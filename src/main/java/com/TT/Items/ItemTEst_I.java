package com.TT.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.TT.Main.MainRegistrey;

public class ItemTEst_I extends Item {
	
    private float On_off_fly = 1;
	
	public ItemTEst_I(){
		super();
		this.setCreativeTab(MainRegistrey.tabTT);
		this.setUnlocalizedName("TestItem");
	}
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return entityplayer.capabilities.allowFlying = true;
       }
	@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		entityplayer.capabilities.allowFlying = false;
		return itemstack;
		
	
    }
}
