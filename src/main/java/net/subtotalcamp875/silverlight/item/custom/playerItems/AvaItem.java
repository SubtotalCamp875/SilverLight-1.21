package net.subtotalcamp875.silverlight.item.custom.playerItems;

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

public class AvaItem extends Item {
    public AvaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200), user);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), user);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200), user);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200), user);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200), user);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200), user);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
