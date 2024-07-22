package net.subtotalcamp875.silverlight.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DRAGON_OMELET = new FoodComponent.Builder().nutrition(8).saturationModifier(0.9f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.5f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_NAUSEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200), 1f).alwaysEdible().build();
    public static final FoodComponent POTENT_POTION_OF_NAUSEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 72000), 1f).alwaysEdible().build();
}
