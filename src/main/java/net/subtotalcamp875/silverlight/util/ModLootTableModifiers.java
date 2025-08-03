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
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.ModItems;

public class ModLootTableModifiers {
    //private static final Identifier GRASS_BLOCK_ID
    //        = Identifier.of("minecraft", "blocks/short_grass");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {

            boolean zillowChest = LootTables.SIMPLE_DUNGEON_CHEST.equals(key) ||
                    LootTables.VILLAGE_TAIGA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_TANNERY_CHEST.equals(key) ||
                    LootTables.VILLAGE_CARTOGRAPHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_FLETCHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_SHEPARD_CHEST.equals(key) ||
                    LootTables.VILLAGE_TOOLSMITH_CHEST.equals(key) ||
                    LootTables.VILLAGE_MASON_CHEST.equals(key) ||
                    LootTables.VILLAGE_ARMORER_CHEST.equals(key) ||
                    LootTables.VILLAGE_FISHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_DESERT_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_SNOWY_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_PLAINS_CHEST.equals(key) ||
                    LootTables.IGLOO_CHEST_CHEST.equals(key) ||
                    LootTables.SHIPWRECK_TREASURE_CHEST.equals(key) ||
                    LootTables.SHIPWRECK_SUPPLY_CHEST.equals(key) ||
                    LootTables.ABANDONED_MINESHAFT_CHEST.equals(key) ||
                    LootTables.ANCIENT_CITY_CHEST.equals(key) ||
                    LootTables.STRONGHOLD_LIBRARY_CHEST.equals(key) ||
                    LootTables.STRONGHOLD_CORRIDOR_CHEST.equals(key) ||
                    LootTables.STRONGHOLD_CROSSING_CHEST.equals(key) ||
                    LootTables.TRAIL_RUINS_COMMON_ARCHAEOLOGY.equals(key) ||
                    LootTables.TRAIL_RUINS_RARE_ARCHAEOLOGY.equals(key) ||
                    LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(key) ||
                    LootTables.UNDERWATER_RUIN_SMALL_CHEST.equals(key) ||
                    LootTables.WOODLAND_MANSION_CHEST.equals(key) ||
                    LootTables.DESERT_PYRAMID_CHEST.equals(key) ||
                    LootTables.DESERT_PYRAMID_ARCHAEOLOGY.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST.equals(key) ||
                    LootTables.PILLAGER_OUTPOST_CHEST.equals(key) ||
                    LootTables.RUINED_PORTAL_CHEST.equals(key) ||
                    LootTables.NETHER_BRIDGE_CHEST.equals(key) ||
                    LootTables.END_CITY_TREASURE_CHEST.equals(key) ||
                    LootTables.BASTION_BRIDGE_CHEST.equals(key) ||
                    LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(key) ||
                    LootTables.BASTION_TREASURE_CHEST.equals(key) ||
                    LootTables.BASTION_OTHER_CHEST.equals(key);

            if (LootTables.VILLAGE_TAIGA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_PLAINS_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.STRAWBERRY_SEED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.VILLAGE_SNOWY_HOUSE_CHEST.equals(key) ||
                    LootTables.PILLAGER_OUTPOST_CHEST.equals(key) ||
                    LootTables.IGLOO_CHEST_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.VIKING_PATTERN))
                        .with(ItemEntry.builder(ModItems.VIKING_HORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.VILLAGE_TAIGA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_TANNERY_CHEST.equals(key) ||
                    LootTables.VILLAGE_CARTOGRAPHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_FLETCHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_SHEPARD_CHEST.equals(key) ||
                    LootTables.VILLAGE_TOOLSMITH_CHEST.equals(key) ||
                    LootTables.VILLAGE_MASON_CHEST.equals(key) ||
                    LootTables.VILLAGE_ARMORER_CHEST.equals(key) ||
                    LootTables.VILLAGE_FISHER_CHEST.equals(key) ||
                    LootTables.VILLAGE_DESERT_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_SNOWY_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_SAVANNA_HOUSE_CHEST.equals(key) ||
                    LootTables.VILLAGE_PLAINS_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.FAKE_BREAD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.SIMPLE_DUNGEON_CHEST.equals(key) ||
                    LootTables.ABANDONED_MINESHAFT_CHEST.equals(key) ||
                    LootTables.ANCIENT_CITY_CHEST.equals(key) ||
                    LootTables.STRONGHOLD_CORRIDOR_CHEST.equals(key) ||
                    LootTables.STRONGHOLD_CROSSING_CHEST.equals(key) ||
                    LootTables.UNDERWATER_RUIN_BIG_CHEST.equals(key) ||
                    LootTables.UNDERWATER_RUIN_SMALL_CHEST.equals(key) ||
                    LootTables.WOODLAND_MANSION_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST.equals(key) ||
                    LootTables.NETHER_BRIDGE_CHEST.equals(key) ||
                    LootTables.BASTION_BRIDGE_CHEST.equals(key) ||
                    LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(key) ||
                    LootTables.BASTION_TREASURE_CHEST.equals(key) ||
                    LootTables.BASTION_OTHER_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModBlocks.MIMIC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (zillowChest) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.50f)) // 11 zillows in 5 chests
                        .with(ItemEntry.builder(ModItems.ZILLOW_ONE))
                        .with(ItemEntry.builder(ModItems.ZILLOW_FIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (zillowChest) {
                LootPool.Builder poolBuilder1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // 6 zillows in 5 chests
                        .with(ItemEntry.builder(ModItems.ZILLOW_TEN))
                        .with(ItemEntry.builder(ModItems.ZILLOW_TWENTY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder1.build());
            }

            if (zillowChest) {
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // 1 zillow in 1 chest
                        .with(ItemEntry.builder(ModItems.ZILLOW_HUNDRED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if (LootTables.NETHER_BRIDGE_CHEST.equals(key) ||
                    LootTables.BASTION_BRIDGE_CHEST.equals(key) ||
                    LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(key) ||
                    LootTables.BASTION_TREASURE_CHEST.equals(key) ||
                    LootTables.BASTION_OTHER_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.005f))
                        .with(ItemEntry.builder(ModItems.SAY10S_CONTRACT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.VILLAGE_TEMPLE_CHEST.equals(key) ||
                    LootTables.DESERT_PYRAMID_ARCHAEOLOGY.equals(key) ||
                    LootTables.DESERT_PYRAMID_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.RIGHT_RING))
                        .with(ItemEntry.builder(ModItems.LEFT_RING))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.BASTION_TREASURE_CHEST.equals(key) ||
                    LootTables.END_CITY_TREASURE_CHEST.equals(key) ||
                    LootTables.VILLAGE_TANNERY_CHEST.equals(key) ||
                    LootTables.SIMPLE_DUNGEON_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.FAKE_ELYTRA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.BASTION_TREASURE_CHEST.equals(key) ||
                    LootTables.END_CITY_TREASURE_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_DISPENSER_CHEST.equals(key) ||
                    LootTables.JUNGLE_TEMPLE_CHEST.equals(key) ||
                    LootTables.VILLAGE_TEMPLE_CHEST.equals(key) ||
                    LootTables.DESERT_PYRAMID_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.HOLY_CHARM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (LootTables.END_CITY_TREASURE_CHEST.equals(key)) {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.50f))
                        .with(ItemEntry.builder(ModItems.COSMIC_BROWNIE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
