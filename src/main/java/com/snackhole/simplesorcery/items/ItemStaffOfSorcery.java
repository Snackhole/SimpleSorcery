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

public class ItemStaffOfSorcery extends ItemBase {
    public ItemStaffOfSorcery(String name) {
        super(name);
        this.setMaxStackSize(1);
        this.setMaxDamage(41);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            int itemDamage = itemStack.getItemDamage();
            boolean creativeMode = playerIn.capabilities.isCreativeMode;
            if (itemDamage != 0) {
                int cost = Math.min(10, itemDamage);
                FoodStats playerFoodStats = playerIn.getFoodStats();
                int currentPlayerFood = creativeMode ? 10 : playerFoodStats.getFoodLevel();
                if (cost <= currentPlayerFood) {
                    itemStack.setItemDamage(itemDamage - cost);
                    playerFoodStats.setFoodLevel(currentPlayerFood - (creativeMode ? 0 : cost));
                } else {
                    playerIn.sendMessage(SimpleSorceryUtils.sorceryMessage("You must eat more food to charge this staff!"));
                }
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Charge:  " + (stack.getMaxDamage() - stack.getItemDamage() - 1) + "/" + (stack.getMaxDamage() - 1));
        tooltip.add("When in either hand:");
        tooltip.add(" Halves cost of spells (rounded up).");
        tooltip.add(" Stores magic power to cast spells with.");
        tooltip.add(" Right-click to charge with magic power.");
    }
}
