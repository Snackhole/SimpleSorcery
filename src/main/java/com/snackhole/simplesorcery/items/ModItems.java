package com.snackhole.simplesorcery.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase staffOfSorcery = new ItemStaffOfSorcery("staff_of_sorcery").setCreativeTab(CreativeTabs.TOOLS);
    public static ItemSwordBase sorcerousSword = new ItemSorcerousSword("sorcerous_sword");
    public static ItemPickaxeBase sorcerousPickaxe = new ItemSorcerousPickaxe("sorcerous_pickaxe");
    public static ItemShovelBase sorcerousShovel = new ItemSorcerousShovel("sorcerous_shovel");
    public static ItemHoeBase sorcerousHoe = new ItemSorcerousHoe("sorcerous_hoe");
    public static ItemAxeBase sorcerousAxe = new ItemSorcerousAxe("sorcerous_axe");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(staffOfSorcery, sorcerousSword, sorcerousPickaxe, sorcerousShovel, sorcerousHoe, sorcerousAxe);
    }

    public static void registerModels() {
        staffOfSorcery.registerItemModel();
        sorcerousSword.registerItemModel();
        sorcerousPickaxe.registerItemModel();
        sorcerousShovel.registerItemModel();
        sorcerousHoe.registerItemModel();
        sorcerousAxe.registerItemModel();
    }
}
