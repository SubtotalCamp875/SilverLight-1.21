package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightOrbEntity;
import net.subtotalcamp875.silverlight.sound.ModSounds;

public class VikingHornItem extends Item {
    public VikingHornItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 1200);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                ModSounds.VIKING_HORN_SOUND, SoundCategory.NEUTRAL, 10f, 0.6f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
