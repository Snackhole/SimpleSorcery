package com.simplesorcery.items;

import net.minecraft.item.ItemHoe;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class ItemHoeBase extends ItemHoe {
    private String name;

    public ItemHoeBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }
}
