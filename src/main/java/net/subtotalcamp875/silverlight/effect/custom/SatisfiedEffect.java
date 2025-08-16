package net.subtotalcamp875.silverlight.effect.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class SatisfiedEffect extends StatusEffect {
    public SatisfiedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isPlayer() && !entity.isSpectator()) {
            World world = entity.getWorld();
            PlayerEntity user = (PlayerEntity) entity;
            int dx = world.getRandom().nextInt(4);
            int dy = world.getRandom().nextInt(4);
            int dz = world.getRandom().nextInt(4);
            int signx = world.getRandom().nextInt(2);
            int signz = world.getRandom().nextInt(2);

            if (signx == 1) {
                dx = -dx;
            }
            if (signz == 1) {
                dz = -dz;
            }

            if (!world.isClient) {
                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.HEART, user.getX()+dx, user.getY()+dy, user.getZ()+dz, 1, 0, 0, 0, 0);
                }
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
