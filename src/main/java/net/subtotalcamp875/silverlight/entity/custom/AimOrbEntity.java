package net.subtotalcamp875.silverlight.entity.custom;

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

public class AimOrbEntity extends ThrownItemEntity {
    public AimOrbEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public AimOrbEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.AIM_ORB_PROJECTILE, livingEntity, world);
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.AIM_ORB;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient) {
            this.discard();
        }
        super.onBlockHit(blockHitResult);
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Aim Orb Entity test");
    }
}
