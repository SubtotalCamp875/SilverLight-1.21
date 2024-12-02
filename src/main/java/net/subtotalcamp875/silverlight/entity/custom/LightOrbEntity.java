package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class LightOrbEntity extends ThrownItemEntity {
    public LightOrbEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightOrbEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.LIGHT_ORB_PROJECTILE, livingEntity, world);
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.LIGHT_ORB;
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
        World world = entity.getWorld();
        if (entity instanceof LivingEntity) {
            entityHitResult.getEntity().damage(this.getDamageSources().magic(), 10f);
        }
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.NEUTRAL, 10f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Light Orb Entity test");
    }
}
