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
import net.subtotalcamp875.silverlight.sound.ModSounds;

public class ElmItem extends Item {
    public ElmItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                ModSounds.ELM_FOX_SQUEAK, SoundCategory.NEUTRAL, 1f, 1f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
