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
    public static final Block SINGLE_CONDENSED_SAND = registerBlock("single_condensed_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_DIRT = registerBlock("single_condensed_dirt", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_STONE = registerBlock("single_condensed_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_GRAVEL = registerBlock("single_condensed_gravel", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_SOUL_SAND = registerBlock("single_condensed_soul_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_NETHERRACK = registerBlock("single_condensed_netherrack", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_MAGMA_BLOCK = registerBlock("single_condensed_magma_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_NETHER_WART_BLOCK = registerBlock("single_condensed_nether_wart_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_OBSIDIAN = registerBlock("single_condensed_obsidian", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_PURPUR_BLOCK = registerBlock("single_condensed_purpur_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_END_STONE = registerBlock("single_condensed_end_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_TORCH = registerBlock("single_condensed_torch", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_GLOWSTONE = registerBlock("single_condensed_glow_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_END_ROD = registerBlock("single_condensed_end_rod", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_FURNACE = registerBlock("single_condensed_furnace", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_PISTON = registerBlock("single_condensed_piston", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_COPPER_BLOCK = registerBlock("single_condensed_copper_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_SLIME_BLOCK = registerBlock("single_condensed_slime_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_REDSTONE_BLOCK = registerBlock("single_condensed_redstone_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_IRON_BLOCK = registerBlock("single_condensed_iron_block", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_LANTERN = registerBlock("single_condensed_lantern", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_SEA_LANTERN = registerBlock("single_condensed_sea_lantern", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_SCULK = registerBlock("single_condensed_sculk", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_RESPAWN_ANCHOR = registerBlock("single_condensed_respawn_anchor", new Block(AbstractBlock.Settings.create()));
    public static final Block SINGLE_CONDENSED_COPPER_BULB = registerBlock("single_condensed_copper_bulb", new Block(AbstractBlock.Settings.create()));

    public static final Block DOUBLE_CONDENSED_SAND = registerBlock("double_condensed_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_DIRT = registerBlock("double_condensed_dirt", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_STONE = registerBlock("double_condensed_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_GRAVEL = registerBlock("double_condensed_gravel", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_SOUL_SAND = registerBlock("double_condensed_soul_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_NETHERRACK = registerBlock("double_condensed_netherrack", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_MAGMA_BLOCK = registerBlock("double_condensed_magma_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_NETHER_WART_BLOCK = registerBlock("double_condensed_nether_wart_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_OBSIDIAN = registerBlock("double_condensed_obsidian", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_PURPUR_BLOCK = registerBlock("double_condensed_purpur_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_END_STONE = registerBlock("double_condensed_end_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_TORCH = registerBlock("double_condensed_torch", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_GLOWSTONE = registerBlock("double_condensed_glow_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_END_ROD = registerBlock("double_condensed_end_rod", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_FURNACE = registerBlock("double_condensed_furnace", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_PISTON = registerBlock("double_condensed_piston", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_COPPER_BLOCK = registerBlock("double_condensed_copper_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_SLIME_BLOCK = registerBlock("double_condensed_slime_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_REDSTONE_BLOCK = registerBlock("double_condensed_redstone_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_IRON_BLOCK = registerBlock("double_condensed_iron_block", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_LANTERN = registerBlock("double_condensed_lantern", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_SEA_LANTERN = registerBlock("double_condensed_sea_lantern", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_SCULK = registerBlock("double_condensed_sculk", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_RESPAWN_ANCHOR = registerBlock("double_condensed_respawn_anchor", new Block(AbstractBlock.Settings.create()));
    public static final Block DOUBLE_CONDENSED_COPPER_BULB = registerBlock("double_condensed_copper_bulb", new Block(AbstractBlock.Settings.create()));

    public static final Block TRIPLE_CONDENSED_SAND = registerBlock("triple_condensed_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_DIRT = registerBlock("triple_condensed_dirt", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_STONE = registerBlock("triple_condensed_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_GRAVEL = registerBlock("triple_condensed_gravel", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_SOUL_SAND = registerBlock("triple_condensed_soul_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_NETHERRACK = registerBlock("triple_condensed_netherrack", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_MAGMA_BLOCK = registerBlock("triple_condensed_magma_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_NETHER_WART_BLOCK = registerBlock("triple_condensed_nether_wart_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_OBSIDIAN = registerBlock("triple_condensed_obsidian", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_PURPUR_BLOCK = registerBlock("triple_condensed_purpur_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_END_STONE = registerBlock("triple_condensed_end_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_TORCH = registerBlock("triple_condensed_torch", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_GLOWSTONE = registerBlock("triple_condensed_glow_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_END_ROD = registerBlock("triple_condensed_end_rod", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_FURNACE = registerBlock("triple_condensed_furnace", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_PISTON = registerBlock("triple_condensed_piston", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_COPPER_BLOCK = registerBlock("triple_condensed_copper_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_SLIME_BLOCK = registerBlock("triple_condensed_slime_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_REDSTONE_BLOCK = registerBlock("triple_condensed_redstone_block", new Block(AbstractBlock.Settings.create()));
    public static final Block TRIPLE_CONDENSED_IRON_BLOCK = registerBlock("triple_condensed_iron_block", new Block(AbstractBlock.Settings.create()));

    public static final Block QUADRUPLE_CONDENSED_SAND = registerBlock("quadruple_condensed_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_DIRT = registerBlock("quadruple_condensed_dirt", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_STONE = registerBlock("quadruple_condensed_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_GRAVEL = registerBlock("quadruple_condensed_gravel", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_SOUL_SAND = registerBlock("quadruple_condensed_soul_sand", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_NETHERRACK = registerBlock("quadruple_condensed_netherrack", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_MAGMA_BLOCK = registerBlock("quadruple_condensed_magma_block", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_NETHER_WART_BLOCK = registerBlock("quadruple_condensed_nether_wart_block", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_OBSIDIAN = registerBlock("quadruple_condensed_obsidian", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_PURPUR_BLOCK = registerBlock("quadruple_condensed_purpur_block", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_END_STONE = registerBlock("quadruple_condensed_end_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_TORCH = registerBlock("quadruple_condensed_torch", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_GLOWSTONE = registerBlock("quadruple_condensed_glow_stone", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_END_ROD = registerBlock("quadruple_condensed_end_rod", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_FURNACE = registerBlock("quadruple_condensed_furnace", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_PISTON = registerBlock("quadruple_condensed_piston", new Block(AbstractBlock.Settings.create()));
    public static final Block QUADRUPLE_CONDENSED_COPPER_BLOCK = registerBlock("quadruple_condensed_copper_block", new Block(AbstractBlock.Settings.create()));


    public static final Block TOMATO_PLANT = Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, "tomato_plant"),
            new TomatoPlantBlock(AbstractBlock.Settings.create()));

    public static final Block DRAGON_PROCESSING_STATION = registerBlock("dragon_processing_station",
            new DragonProcessingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block SIEVING_STATION = registerBlock("sieving_station",
            new SievingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block FERMENTING_STATION = registerBlock("fermenting_station",
            new FermentingStationBlock(AbstractBlock.Settings.create().nonOpaque()));



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
