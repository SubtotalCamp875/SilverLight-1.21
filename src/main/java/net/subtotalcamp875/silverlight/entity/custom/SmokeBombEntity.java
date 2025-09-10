package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class SmokeBombEntity extends ThrownItemEntity {

    private int lifeSpan = 5*20;
    private int fuse = 3*20;


    public SmokeBombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public SmokeBombEntity(LivingEntity livingEntity, World world) {
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

                serverWorld.spawnParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, this.getX(), this.getY(), this.getZ(), 50, 1f, 1f, 1f, 0.02);
                lifeSpan--;
                if (lifeSpan <= 0) {
                    this.discard();
                }
            }

        }
        super.tick();
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Smoke Bomb Entity test");
    }
}
