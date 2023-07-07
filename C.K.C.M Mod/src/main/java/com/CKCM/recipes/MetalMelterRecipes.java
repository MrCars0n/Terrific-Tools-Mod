package com.CKCM.recipes;
 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
 
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
 
public class MetalMelterRecipes
{
    private static final MetalMelterRecipes MetalMelteringBase = new MetalMelterRecipes();
   
    private Map MetalMelteringList = new HashMap();
    private Map experienceList = new HashMap();

	private Map smeltingList;
    private static final String __OBFID = "CL_00000085";
 
 
    public static MetalMelterRecipes Grinding()
    {
        return MetalMelteringBase;
    }
 
    private MetalMelterRecipes()
    {
          //ITEM TO ITEM
 //this.func_151396_a([modid].[input], new ItemStack([modid].[output]), 0.35F);
         //BLOCK TO ITEM
  this.MetalMelterRecipesBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
 
 
    }
 
    public void MetalMelterRecipesBlock(Block block, ItemStack itemstack, float i)
    {
        this.MetalMelterRecipesItem(Item.getItemFromBlock(block), itemstack, i);
    }
 
    public void MetalMelterRecipesItem(Item item, ItemStack itemstack, float i)
    {
        this.func_151394_a(new ItemStack(item, 1, 32767), itemstack, i);
    }
 
    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.MetalMelteringList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }
 
    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack itemstack)
    {
        Iterator iterator = this.MetalMelteringList.entrySet().iterator();
        Entry entry;
 
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
 
            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(itemstack, (ItemStack)entry.getKey()));
 
        return (ItemStack)entry.getValue();
    }
 
    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }
 
    public Map getSmeltingList()
    {
        return this.smeltingList;
    }
 
    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;
 
        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;
 
        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }
 
            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));
 
        return ((Float)entry.getValue()).floatValue();
    }
}