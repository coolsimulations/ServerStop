package net.coolsimulations.ServerStop;

import net.coolsimulations.ServerStop.proxy.ClientProxy;
import net.coolsimulations.ServerStop.proxy.CommonProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(value = Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerStop {
	
	 public static CommonProxy proxy = (CommonProxy) DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	private static ServerStop instance;
	public static ServerStop getInstance()
    {
        return instance;
    }
	
	public ServerStop() {
		
		ServerStopConfig.register(ModLoadingContext.get());
		ServerStopUpdateHandler.init();
		 
		if(FMLEnvironment.dist == Dist.DEDICATED_SERVER) {
			CommonProxy.init();
			MinecraftForge.EVENT_BUS.register(this);
		}
		
	}
	
	@SubscribeEvent
	public static void command(RegisterCommandsEvent event) {
		
		CommandCancel.register(event.getDispatcher());
		
	}
}
