package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class WaddlesItem extends Item {
    public WaddlesItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_GOAT_SCREAMING_AMBIENT, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

                user.giveItemStack(ModItems.SOUND_STAFF.getDefaultStack());

                if (!user.getAbilities().creativeMode) {
                    itemStack.setDamage(itemStack.getDamage() + 1);
                }
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
