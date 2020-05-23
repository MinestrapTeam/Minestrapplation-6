package minestrapp.tileentity;

import minestrapp.containers.inventories.ContainerBrickOven;
import minestrapp.init.TileEntityTypes;
import minestrapp.recipes.BrickOvenRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityBrickOven extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    public LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private final int INPUT_SLOT = 0;
    private final int INPUT_SLOT_TWO = 1;

    public LazyOptional<IItemHandler> output_handler = LazyOptional.of(this::createOutHandler);
    private final int OUTPUT_SLOT = 0;

    public int cookTime;
    public int cookTimeTotal = 100;

    public TileEntityBrickOven(TileEntityType<?> tileEntityType){
        super(tileEntityType);
    }

    public TileEntityBrickOven(){
        super(TileEntityTypes.OVEN_TILE.get());
    }

    @Override
    public void tick() {
        IItemHandlerModifiable h = (IItemHandlerModifiable) handler.orElse(null);
        IItemHandlerModifiable out_h = (IItemHandlerModifiable) output_handler.orElse(null);
        RecipeWrapper rw = new RecipeWrapper(h);

        BrickOvenRecipe recipe = world.getRecipeManager().getRecipe(BrickOvenRecipe.oven, rw, world).orElse(null);

        ItemStack input = h.getStackInSlot(INPUT_SLOT);
        ItemStack input2 = h.getStackInSlot(INPUT_SLOT_TWO);
        ItemStack output = out_h.getStackInSlot(OUTPUT_SLOT);

        if(input.isEmpty() || input2.isEmpty()){
            this.cookTime = 0;
        }

        if(recipe != null){
            if(canCook(recipe, h, out_h)){
                cookTime++;
            }
            if(cookTime >= cookTimeTotal){
                input.shrink(1);
                input2.shrink(1);
                if(output.isEmpty()){
                    out_h.setStackInSlot(OUTPUT_SLOT, recipe.getRecipeOutput().copy());
                } else {
                    output.grow(1);
                }
                cookTime = 0;
            }
        }
        this.markDirty();
    }

    private boolean canCook(BrickOvenRecipe recipe, IItemHandlerModifiable h, IItemHandlerModifiable out){
        ItemStack output = out.getStackInSlot(OUTPUT_SLOT);

        if(!output.isEmpty() && output.getItem() != recipe.getRecipeOutput().getItem()){
            return false;
        }

        if(output.getCount() == output.getMaxStackSize()){
            return false;
        }

        if(world.canBlockSeeSky(pos) && isBlockLitBySun()){
            return true;
        }
        return false;
    }

    public boolean isBlockLitBySun(){
        long time = world.getDayTime();
        if((time >= 1000 && time <= 12500)){
            return true;
        }
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerBrickOven(i, world, pos, playerInventory, playerEntity);
    }

    @Override
    public void read(CompoundNBT tag){
        CompoundNBT inputs = tag.getCompound("inputs");
        CompoundNBT output = tag.getCompound("output");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(inputs));
        output_handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(output));
        cookTime = tag.getInt("cookTime");
        super.read(tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        handler.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            tag.put("inputs", compound);
        });
        output_handler.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            tag.put("output", compound);
        });
        tag.putInt("cookTime", cookTime);
        return super.write(tag);
    }

    private IItemHandlerModifiable createHandler(){
        return new ItemStackHandler(2){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }

            @Override
            @Nonnull
            public ItemStack extractItem(int slot, int amount, boolean simulate){
                return super.extractItem(slot, amount, simulate);
            }

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }
        };
    }

    private IItemHandlerModifiable createOutHandler(){
        return new ItemStackHandler(1){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return false;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }

            @Override
            @Nonnull
            public ItemStack extractItem(int slot, int amount, boolean simulate){
                return super.extractItem(slot, amount, simulate);
            }

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if((side == Direction.DOWN  || side == Direction.UP) && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return output_handler.cast();
        }
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
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
}
