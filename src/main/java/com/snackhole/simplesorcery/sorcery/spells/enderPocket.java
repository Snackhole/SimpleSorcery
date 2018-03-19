package com.snackhole.simplesorcery.sorcery.spells;

import net.minecraft.entity.player.EntityPlayerMP;

public class enderPocket implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        player.displayGUIChest(player.getInventoryEnderChest());
    }
}
