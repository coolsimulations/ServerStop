package net.coolsimulations.ServerStop;

import java.io.File;

import net.coolsimulations.ServerStop.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = Reference.DEPENDENCIES, acceptableRemoteVersions = "*", updateJSON = "https://coolsimulations.net/mcmods/serverstop/versionchecker.json")
public class ServerStop {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Reference.MOD_ID)
	public static ServerStop instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");
		ServerStopConfig.init(new File(event.getModConfigurationDirectory(), Reference.SERVERSTOP_CONFIG_FILE));
		ServerStopUpdateHandler.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");
		if(event.getSide() == Side.SERVER) { 
			CommonProxy.init();
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandCancel());
		
	}
}
