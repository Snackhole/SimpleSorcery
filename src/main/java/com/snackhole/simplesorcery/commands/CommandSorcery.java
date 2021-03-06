package com.snackhole.simplesorcery.commands;

import com.snackhole.simplesorcery.SimpleSorceryUtils;
import com.snackhole.simplesorcery.sorcery.ISorcery;
import com.snackhole.simplesorcery.sorcery.SorceryProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.List;

public class CommandSorcery extends CommandBase {
    private final List commandSorceryAliases;

    public CommandSorcery() {
        commandSorceryAliases = new ArrayList();
        commandSorceryAliases.add("sorcery");
        commandSorceryAliases.add("sorc");
        commandSorceryAliases.add("spell");
    }

    @Override
    public String getName() {
        return "sorcery";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "\"/sorcery\", \"/sorc\", or \"/spell\" displays a list of valid spell names.  Add a spell name at the end to get information about that spell, or \"slots\" to get the spells currently assigned to each slot.  Add 1, 2, or 3 after a spell name to assign that spell to a spell slot.";
    }

    @Override
    public List<String> getAliases() {
        return this.commandSorceryAliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerMP player = (EntityPlayerMP) sender.getCommandSenderEntity();
        ISorcery sorcery = player.getCapability(SorceryProvider.SORCERY_CAP, null);
        if (!validArgs(args, sorcery, player)) {
            return;
        }
        if (args.length == 0) {
            player.sendMessage(SimpleSorceryUtils.sorceryMessage(sorcery.getValidSpellNamesString()));
        } else if (args.length == 1) {
            if (args[0].equals("slots")) {
                String spellNameSlot1 = sorcery.getSlot(1);
                String spellNameSlot2 = sorcery.getSlot(2);
                String spellNameSlot3 = sorcery.getSlot(3);
                player.sendMessage(SimpleSorceryUtils.sorceryMessage("Spell Slot 1:  " + sorcery.getSpellProperName(spellNameSlot1) + ":  Level:  " + sorcery.getLevelString(spellNameSlot1) + ".  Skill:  " + sorcery.getSkill(spellNameSlot1) + "/100.  Cost/Skill Gain:  " + sorcery.getCost(spellNameSlot1) + "."));
                player.sendMessage(SimpleSorceryUtils.sorceryMessage("Spell Slot 2:  " + sorcery.getSpellProperName(spellNameSlot2) + ":  Level:  " + sorcery.getLevelString(spellNameSlot2) + ".  Skill:  " + sorcery.getSkill(spellNameSlot2) + "/100.  Cost/Skill Gain:  " + sorcery.getCost(spellNameSlot2) + "."));
                player.sendMessage(SimpleSorceryUtils.sorceryMessage("Spell Slot 3:  " + sorcery.getSpellProperName(spellNameSlot3) + ":  Level:  " + sorcery.getLevelString(spellNameSlot3) + ".  Skill:  " + sorcery.getSkill(spellNameSlot3) + "/100.  Cost/Skill Gain:  " + sorcery.getCost(spellNameSlot3) + "."));
            } else {
                player.sendMessage(SimpleSorceryUtils.sorceryMessage(sorcery.getSpellInfoString(args[0]) + "  Level:  " + sorcery.getLevelString(args[0]) + ".  Skill:  " + sorcery.getSkill(args[0]) + "/100.  Cost/Skill Gain:  " + sorcery.getCost(args[0]) + "."));
            }
        } else if (args.length == 2) {
            sorcery.setSlot(Integer.parseInt(args[1]), args[0]);
            player.sendMessage(SimpleSorceryUtils.sorceryMessage("Spell \"" + args[0] + "\" set to slot " + args[1] + "."));
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayerMP;
    }

    private boolean validArgs(String[] args, ISorcery sorcery, EntityPlayerMP player) {
        if (args.length > 2) {
            player.sendMessage(new TextComponentString("Too many arguments!"));
            return false;
        }
        if (args.length >= 1) {
            if (args[0].equals("slots")) {
                if (args.length != 1) {
                    player.sendMessage(new TextComponentString("Can't have more than one argument if the first argument is \"slots\"!"));
                    return false;
                }
            } else if (!sorcery.validSpellName(args[0])) {
                player.sendMessage(new TextComponentString("Invalid spell name!"));
                return false;
            }
        }
        if (args.length == 2) {
            int spellSlot = -1;
            try {
                spellSlot = Integer.parseInt(args[1]);
            } catch (NumberFormatException exception) {
                player.sendMessage(new TextComponentString("Slot must be an integer!"));
                return false;
            }
            if (spellSlot < 1 || spellSlot > 3) {
                player.sendMessage(new TextComponentString("Slot must be between 1 and 3!"));
                return false;
            }
        }
        return true;
    }
}
