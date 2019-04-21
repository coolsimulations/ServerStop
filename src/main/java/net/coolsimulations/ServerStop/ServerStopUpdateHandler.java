package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.common.MinecraftForge;

public class ServerStopUpdateHandler {
	
	private static String latestVersion;
	public static boolean isOld = false;
	public static TextComponentTranslation updateInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/serverstop/versionchecker110.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				TextComponentString ss = new TextComponentString(Reference.MOD_NAME);
				ss.getStyle().setColor(TextFormatting.BLUE);
				
				TextComponentString MCVersion = new TextComponentString(MinecraftForge.MC_VERSION);
				MCVersion.getStyle().setColor(TextFormatting.BLUE);
				
				updateInfo = new TextComponentTranslation(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.getStyle().setColor(TextFormatting.YELLOW);
				
				updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge/projects/serverstop"));
				
			}
			
			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				TextComponentString ss = new TextComponentString(Reference.MOD_NAME);
				ss.getStyle().setColor(TextFormatting.BLUE);
				
				TextComponentString version = new TextComponentString(latestVersion);
				version.getStyle().setColor(TextFormatting.BLUE);
				
				updateInfo = new TextComponentTranslation(ServerStopEventHandler.getTranslations("sp.update.display1"), new Object[] {ss, version});
				updateInfo.getStyle().setColor(TextFormatting.YELLOW);
				
				updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge/projects/serverstop"));
				
			}
			
		}
	}

}
