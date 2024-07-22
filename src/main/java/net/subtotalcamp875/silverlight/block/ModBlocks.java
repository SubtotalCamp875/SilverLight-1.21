package net.subtotalcamp875.silverlight.block;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.custom.DragonProcessingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.FermentingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.SievingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.TomatoPlantBlock;

public class ModBlocks {
    public static final Block TOMATO_PLANT = Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, "tomato_plant"),
            new TomatoPlantBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block DRAGON_PROCESSING_STATION = registerBlock("dragon_processing_station",
            new DragonProcessingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block SIEVING_STATION = registerBlock("sieving_station",
            new SievingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));
    public static final Block FERMENTING_STATION = registerBlock("fermenting_station",
            new FermentingStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SilverLight.LOGGER.info("Registering ModBlocks for " + SilverLight.MOD_ID);
    }
}
