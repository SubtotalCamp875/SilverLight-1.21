package net.subtotalcamp875.silverlight.item.custom.staffs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightningOrbEntity;

import java.util.Random;

public class ThorsHammer extends AxeItem {
    public ThorsHammer(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 5*20);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WIND_CHARGE_THROW, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            LightningOrbEntity lightningOrbEntity = new LightningOrbEntity(user, world);
            lightningOrbEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2f, 0.0f);
            world.spawnEntity(lightningOrbEntity);
        }

        if (!user.getAbilities().creativeMode) {
            itemStack.setDamage(itemStack.getDamage() + 5);
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                itemStack.decrement(1);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity user = (PlayerEntity) attacker;
        World world = target.getWorld();
        BlockPos blockPos = target.getBlockPos();


        int roll = (int)(Math.random() * 100); // 0 to 99
        int lightningChancePercentage = 33;
        if (roll <= lightningChancePercentage) {
            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPosition(blockPos.toCenterPos());
            world.spawnEntity(lightningEntity);
        }


        return super.postHit(stack, target, attacker);
    }

    
}
