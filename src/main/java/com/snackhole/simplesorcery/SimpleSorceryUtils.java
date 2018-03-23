package com.snackhole.simplesorcery;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class SimpleSorceryUtils {
    private static final Style spellMessageStyle = new Style().setColor(TextFormatting.GOLD);

    public static ITextComponent sorceryMessage(String message) {
        return new TextComponentString(message).setStyle(spellMessageStyle);
    }

    public static int getTicksFromSeconds(int seconds) {
        return seconds * 20;
    }

    public static int getTicksFromMinutes(int minutes) {
        return getTicksFromSeconds(minutes * 60);
    }
}
