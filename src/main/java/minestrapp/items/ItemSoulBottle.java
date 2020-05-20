package minestrapp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemSoulBottle extends Item {

    public ItemSoulBottle(Properties properties) {
        super(properties);
    }
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
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
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            if(!world.isRemote()){
                int i = 3 + world.rand.nextInt(5) + world.rand.nextInt(5);
                player.giveExperiencePoints(-i);
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.EXPERIENCE_BOTTLE));
            }
        }

        stack.shrink(1);
        return stack;
    }
}
