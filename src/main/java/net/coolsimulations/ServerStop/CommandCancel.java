package net.coolsimulations.ServerStop;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

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
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length >= 1)
        {
            throw new WrongUsageException(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.usage"), new Object[0]);
            
        } else {
        		TextComponentString cancelFalse= new TextComponentString(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display1"));
        		TextComponentString cancelTrue = new TextComponentString(ServerStopEventHandler.getTranslations("serverstop.commands.cancel.display2"));
        		
        		cancelFalse.getStyle().setColor(TextFormatting.YELLOW);
        		cancelTrue.getStyle().setColor(TextFormatting.YELLOW);
        		
        		if(ServerStopEventHandler.cancel == false) {
        			
        			ServerStopEventHandler.cancel = true;
        			server.getPlayerList().sendChatMsg(cancelTrue);
        		} else {
        			
        			ServerStopEventHandler.cancel = false;
        			server.getPlayerList().sendChatMsg(cancelFalse);
        		}
        }
		
	}

	@Override
	public int getRequiredPermissionLevel() {
		
		return 4;
	}
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
    
    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return getListOfStringsMatchingLastWord(args);
    }

}
