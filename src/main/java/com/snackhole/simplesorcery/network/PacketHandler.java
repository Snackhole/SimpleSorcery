package com.snackhole.simplesorcery.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("simplesorcery");
    private static int nextPacketID = 0;

    public static void initPackets() {
        registerMessage(SpellCastPacket.class, SpellCastPacket.SpellCastMessage.class);
        registerMessage(GUIRequestPacket.class, GUIRequestPacket.GUIRequestMessage.class);
        registerMessage(SorcerySyncRequestPacket.class, SorcerySyncRequestPacket.SorcerySyncRequestMessage.class);
        registerMessage(SorcerySyncMessagePacket.class, SorcerySyncMessagePacket.SorcerySyncMessage.class);
        registerMessage(SlotSetPacket.class, SlotSetPacket.SlotSetMessage.class);
    }

    private static void registerMessage(Class packet, Class message) {
        INSTANCE.registerMessage(packet, message, nextPacketID, Side.CLIENT);
        INSTANCE.registerMessage(packet, message, nextPacketID, Side.SERVER);
        nextPacketID++;
    }
}
