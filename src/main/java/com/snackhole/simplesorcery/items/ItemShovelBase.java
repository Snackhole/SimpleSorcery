package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryMain;
import net.minecraft.item.ItemSpade;

public class ItemShovelBase extends ItemSpade {
    private String name;

    public ItemShovelBase(ToolMaterial material, String name) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel() {
        SimpleSorceryMain.proxy.registerItemRenderer(this, 0, name);
    }
}
