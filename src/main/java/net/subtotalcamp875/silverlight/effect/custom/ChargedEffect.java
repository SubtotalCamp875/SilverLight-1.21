package net.subtotalcamp875.silverlight.effect.custom;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;

public class ChargedEffect extends StatusEffect {
    public ChargedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    private int tick = 0;
    private int maxTick = 10*20;

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        tick += 1;
        if (tick >= (maxTick/(amplifier+1))) {
            tick = 0;

            BlockPos blockPos = entity.getBlockPos();
            World world = entity.getWorld();

            LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightningEntity.setPosition(blockPos.toCenterPos());
            world.spawnEntity(lightningEntity);
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
