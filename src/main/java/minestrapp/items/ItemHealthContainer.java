package minestrapp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemHealthContainer extends Item {

    public ItemHealthContainer(Item.Properties prop){
        super(prop);
    }

    @Override
    public UseAction getUseAction(ItemStack stack){
        return UseAction.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack stack = playerIn.getHeldItem(handIn);

        if(playerIn.getMaxHealth() < 40.0D){
            playerIn.setActiveHand(handIn);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            if(!worldIn.isRemote()){
                player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getMaxHealth() + 2D);
                player.getPersistentData().putDouble("health", player.getMaxHealth());
            }
        }

        stack.shrink(1);
        return stack;
    }
}
