package net.subtotalcamp875.silverlight;

import net.fabricmc.api.ModInitializer;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.item.ModItemGroups;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SilverLight implements ModInitializer {
	public static String MOD_ID = "silverlight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModDataComponentTypes.registerModDataComponentTypes();
		ModScreenHandlerTypes.registerModScreenHandlerTypes();
	}
}