package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class ExplosionRainOrbEntity extends ThrownItemEntity {

    private final int rainInterval = 10;
    private int rainIntervalTick = rainInterval;
    private int lifeSpan = 100;

    public ExplosionRainOrbEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplosionRainOrbEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.EXPLOSION_RAIN_ORB_PROJECTILE, livingEntity, world);
        this.setNoGravity(true);
        this.setGlowing(true);

    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.EXPLOSION_RAIN_ORB;
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos blockPos = this.getBlockPos();
        if (!this.getWorld().isClient) {
            lifeSpan--;
            if (lifeSpan <= 0) {
                this.discard();
            }

            rainIntervalTick--;
            if (rainIntervalTick <= 0) {
                TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
                tntEntity.setPosition(blockPos.toCenterPos());
                world.spawnEntity(tntEntity);
                rainIntervalTick = rainInterval;
            }
        }

        super.tick();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Explosion Rain Orb Entity test");
    }
}
