package com.snackhole.simplesorcery.sorcery.spells;

import com.snackhole.simplesorcery.SimpleSorceryUtils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class regeneration implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), SimpleSorceryUtils.getTicksFromSeconds(30 * level), level - 1));
    }
}
