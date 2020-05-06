package minestrapp;

import minestrapp.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MItems {

	//Registries
	public static final DeferredRegister<Item> ITEM_REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.id);

	//Tools
	public static final RegistryObject<Item> PICKAXE_COPPER = ITEM_REGISTRY.register("copper_pickaxe", () -> new PickaxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> AXE_COPPER = ITEM_REGISTRY.register("copper_axe", () -> new AxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SHOVEL_COPPER = ITEM_REGISTRY.register("copper_shovel", () -> new ShovelItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HOE_COPPER = ITEM_REGISTRY.register("copper_hoe", () -> new HoeItem(MItemTier.COPPER,1, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SWORD_COPPER = ITEM_REGISTRY.register("copper_sword", () -> new SwordItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> PICKAXE_BRONZE = ITEM_REGISTRY.register("bronze_pickaxe", () -> new PickaxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> AXE_BRONZE = ITEM_REGISTRY.register("bronze_axe", () -> new AxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SHOVEL_BRONZE = ITEM_REGISTRY.register("bronze_shovel", () -> new ShovelItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HOE_BRONZE = ITEM_REGISTRY.register("bronze_hoe", () -> new HoeItem(MItemTier.COPPER,1, (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SWORD_BRONZE = ITEM_REGISTRY.register("bronze_sword", () -> new SwordItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)));

	//Armor
	public static final RegistryObject<Item> TIN_HELM = ITEM_REGISTRY.register("tin_helm", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.minestrapp))));
	public static final RegistryObject<Item> TIN_CHEST = ITEM_REGISTRY.register("tin_chest", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.minestrapp))));
	public static final RegistryObject<Item> TIN_LEGS = ITEM_REGISTRY.register("tin_legs", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.minestrapp))));
	public static final RegistryObject<Item> TIN_FEET = ITEM_REGISTRY.register("tin_feet", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.minestrapp))));

	//Ingots, Gems, and chunks
	public static final RegistryObject<Item> INGOT_TIN = ITEM_REGISTRY.register("ingot_tin", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> INGOT_TITANIUM = ITEM_REGISTRY.register("ingot_titanium", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> INGOT_COPPER = ITEM_REGISTRY.register("ingot_copper", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> GEM_MEURODITE = ITEM_REGISTRY.register("gem_meurodite", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> INGOT_TORITE = ITEM_REGISTRY.register("ingot_torite", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> IRRADIUM = ITEM_REGISTRY.register("irradium", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));


	//Food and Seeds
	public static final RegistryObject<Item> CABBAGE = ITEM_REGISTRY.register("cabbage", () -> new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.CABBAGE)));
	public static final RegistryObject<Item> CELERY = ITEM_REGISTRY.register("celery", () -> new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.CELERY)));
	public static final RegistryObject<Item> CORN = ITEM_REGISTRY.register("corn", () -> new BlockNamedItem(MBlocks.CROP_CORN.get(), (new Item.Properties()).group(Reference.minestrapp).food(MFoods.CORN)));
	public static final RegistryObject<Item> LETTUCE = ITEM_REGISTRY.register("lettuce", () -> new BlockNamedItem(MBlocks.CROP_LETTUCE.get(), (new Item.Properties()).group(Reference.minestrapp).food(MFoods.LETTUCE)));
	public static final RegistryObject<Item> ONION = ITEM_REGISTRY.register("onion", () -> new BlockNamedItem(MBlocks.CROP_ONION.get(), (new Item.Properties()).group(Reference.minestrapp).food(MFoods.ONION)));
	public static final RegistryObject<Item> PEANUT = ITEM_REGISTRY.register("peanuts", () -> new BlockNamedItem(MBlocks.CROP_PEANUT.get(), (new Item.Properties()).group(Reference.minestrapp).food(MFoods.PEANUT)));
	public static final RegistryObject<Item> PEPPER = ITEM_REGISTRY.register("pepper", () -> new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.PEPPER)));
	public static final RegistryObject<Item> TOMATO = ITEM_REGISTRY.register("tomato", () -> new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.TOMATO)));
	public static final RegistryObject<Item> SEEDS_CABBAGE = ITEM_REGISTRY.register("cabbage_seeds", () -> new BlockNamedItem(MBlocks.CROP_CABBAGE.get(), (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SEEDS_CELERY = ITEM_REGISTRY.register("celery_seeds", () -> new BlockNamedItem(MBlocks.CROP_CELERY.get(), (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SEEDS_PEPPER = ITEM_REGISTRY.register("pepper_seeds", () -> new BlockNamedItem(MBlocks.CROP_PEPPER.get(), (new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SEEDS_TOMATO = ITEM_REGISTRY.register("tomato_seeds", () -> new BlockNamedItem(MBlocks.CROP_TOMATO.get(), (new Item.Properties()).group(Reference.minestrapp)));


	//Misc
	public static final RegistryObject<Item> TALLOW = ITEM_REGISTRY.register("tallow", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HEALTH_CONTAINER = ITEM_REGISTRY.register("heart_container", () -> new ItemHealthContainer(new Item.Properties().maxStackSize(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HEALTH_CRYSTAL = ITEM_REGISTRY.register("health_crystal", () -> new ItemHealthCrystal(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SMELLING_SALTS = ITEM_REGISTRY.register("smelling_salts", () -> new ItemSmellingSalts(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SOUL_GEM = ITEM_REGISTRY.register("gem_soul", () -> new ItemSoulGem(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
}
