package net.subtotalcamp875.silverlight.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<DragonProcessingStationBlockEntity> DRAGON_PROCESSING_STATION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(SilverLight.MOD_ID, "dragon_processing_be"),
                    FabricBlockEntityTypeBuilder.create(DragonProcessingStationBlockEntity::new,
                            ModBlocks.DRAGON_PROCESSING_STATION).build());

    public static void registerBlockEntities() {
        SilverLight.LOGGER.info("Registering Block Entities for " + SilverLight.MOD_ID);
    }
}
