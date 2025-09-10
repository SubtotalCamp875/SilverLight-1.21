package net.subtotalcamp875.silverlight.item.custom.charms;

import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;

public class XPCharmItem extends Item {
    public XPCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        int isActivated = getIsActivated(itemStack);

        if (!world.isClient) {
            if (isActivated == 0) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            if (isActivated == 0) {
                isActivated = 1;
            } else {
                isActivated = 0;
            }
            itemStack.set(ModDataComponentTypes.ISACTIVATED, isActivated);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        int isActivated = getIsActivated(stack);
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && (isActivated == 1) && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            if (!world.isClient) {
                user.addExperience(1);

                if (!user.getAbilities().creativeMode) {
                    stack.setDamage(stack.getDamage() + 1);
                    if (stack.getDamage() == stack.getMaxDamage()) {
                        stack.decrement(1);
                    }
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private int getIsActivated(ItemStack stack) {
        if (stack.get(ModDataComponentTypes.ISACTIVATED) == null) {
            return 0;
        } else {
            return stack.get(ModDataComponentTypes.ISACTIVATED);
        }
    }
}
