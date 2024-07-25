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
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.screen.FermentingScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FermentingStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int FERMENTING_SLOT_1 = 2;
    private static final int FERMENTING_SLOT_2 = 3;
    private static final int FERMENTING_SLOT_3 = 4;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int tickProgress = 0;
    private int secondsProgress = 0;
    private int minuteProgress = 0;
    private int maxProgress = 36000;
    private int maxTickProgress = 20;
    private int maxSecondsProgress = 60;
    private int maxMinuteProgress = 30;

    public FermentingStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FERMENTING_STATION_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FermentingStationBlockEntity.this.progress;
                    case 1 -> FermentingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FermentingStationBlockEntity.this.progress = value;
                    case 1 -> FermentingStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 5;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Fermenting Progress: " + progress + "/" + maxProgress);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, false, registryLookup);
        nbt.putInt("FermentingProgress", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("FermentingProgress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FermentingScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {

            if(this.hasInputRecipes() && this.hasFermentingRecipes()) {
                this.increaseCraftProgress();
                this.increaseTickProgress();

                if (tickProgressFinished()) {
                    this.resetTickProgress();
                    this.increaseSecondsProgress();
                }
                if (secondPrograssFinished()) {
                    this.resetSecondProgress();
                    this.increaseMinuteProgress();
                }

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
        this.tickProgress = 0;
        this.secondsProgress = 0;
        this.minuteProgress = 0;
    }

    private void resetTickProgress() {
        this.tickProgress = 0;
    }

    private void resetSecondProgress() {
        this.secondsProgress = 0;
    }

    private void craftItem() {
        ItemStack result = getLoot();

        if (canInsertItemIntoOutputSlot(result.getItem()) && canInsertAmountIntoOutputSlot(result)) {
            this.setStack(OUTPUT_SLOT, new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
        }

        this.setStack(INPUT_SLOT, new ItemStack(getStack(INPUT_SLOT).getItem(), getStack(INPUT_SLOT).getCount() - 1));
        this.setStack(FERMENTING_SLOT_1, new ItemStack(getStack(FERMENTING_SLOT_1).getItem(), getStack(FERMENTING_SLOT_1).getCount() - 1));
        this.setStack(FERMENTING_SLOT_2, new ItemStack(getStack(FERMENTING_SLOT_2).getItem(), getStack(FERMENTING_SLOT_2).getCount() - 1));
        this.setStack(FERMENTING_SLOT_3, new ItemStack(getStack(FERMENTING_SLOT_3).getItem(), getStack(FERMENTING_SLOT_3).getCount() - 1));
    }

    private ItemStack getLoot() {
        Random rand = new Random();
        ItemStack result = new ItemStack(Items.DIRT);
        int chance = chanceIncrease();
        int drop = rand.nextInt(100);

        if (getStack(INPUT_SLOT).getItem() == Items.POTION && drop <= chance) {
            result = new ItemStack(ModItems.POTION_OF_NAUSEA);
        } else if (getStack(INPUT_SLOT).getItem() == Items.POTION && drop > chance) {
            result = getStack(INPUT_SLOT);
        } else if (getStack(INPUT_SLOT).getItem() == ModItems.POTION_OF_NAUSEA && drop <= chance) {
            result = new ItemStack(ModItems.POTENT_POTION_OF_NAUSEA);
        } else if (getStack(INPUT_SLOT).getItem() == ModItems.POTION_OF_NAUSEA && drop > chance) {
            result = getStack(INPUT_SLOT);
        }

        return result;
    }

    private int chanceIncrease() {
        int chance = 0;
        for (int i = 0; i < 3; i++) {
            int slot = i+2;

            if (getStack(slot).getItem() == ModItems.POTION_OF_NAUSEA && getStack(slot).getItem() == ModItems.POTION_OF_NAUSEA) {
                chance += 25;
            }

            if (getStack(slot).getItem() == Items.MYCELIUM && getStack(slot).getItem() == Items.POTION) {
                chance += 25;
            }
        }

        return chance;
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private boolean tickProgressFinished() {
        return tickProgress >= maxTickProgress;
    }

    private boolean secondPrograssFinished() {
        return secondsProgress >= maxSecondsProgress;
    }


    private void increaseCraftProgress() {
        progress++;
    }

    private void increaseTickProgress() {
        tickProgress++;
    }

    private void increaseSecondsProgress() {
        secondsProgress++;
    }

    private void increaseMinuteProgress() {
        minuteProgress++;
    }

    private boolean hasInputRecipes() {
        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.POTION
                || getStack(INPUT_SLOT).getItem() == ModItems.POTION_OF_NAUSEA;

        return hasInput;
    }

    private boolean hasFermentingRecipes() {
        boolean hasInput =
                getStack(FERMENTING_SLOT_1).getItem() == Items.MYCELIUM
                || getStack(FERMENTING_SLOT_2).getItem() == Items.MYCELIUM
                || getStack(FERMENTING_SLOT_3).getItem() == Items.MYCELIUM

                || getStack(FERMENTING_SLOT_1).getItem() == ModItems.POTION_OF_NAUSEA
                || getStack(FERMENTING_SLOT_2).getItem() == ModItems.POTION_OF_NAUSEA
                || getStack(FERMENTING_SLOT_3).getItem() == ModItems.POTION_OF_NAUSEA;

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
        return new FermentingStationData(this.pos);
    }
}