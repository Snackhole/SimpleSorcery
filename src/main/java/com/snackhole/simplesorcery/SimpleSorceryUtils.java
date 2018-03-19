package com.snackhole.simplesorcery;

import net.minecraft.util.text.TextComponentString;

public class SimpleSorceryUtils {
    public static TextComponentString sorceryMessage(String message) {
        return new TextComponentString("§6" + message);
    }

    public static int getTicksFromSeconds(int seconds) {
        return seconds * 20;
    }

    public static int getTicksFromMinutes(int minutes) {
        return getTicksFromSeconds(minutes * 60);
    }
}
