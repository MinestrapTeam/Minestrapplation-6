package minestrapp.worldgen;

import minestrapp.Minestrapp;
import minestrapp.config.Config;
import minestrapp.init.MBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
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

            int vein_size = 35;
            if(biome.getTempCategory() == Biome.TempCategory.COLD){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.GLACIERROCK.get().getDefaultState(), vein_size)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 0, 75, 255))));
            }

            if(biome.getTempCategory() == Biome.TempCategory.WARM){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.REDROCK.get().getDefaultState(), vein_size)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 0, 75, 255))));
            }

            if(biome.getTempCategory() == Biome.TempCategory.OCEAN){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.OCEANSTONE.get().getDefaultState(), vein_size)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 0, 75, 255))));
            }

            if(biome.getTempCategory() == Biome.TempCategory.MEDIUM){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MBlocks.DEEPSTONE.get().getDefaultState(), vein_size)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(100, 0, 75, 255))));
            }

            //For testing
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.DEPOSIT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(32))));
        }
    }

    public static void setupEndGen(){
        for(Biome biome : ForgeRegistries.BIOMES) {
            if (Config.GEN_DIMENSIUM.get()) {
                if(biome.getCategory() == Biome.Category.THEEND){
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.EMERALD_ORE.withConfiguration(
                            new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), MBlocks.ORE_DIMENSIUM.get().getDefaultState())).withPlacement(Placement.COUNT_RANGE.configure(
                            new CountRangeConfig(25, 0, 0, 70))));
                }
            }
        }
    }
}
