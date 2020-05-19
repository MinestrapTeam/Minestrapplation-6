package minestrapp.containers.inventories;

import minestrapp.init.MItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot {

    public SlotBackpack(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() != MItems.BACKPACK.get();
    }
}
