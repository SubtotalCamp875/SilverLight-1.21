package net.subtotalcamp875.silverlight.item.custom.leeches;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class LongLeechItem extends Item {
    public LongLeechItem(Settings settings) {
        super(settings);

    }
    private int tick = 0;

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient && !user.getAbilities().creativeMode) {

                tick++;
                if (tick == 20) {
                    user.damage(world.getDamageSources().magic(), 1f);
                    stack.setDamage(stack.getDamage() + 1);
                    tick = 0;
                }


                if (stack.getDamage() == stack.getMaxDamage()) {
                    stack.decrement(1);
                    user.giveItemStack(ModItems.STRONG_LEECH.getDefaultStack());
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_HORSE_EAT, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            if (user.getOffHandStack().getItem() == ModItems.CRACKER) {
                user.getOffHandStack().decrement(1);
                user.giveItemStack(ModItems.COSMIC_BROWNIE.getDefaultStack());
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
