package minestrapp.init;

import minestrapp.Reference;
import minestrapp.tileentity.TileEntityBrickOven;
import minestrapp.tileentity.TileEntityCandle;
import minestrapp.tileentity.TileEntityGoblet;
import minestrapp.tileentity.TileEntityMelter;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILEENTITY_REGISTRY = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Reference.id);

    public static final RegistryObject<TileEntityType<TileEntityCandle>> CANDLE_TILE = TILEENTITY_REGISTRY.register("candle", () -> TileEntityType.Builder.create(TileEntityCandle::new, MBlocks.CANDLE.get()).build(null));
    public static final RegistryObject<TileEntityType<TileEntityGoblet>> GOBLET_TILE = TILEENTITY_REGISTRY.register("goblet", () -> TileEntityType.Builder.create(TileEntityGoblet::new, MBlocks.GOBLET.get()).build(null));

    public static final RegistryObject<TileEntityType<TileEntityMelter>> MELTER_TILE = TILEENTITY_REGISTRY.register("melter", () -> TileEntityType.Builder.create(TileEntityMelter::new, MBlocks.MELTER.get()).build(null));
    public static final RegistryObject<TileEntityType<TileEntityBrickOven>> OVEN_TILE = TILEENTITY_REGISTRY.register("brickoven", () -> TileEntityType.Builder.create(TileEntityBrickOven::new, MBlocks.OVEN.get()).build(null));}
