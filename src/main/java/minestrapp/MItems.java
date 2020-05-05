package minestrapp;

import minestrapp.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.id)
public class MItems {

	public static List<Item> items = new ArrayList<Item>();

	//Tools
	public static Item pickaxe_copper;
	public static Item axe_copper;
	public static Item shovel_copper;
	public static Item hoe_copper;
	public static Item sword_copper;
	public static Item pickaxe_bronze;
	public static Item axe_bronze;
	public static Item shovel_bronze;
	public static Item hoe_bronze;
	public static Item sword_bronze;

	//Armor
	public static Item tin_helm;
	public static Item tin_chest;
	public static Item tin_legs;
	public static Item tin_feet;

	//Ingots
	public static Item ingot_tin;
	public static Item ingot_titanium;
	public static Item ingot_copper;
	public static Item ingot_meurodite;
	public static Item ingot_torite;
	public static Item ingot_irradium;


	//Food and Seeds
	public static Item cabbage;
	public static Item celery;
	public static Item corn;
	public static Item lettuce;
	public static Item onion;
	public static Item peanut;
	public static Item pepper;
	public static Item tomato;
	public static Item seeds_cabbage;
	public static Item seeds_celery;
	public static Item seeds_pepper;
	public static Item seeds_tomato;

	//Misc
	public static Item tallow;
	public static Item health_container;
	public static Item health_crystal;
	public static Item smelling_salts;
	public static Item soul_gem;

	static {
		//Tools //TODO implement Minestrapp tool items instead of using vanilla
		registerItem(pickaxe_copper = new PickaxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "copper_pickaxe"));
		registerItem(axe_copper = new AxeItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "copper_axe"));
		registerItem(shovel_copper = new ShovelItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "copper_shovel"));
		registerItem(hoe_copper = new HoeItem(MItemTier.COPPER,1, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "copper_hoe"));
		registerItem(sword_copper = new SwordItem(MItemTier.COPPER,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "copper_sword"));
		registerItem(pickaxe_bronze = new PickaxeItem(MItemTier.BRONZE,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "bronze_pickaxe"));
		registerItem(axe_bronze = new AxeItem(MItemTier.BRONZE,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "bronze_axe"));
		registerItem(shovel_bronze = new ShovelItem(MItemTier.BRONZE,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "bronze_shovel"));
		registerItem(hoe_bronze = new HoeItem(MItemTier.BRONZE,1, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "bronze_hoe"));
		registerItem(sword_bronze = new SwordItem(MItemTier.BRONZE,8,-3.15F, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "bronze_sword"));

		//Armor
		registerItem((tin_helm = new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.HEAD, (new Item.Properties().group(Reference.minestrapp)))).setRegistryName(Reference.id, "tin_helm"));
		registerItem((tin_chest = new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.CHEST, (new Item.Properties().group(Reference.minestrapp)))).setRegistryName(Reference.id, "tin_chest"));
		registerItem((tin_legs = new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.LEGS, (new Item.Properties().group(Reference.minestrapp)))).setRegistryName(Reference.id, "tin_legs"));
		registerItem((tin_feet = new ArmorItem(MArmorMaterial.TIN, EquipmentSlotType.FEET, (new Item.Properties().group(Reference.minestrapp)))).setRegistryName(Reference.id, "tin_feet"));

		//Ingots
		registerItem(ingot_tin = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_tin"));
		registerItem(ingot_titanium = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_titanium"));
		registerItem(ingot_copper = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_copper"));
		registerItem(ingot_meurodite = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_meurodite"));
		registerItem(ingot_torite = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_torite"));
		registerItem(ingot_irradium = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "ingot_irradium"));

		//Food and Seeds
		registerItem(cabbage = new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.CABBAGE)).setRegistryName(Reference.id, "cabbage"));
		registerItem(celery = new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.CELERY)).setRegistryName(Reference.id, "celery"));
		registerItem(corn = new BlockNamedItem(MBlocks.crop_corn, (new Item.Properties()).group(Reference.minestrapp).food(MFoods.CORN)).setRegistryName(Reference.id, "corn"));
		registerItem(lettuce = new BlockNamedItem(MBlocks.crop_lettuce, (new Item.Properties()).group(Reference.minestrapp).food(MFoods.LETTUCE)).setRegistryName(Reference.id, "lettuce"));
		registerItem(onion = new BlockNamedItem(MBlocks.crop_onion, (new Item.Properties()).group(Reference.minestrapp).food(MFoods.ONION)).setRegistryName(Reference.id, "onion"));
		registerItem(peanut = new BlockNamedItem(MBlocks.crop_peanut, (new Item.Properties()).group(Reference.minestrapp).food(MFoods.PEANUT)).setRegistryName(Reference.id, "peanuts"));
		registerItem(pepper = new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.PEPPER)).setRegistryName(Reference.id, "pepper"));
		registerItem(tomato = new Item((new Item.Properties()).group(Reference.minestrapp).food(MFoods.TOMATO)).setRegistryName(Reference.id, "tomato"));
		registerItem(seeds_cabbage = new BlockNamedItem(MBlocks.crop_cabbage, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "cabbage_seeds"));
		registerItem(seeds_celery = new BlockNamedItem(MBlocks.crop_celery, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "celery_seeds"));
		registerItem(seeds_pepper = new BlockNamedItem(MBlocks.crop_pepper, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "pepper_seeds"));
		registerItem(seeds_tomato = new BlockNamedItem(MBlocks.crop_tomato, (new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "tomato_seeds"));

		//Misc
		registerItem(tallow = new Item((new Item.Properties()).group(Reference.minestrapp)).setRegistryName(Reference.id, "tallow"));
		registerItem(health_container = new ItemHealthContainer(new Item.Properties().maxStackSize(1).group(Reference.minestrapp)).setRegistryName(Reference.id, "heart_container"));
		registerItem(health_crystal = new ItemHealthCrystal(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)).setRegistryName(Reference.id, "health_crystal"));
		registerItem(smelling_salts = new ItemSmellingSalts(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)).setRegistryName(Reference.id, "smelling_salts"));
		registerItem(soul_gem = new ItemSoulGem(new Item.Properties().maxStackSize(1).maxDamage(1).group(Reference.minestrapp)).setRegistryName(Reference.id, "gem_soul"));

	}
	
	public static void registerItem(Item item) {
		items.add(item);
	}
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
		for(Item i: items){
			event.getRegistry().register(i);
		}
	}
}
