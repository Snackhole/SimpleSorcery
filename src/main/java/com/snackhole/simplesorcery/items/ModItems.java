package com.snackhole.simplesorcery.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase staffOfSorcery = new ItemStaffOfSorcery("staff_of_sorcery").setCreativeTab(CreativeTabs.TOOLS);
    public static ItemBase staffOfTheArchsorcerer = new ItemStaffOfTheArchsorcerer("staff_of_the_archsorcerer").setCreativeTab(CreativeTabs.TOOLS);
    public static ItemSwordBase sorcerousSword = new ItemSorcerousSword("sorcerous_sword");
    public static ItemPickaxeBase sorcerousPickaxe = new ItemSorcerousPickaxe("sorcerous_pickaxe");
    public static ItemShovelBase sorcerousShovel = new ItemSorcerousShovel("sorcerous_shovel");
    public static ItemHoeBase sorcerousHoe = new ItemSorcerousHoe("sorcerous_hoe");
    public static ItemAxeBase sorcerousAxe = new ItemSorcerousAxe("sorcerous_axe");
    public static ItemBase enchantingBook = new ItemBase("enchanting_book").setCreativeTab(CreativeTabs.MISC);
    public static ItemArmorBase sorcerousHelmet = new ItemSorcerousHelmet("sorcerous_helmet");
    public static ItemArmorBase sorcerousChestplate = new ItemSorcerousChestplate("sorcerous_chestplate");
    public static ItemArmorBase sorcerousLeggings = new ItemSorcerousLeggings("sorcerous_leggings");
    public static ItemArmorBase sorcerousBoots = new ItemSorcerousBoots("sorcerous_boots");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(staffOfSorcery, staffOfTheArchsorcerer, sorcerousSword, sorcerousPickaxe, sorcerousShovel, sorcerousHoe, sorcerousAxe, enchantingBook, sorcerousHelmet, sorcerousChestplate, sorcerousLeggings, sorcerousBoots);
    }

    public static void registerModels() {
        staffOfSorcery.registerItemModel();
        staffOfTheArchsorcerer.registerItemModel();
        sorcerousSword.registerItemModel();
        sorcerousPickaxe.registerItemModel();
        sorcerousShovel.registerItemModel();
        sorcerousHoe.registerItemModel();
        sorcerousAxe.registerItemModel();
        enchantingBook.registerItemModel();
        sorcerousHelmet.registerItemModel();
        sorcerousChestplate.registerItemModel();
        sorcerousLeggings.registerItemModel();
        sorcerousBoots.registerItemModel();
    }
}
