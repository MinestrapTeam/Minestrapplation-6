package minestrapp.tileentity;

import minestrapp.containers.ContainerMelter;
import minestrapp.recipes.MelterRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.ForgeHooks;
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


public class TileEntityMelter extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);
    private final int INPUT_SLOT = 0;
    private final int FUEL_SLOT = 1;
    private final int BUCKET_SLOT = 2;
    private final int OUTPUT_SLOT = 3;


    public int burnTime;
    public int bunrTimeTotal;
    public int cookTime;
    public int cookTimeTotal = 200;

    public TileEntityMelter(TileEntityType<?> tileEntityType){
        super(tileEntityType);
    }

    public TileEntityMelter(){
        super(TileEntityTypes.MELTER_TILE.get());
    }

    @Override
    public void tick() {
        handler.ifPresent(h ->{
            MelterRecipe recipe = world.getRecipeManager().getRecipe(MelterRecipe.melter, new RecipeWrapper((IItemHandlerModifiable) h), world).orElse(null);
            if(recipe != null){
                ItemStack input = h.getStackInSlot(INPUT_SLOT);
                ItemStack output = h.getStackInSlot(OUTPUT_SLOT);
                ItemStack fuel = h.getStackInSlot(FUEL_SLOT);
                ItemStack bucket = h.getStackInSlot(BUCKET_SLOT);

                if(input.isEmpty()){
                    cookTime = 0;
                }

                if(this.getBurnTime(fuel) > 0 && this.burnTime == 0){
                    this.burnTime = this.getBurnTime(fuel);
                    this.bunrTimeTotal = burnTime;
                    fuel.shrink(1);
                }

                if(canMelt(recipe, (IItemHandlerModifiable) h)){
                    cookTime++;
                    if(cookTime >= cookTimeTotal){
                        h.getStackInSlot(INPUT_SLOT).shrink(1);
                        if(recipe.needsBucket()) {
                            bucket.shrink(1);
                        }
                        if(output.isEmpty()){
                            ((IItemHandlerModifiable) h).setStackInSlot(OUTPUT_SLOT, recipe.getRecipeOutput());
                        }
                        output.grow(1);
                        cookTime = 0;
                    }
                }
                if(burnTime > 0) {
                    burnTime--;
                }
                this.markDirty();
            }
        });

    }

    public boolean isBurning(){
        return burnTime > 0;
    }

    private boolean canMelt(MelterRecipe recipe, IItemHandlerModifiable h){
        if(recipe != null){
            ItemStack input = h.getStackInSlot(INPUT_SLOT);
            ItemStack output = h.getStackInSlot(OUTPUT_SLOT);
            ItemStack fuel = h.getStackInSlot(FUEL_SLOT);
            ItemStack bucket = h.getStackInSlot(BUCKET_SLOT);

            if(!isBurning()){
                return false;
            }

            if(recipe.getRecipeOutput().getItem() != output.getItem() && !output.isEmpty()){
                return false;
            }

            if(output.getCount() == output.getMaxStackSize()){
                return false;
            }

            if(recipe.needsBucket() && bucket.getItem() != Items.BUCKET){
                return false;
            }
        }
        return true;
    }

    public int getBurnTime(ItemStack stack){
        return ForgeHooks.getBurnTime(stack);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerMelter(i, world, pos, playerInventory, playerEntity);
    }

    @Override
    public void read(CompoundNBT tag){
        CompoundNBT inv = tag.getCompound("inv");
        handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>)h).deserializeNBT(inv));
        burnTime = tag.getInt("burnTime");
        cookTime = tag.getInt("cookTime");
        super.read(tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        handler.ifPresent(h -> {
            CompoundNBT compound = ((INBTSerializable<CompoundNBT>)h).serializeNBT();
            tag.put("inv", compound);
        });
        tag.putInt("burnTime", burnTime);
        tag.putInt("cookTime", cookTime);
        return super.write(tag);
    }

    private IItemHandlerModifiable createHandler(){
        return new ItemStackHandler(4){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {

                if(slot == OUTPUT_SLOT){
                    return false;
                } else if(slot == BUCKET_SLOT && stack.getItem() != Items.BUCKET){
                    return false;
                } else if(slot == FUEL_SLOT && getBurnTime(stack) <= 0){
                    return false;
                }

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

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
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
