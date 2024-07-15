package net.subtotalcamp875.silverlight.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class ItemsMixin {
    @ModifyExpressionValue(method = "<clinit>", slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/item/Items;DRAGON_EGG:Lnet/minecraft/item/Item;")),
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;rarity(Lnet/minecraft/util/Rarity;)Lnet/minecraft/item/Item$Settings;"))
    private static Item.Settings changeRecipeRemainderOfDragonEgg(Item.Settings original) {
        return original.recipeRemainder(Items.DRAGON_EGG);
    }
}