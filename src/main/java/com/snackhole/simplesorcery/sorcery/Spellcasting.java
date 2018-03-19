package com.snackhole.simplesorcery.sorcery;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import com.snackhole.simplesorcery.SimpleSorceryUtils;
import com.snackhole.simplesorcery.items.ItemStaffOfSorcery;
import com.snackhole.simplesorcery.sorcery.spells.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;

public class Spellcasting {
    public HashMap<String, ISpell> spells;

    public Spellcasting() {
        spells = new HashMap<String, ISpell>();
        spells.put("absorption", new absorption());
        spells.put("blindness", new blindness());
        spells.put("dispel", new dispel());
        spells.put("enderpocket", new enderPocket());
        spells.put("fireresistance", new fireResistance());
        spells.put("glowing", new glowing());
        spells.put("haste", new haste());
        spells.put("hunger", new hunger());
        spells.put("invisibility", new invisibility());
        spells.put("jumpboost", new jumpBoost());
        spells.put("levitation", new levitation());
        spells.put("miningfatigue", new miningFatigue());
        spells.put("nausea", new nausea());
        spells.put("nightvision", new nightVision());
        spells.put("poison", new poison());
        spells.put("regeneration", new regeneration());
        spells.put("resistance", new resistance());
        spells.put("slowness", new slowness());
        spells.put("speed", new speed());
        spells.put("strength", new strength());
        spells.put("waterbreathing", new waterBreathing());
        spells.put("weakness", new weakness());
        spells.put("wither", new wither());
    }

    public void castSpell(String spellName, boolean entityDetected, int entityID, MessageContext ctx) {
        // Get Player
        EntityPlayerMP player = (EntityPlayerMP) SimpleSorceryMain.proxy.getPlayerEntityFromContext(ctx);

        // Send Player Message for No Spell Assigned
        if (spellName.equals("")) {
            player.sendMessage(SimpleSorceryUtils.sorceryMessage("No spell assigned for that slot!"));
            return;
        }

        // Get Player Sorcery Capability
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);

        // Get Spell Skill, Level, and Base Cost
        int skill = sorcery.getSkill(spellName);
        int level = sorcery.getLevel(spellName);
        int baseCost = sorcery.getCost(spellName);

        // Compute Staff Variables
        int halfCost = (int) Math.ceil((float) baseCost / (float) 2);
        boolean staffInHands = false;
        boolean mainHandStaffCoversCost = false;
        boolean offHandStaffCoversCost = false;
        int mainHandStaffDamage = 0;
        int offHandStaffDamage = 0;
        int mainHandStaffDamageAfterHalfCost = 0;
        int offHandStaffDamageAfterHalfCost = 0;
        int staffMaxDamage = 0;

        ItemStack mainHandItemStack = player.getHeldItem(EnumHand.MAIN_HAND);
        ItemStack offHandItemStack = player.getHeldItem(EnumHand.OFF_HAND);

        Item mainHandItem = mainHandItemStack.getItem();
        Item offHandItem = offHandItemStack.getItem();

        if (mainHandItem instanceof ItemStaffOfSorcery) {
            staffInHands = true;
            mainHandStaffDamage = mainHandItemStack.getItemDamage();
            mainHandStaffDamageAfterHalfCost = mainHandStaffDamage + halfCost;
            staffMaxDamage = mainHandItemStack.getMaxDamage();
            if (mainHandStaffDamageAfterHalfCost <= staffMaxDamage - 1) {
                mainHandStaffCoversCost = true;
            }
        }
        if (offHandItem instanceof ItemStaffOfSorcery) {
            staffInHands = true;
            offHandStaffDamage = offHandItemStack.getItemDamage();
            offHandStaffDamageAfterHalfCost = offHandStaffDamage + halfCost;
            staffMaxDamage = offHandItemStack.getMaxDamage();
            if (!mainHandStaffCoversCost && offHandStaffDamageAfterHalfCost <= staffMaxDamage - 1) {
                offHandStaffCoversCost = true;
            }
        }
        if (staffInHands) {
            baseCost = halfCost;
        }

        // Get Player Food Stats and Current Food Level
        FoodStats playerFoodStats = player.getFoodStats();
        int currentPlayerFood = playerFoodStats.getFoodLevel();

        // Handle Cost
        if (mainHandStaffCoversCost) {
            mainHandItemStack.setItemDamage(player.capabilities.isCreativeMode ? mainHandStaffDamage : mainHandStaffDamageAfterHalfCost);
        } else if (offHandStaffCoversCost) {
            offHandItemStack.setItemDamage(player.capabilities.isCreativeMode ? offHandStaffDamage : offHandStaffDamageAfterHalfCost);
        } else if (baseCost <= currentPlayerFood) {
            playerFoodStats.setFoodLevel(currentPlayerFood - (player.capabilities.isCreativeMode ? 0 : baseCost));
        } else {
            player.sendMessage(SimpleSorceryUtils.sorceryMessage("You must eat more food to cast " + sorcery.getSpellProperName(spellName) + "!"));
            return;
        }

        // Cast and Update Skill
        spells.get(spellName).cast(level, player, entityDetected, entityID);
        sorcery.setSkill(spellName, Math.min(skill + baseCost, 100));
    }
}
