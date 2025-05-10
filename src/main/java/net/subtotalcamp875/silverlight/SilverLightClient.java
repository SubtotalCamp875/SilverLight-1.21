package net.subtotalcamp875.silverlight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipComponent;
import net.subtotalcamp875.silverlight.item.tooltip.BackpackTooltipData;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlerTypes;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlers;
import net.subtotalcamp875.silverlight.screen.custom.*;

public class SilverLightClient implements ClientModInitializer {
    public static void registerModelPredicateProviders() {
        ModelPredicateProviderRegistry.register(ModItems.METEOR_STAFF, Identifier.ofVanilla("pull"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime(livingEntity) - livingEntity.getItemUseTimeLeft()) / 20.0F;
        });

        ModelPredicateProviderRegistry.register(ModItems.METEOR_STAFF, Identifier.ofVanilla("pulling"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerTypes.BACKPACK, BackpackScreen::new);
        TooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof BackpackTooltipData(BackpackContentsComponent contents)) {
                return new BackpackTooltipComponent(contents);
            }
            return null;
        });

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_PLANT, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.STRAWBERRY_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DEATHS_BOMB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SMOKE_BOMB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_ORB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.VORTEX_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LIGHT_ORB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.AIM_ORB_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.EXPLOSION_RAIN_ORB_PROJECTILE, FlyingItemEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.DRAGON_PROCESSING_SCREEN_HANDLER, DragonProcessingScreen::new);
        HandledScreens.register(ModScreenHandlers.SIEVING_SCREEN_HANDLER, SievingScreen::new);
        HandledScreens.register(ModScreenHandlers.FERMENTING_SCREEN_HANDLER, FermentingScreen::new);
        HandledScreens.register(ModScreenHandlers.CHARGE_GENERATOR_SCREEN_HANDLER, ChargeGeneratorScreen::new);
        HandledScreens.register(ModScreenHandlers.MIMIC_SCREEN_HANDLER, MimicScreen::new);
        registerModelPredicateProviders();

    }
}
