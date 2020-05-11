package minestrapp;

import minestrapp.config.Config;
import minestrapp.containers.ContainerTypes;
import minestrapp.proxy.ClientProxy;
import minestrapp.proxy.ServerProxy;
import minestrapp.recipes.Recipes;
import minestrapp.tileentity.TileEntityTypes;
import minestrapp.worldgen.OreGen;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Reference.id)
public class Minestrapp {

	public static Minestrapp INSTANCE;

	public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);


	public static final Logger logger = LogManager.getLogger(Reference.id);

	public Minestrapp(){
		INSTANCE = this;

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("minestrapp-client.toml"));
		Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve("minestrapp-common.toml"));

		MBlocks.BLOCK_ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		MBlocks.BLOCK_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		MItems.ITEM_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());

		TileEntityTypes.TILEENTITY_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		ContainerTypes.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());

		Recipes.RECIPES.register(FMLJavaModLoadingContext.get().getModEventBus());

		MPotions.POTION_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		MPotions.EFFECT_REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private void setup(final FMLCommonSetupEvent event) {
		proxy.setup();
		OreGen.setupOverworldGen();
	}
}