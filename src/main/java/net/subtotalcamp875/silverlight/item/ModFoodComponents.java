package net.subtotalcamp875.silverlight.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.subtotalcamp875.silverlight.effect.ModEffects;

public class ModFoodComponents {
    public static final FoodComponent DRAGON_OMELET = new FoodComponent.Builder().nutrition(8).saturationModifier(0.9f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 0.5f).alwaysEdible().build();

    public static final FoodComponent POTION_OF_NAUSEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200), 1f).alwaysEdible().build();
    public static final FoodComponent POTENT_POTION_OF_NAUSEA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 72000), 1f)
            .nutrition(4)
            .saturationModifier(2)
            .alwaysEdible().build();

    public static final FoodComponent POTION_OF_SHRINK = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.SHRINK, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_DWARF = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.DWARF, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_SHORTEN = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.SHORTEN, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_FAIRY = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.FAIRY, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_TALL = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.TALL, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_ENLARGE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.ENLARGE, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_GIANT = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 72000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 72000), 1f)
            .statusEffect(new StatusEffectInstance(ModEffects.GIANT, 72000), 1f).alwaysEdible().build();

    public static final FoodComponent POTION_OF_GRAVITY = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.GRAVITY, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_ANTI_GRAVITY = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.ANTI_GRAVITY, 72000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_DISPROPORTION = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.DISPROPORTION, 36000), 1f).alwaysEdible().build();
    public static final FoodComponent POTION_OF_HAPPY_FEET = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.HAPPY_FEET, 36000), 1f).alwaysEdible().build();

    public static final FoodComponent CRACKER = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 12000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 12000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 12000), 1f)
            .nutrition(1)
            .saturationModifier(20)
            .snack()
            .build();
}
