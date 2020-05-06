package minestrapp.containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public class ContainerBackpack extends Container {


    protected ContainerBackpack(@Nullable ContainerType<?> containerType, int windowID) {
        super(containerType, windowID);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
