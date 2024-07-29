package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        boolean isBlackhole = true;
        boolean isNotBlockhole = true;
        boolean isMainBlackholeItems = true;
        boolean isCondensedBlocks = true;
        boolean isCondensedItem = true;

        if (isNotBlockhole) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BACKPACK, 1)
                    .pattern("STS")
                    .pattern("BCB")
                    .pattern("LLL")
                    .input('S', ModItems.STRETCHY_LEATHER)
                    .input('C', Items.CHEST)
                    .input('T', Items.TRIPWIRE_HOOK)
                    .input('L', Items.LEATHER)
                    .input('B', ModItems.CANONICAL_BOOK)
                    .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BACKPACK)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRETCHY_LEATHER, 1)
                    .pattern("SL")
                    .pattern("R ")
                    .input('S', Items.SLIME_BALL)
                    .input('L', Items.LEATHER)
                    .input('R', Items.RABBIT_HIDE)
                    .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.STRETCHY_LEATHER)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CANONICAL_BOOK, 1)
                    .pattern("BQ")
                    .input('Q', ModItems.QUILL)
                    .input('B', Items.WRITABLE_BOOK)
                    .criterion(hasItem(Items.WRITABLE_BOOK), conditionsFromItem(Items.WRITABLE_BOOK))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CANONICAL_BOOK)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.QUILL, 7)
                    .pattern("FFF")
                    .pattern("FSF")
                    .pattern("FBF")
                    .input('S', Items.INK_SAC)
                    .input('F', Items.FEATHER)
                    .input('B', Items.BLUE_DYE)
                    .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUILL)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DRAGON_OMELET, 1)
                    .pattern("C")
                    .pattern("D")
                    .pattern("B")
                    .input('C', Items.CHORUS_FRUIT)
                    .input('D', ModItems.DRAGON_SCRAP)
                    .input('B', Items.BLAZE_POWDER)
                    .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.DRAGON_OMELET)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_EGG, 1)
                    .pattern("EDE")
                    .pattern("S#S")
                    .pattern("CCC")
                    .input('E', Items.ENDER_EYE)
                    .input('D', Items.BLACK_DYE)
                    .input('S', Items.SHULKER_SHELL)
                    .input('#', Items.EGG)
                    .input('C', Items.END_CRYSTAL)
                    .criterion(hasItem(Items.DRAGON_HEAD), conditionsFromItem(Items.DRAGON_HEAD))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BLACK_EGG)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OBSIDIAN_SHEARS, 1)
                    .pattern(" O")
                    .pattern("OI")
                    .pattern("I ")
                    .input('I', Items.IRON_INGOT)
                    .input('O', Items.OBSIDIAN)
                    .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OBSIDIAN_SHEARS)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BURNING_OBSIDIAN_SHEARS, 1)
                    .pattern("BSB")
                    .pattern("BOB")
                    .pattern("BLB")
                    .input('O', ModItems.OBSIDIAN_SHEARS)
                    .input('B', Items.BLAZE_ROD)
                    .input('L', Items.LAVA_BUCKET)
                    .input('S', Items.SUGAR)
                    .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BURNING_OBSIDIAN_SHEARS)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VOID_OBSIDIAN_SHEARS, 1)
                    .pattern(" SE")
                    .pattern("SCB")
                    .pattern("EB ")
                    .input('S', Items.SHULKER_SHELL)
                    .input('B', ModItems.BURNING_OBSIDIAN_SHEARS)
                    .input('E', Items.ENDER_EYE)
                    .input('C', Items.END_CRYSTAL)
                    .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.VOID_OBSIDIAN_SHEARS)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DRAGON_PROCESSING_STATION, 1)
                    .pattern("OCO")
                    .pattern("S S")
                    .input('C', Items.STONECUTTER)
                    .input('S', Items.SMOOTH_STONE)
                    .input('O', Items.OBSIDIAN)
                    .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.DRAGON_PROCESSING_STATION)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SIEVING_STATION, 1)
                    .pattern("CSC")
                    .pattern("W W")
                    .input('C', Items.SMOOTH_STONE)
                    .input('S', Items.STRING)
                    .input('W', Items.ANDESITE_WALL)
                    .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.SIEVING_STATION)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FERMENTING_STATION, 1)
                    .pattern("S")
                    .pattern("B")
                    .input('B', Items.BARREL)
                    .input('S', Items.BREWING_STAND)
                    .criterion(hasItem(Items.BARREL), conditionsFromItem(Items.BARREL))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FERMENTING_STATION)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SEED, 1)
                    .pattern("T")
                    .input('T', ModItems.TOMATO)
                    .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.TOMATO_SEED)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRACKER, 3)
                    .pattern("B")
                    .input('B', Items.BREAD)
                    .criterion(hasItem(ModItems.CRACKER), conditionsFromItem(ModItems.CRACKER))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CRACKER)));
        }
