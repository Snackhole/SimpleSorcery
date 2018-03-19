package com.snackhole.simplesorcery.items;

import com.snackhole.simplesorcery.SimpleSorceryUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSorcerousShovel extends ItemShovelBase {
    public ItemSorcerousShovel(String name) {
        super(ToolMaterial.IRON, name);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            int itemDamage = itemStack.getItemDamage();
            boolean creativeMode = playerIn.capabilities.isCreativeMode;
            if (itemDamage != 0) {
                int cost = (int) Math.min(10, Math.ceil((double) itemDamage / (double) 7));
                FoodStats playerFoodStats = playerIn.getFoodStats();
                int currentPlayerFood = creativeMode ? 10 : playerFoodStats.getFoodLevel();
                if (cost <= currentPlayerFood) {
                    itemStack.setItemDamage(itemDamage - (cost * 7));
                    playerFoodStats.setFoodLevel((currentPlayerFood - (creativeMode ? 0 : cost)));
                } else {
                    playerIn.sendMessage(SimpleSorceryUtils.sorceryMessage("You must eat more food to repair this pickaxe!"));
                }
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("When in either hand:");
        tooltip.add(" Right-click to repair with magic power.");
    }
}
