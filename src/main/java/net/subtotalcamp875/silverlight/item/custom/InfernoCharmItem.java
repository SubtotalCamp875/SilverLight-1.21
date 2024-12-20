package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InfernoCharmItem extends Item {
    public InfernoCharmItem(Settings settings) {
        super(settings);
    }

    private boolean isActivated = false;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (!isActivated) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
            }
            isActivated = !isActivated;
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && isActivated && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient) {
                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.FLAME, user.getX(), user.getY(), user.getZ(), 2, 2, 2, 2, 0.05);
                    serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME, user.getX(), user.getY(), user.getZ(), 2, 2, 2, 2, 0.05);
                    serverWorld.spawnParticles(ParticleTypes.SOUL_FIRE_FLAME, user.getX(), user.getY(), user.getZ(), 1, 2, 2, 2, 0.05);
                    serverWorld.spawnParticles(ParticleTypes.SOUL, user.getX(), user.getY(), user.getZ(), 1, 2, 2, 2, 0.05);
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, user.getX(), user.getY(), user.getZ(), 1, 2, 2, 2, 0.05);
                    serverWorld.spawnParticles(ParticleTypes.SMOKE, user.getX(), user.getY(), user.getZ(), 1, 2, 2, 2, 0.05);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