/**
         if (isBlackhole) {
         if (isMainBlackholeItems) {
         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLACK_HOLE, 1)
         .pattern(" W ")
         .pattern("AOA")
         .pattern(" M ")
         .input('W', ModItems.WINGS_OF_THE_END)
         .input('A', ModItems.ANTI_MATTER)
         .input('O', ModItems.OMNI_CORE)
         .input('M', ModItems.MECHANICAL_MACHINE)
         .criterion(hasItem(ModItems.BLACK_HOLE), conditionsFromItem(ModItems.BLACK_HOLE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BLACK_HOLE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ANTI_MATTER, 1)
         .pattern(" C ")
         .pattern("CLC")
         .pattern(" C ")
         .input('C', ModItems.CORRUPTED_ESSENCE)
         .input('L', ModItems.LIFE_CORE)
         .criterion(hasItem(ModItems.ANTI_MATTER), conditionsFromItem(ModItems.ANTI_MATTER))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ANTI_MATTER)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LIFE_CORE, 1)
         .pattern("XZX")
         .pattern("CNS")
         .pattern("WWW")
         .input('X', ModItems.QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE)
         .input('N', Items.NETHER_STAR)
         .input('Z', Items.ZOMBIE_HEAD)
         .input('C', Items.CREEPER_HEAD)
         .input('S', Items.SKELETON_SKULL)
         .input('W', Items.WITHER_SKELETON_SKULL)
         .criterion(hasItem(ModItems.LIFE_CORE), conditionsFromItem(ModItems.LIFE_CORE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LIFE_CORE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CORRUPTED_ESSENCE, 1)
         .pattern(" S ")
         .pattern("SBS")
         .pattern(" S ")
         .input('S', ModBlocks.DOUBLE_CONDENSED_SCULK)
         .input('B', ModItems.DOUBLE_CONDENSED_BLAZE_ROD)
         .criterion(hasItem(ModItems.CORRUPTED_ESSENCE), conditionsFromItem(ModItems.CORRUPTED_ESSENCE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CORRUPTED_ESSENCE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WINGS_OF_THE_END, 1)
         .pattern("FDF")
         .pattern("SES")
         .pattern("GBM")
         .input('F', ModItems.QUADRUPLE_CONDENSED_FIREWORK_ROCKET)
         .input('D', ModItems.DOUBLE_CONDENSED_DRAGON_HEAD)
         .input('S', ModItems.TRIPLE_CONDENSED_SHULKER_SHELL)
         .input('E', ModItems.DOUBLE_CONDENSED_ELYTRA)
         .input('G', ModItems.TRIPLE_CONDENSED_GHAST_TEAR)
         .input('B', ModItems.QUADRUPLE_CONDENSED_BLAZE_ROD)
         .input('M', ModItems.TRIPLE_CONDENSED_PHANTOM_MEMBRANE)
         .criterion(hasItem(ModItems.WINGS_OF_THE_END), conditionsFromItem(ModItems.WINGS_OF_THE_END))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WINGS_OF_THE_END)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OMNI_CORE, 1)
         .pattern(" O ")
         .pattern("NDE")
         .pattern(" L ")
         .input('O', ModItems.OVERWORLD_CORE)
         .input('N', ModItems.NETHER_CORE)
         .input('D', ModItems.DESTRUCTIVE_CORE)
         .input('E', ModItems.END_CORE)
         .input('L', ModItems.CORE_OF_LIGHT)
         .criterion(hasItem(ModItems.OMNI_CORE), conditionsFromItem(ModItems.OMNI_CORE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OMNI_CORE)));

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_NETHER_STAR, RecipeCategory.MISC, ModItems.DESTRUCTIVE_CORE, "_from_destructive_core", "destructive_core");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.NETHER_STAR, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_NETHER_STAR, "_from_mod_nether_star", "mod_nether_star");

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OVERWORLD_CORE, 1)
         .pattern("STS")
         .pattern("DND")
         .pattern("GTG")
         .input('S', ModBlocks.QUADRUPLE_CONDENSED_SAND)
         .input('T', ModBlocks.QUADRUPLE_CONDENSED_STONE)
         .input('D', ModBlocks.QUADRUPLE_CONDENSED_DIRT)
         .input('N', Items.NETHER_STAR)
         .input('G', ModBlocks.QUADRUPLE_CONDENSED_GRAVEL)
         .criterion(hasItem(ModItems.OVERWORLD_CORE), conditionsFromItem(ModItems.OVERWORLD_CORE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OVERWORLD_CORE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_CORE, 1)
         .pattern("SWS")
         .pattern("RNR")
         .pattern("MWM")
         .input('S', ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND)
         .input('W', ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK)
         .input('R', ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK)
         .input('N', Items.NETHER_STAR)
         .input('M', ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK)
         .criterion(hasItem(ModItems.NETHER_CORE), conditionsFromItem(ModItems.NETHER_CORE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.NETHER_CORE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.END_CORE, 1)
         .pattern("OPO")
         .pattern("ENE")
         .pattern("CPC")
         .input('O', ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN)
         .input('P', ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK)
         .input('E', ModBlocks.QUADRUPLE_CONDENSED_END_STONE)
         .input('N', Items.NETHER_STAR)
         .input('C', ModItems.QUADRUPLE_CONDENSED_CHORUS_FRUIT)
         .criterion(hasItem(ModItems.NETHER_CORE), conditionsFromItem(ModItems.NETHER_CORE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.END_CORE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CORE_OF_LIGHT, 1)
         .pattern("RTC")
         .pattern("GNE")
         .pattern("FLS")
         .input('R', ModBlocks.DOUBLE_CONDENSED_PEARLESCENT_FROGLIGHT)
         .input('T', ModItems.QUADRUPLE_CONDENSED_TORCH)
         .input('C', ModBlocks.DOUBLE_CONDENSED_CRYING_OBSIDIAN)
         .input('G', ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE)
         .input('N', Items.NETHER_STAR)
         .input('E', ModBlocks.QUADRUPLE_CONDENSED_COPPER_BULB)
         .input('L', ModItems.QUADRUPLE_CONDENSED_LANTERN)
         .input('F', ModBlocks.DOUBLE_CONDENSED_SHROOMLIGHT)
         .input('S', ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN)
         .criterion(hasItem(ModItems.CORE_OF_LIGHT), conditionsFromItem(ModItems.CORE_OF_LIGHT))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CORE_OF_LIGHT)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MECHANICAL_MACHINE, 1)
         .pattern("RSR")
         .pattern("SPS")
         .pattern("RSR")
         .input('S', ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK)
         .input('R', ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK)
         .input('P', ModItems.MULTI_PISTON)
         .criterion(hasItem(ModItems.MECHANICAL_MACHINE), conditionsFromItem(ModItems.MECHANICAL_MACHINE))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.MECHANICAL_MACHINE)));

         ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MULTI_PISTON, 1)
         .pattern("III")
         .pattern("RCR")
         .pattern("SDS")
         .input('I', ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK)
         .input('D', ModBlocks.TRIPLE_CONDENSED_DIAMOND_BLOCK)
         .input('C', ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK)
         .input('R', ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK)
         .input('S', ModBlocks.QUADRUPLE_CONDENSED_STONE)
         .criterion(hasItem(ModItems.MULTI_PISTON), conditionsFromItem(ModItems.MULTI_PISTON))
         .offerTo(exporter, Identifier.of(getRecipeName(ModItems.MULTI_PISTON)));
         }

         if (isCondensedItem) {
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE, "_from_single_condensed_experience_bottle", "single_condensed_experience_bottle");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET, "_from_single_condensed_firework_rocket", "single_condensed_firework_rocket");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_BLAZE_ROD, "_from_single_condensed_blaze_rod", "single_condensed_blaze_rod");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.CHORUS_FRUIT, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_CHORUS_FRUIT, "_from_single_condensed_chorus_fruit", "single_condensed_chorus_fruit");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SHULKER_SHELL, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_SHULKER_SHELL, "_from_single_condensed_shulker_shell", "single_condensed_shulker_shell");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.GHAST_TEAR, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_GHAST_TEAR, "_from_single_condensed_ghast_tear", "single_condensed_ghast_tear");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE, "_from_single_condensed_phantom_membrane", "single_condensed_phantom_membrane");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.DRAGON_HEAD, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_DRAGON_HEAD, "_from_single_condensed_dragon_head", "single_condensed_dragon_head");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.LANTERN, RecipeCategory.MISC,  ModItems.SINGLE_CONDENSED_LANTERN, "_from_single_condensed_lantern", "single_condensed_lantern");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.TORCH, RecipeCategory.MISC,  ModItems.SINGLE_CONDENSED_TORCH, "_from_single_condensed_torch", "single_condensed_torch");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_EXPERIENCE_BOTTLE, "_from_double_condensed_experience_bottle", "double_condensed_experience_bottle");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET, "_from_double_condensed_firework_rocket", "double_condensed_firework_rocket");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_BLAZE_ROD, "_from_double_condensed_blaze_rod", "double_condensed_blaze_rod");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT, "_from_double_condensed_chorus_fruit", "double_condensed_chorus_fruit");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_SHULKER_SHELL, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_SHULKER_SHELL,"_from_double_condensed_shulker_shell", "double_condensed_shulker_shell");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_GHAST_TEAR, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_GHAST_TEAR, "_from_double_condensed_ghast_tear", "double_condensed_ghast_tear");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE, "_from_double_condensed_phantom_membrane", "double_condensed_phantom_membrane");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_ELYTRA, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_ELYTRA, "_from_double_condensed_elytra", "double_condensed_elytra");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_DRAGON_HEAD, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_DRAGON_HEAD, "_from_double_condensed_dragon_head", "double_condensed_dragon_head");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_LANTERN, RecipeCategory.MISC,  ModItems.DOUBLE_CONDENSED_LANTERN, "_from_double_condensed_lantern", "double_condensed_lantern");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_TORCH, RecipeCategory.MISC,  ModItems.DOUBLE_CONDENSED_TORCH, "_from_double_condensed_torch", "double_condensed_torch");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE, "_from_triple_condensed_experience_bottle", "triple_condensed_experience_bottle");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET, "_from_triple_condensed_firework_rocket", "triple_condensed_firework_rocket");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_BLAZE_ROD, "_from_triple_condensed_blaze_rod", "triple_condensed_blaze_rod");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT, "_from_triple_condensed_chorus_fruit", "triple_condensed_chorus_fruit");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_SHULKER_SHELL, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_SHULKER_SHELL, "_from_triple_condensed_shulker_shell", "triple_condensed_shulker_shell");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_GHAST_TEAR, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_GHAST_TEAR, "_from_triple_condensed_ghast_tear", "triple_condensed_ghast_tear");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_PHANTOM_MEMBRANE, "_from_triple_condensed_phantom_membrane", "triple_condensed_phantom_membrane");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_TORCH, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_TORCH, "_from_triple_condensed_torch", "triple_condensed_torch");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_LANTERN, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_LANTERN, "_from_triple_condensed_lantern", "triple_condensed_lantern");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE, "_from_quadruple_condensed_experience_bottle", "quadruple_condensed_experience_bottle");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_FIREWORK_ROCKET, "_from_quadruple_condensed_firework_rocket", "quadruple_condensed_firework_rocket");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_BLAZE_ROD, "_from_quadruple_condensed_blaze_rod", "quadruple_condensed_blaze_rod");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_CHORUS_FRUIT, "_from_quadruple_condensed_chorus_fruit", "quadruple_condensed_chorus_fruit");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_TORCH, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_TORCH, "_from_quadruple_condensed_torch", "quadruple_condensed_torch");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_LANTERN, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_LANTERN, "_from_quadruple_condensed_lantern", "quadruple_condensed_lantern");
         }

         if (isCondensedBlocks) {
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SAND, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SAND, "_from_single_condensed_sand", "single_condensed_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.DIRT, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_DIRT, "_from_single_condensed_dirt", "single_condensed_dirt");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.STONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_STONE, "_from_single_condensed_stone", "single_condensed_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.GRAVEL, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_GRAVEL, "_from_single_condensed_gravel", "single_condensed_gravel");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SOUL_SAND, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SOUL_SAND, "_from_single_condensed_soul_sand", "single_condensed_soul_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.NETHERRACK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_NETHERRACK, "_from_single_condensed_netherrack", "single_condensed_netherrack");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK, "_from_single_condensed_magma_block", "single_condensed_magma_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK, "_from_single_condensed_nether_wart_block", "single_condensed_nether_wart_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.OBSIDIAN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_OBSIDIAN, "_from_single_condensed_obsidian", "single_condensed_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK, "_from_single_condensed_purpur_block", "single_condensed_purpur_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.END_STONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_END_STONE, "_from_single_condensed_end_stone", "single_condensed_end_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.GLOWSTONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_GLOWSTONE, "_from_single_condensed_glow_stone", "single_condensed_glow_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.PEARLESCENT_FROGLIGHT, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_PEARLESCENT_FROGLIGHT, "_from_single_condensed_pearlescent_froglight", "single_condensed_pearlescent_froglight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.CRYING_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_CRYING_OBSIDIAN, "_from_single_condensed_crying_obsidian", "single_condensed_crying_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SHROOMLIGHT, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SHROOMLIGHT, "_from_single_condensed_shroomlight", "single_condensed_shroomlight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK, "_from_single_condensed_copper_block", "single_condensed_copper_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SLIME_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK, "_from_single_condensed_slime_block", "single_condensed_slime_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK, "_from_single_condensed_redstone_block", "single_condensed_redstone_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_IRON_BLOCK, "_from_single_condensed_iron_block", "single_condensed_iron_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SEA_LANTERN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SEA_LANTERN, "_from_single_condensed_sea_lantern", "single_condensed_sea_lantern");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.SCULK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SCULK, "_from_single_condensed_sculk", "single_condensed_sculk");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.COPPER_BULB, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_COPPER_BULB, "_from_single_condensed_copper_bulb", "single_condensed_copper_bulb");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, Items.DIAMOND_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_DIAMOND_BLOCK, "_from_single_condensed_diamond_block", "single_condensed_diamond_block");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SAND, "_from_double_condensed_sand", "double_condensed_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_DIRT, "_from_double_condensed_dirt", "double_condensed_dirt");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_STONE, "_from_double_condensed_stone", "double_condensed_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_GRAVEL, "_from_double_condensed_gravel", "double_condensed_gravel");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SOUL_SAND, "_from_double_condensed_soul_sand", "double_condensed_soul_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_NETHERRACK, "_from_double_condensed_netherrack", "double_condensed_netherrack");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK, "_from_double_condensed_magma_block", "double_condensed_magma_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK, "_from_double_condensed_nether_wart_block", "double_condensed_nether_wart_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_OBSIDIAN, "_from_double_condensed_obsidian", "double_condensed_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK, "_from_double_condensed_purpur_block", "double_condensed_purpur_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_END_STONE, "_from_double_condensed_end_stone", "double_condensed_end_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_GLOWSTONE, "_from_double_condensed_glow_stone", "double_condensed_glow_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_PEARLESCENT_FROGLIGHT, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_PEARLESCENT_FROGLIGHT, "_from_double_condensed_pearlescent_froglight", "double_condensed_pearlescent_froglight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_CRYING_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_CRYING_OBSIDIAN, "_from_double_condensed_crying_obsidian", "double_condensed_cry_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SHROOMLIGHT, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SHROOMLIGHT, "_from_double_condensed_shroomlight", "double_condensed_shroomlight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK, "_from_double_condensed_copper_block", "double_condensed_copper_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK, "_from_double_condensed_slime_block", "double_condensed_slime_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK, "_from_double_condensed_redstone_block", "double_condensed_redstone_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK, "_from_double_condensed_iron_block", "double_condensed_iron_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SEA_LANTERN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN, "_from_double_condensed_sea_lantern", "double_condensed_sea_lantern");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SCULK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SCULK, "_from_double_condensed_sculk", "double_condensed_sculk");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_DIAMOND_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_DIAMOND_BLOCK, "_from_double_condensed_diamond_block", "double_condensed_diamond_block");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SAND, "_from_triple_condensed_sand", "triple_condensed_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_DIRT, "_from_triple_condensed_dirt", "triple_condensed_dirt");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_STONE, "_from_triple_condensed_stone", "triple_condensed_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_GRAVEL, "_from_triple_condensed_gravel", "triple_condensed_gravel");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SOUL_SAND, "_from_triple_condensed_soul_sand", "triple_condensed_soul_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_NETHERRACK, "_from_triple_condensed_netherrack", "triple_condensed_netherrack");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK, "_from_triple_condensed_magma_block", "triple_condensed_magma_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK, "_from_triple_condensed_nether_wart_block", "triple_condensed_nether_wart_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_OBSIDIAN, "_from_triple_condensed_obsidian", "triple_condensed_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK, "_from_triple_condensed_purpur_block", "triple_condensed_purpur_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_END_STONE, "_from_triple_condensed_end_stone", "triple_condensed_end_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_GLOWSTONE, "_from_triple_condensed_glow_stone", "triple_condensed_glow_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_PEARLESCENT_FROGLIGHT, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_PEARLESCENT_FROGLIGHT, "_from_triple_condensed_pearlescent_froglight", "triple_condensed_pearlescent_froglight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_COPPER_BULB, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_COPPER_BULB, "_from_triple_condensed_copper_bulb", "triple_condensed_copper_bulb");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK, "_from_triple_condensed_copper_block", "triple_condensed_copper_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK, "_from_triple_condensed_slime_block", "triple_condensed_slime_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK, "_from_triple_condensed_redstone_block", "triple_condensed_redstone_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK, "_from_triple_condensed_iron_block", "triple_condensed_iron_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_DIAMOND_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_DIAMOND_BLOCK, "_from_triple_condensed_diamond_block", "triple_condensed_diamond_block");

         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_SAND, "_from_quadruple_condensed_sand", "quadruple_condensed_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_DIRT, "_from_quadruple_condensed_dirt", "quadruple_condensed_dirt");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_STONE, "_from_quadruple_condensed_stone", "quadruple_condensed_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_GRAVEL, "_from_quadruple_condensed_gravel", "quadruple_condensed_gravel");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND, "_from_quadruple_condensed_soul_sand", "quadruple_condensed_soul_sand");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK, "_from_quadruple_condensed_netherrack", "quadruple_condensed_netherrack");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK, "_from_quadruple_condensed_magma_block", "quadruple_condensed_magma_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK, "_from_quadruple_condensed_nether_wart_block", "quadruple_condensed_nether_wart_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN, "_from_quadruple_condensed_obsidian", "quadruple_condensed_obsidian");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK, "_from_quadruple_condensed_purpur_block", "quadruple_condensed_purpur_block");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_END_STONE, "_from_quadruple_condensed_end_stone", "quadruple_condensed_end_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE, "_from_quadruple_condensed_glow_stone", "quadruple_condensed_glow_stone");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_PEARLESCENT_FROGLIGHT, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_PEARLESCENT_FROGLIGHT, "_from_quadruple_condensed_pearlescent_froglight", "quadruple_condensed_pearlescent_froglight");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_COPPER_BULB, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_COPPER_BULB, "_from_quadruple_condensed_copper_bulb", "quadruple_condensed_copper_bulb");
         offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK, "_from_quadruple_condensed_copper_block", "quadruple_condensed_copper_block");
         }

         }
 **/
    }
}