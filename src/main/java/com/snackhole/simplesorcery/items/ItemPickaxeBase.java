package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe {
    private String name;

    public ItemPickaxeBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleSorceryMain.proxy.registerItemRenderer(this, 0, name);
    }
}
