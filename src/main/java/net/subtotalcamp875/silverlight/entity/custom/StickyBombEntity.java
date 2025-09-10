package net.subtotalcamp875.silverlight.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;

public class StickyBombEntity extends ThrownItemEntity {

    private int fuse = 5*20;


    public StickyBombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public StickyBombEntity(LivingEntity livingEntity, World world) {
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
        World world = this.getWorld();
        BlockPos blockPos = this.getBlockPos();

        if (this.getWorld() instanceof ServerWorld serverWorld) {
            fuse--;

            if (fuse == 3*20) {
                serverWorld.spawnParticles(ParticleTypes.ANGRY_VILLAGER, this.getX(), this.getY(), this.getZ(), 10, 0.5f, 2f, 0.5f, 0.1);
                world.playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BANJO, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else if (fuse == 2*20) {
                serverWorld.spawnParticles(ParticleTypes.ANGRY_VILLAGER, this.getX(), this.getY(), this.getZ(), 10, 0.5f, 2f, 0.5f, 0.1);
                world.playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BANJO, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else if (fuse == 20) {
                serverWorld.spawnParticles(ParticleTypes.ANGRY_VILLAGER, this.getX(), this.getY(), this.getZ(), 10, 0.5f, 2f, 0.5f, 0.1);
                world.playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BANJO, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            } else if (fuse <= 0) {
                this.setVelocity(0f, 0f, 0f);
                this.setNoGravity(true);

                TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
                tntEntity.setPosition(blockPos.toCenterPos());
                tntEntity.setFuse(1);
                world.spawnEntity(tntEntity);

                this.discard();
            }
        }
        super.tick();
    }

    public void test(PlayerEntity livingEntity) {
        livingEntity.addCommandTag("Silverlight Smoke Bomb Entity test");
    }
}
