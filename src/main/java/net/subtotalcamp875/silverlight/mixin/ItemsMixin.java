package net.subtotalcamp875.silverlight.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.subtotalcamp875.silverlight.SilverLight;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class ItemsMixin {
    @ModifyExpressionValue(method = "<clinit>", slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;DRAGON_EGG:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC)),
            at = @At(value = "NEW", target = "net/minecraft/item/Item$Settings", ordinal = 0))
    private static Item.Settings changeRecipeRemainderOfDragonEgg(Item.Settings original) {
        SilverLight.LOGGER.info("test");
        return original.recipeRemainder(Items.DRAGON_EGG);
    }
}
