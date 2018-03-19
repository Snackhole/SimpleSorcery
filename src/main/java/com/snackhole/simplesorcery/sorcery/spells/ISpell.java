package com.snackhole.simplesorcery.sorcery.spells;

import net.minecraft.entity.player.EntityPlayerMP;

public interface ISpell {
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID);
}
