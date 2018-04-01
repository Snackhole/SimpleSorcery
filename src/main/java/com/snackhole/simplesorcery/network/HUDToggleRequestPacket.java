package com.snackhole.simplesorcery.network;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class HUDToggleRequestPacket implements IMessageHandler<HUDToggleRequestPacket.HUDToggleRequestMessage, SorcerySyncMessagePacket.SorcerySyncMessage> {
    @Override
    public SorcerySyncMessagePacket.SorcerySyncMessage onMessage(HUDToggleRequestMessage message, MessageContext ctx) {
        EntityPlayer player = SimpleSorceryMain.proxy.getPlayerEntityFromContext(ctx);
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        sorcery.toggleHUDActive();
        return new SorcerySyncMessagePacket.SorcerySyncMessage(sorcery, false);
    }

    public static class HUDToggleRequestMessage implements IMessage {
        public HUDToggleRequestMessage() {
        }

        @Override
        public void fromBytes(ByteBuf buf) {

        }

        @Override
        public void toBytes(ByteBuf buf) {

        }
    }
}
