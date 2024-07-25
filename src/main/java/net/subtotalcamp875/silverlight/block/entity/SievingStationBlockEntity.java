package net.subtotalcamp875.silverlight.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.screen.SievingScreenHandler;
import org.jetbrains.annotations.Nullable;
import java.util.Random;

public class SievingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public SievingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SIEVING_STATION_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> SievingStationBlockEntity.this.progress;
                    case 1 -> SievingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SievingStationBlockEntity.this.progress = value;
                    case 1 -> SievingStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 10;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Sieving Station");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, false, registryLookup);
        nbt.putInt("SievingProgress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("SievingProgress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new SievingScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasInputRecipes()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }

            } else {this.resetProgress();}
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        this.setStack(INPUT_SLOT, new ItemStack(getStack(INPUT_SLOT).getItem(), getStack(INPUT_SLOT).getCount() - 1));
        ItemStack result = getLoot();

        for (int i = 0; i < 9; i++) {
            int slot = i+1;
            if (canInsertItemIntoOutputSlot(result.getItem(), slot) && canInsertAmountIntoOutputSlot(result, slot)) {
                this.setStack(slot, new ItemStack(result.getItem(), getStack(slot).getCount() + result.getCount()));
                break;
            }
        }
    }

    private ItemStack getLoot() {
        Random rand = new Random();
        ItemStack result = new ItemStack(Items.DIRT);

        if (getStack(INPUT_SLOT).getItem() == Items.DIRT) {
            int drop = rand.nextInt(1000);
            if (drop == 0) {result = new ItemStack(Items.MYCELIUM);}
            if (drop >= 1 && drop <= 149) {result = new ItemStack(Items.MOSS_BLOCK);}
            if (drop >= 150 && drop <= 199) {result = new ItemStack(Items.FLINT);}
            if (drop >= 200 && drop <= 299) {result = new ItemStack(Items.COBBLESTONE);}
            if (drop >= 300 && drop <= 499) {result = new ItemStack(Items.BONE_MEAL);}
            if (drop >= 500) {result = new ItemStack(Items.DIRT);}
        }

        return result;
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasInputRecipes() {
        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.DIRT;

        return hasInput;
    }

    private boolean canInsertItemIntoOutputSlot(Item item, int slot) {
        return this.getStack(slot).getItem() == item || this.getStack(slot).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result, int slot) {
        return this.getStack(slot).getCount() + result.getCount() <= getStack(slot).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        for (int i = 0; i < 9; i++) {
            int slot = i+1;
            if (this.getStack(slot).isEmpty() || this.getStack(slot).getCount() < this.getStack(slot).getMaxCount()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new SievingStationData(this.pos);
    }
}
