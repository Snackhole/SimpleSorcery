package com.snackhole.simplesorcery.sorcery;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class SorceryStorage implements Capability.IStorage<ISorcery> {
    @Override
    public NBTBase writeNBT(Capability<ISorcery> capability, ISorcery instance, EnumFacing side) {
        NBTTagCompound sorceryNBT = new NBTTagCompound();
        sorceryNBT.setInteger("absorptionSkill", instance.getSkill("absorption"));
        sorceryNBT.setInteger("blindnessSkill", instance.getSkill("blindness"));
        sorceryNBT.setInteger("dispelSkill", instance.getSkill("dispel"));
        sorceryNBT.setInteger("enderPocketSkill", instance.getSkill("enderpocket"));
        sorceryNBT.setInteger("fireResistanceSkill", instance.getSkill("fireresistance"));
        sorceryNBT.setInteger("glowingSkill", instance.getSkill("glowing"));
        sorceryNBT.setInteger("hasteSkill", instance.getSkill("haste"));
        sorceryNBT.setInteger("hungerSkill", instance.getSkill("hunger"));
        sorceryNBT.setInteger("invisibilitySkill", instance.getSkill("invisibility"));
        sorceryNBT.setInteger("jumpBoostSkill", instance.getSkill("jumpboost"));
        sorceryNBT.setInteger("levitationSkill", instance.getSkill("levitation"));
        sorceryNBT.setInteger("miningFatigueSkill", instance.getSkill("miningfatigue"));
        sorceryNBT.setInteger("nauseaSkill", instance.getSkill("nausea"));
        sorceryNBT.setInteger("nightVisionSkill", instance.getSkill("nightvision"));
        sorceryNBT.setInteger("poisonSkill", instance.getSkill("poison"));
        sorceryNBT.setInteger("regenerationSkill", instance.getSkill("regeneration"));
        sorceryNBT.setInteger("resistanceSkill", instance.getSkill("resistance"));
        sorceryNBT.setInteger("slownessSkill", instance.getSkill("slowness"));
        sorceryNBT.setInteger("speedSkill", instance.getSkill("speed"));
        sorceryNBT.setInteger("strengthSkill", instance.getSkill("strength"));
        sorceryNBT.setInteger("waterBreathingSkill", instance.getSkill("waterbreathing"));
        sorceryNBT.setInteger("weaknessSkill", instance.getSkill("weakness"));
        sorceryNBT.setInteger("witherSkill", instance.getSkill("wither"));
        sorceryNBT.setString("spellSlot1", instance.getSlot(1));
        sorceryNBT.setString("spellSlot2", instance.getSlot(2));
        sorceryNBT.setString("spellSlot3", instance.getSlot(3));
        return sorceryNBT;
    }

    @Override
    public void readNBT(Capability<ISorcery> capability, ISorcery instance, EnumFacing side, NBTBase nbt) {
        instance.setSkill("absorption", ((NBTTagCompound) nbt).getInteger("absorptionSkill"));
        instance.setSkill("blindness", ((NBTTagCompound) nbt).getInteger("blindnessSkill"));
        instance.setSkill("dispel", ((NBTTagCompound) nbt).getInteger("dispelSkill"));
        instance.setSkill("enderpocket", ((NBTTagCompound) nbt).getInteger("enderPocketSkill"));
        instance.setSkill("fireresistance", ((NBTTagCompound) nbt).getInteger("fireResistanceSkill"));
        instance.setSkill("glowing", ((NBTTagCompound) nbt).getInteger("glowingSkill"));
        instance.setSkill("haste", ((NBTTagCompound) nbt).getInteger("hasteSkill"));
        instance.setSkill("hunger", ((NBTTagCompound) nbt).getInteger("hungerSkill"));
        instance.setSkill("invisibility", ((NBTTagCompound) nbt).getInteger("invisibilitySkill"));
        instance.setSkill("jumpboost", ((NBTTagCompound) nbt).getInteger("jumpBoostSkill"));
        instance.setSkill("levitation", ((NBTTagCompound) nbt).getInteger("levitationSkill"));
        instance.setSkill("miningfatigue", ((NBTTagCompound) nbt).getInteger("miningFatigueSkill"));
        instance.setSkill("nausea", ((NBTTagCompound) nbt).getInteger("nauseaSkill"));
        instance.setSkill("nightvision", ((NBTTagCompound) nbt).getInteger("nightVisionSkill"));
        instance.setSkill("poison", ((NBTTagCompound) nbt).getInteger("poisonSkill"));
        instance.setSkill("regeneration", ((NBTTagCompound) nbt).getInteger("regenerationSkill"));
        instance.setSkill("resistance", ((NBTTagCompound) nbt).getInteger("resistanceSkill"));
        instance.setSkill("slowness", ((NBTTagCompound) nbt).getInteger("slownessSkill"));
        instance.setSkill("speed", ((NBTTagCompound) nbt).getInteger("speedSkill"));
        instance.setSkill("strength", ((NBTTagCompound) nbt).getInteger("strengthSkill"));
        instance.setSkill("waterbreathing", ((NBTTagCompound) nbt).getInteger("waterBreathingSkill"));
        instance.setSkill("weakness", ((NBTTagCompound) nbt).getInteger("weaknessSkill"));
        instance.setSkill("wither", ((NBTTagCompound) nbt).getInteger("witherSkill"));
        instance.setSlot(1, ((NBTTagCompound) nbt).getString("spellSlot1"));
        instance.setSlot(2, ((NBTTagCompound) nbt).getString("spellSlot2"));
        instance.setSlot(3, ((NBTTagCompound) nbt).getString("spellSlot3"));
    }
}
