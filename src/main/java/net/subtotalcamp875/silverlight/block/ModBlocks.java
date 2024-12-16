package net.subtotalcamp875.silverlight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.custom.DragonProcessingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.FermentingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.SievingStationBlock;
import net.subtotalcamp875.silverlight.block.custom.StrawberryPlantBlock;

import java.util.List;

public class ModBlocks {

    public static final Block STRAWBERRY_PLANT = Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, "strawberry_plant"),
            new StrawberryPlantBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block DRAGON_PROCESSING_STATION = registerBlock("dragon_processing_station",
            new DragonProcessingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block SIEVING_STATION = registerBlock("sieving_station",
            new SievingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block FERMENTING_STATION = registerBlock("fermenting_station",
            new FermentingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block FAKE_DIAMOND_BLOCK = registerBlock("fake_diamond_block",
            new Block(AbstractBlock.Settings.create().hardness(5).resistance(6).requiresTool()) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.silverlight.fake_diamond_block.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(SilverLight.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SilverLight.LOGGER.info("Registering ModBlocks for " + SilverLight.MOD_ID);
    }
}
