package minestrapp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;

public class BlockStoneBase extends Block
{
    private StoneType stoneType;
    public static final EnumProperty<StoneType> VARIANT = EnumProperty.<StoneType>create("variant", StoneType.class);

    public BlockStoneBase(Block.Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(VARIANT, StoneType.STONE));
        this.stoneType = stoneType;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    //TODO: Check temp/height and set blockstate accordingly
}