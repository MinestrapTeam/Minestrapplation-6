package minestrapp.world;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.thread.EffectiveSide;

public class WorldGenManager {

    private final int dimensionID;

    public WorldGenManager(int dimensionID) {
        this.dimensionID = dimensionID;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPopulateChunk(ChunkEvent.Load event) {
        if (event.getWorld() == null || event.getChunk() == null)
            return;

        if (EffectiveSide.get() == LogicalSide.SERVER) {
            if (dimensionID == event.getWorld().getDimension().getType().getId()) {
                IChunk chunk = event.getChunk();

                StoneGen.replaceStoneInChunk(chunk);

                ((Chunk) chunk).setModified(true);
                ((Chunk) chunk).markDirty();
            }
        }
    }
}