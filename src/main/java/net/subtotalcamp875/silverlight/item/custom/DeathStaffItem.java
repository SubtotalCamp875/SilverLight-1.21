package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
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

public class DeathStaffItem extends Item {
    public DeathStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_HORSE_DEATH, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_GHAST_DEATH, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            if (!user.getAbilities().creativeMode) {

                if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                    user.sendMessage(Text.of("The Effect of §4Death's Staff§r has been §etriggered§r! Granting a random item (out of 2) to the selected user!"));

                    if (user.getOffHandStack().getItem() == ModItems.DEATHS_DOLL) {
                        user.sendMessage(Text.of("§The God Of Death Is Happy With You Sacrifice! Granting Reaper's Scythe To The Player!§r"));
                        user.getOffHandStack().decrement(1);
                        user.giveItemStack(ModItems.REAPERS_SCYTHE.getDefaultStack());
                    } else {
                        int chance = world.getRandom().nextInt(2);
                        if (chance == 0) {
                            user.giveItemStack(ModItems.DEATHS_DOLL.getDefaultStack());
                        } else {
                            user.giveItemStack(ModItems.DEATHS_BOMB.getDefaultStack());
                        }
                    }

                    itemStack.decrement(1);


                } else {
                    user.kill();
                    itemStack.setDamage(itemStack.getDamage() + 1);
                }
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
