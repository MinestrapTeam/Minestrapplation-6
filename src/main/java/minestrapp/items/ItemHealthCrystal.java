package minestrapp.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemHealthCrystal extends Item {

    public ItemHealthCrystal(Item.Properties prop){
        super(prop);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1));

        stack.damageItem(1, playerIn, (PlayerEntity) -> playerIn.sendBreakAnimation(handIn));

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
