package net.subtotalcamp875.silverlight.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BackpackContentsComponent> BACKPACK_CONTENTS = registerComponentType("backpack_contents", builder -> builder
            .codec(BackpackContentsComponent.CODEC)
            .packetCodec(BackpackContentsComponent.PACKET_CODEC).cache()
    );

    private static <T> ComponentType<T> registerComponentType(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(SilverLight.MOD_ID, id), builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerModDataComponentTypes() {
        SilverLight.LOGGER.info("Registering ModDataComponentTypes for " + SilverLight.MOD_ID);
    }
}
