package minestrapp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
//TODO finish implementing
public class BlockBlazium extends Block {

    private int tickTime = 30;

    public BlockBlazium(Block.Properties prop){
        super(prop);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickTime, TickPriority.NORMAL);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickTime, TickPriority.NORMAL);
        if(worldIn.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)){
            boolean flag1 = worldIn.isBlockinHighHumidity(pos);
            int k = flag1 ? -50 : 0;
            this.tryCatchFire(worldIn, pos.east(), 300 + k, rand, rand.nextInt(10), Direction.WEST);
            this.tryCatchFire(worldIn, pos.west(), 300 + k, rand, rand.nextInt(10), Direction.EAST);
            this.tryCatchFire(worldIn, pos.down(), 250 + k, rand, rand.nextInt(10), Direction.UP);
            this.tryCatchFire(worldIn, pos.up(), 250 + k, rand, rand.nextInt(10), Direction.DOWN);
            this.tryCatchFire(worldIn, pos.north(), 300 + k, rand, rand.nextInt(10), Direction.SOUTH);
            this.tryCatchFire(worldIn, pos.south(), 300 + k, rand, rand.nextInt(10), Direction.NORTH);
        }
    }

    private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, Direction face) {
        int i = worldIn.getBlockState(pos).getFlammability(worldIn, pos, face);
        if (random.nextInt(chance) < i) {
            BlockState blockstate = worldIn.getBlockState(pos);
            if (random.nextInt(age + 10) < 5 && !worldIn.isRainingAt(pos)) {
                int j = Math.min(age + random.nextInt(5) / 4, 15);
                worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState().with(FireBlock.AGE, Integer.valueOf(j)), 3);
            } else {
                worldIn.removeBlock(pos, false);
            }

            blockstate.catchFire(worldIn, pos, face, null);
        }

    }

    private int getNeighborFireChance(World worldIn, BlockPos pos){
        if (!worldIn.isAirBlock(pos)) {
            return 0;
        } else {
            int i = 0;

            for(Direction direction : Direction.values()) {
                BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
                i = Math.max(blockstate.getFlammability(worldIn, pos.offset(direction), direction.getOpposite()), i);
            }

            return i;
        }
    }
}
