package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.item.custom.BackpackItem;

public class ModItems {
    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1)));

    public static final Item STRETCHY_LEATHER = registerItem("stretchy_leather", new Item(new Item.Settings()));
    public static final Item QUILL = registerItem("quill", new Item(new Item.Settings()));
    public static final Item CANONICAL_BOOK = registerItem("canonical_book", new Item(new Item.Settings().maxCount(1)));

    public static final Item DRAGON_OMLET = registerItem("dragon_omlet", new Item(new Item.Settings().food(ModFoodComponents.DRAGON_OMLET)));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BACKPACK);
        entries.add(STRETCHY_LEATHER);
        entries.add(QUILL);
        entries.add(CANONICAL_BOOK);
        entries.add(DRAGON_OMLET);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SilverLight.LOGGER.info("Registering Mod Items for " + SilverLight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
