 package net.coolsimulations.ServerStop.proxy;
 
 import cpw.mods.fml.common.FMLCommonHandler;
import net.coolsimulations.ServerStop.ServerStopEventHandler;

public interface CommonProxy {
	
	public static void init() {
		
		FMLCommonHandler.instance().bus().register(new ServerStopEventHandler());
	}
	 
}
