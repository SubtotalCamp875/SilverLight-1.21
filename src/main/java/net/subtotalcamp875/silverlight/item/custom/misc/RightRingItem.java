package net.subtotalcamp875.silverlight.item.custom.misc;

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
import net.subtotalcamp875.silverlight.effect.ModEffects;
import net.subtotalcamp875.silverlight.item.ModItems;

public class RightRingItem extends Item {
    public RightRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            if (user.getOffHandStack().getItem() == ModItems.LEFT_RING) {
                user.addStatusEffect(new StatusEffectInstance(ModEffects.STRONG_FAIRY, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), user);

                user.giveItemStack(ModItems.BLESSED_RING.getDefaultStack());
                user.getOffHandStack().decrement(1);
                itemStack.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

}
