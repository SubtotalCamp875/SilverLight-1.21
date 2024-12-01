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
                        entries.add(ModItems.BLACK_HOLE);
                        entries.add(ModItems.STRETCHY_LEATHER);
                        entries.add(ModItems.QUILL);
                        entries.add(ModItems.CANONICAL_BOOK);
                        entries.add(ModBlocks.DRAGON_PROCESSING_STATION);
                        entries.add(ModItems.DRAGON_OMELET);
                        entries.add(ModItems.DRAGON_SCRAP);
                        entries.add(ModItems.BLACK_EGG);
                        entries.add(ModItems.OBSIDIAN_SHEARS);
                        entries.add(ModItems.BURNING_OBSIDIAN_SHEARS);
                        entries.add(ModItems.VOID_OBSIDIAN_SHEARS);

                        entries.add(ModBlocks.FERMENTING_STATION);
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
                        entries.add(ModBlocks.SIEVING_STATION);


                        //season 7 code

                        entries.add(ModBlocks.FAKE_DIAMOND_BLOCK);
                        entries.add(ModItems.FAKE_ELYTRA);
                        entries.add(ModItems.LEFT_RING);
                        entries.add(ModItems.RIGHT_RING);
                        entries.add(ModItems.BLESSED_RING);
                        entries.add(ModItems.XP_TANK);
                        entries.add(ModItems.GROUNDED);
                        entries.add(ModItems.AVA);
                        entries.add(ModItems.YACKAMAID);
                        entries.add(ModItems.BITCOIN);
                        entries.add(ModItems.LEECH);
                        entries.add(ModItems.LONG_LEECH);
                        entries.add(ModItems.STRONG_LEECH);
                        entries.add(ModItems.HOLY_SHIELD_GENERATOR);
                        entries.add(ModItems.REAPERS_SCYTHE);
                        entries.add(ModItems.MINIGUN_STICK);
                        entries.add(ModItems.ARROW_STAFF);
                        entries.add(ModItems.SOUND_STAFF);
                        entries.add(ModItems.DICE_STAFF);
                        entries.add(ModItems.DEATH_STAFF);
                        entries.add(ModItems.DEATHS_DOLL);
                        entries.add(ModItems.DEATHS_BOMB);
                        entries.add(ModItems.HORN_OF_BRAN_GALED);
                        entries.add(ModItems.LIGHTNING_ORB);
                        entries.add(ModItems.THORS_HAMMER);
                        entries.add(ModItems.CANDY_CANE);
                        entries.add(ModItems.SAY10S_CONTRACT);
                        entries.add(ModItems.SAY10S_CHARM);

                    }).build());


    public static void registerItemGroups() {
        SilverLight.LOGGER.info("Registering Item Groups for " + SilverLight.MOD_ID);
    }
}
