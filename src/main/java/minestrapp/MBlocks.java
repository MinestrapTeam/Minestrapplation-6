package minestrapp;

import minestrapp.blocks.*;
import minestrapp.blocks.crops.*;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.id)
public class MBlocks {
	
	public static List<Block> blocks = new ArrayList<Block>();

	// Stones
	public static Block redrock;
	public static Block deep_redrock;
	public static Block deepstone;
	public static Block coldstone;
	public static Block deep_coldstone;
	public static Block icestone;
	public static Block glacierrock;
	public static Block oceanstone;
	public static Block deep_oceanstone;


	//Slabs
	public static Block slab_deepstone;


	//Ores
	public static Block ore_tin;
	public static Block ore_titanium;
	public static Block ore_copper;
	public static Block ore_meurodite;
	public static Block ore_torite;
	public static Block ore_salt;
	public static Block ore_irradium;

	//Soil
	public static Block mud_dried;
	public static Block mud;
	public static Block cold_sand;
	public static Block cold_red_sand;

	//Crops
	public static Block crop_cabbage;
	public static Block crop_celery;
	public static Block crop_corn;
	public static Block crop_lettuce;
	public static Block crop_onion;
	public static Block crop_peanut;
	public static Block crop_pepper;
	public static Block crop_tomato;

	//Misc
	public static Block godstone;
	public static Block mite_honey;
	public static Block candle;
	
	static {
		//Stone and ore
		registerBlock(redrock = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "redrock"));
		registerBlock(deep_redrock = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "deep_redrock"));
		registerBlock(deepstone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "deepstone"));
		registerBlock(coldstone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "coldstone"));
		registerBlock(deep_coldstone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "deep_coldstone"));
		registerBlock(icestone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "icestone"));
		registerBlock(glacierrock = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "glacierrock"));
		registerBlock(oceanstone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "oceanstone"));
		registerBlock(deep_oceanstone = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "deep_oceanstone"));

		registerBlock(slab_deepstone = new SlabBlock(Block.Properties.create(Material.ROCK)).setRegistryName(Reference.id, "slab_deepstone"));

		registerBlock(ore_tin = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_tin"));
		registerBlock(ore_titanium = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_titanium"));
		registerBlock(ore_copper = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_copper"));
		registerBlock(ore_meurodite = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_meurodite"));
		registerBlock(ore_torite = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_torite"));
		registerBlock(ore_salt = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_salt"));
		registerBlock(ore_irradium = new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE)).setRegistryName(Reference.id, "ore_irradium"));

		//Soil
		registerBlock(mud_dried = new BlockDriedMud(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)).setRegistryName(Reference.id,"dried_mud"));
		registerBlock(mud = new BlockMud(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL).tickRandomly()).setRegistryName(Reference.id,"mud"));
		registerBlock(cold_sand = new BlockColdSand(15466239, Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)).setRegistryName(Reference.id,"cold_sand"));
		registerBlock(cold_red_sand = new BlockColdSand(16752010, Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)).setRegistryName(Reference.id,"cold_red_sand"));

		//Crop
		registerBlock(crop_cabbage = new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_cabbage"));
		registerBlock(crop_celery = new CropCelery(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_celery"));
		registerBlock(crop_corn = new CropCorn(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_corn"));
		registerBlock(crop_lettuce = new CropLettuce(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_lettuce"));
		registerBlock(crop_onion = new CropOnion(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_onion"));
		registerBlock(crop_peanut = new CropPeanut(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_peanuts"));
		registerBlock(crop_pepper = new CropPepper(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_pepper"));
		registerBlock(crop_tomato = new CropTomato(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()).setRegistryName(Reference.id, "crop_tomato"));

		//Misc
		registerBlock(mite_honey = new BlockMiteHoney(Block.Properties.create(Material.PLANTS)).setRegistryName(Reference.id,"mite_honey"));
		registerBlock(godstone = new BlockGodstone((Block.Properties.create(Material.GLASS).notSolid().tickRandomly())).setRegistryName(Reference.id, "godstone"));
		registerBlock(candle = new BlockCandle(Block.Properties.create(Material.CLAY).notSolid()).setRegistryName(Reference.id, "candle"));
	}
	
	public static void registerBlock(Block block) {
		blocks.add(block);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for(Block b: blocks) {
			event.getRegistry().register(b);
		}	
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		for(Block b: blocks) {
			if(!(b instanceof CropsBlock)){
				event.getRegistry().register(new BlockItem(b, new Item.Properties().group(Reference.minestrapp)).setRegistryName(b.getRegistryName()));
			}
		}
	}
}
