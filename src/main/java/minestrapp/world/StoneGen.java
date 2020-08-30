package minestrapp.world;

import java.util.Random;

import minestrapp.config.Config;
import minestrapp.init.MBlocks;
import net.minecraft.block.Block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;

public class StoneGen
{
    public static void replaceStoneInChunk(IChunk chunk) {
        int xPos = chunk.getPos().x * 16;
        int zPos = chunk.getPos().z * 16;
        World world = chunk.getWorldForge().getWorld();
        for (ChunkSection storage : chunk.getSections()) {
            if (storage != null && !storage.isEmpty()) {
                int yPos = storage.getYLocation();
//                if (yPos >= config.generationHeight()) TODO
//                    return;

                for (int x = 0; x < 16; ++x) {
                    for (int z = 0; z < 16; ++z) {

                        Biome biome = chunk.getBiomes().getNoiseBiome(x,0,z);
                        Block sType = StoneGen.getStoneForBiome(biome);
                        Block dType = StoneGen.getDeepStoneForBiome(biome);

                        for (int y = 0; y < 16; ++y) {
                            BlockState currentBlockState = storage.getBlockState(x, y, z);
                            Block currentBlock = currentBlockState.getBlock();
                            int deepStoneDepth = StoneGen.getDeepstoneDepthForBiome(biome, world.getRandom());
                            /*
                             * Skip air, water and lava
                             */
                            if (currentBlock == Blocks.AIR)
                                continue;
                            else if (currentBlock == Blocks.WATER)
                                continue;
                            else if (currentBlock == Blocks.LAVA)
                                continue;
                            else if (currentBlock == Blocks.BEDROCK && y == 0) {
                                storage.setBlockState(x, y, z, MBlocks.INVINCIUM.get().getDefaultState(), true);
                                continue;
                            }
                            else if ((currentBlock == Blocks.STONE)) {
                                if (Config.GEN_DEEPSTONE.get() && yPos < deepStoneDepth) {
                                    storage.setBlockState(x, y, z, dType.getDefaultState(), true);
                                } else {
                                    storage.setBlockState(x, y, z, sType.getDefaultState(), true);
                                }
                                continue;
                            }
                            // TODO Decor stones
//                        if(currentBlock == MBlocks.STONE && biome.getDefaultTemperature() >= 0.4F)
//                        {
//                            if((biome.getTempCategory() == TempCategory.OCEAN || biome instanceof BiomeMushroomIsland) && state == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE))
//                            {
//                                chunk.setBlockState(subpos2, MBlocks.decor_stone.getDefaultState());
//                            }
//                            else if(biome.getDefaultTemperature() < 1F && state == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE))
//                            {
//                                chunk.setBlockState(subpos2, MBlocks.decor_stone.getDefaultState());
//                            }
//                            else if(biome.getDefaultTemperature() >= 1F && state == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE))
//                            {
//                                chunk.setBlockState(subpos2, MBlocks.decor_stone.getDefaultState());
//                            }
//                        }
                        }
                    }
                }
            }
        }
    }

    public static Block getStoneForBiome(Biome biome)
    {
        if (Config.GEN_OCEANSTONE.get() && (biome.getTempCategory() == TempCategory.OCEAN || biome == Biomes.MUSHROOM_FIELDS))
        {
            return MBlocks.OCEANSTONE.get();
        }
        else if (Config.GEN_ICESTONE.get() && biome.getDefaultTemperature() < 0.2F)
        {
            return MBlocks.ICESTONE.get();
        }
        else if (Config.GEN_COLDSTONE.get() && biome.getDefaultTemperature() < 0.4F)
        {
            return MBlocks.COLDSTONE.get();
        }
        else if (Config.GEN_REDROCK.get() && biome.getDefaultTemperature() >= 1.0F)
        {
            return MBlocks.REDROCK.get();
        }
        else
        {
            return Blocks.STONE;
        }
    }

    public static Block getDeepStoneForBiome(Biome biome)
    {
        if (Config.GEN_OCEANSTONE.get() && (biome.getTempCategory() == TempCategory.OCEAN || biome == Biomes.MUSHROOM_FIELDS))
        {
            return MBlocks.DEEP_OCEANSTONE.get();
        }
        else if (Config.GEN_ICESTONE.get() && biome.getDefaultTemperature() < 0.2F)
        {
            return MBlocks.GLACIERROCK.get();
        }
        else if (Config.GEN_COLDSTONE.get() && biome.getDefaultTemperature() < 0.4F)
        {
            return MBlocks.DEEP_COLDSTONE.get();
        }
        else if (Config.GEN_REDROCK.get() && biome.getDefaultTemperature() >= 1.0F)
        {
            return MBlocks.DEEP_REDROCK.get();
        }
        else
        {
            return MBlocks.DEEPSTONE.get();
        }
    }

    public static int getDeepstoneDepthForBiome(Biome biome, Random random)
    {
        if (biome.getTempCategory() == TempCategory.OCEAN || biome == Biomes.MUSHROOM_FIELDS)
        {
            return random.nextInt(5) + 20;
        }
        else if (biome.getDefaultTemperature() < 0.2F)
        {
            return random.nextInt(5) + 30;
        }
        else if (biome.getDefaultTemperature() < 0.4F)
        {
            return random.nextInt(5) + 40;
        }
        else if (biome.getDefaultTemperature() >= 1.0F)
        {
            return random.nextInt(5) + 25;
        }
        else
        {
            return random.nextInt(5) + 35;
        }
    }
}