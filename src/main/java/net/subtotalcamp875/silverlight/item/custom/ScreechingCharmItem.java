package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.entity.custom.LightOrbEntity;

public class ScreechingCharmItem extends Item {
    public ScreechingCharmItem(Settings settings) {
        super(settings);
    }

    private boolean isActivated = false;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (user.isSneaking()) {
                user.getItemCooldownManager().set(this, 200);
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_WARDEN_ATTACK_IMPACT, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                Vec3d vec3d = user.getRotationVec(1.0F);

                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    for (int i = 0; i <= 32; i += 2) {
                        serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM, user.getX() + vec3d.x * i, user.getY() + 2 + vec3d.y * i, user.getZ() + vec3d.z * i, 1, 0, 0, 0, 0);
                    }
                }

            } else if (!isActivated) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                isActivated = !isActivated;
            } else {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_VAULT_BREAK, SoundCategory.NEUTRAL, 1f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                isActivated = !isActivated;
            }
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
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2), user);
                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.SCULK_CHARGE_POP, user.getX(), user.getY(), user.getZ(), 50, 0.2, 0.2, 0.2, 0.05);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
