package net.subtotalcamp875.silverlight.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.entity.custom.DeathsBombEntity;
import net.subtotalcamp875.silverlight.entity.custom.LightningOrbEntity;
import net.subtotalcamp875.silverlight.entity.custom.TomatoEntity;
import net.subtotalcamp875.silverlight.entity.custom.VortexEntity;

public class ModEntities {
    public static final EntityType<TomatoEntity> TOMATO_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SilverLight.MOD_ID, "tomato_projectile"),
            EntityType.Builder.<TomatoEntity>create(TomatoEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build());

    public static final EntityType<DeathsBombEntity> DEATHS_BOMB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SilverLight.MOD_ID, "deaths_bomb_projectile"),
            EntityType.Builder.<DeathsBombEntity>create(DeathsBombEntity::new, SpawnGroup.MISC)
                    .dimensions(0.3f, 0.3f).build());

    public static final EntityType<LightningOrbEntity> LIGHTNING_ORB_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SilverLight.MOD_ID, "lightning_orb_projectile"),
            EntityType.Builder.<LightningOrbEntity>create(LightningOrbEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());

    public static final EntityType<VortexEntity> VORTEX_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SilverLight.MOD_ID, "vortex_projectile"),
            EntityType.Builder.<VortexEntity>create(VortexEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());

    public static void registerModEntities() {
        SilverLight.LOGGER.info("Registering Entities for " + SilverLight.MOD_ID);
    }
}
