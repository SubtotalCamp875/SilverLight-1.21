package net.subtotalcamp875.silverlight.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;
import net.subtotalcamp875.silverlight.block.entity.custom.*;
import net.subtotalcamp875.silverlight.screen.custom.*;

public class ModScreenHandlers {
    public static final ScreenHandlerType<DragonProcessingScreenHandler> DRAGON_PROCESSING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, "dragon_processing"),
                    new ExtendedScreenHandlerType<>(DragonProcessingScreenHandler::new, DragonProcessingStationData.PACKET_CODEC));

    public static final ScreenHandlerType<SievingScreenHandler> SIEVING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, "sieving"),
                    new ExtendedScreenHandlerType<>(SievingScreenHandler::new, SievingStationData.PACKET_CODEC));

    public static final ScreenHandlerType<FermentingScreenHandler> FERMENTING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, "fermenting"),
                    new ExtendedScreenHandlerType<>(FermentingScreenHandler::new, FermentingStationData.PACKET_CODEC));

    public static final ScreenHandlerType<ChargeGeneratorScreenHandler> CHARGE_GENERATOR_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, "charge_generating"),
                    new ExtendedScreenHandlerType<>(ChargeGeneratorScreenHandler::new, ChargeGeneratorData.PACKET_CODEC));

    public static final ScreenHandlerType<MimicScreenHandler> MIMIC_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SilverLight.MOD_ID, "mimic"),
                    new ExtendedScreenHandlerType<>(MimicScreenHandler::new, MimicData.PACKET_CODEC));
    
    public static void registerScreenHandlers() {
        SilverLight.LOGGER.info("Registering Screen Handlers for " + SilverLight.MOD_ID);
    }
}
