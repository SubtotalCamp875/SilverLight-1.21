package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class MeteorStaffItem extends RangedWeaponItem {
    public MeteorStaffItem(Settings settings) {
        super(settings);
    }

    private static float fireballStrength = 1;

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            ItemStack itemStack = playerEntity.getProjectileType(stack);
            if (!itemStack.isEmpty()) {
                int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = load(stack, itemStack, playerEntity);
                    if (world instanceof ServerWorld serverWorld && !list.isEmpty()) {
                        this.shootAll(serverWorld, user, user.getActiveHand(), stack, list, 2F, 1.0F, false, null);
                    }

                    world.playSound(null, user.getX(), user.getY(), user.getZ(),
                            SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 0.9f * 0.5F);
                }
            }
        }
    }

    @Override
    protected void shoot(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, @Nullable LivingEntity target) {
        projectile.setVelocity(shooter, shooter.getPitch(), shooter.getYaw() + yaw, 0.0F, speed, divergence);
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0F;
        f = f / 5.0F;
        if (f > 10.0F) {
            f = 10.0F;
        }

        setFireballStrength(f/2);
        return f;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl = !user.getProjectileType(itemStack).isEmpty();
        if (!user.isInCreativeMode() && !bl) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    public int getFireballStrength() {
        return (int) fireballStrength;
    }
    public static int setFireballStrength(float strength) {
        fireballStrength = strength;
        return 0;
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

        for (int j = 0; j < projectiles.size(); j++) {
            ItemStack itemStack = (ItemStack) projectiles.get(j);
            if (!itemStack.isEmpty()) {
                Vec3d vec3d = shooter.getRotationVec(1.0F);
                double f = shooter.getX() - (shooter.getX() + vec3d.x * 4.0);
                double g = shooter.getBodyY(0.5) - (0.5 + shooter.getBodyY(0.5));
                double h = shooter.getZ() - (shooter.getZ() + vec3d.z * 4.0);
                Vec3d vec3d2 = new Vec3d(f, g, h);

                FireballEntity fireballEntity = new FireballEntity(world, shooter, vec3d2.normalize(), this.getFireballStrength());
                fireballEntity.setPosition(shooter.getX() + vec3d.x * 3.0, shooter.getY()+1, fireballEntity.getZ() + vec3d.z * 3.0);
                world.spawnEntity(fireballEntity);

                stack.damage(this.getWeaponStackDamage(itemStack), shooter, LivingEntity.getSlotForHand(hand));
                shooter.sendMessage(Text.of(shooter.getName() + " summoned Fire Ball with the power of " + getFireballStrength()));
                if (stack.isEmpty()) {
                    break;
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.silverlight.meteor_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.meteor_staff_shift_down1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.meteor_staff_shift_down2.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.meteor_staff_shift_down3.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.silverlight.meteor_staff.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
