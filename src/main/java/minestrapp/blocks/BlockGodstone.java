package minestrapp.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

//TODO figure out how to schedule a tick instead of randomly ticking.
//TODO figure how to make texture less fucky
public class BlockGodstone extends Block {

    public BlockGodstone(Block.Properties prop){
        super(prop);
    }

    @Override
    public int tickRate(IWorldReader worldIn) {
        return 30;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        List<LivingEntity> entities = worldIn.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(x-8, y-8, z-8, x+8, y+8, z+8));

        for(LivingEntity living : entities)
        {
            if(living.isEntityUndead())
                living.setFire(30);
        }
    }
}
