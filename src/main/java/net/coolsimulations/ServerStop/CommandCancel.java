package net.coolsimulations.ServerStop;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

public class CommandCancel {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("serverstop")
		.requires(s -> s.hasPermissionLevel(4))
		.executes(cancel -> cancel(cancel.getSource())));
	}

	private static int cancel(ServerCommandSource sender) {

		LiteralText cancelFalse= new LiteralText(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
		LiteralText cancelTrue = new LiteralText(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));
		
		cancelFalse.getStyle().setColor(Formatting.YELLOW);
		cancelTrue.getStyle().setColor(Formatting.YELLOW);
		
		if(ServerStopEventHandler.cancel == false) {
			
			ServerStopEventHandler.cancel = true;
			sender.getMinecraftServer().getPlayerManager().sendToAll(cancelTrue);
		} else {
			
			ServerStopEventHandler.cancel = false;
			sender.getMinecraftServer().getPlayerManager().sendToAll(cancelFalse);
		}

		return Command.SINGLE_SUCCESS;
	}

}
