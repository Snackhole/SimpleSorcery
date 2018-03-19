package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {
    private String name;

    public ItemSwordBase(Item.ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleSorceryMain.proxy.registerItemRenderer(this, 0, name);
    }
}
