package com.snackhole.simplesorcery.network;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SlotSetPacket implements IMessageHandler<SlotSetPacket.SlotSetMessage, IMessage> {
    @Override
    public IMessage onMessage(SlotSetMessage message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = (EntityPlayerMP) SimpleSorceryMain.proxy.getPlayerEntityFromContext(ctx);
        serverPlayer.getServerWorld().addScheduledTask(() -> {
            ISorcery sorcery = serverPlayer.getCapability(SorceryProvider.SORCERY_CAP, null);
            sorcery.setSlot(message.spellSlot, message.spellName);
        });

        return null;
    }

    public static class SlotSetMessage implements IMessage {
        private int spellSlot;
        private String spellName;

        public SlotSetMessage() {
        }

        public SlotSetMessage(int spellSlot, String spellName) {
            this.spellSlot = spellSlot;
            this.spellName = spellName;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            this.spellSlot = buf.readInt();
            this.spellName = ByteBufUtils.readUTF8String(buf);
        }

        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeInt(this.spellSlot);
            ByteBufUtils.writeUTF8String(buf, this.spellName);
        }
    }


}
