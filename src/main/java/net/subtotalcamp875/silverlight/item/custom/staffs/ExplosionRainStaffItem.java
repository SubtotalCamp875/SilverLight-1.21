package net.subtotalcamp875.silverlight.item.custom.staffs;

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
import net.subtotalcamp875.silverlight.entity.custom.ExplosionRainOrbEntity;

import java.util.List;

public class ExplosionRainStaffItem extends Item {
    public ExplosionRainStaffItem(Item.Settings settings) {
        super(settings);
    }

    private boolean isSingleAttack(ItemStack itemStack) {
        return itemStack.getDamage() == 4;
    }
    private boolean isDoubleAttack(ItemStack itemStack) {
        return itemStack.getDamage() == 3;
    }
    private boolean isTripleAttack(ItemStack itemStack) {
        return itemStack.getDamage() == 2;
    }
    private boolean isQuadAttack(ItemStack itemStack) {
        return itemStack.getDamage() == 1;
    }
    private boolean isQuinAttack(ItemStack itemStack) {
        return itemStack.getDamage() == 0;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int angleLimit = 45;
        user.getItemCooldownManager().set(this, 30);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            if (isSingleAttack(itemStack)) {
                ExplosionRainOrbEntity explosionRainOrbEntity = new ExplosionRainOrbEntity(user, world);
                explosionRainOrbEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1f, 0.0f);
                world.spawnEntity(explosionRainOrbEntity);
            } else if (isDoubleAttack(itemStack)) {
                ExplosionRainOrbEntity explosionRainOrbEntity = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity2 = new ExplosionRainOrbEntity(user, world);
                explosionRainOrbEntity.setVelocity(user, user.getPitch(), user.getYaw()-((float) angleLimit /4), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity2.setVelocity(user, user.getPitch(), user.getYaw()+((float) angleLimit /4), 0.0f, 1f, 0.0f);
                world.spawnEntity(explosionRainOrbEntity);
                world.spawnEntity(explosionRainOrbEntity2);
            } else if (isTripleAttack(itemStack)) {
                ExplosionRainOrbEntity explosionRainOrbEntity = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity2 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity3 = new ExplosionRainOrbEntity(user, world);
                explosionRainOrbEntity.setVelocity(user, user.getPitch(), user.getYaw()-((float) angleLimit /2), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity2.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity3.setVelocity(user, user.getPitch(), user.getYaw()+((float) angleLimit /2), 0.0f, 1f, 0.0f);
                world.spawnEntity(explosionRainOrbEntity);
                world.spawnEntity(explosionRainOrbEntity2);
                world.spawnEntity(explosionRainOrbEntity3);
            } else if (isQuadAttack(itemStack)) {
                ExplosionRainOrbEntity explosionRainOrbEntity = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity2 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity3 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity4 = new ExplosionRainOrbEntity(user, world);
                explosionRainOrbEntity.setVelocity(user, user.getPitch(), user.getYaw()-((float) angleLimit /2)-((float) angleLimit /4), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity2.setVelocity(user, user.getPitch(), user.getYaw()-((float) angleLimit /4), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity3.setVelocity(user, user.getPitch(), user.getYaw()+((float) angleLimit /4), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity4.setVelocity(user, user.getPitch(), user.getYaw()+((float) angleLimit /2)+((float) angleLimit /4), 0.0f, 1f, 0.0f);
                world.spawnEntity(explosionRainOrbEntity);
                world.spawnEntity(explosionRainOrbEntity2);
                world.spawnEntity(explosionRainOrbEntity3);
                world.spawnEntity(explosionRainOrbEntity4);
            } else if (isQuinAttack(itemStack)) {
                ExplosionRainOrbEntity explosionRainOrbEntity = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity2 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity3 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity4 = new ExplosionRainOrbEntity(user, world);
                ExplosionRainOrbEntity explosionRainOrbEntity5 = new ExplosionRainOrbEntity(user, world);
                explosionRainOrbEntity.setVelocity(user, user.getPitch(), user.getYaw()-angleLimit, 0.0f, 1f, 0.0f);
                explosionRainOrbEntity2.setVelocity(user, user.getPitch(), user.getYaw()-((float) angleLimit /2), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity3.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity4.setVelocity(user, user.getPitch(), user.getYaw()+((float) angleLimit /2), 0.0f, 1f, 0.0f);
                explosionRainOrbEntity5.setVelocity(user, user.getPitch(), user.getYaw()+angleLimit, 0.0f, 1f, 0.0f);
                world.spawnEntity(explosionRainOrbEntity);
                world.spawnEntity(explosionRainOrbEntity2);
                world.spawnEntity(explosionRainOrbEntity3);
                world.spawnEntity(explosionRainOrbEntity4);
                world.spawnEntity(explosionRainOrbEntity5);
            }
        }

        if (itemStack.getDamage() == 0) {
            itemStack.setDamage(5);
        }
        itemStack.setDamage(itemStack.getDamage() - 1);
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.silverlight.explosion_rain_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.explosion_rain_staff_shift_down_1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.explosion_rain_staff_shift_down_2.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.silverlight.explosion_rain_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.easter_egg_item.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
