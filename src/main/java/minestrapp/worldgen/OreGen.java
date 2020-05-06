package minestrapp.worldgen;

import minestrapp.MBlocks;
import minestrapp.Minestrapp;
import minestrapp.config.Config;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {

    public static void setupOverworldGen(){
        Minestrapp.logger.info("Setting up Minestrappolation Ore Gen");

        for(Biome biome : ForgeRegistries.BIOMES){

            if(Config.GEN_COPPER.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.ORE_COPPER.get().getDefaultState(), Config.GEN_COPPER_VEIN_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 75, 75, 255))));
            }

            if(Config.GEN_TIN.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.ORE_TIN.get().getDefaultState(), Config.GEN_TIN_VEIN_SIZE.get())).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 75, 75, 255))));
            }

            //For testing
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.DEPOSIT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(32))));
        }
    }
}
