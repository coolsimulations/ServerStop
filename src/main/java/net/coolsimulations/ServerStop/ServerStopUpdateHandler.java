package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class ServerStopUpdateHandler {
	
	private static String latestVersion;
	public static boolean isOld = false;
	public static TranslatableComponent updateInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/serverstop-fabric/versionchecker116.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				TextComponent ss = new TextComponent(Reference.MOD_NAME);
				ss.withStyle(ChatFormatting.BLUE);
				
				TextComponent MCVersion = new TextComponent(SharedConstants.getCurrentVersion().getName());
				MCVersion.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				//updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop-fabric"));
				
			}
			
			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				TextComponent ss = new TextComponent(Reference.MOD_NAME);
				ss.withStyle(ChatFormatting.BLUE);
				
				TextComponent version = new TextComponent(latestVersion);
				version.withStyle(ChatFormatting.BLUE);
				
				updateInfo = new TranslatableComponent(ServerStopEventHandler.getTranslations("sp.update.display1"), new Object[] {ss, version});
				updateInfo.withStyle(ChatFormatting.YELLOW);
				
				//updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop-fabric"));
				
			}
			
		}
	}

}
