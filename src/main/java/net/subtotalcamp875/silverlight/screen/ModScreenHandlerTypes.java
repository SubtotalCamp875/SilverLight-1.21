package net.subtotalcamp875.silverlight.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.screen.custom.BackpackScreenHandler;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<BackpackScreenHandler> BACKPACK = registerScreenHandlerType("backpack",
            new ExtendedScreenHandlerType<>(BackpackScreenHandler::new, ItemStack.PACKET_CODEC));

    private static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandlerType(String id, ScreenHandlerType<T> screenHandlerType) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, id), screenHandlerType);
    }

    public static void registerModScreenHandlerTypes() {
        SilverLight.LOGGER.info("Registering ModScreenHandlerTypes for " + SilverLight.MOD_ID);
    }
}
