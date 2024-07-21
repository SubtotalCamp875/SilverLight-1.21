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

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEED);

                        entries.add(ModBlocks.DRAGON_PROCESSING_STATION);
                        entries.add(ModBlocks.SIEVING_STATION);


                    }).build());


    public static void registerItemGroups() {
        SilverLight.LOGGER.info("Registering Item Groups for " + SilverLight.MOD_ID);
    }
}
