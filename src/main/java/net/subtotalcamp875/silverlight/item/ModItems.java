package net.subtotalcamp875.silverlight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.custom.charms.*;
import net.subtotalcamp875.silverlight.item.custom.leeches.LeechItem;
import net.subtotalcamp875.silverlight.item.custom.leeches.LongLeechItem;
import net.subtotalcamp875.silverlight.item.custom.leeches.StrongLeechItem;
import net.subtotalcamp875.silverlight.item.custom.misc.*;
import net.subtotalcamp875.silverlight.item.custom.playerItems.*;
import net.subtotalcamp875.silverlight.item.custom.staffs.*;

import java.util.List;

public class ModItems {
    public static final Item BACKPACK = registerItem("backpack", new BackpackItem(new Item.Settings().maxCount(1)));
    public static final Item BLACK_HOLE = registerItem("black_hole", new BlackHoleItem(new Item.Settings().maxCount(1)));

    public static final Item STRETCHY_LEATHER = registerItem("stretchy_leather", new Item(new Item.Settings()));
    public static final Item QUILL = registerItem("quill", new Item(new Item.Settings()));
    public static final Item CANONICAL_BOOK = registerItem("canonical_book", new Item(new Item.Settings().maxCount(1)));
    public static final Item DRAGON_OMELET = registerItem("dragon_omelet", new Item(new Item.Settings().food(ModFoodComponents.DRAGON_OMELET)));
    public static final Item DRAGON_SCRAP = registerItem("dragon_scrap", new Item(new Item.Settings()));
    public static final Item BLACK_EGG = registerItem("black_egg", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_SHEARS = registerItem("obsidian_shears", new Item(new Item.Settings().maxDamage(64)));
    public static final Item BURNING_OBSIDIAN_SHEARS = registerItem("burning_obsidian_shears", new Item(new Item.Settings().maxDamage(64)));
    public static final Item VOID_OBSIDIAN_SHEARS = registerItem("void_obsidian_shears", new Item(new Item.Settings().maxDamage(64)));



    public static final Item POTION_OF_NAUSEA = registerItem("potion_of_nausea", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_NAUSEA).maxCount(16)));
    public static final Item POTENT_POTION_OF_NAUSEA = registerItem("potent_potion_of_nausea", new Item(new Item.Settings().food(ModFoodComponents.POTENT_POTION_OF_NAUSEA).maxCount(16)));
    public static final Item POTION_OF_SHRINK = registerItem("potion_of_shrink", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_SHRINK).maxCount(16)));
    public static final Item POTION_OF_DWARF = registerItem("potion_of_dwarf", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_DWARF).maxCount(16)));
    public static final Item POTION_OF_SHORTEN = registerItem("potion_of_shorten", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_SHORTEN).maxCount(16)));
    public static final Item POTION_OF_FAIRY = registerItem("potion_of_fairy", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_FAIRY).maxCount(16)));
    public static final Item POTION_OF_TALL = registerItem("potion_of_tall", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_TALL).maxCount(16)));
    public static final Item POTION_OF_ENLARGE = registerItem("potion_of_enlarge", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_ENLARGE).maxCount(16)));
    public static final Item POTION_OF_GIANT = registerItem("potion_of_giant", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_GIANT).maxCount(16)));
    public static final Item POTION_OF_GRAVITY = registerItem("potion_of_gravity", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_GRAVITY).maxCount(16)));
    public static final Item POTION_OF_ANTI_GRAVITY = registerItem("potion_of_anti_gravity", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_ANTI_GRAVITY).maxCount(16)));
    public static final Item POTION_OF_DISPROPORTION = registerItem("potion_of_disproportion", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_DISPROPORTION).maxCount(16)));
    public static final Item POTION_OF_HAPPY_FEET = registerItem("potion_of_happy_feet", new Item(new Item.Settings().food(ModFoodComponents.POTION_OF_HAPPY_FEET).maxCount(16)));
    public static final Item CRACKER = registerItem("cracker", new Item(new Item.Settings().food(ModFoodComponents.CRACKER).maxCount(64)));

    public static final Item STRAWBERRY_SEED = registerItem("strawberry_seed",
            new AliasedBlockItem(ModBlocks.STRAWBERRY_PLANT, new Item.Settings()));
    public static final Item STRAWBERRY = registerItem("strawberry",
            new StrawberryItem(new Item.Settings()));

    //season 7 code starts here

    public static final Item RIGHT_RING = registerItem("right_ring", new RightRingItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.right_ring.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);

        }
    });
    public static final Item LEFT_RING = registerItem("left_ring", new Item(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.right_ring.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item BLESSED_RING = registerItem("blessed_ring", new BlessedRingItem(new Item.Settings().maxCount(1).maxDamage(3456000)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item FAKE_ELYTRA = registerItem("fake_elytra", new Item(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.fake_elytra.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item XP_CHARM = registerItem("xp_charm", new XPCharmItem(new Item.Settings().maxCount(1).maxDamage(1125)));
    public static final Item GROUNDED = registerItem("grounded", new GroundedItem(new Item.Settings().maxCount(1).maxDamage(16)));
    public static final Item AVA = registerItem("ava", new AvaItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.ava.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item YACKAMAID = registerItem("yackamaid", new YackaMaidItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.yackamaid.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item JIMMYLOGZ = registerItem("jimmylogz", new JimmyLogzItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.jimmylogz.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item WADDLES = registerItem("waddles", new WaddlesItem(new Item.Settings().maxCount(1).maxDamage(1)));
    public static final Item DEVCAMP = registerItem("dev_camp", new DevCampItem(new Item.Settings().maxCount(1).maxDamage(2)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.dev_camp.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item BITCOIN = registerItem("bitcoin", new Item(new Item.Settings()));
    public static final Item LEECH = registerItem("leech", new LeechItem(new Item.Settings().maxDamage(3600).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.leech.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item LONG_LEECH = registerItem("long_leech", new LongLeechItem(new Item.Settings().maxDamage(7200).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.long_leech.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item STRONG_LEECH = registerItem("strong_leech", new StrongLeechItem(new Item.Settings().maxDamage(7200).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.strong_leech.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item HOLY_CHARM = registerItem("holy_charm", new HolyCharmItem(new Item.Settings().maxDamage(28800).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.holy_charm.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.holy_charm.tooltip1"));
            tooltip.add(Text.translatable("tooltip.silverlight.holy_charm.tooltip2"));
            tooltip.add(Text.translatable("tooltip.silverlight.holy_charm.tooltip3"));
            tooltip.add(Text.translatable("tooltip.silverlight.holy_charm.tooltip4"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item ARROW_STAFF = registerItem("arrow_staff", new ArrowStaffItem(new Item.Settings().maxDamage(100).maxCount(1)));

    public static final Item REAPERS_SCYTHE = registerItem("reapers_scythe",
            new SwordItem(ModToolMaterials.REAPERS_SCYTHE_MATERIAL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.REAPERS_SCYTHE_MATERIAL, 1998, 0f))){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.reapers_scythe.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.reapers_scythe1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);

        }
    });

    public static final Item MINIGUN_STICK = registerItem("minigun_stick",
            new SwordItem(ModToolMaterials.MINIGUN_STICK_MATERIAL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MINIGUN_STICK_MATERIAL, 2, 1000f))));

    public static final Item SOUND_STAFF = registerItem("sound_staff", new SoundStaffItem(new Item.Settings().maxCount(1).maxDamage(5)));
    public static final Item DICE_STAFF = registerItem("dice_staff", new DiceStaffItem(new Item.Settings().maxCount(1).maxDamage(64)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.dice_staff.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item VORTEX_STAFF = registerItem("vortex_staff", new VortexStaffItem(new Item.Settings().maxCount(1).maxDamage(10)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item VORTEX = registerItem("vortex", new Item(new Item.Settings()));
    public static final Item LIGHT_STAFF = registerItem("light_staff", new LightStaffItem(new Item.Settings().maxDamage(1500).maxCount(1)));
    public static final Item LIGHT_ORB = registerItem("light_orb", new Item(new Item.Settings()));
    public static final Item AIM_ORB = registerItem("aim_orb", new Item(new Item.Settings()));
    public static final Item METEOR_STAFF = registerItem("meteor_staff", new MeteorStaffItem(new Item.Settings().maxDamage(500).maxCount(1)));
    public static final Item DEATH_STAFF = registerItem("death_staff", new DeathStaffItem(new Item.Settings().maxCount(1).maxDamage(100)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.death_staff.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item DEATHS_DOLL = registerItem("deaths_doll", new DeathsDollItem(new Item.Settings().maxCount(1).maxDamage(10)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item DEATHS_BOMB = registerItem("deaths_bomb", new DeathsBombItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item HORN_OF_BRAN_GALED = registerItem("horn_of_bran_galed", new HornOfBranGaledItem(new Item.Settings().maxCount(1)));
    public static final Item LIGHTNING_ORB = registerItem("lightning_orb", new Item(new Item.Settings()));
    public static final Item THORS_HAMMER = registerItem("thors_hammer", new ThorsHammer(ModToolMaterials.THORS_HAMMER_MATERIAL, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.THORS_HAMMER_MATERIAL, 8, -3.2f))){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.thors_hammer.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item CANDY_CANE = registerItem("candy_cane", new CandyCaneItem(ModToolMaterials.CANDY_CANE_MATERIAL, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CANDY_CANE_MATERIAL, 0, -3f))));
    public static final Item SAY10S_CONTRACT = registerItem("say10s_contract", new Say10sContractItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.say10s_contract.tooltip"));

            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SAY10S_CHARM = registerItem("say10s_charm", new Say10sCharmItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.say10s_charm.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item MOUTHWASH = registerItem("mouthwash", new Item(new Item.Settings().food(ModFoodComponents.MOUTHWASH).maxCount(100)));
    public static final Item BLACK_PAPER = registerItem("black_paper", new Item(new Item.Settings()));
    public static final Item CLOUD_CHARM = registerItem("cloud_charm", new CloudCharm(new Item.Settings().maxCount(1)));
    public static final Item VIBRATION_CHARM = registerItem("vibration_charm", new VibrationCharm(new Item.Settings().maxCount(1)));
    public static final Item COSMIC_BROWNIE = registerItem("cosmic_brownie", new Item(new Item.Settings().food(ModFoodComponents.COSMIC_BROWNIE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item FAKE_BREAD = registerItem("fake_bread", new Item(new Item.Settings().food(ModFoodComponents.FAKE_BREAD)));
    public static final Item HONEY_CAKE_ON_A_STICK = registerItem("honey_cake_on_a_stick", new Item(new Item.Settings().food(ModFoodComponents.HONEY_CAKE).maxCount(1)));
    public static final Item VIKING_HORN = registerItem("viking_horn", new VikingHornItem(new Item.Settings().maxCount(1)));
    public static final Item VIKING_PATTERN = registerItem("viking_pattern", new Item(new Item.Settings()));
    public static final Item VIKING_AXE = registerItem("viking_axe",
            new SwordItem(ModToolMaterials.VIKING_AXE_MATERIAL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VIKING_AXE_MATERIAL, 10, -3f))));
    public static final Item CHOCOLATE_MILK = registerItem("chocolate_milk", new Item(new Item.Settings().food(ModFoodComponents.CHOCOLATE_MILK)));
    public static final Item ZILLOW_ONE = registerItem("zillow_one", new Item(new Item.Settings().maxCount(50)));
    public static final Item ZILLOW_FIVE = registerItem("zillow_five", new Item(new Item.Settings().maxCount(50)));
    public static final Item ZILLOW_TEN = registerItem("zillow_ten", new Item(new Item.Settings().maxCount(50)));
    public static final Item ZILLOW_TWENTY = registerItem("zillow_twenty", new Item(new Item.Settings().maxCount(50)));
    public static final Item ZILLOW_HUNDRED = registerItem("zillow_hundred", new Item(new Item.Settings().maxCount(50)));
    public static final Item METEOR_CHARM = registerItem("meteor_charm", new MeteorCharmItem(new Item.Settings().maxCount(1)));
    public static final Item SCREECHING_CHARM = registerItem("screeching_charm", new ScreechingCharmItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SMOKE_BOMB = registerItem("smoke_bomb", new SmokeBombItem(new Item.Settings()));
    public static final Item INFERNO_CHARM = registerItem("inferno_charm", new InfernoCharmItem(new Item.Settings().maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item BEER = registerItem("beer", new Item(new Item.Settings().food(ModFoodComponents.BEER).maxCount(16)));
    public static final Item WINE = registerItem("wine", new Item(new Item.Settings().food(ModFoodComponents.WINE).maxCount(16)));
    public static final Item OENOBEER = registerItem("oenobeer", new Item(new Item.Settings().food(ModFoodComponents.OENOBEER).maxCount(16)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SilverLight.LOGGER.info("Registering Mod Items for " + SilverLight.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
