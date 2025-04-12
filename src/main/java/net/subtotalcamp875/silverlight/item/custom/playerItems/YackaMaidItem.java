package net.subtotalcamp875.silverlight.item.custom.playerItems;

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

public class YackaMaidItem extends Item {
    public YackaMaidItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 5);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_PURREOW, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_PURR, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_CAT_AMBIENT, SoundCategory.NEUTRAL, 50f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        stack.copyComponentsToNewStack(stack.getItem(), 1);
        if (entity.isPlayer() && !entity.isSpectator()) {
            PlayerEntity user = world.getClosestPlayer(entity, 1);

            assert user != null;
            if (!world.isClient) {
                if (user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.HEART, user.getX(), user.getY()+2.5, user.getZ(), 1, 0.05, 0, 0.05, 0.05);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
