package net.subtotalcamp875.silverlight.item.custom.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightningBombEntity;
import net.subtotalcamp875.silverlight.entity.custom.SmokeBombEntity;

public class LightningBombItem extends Item {
    public LightningBombItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        user.getItemCooldownManager().set(this, 20*20);

        if (!world.isClient) {
            LightningBombEntity lightningBombEntity = new LightningBombEntity(user, world);
            lightningBombEntity.setItem(itemStack);
            lightningBombEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0f, 1.5f, 0.1f);
            lightningBombEntity.setPosition(user.getX(), user.getY()+1.5f, user.getZ());
            world.spawnEntity(lightningBombEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
