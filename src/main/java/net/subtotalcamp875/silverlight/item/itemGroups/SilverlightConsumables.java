package net.subtotalcamp875.silverlight.item.itemGroups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.item.ModItems;

public class SilverlightConsumables {
    public static final ItemGroup SILVERLIGHT_CONSUMABLES = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "consumables_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.consumables"))
                    .icon(() -> new ItemStack(ModItems.DRAGON_OMELET)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DRAGON_OMELET);

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

                        entries.add(ModItems.FAKE_BREAD);
                        entries.add(ModItems.COSMIC_BROWNIE);
                        entries.add(ModItems.CHOCOLATE_MILK);
                        entries.add(ModItems.HONEY_CAKE_ON_A_STICK);
                        entries.add(ModItems.MOUTHWASH);
                        entries.add(ModItems.HORN_OF_BRAN_GALED);

                        entries.add(ModItems.LEFT_RING);
                        entries.add(ModItems.RIGHT_RING);
                        entries.add(ModItems.GROUNDED);
                        entries.add(ModItems.SMOKE_BOMB);
                        entries.add(ModItems.SAY10S_CONTRACT);
                        entries.add(ModItems.XP_CHARM);

                    }).build());


    public static void registerConsumablesItemGroups() {
        SilverLight.LOGGER.info("Registering Consumables Item Groups for " + SilverLight.MOD_ID);
    }
}
