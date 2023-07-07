package com.CKCM.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.CKCM.Main.MainRegistrey;

public class ItemTEst_I extends Item {
	
    private float On_off_fly = 1;
	
	public ItemTEst_I(){
		super();
		this.setCreativeTab(MainRegistrey.tabTT);
		this.setUnlocalizedName("TestItem");
	}
			@Override
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
			entityplayer.capabilities.allowFlying = false;
			On_off_fly = 2;
			return itemstack;
			
		
}
}
