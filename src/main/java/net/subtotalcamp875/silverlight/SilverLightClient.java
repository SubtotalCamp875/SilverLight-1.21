package net.subtotalcamp875.silverlight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.subtotalcamp875.silverlight.component.type.BackpackContentsComponent;
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
    }
}
