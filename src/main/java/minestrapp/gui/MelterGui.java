package minestrapp.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import minestrapp.Reference;
import minestrapp.containers.ContainerMelter;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.awt.*;

public class MelterGui extends ContainerScreen<ContainerMelter> {

    private ResourceLocation GUI = new ResourceLocation(Reference.id, "textures/gui/melter.png");

    public MelterGui(ContainerMelter container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String lvt_3_1_ = this.title.getFormattedText();
        this.font.drawString(lvt_3_1_, (float)(this.xSize / 2 - this.font.getStringWidth(lvt_3_1_) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.fontRenderer.drawString(Integer.toString(this.container.te.burnTime), 0, 0, new Color(255, 38, 234).getRGB());
        minecraft.fontRenderer.drawString(Integer.toString(this.container.te.cookTime), 0, 15, new Color(255, 251, 15).getRGB());
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
        this.blit(relX + 56, relY + 36 + 12 - burnScaled(), 176, 12 - burnScaled(), 14, burnScaled());
        this.blit(relX + 79, relY + 34, 176, 14, cookScaled() + 1, 17);
        //this.blit(relX + 34, relY + 34, 176, 13 - burnScaled(), 14, burnScaled() + 2);
    }

    private int burnScaled(){
        int totalBurn = this.container.te.bunrTimeTotal;
        int l;

        if(totalBurn <= 0){
             l = 1600;
        } else {
            l = totalBurn;
        }
        return (14 * this.container.te.burnTime) / l;
    }

    private int cookScaled(){
        return (24 * this.container.te.cookTime) / this.container.te.cookTimeTotal;
    }
}
