package net.subtotalcamp875.silverlight.item.custom.charms;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.component.ModDataComponentTypes;
import net.subtotalcamp875.silverlight.item.ModItems;

public class VibrationCharm extends Item {
    public VibrationCharm(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        int isActivated = getIsActivated(itemStack);

        if (!world.isClient && (itemStack.getDamage() != itemStack.getMaxDamage())) {
            if (user.getOffHandStack().getItem() == ModItems.CLOUD_CHARM) {
                user.sendMessage(Text.of("§3The God Of Noise Is Happy With You Sacrifice! Granting Screeching Charm To The Player!§r"));
                user.getOffHandStack().setDamage(user.getOffHandStack().getMaxDamage());
                itemStack.setDamage(itemStack.getMaxDamage());
                user.giveItemStack(ModItems.SCREECHING_CHARM.getDefaultStack());

            } else if (isActivated == 0) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                isActivated = 1;
                itemStack.set(ModDataComponentTypes.ISACTIVATED, isActivated);
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                isActivated = 0;
                itemStack.set(ModDataComponentTypes.ISACTIVATED, isActivated);
            }

        } else if (!world.isClient) {
            user.sendMessage(Text.of("This item has already been used"));
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        int isActivated = getIsActivated(stack);
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && (isActivated == 1) && !entity.isSpectator() && (stack.getDamage() != stack.getMaxDamage())) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            if (!world.isClient && user != null) {
                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.SCULK_CHARGE_POP, user.getX(), user.getY(), user.getZ(), 50, 0.2, 0.2, 0.2, 0.05);
                }
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 60), user);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private int getIsActivated(ItemStack stack) {
        if (stack.get(ModDataComponentTypes.ISACTIVATED) == null) {
            return 0;
        } else {
            return stack.get(ModDataComponentTypes.ISACTIVATED);
        }
    }
}
