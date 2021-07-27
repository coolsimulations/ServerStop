package net.coolsimulations.ServerStop;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TextComponent;

public class CommandCancel {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("serverstop")
				.requires(s -> s.hasPermission(4))
				.executes(cancel -> cancel(cancel.getSource())));
	}

	private static int cancel(CommandSourceStack sender) {

		TextComponent cancelFalse= new TextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
		TextComponent cancelTrue = new TextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));

		cancelFalse.withStyle(ChatFormatting.YELLOW);
		cancelTrue.withStyle(ChatFormatting.YELLOW);

		if(ServerStopEventHandler.cancel == false) {

			ServerStopEventHandler.cancel = true;
			if (sender.getEntity() != null)
				sender.getServer().getPlayerList().broadcastMessage(cancelTrue, ChatType.CHAT, sender.getEntity().getUUID());
			else
				sender.getServer().getPlayerList().broadcastMessage(cancelTrue, ChatType.SYSTEM, Util.NIL_UUID);
		} else {

			ServerStopEventHandler.cancel = false;
			if (sender.getEntity() != null)
				sender.getServer().getPlayerList().broadcastMessage(cancelFalse, ChatType.CHAT, sender.getEntity().getUUID());
			else
				sender.getServer().getPlayerList().broadcastMessage(cancelFalse, ChatType.SYSTEM, Util.NIL_UUID);
		}

		return Command.SINGLE_SUCCESS;
	}

}
