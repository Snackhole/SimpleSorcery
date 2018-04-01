package com.snackhole.simplesorcery.gui;

import com.snackhole.simplesorcery.network.PacketHandler;
import com.snackhole.simplesorcery.network.SlotSetPacket;
import com.snackhole.simplesorcery.network.SorcerySyncRequestPacket;
import com.snackhole.simplesorcery.proxy.ClientProxy;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SorceryGui extends GuiScreen {
    private Minecraft minecraft;
    private EntityPlayer player;
    private ISorcery sorcery;
    private ScaledResolution scaledResolution;
    private int guiYStart;
    private int guiXStart;
    private ArrayList<GuiButton> spellButtonsList = new ArrayList<GuiButton>();
    private GuiButton scrollUpButton;
    private GuiButton scrollDownButton;
    private GuiButton doneButton;
    private GuiButton slot1Button;
    private GuiButton slot2Button;
    private GuiButton slot3Button;
    private GuiButton absorptionButton;
    private GuiButton blindnessButton;
    private GuiButton dispelButton;
    private GuiButton enderPocketButton;
    private GuiButton fireResistanceButton;
    private GuiButton glowingButton;
    private GuiButton hasteButton;
    private GuiButton hungerButton;
    private GuiButton invisibilityButton;
    private GuiButton jumpBoostButton;
    private GuiButton levitationButton;
    private GuiButton miningFatigueButton;
    private GuiButton nauseaButton;
    private GuiButton nightVisionButton;
    private GuiButton poisonButton;
    private GuiButton regenerationButton;
    private GuiButton resistanceButton;
    private GuiButton slownessButton;
    private GuiButton speedButton;
    private GuiButton strengthButton;
    private GuiButton waterBreathingButton;
    private GuiButton weaknessButton;
    private GuiButton witherButton;
    private int spellButtonID;
    private int spellButtonX;
    private int spellButtonY;
    private HashMap<GuiButton, String> spellButtonValues = new HashMap<GuiButton, String>();
    private String currentDisplayedSpell;
    private String spellDescription;

    @Override
    public void initGui() {
        minecraft = Minecraft.getMinecraft();
        player = minecraft.player;
        sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        scaledResolution = new ScaledResolution(minecraft);
        guiYStart = (scaledResolution.getScaledHeight() - getPixelsFromScreenUnits(11)) / 2;
        guiXStart = (scaledResolution.getScaledWidth() - getPixelsFromScreenUnits(15)) / 2;

        // Done Button
        doneButton = constructButton(0, 6, 1, 9, 10, "Done");
        buttonList.add(doneButton);

        // Slot Buttons
        slot1Button = constructButton(1, 8, 1, 0, 0, "Slot 1:  " + sorcery.getSpellProperName(sorcery.getSlot(1)));
        buttonList.add(slot1Button);
        slot2Button = constructButton(2, 8, 1, 0, 1, "Slot 2:  " + sorcery.getSpellProperName(sorcery.getSlot(2)));
        buttonList.add(slot2Button);
        slot3Button = constructButton(3, 8, 1, 0, 2, "Slot 3:  " + sorcery.getSpellProperName(sorcery.getSlot(3)));
        buttonList.add(slot3Button);

        // Scrolling Buttons
        scrollUpButton = constructButton(4, 2, 1, 11, 0, "UP");
        buttonList.add(scrollUpButton);
        scrollDownButton = constructButton(5, 2, 1, 11, 8, "DOWN");
        buttonList.add(scrollDownButton);

        // Spell Buttons
        spellButtonID = 6;
        spellButtonX = 9;
        spellButtonY = 1;

        absorptionButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Absorption");
        spellButtonsList.add(absorptionButton);
        spellButtonValues.put(absorptionButton, "absorption");

        blindnessButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Blindness");
        spellButtonsList.add(blindnessButton);
        spellButtonValues.put(blindnessButton, "blindness");

        dispelButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Dispel");
        spellButtonsList.add(dispelButton);
        spellButtonValues.put(dispelButton, "dispel");

        enderPocketButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Ender Pocket");
        spellButtonsList.add(enderPocketButton);
        spellButtonValues.put(enderPocketButton, "enderpocket");

        fireResistanceButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Fire Resistance");
        spellButtonsList.add(fireResistanceButton);
        spellButtonValues.put(fireResistanceButton, "fireresistance");

        glowingButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Glowing");
        spellButtonsList.add(glowingButton);
        spellButtonValues.put(glowingButton, "glowing");

        hasteButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Haste");
        spellButtonsList.add(hasteButton);
        spellButtonValues.put(hasteButton, "haste");

        hungerButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Hunger");
        spellButtonsList.add(hungerButton);
        spellButtonValues.put(hungerButton, "hunger");

        invisibilityButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Invisibility");
        spellButtonsList.add(invisibilityButton);
        spellButtonValues.put(invisibilityButton, "invisibility");

        jumpBoostButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Jump Boost");
        spellButtonsList.add(jumpBoostButton);
        spellButtonValues.put(jumpBoostButton, "jumpboost");

        levitationButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Levitation");
        spellButtonsList.add(levitationButton);
        spellButtonValues.put(levitationButton, "levitation");

        miningFatigueButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Mining Fatigue");
        spellButtonsList.add(miningFatigueButton);
        spellButtonValues.put(miningFatigueButton, "miningfatigue");

        nauseaButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Nausea");
        spellButtonsList.add(nauseaButton);
        spellButtonValues.put(nauseaButton, "nausea");

        nightVisionButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Night Vision");
        spellButtonsList.add(nightVisionButton);
        spellButtonValues.put(nightVisionButton, "nightvision");

        poisonButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Poison");
        spellButtonsList.add(poisonButton);
        spellButtonValues.put(poisonButton, "poison");

        regenerationButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Regeneration");
        spellButtonsList.add(regenerationButton);
        spellButtonValues.put(regenerationButton, "regeneration");

        resistanceButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Resistance");
        spellButtonsList.add(resistanceButton);
        spellButtonValues.put(resistanceButton, "resistance");

        slownessButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Slowness");
        spellButtonsList.add(slownessButton);
        spellButtonValues.put(slownessButton, "slowness");

        speedButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Speed");
        spellButtonsList.add(speedButton);
        spellButtonValues.put(speedButton, "speed");

        strengthButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Strength");
        spellButtonsList.add(strengthButton);
        spellButtonValues.put(strengthButton, "strength");

        waterBreathingButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Water Breathing");
        spellButtonsList.add(waterBreathingButton);
        spellButtonValues.put(waterBreathingButton, "waterbreathing");

        weaknessButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Weakness");
        spellButtonsList.add(weaknessButton);
        spellButtonValues.put(weaknessButton, "weakness");

        witherButton = constructButton(spellButtonID++, 6, 1, spellButtonX, spellButtonY++, "Wither");
        spellButtonsList.add(witherButton);
        spellButtonValues.put(witherButton, "wither");

        for (GuiButton spellButton : spellButtonsList) {
            buttonList.add(spellButton);
        }

        // Current Spell Info
        currentDisplayedSpell = "absorption";
        spellDescription = sorcery.getSpellInfoString(currentDisplayedSpell) + "\n\nLevel:  " + sorcery.getLevelString(currentDisplayedSpell) + ".\nSkill:  " + sorcery.getSkill(currentDisplayedSpell) + "/100.\nCost/Skill Gain:  " + sorcery.getCost(currentDisplayedSpell) + ".";

    }

    @Override
    public void actionPerformed(GuiButton button) {
        if (button.id == doneButton.id) {
            player.closeScreen();
            IMessage msg = new SorcerySyncRequestPacket.SorcerySyncRequestMessage();
            PacketHandler.INSTANCE.sendToServer(msg);
        } else if (button.id == scrollUpButton.id) {
            scrollSpellList(20);
        } else if (button.id == scrollDownButton.id) {
            scrollSpellList(-20);
        } else if (button.id == slot1Button.id || button.id == slot2Button.id || button.id == slot3Button.id) {
            IMessage msg = new SlotSetPacket.SlotSetMessage(button.id, currentDisplayedSpell);
            PacketHandler.INSTANCE.sendToServer(msg);
            button.displayString = "Slot " + button.id + ":  " + sorcery.getSpellProperName(currentDisplayedSpell);
        } else if (spellButtonsList.contains(button)) {
            currentDisplayedSpell = spellButtonValues.get(button);
            spellDescription = sorcery.getSpellInfoString(currentDisplayedSpell) + "\n\nLevel:  " + sorcery.getLevelString(currentDisplayedSpell) + ".\nSkill:  " + sorcery.getSkill(currentDisplayedSpell) + "/100.\nCost/Skill Gain:  " + sorcery.getCost(currentDisplayedSpell) + ".";
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        hideSpellButtons();
        super.drawScreen(mouseX, mouseY, partialTicks);
        minecraft.fontRenderer.drawSplitString(spellDescription, guiXStart + getPixelsFromScreenUnits(0), guiYStart + getPixelsFromScreenUnits(4), getPixelsFromScreenUnits(8), 14737632);
    }

    private GuiButton constructButton(int buttonID, int buttonWidth, int buttonHeight, int x, int y, String text) {
        return new GuiButton(buttonID, guiXStart + getPixelsFromScreenUnits(x), guiYStart + getPixelsFromScreenUnits(y), getPixelsFromScreenUnits(buttonWidth), getPixelsFromScreenUnits(buttonHeight), text);
    }

    private void hideSpellButtons() {
        for (GuiButton spellButton : spellButtonsList) {
            if (spellButton.y <= scrollUpButton.y || spellButton.y >= scrollDownButton.y) {
                spellButton.visible = false;
            } else {
                spellButton.visible = true;
            }
        }
    }

    private void scrollSpellList(int scrollDelta) {
        if ((spellButtonsList.get(spellButtonsList.size() - 1).visible && scrollDelta < 0) || (spellButtonsList.get(0).visible && scrollDelta > 0)) {
            return;
        }
        for (GuiButton spellButton : spellButtonsList) {
            spellButton.y += scrollDelta;
        }
    }

    private int getPixelsFromScreenUnits(int screenUnits) {
        return screenUnits * 20;
    }

    private void mouseWheeled(int mouseX, int mouseY, int mouseWheelDelta) throws IOException {
        boolean fireMouseWheel = false;
        for (GuiButton spellButton : spellButtonsList) {
            if (spellButton.mousePressed(this.mc, mouseX, mouseY)) {
                fireMouseWheel = true;
            }
        }
        if (fireMouseWheel) {
            scrollSpellList(mouseWheelDelta * 20);
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int mouseWheelDelta = Integer.signum(Mouse.getEventDWheel());
        if (mouseWheelDelta != 0) {
            int i = Mouse.getEventX() * this.width / this.mc.displayWidth;
            int j = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            mouseWheeled(i, j, mouseWheelDelta);
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        if (keyCode == ClientProxy.keyBindings[3].getKeyCode()) {
            player.closeScreen();
        }
    }
}
