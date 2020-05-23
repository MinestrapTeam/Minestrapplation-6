package minestrapp.init;

import minestrapp.Minestrapp;
import minestrapp.Reference;
import minestrapp.containers.ContainerBackpack;
import minestrapp.containers.ContainerMelter;
import minestrapp.containers.inventories.ContainerBrickOven;
import minestrapp.containers.inventories.InventoryBackpack;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Reference.id);

    public static final RegistryObject<ContainerType<ContainerMelter>> MELTER_CONTAINER = CONTAINERS.register("melter", () -> IForgeContainerType.create((windowID, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        return new ContainerMelter(windowID, Minestrapp.proxy.getClientWorld(), pos, inv, Minestrapp.proxy.getClientPlayer());
    }));

    public static final RegistryObject<ContainerType<ContainerBrickOven>> OVEN_CONTAINER = CONTAINERS.register("brickoven", () -> IForgeContainerType.create((windowID, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        return new ContainerBrickOven(windowID, Minestrapp.proxy.getClientWorld(), pos, inv, Minestrapp.proxy.getClientPlayer());
    }));

    public static final RegistryObject<ContainerType<ContainerBackpack>> BACKPACK_CONTAINER = CONTAINERS.register("backpack", () -> IForgeContainerType.create((windowID, inv, data) -> {
        return new ContainerBackpack(windowID, inv, new InventoryBackpack(Minestrapp.proxy.getClientPlayer().getHeldItemMainhand(), 20));
    }));
}
