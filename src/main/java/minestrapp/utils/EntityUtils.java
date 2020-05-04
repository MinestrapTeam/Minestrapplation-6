package minestrapp.utils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Iterator;

public class EntityUtils {

    public static boolean hasArmorSet(LivingEntity entity, Item helmet, Item chest, Item legs, Item feet){
        Iterator it = entity.getArmorInventoryList().iterator();

        boolean matches = false;

        while(it.hasNext()){
            ItemStack armor = (ItemStack)it.next();

            if(armor.getItem() != helmet && armor.getItem() != chest && armor.getItem() != legs && armor.getItem() != feet){
                matches = false;
                break;
            } else {
                matches = true;
            }
        }

        if(matches){
            return true;
        }

        return false;
    }

}
