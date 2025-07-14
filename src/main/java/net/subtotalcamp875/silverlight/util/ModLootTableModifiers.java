package net.subtotalcamp875.silverlight.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.item.ModItems;

public class ModLootTableModifiers {
    //private static final Identifier GRASS_BLOCK_ID
    //        = Identifier.of("minecraft", "blocks/short_grass");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {

            if (LootTables.VILLAGE_TAIGA_HOUSE_CHEST.equals(key) || LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key) || LootTables.VILLAGE_PLAINS_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.STRAWBERRY_SEED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
