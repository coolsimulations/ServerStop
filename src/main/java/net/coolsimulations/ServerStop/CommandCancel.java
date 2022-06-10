package net.coolsimulations.ServerStop;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class CommandCancel {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("serverstop")
				.requires(s -> s.hasPermission(4))
				.executes(cancel -> cancel(cancel.getSource())));
	}

	private static int cancel(CommandSourceStack sender) {

		MutableComponent cancelFalse= Component.literal(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
		MutableComponent cancelTrue = Component.literal(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));

		cancelFalse.withStyle(ChatFormatting.YELLOW);
		cancelTrue.withStyle(ChatFormatting.YELLOW);

		if(ServerStopEventHandler.cancel == false) {

			ServerStopEventHandler.cancel = true;
			sender.getServer().getPlayerList().broadcastSystemMessage(cancelTrue, ChatType.SYSTEM);
		} else {

			ServerStopEventHandler.cancel = false;
			sender.getServer().getPlayerList().broadcastSystemMessage(cancelFalse, ChatType.SYSTEM);
		}

		return Command.SINGLE_SUCCESS;
	}

}
