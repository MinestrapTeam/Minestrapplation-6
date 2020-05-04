package minestrapp.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

//TODO figure how to make texture less fucky
public class BlockGodstone extends Block {

    private int tickTime = 30;
    private int range = 8;

    public BlockGodstone(Block.Properties prop){
        super(prop);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickTime, TickPriority.NORMAL);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickTime, TickPriority.NORMAL);

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        List<LivingEntity> entities = worldIn.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(x-range, y-range, z-range, x+range, y+range, z+range));

        for(LivingEntity living : entities) {
            if(living.isEntityUndead()){
                living.setFire(30);
            }
        }
    }
}
