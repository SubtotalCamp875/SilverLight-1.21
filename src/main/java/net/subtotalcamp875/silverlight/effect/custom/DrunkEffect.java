package net.subtotalcamp875.silverlight.effect.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Collections;

public class DrunkEffect extends StatusEffect {
    public DrunkEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    private int tick = 0;
    private int maxTick = 30*20;

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        tick += 1;
        if (tick >= maxTick) {
            tick = 0;

            PlayerEntity playerEntity = (PlayerEntity) entity;
            Collections.shuffle(playerEntity.getInventory().main);
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
