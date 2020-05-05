package minestrapp;

import minestrapp.config.Config;
import minestrapp.utils.EntityUtils;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
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
    public static void playerTick(LivingEvent.LivingUpdateEvent e){
        LivingEntity entity = e.getEntityLiving();

        if(entity instanceof PlayerEntity){
            //TODO needs removed at some point just a random effect for testing armor sets
            if(EntityUtils.hasArmorSet(entity, MItems.tin_helm, MItems.tin_chest, MItems.tin_legs, MItems.tin_feet)){
                BlockPos entityPos = entity.getPosition();
                World world = entity.getEntityWorld();
                if(!world.isAirBlock(entityPos.down())){
                    world.setBlockState(entityPos.down(), Blocks.STONE.getDefaultState(), 2);
                }
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

    @SubscribeEvent
    public static void playerInteracted(PlayerInteractEvent.RightClickBlock e){
        if(e.getPlayer().isCrouching() && e.getWorld().getBlockState(e.getPos()).getBlock() == MBlocks.candle && e.getPlayer().getHeldItem(e.getHand()).getItem() instanceof DyeItem){
            e.setUseItem(Event.Result.DENY);
            //e.setUseBlock(Event.Result.ALLOW);
        }
    }

}
