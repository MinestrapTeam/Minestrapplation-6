package minestrapp.worldgen;

import com.mojang.datafixers.Dynamic;
import minestrapp.init.MBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class SurfaceDepositFeature extends Feature<NoFeatureConfig> {

    //For testing world gen things.

    public SurfaceDepositFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> d) {
        super(d);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        BlockPos np = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos);
        BlockPos.Mutable blockpos = new BlockPos.Mutable();

        for(int i = 0; i < 75; i++){



            int x = rand.nextInt(3) - rand.nextInt(3);
            int z = rand.nextInt(3) - rand.nextInt(3);
            int y = rand.nextInt(8) - rand.nextInt(8);

            blockpos.setPos(np).move(x, y, z);

            if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).isSolid() && blockpos.getY() < worldIn.getMaxHeight() - 1) {
                    worldIn.setBlockState(blockpos, MBlocks.ICESTONE.get().getDefaultState(), 2);
            }
        }

        return true;
    }

}
