package minestrapp.proxy;

import minestrapp.MBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy extends ServerProxy{

	@Override
	public void setup() {
		RenderTypeLookup.setRenderLayer(MBlocks.crop_cabbage, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_celery, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_corn, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_lettuce, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_onion, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_peanut, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_pepper, RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(MBlocks.crop_tomato, RenderType.getCutoutMipped());

		RenderTypeLookup.setRenderLayer(MBlocks.godstone, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(MBlocks.mite_honey, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(MBlocks.candle, RenderType.getCutout());
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
