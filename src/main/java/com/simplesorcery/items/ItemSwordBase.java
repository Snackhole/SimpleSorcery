package com.simplesorcery.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class ItemSwordBase extends ItemSword {
    private String name;

    public ItemSwordBase(Item.ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }
}
