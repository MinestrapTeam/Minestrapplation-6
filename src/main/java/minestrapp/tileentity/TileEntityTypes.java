package minestrapp.tileentity;

import minestrapp.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class TileEntityTypes {

    public static final String CANDLE_NAME = Reference.id +":candle";


    @ObjectHolder(CANDLE_NAME)
    public static TileEntityType<TileEntityCandle> CANDLE;


    @Mod.EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration {

        @SubscribeEvent
        public static void tileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event){
            event.getRegistry().register(TileEntityType.Builder.create(TileEntityCandle::new).build(null).setRegistryName(CANDLE_NAME));
        }
    }
}
