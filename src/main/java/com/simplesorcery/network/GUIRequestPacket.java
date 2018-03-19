package com.simplesorcery.network;

import com.simplesorcery.sorcery.ISorcery;
import com.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class GUIRequestPacket implements IMessageHandler<GUIRequestPacket.SorcerySyncRequest, SorcerySyncMessagePacket.SorcerySyncMessage> {
    @Override
    public SorcerySyncMessagePacket.SorcerySyncMessage onMessage(SorcerySyncRequest message, MessageContext ctx) {
        EntityPlayer player = proxy.getPlayerEntityFromContext(ctx);
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        return new SorcerySyncMessagePacket.SorcerySyncMessage(sorcery);
    }

    public static class SorcerySyncRequest implements IMessage {
        public SorcerySyncRequest() {
        }

        @Override
        public void fromBytes(ByteBuf buf) {

        }

        @Override
        public void toBytes(ByteBuf buf) {

        }
    }
}
