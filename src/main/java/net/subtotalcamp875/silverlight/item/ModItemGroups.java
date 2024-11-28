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

                        entries.add(ModItems.POTION_OF_NAUSEA);
                        entries.add(ModItems.POTENT_POTION_OF_NAUSEA);
                        entries.add(ModItems.POTION_OF_SHRINK);
                        entries.add(ModItems.POTION_OF_DWARF);
                        entries.add(ModItems.POTION_OF_SHORTEN);
                        entries.add(ModItems.POTION_OF_FAIRY);
                        entries.add(ModItems.POTION_OF_TALL);
                        entries.add(ModItems.POTION_OF_ENLARGE);
                        entries.add(ModItems.POTION_OF_GIANT);
                        entries.add(ModItems.POTION_OF_GRAVITY);
                        entries.add(ModItems.POTION_OF_ANTI_GRAVITY);
                        entries.add(ModItems.POTION_OF_DISPROPORTION);
                        entries.add(ModItems.POTION_OF_HAPPY_FEET);
                        entries.add(ModItems.CRACKER);

                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEED);

                        entries.add(ModBlocks.DRAGON_PROCESSING_STATION);
                        entries.add(ModBlocks.SIEVING_STATION);
                        entries.add(ModBlocks.FERMENTING_STATION);

                        //season 7 code

                        entries.add(ModItems.RIGHT_RING);
                        entries.add(ModItems.LEFT_RING);
                        entries.add(ModItems.FAKE_ELYTRA);
                        entries.add(ModItems.XP_TANK);

                    }).build());


    public static void registerItemGroups() {
        SilverLight.LOGGER.info("Registering Item Groups for " + SilverLight.MOD_ID);
    }
}
