package com.CKCM.CreativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TT_tab extends CreativeTabs {

	public TT_tab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Items.enchanted_book;
	}

}