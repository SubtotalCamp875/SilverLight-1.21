package net.subtotalcamp875.silverlight.item.custom;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class DevCampItem extends Item {
    public DevCampItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 1728000);
        //user.getItemCooldownManager().set(this, 20);
        ItemStack itemStack = user.getStackInHand(hand);



        if (!world.isClient) {
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                user.sendMessage(Text.of("Developer875 is burnt out"));
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

            } else {
                int action = world.getRandom().nextInt(20);
                world.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.NEUTRAL, 2f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

                if (action == 0) {
                    user.giveItemStack(ModItems.LEFT_RING.getDefaultStack());
                } else if (action == 1) {
                    user.giveItemStack(ModItems.RIGHT_RING.getDefaultStack());
                } else if (action == 2) {
                    user.giveItemStack(ModItems.XP_TANK.getDefaultStack());
                } else if (action == 3) {
                    user.giveItemStack(ModItems.GROUNDED.getDefaultStack());
                } else if (action == 4) {
                    user.giveItemStack(ModItems.AVA.getDefaultStack());
                } else if (action == 5) {
                    user.giveItemStack(ModItems.YACKAMAID.getDefaultStack());
                } else if (action == 6) {
                    user.giveItemStack(ModItems.JIMMYLOGZ.getDefaultStack());
                } else if (action == 7) {
                    user.giveItemStack(ModItems.BITCOIN.getDefaultStack());
                } else if (action == 8) {
                    user.giveItemStack(ModItems.LEECH.getDefaultStack());
                } else if (action == 9) {
                    user.giveItemStack(ModItems.HOLY_SHIELD_GENERATOR.getDefaultStack());
                } else if (action == 10) {
                    user.giveItemStack(ModItems.REAPERS_SCYTHE.getDefaultStack());
                } else if (action == 11) {
                    user.giveItemStack(ModItems.MINIGUN_STICK.getDefaultStack());
                } else if (action == 12) {
                    user.giveItemStack(ModItems.ARROW_STAFF.getDefaultStack());
                } else if (action == 13) {
                    user.giveItemStack(ModItems.SOUND_STAFF.getDefaultStack());
                } else if (action == 14) {
                    user.giveItemStack(ModItems.DICE_STAFF.getDefaultStack());
                } else if (action == 15) {
                    user.giveItemStack(ModItems.DEATH_STAFF.getDefaultStack());
                } else if (action == 16) {
                    user.giveItemStack(ModItems.HORN_OF_BRAN_GALED.getDefaultStack());
                } else if (action == 17) {
                    user.giveItemStack(ModItems.THORS_HAMMER.getDefaultStack());
                } else if (action == 18) {
                    user.giveItemStack(ModItems.CANDY_CANE.getDefaultStack());
                } else if (action == 19) {
                    user.giveItemStack(ModItems.SAY10S_CONTRACT.getDefaultStack());
                }

                if (!user.getAbilities().creativeMode) {
                    itemStack.setDamage(itemStack.getDamage() + 1);
                }
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
