package net.subtotalcamp875.silverlight.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.custom.DragonProcessingStationBlock;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.screen.DragonProcessingScreenHandler;
import org.jetbrains.annotations.Nullable;

public class DragonProcessingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int TOOL_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int tick = 0;
    private int maxTick = 50;

    public DragonProcessingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRAGON_PROCESSING_STATION_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> DragonProcessingStationBlockEntity.this.progress;
                    case 1 -> DragonProcessingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> DragonProcessingStationBlockEntity.this.progress = value;
                    case 1 -> DragonProcessingStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Dragon Processing Station");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, false, registryLookup);
        nbt.putInt("runicForgeProgress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, false, registryLookup);
        progress = nbt.getInt("runicForgeProgress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DragonProcessingScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasRecipe()) {

                if (!this.hasBlackEggRecipe()) {
                    this.increaseCraftProgress();
                    this.progressMultiplier();
                    markDirty(world, pos, state);
                } else {
                    if (this.tickReached()) {
                        this.increaseCraftProgress();
                        this.progressMultiplier();
                        this.resetTick();
                    } else {
                        this.increaseTick();
                    }
                    markDirty(world, pos, state);
                    }

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }

            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void progressMultiplier() {
        SilverLight.LOGGER.info("test1");
        SilverLight.LOGGER.info(String.valueOf(this.hasBurningRecipe()));
        SilverLight.LOGGER.info(String.valueOf(this.hasVoidRecipe()));
        if (this.hasBurningRecipe()) {
            SilverLight.LOGGER.info("test2");
            this.increaseCraftProgress();
        } else if (this.hasVoidRecipe()) {
            SilverLight.LOGGER.info("test3");
            this.increaseCraftProgress();
            this.increaseCraftProgress();
            this.increaseCraftProgress();
            this.increaseCraftProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void resetTick() {
        this.tick = 0;
    }

    private void increaseTick() {
        this.tick++;
    }

    private boolean tickReached() {
        return tick >= maxTick;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(ModItems.DRAGON_SCRAP);

        this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result = new ItemStack(ModItems.DRAGON_SCRAP);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.DRAGON_EGG || getStack(INPUT_SLOT).getItem() == ModItems.BLACK_EGG;
        boolean hasTool =
                getStack(TOOL_SLOT).getItem() == ModItems.OBSIDIAN_SHEARS ||
                getStack(TOOL_SLOT).getItem() == ModItems.BURNING_OBSIDIAN_SHEARS ||
                getStack(TOOL_SLOT).getItem() == ModItems.VOID_OBSIDIAN_SHEARS;

        return hasInput && canInsertAmountIntoOutputSlot(result) && canInsertItemIntoOutputSlot(result.getItem()) && hasTool;
    }

    private boolean hasBurningRecipe() {
        boolean hasTool = getStack(TOOL_SLOT).getItem() == ModItems.BURNING_OBSIDIAN_SHEARS;

        return hasTool;
    }

    private boolean hasVoidRecipe() {
        boolean hasTool = getStack(TOOL_SLOT).getItem() == ModItems.VOID_OBSIDIAN_SHEARS;

        return hasTool;
    }

    private boolean hasBlackEggRecipe() {
        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.BLACK_EGG;

        return hasInput;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new DragonProcessingStationData(this.pos);
    }
}