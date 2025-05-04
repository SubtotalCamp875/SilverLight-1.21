package net.subtotalcamp875.silverlight.item;

import com.google.common.base.Supplier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.subtotalcamp875.silverlight.SilverLight;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> CHARGED_CRYSTAL_ARMOR_MATERIAL = registerArmorMaterial("charged_crystal",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.BEDROCK),
                    List.of(new ArmorMaterial.Layer(Identifier.of(SilverLight.MOD_ID, "charged_crystal"))), 0,0));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(SilverLight.MOD_ID, name), material.get());
    }
}