package minestrapp.proxy;

import minestrapp.init.MBlocks;
import minestrapp.init.ContainerTypes;
import minestrapp.gui.MelterGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

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
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

}
