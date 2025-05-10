package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.block.custom.StrawberryPlantBlock;
import net.subtotalcamp875.silverlight.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_PLANT).properties(StatePredicate.Builder.create()
                .exactMatch(StrawberryPlantBlock.AGE, 8));

        addDrop(ModBlocks.STRAWBERRY_PLANT, cropDrops(ModBlocks.STRAWBERRY_PLANT, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEED, builder2));
        addDrop(ModBlocks.DRAGON_PROCESSING_STATION);
        addDrop(ModBlocks.SIEVING_STATION);
        addDrop(ModBlocks.FERMENTING_STATION);
        addDrop(ModBlocks.FAKE_DIAMOND_BLOCK);
        addDrop(ModBlocks.CHARGE_GENERATOR);
        addDrop(ModBlocks.ENERGY_GENERATOR);
        addDrop(ModBlocks.MIMIC);

    }
}
