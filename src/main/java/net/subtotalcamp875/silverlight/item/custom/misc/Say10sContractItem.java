package net.subtotalcamp875.silverlight.item.custom.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.subtotalcamp875.silverlight.item.ModItems;

public class Say10sContractItem extends Item {
    public Say10sContractItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.BLOCK_NOTE_BLOCK_BELL, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (!world.isClient) {
            if (itemStack.getDamage() != itemStack.getMaxDamage()) {
                user.sendMessage(Text.of("This item has already been used"));
            } else if (user.getCommandTags().contains("say10s_contract")) {
                user.sendMessage(Text.of("You have already been cursed!"));
            } else {
                user.addCommandTag("say10s_contract");
                user.giveItemStack(ModItems.SAY10S_CHARM.getDefaultStack());
                itemStack.setDamage(itemStack.getMaxDamage());
            }
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
