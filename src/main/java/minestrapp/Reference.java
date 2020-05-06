package minestrapp;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference {

	public static final String id = "minestrapp";

	public static ItemGroup minestrapp = new ItemGroup("Minestrappolation") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(MBlocks.DEEP_REDROCK.get());
		}
	};
}
