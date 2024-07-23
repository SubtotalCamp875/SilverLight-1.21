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
                    .pattern("MPR")
                    .pattern("GBG")
                    .pattern("SSS")
                    .input('M', Items.BROWN_MUSHROOM)
                    .input('P', Items.OAK_PLANKS)
                    .input('R', Items.RED_MUSHROOM)
                    .input('G', Items.GLASS)
                    .input('B', Items.BARREL)
                    .input('S', Items.SMOOTH_STONE)
                    .criterion(hasItem(Items.SMOOTH_STONE), conditionsFromItem(Items.SMOOTH_STONE))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FERMENTING_STATION)));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SEED, 1)
                    .pattern("T")
                    .input('T', ModItems.TOMATO)
                    .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.TOMATO_SEED)));
        }
        if (isBlackhole) {
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

            if (isCondensedItem) {
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_BLAZE_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CHORUS_FRUIT, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_CHORUS_FRUIT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SHULKER_SHELL, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_SHULKER_SHELL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.GHAST_TEAR, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_GHAST_TEAR);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.DRAGON_HEAD, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_DRAGON_HEAD);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_EXPERIENCE_BOTTLE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_BLAZE_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_SHULKER_SHELL, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_SHULKER_SHELL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_GHAST_TEAR, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_GHAST_TEAR);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_ELYTRA, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_ELYTRA);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SINGLE_CONDENSED_DRAGON_HEAD, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_DRAGON_HEAD);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_DRAGON_HEAD, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_BLAZE_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_SHULKER_SHELL, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_SHULKER_SHELL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_GHAST_TEAR, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_GHAST_TEAR);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLE_CONDENSED_PHANTOM_MEMBRANE, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_PHANTOM_MEMBRANE);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_EXPERIENCE_BOTTLE, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_EXPERIENCE_BOTTLE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_FIREWORK_ROCKET, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_FIREWORK_ROCKET);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_BLAZE_ROD, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_BLAZE_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TRIPLE_CONDENSED_CHORUS_FRUIT, RecipeCategory.MISC, ModItems.QUADRUPLE_CONDENSED_CHORUS_FRUIT);
            }

            if (isCondensedBlocks) {
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SAND, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.DIRT, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_DIRT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.STONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.GRAVEL, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_GRAVEL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SOUL_SAND, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SOUL_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.NETHERRACK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_NETHERRACK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.OBSIDIAN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_OBSIDIAN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.END_STONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_END_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.TORCH, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_TORCH);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.GLOWSTONE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_GLOWSTONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.END_ROD, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_END_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.FURNACE, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_FURNACE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PISTON, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_PISTON);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SLIME_BALL, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_IRON_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.LANTERN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_LANTERN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SEA_LANTERN, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SEA_LANTERN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SCULK, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_SCULK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.RESPAWN_ANCHOR, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.COPPER_BULB, RecipeCategory.MISC,  ModBlocks.SINGLE_CONDENSED_COPPER_BULB);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_DIRT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_GRAVEL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SOUL_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_NETHERRACK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_OBSIDIAN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_END_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_TORCH, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_TORCH);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_GLOWSTONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_END_ROD, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_END_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_FURNACE, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_FURNACE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_PISTON, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_PISTON);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SLIME_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_LANTERN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_LANTERN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SEA_LANTERN, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SEA_LANTERN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_SCULK, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_SCULK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_RESPAWN_ANCHOR, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_RESPAWN_ANCHOR);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.SINGLE_CONDENSED_COPPER_BULB, RecipeCategory.MISC,  ModBlocks.DOUBLE_CONDENSED_COPPER_BULB);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_DIRT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_GRAVEL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SOUL_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_NETHERRACK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_OBSIDIAN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_END_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_TORCH, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_TORCH);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_GLOWSTONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_END_ROD, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_END_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_FURNACE, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_FURNACE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_PISTON, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_PISTON);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_SLIME_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_SLIME_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_REDSTONE_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_REDSTONE_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.DOUBLE_CONDENSED_IRON_BLOCK, RecipeCategory.MISC,  ModBlocks.TRIPLE_CONDENSED_IRON_BLOCK);

                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_SAND, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_DIRT, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_DIRT);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_STONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_GRAVEL, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_GRAVEL);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_SOUL_SAND, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_SOUL_SAND);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_NETHERRACK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_NETHERRACK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_MAGMA_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_MAGMA_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_NETHER_WART_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_NETHER_WART_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_OBSIDIAN, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_OBSIDIAN);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_PURPUR_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_PURPUR_BLOCK);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_END_STONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_END_STONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_TORCH, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_TORCH);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_GLOWSTONE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_GLOWSTONE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_END_ROD, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_END_ROD);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_FURNACE, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_FURNACE);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_PISTON, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_PISTON);
                offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModBlocks.TRIPLE_CONDENSED_COPPER_BLOCK, RecipeCategory.MISC,  ModBlocks.QUADRUPLE_CONDENSED_COPPER_BLOCK);
            }
        }
    }
}