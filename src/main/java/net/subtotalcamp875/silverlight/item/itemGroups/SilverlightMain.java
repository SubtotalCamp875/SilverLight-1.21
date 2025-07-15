package net.subtotalcamp875.silverlight.item.itemGroups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.ModItems;

public class SilverlightMain {
    public static final ItemGroup SILVERLIGHT_MAIN = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "main_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.main"))
                    .icon(() -> new ItemStack(ModItems.BACKPACK)).entries((displayContext, entries) -> {

                        entries.add(ModItems.BACKPACK);
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
                        entries.add(ModItems.BEER);
                        entries.add(ModItems.WINE);
                        entries.add(ModItems.OENOBEER);
                        entries.add(ModItems.CRACKER);

                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.STRAWBERRY_SEED);
                        entries.add(ModBlocks.SIEVING_STATION);


                        //season 7 code

                        entries.add(ModItems.BLACK_PAPER);
                        entries.add(ModItems.ZILLOW_ONE);
                        entries.add(ModItems.ZILLOW_FIVE);
                        entries.add(ModItems.ZILLOW_TEN);
                        entries.add(ModItems.ZILLOW_TWENTY);
                        entries.add(ModItems.ZILLOW_HUNDRED);
                        entries.add(ModBlocks.FAKE_DIAMOND_BLOCK);
                        entries.add(ModItems.FAKE_ELYTRA);
                        entries.add(ModItems.FAKE_BREAD);
                        entries.add(ModItems.GOLDEN_APPLE);
                        entries.add(ModItems.COSMIC_BROWNIE);
                        entries.add(ModItems.CHOCOLATE_MILK);
                        entries.add(ModItems.HONEY_CAKE_ON_A_STICK);
                        entries.add(ModItems.MOUTHWASH);
                        entries.add(ModItems.HORN_OF_BRAN_GALED);
                        entries.add(ModItems.CANDY_CANE);
                        entries.add(ModItems.LEFT_RING);
                        entries.add(ModItems.RIGHT_RING);
                        entries.add(ModItems.BLESSED_RING);
                        entries.add(ModItems.AVA);
                        entries.add(ModItems.ELM);
                        entries.add(ModItems.YACKAMAID);
                        entries.add(ModItems.JIMMYLOGZ);
                        entries.add(ModItems.WADDLES);
                        entries.add(ModItems.DEVCAMP);
                        entries.add(ModItems.BITCOIN);
                        entries.add(ModItems.LEECH);
                        entries.add(ModItems.LONG_LEECH);
                        entries.add(ModItems.STRONG_LEECH);
                        entries.add(ModItems.REAPERS_SCYTHE);
                        entries.add(ModItems.MINIGUN_STICK);
                        entries.add(ModItems.THORS_HAMMER);
                        entries.add(ModItems.ARROW_STAFF);
                        entries.add(ModItems.SOUND_STAFF);
                        entries.add(ModItems.DICE_STAFF);
                        entries.add(ModItems.VORTEX_STAFF);
                        entries.add(ModItems.LIGHT_STAFF);
                        entries.add(ModItems.METEOR_STAFF);
                        entries.add(ModItems.EXPLOSION_RAIN_STAFF);
                        entries.add(ModItems.DEATH_STAFF);
                        entries.add(ModItems.DEATHS_DOLL);
                        entries.add(ModItems.DEATHS_BOMB);
                        entries.add(ModItems.SMOKE_BOMB);
                        entries.add(ModItems.VORTEX);
                        entries.add(ModItems.LIGHT_ORB);
                        entries.add(ModItems.AIM_ORB);
                        entries.add(ModItems.LIGHTNING_ORB);
                        entries.add(ModItems.EXPLOSION_RAIN_ORB);
                        entries.add(ModItems.SAY10S_CONTRACT);
                        entries.add(ModItems.SAY10S_CHARM);
                        entries.add(ModItems.HOLY_CHARM);
                        entries.add(ModItems.METEOR_CHARM);
                        entries.add(ModItems.XP_CHARM);
                        entries.add(ModItems.CLOUD_CHARM);
                        entries.add(ModItems.VIBRATION_CHARM);
                        entries.add(ModItems.INFERNO_CHARM);
                        entries.add(ModItems.SCREECHING_CHARM);
                        entries.add(ModItems.VIKING_PATTERN);
                        entries.add(ModItems.VIKING_HORN);
                        entries.add(ModItems.VIKING_AXE);

                        // Season 8

                        entries.add(ModBlocks.MIMIC);
                        entries.add(ModItems.SILVER_TOKEN);


                    }).build());


    public static void registerMainItemGroups() {
        SilverLight.LOGGER.info("Registering Main Item Groups for " + SilverLight.MOD_ID);
    }
}
