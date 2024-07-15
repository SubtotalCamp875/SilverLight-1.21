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
    }
}
