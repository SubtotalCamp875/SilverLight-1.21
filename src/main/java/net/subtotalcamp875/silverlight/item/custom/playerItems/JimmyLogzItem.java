package net.subtotalcamp875.silverlight.item.custom.playerItems;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JimmyLogzItem extends Item {
    public JimmyLogzItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 100);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WIND_CHARGE_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            Vec3d vec3d = user.getRotationVec(1.0F);
            double f = user.getX() - (user.getX() + vec3d.x * 4.0);
            double g = user.getY();
            double h = user.getZ() - (user.getZ() + vec3d.z * 4.0);
            Vec3d vec3d2 = new Vec3d(f, g, h);
            FireballEntity fireballEntity = new FireballEntity(world, user, vec3d2.normalize(), 1);
            fireballEntity.setPosition(user.getX(), user.getY(), user.getZ());
            world.spawnEntity(fireballEntity);

            WindChargeEntity windChargeEntity = new WindChargeEntity(user, world, user.getX(), user.getY(), user.getZ());
            windChargeEntity.setVelocity(user, 90, 0, 0, 1.5F, 1.0F);
            world.spawnEntity(windChargeEntity);

            PotionEntity potionEntity = new PotionEntity(world, user);
            potionEntity.setItem(PotionContentsComponent.createStack(Items.LINGERING_POTION, Potions.POISON));
            world.spawnEntity(potionEntity);

        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
