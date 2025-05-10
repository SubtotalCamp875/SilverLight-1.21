package net.subtotalcamp875.silverlight.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.block.entity.ImplementedInventory;
import net.subtotalcamp875.silverlight.block.entity.ModBlockEntities;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.screen.custom.EnergyGeneratorScreenHandler;
import org.jetbrains.annotations.Nullable;

public class EnergyGeneratorBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int chargeAmountTotal = 0;
    private int maxProgress = 20*32*6; //time in ticks
    private int maxCharge = 64*6*9;

    public EnergyGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENERGY_GENERATOR_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> EnergyGeneratorBlockEntity.this.progress;
                    case 1 -> EnergyGeneratorBlockEntity.this.maxProgress;
                    case 2 -> EnergyGeneratorBlockEntity.this.chargeAmountTotal;
                    case 3 -> EnergyGeneratorBlockEntity.this.maxCharge;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> EnergyGeneratorBlockEntity.this.progress = value;
                    case 1 -> EnergyGeneratorBlockEntity.this.maxProgress = value;
                    case 2 -> EnergyGeneratorBlockEntity.this.chargeAmountTotal = value;
                    case 3 -> EnergyGeneratorBlockEntity.this.maxCharge = value;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("EnergyGenerating", progress);
        nbt.putInt("EnergyGeneratingCharge", chargeAmountTotal);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("EnergyGenerating");
        chargeAmountTotal = nbt.getInt("EnergyGeneratingCharge");
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(hasRecipe()) {
            fuelGenerator();
        }
        if(hasPowerAndCanInsert()) {
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        ItemStack output = new ItemStack(ModItems.ENERGY_CRYSTAL, 1);

        this.chargeAmountTotal -= 32*6;
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void fuelGenerator() {
        int remainingSpace = this.maxCharge - this.chargeAmountTotal;
        int growth = getStack(INPUT_SLOT).getCount();
        if (getStack(INPUT_SLOT).getCount() > remainingSpace) {
            growth = remainingSpace;
        }

        this.setStack(INPUT_SLOT, new ItemStack(getStack(INPUT_SLOT).getItem(), getStack(INPUT_SLOT).getCount() - growth));
        this.chargeAmountTotal += growth;
    }


    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        return this.getStack(INPUT_SLOT).getItem() != Items.AIR && this.chargeAmountTotal < this.maxCharge && this.getStack(INPUT_SLOT).getItem().getMaxCount() > 1;
    }

    private boolean hasPowerAndCanInsert() {
        ItemStack output = new ItemStack(ModItems.ENERGY_CRYSTAL, 1);

        return this.chargeAmountTotal >= 32 &&
                canInsertAmountIntoOutputSlot(output) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return new EnergyGeneratorData(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Energy Generator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new EnergyGeneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
