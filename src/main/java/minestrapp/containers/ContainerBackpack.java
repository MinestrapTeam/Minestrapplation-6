package minestrapp.containers;

import minestrapp.containers.inventories.InventoryBackpack;
import minestrapp.containers.inventories.SlotBackpack;
import minestrapp.init.ContainerTypes;
import minestrapp.init.MItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ContainerBackpack extends Container {

    private final IInventory backpack;
    private IItemHandler playerInv;

    public ContainerBackpack(int window, PlayerInventory inv, IInventory backpack){
        super(ContainerTypes.BACKPACK_CONTAINER.get(), window);
        this.backpack = backpack;
        this.playerInv = new InvWrapper(inv);

        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 9; ++k) {
                addSlot(new SlotBackpack(this.backpack, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }
        layoutPlayerInventorySlots(8,69);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        ((InventoryBackpack) backpack).writeItemStack();
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        // Player inventory
        addSlotBox(playerInv, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(playerInv, 0, leftCol, topRow, 9, 18);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            itemstack = stack.copy();

            if(index < backpack.getSizeInventory()){
                if(!this.mergeItemStack(stack, backpack.getSizeInventory(), this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if(!this.mergeItemStack(stack, 0, backpack.getSizeInventory(), false)){
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, stack);
        }

        return itemstack;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player) {
        if(slotId >= 0 && this.getSlot(slotId).getStack().getItem() == MItems.BACKPACK.get()){
            return ItemStack.EMPTY;
        }

        return super.slotClick(slotId, dragType, clickTypeIn, player);
    }
}
