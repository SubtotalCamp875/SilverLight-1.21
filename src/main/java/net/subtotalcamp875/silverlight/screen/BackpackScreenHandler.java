package net.subtotalcamp875.silverlight.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;

public class BackpackScreenHandler extends ScreenHandler {

    private static final int BACKPACK_START = 0;
    private static final int BACKPACK_END = 54;
    private static final int INVENTORY_START = 54;
    private static final int INVENTORY_END = 81;
    private static final int HOTBAR_START = 81;
    private static final int HOTBAR_END = 90;

    private final SimpleInventory inventory;
    public final ItemStack backpackStack;

    public BackpackScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack backpackStack) {
        super(ModScreenHandlerTypes.BACKPACK, syncId);
        this.backpackStack = backpackStack;
        BackpackContentsComponent backpackContentsComponent = backpackStack.getOrDefault(ModDataComponentTypes.BACKPACK_CONTENTS,
                new BackpackContentsComponent());
        this.inventory = new SimpleInventory(backpackContentsComponent.stacks.toArray(ItemStack[]::new));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(this.inventory, j + i * 9, 8 + j * 18, 18 + i * 18) {
                    @Override
                    public boolean canInsert(ItemStack stack) {
                        return stack.getItem().canBeNested();
                    }
                });
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 198));
        }
        inventory.onOpen(playerInventory.player);
        inventory.addListener(sender -> {
            if (this.inventory.isEmpty()) {
                this.backpackStack.remove(ModDataComponentTypes.BACKPACK_CONTENTS);
            } else {
                this.backpackStack.set(ModDataComponentTypes.BACKPACK_CONTENTS, new BackpackContentsComponent(this.inventory.heldStacks));
            }
            playerInventory.markDirty();
            this.syncState();
        });
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot.hasStack()) {
            ItemStack stackInSlot = slot.getStack();
            originalStack = stackInSlot.copy();
            if (slotIndex >= BACKPACK_START && slotIndex < BACKPACK_END) {
                if (!this.insertItem(stackInSlot, INVENTORY_START, HOTBAR_END, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(stackInSlot, BACKPACK_START, BACKPACK_END, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

        }

        return originalStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return player.getInventory().contains(stack -> stack == this.backpackStack);
    }
}
