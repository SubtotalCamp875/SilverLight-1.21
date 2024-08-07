package net.subtotalcamp875.silverlight.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.entity.custom.TomatoEntity;

public class ModEntities {
    public static final EntityType<TomatoEntity> TOMATO_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SilverLight.MOD_ID, "tomato_projectile"),
            EntityType.Builder.<TomatoEntity>create(TomatoEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build());

    public static void registerModEntities() {
        SilverLight.LOGGER.info("Registering Entities for " + SilverLight.MOD_ID);
    }
}
