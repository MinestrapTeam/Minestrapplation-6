package minestrapp;

import minestrapp.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Events {

    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent e){
        if (e.getEntity() instanceof PlayerEntity) {
             PlayerEntity player = (PlayerEntity) e.getEntity();
             CompoundNBT nbt = player.getPersistentData();

             if(nbt.contains("health")){
                 player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(nbt.getDouble("health"));
             } else {
                 player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Config.MAX_STARTING_HEALTH.get());
             }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderFog(EntityViewRenderEvent.FogDensity e){
        ClientPlayerEntity entity = Minecraft.getInstance().player;
        if(entity.isPotionActive(Effects.FIRE_RESISTANCE) && entity.areEyesInFluid(FluidTags.LAVA)){
            e.setDensity(0.25F);
            e.setCanceled(true);
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void renderOverlay(RenderBlockOverlayEvent e){
        PlayerEntity player = e.getPlayer();
        if(player.isPotionActive(Effects.FIRE_RESISTANCE) && player.areEyesInFluid(FluidTags.LAVA) && e.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE){
            e.setCanceled(true);
        }
    }

}
