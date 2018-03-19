package com.simplesorcery.sorcery.spells;

import com.simplesorcery.SimpleSorceryUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class poison implements ISpell {
    @Override
    public void cast(int level, EntityPlayerMP player, boolean entityDetected, int entityID) {
        if (entityDetected) {
            Entity target = player.getServerWorld().getEntityByID(entityID);
            if (target.isEntityAlive()) {
                EntityLivingBase targetLiving = (EntityLivingBase) target;
                if (level == 3) {
                    level = 5;
                }
                targetLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(19), SimpleSorceryUtils.getTicksFromSeconds(10 * level), level - 1));
                targetLiving.attackEntityFrom(DamageSource.causePlayerDamage(player), (float) 0);
            }
        } else {
            player.sendMessage(SimpleSorceryUtils.sorceryMessage("No target within range."));
        }
    }
}
