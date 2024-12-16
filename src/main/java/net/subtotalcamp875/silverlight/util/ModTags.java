package net.subtotalcamp875.silverlight.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> REAPERS_SCYTHE_MATERIAL = createTag("reapers_scythe_material");
        public static final TagKey<Block> MINIGUN_STICK_MATERIAL = createTag("minigun_stick_material");
        public static final TagKey<Block> VIKING_AXE_MATERIAL = createTag("viking_axe_material");
        public static final TagKey<Block> THORS_HAMMER_MATERIAL = createTag("thors_hammer_material");
        public static final TagKey<Block> CANDY_CANE_MATERIAL = createTag("candy_cane_material");

        private static TagKey<net.minecraft.block.Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SilverLight.MOD_ID, name));
        }
    }

    public static class Items {
        private static final TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SilverLight.MOD_ID, name));
        }
    }


}
