package minestrapp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemCreeperHeart extends Item {

    public ItemCreeperHeart(Properties properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack stack){
        return UseAction.EAT;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 25;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;
            worldIn.createExplosion(player, player.getPosX(), player.getPosY(), player.getPosZ(), 2.5F, false, Explosion.Mode.BREAK);
        }

        stack.shrink(1);
        return stack;
    }


}
