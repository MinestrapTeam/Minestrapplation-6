package minestrapp.potion;


import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

import java.awt.*;

public class PotionHydrophobia extends Effect {

    public PotionHydrophobia(){
        super(EffectType.HARMFUL, new Color(21, 242, 255).getRGB());
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if(entity.isWet()){
            float damageAmount = 1F + (2F * amplifier);
            entity.attackEntityFrom(DamageSource.DROWN, damageAmount);
        }
    }
}
