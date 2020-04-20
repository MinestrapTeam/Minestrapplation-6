package minestrapp.blocks;

import minestrapp.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import java.util.Random;

//TODO Implement particles and Mud balls

public class BlockMud extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);


    public BlockMud(Block.Properties prop){
        super(prop);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if(context.getWorld().dimension.doesWaterVaporize()){
            return MBlocks.mud_dried.getDefaultState();
        }

        return super.getStateForPlacement(context);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if(!worldIn.isRemote){
            if(worldIn.canBlockSeeSky(pos)){
                float temp = worldIn.getBiome(pos).getDefaultTemperature();

                if(temp > 0.9F && !worldIn.isRaining() && worldIn.isDaytime() && worldIn.getBlockState(pos.up()).getMaterial() != Material.WATER){
                    worldIn.setBlockState(pos, MBlocks.mud_dried.getDefaultState());
                }

            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotion(entityIn.getMotion().x * 0.15D, entityIn.getMotion().y * 0.2D, entityIn.getMotion().z * 0.15D);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable){
        PlantType plantType = plantable.getPlantType(world, pos.offset(facing));
        switch(plantType){
            case Cave:
                return state.isTopSolid(world, pos, null);
            case Plains:
            case Beach:
                return true;
        }
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
