package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.subtotalcamp875.silverlight.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DRAGON_PROCESSING_STATION)
                .add(ModBlocks.SIEVING_STATION)
                .add(ModBlocks.FERMENTING_STATION)

                .add(ModBlocks.SINGLE_CONDENSED_SAND)
                .add(ModBlocks.SINGLE_CONDENSED_DIRT)
                .add(ModBlocks.SINGLE_CONDENSED_STONE)
                .add(ModBlocks.SINGLE_CONDENSED_GRAVEL)
                .add(ModBlocks.SINGLE_CONDENSED_SOUL_SAND)
                .add(ModBlocks.SINGLE_CONDENSED_NETHERRACK)
                .add(ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_OBSIDIAN)
                .add(ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_END_STONE)
                .add(ModBlocks.SINGLE_CONDENSED_TORCH)
                .add(ModBlocks.SINGLE_CONDENSED_GLOWSTONE)
                .add(ModBlocks.SINGLE_CONDENSED_END_ROD)
                .add(ModBlocks.SINGLE_CONDENSED_FURNACE)
                .add(ModBlocks.SINGLE_CONDENSED_PISTON)
                .add(ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_IRON_BLOCK)
                .add(ModBlocks.SINGLE_CONDENSED_LANTERN)
                .add(ModBlocks.SINGLE_CONDENSED_SEA_LANTERN)
                .add(ModBlocks.SINGLE_CONDENSED_SCULK)
                .add(ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR)
                .add(ModBlocks.SINGLE_CONDENSED_COPPER_BULB)
        
                .add(ModBlocks.DOUBLE_CONDENSED_SAND)
                .add(ModBlocks.DOUBLE_CONDENSED_DIRT)
                .add(ModBlocks.DOUBLE_CONDENSED_STONE)
                .add(ModBlocks.DOUBLE_CONDENSED_GRAVEL)
                .add(ModBlocks.DOUBLE_CONDENSED_SOUL_SAND)
                .add(ModBlocks.DOUBLE_CONDENSED_NETHERRACK)
                .add(ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_OBSIDIAN)
                .add(ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_END_STONE)
                .add(ModBlocks.DOUBLE_CONDENSED_TORCH)
                .add(ModBlocks.DOUBLE_CONDENSED_GLOWSTONE)
                .add(ModBlocks.DOUBLE_CONDENSED_END_ROD)
                .add(ModBlocks.DOUBLE_CONDENSED_FURNACE)
                .add(ModBlocks.DOUBLE_CONDENSED_PISTON)
                .add(ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK)
                .add(ModBlocks.DOUBLE_CONDENSED_LANTERN)
                .add(ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN)
                .add(ModBlocks.DOUBLE_CONDENSED_SCULK)
                .add(ModBlocks.DOUBLE_CONDENSED_RESPAWN_ANCHOR)
                .add(ModBlocks.DOUBLE_CONDENSED_COPPER_BULB)
        
                .add(ModBlocks.TRIPLE_CONDENSED_SAND)
                .add(ModBlocks.TRIPLE_CONDENSED_DIRT)
                .add(ModBlocks.TRIPLE_CONDENSED_STONE)
                .add(ModBlocks.TRIPLE_CONDENSED_GRAVEL)
                .add(ModBlocks.TRIPLE_CONDENSED_SOUL_SAND)
                .add(ModBlocks.TRIPLE_CONDENSED_NETHERRACK)
                .add(ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_OBSIDIAN)
                .add(ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_END_STONE)
                .add(ModBlocks.TRIPLE_CONDENSED_TORCH)
                .add(ModBlocks.TRIPLE_CONDENSED_GLOWSTONE)
                .add(ModBlocks.TRIPLE_CONDENSED_END_ROD)
                .add(ModBlocks.TRIPLE_CONDENSED_FURNACE)
                .add(ModBlocks.TRIPLE_CONDENSED_PISTON)
                .add(ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK)
                .add(ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK)
        
                .add(ModBlocks.QUADRUPLE_CONDENSED_SAND)
                .add(ModBlocks.QUADRUPLE_CONDENSED_DIRT)
                .add(ModBlocks.QUADRUPLE_CONDENSED_STONE)
                .add(ModBlocks.QUADRUPLE_CONDENSED_GRAVEL)
                .add(ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND)
                .add(ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK)
                .add(ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK)
                .add(ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK)
                .add(ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN)
                .add(ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK)
                .add(ModBlocks.QUADRUPLE_CONDENSED_END_STONE)
                .add(ModBlocks.QUADRUPLE_CONDENSED_TORCH)
                .add(ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE)
                .add(ModBlocks.QUADRUPLE_CONDENSED_END_ROD)
                .add(ModBlocks.QUADRUPLE_CONDENSED_FURNACE)
                .add(ModBlocks.QUADRUPLE_CONDENSED_PISTON)
                .add(ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
