package minestrapp.blocks;

import minestrapp.utils.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockCopper extends Block {
    public static final BooleanProperty TARNISHED = BooleanProperty.create("tarnished");

    public BlockCopper(Properties properties) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(TARNISHED, Boolean.valueOf(false)));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if(state.get(TARNISHED) == false){
            float chance = rand.nextFloat();
            if((worldIn.isRaining() || BlockUtils.hasOnAnySide(worldIn, pos, Material.WATER)) && chance > 0.6){
                worldIn.setBlockState(pos, this.getDefaultState().with(TARNISHED, Boolean.valueOf(true)), 3);
            }
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TARNISHED);
    }


}
