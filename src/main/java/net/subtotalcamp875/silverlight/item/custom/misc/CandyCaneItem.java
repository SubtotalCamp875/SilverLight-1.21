package net.subtotalcamp875.silverlight.item.custom.misc;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class CandyCaneItem extends SwordItem {
    public CandyCaneItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setHealth(target.getHealth()-(stack.getDamage()/40f));
        attacker.setHealth(attacker.getHealth()-((stack.getDamage()/40f)*0.6f));
        attacker.tiltScreen(target.getX() - attacker.getX(), target.getZ() - attacker.getZ());

        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {

        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.silverlight.candy_cane.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.candy_cane_shift_down1.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.candy_cane_shift_down2.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.candy_cane_shift_down3.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.silverlight.candy_cane.tooltip"));
            tooltip.add(Text.translatable("tooltip.silverlight.shift.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
