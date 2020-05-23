package minestrapp.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import minestrapp.Reference;
import minestrapp.containers.inventories.ContainerBrickOven;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BrickOvenGui extends ContainerScreen<ContainerBrickOven> {

    private ResourceLocation GUI = new ResourceLocation(Reference.id, "textures/gui/brickoven.png");

    public BrickOvenGui(ContainerBrickOven container, PlayerInventory inv, ITextComponent name) {
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
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
        this.blit(relX + 79, relY + 34, 176, 14, cookScaled() + 1, 17);
        if(this.container.te.isBlockLitBySun()){
            this.blit(relX + 27, relY + 12, 176, 31, 16, 16);
        }
    }

    private int cookScaled(){
        return (24 * this.container.te.cookTime) / this.container.te.cookTimeTotal;
    }
}
