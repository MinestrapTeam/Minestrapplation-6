package minestrapp;

import minestrapp.blocks.BlockCandle;
import minestrapp.init.MBlocks;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandlers {

    @SubscribeEvent
    public static void registerColorHandler(ColorHandlerEvent.Block event){
      event.getBlockColors().register(new BlockCandle.ColorHandler(), MBlocks.CANDLE.get());
    }
}
