package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.custom.*;

public class ModItems {
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
    public static final Item POTION_OF_SHRINK = registerItem("potion_of_shrink", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_SHRINK).maxCount(1)));
    public static final Item POTION_OF_DWARF = registerItem("potion_of_dwarf", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_DWARF).maxCount(1)));
    public static final Item POTION_OF_SHORTEN = registerItem("potion_of_shorten", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_SHORTEN).maxCount(1)));
    public static final Item POTION_OF_FAIRY = registerItem("potion_of_fairy", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_FAIRY).maxCount(1)));
    public static final Item POTION_OF_TALL = registerItem("potion_of_tall", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_TALL).maxCount(1)));
    public static final Item POTION_OF_ENLARGE = registerItem("potion_of_enlarge", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_ENLARGE).maxCount(1)));
    public static final Item POTION_OF_GIANT = registerItem("potion_of_giant", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_GIANT).maxCount(1)));
    public static final Item POTION_OF_GRAVITY = registerItem("potion_of_gravity", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_GRAVITY).maxCount(1)));
    public static final Item POTION_OF_ANTI_GRAVITY = registerItem("potion_of_anti_gravity", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_ANTI_GRAVITY).maxCount(1)));
    public static final Item POTION_OF_DISPROPORTION = registerItem("potion_of_disproportion", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_DISPROPORTION).maxCount(1)));
    public static final Item POTION_OF_HAPPY_FEET = registerItem("potion_of_happy_feet", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_HAPPY_FEET).maxCount(1)));
    public static final Item CRACKER = registerItem("cracker", new Item(new Item.Settings().food(ModFoodComponents.CRACKER).maxCount(64)));

    public static final Item TOMATO_SEED = registerItem("tomato_seed",
            new AliasedBlockItem(ModBlocks.TOMATO_PLANT, new Item.Settings()));
    public static final Item TOMATO = registerItem("tomato",
            new TomatoItem(new Item.Settings()));

    //season 7 code starts here

    public static final Item RIGHT_RING = registerItem("right_ring", new RightRingItem(new Item.Settings().maxCount(1)));
    public static final Item LEFT_RING = registerItem("left_ring", new Item(new Item.Settings().maxCount(1)));
    public static final Item FAKE_ELYTRA = registerItem("fake_elytra", new Item(new Item.Settings().maxCount(1)));
    public static final Item XP_TANK = registerItem("xp_tank", new XPTankItem(new Item.Settings().maxCount(1).maxDamage(1125)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SilverLight.LOGGER.info("Registering Mod Items for " + SilverLight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
