package net.subtotalcamp875.silverlight;

import net.fabricmc.api.ModInitializer;
import net.subtotalcamp875.silverlight.block.ModBlocks;
import net.subtotalcamp875.silverlight.block.entity.ModBlockEntities;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.effect.ModEffects;
import net.subtotalcamp875.silverlight.entity.ModEntities;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.item.itemGroups.SilverlightConsumables;
import net.subtotalcamp875.silverlight.item.itemGroups.SilverlightMain;
import net.subtotalcamp875.silverlight.item.itemGroups.SilverlightPlayerItems;
import net.subtotalcamp875.silverlight.item.itemGroups.SilverlightStaffs;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlerTypes;
import net.subtotalcamp875.silverlight.screen.ModScreenHandlers;
import net.subtotalcamp875.silverlight.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SilverLight implements ModInitializer {
	public static String MOD_ID = "silverlight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SilverlightMain.registerMainItemGroups();
		SilverlightStaffs.registerStaffsItemGroups();
		SilverlightConsumables.registerConsumablesItemGroups();
		SilverlightPlayerItems.registerPlayerItemsItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerModEffects();
		ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModEntities.registerModEntities();

		ModDataComponentTypes.registerModDataComponentTypes();
		ModScreenHandlerTypes.registerModScreenHandlerTypes();
	}
}