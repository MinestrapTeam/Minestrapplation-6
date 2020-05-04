package minestrapp.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPavers extends Block{

    private double speedMod;

    public BlockPavers(Block.Properties prop, double speedMod){
        super(prop);
        this.speedMod = speedMod;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotion(entityIn.getMotion().x * speedMod, entityIn.getMotion().y, entityIn.getMotion().z  * speedMod);
    }
}
