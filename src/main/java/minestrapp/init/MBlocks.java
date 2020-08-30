package minestrapp.init;

import minestrapp.Reference;
import minestrapp.blocks.*;
import minestrapp.blocks.crops.*;
import minestrapp.blocks.machines.BlockBrickOven;
import minestrapp.blocks.machines.BlockMelter;
import net.minecraft.block.BedrockBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;
import java.util.function.Supplier;

public class MBlocks {

	//Registries
	public static final DeferredRegister<Block> BLOCK_REGISTRY = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.id);
	public static final DeferredRegister<Item> BLOCK_ITEM_REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.id);

	//Containers
	public static final RegistryObject<Block> MELTER = registerBlock("melter", () -> new BlockMelter(Block.Properties.create(Material.ROCK)), Reference.utility);
	public static final RegistryObject<Block> OVEN = registerBlock("brick_oven", () -> new BlockBrickOven(Block.Properties.create(Material.ROCK)), Reference.utility);

	// Stones
	public static final RegistryObject<Block> INVINCIUM = registerBlock("invincium", () -> new BedrockBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(-1.0F, 3600000.0F).noDrops()), Reference.environment);
	public static final RegistryObject<Block> REDROCK = registerBlock("redrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> DEEP_REDROCK = registerBlock("deep_redrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> DEEPSTONE = registerBlock("deepstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> COLDSTONE = registerBlock("coldstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> DEEP_COLDSTONE = registerBlock("deep_coldstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> ICESTONE = registerBlock("icestone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> GLACIERROCK = registerBlock("glacierrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> OCEANSTONE = registerBlock("oceanstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	public static final RegistryObject<Block> DEEP_OCEANSTONE = registerBlock("deep_oceanstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F,6.0F).harvestTool(ToolType.PICKAXE)), Reference.environment);
	// TODO Add respective cobblestones & drops

	//Slabs
	public static final RegistryObject<Block> SLAB_DEEPSTONE = registerBlock("slab_deepstone", () -> new SlabBlock(Block.Properties.create(Material.ROCK)), Reference.resource);

	//Ores
	public static final RegistryObject<Block> ORE_TIN = registerBlock("ore_tin", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_TITANIUM = registerBlock("ore_titanium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_COPPER = registerBlock("ore_copper", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_MEURODITE = registerBlock("ore_meurodite", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_TORITE = registerBlock("ore_torite", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_SALT = registerBlock("ore_salt", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_IRRADIUM = registerBlock("ore_irradium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_BLAZIUM = registerBlock("ore_blazium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> ORE_DIMENSIUM = registerBlock("ore_dimensium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);

	public static final RegistryObject<Block> BLAZIUM = registerBlock("block_blazium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);
	public static final RegistryObject<Block> COPPER_BLOCK = registerBlock("block_copper", () -> new BlockCopper(Block.Properties.create(Material.ROCK).tickRandomly().hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)), Reference.resource);

	//Soil
	public static final RegistryObject<Block> MUD_DRIED = registerBlock("dried_mud", () -> new BlockDriedMud(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)), Reference.environment);
	public static final RegistryObject<Block> MUD = registerBlock("mud", () -> new BlockMud(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)), Reference.environment);
	public static final RegistryObject<Block> COLD_SAND = registerBlock("cold_sand", () -> new BlockColdSand(new Color(55, 238, 244).getRGB(),Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)), Reference.environment);
	public static final RegistryObject<Block> COLD_RED_SAND = registerBlock("cold_red_sand", () -> new BlockColdSand(new Color(244, 114, 119).getRGB(), Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7F).harvestTool(ToolType.PICKAXE)), Reference.environment);

	//Crops
	public static final RegistryObject<Block> CROP_CABBAGE = registerBlockOnly("crop_cabbage", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_CELERY = registerBlockOnly("crop_celery", () -> new CropCelery(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_CORN = registerBlockOnly("crop_corn", () -> new CropCorn(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_LETTUCE = registerBlockOnly("crop_lettuce", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_ONION = registerBlockOnly("crop_onion", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_PEANUT = registerBlockOnly("crop_peanuts", () -> new CropPeanut(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_PEPPER = registerBlockOnly("crop_pepper", () -> new CropPepper(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_TOMATO = registerBlockOnly("crop_tomato", () -> new CropTomato(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));

	//Pavers
	//TODO add models and textures
	public static final RegistryObject<Block> REDROCK_PAVER = registerBlock("red_rock_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D), Reference.utility);
	public static final RegistryObject<Block> STONE_PAVER = registerBlock("stone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D), Reference.utility);
	public static final RegistryObject<Block> COLDSTONE_PAVER = registerBlock("coldstone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D), Reference.utility);
	public static final RegistryObject<Block> ICESTONE_PAVER = registerBlock("icestone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D), Reference.utility);
	public static final RegistryObject<Block> OCEANSTONE_PAVER = registerBlock("oceanstone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D), Reference.utility);
	public static final RegistryObject<Block> NETHERRACK_PAVER = registerBlock("netherrack_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.6D), Reference.utility);
	public static final RegistryObject<Block> ENDSTONE_PAVER = registerBlock("end_stone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.8D), Reference.utility);

	//Misc
	public static final RegistryObject<Block> GODSTONE = registerBlock("godstone", () -> new BlockGodstone(Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F)), Reference.resource);
	public static final RegistryObject<Block> MITE_HONEY = registerBlock("mite_honey", () -> new BlockMiteHoney(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)), Reference.resource);
	public static final RegistryObject<Block> CANDLE = registerBlock("candle", () -> new BlockCandle(Block.Properties.create(Material.EARTH)), Reference.decor);
	public static final RegistryObject<Block> GOBLET = registerBlock("goblet", () -> new BlockGoblet(Block.Properties.create(Material.EARTH)), Reference.decor);

	private static <T extends Block> RegistryObject<T> registerBlockOnly(String name, Supplier<? extends T> block){
		RegistryObject<T> object = BLOCK_REGISTRY.register(name, block);
		return object;
	}

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<? extends T> block, ItemGroup ig){
		RegistryObject<T> object = BLOCK_REGISTRY.register(name, block);
		BLOCK_ITEM_REGISTRY.register(name, registerBlockItem(object, ig));
		return object;
	}

	private static <T extends Block> Supplier<BlockItem> registerBlockItem(final RegistryObject<T> block, ItemGroup ig){
		return () -> new BlockItem(block.get(),  new Item.Properties().group(ig));
	}
}
