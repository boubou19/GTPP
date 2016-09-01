package miscutil.xmod.ic2.block.RTGGenerator.gui;

import ic2.core.IC2;
import ic2.core.block.generator.gui.GuiRTGenerator;
import ic2.core.util.GuiTooltipHelper;
import miscutil.xmod.ic2.block.RTGGenerator.TileEntityRTG;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUI_RTG
  extends GuiRTGenerator
{
  public CONTAINER_RTG container;
  public String name;
  
  public GUI_RTG(CONTAINER_RTG container1)
  {
    super(container1);
    
    this.container = container1;
    this.name = "RTG Mach II";
  }
  
  @Override
protected void drawGuiContainerForegroundLayer(int par1, int par2)
  {
    this.fontRendererObj.drawString(this.name, (this.xSize - this.fontRendererObj.getStringWidth(this.name)) / 2, 4, 4210752);
    
    GuiTooltipHelper.drawAreaTooltip(par1 - this.guiLeft, par2 - this.guiTop, StatCollector.translateToLocalFormatted("ic2.generic.text.bufferEU", new Object[] { Double.valueOf(((TileEntityRTG)this.container.base).storage) }), 117, 38, 150, 48);
  }
  
  @Override
protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
  {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.getTextureManager().bindTexture(background);
    int j = (this.width - this.xSize) / 2;
    int k = (this.height - this.ySize) / 2;
    drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
    
    int i1 = ((TileEntityRTG)this.container.base).gaugeStorageScaled(31);
    drawTexturedModalRect(j + 119, k + 40, 179, 3, i1, 8);
  }
  
  private static final ResourceLocation background = new ResourceLocation(IC2.textureDomain, "textures/gui/GUIRTGenerator.png");
}