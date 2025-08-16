package net.subtotalcamp875.silverlight.item.custom.misc;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.effect.ModEffects;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipData;
import net.subtotalcamp875.silverlight.screen.custom.BackpackScreenHandler;

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

    private int tick = 0;

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
/**
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        PlayerEntity playerEntity = (PlayerEntity) entity;
        PlayerInventory playerInventory = playerEntity.getInventory();

        if (!world.isClient) {

            tick += 1;
            if (tick >= 20) {
                tick = 0;

                if (!playerEntity.isCreative()) {
                    int count = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (playerInventory.getStack(j + i * 9 + 9).toString().equals(ModItems.BACKPACK.getDefaultStack().toString())) {
                                count += 1;
                            }
                        }
                    }

                    for (int i = 0; i < 9; i++) {
                        if (playerInventory.getStack(i).toString().equals(ModItems.BACKPACK.getDefaultStack().toString())) {
                            count += 1;
                        }
                    }

                    if (count > 1 || playerEntity.getOffHandStack().toString().equals(ModItems.BACKPACK.getDefaultStack().toString())) {
                        playerEntity.addStatusEffect(new StatusEffectInstance(ModEffects.ENCUMBERED, 30*20, 3), playerEntity);
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
**/
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
