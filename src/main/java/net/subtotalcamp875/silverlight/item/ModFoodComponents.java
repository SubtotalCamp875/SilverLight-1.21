package net.subtotalcamp875.silverlight.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DRAGON_OMLET = new FoodComponent.Builder().nutrition(6).saturationModifier(15)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.5f).build();
}
