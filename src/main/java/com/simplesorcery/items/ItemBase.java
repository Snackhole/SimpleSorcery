package com.simplesorcery.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.simplesorcery.SimpleSorceryMain.proxy;

public class ItemBase extends Item {
    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
