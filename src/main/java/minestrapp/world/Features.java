package minestrapp.world;

import minestrapp.Reference;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Features {

    public static final Feature<NoFeatureConfig> DEPOSIT = new SurfaceDepositFeature((NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> evt){
        DEPOSIT.setRegistryName(Reference.id, "surface_deposit");
        ForgeRegistries.FEATURES.register(DEPOSIT);
    }
}
