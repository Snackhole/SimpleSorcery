package com.simplesorcery.sorcery;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SorceryProvider implements ICapabilitySerializable {
    @CapabilityInject(ISorcery.class)
    public static final Capability<ISorcery> SORCERY_CAP = null;
    private ISorcery instance = SORCERY_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == SORCERY_CAP;
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == SORCERY_CAP ? SORCERY_CAP.<T>cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return SORCERY_CAP.getStorage().writeNBT(SORCERY_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SORCERY_CAP.getStorage().readNBT(SORCERY_CAP, this.instance, null, nbt);
    }
}
