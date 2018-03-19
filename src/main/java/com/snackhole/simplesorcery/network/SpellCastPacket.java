package com.snackhole.simplesorcery.network;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SpellCastPacket implements IMessageHandler<SpellCastPacket.SpellCastMessage, IMessage> {
    @Override
    public IMessage onMessage(SpellCastMessage message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = (EntityPlayerMP) SimpleSorceryMain.proxy.getPlayerEntityFromContext(ctx);
        serverPlayer.getServerWorld().addScheduledTask(() -> {
            ISorcery sorcery = serverPlayer.getCapability(SorceryProvider.SORCERY_CAP, null);
            String spellCast = sorcery.getSlot(message.spellSlot);
//            spellcasting.castSpell(spellCast, ctx);
            SimpleSorceryMain.spellcasting.castSpell(spellCast, message.entityDetected, message.entityID, ctx);
        });
        return null;
    }

    public static class SpellCastMessage implements IMessage {
        private int spellSlot;
        private boolean entityDetected;
        private int entityID;

        public SpellCastMessage() {
        }

//        public SpellCastMessage(int spellSlot) {
//            this.spellSlot = spellSlot;
//        }

        public SpellCastMessage(int spellSlot, boolean entityDetected, int entityID) {
            this.spellSlot = spellSlot;
            this.entityDetected = entityDetected;
            this.entityID = entityID;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            this.spellSlot = buf.readInt();
            this.entityDetected = buf.readBoolean();
            this.entityID = buf.readInt();
        }

        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeInt(this.spellSlot);
            buf.writeBoolean(this.entityDetected);
            buf.writeInt(this.entityID);
        }
    }


}
