package net.subtotalcamp875.silverlight.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
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
            FabricEntityTypeBuilder.<TomatoEntity>create(SpawnGroup.MISC, TomatoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
}
