package net.subtotalcamp875.silverlight.item.custom.charms;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class MeteorCharmItem extends Item {
    public MeteorCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (user.getOffHandStack().getItem() == ModItems.CLOUD_CHARM) {
                user.sendMessage(Text.of("§6The God Of Fire Is Happy With You Sacrifice! Granting Inferno Charm To The Player!§r"));
                user.getOffHandStack().decrement(1);
                user.giveItemStack(ModItems.INFERNO_CHARM.getDefaultStack());
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
            if (!world.isClient && !user.isOnGround()) {

                boolean active = true;
                for (int i = 0; i <= 5; i++) {
                    BlockPos blockPos = user.getBlockPos();
                    BlockState state = world.getBlockState(blockPos.down(i));
                    if (!state.isOf(Blocks.AIR)) {
                        active = false;
                    }
                }

                if (active && user.getWorld() instanceof ServerWorld serverWorld) {
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, user.getX(), user.getY()+6, user.getZ(), 20, 0, 0.5, 0, 0.2);
                    serverWorld.spawnParticles(ParticleTypes.FLAME, user.getX(), user.getY()+6, user.getZ(), 20, 0, 0.5, 0, 0.2);
                    serverWorld.spawnParticles(ParticleTypes.EXPLOSION, user.getX(), user.getY()-3, user.getZ(), 10, 0.05, 0.05, 0.05, 0.2);
                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
