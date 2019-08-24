 package net.coolsimulations.ServerStop.proxy;
 
 import net.coolsimulations.ServerStop.ServerStopEventHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	public static void init() {
		
		MinecraftForge.EVENT_BUS.register(new ServerStopEventHandler());
	}
	 
}
