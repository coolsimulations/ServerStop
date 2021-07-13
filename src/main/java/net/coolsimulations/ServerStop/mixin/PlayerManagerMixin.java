package net.coolsimulations.ServerStop.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.coolsimulations.ServerStop.ServerStopEventHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {
	
    @Inject(at = @At("TAIL"), method = "onPlayerConnect", cancellable = true)
	public void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info) {
    	
    	ServerStopEventHandler.onplayerLogin(player);
	}

}
