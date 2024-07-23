package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.block.custom.TomatoPlantBlock;
import net.subtotalcamp875.silverlight.item.ModItems;
import org.apache.commons.io.output.TaggedOutputStream;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_PLANT).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoPlantBlock.AGE, 8));

        addDrop(ModBlocks.TOMATO_PLANT, cropDrops(ModBlocks.TOMATO_PLANT, ModItems.TOMATO, ModItems.TOMATO_SEED, builder2));
        addDrop(ModBlocks.DRAGON_PROCESSING_STATION);
        addDrop(ModBlocks.SIEVING_STATION);
        addDrop(ModBlocks.FERMENTING_STATION);
        
        addDrop(ModBlocks.SINGLE_CONDENSED_SAND);
        addDrop(ModBlocks.SINGLE_CONDENSED_DIRT);
        addDrop(ModBlocks.SINGLE_CONDENSED_STONE);
        addDrop(ModBlocks.SINGLE_CONDENSED_GRAVEL);
        addDrop(ModBlocks.SINGLE_CONDENSED_SOUL_SAND);
        addDrop(ModBlocks.SINGLE_CONDENSED_NETHERRACK);
        addDrop(ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_OBSIDIAN);
        addDrop(ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_END_STONE);
        addDrop(ModBlocks.SINGLE_CONDENSED_TORCH);
        addDrop(ModBlocks.SINGLE_CONDENSED_GLOWSTONE);
        addDrop(ModBlocks.SINGLE_CONDENSED_END_ROD);
        addDrop(ModBlocks.SINGLE_CONDENSED_FURNACE);
        addDrop(ModBlocks.SINGLE_CONDENSED_PISTON);
        addDrop(ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_IRON_BLOCK);
        addDrop(ModBlocks.SINGLE_CONDENSED_LANTERN);
        addDrop(ModBlocks.SINGLE_CONDENSED_SEA_LANTERN);
        addDrop(ModBlocks.SINGLE_CONDENSED_SCULK);
        addDrop(ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR);
        addDrop(ModBlocks.SINGLE_CONDENSED_COPPER_BULB);

        addDrop(ModBlocks.DOUBLE_CONDENSED_SAND);
        addDrop(ModBlocks.DOUBLE_CONDENSED_DIRT);
        addDrop(ModBlocks.DOUBLE_CONDENSED_STONE);
        addDrop(ModBlocks.DOUBLE_CONDENSED_GRAVEL);
        addDrop(ModBlocks.DOUBLE_CONDENSED_SOUL_SAND);
        addDrop(ModBlocks.DOUBLE_CONDENSED_NETHERRACK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_OBSIDIAN);
        addDrop(ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_END_STONE);
        addDrop(ModBlocks.DOUBLE_CONDENSED_TORCH);
        addDrop(ModBlocks.DOUBLE_CONDENSED_GLOWSTONE);
        addDrop(ModBlocks.DOUBLE_CONDENSED_END_ROD);
        addDrop(ModBlocks.DOUBLE_CONDENSED_FURNACE);
        addDrop(ModBlocks.DOUBLE_CONDENSED_PISTON);
        addDrop(ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_LANTERN);
        addDrop(ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN);
        addDrop(ModBlocks.DOUBLE_CONDENSED_SCULK);
        addDrop(ModBlocks.DOUBLE_CONDENSED_RESPAWN_ANCHOR);
        addDrop(ModBlocks.DOUBLE_CONDENSED_COPPER_BULB);

        addDrop(ModBlocks.TRIPLE_CONDENSED_SAND);
        addDrop(ModBlocks.TRIPLE_CONDENSED_DIRT);
        addDrop(ModBlocks.TRIPLE_CONDENSED_STONE);
        addDrop(ModBlocks.TRIPLE_CONDENSED_GRAVEL);
        addDrop(ModBlocks.TRIPLE_CONDENSED_SOUL_SAND);
        addDrop(ModBlocks.TRIPLE_CONDENSED_NETHERRACK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_OBSIDIAN);
        addDrop(ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_END_STONE);
        addDrop(ModBlocks.TRIPLE_CONDENSED_TORCH);
        addDrop(ModBlocks.TRIPLE_CONDENSED_GLOWSTONE);
        addDrop(ModBlocks.TRIPLE_CONDENSED_END_ROD);
        addDrop(ModBlocks.TRIPLE_CONDENSED_FURNACE);
        addDrop(ModBlocks.TRIPLE_CONDENSED_PISTON);
        addDrop(ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK);
        addDrop(ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK);

        addDrop(ModBlocks.QUADRUPLE_CONDENSED_SAND);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_DIRT);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_STONE);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_GRAVEL);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_END_STONE);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_TORCH);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_END_ROD);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_FURNACE);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_PISTON);
        addDrop(ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK);
    }
}
