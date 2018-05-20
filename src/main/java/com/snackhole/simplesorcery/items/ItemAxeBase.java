package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ItemAxeBase extends ItemAxe {
    private String name;

    public ItemAxeBase(Item.ToolMaterial material, String name, float damage, float speed) {
        super(material, damage, speed);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleSorceryMain.proxy.registerItemRenderer(this, 0, name);
    }
}
