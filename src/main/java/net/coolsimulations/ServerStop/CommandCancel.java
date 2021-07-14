package net.coolsimulations.ServerStop;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.Util;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class CommandCancel {

	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("serverstop")
				.requires(s -> s.hasPermission(4))
				.executes(cancel -> cancel(cancel.getSource())));
	}

	private static int cancel(CommandSource sender) {

		StringTextComponent cancelFalse= new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
		StringTextComponent cancelTrue = new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));

		cancelFalse.withStyle(TextFormatting.YELLOW);
		cancelTrue.withStyle(TextFormatting.YELLOW);

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
