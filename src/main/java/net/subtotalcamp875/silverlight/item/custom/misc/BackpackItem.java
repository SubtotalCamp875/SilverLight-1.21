package net.subtotalcamp875.silverlight.item.custom.misc;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipData;
import net.subtotalcamp875.silverlight.screen.BackpackScreenHandler;

import java.util.Optional;

public class BackpackItem extends Item {

    public BackpackItem(Settings settings) {
        super(settings);
    }

    private static ExtendedScreenHandlerFactory<ItemStack> createExtendedScreenHandlerFactory(ItemStack backpackStack) {
        return new ExtendedScreenHandlerFactory<>() {
            @Override
            public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                return new BackpackScreenHandler(syncId, playerInventory, backpackStack);
            }

            @Override
            public Text getDisplayName() {
                return backpackStack.getName();
            }

            @Override
            public ItemStack getScreenOpeningData(ServerPlayerEntity player) {
                return backpackStack;
            }
        };
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stackInHand = user.getStackInHand(hand);
        user.openHandledScreen(createExtendedScreenHandlerFactory(stackInHand));
        return TypedActionResult.success(stackInHand);
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (player.currentScreenHandler instanceof BackpackScreenHandler backpackScreenHandler &&
                backpackScreenHandler.backpackStack == stack) return true;
        if (clickType != ClickType.RIGHT) return false;
        if (!player.getWorld().isClient()) {
            player.currentScreenHandler.setCursorStack(ItemStack.EMPTY);
            player.openHandledScreen(createExtendedScreenHandlerFactory(stack));
            player.currentScreenHandler.setCursorStack(otherStack);
            player.currentScreenHandler.syncState();
        }
        return true;
    }

    @Override
    public boolean canBeNested() {
        return false;
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        if (stack.contains(DataComponentTypes.HIDE_TOOLTIP) || stack.contains(DataComponentTypes.HIDE_ADDITIONAL_TOOLTIP)) return Optional.empty();
        return Optional.ofNullable(stack.get(ModDataComponentTypes.BACKPACK_CONTENTS)).map(BackpackTooltipData::new);
    }
}
