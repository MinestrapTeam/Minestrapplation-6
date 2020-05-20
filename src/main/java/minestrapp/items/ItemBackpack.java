package minestrapp.items;

import minestrapp.containers.ContainerBackpack;
import minestrapp.containers.inventories.InventoryBackpack;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.awt.*;

public class ItemBackpack extends Item implements IDyeableArmorItem {

    public ItemBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if(!world.isRemote){
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return stack.getDisplayName();
                }

                @Nullable
                @Override
                public Container createMenu(int id, PlayerInventory inv, PlayerEntity player) {
                    return new ContainerBackpack(id, inv, new InventoryBackpack(player.getHeldItemMainhand(), 20));
                }
            });
        }
        return ActionResult.resultSuccess(stack);
    }

    public static class ColorHandler implements IItemColor {
        @Override
        public int getColor(ItemStack stack, int layer) {
            IDyeableArmorItem item = (IDyeableArmorItem)stack.getItem();
            if(layer == 1){
                return item.getColor(stack);
            }
            return new Color(255, 255, 255).getRGB();
        }
    }
}
