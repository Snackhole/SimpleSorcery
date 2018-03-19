package com.snackhole.simplesorcery;

import com.snackhole.simplesorcery.commands.CommandSorcery;
import com.snackhole.simplesorcery.gui.SorceryGuiHandler;
import com.snackhole.simplesorcery.items.ModItems;
import com.snackhole.simplesorcery.network.PacketHandler;
import com.snackhole.simplesorcery.proxy.IProxy;
import com.snackhole.simplesorcery.sorcery.*;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = SimpleSorceryMain.MODID, version = SimpleSorceryMain.VERSION)
public class SimpleSorceryMain {
    public static final String MODID = "simplesorcery";
    public static final String VERSION = "1";
    @SidedProxy(clientSide = "com.snackhole.simplesorcery.proxy.ClientProxy", serverSide = "com.snackhole.simplesorcery.proxy.ServerProxy")
    public static IProxy proxy;
    @Mod.Instance
    public static SimpleSorceryMain simpleSorceryMainInstance;
    public static Spellcasting spellcasting;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.initPackets();
        CapabilityManager.INSTANCE.register(ISorcery.class, new SorceryStorage(), Sorcery::new);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SorceryHandler());
        spellcasting = new Spellcasting();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new SorceryGuiHandler());
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandSorcery());
    }

    public SimpleSorceryMain() {
        simpleSorceryMainInstance = this;
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }

    @Mod.EventBusSubscriber
    public static class LootTableHandler {
        @SubscribeEvent
        public static void lootLoad(LootTableLoadEvent event) {
            String tableName = event.getName().toString();
            if (tableName.startsWith("minecraft:chests/") && !tableName.equals("minecraft:chests/igloo_chest") && !tableName.equals("minecraft:chests/jungle_temple_dispenser") && !tableName.equals("minecraft:chests/spawn_bonus_chest") && !tableName.equals("minecraft:chests/village_blacksmith")) {
                LootEntry entry = new LootEntryItem(ModItems.staffOfSorcery, 10, 0, new LootFunction[0], new LootCondition[0], "staff_of_sorcery");
                event.getTable().getPool("main").addEntry(entry);

            }
        }
    }

}

