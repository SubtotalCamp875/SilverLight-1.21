package net.subtotalcamp875.silverlight.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.effect.custom.BasicEffect;
import net.subtotalcamp875.silverlight.effect.custom.ArmorlessEffect;
import net.subtotalcamp875.silverlight.effect.custom.HolyShieldStatusEffect;
import net.subtotalcamp875.silverlight.effect.custom.SatisfiedEffect;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SHRINK = registerEffect(
            "shrink", new ArmorlessEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "shrink"),
                    -0.5F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> SHORTEN = registerEffect(
            "shorten", new BasicEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "shorten"),
                            -0.25F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> DWARF = registerEffect(
            "dwarf", new ArmorlessEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "dwarf"),
                            -0.75F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> FAIRY = registerEffect(
            "fairy", new ArmorlessEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "fairy"),
                            -0.99F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> STRONG_FAIRY = registerEffect(
            "strong_fairy", new BasicEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "strong_fairy"),
                            -0.99F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> TALL = registerEffect(
            "tall", new BasicEffect(StatusEffectCategory.NEUTRAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "tall"),
                            0.5F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> ENLARGE = registerEffect(
            "enlarge", new BasicEffect(StatusEffectCategory.NEUTRAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "enlarge"),
                            1F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> GIANT = registerEffect(
            "giant", new BasicEffect(StatusEffectCategory.HARMFUL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_SCALE, Identifier.of(SilverLight.MOD_ID, "giant"),
                            1.5F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> GRAVITY = registerEffect(
            "gravity", new BasicEffect(StatusEffectCategory.HARMFUL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_GRAVITY, Identifier.of(SilverLight.MOD_ID, "gravity"),
                            .72F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> ANTI_GRAVITY = registerEffect(
            "anti_gravity", new BasicEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_GRAVITY, Identifier.of(SilverLight.MOD_ID, "anti_gravity"),
                            -0.06F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> DISPROPORTION = registerEffect(
            "disproportion", new BasicEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, Identifier.of(SilverLight.MOD_ID, "disproportion"),
                            3.5F, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> HAPPY_FEET = registerEffect(
            "happy_feet", new BasicEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_STEP_HEIGHT, Identifier.of(SilverLight.MOD_ID, "happy_feet"),
                            9.4F, EntityAttributeModifier.Operation.ADD_VALUE));


    public static final RegistryEntry<StatusEffect> DRUNK = registerEffect(
            "drunk", new BasicEffect(StatusEffectCategory.HARMFUL, 0));

    public static final RegistryEntry<StatusEffect> HOLY_SHIELD = registerEffect(
            "holy_shield", new HolyShieldStatusEffect(StatusEffectCategory.BENEFICIAL, 2445989)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_ABSORPTION, Identifier.of(SilverLight.MOD_ID, "holy_shield"),
                            12f, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> SAY10S_CURSE = registerEffect(
            "say10s_curse", new BasicEffect(StatusEffectCategory.HARMFUL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, Identifier.of(SilverLight.MOD_ID, "say10s_curse"),
                            -4f, EntityAttributeModifier.Operation.ADD_VALUE));

    public static final RegistryEntry<StatusEffect> SATISFIED = registerEffect(
            "satisfied", new SatisfiedEffect(StatusEffectCategory.BENEFICIAL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(SilverLight.MOD_ID, "satisfied"),
                            -0.015f, EntityAttributeModifier.Operation.ADD_VALUE));


    private static RegistryEntry<StatusEffect> registerEffect(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SilverLight.MOD_ID, id), statusEffect);
    }

    public static void registerModEffects() {
        SilverLight.LOGGER.info("Registering Mod Effects for " + SilverLight.MOD_ID);
    }
}
