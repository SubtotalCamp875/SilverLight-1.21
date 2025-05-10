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
import net.subtotalcamp875.silverlight.block.entity.custom.ChargeGeneratorBlockEntity;
import net.subtotalcamp875.silverlight.block.entity.custom.ChargeGeneratorData;
import net.subtotalcamp875.silverlight.block.entity.custom.EnergyGeneratorBlockEntity;
import net.subtotalcamp875.silverlight.block.entity.custom.EnergyGeneratorData;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlers;

public class EnergyGeneratorScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final EnergyGeneratorBlockEntity blockEntity;

    public EnergyGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, EnergyGeneratorData data) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(data.pos()),
                new ArrayPropertyDelegate(4));
    }

    public EnergyGeneratorScreenHandler(int syncId, PlayerInventory playerInventory,
                                        BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.ENERGY_GENERATOR_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 2);
        this.inventory = ((Inventory) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((EnergyGeneratorBlockEntity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 44, 60));
        this.addSlot(new Slot(inventory, 1, 17, 60));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1); // Max Progress
        int arrowPixelSize = 17; // This is the height in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public int getScaledCharge1() {
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2);
        if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge2() {
        int count = 2;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge3() {
        int count = 3;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge4() {
        int count = 4;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge5() {
        int count = 5;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge6() {
        int count = 6;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge7() {
        int count = 7;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge8() {
        int count = 8;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
    }

    public int getScaledCharge9() {
        int count = 9;
        int maxCharge = 64*6; // Max Progress
        int chargeAmountTotal = this.propertyDelegate.get(2)-((count - 1) * maxCharge);
        if (chargeAmountTotal < 0) {
            chargeAmountTotal = 0;
        } else if (chargeAmountTotal > maxCharge) {
            chargeAmountTotal = maxCharge;
        }
        int arrowPixelSize = 67; // This is the height in pixels of your arrow

        return maxCharge != 0 && chargeAmountTotal != 0 ? chargeAmountTotal * arrowPixelSize / maxCharge : 0;
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
