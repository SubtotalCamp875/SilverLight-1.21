package net.subtotalcamp875.silverlight.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.subtotalcamp875.silverlight.SilverLight;

public class ModSounds {

    public static final SoundEvent LIGHT_STAFF_SHOOT = registerSoundEvent("light_staff_shoot");
    public static final SoundEvent VIKING_HORN_SOUND = registerSoundEvent("viking_horn_sound");


    private static SoundEvent registerSoundEvent(String name) {
        net.minecraft.util.Identifier id = Identifier.of(SilverLight.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        SilverLight.LOGGER.info("Registering Sounds for " + SilverLight.MOD_ID);
    }
}
