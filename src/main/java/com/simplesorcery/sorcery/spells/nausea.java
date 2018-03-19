package com.simplesorcery.sorcery.spells;

import com.simplesorcery.SimpleSorceryUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class nausea implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        if (entityDetected) {
            Entity target = player.getServerWorld().getEntityByID(entityID);
            if (target.isEntityAlive()) {
                EntityLivingBase targetLiving = (EntityLivingBase) target;
                targetLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(9), SimpleSorceryUtils.getTicksFromSeconds(5 * level)));
                targetLiving.attackEntityFrom(DamageSource.causePlayerDamage(player), (float) 0);
            }
        } else {
            player.sendMessage(SimpleSorceryUtils.sorceryMessage("No target within range."));
        }
    }
}
