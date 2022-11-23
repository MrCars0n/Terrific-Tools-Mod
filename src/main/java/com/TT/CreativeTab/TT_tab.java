package com.TT.CreativeTab;

import com.TT.Main.MainRegistrey;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TT_tab extends CreativeTabs {

	public TT_tab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return MainRegistrey.explosive_bow;
	}

}