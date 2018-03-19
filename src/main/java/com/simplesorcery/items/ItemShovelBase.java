package com.simplesorcery.items;

import net.minecraft.item.ItemSpade;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class ItemShovelBase extends ItemSpade {
    private String name;

    public ItemShovelBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }
}
