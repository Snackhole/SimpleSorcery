package com.snackhole.simplesorcery.sorcery.spells;

import com.snackhole.simplesorcery.SimpleSorceryUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class resistance implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), SimpleSorceryUtils.getTicksFromMinutes(level), level - 1));
    }
}
