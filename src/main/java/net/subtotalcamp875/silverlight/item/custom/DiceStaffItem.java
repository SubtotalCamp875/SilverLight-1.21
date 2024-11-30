package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CobwebBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.effect.ModEffects;

public class DiceStaffItem extends Item {
    public DiceStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 20);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundCategory.NEUTRAL, 3f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!world.isClient) {
            BlockPos blockPos = user.getBlockPos();
            int action = world.getRandom().nextInt(16);

            if (action == 0) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2000), user);
            } else if (action == 1) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2000), user);
            } else if (action == 2) {
                user.addStatusEffect(new StatusEffectInstance(ModEffects.ANTI_GRAVITY, 2000), user);
            } else if (action == 3) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2000), user);
            } else if (action == 4) {
                user.giveItemStack(Items.DIAMOND_BLOCK.getDefaultStack());
                user.giveItemStack(Items.DIAMOND_BLOCK.getDefaultStack());
                user.giveItemStack(Items.DIAMOND_BLOCK.getDefaultStack());

            } else if (action == 5) {
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.NEUTRAL, 10f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                user.addExperience(1000);

            } else if (action == 6) {
                user.giveItemStack(Items.DANDELION.getDefaultStack());
                user.giveItemStack(Items.POPPY.getDefaultStack());
                user.giveItemStack(Items.BLUE_ORCHID.getDefaultStack());
                user.giveItemStack(Items.ALLIUM.getDefaultStack());
                user.giveItemStack(Items.AZURE_BLUET.getDefaultStack());
                user.giveItemStack(Items.WHITE_TULIP.getDefaultStack());
                user.giveItemStack(Items.ORANGE_TULIP.getDefaultStack());
                user.giveItemStack(Items.RED_TULIP.getDefaultStack());
                user.giveItemStack(Items.PINK_TULIP.getDefaultStack());
                user.giveItemStack(Items.OXEYE_DAISY.getDefaultStack());
                user.giveItemStack(Items.CORNFLOWER.getDefaultStack());
                user.giveItemStack(Items.LILY_OF_THE_VALLEY.getDefaultStack());
                user.giveItemStack(Items.TORCHFLOWER.getDefaultStack());


            } else if (action == 7) {
                IronGolemEntity ironGolemEntity = new IronGolemEntity(EntityType.IRON_GOLEM,world);
                IronGolemEntity ironGolemEntity1 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity2 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity3 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity4 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity5 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity6 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                IronGolemEntity ironGolemEntity7 = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                ironGolemEntity.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                ironGolemEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                world.spawnEntity(ironGolemEntity);
                world.spawnEntity(ironGolemEntity1);
                world.spawnEntity(ironGolemEntity2);
                world.spawnEntity(ironGolemEntity3);
                world.spawnEntity(ironGolemEntity4);
                world.spawnEntity(ironGolemEntity5);
                world.spawnEntity(ironGolemEntity6);
                world.spawnEntity(ironGolemEntity7);

            } else if (action == 8) {
                PhantomEntity phantomEntity = new PhantomEntity(EntityType.PHANTOM,world);
                PhantomEntity phantomEntity1 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity2 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity3 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity4 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity5 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity6 = new PhantomEntity(EntityType.PHANTOM, world);
                PhantomEntity phantomEntity7 = new PhantomEntity(EntityType.PHANTOM, world);
                phantomEntity.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                phantomEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                world.spawnEntity(phantomEntity);
                world.spawnEntity(phantomEntity1);
                world.spawnEntity(phantomEntity2);
                world.spawnEntity(phantomEntity3);
                world.spawnEntity(phantomEntity4);
                world.spawnEntity(phantomEntity5);
                world.spawnEntity(phantomEntity6);
                world.spawnEntity(phantomEntity7);

            } else if (action == 9) {
                WardenEntity wardenEntity = new WardenEntity(EntityType.WARDEN, world);
                wardenEntity.setPosition(blockPos.toCenterPos());
                world.spawnEntity(wardenEntity);

            } else if (action == 10) {
                user.setHealth(5);

            } else if (action == 11) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200), user);

            } else if (action == 12) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200), user);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 200), user);

            } else if (action == 13) {
                TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity1 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity2 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity3 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity4 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity5 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity6 = new TntEntity(EntityType.TNT, world);
                TntEntity tntEntity7 = new TntEntity(EntityType.TNT, world);
                tntEntity.setPosition(blockPos.toCenterPos());
                tntEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                tntEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                tntEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                tntEntity4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                tntEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                tntEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                tntEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                world.spawnEntity(tntEntity);
                world.spawnEntity(tntEntity1);
                world.spawnEntity(tntEntity2);
                world.spawnEntity(tntEntity3);
                world.spawnEntity(tntEntity4);
                world.spawnEntity(tntEntity5);
                world.spawnEntity(tntEntity6);
                world.spawnEntity(tntEntity7);

            } else if (action == 14) {
                ZombieEntity zombieEntity = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity1 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity2 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity3 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity4 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity5 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity6 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity7 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity8 = new ZombieEntity(EntityType.ZOMBIE, world);
                ZombieEntity zombieEntity9 = new ZombieEntity(EntityType.ZOMBIE, world);
                zombieEntity.setPosition(blockPos.toCenterPos());
                zombieEntity1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity2.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity3.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity4.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity6.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity7.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity8.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                zombieEntity9.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                world.spawnEntity(zombieEntity);
                world.spawnEntity(zombieEntity1);
                world.spawnEntity(zombieEntity2);
                world.spawnEntity(zombieEntity3);
                world.spawnEntity(zombieEntity4);
                world.spawnEntity(zombieEntity5);
                world.spawnEntity(zombieEntity6);
                world.spawnEntity(zombieEntity7);
                world.spawnEntity(zombieEntity8);
                world.spawnEntity(zombieEntity9);


            } else if (action == 15) {
                Entity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning1 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning2 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning3 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning4 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning5 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning6 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                Entity lightning7 = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.setPosition(blockPos.toCenterPos());
                lightning1.setPosition(blockPos.add(world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                lightning2.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                lightning3.setPosition(blockPos.add(world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                lightning4.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                lightning5.setPosition(blockPos.add(-world.getRandom().nextInt(8), world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                lightning6.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), world.getRandom().nextInt(8)).toCenterPos());
                lightning7.setPosition(blockPos.add(-world.getRandom().nextInt(8), -world.getRandom().nextInt(8), -world.getRandom().nextInt(8)).toCenterPos());
                world.spawnEntity(lightning);
                world.spawnEntity(lightning1);
                world.spawnEntity(lightning2);
                world.spawnEntity(lightning3);
                world.spawnEntity(lightning4);
                world.spawnEntity(lightning5);
                world.spawnEntity(lightning6);
                world.spawnEntity(lightning7);
                
            }

            if (!user.getAbilities().creativeMode) {
                itemStack.setDamage(itemStack.getDamage() + 1);
                if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                    itemStack.decrement(1);
                }
            }
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
