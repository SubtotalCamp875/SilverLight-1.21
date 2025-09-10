package net.subtotalcamp875.silverlight.item.custom.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.effect.ModEffects;

public class BlessingOfCreation extends Item {
    public BlessingOfCreation(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean isActivated = getIsActivated(itemStack);

        if (!world.isClient) {
            if (!isActivated) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }

            isActivated = !isActivated;
            itemStack.set(ModDataComponentTypes.ISACTIVATED, isActivated);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        boolean isActivated = getIsActivated(stack);
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && (isActivated) && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            if (!world.isClient && user != null) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60, 2), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 60, 1), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 2), user);
                user.addStatusEffect(new StatusEffectInstance(ModEffects.DISPROPORTION, 60, 1), user);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean getIsActivated(ItemStack stack) {
        if (stack.get(ModDataComponentTypes.ISACTIVATED) == null) {
            return false;
        } else {
            return stack.get(ModDataComponentTypes.ISACTIVATED);
        }
    }
}
