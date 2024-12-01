package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.TomatoEntity;
import net.subtotalcamp875.silverlight.item.ModItems;

public class LeechItem extends Item {
    public LeechItem(Settings settings) {
        super(settings);

    }
    private static int tick = 0;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient && !user.getAbilities().creativeMode) {

                tick++;
                if (tick == 100) {
                    user.setHealth(user.getHealth() - 1f);
                    stack.setDamage(stack.getDamage() + 1);
                    tick = 0;
                }


                if (stack.getDamage() == stack.getMaxDamage()) {
                    stack.decrement(1);
                    user.giveItemStack(ModItems.LONG_LEECH.getDefaultStack());
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
