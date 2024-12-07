package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class BlessedRingItem extends Item {
    public BlessedRingItem(Settings settings) {
        super(settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 40), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 40), user);

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
}
