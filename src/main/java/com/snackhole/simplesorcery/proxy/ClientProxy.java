package com.snackhole.simplesorcery.proxy;


import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.lwjgl.input.Keyboard;

public class ClientProxy implements IProxy {
    public static KeyBinding[] keyBindings;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void init(FMLInitializationEvent event) {
        keyBindings = new KeyBinding[4];
        keyBindings[0] = new KeyBinding("key.spell1.desc", Keyboard.KEY_V, "key.simplesorcery.category");
        keyBindings[1] = new KeyBinding("key.spell2.desc", Keyboard.KEY_B, "key.simplesorcery.category");
        keyBindings[2] = new KeyBinding("key.spell3.desc", Keyboard.KEY_N, "key.simplesorcery.category");
        keyBindings[3] = new KeyBinding("key.spellmod.desc", Keyboard.KEY_G, "key.simplesorcery.category");
        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void serverStarting(FMLServerStartingEvent event) {

    }

    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext parContext) {
        return (parContext.side.isClient() ? Minecraft.getMinecraft().player : parContext.getServerHandler().player);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(SimpleSorceryMain.MODID + ":" + id, "inventory"));
    }
}
