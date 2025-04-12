package net.subtotalcamp875.silverlight.item.custom.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.SilverLight;

public class BlackHoleItem extends Item {
    public BlackHoleItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            SilverLight.LOGGER.info("black hole");
            MinecraftServer server = user.getServer();
            server.close();
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}