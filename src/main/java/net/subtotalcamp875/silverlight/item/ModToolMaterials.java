package net.subtotalcamp875.silverlight.item;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.subtotalcamp875.silverlight.util.ModTags;

import java.util.function.Supplier;


public enum ModToolMaterials implements ToolMaterial {
    VIKING_AXE_MATERIAL(ModTags.Blocks.VIKING_AXE_MATERIAL,
            2031, 1.0F, 0f, 15, () -> Ingredient.ofItems(Items.NETHER_STAR)),
    CANDY_CANE_MATERIAL(ModTags.Blocks.CANDY_CANE_MATERIAL,
            100, 0.0F, 0f, 0, () -> Ingredient.ofItems(Items.SUGAR)),
    THORS_HAMMER_MATERIAL(ModTags.Blocks.THORS_HAMMER_MATERIAL,
            500, 0.0F, 0f, 20, () -> Ingredient.ofItems(Items.NETHER_STAR)),
    REAPERS_SCYTHE_MATERIAL(ModTags.Blocks.REAPERS_SCYTHE_MATERIAL,
            1, 0.0F, 1f, 0, () -> Ingredient.ofItems(Items.BEDROCK));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
