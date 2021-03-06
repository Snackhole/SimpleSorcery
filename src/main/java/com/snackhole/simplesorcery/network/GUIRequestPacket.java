package com.snackhole.simplesorcery.network;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GUIRequestPacket implements IMessageHandler<GUIRequestPacket.GUIRequestMessage, SorcerySyncMessagePacket.SorcerySyncMessage> {
    @Override
    public SorcerySyncMessagePacket.SorcerySyncMessage onMessage(GUIRequestMessage message, MessageContext ctx) {
        EntityPlayer player = SimpleSorceryMain.proxy.getPlayerEntityFromContext(ctx);
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        return new SorcerySyncMessagePacket.SorcerySyncMessage(sorcery, true);
    }

    public static class GUIRequestMessage implements IMessage {
        public GUIRequestMessage() {
        }

        @Override
        public void fromBytes(ByteBuf buf) {

        }

        @Override
        public void toBytes(ByteBuf buf) {

        }
    }
}
