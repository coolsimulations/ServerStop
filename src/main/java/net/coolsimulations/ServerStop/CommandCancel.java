package net.coolsimulations.ServerStop;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandCancel extends CommandBase{

	@Override
	public String getCommandName() {
		
		return "serverstop";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		
		return ServerStopEventHandler.getTranslations("serverstop.commands.cancel.usage");
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 1)
        {
            throw new WrongUsageException(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.usage"), new Object[0]);
            
        } else {
        		ChatComponentText cancelFalse= new ChatComponentText(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
        		ChatComponentText cancelTrue = new ChatComponentText(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));
        		
        		cancelFalse.getChatStyle().setColor(EnumChatFormatting.YELLOW);
        		cancelTrue.getChatStyle().setColor(EnumChatFormatting.YELLOW);
        		
        		if(ServerStopEventHandler.cancel == false) {
        			
        			ServerStopEventHandler.cancel = true;
        			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(cancelTrue);
        		} else {
        			
        			ServerStopEventHandler.cancel = false;
        			MinecraftServer.getServer().getConfigurationManager().sendChatMsg(cancelFalse);
        		}
        }
		
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 4;
	}
    
    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos)
    {
        return getListOfStringsMatchingLastWord(args);
    }

}
