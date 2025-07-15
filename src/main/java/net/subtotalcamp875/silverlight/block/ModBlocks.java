package net.subtotalcamp875.silverlight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.custom.*;

import java.util.List;

public class ModBlocks {

    public static final Block STRAWBERRY_PLANT = Registry.register(Registries.BLOCK, Identifier.of(SilverLight.MOD_ID, "strawberry_plant"),
            new StrawberryPlantBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block DRAGON_PROCESSING_STATION = registerBlock("dragon_processing_station",
            new DragonProcessingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block SIEVING_STATION = registerBlock("sieving_station",
            new SievingStationBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block FERMENTING_STATION = registerBlock("fermenting_station",
            new FermentingStationBlock(AbstractBlock.Settings.create().nonOpaque()) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

                    if(Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_1.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_2.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_3.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_4.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_5.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_6.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_7.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_8.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_9.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_10.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_11.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_12.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_13.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_14.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_15.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_16.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_17.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_18.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_shift_down_19.tooltip"));
                    } else if (Screen.hasControlDown()) {
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down_1.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down_2.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down_3.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down_4.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station_control_down_5.tooltip"));
                    }else {
                        tooltip.add(Text.translatable("tooltip.silverlight.fermenting_station.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
                        tooltip.add(Text.translatable("tooltip.silverlight.control.tooltip"));
                    }

                    super.appendTooltip(stack, context, tooltip, options);
                }
            });

    public static final Block FAKE_DIAMOND_BLOCK = registerBlock("fake_diamond_block",
            new Block(AbstractBlock.Settings.create().hardness(5).resistance(6).requiresTool()) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.silverlight.fake_diamond_block.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });

    public static final Block MIMIC = registerBlock("mimic",
            new MimicBlock(AbstractBlock.Settings.create().nonOpaque()));

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
