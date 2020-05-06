package minestrapp.potion;


import minestrapp.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.awt.*;
import java.util.Random;

public class PotionInfection extends Effect {

    private Random rand = new Random();

    private ResourceLocation rl = new ResourceLocation(Reference.id, "infection");

    public PotionInfection(){
        super(EffectType.HARMFUL, new Color(0, 74, 37).getRGB());
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        World world = entity.getEntityWorld();
        BlockPos posBelow = entity.getPosition().down();
        Block blockBelow = world.getBlockState(posBelow).getBlock();

        if(!world.isRemote && BlockTags.getCollection().get(rl).contains(blockBelow)){
            float mushroomChance = rand.nextFloat();

            world.setBlockState(posBelow, Blocks.MYCELIUM.getDefaultState(), 2);

            if(mushroomChance >= 0.75F){
                world.setBlockState(entity.getPosition(), Blocks.RED_MUSHROOM.getDefaultState(), 2);
            }
        }

        if(blockBelow == Blocks.MYCELIUM.getDefaultState().getBlock()){
            entity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200));
        }
    }
}
