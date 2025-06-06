package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.block.custom.StrawberryPlantBlock;
import net.subtotalcamp875.silverlight.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_PLANT, StrawberryPlantBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerSimpleState(ModBlocks.DRAGON_PROCESSING_STATION);
        blockStateModelGenerator.registerSimpleState(ModBlocks.SIEVING_STATION);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FERMENTING_STATION);
        blockStateModelGenerator.registerSimpleState(ModBlocks.CHARGE_GENERATOR);
        blockStateModelGenerator.registerSimpleState(ModBlocks.MIMIC);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FAKE_DIAMOND_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_HOLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRETCHY_LEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUILL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANONICAL_BOOK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_OMELET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNING_OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_OBSIDIAN_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_NAUSEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTENT_POTION_OF_NAUSEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_SHRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_DWARF, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_SHORTEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_FAIRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_TALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_ENLARGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_GIANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_GRAVITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_ANTI_GRAVITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_DISPROPORTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.POTION_OF_HAPPY_FEET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRACKER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);

        // season 7 code

        itemModelGenerator.register(ModItems.RIGHT_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEFT_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLESSED_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.FAKE_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.XP_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GROUNDED, Models.GENERATED);
        itemModelGenerator.register(ModItems.REAPERS_SCYTHE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YACKAMAID, Models.GENERATED);
        itemModelGenerator.register(ModItems.BITCOIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEECH, Models.GENERATED);
        itemModelGenerator.register(ModItems.LONG_LEECH, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRONG_LEECH, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOLY_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINIGUN_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARROW_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DICE_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.VORTEX_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.VORTEX, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHT_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.AIM_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPLOSION_RAIN_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.EXPLOSION_RAIN_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATH_STAFF, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATHS_DOLL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEATHS_BOMB, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.THORS_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANDY_CANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAY10S_CONTRACT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAY10S_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOUTHWASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOUD_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRATION_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_PAPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COSMIC_BROWNIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FAKE_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HONEY_CAKE_ON_A_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIKING_PATTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_MILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZILLOW_ONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZILLOW_FIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZILLOW_TEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZILLOW_TWENTY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZILLOW_HUNDRED, Models.GENERATED);
        itemModelGenerator.register(ModItems.METEOR_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCREECHING_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOKE_BOMB, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFERNO_CHARM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OENOBEER, Models.GENERATED);

        //season 8

        itemModelGenerator.register(ModItems.MYSTERIOUS_COMPASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACTIVATED_MYSTERIOUS_COMPASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOAP_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGY_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLUMPED_ENERGY_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGY_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.INKWISP, Models.GENERATED);
        itemModelGenerator.register(ModItems.INKLING, Models.GENERATED);
        itemModelGenerator.register(ModItems.INKSHADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INKLOOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.INKVOID, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEAK_MYSTERIOUS_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTERIOUS_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTALLIZED_MYSTERIOUS_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARGED_CRYSTAL, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHARGED_CRYSTAL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHARGED_CRYSTAL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHARGED_CRYSTAL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHARGED_CRYSTAL_BOOTS));
    }
}