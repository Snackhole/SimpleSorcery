package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.item.ItemHoe;

public class ItemHoeBase extends ItemHoe {
    private String name;

    public ItemHoeBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleSorceryMain.proxy.registerItemRenderer(this, 0, name);
    }
}
