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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRETCHY_LEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUILL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANONICAL_BOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_OMLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
    }
}