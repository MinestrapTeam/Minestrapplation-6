package minestrapp.potion;


import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.MathHelper;

import java.awt.*;

public class PotionClimbing extends Effect {

    public PotionClimbing(){
        super(EffectType.NEUTRAL, new Color(122, 61, 22).getRGB());
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if(entity.collidedHorizontally && !entity.isOnLadder()) {
            final float factor = 0.15F;

            if(entity.isCrouching()) {
                entity.setMotion(entity.getMotion().x, 0, entity.getMotion().z);
            }
            else {
                entity.setMotion(MathHelper.clamp(entity.getMotion().x, -factor, factor), 0.2D, MathHelper.clamp(entity.getMotion().z, -factor, factor));
            }

            entity.fallDistance = 0.0F;
        }
    }
}
