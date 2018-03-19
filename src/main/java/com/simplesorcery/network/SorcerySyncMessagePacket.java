package com.simplesorcery.network;

import com.simplesorcery.sorcery.ISorcery;
import com.simplesorcery.sorcery.SorceryProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static com.simplesorcery.SimpleSorceryMain.proxy;
import static com.simplesorcery.SimpleSorceryMain.simpleSorceryMainInstance;

public class SorcerySyncMessagePacket implements IMessageHandler<SorcerySyncMessagePacket.SorcerySyncMessage, IMessage> {
    public static final int guiID = 0;

    @Override
    public IMessage onMessage(SorcerySyncMessage message, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(() -> {
            EntityPlayer player = proxy.getPlayerEntityFromContext(ctx);
            ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
            sorcery.setSkill("absorption", message.absorptionSkill);
            sorcery.setSkill("blindness", message.blindnessSkill);
            sorcery.setSkill("dispel", message.dispelSkill);
            sorcery.setSkill("enderpocket", message.enderPocketSkill);
            sorcery.setSkill("fireresistance", message.fireResistanceSkill);
            sorcery.setSkill("glowing", message.glowingSkill);
            sorcery.setSkill("haste", message.hasteSkill);
            sorcery.setSkill("hunger", message.hungerSkill);
            sorcery.setSkill("invisibility", message.invisibilitySkill);
            sorcery.setSkill("jumpboost", message.jumpBoostSkill);
            sorcery.setSkill("levitation", message.levitationSkill);
            sorcery.setSkill("miningfatigue", message.miningFatigueSkill);
            sorcery.setSkill("nausea", message.nauseaSkill);
            sorcery.setSkill("nightvision", message.nightVisionSkill);
            sorcery.setSkill("poison", message.poisonSkill);
            sorcery.setSkill("regeneration", message.regenerationSkill);
            sorcery.setSkill("resistance", message.resistanceSkill);
            sorcery.setSkill("slowness", message.slownessSkill);
            sorcery.setSkill("speed", message.speedSkill);
            sorcery.setSkill("strength", message.strengthSkill);
            sorcery.setSkill("waterbreathing", message.waterBreathingSkill);
            sorcery.setSkill("weakness", message.weaknessSkill);
            sorcery.setSkill("wither", message.witherSkill);
            sorcery.setSlot(1, message.spellSlot1);
            sorcery.setSlot(2, message.spellSlot2);
            sorcery.setSlot(3, message.spellSlot3);
            BlockPos playerPos = player.getPosition();
            player.openGui(simpleSorceryMainInstance, guiID, player.getEntityWorld(), playerPos.getX(), playerPos.getY(), playerPos.getZ());
        });
        return null;
    }

    public static class SorcerySyncMessage implements IMessage {
        private int absorptionSkill;
        private int blindnessSkill;
        private int dispelSkill;
        private int enderPocketSkill;
        private int fireResistanceSkill;
        private int glowingSkill;
        private int hasteSkill;
        private int hungerSkill;
        private int invisibilitySkill;
        private int jumpBoostSkill;
        private int levitationSkill;
        private int miningFatigueSkill;
        private int nauseaSkill;
        private int nightVisionSkill;
        private int poisonSkill;
        private int regenerationSkill;
        private int resistanceSkill;
        private int slownessSkill;
        private int speedSkill;
        private int strengthSkill;
        private int waterBreathingSkill;
        private int weaknessSkill;
        private int witherSkill;
        private String spellSlot1;
        private String spellSlot2;
        private String spellSlot3;

        public SorcerySyncMessage() {
        }

