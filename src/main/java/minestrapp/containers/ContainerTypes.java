package minestrapp.containers;

import minestrapp.Minestrapp;
import minestrapp.Reference;
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
}
