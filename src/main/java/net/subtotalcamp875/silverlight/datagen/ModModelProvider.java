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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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
        itemModelGenerator.register(ModItems.POTION_OF_SHRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_DWARF, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_SHORTEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_FAIRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_TALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_ENLARGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_GIANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_GRAVITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_ANTI_GRAVITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_DISPROPORTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_HAPPY_FEET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRACKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);

        // season 7 code

        itemModelGenerator.register(ModItems.RIGHT_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEFT_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.FAKE_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.XP_TANK, Models.GENERATED);

    }
}