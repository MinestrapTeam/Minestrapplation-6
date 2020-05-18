package minestrapp.blocks;

import minestrapp.tileentity.TileEntityCandle;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ILightReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Random;

public class BlockCandle extends Block implements ITileEntityProvider {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);

    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    private int increment = 5;

    public BlockCandle(Block.Properties prop){
        super(prop);
        this.setDefaultState(this.getStateContainer().getBaseState().with(LIT, Boolean.valueOf(false)));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_){
        TileEntityCandle candle = (TileEntityCandle) worldIn.getTileEntity(pos);

        Item heldItem = player.getHeldItem(handIn).getItem();

        //TODO figure out why crouch right click doesn't work when holding item -- also see the Events class
        if(player.isCrouching()){
            if(heldItem instanceof DyeItem){
                DyeItem dye = (DyeItem) heldItem;
                candle.setColor(new Color(dye.getDyeColor().getColorValue()));
            }
        } else {
            if(heldItem == Items.RED_DYE){
                candle.addColor(increment, 0,0);
            }
            if(heldItem == Items.GREEN_DYE){
                candle.addColor(0, increment,0);
            }
            if(heldItem == Items.BLUE_DYE){
                candle.addColor(0, 0,increment);
            }
            if(heldItem == Items.WHITE_DYE){
                candle.setColor(255,255,255);
            }
        }

        if(heldItem == Items.FLINT_AND_STEEL){
           worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true)), 2);
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public int getLightValue(BlockState state){
        return state.get(LIT) ? 10 : 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.5D;
        if(stateIn.get(LIT)){
            worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityCandle();
    }

    public static class ColorHandler implements IBlockColor {

        @Override
        public int getColor(BlockState state, @Nullable ILightReader world, @Nullable BlockPos pos, int tintIndex) {
            if(tintIndex == 0 && world.getTileEntity(pos) instanceof TileEntityCandle){
                TileEntityCandle candle = (TileEntityCandle) world.getTileEntity(pos);
                return candle.getColor().getRGB();
            }
            return new Color(255, 58, 63).getRGB();
        }
    }
}
