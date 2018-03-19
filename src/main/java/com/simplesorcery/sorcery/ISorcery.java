package com.simplesorcery.sorcery;

import java.util.ArrayList;

public interface ISorcery {
    int getSkill(String spellName);

    void setSkill(String spellName, int newSkill);

    String getSlot(int slot);

    void setSlot(int slot, String spellName);

    boolean validSpellName(String spellName);

    String getValidSpellNamesString();

    String getSpellInfoString(String spellName);

    int getLevel(String spellName);

    String getLevelString(String spellName);

    int getCost(String spellName);

    String getSpellProperName(String spellName);

    ArrayList<String> getSpellNamesList();
}
