package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class SoundStaffItem extends Item {
    public SoundStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);


        if (!world.isClient) {
            if (user.isSneaking()) {
                System.out.println(itemStack.getDamage());
                if (itemStack.getDamage() == 0) {
                    itemStack.setDamage(itemStack.getMaxDamage());
                }
                itemStack.setDamage(itemStack.getDamage() - 1);
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else {

                if (itemStack.getDamage() == 1) {
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_ENDERMAN_DEATH, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.getDamage() == 2) {
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.getDamage() == 3) {
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                } else if (itemStack.getDamage() == 4) {
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                } else {
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_ENDERMAN_SCREAM, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                }
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down2.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down3.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down4.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down5.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down6.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff_shift_down7.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.silverlight.sound_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
