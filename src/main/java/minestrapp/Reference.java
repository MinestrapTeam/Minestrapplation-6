package minestrapp;

import minestrapp.init.MBlocks;
import minestrapp.init.MItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference {

	public static final String id = "minestrapp";

	public static ItemGroup plant = new ItemGroup("Plants")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.SEEDS_CABBAGE.get());
		}
	};

	public static ItemGroup environment = new ItemGroup("EnvironmentalBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.MUD.get());
		}
	};

	public static ItemGroup wood = new ItemGroup("Wood")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.DEEP_REDROCK.get());
		} //TODO Wood
	};

	public static ItemGroup stone = new ItemGroup("Stone")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.DEEP_REDROCK.get());
		}
	};

	public static ItemGroup ore = new ItemGroup("Ores")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.ORE_COPPER.get());
		}
	};

	public static ItemGroup resource = new ItemGroup("ResourceBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.BLAZIUM.get());
		}
	};

	public static ItemGroup dye = new ItemGroup("Dyeables")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.DEEP_REDROCK.get());
		} //TODO dyable icon
	};

	public static ItemGroup decor = new ItemGroup("DecorBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.CANDLE.get());
		} //TODO decor block
	};

	public static ItemGroup utility = new ItemGroup("UtilityBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.MELTER.get());
		}
	};

	public static ItemGroup minerals = new ItemGroup("Minerals")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.INGOT_COPPER.get());
		}
	};

	public static ItemGroup food = new ItemGroup("Food")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.ONION.get());
		}
	};

	public static ItemGroup ingredients = new ItemGroup("Ingredients")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.DEEP_REDROCK.get());
		} //TODO tech items
	};

	public static ItemGroup tools = new ItemGroup("Tools")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.PICKAXE_BRONZE.get());
		}
	};

	public static ItemGroup combat = new ItemGroup("Combat")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.SWORD_BRONZE.get());
		}
	};
}
