package com.CKCM.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.CKCM.Main.MainRegistrey;
import com.CKCM.container.ContainerMetalMelter;
import com.CKCM.gui.GuiMetalMelter;
import com.CKCM.tileEntity.TileEntityMetalMelter;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case MainRegistrey.guiIDMetalMeter:
				if(entity instanceof TileEntityMetalMelter){
					return new ContainerMetalMelter(player.inventory, (TileEntityMetalMelter) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case MainRegistrey.guiIDMetalMeter:
				if(entity instanceof TileEntityMetalMelter){
					return new GuiMetalMelter(player.inventory, (TileEntityMetalMelter) entity);
				}
				return null;
			}
		}
		return null;
	}

}