        public SorcerySyncMessage(ISorcery sorcery) {
            this.absorptionSkill = sorcery.getSkill("absorption");
            this.blindnessSkill = sorcery.getSkill("blindness");
            this.dispelSkill = sorcery.getSkill("dispel");
            this.enderPocketSkill = sorcery.getSkill("enderpocket");
            this.fireResistanceSkill = sorcery.getSkill("fireresistance");
            this.glowingSkill = sorcery.getSkill("glowing");
            this.hasteSkill = sorcery.getSkill("haste");
            this.hungerSkill = sorcery.getSkill("hunger");
            this.invisibilitySkill = sorcery.getSkill("invisibility");
            this.jumpBoostSkill = sorcery.getSkill("jumpboost");
            this.levitationSkill = sorcery.getSkill("levitation");
            this.miningFatigueSkill = sorcery.getSkill("miningfatigue");
            this.nauseaSkill = sorcery.getSkill("nausea");
            this.nightVisionSkill = sorcery.getSkill("nightvision");
            this.poisonSkill = sorcery.getSkill("poison");
            this.regenerationSkill = sorcery.getSkill("regeneration");
            this.resistanceSkill = sorcery.getSkill("resistance");
            this.slownessSkill = sorcery.getSkill("slowness");
            this.speedSkill = sorcery.getSkill("speed");
            this.strengthSkill = sorcery.getSkill("strength");
            this.waterBreathingSkill = sorcery.getSkill("waterbreathing");
            this.weaknessSkill = sorcery.getSkill("weakness");
            this.witherSkill = sorcery.getSkill("wither");
            this.spellSlot1 = sorcery.getSlot(1);
            this.spellSlot2 = sorcery.getSlot(2);
            this.spellSlot3 = sorcery.getSlot(3);
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            this.absorptionSkill = buf.readInt();
            this.blindnessSkill = buf.readInt();
            this.dispelSkill = buf.readInt();
            this.enderPocketSkill = buf.readInt();
            this.fireResistanceSkill = buf.readInt();
            this.glowingSkill = buf.readInt();
            this.hasteSkill = buf.readInt();
            this.hungerSkill = buf.readInt();
            this.invisibilitySkill = buf.readInt();
            this.jumpBoostSkill = buf.readInt();
            this.levitationSkill = buf.readInt();
            this.miningFatigueSkill = buf.readInt();
            this.nauseaSkill = buf.readInt();
            this.nightVisionSkill = buf.readInt();
            this.poisonSkill = buf.readInt();
            this.regenerationSkill = buf.readInt();
            this.resistanceSkill = buf.readInt();
            this.slownessSkill = buf.readInt();
            this.speedSkill = buf.readInt();
            this.strengthSkill = buf.readInt();
            this.waterBreathingSkill = buf.readInt();
            this.weaknessSkill = buf.readInt();
            this.witherSkill = buf.readInt();
            this.spellSlot1 = ByteBufUtils.readUTF8String(buf);
            this.spellSlot2 = ByteBufUtils.readUTF8String(buf);
            this.spellSlot3 = ByteBufUtils.readUTF8String(buf);
        }

        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeInt(this.absorptionSkill);
            buf.writeInt(this.blindnessSkill);
            buf.writeInt(this.dispelSkill);
            buf.writeInt(this.enderPocketSkill);
            buf.writeInt(this.fireResistanceSkill);
            buf.writeInt(this.glowingSkill);
            buf.writeInt(this.hasteSkill);
            buf.writeInt(this.hungerSkill);
            buf.writeInt(this.invisibilitySkill);
            buf.writeInt(this.jumpBoostSkill);
            buf.writeInt(this.levitationSkill);
            buf.writeInt(this.miningFatigueSkill);
            buf.writeInt(this.nauseaSkill);
            buf.writeInt(this.nightVisionSkill);
            buf.writeInt(this.poisonSkill);
            buf.writeInt(this.regenerationSkill);
            buf.writeInt(this.resistanceSkill);
            buf.writeInt(this.slownessSkill);
            buf.writeInt(this.speedSkill);
            buf.writeInt(this.strengthSkill);
            buf.writeInt(this.waterBreathingSkill);
            buf.writeInt(this.weaknessSkill);
            buf.writeInt(this.witherSkill);
            ByteBufUtils.writeUTF8String(buf, this.spellSlot1);
            ByteBufUtils.writeUTF8String(buf, this.spellSlot2);
            ByteBufUtils.writeUTF8String(buf, this.spellSlot3);
        }
    }


}
