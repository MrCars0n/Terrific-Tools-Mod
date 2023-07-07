package com.CKCM.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import com.CKCM.CreativeTab.TT_tab;
import com.CKCM.Items.ItemTEst_I;
import com.CKCM.blocks.MetalMelter;
import com.CKCM.handler.GuiHandler;
import com.CKCM.lib.RefStrings;
import com.CKCM.proxy.ClientProxy;
import com.CKCM.tileEntity.TileEntityMetalMelter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistrey {
	public static Block blockMetalMelterIdle;
	public static Block blockMetalMelterActive;
	
	public static final int guiIDMetalMeter = 0; 
	
	public static Item Test_Item = new ItemTEst_I().setUnlocalizedName("TestItem");
	
	public static final TT_tab tabTT = new TT_tab("tabTT");
	
	@SidedProxy(clientSide = "com.TT.proxy.ClientProxy", serverSide = "com.TT.proxy.CommonProxy")
	public static ClientProxy proxy;
	
	@Instance(RefStrings.MODID)
	public static MainRegistrey instance;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		proxy.registerRenderThings();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//Machines
		blockMetalMelterIdle = new MetalMelter(false).setBlockName("MetalMelterIdle").setCreativeTab(MainRegistrey.tabTT).setHardness(3.5F);
		blockMetalMelterActive = new MetalMelter(true).setBlockName("MetalMelterActive").setLightLevel(0.82F).setHardness(3.5F);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//Registers
		GameRegistry.registerBlock(blockMetalMelterIdle, "MetalMelterIdle");
		GameRegistry.registerBlock(blockMetalMelterActive, "MetalMelterActive");
		
		GameRegistry.registerTileEntity(TileEntityMetalMelter.class, "MetalMelter");
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event){
		
		GameRegistry.addRecipe(new ItemStack(MainRegistrey.blockMetalMelterIdle),
				"ICI",
				"CLC",
				"ICI",
				'C', Blocks.cobblestone, 'L', Items.lava_bucket, 'I', Items.iron_ingot
				);
		
	}

}
