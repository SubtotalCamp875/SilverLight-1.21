package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.effect.ModEffects;
import net.subtotalcamp875.silverlight.entity.custom.TomatoEntity;
import net.subtotalcamp875.silverlight.item.ModItems;

import java.util.List;

public class RightRingItem extends Item {
    public RightRingItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            if (user.getStackInHand(hand) == ModItems.RIGHT_RING.getDefaultStack()) {
                if (user.getOffHandStack() == ModItems.LEFT_RING.getDefaultStack()) {
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.STRONG_FAIRY, 100), user);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100), user);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100), user);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), user);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100), user);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200), user);

                    itemStack.decrement(1);
                    user.getOffHandStack().decrement(1);
                }
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

}
