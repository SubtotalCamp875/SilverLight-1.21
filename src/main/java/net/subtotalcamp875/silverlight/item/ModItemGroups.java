package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;

public class ModItemGroups {
    public static final ItemGroup SILVERLIGHT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "silverlight"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.silverlight"))
                    .icon(() -> new ItemStack(ModItems.BACKPACK)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BACKPACK);
                        entries.add(ModItems.STRETCHY_LEATHER);


                    }).build());


    public static void registerItemGroups() {
        SilverLight.LOGGER.info("Registering Item Groups for " + SilverLight.MOD_ID);
    }
}
