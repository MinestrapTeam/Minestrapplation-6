package minestrapp.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUtils {

    public static boolean hasOnAnySide(World world, BlockPos pos, Block block){
        if(world.getBlockState(pos.up()).getBlock() == block){
            return true;
        }
        else if(world.getBlockState(pos.down()).getBlock() == block){
            return true;
        }
        else if(world.getBlockState(pos.north()).getBlock() == block){
            return true;
        }
        else if(world.getBlockState(pos.south()).getBlock() == block){
            return true;
        }
        else if(world.getBlockState(pos.east()).getBlock() == block){
            return true;
        }
        else if(world.getBlockState(pos.west()).getBlock() == block){
            return true;
        }
        return false;
    }

    public static boolean hasOnAnySide(World world, BlockPos pos, Material material){
        if(world.getBlockState(pos.up()).getMaterial() == material){
            return true;
        }
        else if(world.getBlockState(pos.down()).getMaterial() == material){
            return true;
        }
        else if(world.getBlockState(pos.north()).getMaterial() == material){
            return true;
        }
        else if(world.getBlockState(pos.south()).getMaterial() == material){
            return true;
        }
        else if(world.getBlockState(pos.east()).getMaterial() == material){
            return true;
        }
        else if(world.getBlockState(pos.west()).getMaterial() == material){
            return true;
        }
        return false;
    }
}
