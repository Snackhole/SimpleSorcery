package com.simplesorcery.items;

import net.minecraft.item.ItemPickaxe;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class ItemPickaxeBase extends ItemPickaxe {
    private String name;

    public ItemPickaxeBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }
}
