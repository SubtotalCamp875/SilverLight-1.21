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

public class SilverlightStaffs {
    public static final ItemGroup SILVERLIGHT_STAFF = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SilverLight.MOD_ID, "staffs_item_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.staffs"))
                    .icon(() -> new ItemStack(ModItems.VORTEX_STAFF)).entries((displayContext, entries) -> {
                        entries.add(ModItems.THORS_HAMMER);
                        entries.add(ModItems.ARROW_STAFF);
                        entries.add(ModItems.SOUND_STAFF);
                        entries.add(ModItems.DICE_STAFF);
                        entries.add(ModItems.VORTEX_STAFF);
                        entries.add(ModItems.LIGHT_STAFF);
                        entries.add(ModItems.METEOR_STAFF);
                        entries.add(ModItems.DEATH_STAFF);
                        entries.add(ModItems.DEATHS_DOLL);
                        entries.add(ModItems.DEATHS_BOMB);
                        entries.add(ModItems.VORTEX);
                        entries.add(ModItems.LIGHT_ORB);
                        entries.add(ModItems.AIM_ORB);
                        entries.add(ModItems.LIGHTNING_ORB);

                    }).build());


    public static void registerStaffsItemGroups() {
        SilverLight.LOGGER.info("Registering Staffs Item Groups for " + SilverLight.MOD_ID);
    }
}
