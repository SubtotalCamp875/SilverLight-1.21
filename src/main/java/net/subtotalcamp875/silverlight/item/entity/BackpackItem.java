package net.subtotalcamp875.silverlight.item.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BackpackItem extends ItemEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private  final  DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10, ItemStack.EMPTY);
    
    private static final int SLOT_0 = 0;
    private static final int SLOT_1 = 1;
    private static final int SLOT_2 = 2;
    private static final int SLOT_3 = 3;
    private static final int SLOT_4 = 4;
    private static final int SLOT_5 = 5;
    private static final int SLOT_6 = 6;
    private static final int SLOT_7 = 7;
    private static final int SLOT_8 = 8;
    private static final int SLOT_9 = 9;
    private static final int SLOT_10 = 10;
    private static final int SLOT_11 = 11;
    private static final int SLOT_12 = 12;
    private static final int SLOT_13 = 13;
    private static final int SLOT_14 = 14;
    private static final int SLOT_15 = 15;
    private static final int SLOT_16 = 16;
    private static final int SLOT_17 = 17;
    private static final int SLOT_18 = 18;
    private static final int SLOT_19 = 19;
    private static final int SLOT_20 = 20;
    private static final int SLOT_21 = 21;
    private static final int SLOT_22 = 22;
    private static final int SLOT_23 = 23;
    private static final int SLOT_24 = 24;
    private static final int SLOT_25 = 25;
    private static final int SLOT_26 = 26;

    public BackpackItem(EntityType<? extends ItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
}
