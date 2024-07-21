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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SEED, 1)
                .pattern("T")
                .input('T', ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.TOMATO_SEED)));
    }
}