package com.TT.Main;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

import com.TT.CreativeTab.TT_tab;
import com.TT.Items.ItemTEst_I;
import com.TT.blocks.MetalMelter;
import com.TT.bow.ItemExplosiveBow;
import com.TT.bow.itemExplosiveArrow;
import com.TT.handler.GuiHandler;
import com.TT.lib.RefStrings;
import com.TT.proxy.ClientProxy;
import com.TT.tileEntity.TileEntityMetalMelter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistrey {
	public static Block blockMetalMelterIdle;
	public static Block blockMetalMelterActive;
	public static final int guiIDMetalMeter = 0; 
	public static Item explosive_bow;
	public static Item Test_Item = new ItemTEst_I().setUnlocalizedName("TestItem");
	public static Item itemExplosiveArrow;
	public static final TT_tab tabTT = new TT_tab("tabTT");
	
	@SidedProxy(clientSide = "com.TT.proxy.ClientProxy", serverSide = "com.TT.proxy.CommonProxy")
	public static ClientProxy proxy;
	
	@Instance(RefStrings.MODID)
	public static MainRegistrey instance;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		proxy.registerRenderThings();
		//Items
		itemExplosiveArrow = new itemExplosiveArrow().setUnlocalizedName("itemExplosiveArrow").setTextureName(RefStrings.MODID + ":" + "itemExplosiveArrow");
		explosive_bow = new ItemExplosiveBow();
		
		//Item Registers
		GameRegistry.registerItem(itemExplosiveArrow, itemExplosiveArrow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Test_Item, Test_Item.getUnlocalizedName().substring(5));
		//Crafting Recipes
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(MainRegistrey.explosive_bow),
				"TTT",
				"TBT",
				"TTT",
				'T', Blocks.tnt, 'B', Items.bow
				);
		//Machines
		blockMetalMelterIdle = new MetalMelter(false).setBlockName("MetalMelterIdle").setCreativeTab(MainRegistrey.tabTT).setHardness(3.5F);
		blockMetalMelterActive = new MetalMelter(true).setBlockName("MetalMelterActive").setLightLevel(0.82F).setHardness(3.5F);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//Registers
		GameRegistry.registerBlock(blockMetalMelterIdle, "MetalMelterIdle");
		GameRegistry.registerBlock(blockMetalMelterActive, "MetalMelterActive");
		GameRegistry.registerItem(explosive_bow, "explosive_bow");
		
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
