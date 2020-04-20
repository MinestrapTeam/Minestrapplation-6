package minestrapp.worldgen;

import minestrapp.MBlocks;
import minestrapp.Minestrapp;
import minestrapp.config.Config;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {

    public static void setupOverworldGen(){
        Minestrapp.logger.info("Setting up Minestrappolation Ore Gen");

        for(Biome biome : ForgeRegistries.BIOMES){

            if(Config.GEN_COPPER.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.ore_copper.getDefaultState(), 25)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 75, 75, 255))));
            }

        }
    }
}
