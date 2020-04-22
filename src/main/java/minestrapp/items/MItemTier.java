package minestrapp.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum MItemTier implements IItemTier {

    COPPER(1, 200,5F, 1.5F,17, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    BRONZE(2, 1000,5F, 1.5F,13, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    STEEL(2, 500,7.5F, 2.5F,19, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    MEURODITE(2, 906,7F, 2.5F,16, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    TORITE(2, 1200,7F, 3.5F,30, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    BLAZIUM(2, 960,7.5F, 3F,22, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    GLACIERITE(3, 1400,8F, 8F,34, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }),
    BEDROCK(4, 6244,6F, 1.5F,6, () ->{
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    });




    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private MItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
