package minestrapp.blocks;

import minestrapp.tileentity.TileEntityGoblet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ILightReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.awt.*;

public class BlockGoblet extends Block implements ITileEntityProvider {

    public BlockGoblet(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_){
        TileEntityGoblet goblet = (TileEntityGoblet) worldIn.getTileEntity(pos);

        if(player.getHeldItemMainhand().getItem() instanceof PotionItem){
            goblet.setEffect(PotionUtils.getEffectsFromStack(player.getHeldItemMainhand()).get(0));
        } else{
            player.addPotionEffect(goblet.effect);
        }

        return ActionResultType.SUCCESS;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityGoblet();
    }

    public static class ColorHandler implements IBlockColor {

        @Override
        public int getColor(BlockState state, @Nullable ILightReader world, @Nullable BlockPos pos, int tintIndex) {
            if(tintIndex == 0 && world.getTileEntity(pos) instanceof TileEntityGoblet){
                TileEntityGoblet goblet = (TileEntityGoblet) world.getTileEntity(pos);
                return goblet.effect.getPotion().getLiquidColor();
            }
            return new Color(255, 255, 255).getRGB();
        }
    }
}
