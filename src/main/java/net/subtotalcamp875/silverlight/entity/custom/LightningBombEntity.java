package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;
import org.apache.logging.log4j.core.jmx.Server;

public class LightningBombEntity extends ThrownItemEntity {

    private int lifeSpan = 7*20;
    private int fuse = 3*20;


    public LightningBombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningBombEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.SMOKE_BOMB_PROJECTILE, livingEntity, world);
        this.setGlowing(false);
        this.setNoGravity(false);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SMOKE_BOMB;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
             this.setVelocity(0f, 0f, 0f);
             this.setNoGravity(true);
             this.setGlowing(true);
        }
        super.onBlockHit(blockHitResult);
    }

    @Override
    public void tick() {
        if (this.getWorld() instanceof ServerWorld serverWorld) {

            fuse--;
            if (fuse <= 0) {
                fuse = 0;

                lifeSpan--;
                if (lifeSpan%20 == 0) {
                    summonLightning();
                }
                if (lifeSpan <= 0) {
                    this.discard();
                }
            }

        }
        super.tick();
    }

    private void summonLightning() {
        BlockPos blockPos = this.getBlockPos();
        World world = this.getWorld();
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ParticleTypes.ELECTRIC_SPARK, this.getX(), this.getY(), this.getZ(), 300, 5f, 5f, 5f, 0.2);
        }


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
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Smoke Bomb Entity test");
    }
}
