package net.subtotalcamp875.silverlight.item.custom.progression;

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
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;
import org.apache.logging.log4j.core.jmx.Server;

public class MysteriousCompassItem extends Item {
    public MysteriousCompassItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 5);
        ItemStack itemStack = user.getStackInHand(hand);
        Position position = user.getPos();

        if (!world.isClient) {
            if (itemStack.getDamage() == itemStack.getMaxDamage()) {
                user.sendMessage(Text.of("This item has already been used"));


            } else if ((-0.05 < position.getX() && position.getX() < 0.05) && (-0.05 < position.getZ() && position.getZ() < 0.05)) {
                user.sendMessage(Text.of("§dThe Compass has created a noise...§r"));
                itemStack.setDamage(itemStack.getMaxDamage());
                user.giveItemStack(ModItems.ACTIVATED_MYSTERIOUS_COMPASS.getDefaultStack());
            } else if ((-1.5 < position.getX() && position.getX() < 1.5) && (-1.5 < position.getZ() && position.getZ() < 1.5)) {
                user.sendMessage(Text.of("§dThe Compass is v§kib§r§dr§kat§r§ding with MYSTERIOUS energy...§r"));

            } else if (isX(position)) {
                if (isPos(position.getX())) { //biggest number is pos x
                    user.sendMessage(Text.of("§dThe Compass is reacting to a MYSTERIOUS energy. It tells the player, \"Perhaps head " + "§5West§d?\"§r"));
                } else { //biggest number is neg x
                    user.sendMessage(Text.of("§dThe Compass is reacting to a MYSTERIOUS energy. It tells the player, \"Perhaps head " + "§5East§d?\"§r"));
                }
            } else {
                if (isPos(position.getZ())) { //biggest number is pos z
                    user.sendMessage(Text.of("§dThe Compass is reacting to a MYSTERIOUS energy. It tells the player, \"Perhaps head " + "§5North§d?\"§r"));
                } else { //biggest number is neg z
                    user.sendMessage(Text.of("§dThe Compass is reacting to a MYSTERIOUS energy. It tells the player, \"Perhaps head " + "§5South§d?\"§r"));
                }
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    private boolean isX(Position position) {
        return Math.abs(position.getX()) >= Math.abs(position.getZ());
    }

    private  boolean isPos(double value){
        return (value == Math.abs(value));
    }
}
