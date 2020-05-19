package minestrapp.enchantments;

import minestrapp.init.MEnchaments;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedList;
import java.util.Queue;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnchantExcavating extends Enchantment {
    public EnchantExcavating() {
        super(Rarity.COMMON, EnchantmentType.DIGGER, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @SubscribeEvent
    public static void breakBlocks(BlockEvent.BreakEvent event){
        if(EnchantmentHelper.getEnchantments(event.getPlayer().getHeldItemMainhand()).containsKey(MEnchaments.EXCAVATING.get())){
            event.getPlayer().getHeldItemMainhand().damageItem(veinMine(EnchantmentHelper.getEnchantmentLevel(MEnchaments.EXCAVATING.get(), event.getPlayer().getHeldItemMainhand()), event.getPos(), event.getWorld()), event.getPlayer(), (PlayerEntity) -> {
                PlayerEntity.sendBreakAnimation(Hand.MAIN_HAND);
            });
        }
    }

    private static int veinMine(int power, BlockPos pos, IWorld world){
        Queue q = new LinkedList();
        Block bl = world.getBlockState(pos).getBlock();
        q.add(pos);

        int maxBlock = 5 * power;
        int blocksMined = 0;

        while(!q.isEmpty() && blocksMined < maxBlock){
            BlockPos bp = (BlockPos)q.poll();

            if(world.destroyBlock(bp, true)){
                blocksMined++;
            }

            if(world.getBlockState(bp.up()).getBlock() == bl){
                q.add(bp.up());
            }

            if(world.getBlockState(bp.down()).getBlock() == bl){
                q.add(bp.down());
            }

            if(world.getBlockState(bp.north()).getBlock() == bl){
                q.add(bp.north());
            }

            if(world.getBlockState(bp.south()).getBlock() == bl){
                q.add(bp.south());
            }

            if(world.getBlockState(bp.east()).getBlock() == bl){
                q.add(bp.east());
            }

            if(world.getBlockState(bp.west()).getBlock() == bl){
                q.add(bp.west());
            }
        }

        return blocksMined;
    }

}
