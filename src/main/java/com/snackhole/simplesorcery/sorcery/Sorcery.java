package com.snackhole.simplesorcery.sorcery;

import java.util.ArrayList;
import java.util.HashMap;

public class Sorcery implements ISorcery {
    private HashMap<String, Integer> spellSkills = new HashMap<String, Integer>();
    private HashMap<Integer, String> spellSlots = new HashMap<Integer, String>();
    private HashMap<String, String> spellProperNames = new HashMap<String, String>();
    private HashMap<String, String> spellDescriptions = new HashMap<String, String>();
    private ArrayList<String> spellNames = new ArrayList<String>();
    private int absorptionSkill;
    private int blindnessSkill;
    private int dispelSkill;
    private int enderPocketSkill;
    private int fireResistanceSkill;
    private int glowingSkill;
    private int hasteSkill;
    private int hungerSkill;
    private int invisibilitySkill;
    private int jumpBoostSkill;
    private int levitationSkill;
    private int miningFatigueSkill;
    private int nauseaSkill;
    private int nightVisionSkill;
    private int poisonSkill;
    private int regenerationSkill;
    private int resistanceSkill;
    private int slownessSkill;
    private int speedSkill;
    private int strengthSkill;
    private int waterBreathingSkill;
    private int weaknessSkill;
    private int witherSkill;
    private String spellSlot1;
    private String spellSlot2;
    private String spellSlot3;
    private boolean hudActive;

