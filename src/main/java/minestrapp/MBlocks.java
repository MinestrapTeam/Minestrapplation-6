package minestrapp;

import minestrapp.blocks.*;
import minestrapp.blocks.crops.*;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;

public class MBlocks {

	//Registries
	public static final DeferredRegister<Block> BLOCK_REGISTRY = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.id);
	public static final DeferredRegister<Item> BLOCK_ITEM_REGISTRY = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.id);

	// Stones
	public static final RegistryObject<Block> REDROCK = BLOCK_REGISTRY.register("redrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  REDROCK_ITEM = BLOCK_ITEM_REGISTRY.register("redrock", () -> new BlockItem(REDROCK.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> DEEP_REDROCK = BLOCK_REGISTRY.register("deep_redrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  DEEP_REDROCK_ITEM = BLOCK_ITEM_REGISTRY.register("deep_redrock", () -> new BlockItem(DEEP_REDROCK.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> DEEPSTONE = BLOCK_REGISTRY.register("deepstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  DEEPSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("deepstone", () -> new BlockItem(DEEPSTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> COLDSTONE = BLOCK_REGISTRY.register("coldstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  COLDSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("coldstone", () -> new BlockItem(COLDSTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> DEEP_COLDSTONE = BLOCK_REGISTRY.register("deep_coldstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  DEEP_COLDSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("deep_coldstone", () -> new BlockItem(DEEP_COLDSTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ICESTONE = BLOCK_REGISTRY.register("icestone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  ICESTONE_ITEM = BLOCK_ITEM_REGISTRY.register("icestone", () -> new BlockItem(ICESTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> GLACIERROCK = BLOCK_REGISTRY.register("glacierrock", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  GLACIERROCK_ITEM = BLOCK_ITEM_REGISTRY.register("glacierrock", () -> new BlockItem(GLACIERROCK.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> OCEANSTONE = BLOCK_REGISTRY.register("oceanstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  OCEANSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("oceanstone", () -> new BlockItem(OCEANSTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> DEEP_OCEANSTONE = BLOCK_REGISTRY.register("deep_oceanstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item>  DEEP_OCEANSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("deep_oceanstone", () -> new BlockItem(DEEP_OCEANSTONE.get(), new Item.Properties().group(Reference.minestrapp)));

	//Slabs
	public static final RegistryObject<Block> SLAB_DEEPSTONE = BLOCK_REGISTRY.register("slab_deepstone", () -> new SlabBlock(Block.Properties.create(Material.ROCK)));
	public static final RegistryObject<Item> SLAB_DEEPSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("slab_deepstone",() -> new BlockItem(SLAB_DEEPSTONE.get(), new Item.Properties().group(Reference.minestrapp)));

	//Ores
	public static final RegistryObject<Block> ORE_TIN = BLOCK_REGISTRY.register("ore_tin", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_TIN_ITEM = BLOCK_ITEM_REGISTRY.register("ore_tin",() -> new BlockItem(ORE_TIN.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_TITANIUM = BLOCK_REGISTRY.register("ore_titanium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_TITANIUM_ITEM = BLOCK_ITEM_REGISTRY.register("ore_titanium",() -> new BlockItem(ORE_TITANIUM.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_COPPER = BLOCK_REGISTRY.register("ore_copper", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_COPPER_ITEM = BLOCK_ITEM_REGISTRY.register("ore_copper",() -> new BlockItem(ORE_COPPER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_MEURODITE = BLOCK_REGISTRY.register("ore_meurodite", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_MEURODITE_ITEM = BLOCK_ITEM_REGISTRY.register("ore_meurodite",() -> new BlockItem(ORE_MEURODITE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_TORITE = BLOCK_REGISTRY.register("ore_torite", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_TORITE_ITEM = BLOCK_ITEM_REGISTRY.register("ore_torite",() -> new BlockItem(ORE_TORITE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_SALT = BLOCK_REGISTRY.register("ore_salt", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_SALT_ITEM = BLOCK_ITEM_REGISTRY.register("ore_salt",() -> new BlockItem(ORE_SALT.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_IRRADIUM = BLOCK_REGISTRY.register("ore_irradium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_IRRADIUM_ITEM = BLOCK_ITEM_REGISTRY.register("ore_irradium",() -> new BlockItem(ORE_IRRADIUM.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ORE_BLAZIUM = BLOCK_REGISTRY.register("ore_blazium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> ORE_BLAZIUM_ITEM = BLOCK_ITEM_REGISTRY.register("ore_blazium",() -> new BlockItem(ORE_BLAZIUM.get(), new Item.Properties().group(Reference.minestrapp)));

	public static final RegistryObject<Block> BLAZIUM = BLOCK_REGISTRY.register("block_blazium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> BLAZIUM_ITEM = BLOCK_ITEM_REGISTRY.register("block_blazium",() -> new BlockItem(BLAZIUM.get(), new Item.Properties().group(Reference.minestrapp)));

	//Soil
	public static final RegistryObject<Block> MUD_DRIED = BLOCK_REGISTRY.register("dried_mud", () -> new BlockDriedMud(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Item> MUD_DRIED_ITEM = BLOCK_ITEM_REGISTRY.register("dried_mud",() -> new BlockItem(MUD_DRIED.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> MUD = BLOCK_REGISTRY.register("mud", () -> new BlockMud(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Item> MUD_ITEM = BLOCK_ITEM_REGISTRY.register("mud",() -> new BlockItem(MUD.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> COLD_SAND = BLOCK_REGISTRY.register("cold_sand", () -> new BlockColdSand(new Color(55, 238, 244).getRGB(),Block.Properties.create(Material.SAND).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Item> COLD_SAND_ITEM = BLOCK_ITEM_REGISTRY.register("cold_sand",() -> new BlockItem(COLD_SAND.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> COLD_RED_SAND = BLOCK_REGISTRY.register("cold_red_sand", () -> new BlockColdSand(new Color(244, 114, 119).getRGB(), Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7F).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Item> COLD_RED_SAND_ITEM = BLOCK_ITEM_REGISTRY.register("cold_red_sand",() -> new BlockItem(COLD_RED_SAND.get(), new Item.Properties().group(Reference.minestrapp)));

	//Crops
	public static final RegistryObject<Block> CROP_CABBAGE = BLOCK_REGISTRY.register("crop_cabbage", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_CELERY = BLOCK_REGISTRY.register("crop_celery", () -> new CropCelery(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_CORN = BLOCK_REGISTRY.register("crop_corn", () -> new CropCorn(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_LETTUCE = BLOCK_REGISTRY.register("crop_lettuce", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_ONION = BLOCK_REGISTRY.register("crop_onion", () -> new CropCabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_PEANUT = BLOCK_REGISTRY.register("crop_peanuts", () -> new CropPeanut(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_PEPPER = BLOCK_REGISTRY.register("crop_pepper", () -> new CropPepper(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));
	public static final RegistryObject<Block> CROP_TOMATO = BLOCK_REGISTRY.register("crop_tomato", () -> new CropTomato(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()));

	//Pavers
	//TODO add models and textures
	public static final RegistryObject<Block> REDROCK_PAVER = BLOCK_REGISTRY.register("red_rock_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D));
	public static final RegistryObject<Item> REDROCK_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("red_rock_paver",() -> new BlockItem(REDROCK_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> STONE_PAVER = BLOCK_REGISTRY.register("stone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D));
	public static final RegistryObject<Item> STONE_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("stone_paver",() -> new BlockItem(STONE_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> COLDSTONE_PAVER = BLOCK_REGISTRY.register("coldstone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D));
	public static final RegistryObject<Item> COLDSTONE_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("coldstone_paver",() -> new BlockItem(COLDSTONE_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ICESTONE_PAVER = BLOCK_REGISTRY.register("icestone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D));
	public static final RegistryObject<Item> ICESTONE_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("icestone_paver",() -> new BlockItem(ICESTONE_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> OCEANSTONE_PAVER = BLOCK_REGISTRY.register("oceanstone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.4D));
	public static final RegistryObject<Item> OCEANSTONE_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("oceanstone_paver",() -> new BlockItem(OCEANSTONE_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> NETHERRACK_PAVER = BLOCK_REGISTRY.register("netherrack_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.6D));
	public static final RegistryObject<Item> NETHERRACK_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("netherrack_paver",() -> new BlockItem(NETHERRACK_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> ENDSTONE_PAVER = BLOCK_REGISTRY.register("end_stone_paver", () -> new BlockPavers(Block.Properties.create(Material.EARTH).hardnessAndResistance(1F), 1.8D));
	public static final RegistryObject<Item> ENDSTONE_PAVER_ITEM = BLOCK_ITEM_REGISTRY.register("end_stone_paver",() -> new BlockItem(NETHERRACK_PAVER.get(), new Item.Properties().group(Reference.minestrapp)));

	//Misc
	public static final RegistryObject<Block> GODSTONE = BLOCK_REGISTRY.register("godstone", () -> new BlockGodstone(Block.Properties.create(Material.EARTH).hardnessAndResistance(1.5F)));
	public static final RegistryObject<Item> GODSTONE_ITEM = BLOCK_ITEM_REGISTRY.register("godstone",() -> new BlockItem(GODSTONE.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> MITE_HONEY = BLOCK_REGISTRY.register("mite_honey", () -> new BlockMiteHoney(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.7F).harvestTool(ToolType.SHOVEL)));
	public static final RegistryObject<Item> MITE_HONEY_ITEM = BLOCK_ITEM_REGISTRY.register("mite_honey",() -> new BlockItem(MITE_HONEY.get(), new Item.Properties().group(Reference.minestrapp)));
	public static final RegistryObject<Block> CANDLE = BLOCK_REGISTRY.register("candle", () -> new BlockCandle(Block.Properties.create(Material.EARTH)));
	public static final RegistryObject<Item> CANDLE_ITEM = BLOCK_ITEM_REGISTRY.register("candle",() -> new BlockItem(CANDLE.get(), new Item.Properties().group(Reference.minestrapp)));
}
