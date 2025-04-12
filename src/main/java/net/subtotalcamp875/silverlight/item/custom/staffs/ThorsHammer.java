package net.subtotalcamp875.silverlight.item.custom.staffs;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightningOrbEntity;

public class ThorsHammer extends SwordItem {
    public ThorsHammer(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 100);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WIND_CHARGE_THROW, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            LightningOrbEntity lightningOrbEntity = new LightningOrbEntity(user, world);
            lightningOrbEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2f, 0.0f);
            world.spawnEntity(lightningOrbEntity);
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
