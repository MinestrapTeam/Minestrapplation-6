package minestrapp.proxy;

import minestrapp.blocks.BlockCandle;
import minestrapp.gui.BackpackGui;
import minestrapp.gui.BrickOvenGui;
import minestrapp.gui.MelterGui;
import minestrapp.init.ContainerTypes;
import minestrapp.init.MBlocks;
import minestrapp.init.MItems;
import minestrapp.items.ItemBackpack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy extends ServerProxy{

	@Override
	public void setup() {
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_CABBAGE.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_CELERY.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_CORN.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_LETTUCE.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_ONION.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_PEANUT.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_PEPPER.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.CROP_TOMATO.get(), RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(MBlocks.GODSTONE.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(MBlocks.MITE_HONEY.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(MBlocks.CANDLE.get(), RenderType.getCutout());

		ScreenManager.registerFactory(ContainerTypes.MELTER_CONTAINER.get(), MelterGui::new);
		ScreenManager.registerFactory(ContainerTypes.OVEN_CONTAINER.get(), BrickOvenGui::new);
		ScreenManager.registerFactory(ContainerTypes.BACKPACK_CONTAINER.get(), BackpackGui::new);
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}


	@SubscribeEvent
	public static void registerBlockColorHandler(ColorHandlerEvent.Block event){
		event.getBlockColors().register(new BlockCandle.ColorHandler(), MBlocks.CANDLE.get());
	}

	@SubscribeEvent
	public static void registerItemColorHandler(ColorHandlerEvent.Item event){
		event.getItemColors().register(new ItemBackpack.ColorHandler(), MItems.BACKPACK.get());
	}

}
