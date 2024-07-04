package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.item.custom.BackpackItem;
import org.spongepowered.asm.mixin.injection.Slice;

public class ModItems {
    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings()));
    public static final Item STRETCHY_LEATHER = registerItem("stretchy_leather", new Item(new Item.Settings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(BACKPACK);
        entries.add(STRETCHY_LEATHER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SilverLight.LOGGER.info("Registering Mod Items for " + SilverLight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