    public Sorcery() {
        // Initialize Variables
        absorptionSkill = 0;
        blindnessSkill = 0;
        dispelSkill = 0;
        enderPocketSkill = 0;
        fireResistanceSkill = 0;
        glowingSkill = 0;
        hasteSkill = 0;
        hungerSkill = 0;
        invisibilitySkill = 0;
        jumpBoostSkill = 0;
        levitationSkill = 0;
        miningFatigueSkill = 0;
        nauseaSkill = 0;
        nightVisionSkill = 0;
        poisonSkill = 0;
        regenerationSkill = 0;
        resistanceSkill = 0;
        slownessSkill = 0;
        speedSkill = 0;
        strengthSkill = 0;
        waterBreathingSkill = 0;
        weaknessSkill = 0;
        witherSkill = 0;
        spellSlot1 = "";
        spellSlot2 = "";
        spellSlot3 = "";
        hudActive = true;

        // Construct List of Spell Names
        spellNames.add("absorption");
        spellNames.add("blindness");
        spellNames.add("dispel");
        spellNames.add("enderpocket");
        spellNames.add("fireresistance");
        spellNames.add("glowing");
        spellNames.add("haste");
        spellNames.add("hunger");
        spellNames.add("invisibility");
        spellNames.add("jumpboost");
        spellNames.add("levitation");
        spellNames.add("miningfatigue");
        spellNames.add("nausea");
        spellNames.add("nightvision");
        spellNames.add("poison");
        spellNames.add("regeneration");
        spellNames.add("resistance");
        spellNames.add("slowness");
        spellNames.add("speed");
        spellNames.add("strength");
        spellNames.add("waterbreathing");
        spellNames.add("weakness");
        spellNames.add("wither");

        // Map Spell Names to Skills
        spellSkills.put("", 0);
        spellSkills.put("absorption", absorptionSkill);
        spellSkills.put("blindness", blindnessSkill);
        spellSkills.put("dispel", dispelSkill);
        spellSkills.put("enderpocket", enderPocketSkill);
        spellSkills.put("fireresistance", fireResistanceSkill);
        spellSkills.put("glowing", glowingSkill);
        spellSkills.put("haste", hasteSkill);
        spellSkills.put("hunger", hungerSkill);
        spellSkills.put("invisibility", invisibilitySkill);
        spellSkills.put("jumpboost", jumpBoostSkill);
        spellSkills.put("levitation", levitationSkill);
        spellSkills.put("miningfatigue", miningFatigueSkill);
        spellSkills.put("nausea", nauseaSkill);
        spellSkills.put("nightvision", nightVisionSkill);
        spellSkills.put("poison", poisonSkill);
        spellSkills.put("regeneration", regenerationSkill);
        spellSkills.put("resistance", resistanceSkill);
        spellSkills.put("slowness", slownessSkill);
        spellSkills.put("speed", speedSkill);
        spellSkills.put("strength", strengthSkill);
        spellSkills.put("waterbreathing", waterBreathingSkill);
        spellSkills.put("weakness", weaknessSkill);
        spellSkills.put("wither", witherSkill);

        // Map Spell Slots to Selected Spell Names
        spellSlots.put(1, this.spellSlot1);
        spellSlots.put(2, this.spellSlot2);
        spellSlots.put(3, this.spellSlot3);

        // Map Spell Names to Proper Names
        spellProperNames.put("", "None");
        spellProperNames.put("absorption", "Absorption");
        spellProperNames.put("blindness", "Blindness");
        spellProperNames.put("dispel", "Dispel");
        spellProperNames.put("enderpocket", "Ender Pocket");
        spellProperNames.put("fireresistance", "Fire Resistance");
        spellProperNames.put("glowing", "Glowing");
        spellProperNames.put("haste", "Haste");
        spellProperNames.put("hunger", "Hunger");
        spellProperNames.put("invisibility", "Invisibility");
        spellProperNames.put("jumpboost", "Jump Boost");
        spellProperNames.put("levitation", "Levitation");
        spellProperNames.put("miningfatigue", "Mining Fatigue");
        spellProperNames.put("nausea", "Nausea");
        spellProperNames.put("nightvision", "Night Vision");
        spellProperNames.put("poison", "Poison");
        spellProperNames.put("regeneration", "Regeneration");
        spellProperNames.put("resistance", "Resistance");
        spellProperNames.put("slowness", "Slowness");
        spellProperNames.put("speed", "Speed");
        spellProperNames.put("strength", "Strength");
        spellProperNames.put("waterbreathing", "Water Breathing");
        spellProperNames.put("weakness", "Weakness");
        spellProperNames.put("wither", "Wither");

        // Map Spell Names to Descriptions
        spellDescriptions.put("", "");
        spellDescriptions.put("absorption", spellProperNames.get("absorption") + ":  Adds damage absorption to the caster.  5 minutes and 4 health per level.");
        spellDescriptions.put("blindness", spellProperNames.get("blindness") + ":  Blinds a target within about 3 blocks.  5 seconds per level.");
        spellDescriptions.put("dispel", spellProperNames.get("dispel") + ":  Dispels status effects on the caster.");
        spellDescriptions.put("enderpocket", spellProperNames.get("enderpocket") + ":  Opens the caster's ender chest inventory.");
        spellDescriptions.put("fireresistance", spellProperNames.get("fireresistance") + ":  Caster gains immunity to fire, lava, etc.  1 minute per level.");
        spellDescriptions.put("glowing", spellProperNames.get("glowing") + ":  Causes entities within about 30 blocks of caster to glow, visible through blocks.  5 seconds per level.");
        spellDescriptions.put("haste", spellProperNames.get("haste") + ":  Increases mining and attack speed of caster.  20% and 10% per level, respectively.  5 minutes per level.");
        spellDescriptions.put("hunger", spellProperNames.get("hunger") + ":  Induces hunger in a target within about 3 blocks.  10 seconds per level.");
        spellDescriptions.put("invisibility", spellProperNames.get("invisibility") + ":  Grants invisibility to the caster.  1 minute per level.");
        spellDescriptions.put("jumpboost", spellProperNames.get("jumpboost") + ":  Increases jump height and reduces fall damage for the caster.  5 minutes and about 1 block of height per level.");
        spellDescriptions.put("levitation", spellProperNames.get("levitation") + ":  Caster floats upwards about 1 block per second.  5 seconds per level.  Negates falling distance every cast.");
        spellDescriptions.put("miningfatigue", spellProperNames.get("miningfatigue") + ":  Decreases mining and attack speed of a target within about 3 blocks.  70/91/99% and 10% per level, respectively.  5 minutes per level.");
        spellDescriptions.put("nausea", spellProperNames.get("nausea") + ":  Induces nausea in a target within about 3 blocks.  5 seconds per level.");
        spellDescriptions.put("nightvision", spellProperNames.get("nightvision") + ":  Negates darkness for the caster.  5 minutes per level.");
        spellDescriptions.put("poison", spellProperNames.get("poison") + ":  Poisons a target within about 3 blocks, non-fatally.  10 seconds per level; 0.8/1.6/2 damage per second per level, respectively.");
        spellDescriptions.put("regeneration", spellProperNames.get("regeneration") + ":  Regenerates caster's health over time.  30 seconds per level; 0.4/0.8/1.6 health per second per level, respectively.");
        spellDescriptions.put("resistance", spellProperNames.get("resistance") + ":  Reduces most damage to the caster.  1 minute and 20% less damage per level.");
        spellDescriptions.put("slowness", spellProperNames.get("slowness") + ":  Reduces the walking and sprinting speeds of a target within about 3 blocks.  5 minutes and 15% per level.");
        spellDescriptions.put("speed", spellProperNames.get("speed") + ":  Increases caster's walking and sprinting speeds.  5 minutes and 20% per level.");
        spellDescriptions.put("strength", spellProperNames.get("strength") + ":  Increases caster's melee damage.  1 minute and 3 damage per level.");
        spellDescriptions.put("waterbreathing", spellProperNames.get("waterbreathing") + ":  Prevents caster from drowning.  5 minutes per level.");
        spellDescriptions.put("weakness", spellProperNames.get("weakness") + ":  Decreases the melee damage of a target within about 3 blocks.  1 minute and 4 damage per level.");
        spellDescriptions.put("wither", spellProperNames.get("wither") + ":  Withers a target within about 3 blocks.  5 seconds per level; 0.5/1/2 damage per second per level.");
    }

