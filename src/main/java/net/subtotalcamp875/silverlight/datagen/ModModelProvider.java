package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.block.custom.TomatoPlantBlock;
import net.subtotalcamp875.silverlight.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_PLANT, TomatoPlantBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerSimpleState(ModBlocks.DRAGON_PROCESSING_STATION);
        blockStateModelGenerator.registerSimpleState(ModBlocks.SIEVING_STATION);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FERMENTING_STATION);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_GRAVEL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_SOUL_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_NETHERRACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_GLOWSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_END_ROD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_FURNACE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_PISTON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_SEA_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_SCULK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINGLE_CONDENSED_COPPER_BULB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_GRAVEL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_SOUL_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_NETHERRACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_GLOWSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_END_ROD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_FURNACE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_PISTON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_SCULK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_RESPAWN_ANCHOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOUBLE_CONDENSED_COPPER_BULB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_GRAVEL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_SOUL_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_NETHERRACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_GLOWSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_END_ROD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_FURNACE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_PISTON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_GRAVEL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_END_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_TORCH);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_END_ROD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_FURNACE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_PISTON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BLACK_HOLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OMNI_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANTI_MATTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MECHANICAL_MACHINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORRUPTED_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MULTI_PISTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIFE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OVERWORLD_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.END_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORE_OF_LIGHT, Models.GENERATED);

        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_BLAZE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_SHULKER_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_GHAST_TEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SINGLE_CONDENSED_DRAGON_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_EXPERIENCE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_BLAZE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_SHULKER_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_GHAST_TEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUBLE_CONDENSED_DRAGON_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_BLAZE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_SHULKER_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_GHAST_TEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRIPLE_CONDENSED_PHANTOM_MEMBRANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUADRUPLE_CONDENSED_FIREWORK_ROCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUADRUPLE_CONDENSED_BLAZE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUADRUPLE_CONDENSED_CHORUS_FRUIT, Models.GENERATED);



        itemModelGenerator.register(ModItems.BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRETCHY_LEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUILL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANONICAL_BOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_OMELET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNING_OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_NAUSEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTENT_POTION_OF_NAUSEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
    }
}