package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class StrongLeechItem extends Item {
    public StrongLeechItem(Settings settings) {
        super(settings);

    }
    private int tick = 0;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity.isPlayer()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient && !user.getAbilities().creativeMode) {

                tick++;
                if (tick == 20) {
                    user.setHealth(user.getHealth() - 1f);
                    stack.setDamage(stack.getDamage() + 1);
                    tick = 0;
                }


                if (stack.getDamage() == stack.getMaxDamage()) {
                    stack.decrement(1);
                    user.giveItemStack(ModItems.BLACK_HOLE.getDefaultStack());
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
