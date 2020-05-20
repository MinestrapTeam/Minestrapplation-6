package minestrapp.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.awt.*;

public class TileEntityCandle extends TileEntity {

    public int r = 255;
    public int g = 255;
    public int b = 255;

    public TileEntityCandle(TileEntityType<?> tileEntityType){
        super(tileEntityType);
    }

    public TileEntityCandle(){
        super(TileEntityTypes.CANDLE_TILE.get());
    }

    public void setColor(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
        this.saveAndSync();
    }

    public void addColor(int r, int g, int b){
        if(this.r + r > 255){
            this.r = 0;
        } else {
            this.r += r;
        }

        if(this.g + g > 255){
            this.g = 0;
        } else {
            this.g += g;
        }

        if(this.b + b > 255){
            this.b = 0;
        } else {
            this.b += b;
        }

        this.saveAndSync();
    }

    public void setColor(Color color){
        this.r = color.getRed();
        this.g = color.getGreen();
        this.b = color.getBlue();
        this.saveAndSync();
    }

    public Color getColor(){
        return new Color(r, g, b);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.r = compound.getInt("r");
        this.g = compound.getInt("g");
        this.b = compound.getInt("b");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("r", this.r);
        compound.putInt("g", this.g);
        compound.putInt("b", this.b);
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
