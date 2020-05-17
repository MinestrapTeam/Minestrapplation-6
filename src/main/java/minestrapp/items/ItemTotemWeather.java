package minestrapp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemTotemWeather extends Item {

    public ItemTotemWeather(Properties prop){
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
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(worldIn.isRaining()){
            worldIn.getWorldInfo().setRaining(false);
        } else {
            worldIn.getWorldInfo().setRaining(true);
        }
        stack.shrink(1);
        return stack;
    }
}
