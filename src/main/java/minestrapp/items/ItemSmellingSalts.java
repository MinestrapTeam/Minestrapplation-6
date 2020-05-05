package minestrapp.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemSmellingSalts extends Item {

    public ItemSmellingSalts(Properties prop){
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

        if(playerIn.getActivePotionEffects().size() > 0){
            playerIn.setActiveHand(handIn);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entityLiving;

            if(!worldIn.isRemote()){
                Iterator effects = player.getActivePotionEffects().iterator();

                List<Effect> potionsToRemove = new ArrayList<>();

                while(effects.hasNext()){
                    EffectInstance effect = (EffectInstance) effects.next();
                    if(effect.getPotion().getEffectType() == EffectType.HARMFUL){
                        potionsToRemove.add(effect.getPotion());
                    }
                }

                for(Effect effect: potionsToRemove){
                    player.removePotionEffect(effect);
                }

                if(potionsToRemove.size() > 0){
                    stack.shrink(1);
                }
            }
        }


        return stack;
    }
}
