package minestrapp.tileentity;

import minestrapp.MBlocks;
import minestrapp.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILEENTITY_REGISTRY = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Reference.id);

    public static final RegistryObject<TileEntityType<TileEntityCandle>> CANDLE_TILE = TILEENTITY_REGISTRY.register("candle", () -> TileEntityType.Builder.create(TileEntityCandle::new, MBlocks.CANDLE.get()).build(null));
}
