package com.TT.bow;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.TT.Main.MainRegistrey;

public class itemExplosiveArrow extends Item {
	
	public itemExplosiveArrow(){
		super();
		this.setCreativeTab(MainRegistrey.tabTT);
		this.setUnlocalizedName("itemExplosiveArrow");
	}
}
