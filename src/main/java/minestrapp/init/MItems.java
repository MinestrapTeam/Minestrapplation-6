package minestrapp.init;

import minestrapp.Reference;
import minestrapp.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class MItems {

	//Registries
	public static final DeferredRegister<Item> ITEM_REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.id);

	//Tools
	public static final RegistryObject<Item> PICKAXE_COPPER = register("copper_pickaxe", () -> new PickaxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> AXE_COPPER = register("copper_axe", () -> new AxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> SHOVEL_COPPER = register("copper_shovel", () -> new ShovelItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> HOE_COPPER = register("copper_hoe", () -> new HoeItem(MItemTier.COPPER,1, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> SWORD_COPPER = register("copper_sword", () -> new SwordItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.combat)));
	public static final RegistryObject<Item> PICKAXE_BRONZE = register("bronze_pickaxe", () -> new PickaxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> AXE_BRONZE = register("bronze_axe", () -> new AxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> SHOVEL_BRONZE = register("bronze_shovel", () -> new ShovelItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> HOE_BRONZE = register("bronze_hoe", () -> new HoeItem(MItemTier.COPPER,1, (new Item.Properties()).group(Reference.tools)));
	public static final RegistryObject<Item> SWORD_BRONZE = register("bronze_sword", () -> new SwordItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.combat)));

	//Armor
	public static final RegistryObject<Item> TIN_HELM = register("tin_helm", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TIN_CHEST = register("tin_chest", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TIN_LEGS = register("tin_legs", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TIN_FEET = register("tin_feet", () -> new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BRONZE_HELM = register("bronze_helm", () -> new ArmorItem(MArmorMaterial.BRONZE, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BRONZE_CHEST = register("bronze_chest", () -> new ArmorItem(MArmorMaterial.BRONZE, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BRONZE_LEGS = register("bronze_legs", () -> new ArmorItem(MArmorMaterial.BRONZE, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BRONZE_FEET = register("bronze_feet", () -> new ArmorItem(MArmorMaterial.BRONZE, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TITANIUM_HELM = register("titanium_helm", () -> new ArmorItem(MArmorMaterial.TITANIUM, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TITANIUM_CHEST = register("titanium_chest", () -> new ArmorItem(MArmorMaterial.TITANIUM, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TITANIUM_LEGS = register("titanium_legs", () -> new ArmorItem(MArmorMaterial.TITANIUM, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TITANIUM_FEET = register("titanium_feet", () -> new ArmorItem(MArmorMaterial.TITANIUM, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> MEURODITE_HELM = register("meurodite_helm", () -> new ArmorItem(MArmorMaterial.MEURODITE, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> MEURODITE_CHEST = register("meurodite_chest", () -> new ArmorItem(MArmorMaterial.MEURODITE, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> MEURODITE_LEGS = register("meurodite_legs", () -> new ArmorItem(MArmorMaterial.MEURODITE, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> MEURODITE_FEET = register("meurodite_feet", () -> new ArmorItem(MArmorMaterial.MEURODITE, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TORITE_HELM = register("torite_helm", () -> new ArmorItem(MArmorMaterial.TORITE, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TORITE_CHEST = register("torite_chest", () -> new ArmorItem(MArmorMaterial.TORITE, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TORITE_LEGS = register("torite_legs", () -> new ArmorItem(MArmorMaterial.TORITE, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> TORITE_FEET = register("torite_feet", () -> new ArmorItem(MArmorMaterial.TORITE, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BLAZIUM_HELM = register("fire_helm", () -> new ArmorItem(MArmorMaterial.BLAZIUM, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BLAZIUM_CHEST = register("fire_chest", () -> new ArmorItem(MArmorMaterial.BLAZIUM, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BLAZIUM_LEGS = register("fire_legs", () -> new ArmorItem(MArmorMaterial.BLAZIUM, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.combat))));
	public static final RegistryObject<Item> BLAZIUM_FEET = register("fire_feet", () -> new ArmorItem(MArmorMaterial.BLAZIUM, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.combat))));


	//Ingots, Gems, and chunks
	public static final RegistryObject<Item> INGOT_TIN = register("ingot_tin", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> INGOT_TITANIUM = register("ingot_titanium", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> INGOT_COPPER = register("ingot_copper", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> GEM_MEURODITE = register("gem_meurodite", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> INGOT_TORITE = register("ingot_torite", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> IRRADIUM = register("irradium", () -> new Item((new Item.Properties()).group(Reference.minerals)));
	public static final RegistryObject<Item> CHUNK_REDROCK = register("chunk_redrock", () -> new Item((new Item.Properties().group(Reference.minerals))));
	public static final RegistryObject<Item> CHUNK_STONE = register("chunk_stone", () -> new Item((new Item.Properties().group(Reference.minerals))));
	public static final RegistryObject<Item> CHUNK_COLDSTONE = register("chunk_coldstone", () -> new Item((new Item.Properties().group(Reference.minerals))));
	public static final RegistryObject<Item> CHUNK_ICESTONE = register("chunk_icestone", () -> new Item((new Item.Properties().group(Reference.minerals))));
	public static final RegistryObject<Item> CHUNK_OCEANSTONE = register("chunk_oceanstone", () -> new Item((new Item.Properties().group(Reference.minerals))));
	public static final RegistryObject<Item> CHUNK_NETHERRACK = register("chunk_netherrack", () -> new Item((new Item.Properties().group(Reference.minerals))));

	//Food and Seeds
	public static final RegistryObject<Item> CABBAGE = register("cabbage", () -> new Item((new Item.Properties()).group(Reference.food).food(MFoods.CABBAGE)));
	public static final RegistryObject<Item> CELERY = register("celery", () -> new Item((new Item.Properties()).group(Reference.food).food(MFoods.CELERY)));
	public static final RegistryObject<Item> CORN = register("corn", () -> new BlockNamedItem(MBlocks.CROP_CORN.get(), (new Item.Properties()).group(Reference.food).food(MFoods.CORN)));
	public static final RegistryObject<Item> LETTUCE = register("lettuce", () -> new BlockNamedItem(MBlocks.CROP_LETTUCE.get(), (new Item.Properties()).group(Reference.food).food(MFoods.LETTUCE)));
	public static final RegistryObject<Item> ONION = register("onion", () -> new BlockNamedItem(MBlocks.CROP_ONION.get(), (new Item.Properties()).group(Reference.food).food(MFoods.ONION)));
	public static final RegistryObject<Item> PEANUT = register("peanuts", () -> new BlockNamedItem(MBlocks.CROP_PEANUT.get(), (new Item.Properties()).group(Reference.food).food(MFoods.PEANUT)));
	public static final RegistryObject<Item> PEPPER = register("pepper", () -> new Item((new Item.Properties()).group(Reference.food).food(MFoods.PEPPER)));
	public static final RegistryObject<Item> TOMATO = register("tomato", () -> new Item((new Item.Properties()).group(Reference.food).food(MFoods.TOMATO)));
	public static final RegistryObject<Item> SEEDS_CABBAGE = register("cabbage_seeds", () -> new BlockNamedItem(MBlocks.CROP_CABBAGE.get(), (new Item.Properties()).group(Reference.plant)));
	public static final RegistryObject<Item> SEEDS_CELERY = register("celery_seeds", () -> new BlockNamedItem(MBlocks.CROP_CELERY.get(), (new Item.Properties()).group(Reference.plant)));
	public static final RegistryObject<Item> SEEDS_PEPPER = register("pepper_seeds", () -> new BlockNamedItem(MBlocks.CROP_PEPPER.get(), (new Item.Properties()).group(Reference.plant)));
	public static final RegistryObject<Item> SEEDS_TOMATO = register("tomato_seeds", () -> new BlockNamedItem(MBlocks.CROP_TOMATO.get(), (new Item.Properties()).group(Reference.plant)));


	//Misc
<<<<<<< HEAD
	public static final RegistryObject<Item> TALLOW = register("tallow", () -> new Item((new Item.Properties()).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HEALTH_CONTAINER = register("heart_container", () -> new ItemHealthContainer(new Item.Properties().maxStackSize(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> HEALTH_CRYSTAL = register("health_crystal", () -> new ItemHealthCrystal(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SMELLING_SALTS = register("smelling_salts", () -> new ItemSmellingSalts(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> SOUL_GEM = register("gem_soul", () -> new ItemSoulGem(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
	public static final RegistryObject<Item> TOTEM_WEATHER = register("totem_of_weather", () -> new ItemTotemWeather(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)));
=======
	public static final RegistryObject<Item> TALLOW = register("tallow", () -> new Item((new Item.Properties()).group(Reference.resource)));
	public static final RegistryObject<Item> HEALTH_CONTAINER = register("heart_container", () -> new ItemHealthContainer(new Item.Properties().maxStackSize(1).group(Reference.utility)));
	public static final RegistryObject<Item> HEALTH_CRYSTAL = register("health_crystal", () -> new ItemHealthCrystal(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.utility)));
	public static final RegistryObject<Item> SMELLING_SALTS = register("smelling_salts", () -> new ItemSmellingSalts(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.utility)));
	public static final RegistryObject<Item> SOUL_GEM = register("gem_soul", () -> new ItemSoulGem(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.resource)));
	public static final RegistryObject<Item> TOTEM_WEATHER = register("totem_of_weather", () -> new ItemTotemWeather(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.utility)));
>>>>>>> ad4db1569fb86bbf3d7908dedf5ac0a974b570c6
	public static final RegistryObject<Item> SOUL_BOTTLE = register("soul_bottle", () -> new ItemSoulBottle(new Item.Properties().group(Reference.minestrapp)));

	public static final RegistryObject<Item> BACKPACK = register("backpack", () -> new ItemBackpack(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.utility)));

	public static <T extends Item> RegistryObject<T> register(String name, Supplier<? extends T> e){
		return ITEM_REGISTRY.register(name , e);
	}
}
