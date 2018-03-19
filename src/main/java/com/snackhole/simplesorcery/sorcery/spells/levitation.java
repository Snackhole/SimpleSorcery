package com.snackhole.simplesorcery.sorcery.spells;

import com.snackhole.simplesorcery.SimpleSorceryUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class levitation implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(25), SimpleSorceryUtils.getTicksFromSeconds(5 * level)));
        player.fallDistance = (float) 0;
    }
}
