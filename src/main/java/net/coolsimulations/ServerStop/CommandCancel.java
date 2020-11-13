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
		.requires(s -> s.hasPermissionLevel(4))
		.executes(cancel -> cancel(cancel.getSource())));
	}

	private static int cancel(CommandSource sender) {

		StringTextComponent cancelFalse= new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
		StringTextComponent cancelTrue = new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));
		
		cancelFalse.mergeStyle(TextFormatting.YELLOW);
		cancelTrue.mergeStyle(TextFormatting.YELLOW);
		
		if(ServerStopEventHandler.cancel == false) {
			
			ServerStopEventHandler.cancel = true;
			sender.getServer().getPlayerList().func_232641_a_(cancelTrue, ChatType.SYSTEM, Util.DUMMY_UUID);
		} else {
			
			ServerStopEventHandler.cancel = false;
			sender.getServer().getPlayerList().func_232641_a_(cancelFalse, ChatType.SYSTEM, Util.DUMMY_UUID);
		}

		return Command.SINGLE_SUCCESS;
	}

}
