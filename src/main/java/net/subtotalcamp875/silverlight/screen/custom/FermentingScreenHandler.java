package net.subtotalcamp875.silverlight.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.subtotalcamp875.silverlight.block.entity.custom.FermentingStationBlockEntity;
import net.subtotalcamp875.silverlight.block.entity.custom.FermentingStationData;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlers;

public class FermentingScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final FermentingStationBlockEntity blockEntity;

    public FermentingScreenHandler(int syncId, PlayerInventory inventory, FermentingStationData data) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(data.pos()),
                new ArrayPropertyDelegate(8));
    }

    public FermentingScreenHandler(int syncId, PlayerInventory playerInventory,
                                   BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.FERMENTING_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 5);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((FermentingStationBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 80, 11));
        this.addSlot(new Slot(inventory, 1, 80, 59));
        this.addSlot(new Slot(inventory, 2, 44, 11));
        this.addSlot(new Slot(inventory, 3, 44, 29));
        this.addSlot(new Slot(inventory, 4, 44, 47));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);  // Max Progress
        int progressArrowSize = 26; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledTickProgress() {
        int tickProgress = this.propertyDelegate.get(2);
        int maxTickProgress = this.propertyDelegate.get(3);  // Max Progress
        int progressArrowSize = 64; // This is the height in pixels of your arrow

        return maxTickProgress != 0 && tickProgress != 0 ? tickProgress * progressArrowSize / maxTickProgress : 0;
    }

    public int getScaledSecondsProgress() {
        int secondsProgress = this.propertyDelegate.get(4);
        int maxSecondsProgress = this.propertyDelegate.get(5);  // Max Progress
        int progressArrowSize = 64; // This is the height in pixels of your arrow

        return maxSecondsProgress != 0 && secondsProgress != 0 ? secondsProgress * progressArrowSize / maxSecondsProgress : 0;
    }

    public int getScaledMinuteProgress() {
        int minuteProgress = this.propertyDelegate.get(6);
        int maxMinuteProgress = this.propertyDelegate.get(7);  // Max Progress
        int progressArrowSize = 64; // This is the height in pixels of your arrow

        return maxMinuteProgress != 0 && minuteProgress != 0 ? minuteProgress * progressArrowSize / maxMinuteProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}