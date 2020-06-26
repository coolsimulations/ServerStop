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
		
		cancelFalse.func_240699_a_(TextFormatting.YELLOW);
		cancelTrue.func_240699_a_(TextFormatting.YELLOW);
		
		if(ServerStopEventHandler.cancel == false) {
			
			ServerStopEventHandler.cancel = true;
			sender.getServer().getPlayerList().func_232641_a_(cancelTrue, ChatType.SYSTEM, Util.field_240973_b_);
		} else {
			
			ServerStopEventHandler.cancel = false;
			sender.getServer().getPlayerList().func_232641_a_(cancelFalse, ChatType.SYSTEM, Util.field_240973_b_);
		}

		return Command.SINGLE_SUCCESS;
	}

}
