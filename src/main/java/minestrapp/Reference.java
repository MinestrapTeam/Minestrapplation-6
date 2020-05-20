package minestrapp;

import minestrapp.init.MBlocks;
import minestrapp.init.MItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference {

	public static final String id = "minestrapp";

	public static ItemGroup environment = new ItemGroup("EnvironmentalBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.COLDSTONE.get());
		}
	};

	public static ItemGroup resource = new ItemGroup("ResourceBlocks")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.ORE_TITANIUM.get());
		}
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

	public static ItemGroup food = new ItemGroup("Food")
	{
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MItems.ONION.get());
		}
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
