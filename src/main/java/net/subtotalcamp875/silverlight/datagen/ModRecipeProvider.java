package net.subtotalcamp875.silverlight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BACKPACK, 1)
                .pattern("SBS")
                .pattern("NCN")
                .pattern("SLS")
                .input('S', ModItems.STRETCHY_LEATHER)
                .input('C', Items.CHEST)
                .input('N', Items.ANCIENT_DEBRIS)
                .input('L', Items.LEATHER)
                .input('B', Items.MOJANG_BANNER_PATTERN)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.BACKPACK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STRETCHY_LEATHER, 1)
                .pattern("LRL")
                .pattern("RSR")
                .pattern("LRL")
                .input('S', Items.SLIME_BALL)
                .input('L', Items.LEATHER)
                .input('R', Items.RABBIT_HIDE)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.STRETCHY_LEATHER)));
    }
}