package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
            LightningEntity lightningEntity1 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity2 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity3 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity4 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity5 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity6 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity7 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity8 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity9 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity10 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity11 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity12 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity13 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity14 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity15 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity16 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity17 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity18 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            LightningEntity lightningEntity19 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPosition(blockPos.toCenterPos());
            lightningEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity8.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity9.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity10.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity11.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity12.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity13.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity14.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity15.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity16.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity17.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity18.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            lightningEntity19.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
            world.spawnEntity(lightningEntity);
            world.spawnEntity(lightningEntity1);
            world.spawnEntity(lightningEntity2);
            world.spawnEntity(lightningEntity3);
            world.spawnEntity(lightningEntity4);
            world.spawnEntity(lightningEntity5);
            world.spawnEntity(lightningEntity6);
            world.spawnEntity(lightningEntity7);
            world.spawnEntity(lightningEntity8);
            world.spawnEntity(lightningEntity9);
            world.spawnEntity(lightningEntity10);
            world.spawnEntity(lightningEntity11);
            world.spawnEntity(lightningEntity12);
            world.spawnEntity(lightningEntity13);
            world.spawnEntity(lightningEntity14);
            world.spawnEntity(lightningEntity15);
            world.spawnEntity(lightningEntity16);
            world.spawnEntity(lightningEntity17);
            world.spawnEntity(lightningEntity18);
            world.spawnEntity(lightningEntity19);

            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Lightning Orb Entity test");
    }
}
