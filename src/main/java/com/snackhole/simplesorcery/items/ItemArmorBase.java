package com.snackhole.simplesorcery.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

import static com.snackhole.simplesorcery.SimpleSorceryMain.proxy;

public class ItemArmorBase extends ItemArmor {
    private String name;

    public ItemArmorBase(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel() {
        proxy.registerItemRenderer(this, 0, name);
    }
}
