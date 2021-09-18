 package net.coolsimulations.ServerStop.proxy;
 
 import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.coolsimulations.ServerStop.ServerStopEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	public static void init() {
		
		//FMLCommonHandler.instance().bus().register(new ServerStopEventHandler());
		MinecraftForge.EVENT_BUS.register(new ServerStopEventHandler());
		TickRegistry.registerTickHandler(new ServerStopEventHandler(), Side.SERVER);
	}
	 
}
