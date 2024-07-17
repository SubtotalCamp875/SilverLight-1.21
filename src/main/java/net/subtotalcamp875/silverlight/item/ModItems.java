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
import net.subtotalcamp875.silverlight.item.custom.TomatoItem;

public class ModItems {

    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1)));


    public static final Item STRETCHY_LEATHER = registerItem("stretchy_leather", new Item(new Item.Settings()));
    public static final Item QUILL = registerItem("quill", new Item(new Item.Settings()));
    public static final Item CANONICAL_BOOK = registerItem("canonical_book", new Item(new Item.Settings().maxCount(1)));
    public static final Item DRAGON_OMELET = registerItem("dragon_omelet", new Item(new Item.Settings().food(ModFoodComponents.DRAGON_OMELET)));
    public static final Item DRAGON_SCRAP = registerItem("dragon_scrap", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_SHEARS = registerItem("obsidian_shears", new Item(new Item.Settings().maxDamage(64)));


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
