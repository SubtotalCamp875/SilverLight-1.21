package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.effect.ModEffects;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class LightningOrbEntity extends ThrownItemEntity {

    private int lifeSpan = 400;

    public LightningOrbEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);

    }

    public LightningOrbEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.LIGHTNING_ORB_PROJECTILE, livingEntity, world);
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.LIGHTNING_ORB;
    }

    @Override
    public void tick() {
        lifeSpan--;
        if (lifeSpan <= 0) {
            this.discard();
        }
        super.tick();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
            BlockPos blockPos = blockHitResult.getBlockPos();
            World world = this.getWorld();


            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPosition(blockPos.toCenterPos());
            world.spawnEntity(lightningEntity);

            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient) {
            BlockPos blockPos = BlockPos.ofFloored(entityHitResult.getPos());
            LivingEntity livingEntity = (LivingEntity) entityHitResult.getEntity();
            World world = this.getWorld();

            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPosition(blockPos.toCenterPos());
            world.spawnEntity(lightningEntity);

            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.CHARGED, 60*20), livingEntity);

            this.discard();
        }

        super.onEntityHit(entityHitResult);
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Lightning Orb Entity test");
    }
}
