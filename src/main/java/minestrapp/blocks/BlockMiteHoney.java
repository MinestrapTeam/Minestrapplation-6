package minestrapp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockMiteHoney extends Block{
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0625D, 0.0625D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);

    public BlockMiteHoney(Block.Properties prop){
        super(prop);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotion(entityIn.getMotion().x * 0D, entityIn.getMotion().y * 0D, entityIn.getMotion().z * 0D);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