    @Override
    public int getSkill(String spellName) {
        return spellSkills.get(spellName);
    }

    @Override
    public void setSkill(String spellName, int newSkill) {
        spellSkills.put(spellName, newSkill);
    }

    @Override
    public String getSlot(int slot) {
        return spellSlots.get(slot);
    }

    @Override
    public void setSlot(int slot, String spellName) {
        spellSlots.put(slot, spellName);
    }

    @Override
    public boolean validSpellName(String spellName) {
        return spellSkills.containsKey(spellName);
    }

    @Override
    public String getValidSpellNamesString() {
        String validSpellNames = "Valid spell names:  ";
        int spellNamesSize = spellNames.size();
        for (int i = 0; i < spellNamesSize; ++i) {
            validSpellNames += spellNames.get(i);
            if (i == spellNamesSize - 1) {
                validSpellNames += ".";
            } else {
                validSpellNames += ", ";
            }
        }
        return validSpellNames;
    }

    @Override
    public String getSpellInfoString(String spellName) {
        return spellDescriptions.get(spellName);
    }

    @Override
    public int getLevel(String spellName) {
        int skill = this.getSkill(spellName);
        int level = 1;
        if (skill > 49) {
            level++;
        }
        if (skill > 99) {
            level++;
        }
        return level;
    }

    @Override
    public String getLevelString(String spellName) {
        String levelString = "";
        int level = this.getLevel(spellName);
        for (int i = 1; i <= level; i++) {
            levelString += "I";
        }
        return levelString;
    }

    @Override
    public int getCost(String spellName) {
        return (int) Math.ceil(((double) 1000 - ((double) 7 * (double) this.getSkill(spellName))) / (double) 100);
    }

    @Override
    public String getSpellProperName(String spellName) {
        return spellProperNames.get(spellName);
    }

    @Override
    public ArrayList<String> getSpellNamesList() {
        return spellNames;
    }

    @Override
    public boolean getHUDActive() {
        return hudActive;
    }

    @Override
    public void setHUDActive(boolean isHUDActive) {
        hudActive = isHUDActive;
    }

    @Override
    public void toggleHUDActive() {
        hudActive = !hudActive;
    }
}
