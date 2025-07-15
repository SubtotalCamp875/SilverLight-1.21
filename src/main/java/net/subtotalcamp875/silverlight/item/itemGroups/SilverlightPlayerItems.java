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

public class SilverlightPlayerItems {
    public static final ItemGroup SILVERLIGHT_PLAYER_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "player_items_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.player_items"))
                    .icon(() -> new ItemStack(ModItems.DEVCAMP)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DRAGON_OMELET);

                        entries.add(ModItems.MOUTHWASH);
                        entries.add(ModItems.AVA);
                        entries.add(ModItems.POTION_OF_HAPPY_FEET);
                        entries.add(ModItems.ELM);
                        entries.add(ModItems.YACKAMAID);
                        entries.add(ModItems.JIMMYLOGZ);
                        entries.add(ModItems.WADDLES);
                        entries.add(ModItems.SOUND_STAFF);
                        entries.add(ModItems.DEVCAMP);
                        entries.add(ModItems.VIKING_AXE);
                        entries.add(ModItems.VIKING_HORN);

                    }).build());


    public static void registerPlayerItemsItemGroups() {
        SilverLight.LOGGER.info("Registering Player Items Item Groups for " + SilverLight.MOD_ID);
    }
}
