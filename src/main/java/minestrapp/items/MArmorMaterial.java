package minestrapp.items;

import minestrapp.MItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

//TODO add the correct repair materials
public enum MArmorMaterial implements IArmorMaterial {
    TIN("tin", 4, new int[]{1, 3, 4, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_tin});
    }),
    BRONZE("bronze", 28, new int[]{2, 4, 5, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_copper});
    }),
    STEEL("steel", 18, new int[]{3, 6, 7, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_tin});
    }),
    MEURODITE("meurodite", 24, new int[]{2, 6, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_meurodite});
    }),
    TORITE("torite", 26, new int[]{2, 6, 7, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_torite});
    }),
    BLAZIUM("blazium", 25, new int[]{2, 5, 6, 3}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.2F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_copper});
    }),
    GLACIERITE("glacierite", 28, new int[]{2, 6, 7, 2}, 34, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{MItems.ingot_tin});
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private MArmorMaterial(String name, int maxDamage, int[] damageReductionAmountArray, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairItem) {
        this.name = name;
        this.maxDamageFactor = maxDamage;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = sound;
        this.toughness = toughness;
        this.repairMaterial = new LazyValue(repairItem);
    }

    public int getDurability(EquipmentSlotType p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
}
