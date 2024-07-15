package net.subtotalcamp875.silverlight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipComponent;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipData;
import net.subtotalcamp875.silverlight.screen.BackpackScreen;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlerTypes;

public class SilverLightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerTypes.BACKPACK, BackpackScreen::new);
        TooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof BackpackTooltipData(BackpackContentsComponent contents)) {
                return new BackpackTooltipComponent(contents);
            }
            return null;
        });

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_PLANT, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.TOMATO_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
