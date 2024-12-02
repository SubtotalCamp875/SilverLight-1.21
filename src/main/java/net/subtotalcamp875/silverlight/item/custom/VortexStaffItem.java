package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightningOrbEntity;
import net.subtotalcamp875.silverlight.entity.custom.VortexEntity;

public class VortexStaffItem extends Item {
    public VortexStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 20);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WITHER_AMBIENT, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            VortexEntity vortexEntity = new VortexEntity(user, world);
            vortexEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.5f, 0.0f);
            world.spawnEntity(vortexEntity);
        }

        if (!user.getAbilities().creativeMode) {
            itemStack.setDamage(itemStack.getDamage() + 1);
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                itemStack.decrement(1);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
