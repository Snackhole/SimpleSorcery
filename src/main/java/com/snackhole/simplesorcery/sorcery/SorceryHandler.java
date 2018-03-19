package com.snackhole.simplesorcery.sorcery;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.network.GUIRequestPacket;
import com.snackhole.simplesorcery.network.PacketHandler;
import com.snackhole.simplesorcery.network.SpellCastPacket;
import com.snackhole.simplesorcery.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SorceryHandler {
    public static final ResourceLocation SORCERY_CAP = new ResourceLocation(SimpleSorceryMain.MODID, "Sorcery");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(SORCERY_CAP, new SorceryProvider());
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        KeyBinding[] keyBindings = ClientProxy.keyBindings;
        if (keyBindings[0].isPressed()) {
            sendSpellCastPacket(1);
        }
        if (keyBindings[1].isPressed()) {
            sendSpellCastPacket(2);
        }
        if (keyBindings[2].isPressed()) {
            sendSpellCastPacket(3);
        }
        if (keyBindings[3].isPressed()) {
            IMessage msg = new GUIRequestPacket.SorcerySyncRequest();
            PacketHandler.INSTANCE.sendToServer(msg);
        }
    }

    public void sendSpellCastPacket(int spellSlot) {
        RayTraceResult possibleEntityHit = Minecraft.getMinecraft().objectMouseOver;
        boolean entityDetected = false;
        int entityID = 0;
        if (possibleEntityHit.entityHit != null) {
            entityDetected = true;
            entityID = possibleEntityHit.entityHit.getEntityId();
        }
        IMessage msg = new SpellCastPacket.SpellCastMessage(spellSlot, entityDetected, entityID);
        PacketHandler.INSTANCE.sendToServer(msg);
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        int skillDeduction = event.isWasDeath() ? 25 : 0;
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        ISorcery oldSorcery = event.getOriginal().getCapability(SorceryProvider.SORCERY_CAP, null);
        for (String spellName : sorcery.getSpellNamesList()) {
            sorcery.setSkill(spellName, (int) Math.max(oldSorcery.getSkill(spellName) - skillDeduction, 0));
        }
        sorcery.setSlot(1, oldSorcery.getSlot(1));
        sorcery.setSlot(2, oldSorcery.getSlot(2));
        sorcery.setSlot(3, oldSorcery.getSlot(3));
    }
}
