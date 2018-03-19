package com.snackhole.simplesorcery.sorcery.spells;

import net.minecraft.entity.player.EntityPlayerMP;

public class dispel implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        player.clearActivePotions();
    }
}
