package minestrapp.gui;

import minestrapp.containers.ContainerBackpack;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class GuiBackpack extends ContainerScreen<ContainerBackpack> implements IHasContainer<ContainerBackpack> {

    public GuiBackpack(ContainerBackpack containerBackpack, PlayerInventory playerInventory, ITextComponent title) {
        super(containerBackpack, playerInventory, title);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
