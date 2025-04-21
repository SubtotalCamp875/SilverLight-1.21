package net.subtotalcamp875.silverlight.item.custom.staffs;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class ArrowStaffItem extends RangedWeaponItem {
    public ArrowStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        ItemStack itemStack = user.getProjectileType(stack);
        ItemStack offHandStack = user.getOffHandStack();

        if ((offHandStack.getItem() == ModItems.METEOR_CHARM) && (itemStack.getDamage() != itemStack.getMaxDamage()) && (offHandStack.getDamage() != offHandStack.getMaxDamage())) {
            user.sendMessage(Text.of("§6Arrows fused with the power of Meteors - How could a single staff possibly handle all this power?§r"));
            offHandStack.setDamage(offHandStack.getMaxDamage());
            itemStack.setDamage(itemStack.getMaxDamage());
            user.giveItemStack(ModItems.EXPLOSION_RAIN_STAFF.getDefaultStack());

        } else if (!itemStack.isEmpty() && (itemStack.getDamage() != itemStack.getMaxDamage())) {
            List<ItemStack> list = load(stack, itemStack, user);
            if (world instanceof ServerWorld serverWorld && !list.isEmpty()) {
                this.shootAll(serverWorld, user, user.getActiveHand(), stack, list, 2F, 1.0F, false, null);
                itemStack.setDamage(itemStack.getDamage() +1);
            }

            world.playSound(
                    null,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    SoundEvents.ENTITY_ARROW_SHOOT,
                    SoundCategory.PLAYERS,
                    1.0F,
                    1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 0.9f * 0.5F
            );
        } else {
            user.sendMessage(Text.of("This item has already been used"));
        }
        return TypedActionResult.fail(stack);
    }

    @Override
    protected void shootAll (
            ServerWorld world,
            LivingEntity shooter,
            Hand hand,
            ItemStack stack,
            List<ItemStack> projectiles,
            float speed,
            float divergence,
            boolean critical,
            @Nullable LivingEntity target
	) {
        float i = 1.0F;

        for (int j = 0; j < projectiles.size(); j++) {
            ItemStack itemStack = (ItemStack) projectiles.get(j);
            if (!itemStack.isEmpty()) {
                i = -i;
                ProjectileEntity projectileEntity = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity, j, speed, divergence, 0, target);
                world.spawnEntity(projectileEntity);

                ProjectileEntity projectileEntity9 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity9, j, speed, divergence, 22.5f, target);
                world.spawnEntity(projectileEntity9);

                ProjectileEntity projectileEntity5 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity5, j, speed, divergence, 45, target);
                world.spawnEntity(projectileEntity5);

                ProjectileEntity projectileEntity10 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity10, j, speed, divergence, 45+22.5f, target);
                world.spawnEntity(projectileEntity10);

                ProjectileEntity projectileEntity1 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity1, j, speed, divergence, 90, target);
                world.spawnEntity(projectileEntity1);

                ProjectileEntity projectileEntity11 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity11, j, speed, divergence, 90+22.5f, target);
                world.spawnEntity(projectileEntity11);

                ProjectileEntity projectileEntity7 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity7, j, speed, divergence, 90+45, target);
                world.spawnEntity(projectileEntity7);

                ProjectileEntity projectileEntity12 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity12, j, speed, divergence, 90+45+22.5f, target);
                world.spawnEntity(projectileEntity12);

                ProjectileEntity projectileEntity4 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity4, j, speed, divergence, 180, target);
                world.spawnEntity(projectileEntity4);

                ProjectileEntity projectileEntity13 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity13, j, speed, divergence, 22.5f, target);
                world.spawnEntity(projectileEntity13);

                ProjectileEntity projectileEntity6 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity6, j, speed, divergence, -45, target);
                world.spawnEntity(projectileEntity6);

                ProjectileEntity projectileEntity14 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity14, j, speed, divergence, -45-22.5f, target);
                world.spawnEntity(projectileEntity14);

                ProjectileEntity projectileEntity3 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity3, j, speed, divergence, -90, target);
                world.spawnEntity(projectileEntity3);

                ProjectileEntity projectileEntity15 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity15, j, speed, divergence, -90-22.5f, target);
                world.spawnEntity(projectileEntity15);

                ProjectileEntity projectileEntity8 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity8, j, speed, divergence, -90-45, target);
                world.spawnEntity(projectileEntity8);

                ProjectileEntity projectileEntity16 = this.createArrowEntity(world, shooter, stack, itemStack, critical);
                this.shoot(shooter, projectileEntity16, j, speed, divergence, -90-45-22.5f, target);
                world.spawnEntity(projectileEntity16);

                stack.damage(this.getWeaponStackDamage(itemStack), shooter, LivingEntity.getSlotForHand(hand));
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
    }

}
