package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.custom.BackpackItem;
import net.subtotalcamp875.silverlight.item.custom.BlackHoleItem;
import net.subtotalcamp875.silverlight.item.custom.TomatoItem;

public class ModItems {
    public static final Item BLACK_HOLE = registerItem("black_hole", new BlackHoleItem(new Item.Settings()));
    public static final Item WINGS_OF_THE_END = registerItem("wings_of_the_end", new Item(new Item.Settings()));
    public static final Item OMNI_CORE = registerItem("omni_core", new Item(new Item.Settings()));
    public static final Item ANTI_MATTER = registerItem("anti_matter", new Item(new Item.Settings()));
    public static final Item MECHANICAL_MACHINE = registerItem("mechanical_machine", new Item(new Item.Settings()));
    public static final Item CORRUPTED_ESSENCE = registerItem("corrupted_essence", new Item(new Item.Settings()));
    public static final Item MULTI_PISTON = registerItem("multi_piston", new Item(new Item.Settings()));
    public static final Item LIFE_CORE = registerItem("life_core", new Item(new Item.Settings()));
    public static final Item DESTRUCTIVE_CORE = registerItem("destructive_core", new Item(new Item.Settings()));
    public static final Item OVERWORLD_CORE = registerItem("overworld_core", new Item(new Item.Settings()));
    public static final Item NETHER_CORE = registerItem("nether_core", new Item(new Item.Settings()));
    public static final Item END_CORE = registerItem("end_core", new Item(new Item.Settings()));
    public static final Item CORE_OF_LIGHT = registerItem("core_of_light", new Item(new Item.Settings()));

    public static final Item SINGLE_CONDENSED_EXPERIENCE_BOTTLE = registerItem("single_condensed_experience_bottle", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_FIREWORK_ROCKET = registerItem("single_condensed_firework_rocket", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_BLAZE_ROD = registerItem("single_condensed_blaze_rod", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_CHORUS_FRUIT = registerItem("single_condensed_chorus_fruit", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_SHULKER_SHELL = registerItem("single_condensed_shulker_shell", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_GHAST_TEAR = registerItem("single_condensed_ghast_tear", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_PHANTOM_MEMBRANE = registerItem("single_condensed_phantom_membrane", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_ELYTRA = registerItem("single_condensed_elytra", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_DRAGON_HEAD = registerItem("single_condensed_dragon_head", new Item(new Item.Settings()));
    public static final Item SINGLE_CONDENSED_NETHER_STAR = registerItem("single_condensed_nether_star", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_EXPERIENCE_BOTTLE = registerItem("double_condensed_experience_bottle", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_FIREWORK_ROCKET = registerItem("double_condensed_firework_rocket", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_BLAZE_ROD = registerItem("double_condensed_blaze_rod", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_CHORUS_FRUIT = registerItem("double_condensed_chorus_fruit", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_SHULKER_SHELL = registerItem("double_condensed_shulker_shell", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_GHAST_TEAR = registerItem("double_condensed_ghast_tear", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_PHANTOM_MEMBRANE = registerItem("double_condensed_phantom_membrane", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_ELYTRA = registerItem("double_condensed_elytra", new Item(new Item.Settings()));
    public static final Item DOUBLE_CONDENSED_DRAGON_HEAD = registerItem("double_condensed_dragon_head", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_EXPERIENCE_BOTTLE = registerItem("triple_condensed_experience_bottle", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_FIREWORK_ROCKET = registerItem("triple_condensed_firework_rocket", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_BLAZE_ROD = registerItem("triple_condensed_blaze_rod", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_CHORUS_FRUIT = registerItem("triple_condensed_chorus_fruit", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_SHULKER_SHELL = registerItem("triple_condensed_shulker_shell", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_GHAST_TEAR = registerItem("triple_condensed_ghast_tear", new Item(new Item.Settings()));
    public static final Item TRIPLE_CONDENSED_PHANTOM_MEMBRANE = registerItem("triple_condensed_phantom_membrane", new Item(new Item.Settings()));
    public static final Item QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE = registerItem("quadruple_condensed_experience_bottle", new Item(new Item.Settings()));
    public static final Item QUADRUPLE_CONDENSED_FIREWORK_ROCKET = registerItem("quadruple_condensed_firework_rocket", new Item(new Item.Settings()));
    public static final Item QUADRUPLE_CONDENSED_BLAZE_ROD = registerItem("quadruple_condensed_blaze_rod", new Item(new Item.Settings()));
    public static final Item QUADRUPLE_CONDENSED_CHORUS_FRUIT = registerItem("quadruple_condensed_chorus_fruit", new Item(new Item.Settings()));

    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1)));

    public static final Item STRETCHY_LEATHER = registerItem("stretchy_leather", new Item(new Item.Settings()));
    public static final Item QUILL = registerItem("quill", new Item(new Item.Settings()));
    public static final Item CANONICAL_BOOK = registerItem("canonical_book", new Item(new Item.Settings().maxCount(1)));
    public static final Item DRAGON_OMELET = registerItem("dragon_omelet", new Item(new Item.Settings().food(ModFoodComponents.DRAGON_OMELET)));
    public static final Item DRAGON_SCRAP = registerItem("dragon_scrap", new Item(new Item.Settings()));
    public static final Item BLACK_EGG = registerItem("black_egg", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_SHEARS = registerItem("obsidian_shears", new Item(new Item.Settings().maxDamage(64)));
    public static final Item BURNING_OBSIDIAN_SHEARS = registerItem("burning_obsidian_shears", new Item(new Item.Settings().maxDamage(64)));
    public static final Item VOID_OBSIDIAN_SHEARS = registerItem("void_obsidian_shears", new Item(new Item.Settings().maxDamage(64)));



    public static final Item POTION_OF_NAUSEA = registerItem("potion_of_nausea", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_NAUSEA).maxCount(1)));
    public static final Item POTENT_POTION_OF_NAUSEA = registerItem("potent_potion_of_nausea", new Item(new Item.Settings().food(ModFoodComponents.POTENT_POTION_OF_NAUSEA).maxCount(1)));
    public static final Item CRACKER = registerItem("cracker", new Item(new Item.Settings().food(ModFoodComponents.CRACKER).maxCount(64)));

    public static final Item TOMATO_SEED = registerItem("tomato_seed",
            new AliasedBlockItem(ModBlocks.TOMATO_PLANT, new Item.Settings()));
    public static final Item TOMATO = registerItem("tomato",
            new TomatoItem(new Item.Settings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BACKPACK);
        entries.add(STRETCHY_LEATHER);
        entries.add(QUILL);
        entries.add(CANONICAL_BOOK);
        entries.add(DRAGON_OMELET);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SilverLight.LOGGER.info("Registering Mod Items for " + SilverLight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
