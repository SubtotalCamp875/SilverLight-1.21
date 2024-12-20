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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FERMENTING_STATION, 1)
                .pattern("S")
                .pattern("B")
                .input('B', Items.BARREL)
                .input('S', Items.BREWING_STAND)
                .criterion(hasItem(Items.BARREL), conditionsFromItem(Items.BARREL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.FERMENTING_STATION)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRAWBERRY_SEED, 1)
                .pattern("T")
                .input('T', ModItems.STRAWBERRY)
                .criterion(hasItem(ModItems.STRAWBERRY), conditionsFromItem(ModItems.STRAWBERRY))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.STRAWBERRY_SEED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRACKER, 3)
                .pattern("B")
                .input('B', Items.BREAD)
                .criterion(hasItem(ModItems.CRACKER), conditionsFromItem(ModItems.CRACKER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CRACKER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FAKE_BREAD, 1)
                .pattern("D")
                .pattern("B")
                .input('D', Items.DIRT)
                .input('B', Items.BREAD)
                .criterion(hasItem(ModItems.FAKE_BREAD), conditionsFromItem(ModItems.FAKE_BREAD))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.FAKE_BREAD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HONEY_CAKE_ON_A_STICK, 1)
                .pattern("HC")
                .pattern("SH")
                .input('S', Items.STICK)
                .input('C', Items.CAKE)
                .input('H', Items.HONEYCOMB)
                .criterion(hasItem(ModItems.HONEY_CAKE_ON_A_STICK), conditionsFromItem(ModItems.HONEY_CAKE_ON_A_STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.HONEY_CAKE_ON_A_STICK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIKING_AXE, 1)
                .pattern("P")
                .pattern("X")
                .input('P', ModItems.VIKING_PATTERN)
                .input('X', Items.DIAMOND_AXE)
                .criterion(hasItem(ModItems.VIKING_AXE), conditionsFromItem(ModItems.VIKING_AXE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.VIKING_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHOCOLATE_MILK, 7)
                .pattern("BCB")
                .pattern("BMB")
                .pattern("BBB")
                .input('C', ModItems.COSMIC_BROWNIE)
                .input('M', Items.MILK_BUCKET)
                .input('B', Items.GLASS_BOTTLE)
                .criterion(hasItem(ModItems.CHOCOLATE_MILK), conditionsFromItem(ModItems.CHOCOLATE_MILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CHOCOLATE_MILK)));
    }
}