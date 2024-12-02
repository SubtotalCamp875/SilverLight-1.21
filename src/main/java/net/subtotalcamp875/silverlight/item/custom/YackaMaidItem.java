package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class YackaMaidItem extends Item {
    public YackaMaidItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //user.getItemCooldownManager().set(this, 1728000);
        user.getItemCooldownManager().set(this, 5);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_PURREOW, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_PURR, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
