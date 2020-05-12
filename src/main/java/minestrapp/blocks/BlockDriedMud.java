package minestrapp.blocks;

import minestrapp.init.MBlocks;
import minestrapp.utils.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

public class BlockDriedMud extends Block{

    public BlockDriedMud(Block.Properties prop){
        super(prop);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if(BlockUtils.hasOnAnySide(world, pos, Material.WATER)){
            world.setBlockState(pos, MBlocks.MUD.get().getDefaultState());
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        PlantType plantType = plantable.getPlantType(world, pos.offset(facing));

        switch (plantType){
            case Cave: return state.isTopSolid(world, pos, null);
            case Desert: return true;
            default: break;
        }
        return false;
    }
}
