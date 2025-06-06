package net.subtotalcamp875.silverlight.item.custom.staffs;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.AimOrbEntity;
import net.subtotalcamp875.silverlight.entity.custom.LightOrbEntity;
import net.subtotalcamp875.silverlight.item.ModItems;
import net.subtotalcamp875.silverlight.sound.ModSounds;

import java.util.List;

public class LightStaffItem extends Item {
    public LightStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        //user.getItemCooldownManager().set(this, 200);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                ModSounds.LIGHT_STAFF_SHOOT, SoundCategory.NEUTRAL, 10f, 0.6f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            Vec3d vec3d = user.getRotationVec(1.0F);

            LightOrbEntity lightOrbEntity = new LightOrbEntity(user, world);
            lightOrbEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1f, 0.0f);
            lightOrbEntity.setPosition(user.getX() + vec3d.x, user.getY() + 1 + vec3d.y, user.getZ() + vec3d.z);
            world.spawnEntity(lightOrbEntity);

        }

        if (!user.getAbilities().creativeMode) {
            itemStack.setDamage(itemStack.getDamage() + 1);
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                itemStack.decrement(1);
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient) {
                Vec3d vec3d = user.getRotationVec(1.0F);

                if (user.getMainHandStack().getItem() == ModItems.LIGHT_STAFF || user.getOffHandStack().getItem() == ModItems.LIGHT_STAFF) {
                    user.setGlowing(true);
                    AimOrbEntity aimOrbEntity = new AimOrbEntity(user, world);
                    aimOrbEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 4f, 0.0f);
                    aimOrbEntity.setPosition(user.getX() + vec3d.x, user.getY() + 1 + vec3d.y, user.getZ() + vec3d.z);
                    world.spawnEntity(aimOrbEntity);
                } else {
                    //user.getItemCooldownManager().set(this, 200);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff_shift_down1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff_shift_down2.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff_shift_down3.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff_shift_down4.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.silverlight.light_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
