package minestrapp.tileentity;

import minestrapp.init.TileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityGoblet extends TileEntity {

    public EffectInstance effect;

    public TileEntityGoblet(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TileEntityGoblet() {
        super(TileEntityTypes.GOBLET_TILE.get());
    }

    public void setEffect(EffectInstance effect){
        this.effect = effect;
        this.saveAndSync();
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.effect = EffectInstance.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        this.effect.write(compound);
        return compound;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket (this.getPos(), 0, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        this.read(packet.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(CompoundNBT nbt) {
        this.read(nbt);
    }

    public void saveAndSync() {
        BlockState state = this.world.getBlockState(this.pos);
        this.world.notifyBlockUpdate(pos, state, state, 3);
        this.markDirty();
    }
}
