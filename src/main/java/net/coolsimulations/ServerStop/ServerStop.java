package net.coolsimulations.ServerStop;

import java.io.File;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;

public class ServerStop implements ModInitializer {

	private static ServerStop instance;
	public static ServerStop getInstance()
	{
		return instance;
	}

	@Override
	public void onInitialize() {

		ServerStopConfig.init(new File(FabricLoader.getInstance().getConfigDir().toFile(), Reference.MOD_ID + ".json"));
		ServerStopUpdateHandler.init();

		if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
			ServerStopEventHandler.onServerTickEvent();
		}
		
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, environment) -> {
			CommandCancel.register(dispatcher);
		});

	}
}
