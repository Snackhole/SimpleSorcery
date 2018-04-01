package com.snackhole.simplesorcery.gui;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class SorceryHUDGui extends Gui {
    private Minecraft minecraft;
    private ScaledResolution scaledResolution;
    private int textureWidth = 74;
    private int textureHeight = 31;
    private int textureFileWidth = 74;
    private int textureFileHeight = 598;
    private int iconDim = 24;
    private ISorcery sorcery;
    private final ResourceLocation guiTexture = new ResourceLocation(SimpleSorceryMain.MODID, "textures/gui/spellhud.png");
    private HashMap<String, IconPosition> iconPositions = new HashMap<String, IconPosition>();

    public SorceryHUDGui(Minecraft minecraft) {
        this.minecraft = minecraft;
        iconPositions.put("", new IconPosition(-1));
        iconPositions.put("absorption", new IconPosition(1));
        iconPositions.put("fireresistance", new IconPosition(2));
        iconPositions.put("glowing", new IconPosition(3));
        iconPositions.put("haste", new IconPosition(4));
        iconPositions.put("invisibility", new IconPosition(5));
        iconPositions.put("jumpboost", new IconPosition(6));
        iconPositions.put("levitation", new IconPosition(7));
        iconPositions.put("nightvision", new IconPosition(8));
        iconPositions.put("regeneration", new IconPosition(9));
        iconPositions.put("resistance", new IconPosition(10));
        iconPositions.put("speed", new IconPosition(11));
        iconPositions.put("strength", new IconPosition(12));
        iconPositions.put("waterbreathing", new IconPosition(13));
        iconPositions.put("blindness", new IconPosition(14));
        iconPositions.put("hunger", new IconPosition(15));
        iconPositions.put("miningfatigue", new IconPosition(16));
        iconPositions.put("nausea", new IconPosition(17));
        iconPositions.put("poison", new IconPosition(18));
        iconPositions.put("slowness", new IconPosition(19));
        iconPositions.put("weakness", new IconPosition(20));
        iconPositions.put("wither", new IconPosition(21));
        iconPositions.put("dispel", new IconPosition(22));
        iconPositions.put("enderpocket", new IconPosition(23));
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
        sorcery = minecraft.player.getCapability(SorceryProvider.SORCERY_CAP, null);
        scaledResolution = new ScaledResolution(minecraft);
        minecraft.renderEngine.bindTexture(guiTexture);
        int guiXStart = scaledResolution.getScaledWidth() - textureWidth - 1;
        int guiYStart = scaledResolution.getScaledHeight() - textureHeight - 1;
        drawModalRectWithCustomSizedTexture(guiXStart, guiYStart, 0, 0, textureWidth, textureHeight, textureFileWidth, textureFileHeight);
        iconPositions.get(sorcery.getSlot(1)).render(guiXStart, guiYStart, 1);
        iconPositions.get(sorcery.getSlot(2)).render(guiXStart, guiYStart, 2);
        iconPositions.get(sorcery.getSlot(3)).render(guiXStart, guiYStart, 3);
    }

    private class IconPosition {
        private int y;
        private int yStart;

        public IconPosition(int y) {
            this.y = y;
            yStart = ((this.y - 1) * iconDim) + textureHeight;
        }

        public void render(int guiXStart, int guiYStart, int slot) {
            if (y == -1) {
                return;
            }
            drawModalRectWithCustomSizedTexture(guiXStart + ((slot - 1) * (iconDim + 1)), guiYStart + 7, 0, yStart, iconDim, iconDim, textureFileWidth, textureFileHeight);
        }
    }
}
