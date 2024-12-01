package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.effect.ModEffects;

public class Say10sCharmItem extends Item {
    public Say10sCharmItem(Settings settings) {
        super(settings);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60), user);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
