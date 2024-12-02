package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class VortexEntity extends ThrownItemEntity {
    public VortexEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public VortexEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.VORTEX_PROJECTILE, livingEntity, world);
        this.setNoGravity(true);
        this.setGlowing(true);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.VORTEX;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).setHealth(0);
        }

    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        player.setHealth(0);
        super.onPlayerCollision(player);
    }


    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Vortex Entity test");
    }
}
