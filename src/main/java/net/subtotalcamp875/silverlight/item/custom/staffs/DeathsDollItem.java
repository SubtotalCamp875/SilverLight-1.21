package net.subtotalcamp875.silverlight.item.custom.staffs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeathsDollItem extends Item {
    public DeathsDollItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity user = (PlayerEntity) attacker;
        user.getItemCooldownManager().set(this, 1200);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 600), attacker);
        World world = target.getWorld();
        BlockPos blockPos = target.getBlockPos();

        SkeletonEntity skeletonEntity = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity1 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity2 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity3 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity4 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity5 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity6 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity7 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity8 = new SkeletonEntity(EntityType.SKELETON, world);
        SkeletonEntity skeletonEntity9 = new SkeletonEntity(EntityType.SKELETON, world);
        skeletonEntity.setPosition(blockPos.toCenterPos());
        skeletonEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity8.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        skeletonEntity9.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
        world.spawnEntity(skeletonEntity);
        world.spawnEntity(skeletonEntity1);
        world.spawnEntity(skeletonEntity2);
        world.spawnEntity(skeletonEntity3);
        world.spawnEntity(skeletonEntity4);
        world.spawnEntity(skeletonEntity5);
        world.spawnEntity(skeletonEntity6);
        world.spawnEntity(skeletonEntity7);
        world.spawnEntity(skeletonEntity8);
        world.spawnEntity(skeletonEntity9);

        stack.setDamage(stack.getDamage() + 1);
        if (stack.getDamage() == stack.getMaxDamage()) {
            stack.decrement(1);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        super.postDamageEntity(stack, target, attacker);
    }
}
