package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SILVERLIGHT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "silverlight"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.silverlight"))
                    .icon(() -> new ItemStack(ModItems.BACKPACK)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BLACK_HOLE);
                        entries.add(ModItems.WINGS_OF_THE_END);
                        entries.add(ModItems.OMNI_CORE);
                        entries.add(ModItems.ANTI_MATTER);
                        entries.add(ModItems.MECHANICAL_MACHINE);
                        entries.add(ModItems.CORRUPTED_ESSENCE);
                        entries.add(ModItems.MULTI_PISTON);
                        entries.add(ModItems.LIFE_CORE);
                        entries.add(ModItems.DESTRUCTIVE_CORE);
                        entries.add(ModItems.OVERWORLD_CORE);
                        entries.add(ModItems.NETHER_CORE);
                        entries.add(ModItems.END_CORE);
                        entries.add(ModItems.CORE_OF_LIGHT);

                        entries.add(ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE);
                        entries.add(ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET);
                        entries.add(ModItems.SINGLE_CONDENSED_BLAZE_ROD);
                        entries.add(ModItems.SINGLE_CONDENSED_CHORUS_FRUIT);
                        entries.add(ModItems.SINGLE_CONDENSED_SHULKER_SHELL);
                        entries.add(ModItems.SINGLE_CONDENSED_GHAST_TEAR);
                        entries.add(ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE);
                        entries.add(ModItems.SINGLE_CONDENSED_ELYTRA);
                        entries.add(ModItems.SINGLE_CONDENSED_DRAGON_HEAD);
                        entries.add(ModItems.SINGLE_CONDENSED_NETHER_STAR);
                        entries.add(ModItems.DOUBLE_CONDENSED_EXPERIENCE_BOTTLE);
                        entries.add(ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET);
                        entries.add(ModItems.DOUBLE_CONDENSED_BLAZE_ROD);
                        entries.add(ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT);
                        entries.add(ModItems.DOUBLE_CONDENSED_SHULKER_SHELL);
                        entries.add(ModItems.DOUBLE_CONDENSED_GHAST_TEAR);
                        entries.add(ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE);
                        entries.add(ModItems.DOUBLE_CONDENSED_ELYTRA);
                        entries.add(ModItems.DOUBLE_CONDENSED_DRAGON_HEAD);
                        entries.add(ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE);
                        entries.add(ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET);
                        entries.add(ModItems.TRIPLE_CONDENSED_BLAZE_ROD);
                        entries.add(ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT);
                        entries.add(ModItems.TRIPLE_CONDENSED_SHULKER_SHELL);
                        entries.add(ModItems.TRIPLE_CONDENSED_GHAST_TEAR);
                        entries.add(ModItems.TRIPLE_CONDENSED_PHANTOM_MEMBRANE);
                        entries.add(ModItems.QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE);
                        entries.add(ModItems.QUADRUPLE_CONDENSED_FIREWORK_ROCKET);
                        entries.add(ModItems.QUADRUPLE_CONDENSED_BLAZE_ROD);
                        entries.add(ModItems.QUADRUPLE_CONDENSED_CHORUS_FRUIT);

                        entries.add(ModBlocks.SINGLE_CONDENSED_SAND);
                        entries.add(ModBlocks.SINGLE_CONDENSED_DIRT);
                        entries.add(ModBlocks.SINGLE_CONDENSED_STONE);
                        entries.add(ModBlocks.SINGLE_CONDENSED_GRAVEL);
                        entries.add(ModBlocks.SINGLE_CONDENSED_SOUL_SAND);
                        entries.add(ModBlocks.SINGLE_CONDENSED_NETHERRACK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_OBSIDIAN);
                        entries.add(ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_END_STONE);
                        entries.add(ModBlocks.SINGLE_CONDENSED_TORCH);
                        entries.add(ModBlocks.SINGLE_CONDENSED_GLOWSTONE);
                        entries.add(ModBlocks.SINGLE_CONDENSED_END_ROD);
                        entries.add(ModBlocks.SINGLE_CONDENSED_FURNACE);
                        entries.add(ModBlocks.SINGLE_CONDENSED_PISTON);
                        entries.add(ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_IRON_BLOCK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_LANTERN);
                        entries.add(ModBlocks.SINGLE_CONDENSED_SEA_LANTERN);
                        entries.add(ModBlocks.SINGLE_CONDENSED_SCULK);
                        entries.add(ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR);
                        entries.add(ModBlocks.SINGLE_CONDENSED_COPPER_BULB);

                        entries.add(ModBlocks.DOUBLE_CONDENSED_SAND);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_DIRT);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_STONE);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_GRAVEL);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_SOUL_SAND);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_NETHERRACK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_OBSIDIAN);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_END_STONE);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_TORCH);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_GLOWSTONE);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_END_ROD);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_FURNACE);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_PISTON);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_LANTERN);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_SCULK);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_RESPAWN_ANCHOR);
                        entries.add(ModBlocks.DOUBLE_CONDENSED_COPPER_BULB);

                        entries.add(ModBlocks.TRIPLE_CONDENSED_SAND);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_DIRT);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_STONE);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_GRAVEL);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_SOUL_SAND);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_NETHERRACK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_OBSIDIAN);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_END_STONE);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_TORCH);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_GLOWSTONE);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_END_ROD);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_FURNACE);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_PISTON);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK);
                        entries.add(ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK);

                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_SAND);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_DIRT);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_STONE);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_GRAVEL);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_END_STONE);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_TORCH);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_END_ROD);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_FURNACE);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_PISTON);
                        entries.add(ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK);


                        entries.add(ModItems.BACKPACK);
                        entries.add(ModItems.STRETCHY_LEATHER);
                        entries.add(ModItems.QUILL);
                        entries.add(ModItems.CANONICAL_BOOK);
                        entries.add(ModItems.DRAGON_OMELET);
                        entries.add(ModItems.DRAGON_SCRAP);
                        entries.add(ModItems.BLACK_EGG);
                        entries.add(ModItems.OBSIDIAN_SHEARS);
                        entries.add(ModItems.BURNING_OBSIDIAN_SHEARS);
                        entries.add(ModItems.VOID_OBSIDIAN_SHEARS);

                        entries.add(ModItems.POTION_OF_NAUSEA);
                        entries.add(ModItems.POTENT_POTION_OF_NAUSEA);
                        entries.add(ModItems.CRACKER);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEED);

                        entries.add(ModBlocks.DRAGON_PROCESSING_STATION);
                        entries.add(ModBlocks.SIEVING_STATION);
                        entries.add(ModBlocks.FERMENTING_STATION);


                    }).build());


    public static void registerItemGroups() {
        SilverLight.LOGGER.info("Registering Item Groups for " + SilverLight.MOD_ID);
    }
}
