package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class ServerStopUpdateHandler {
	
	private static String latestVersion;
	public static boolean isOld = false;
	public static TranslationTextComponent updateInfo = null;
	
	public static void init() {
		
		try {
            URL url = new URL("https://coolsimulations.net/mcmods/serverstop/versionchecker115.txt");
            Scanner s = new Scanner(url.openStream());
            latestVersion = s.next();
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		if(latestVersion != null) {
			
			if(latestVersion.equals("ended")) {
				
				isOld = true;
				
				StringTextComponent ss = new StringTextComponent(Reference.MOD_NAME);
				ss.getStyle().setColor(TextFormatting.BLUE);
				
				StringTextComponent MCVersion = new StringTextComponent(MCPVersion.getMCVersion());
				MCVersion.getStyle().setColor(TextFormatting.BLUE);
				
				updateInfo = new TranslationTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.getStyle().setColor(TextFormatting.YELLOW);
				
				updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));
				
			}
			
			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {
				
				isOld = true;
				
				StringTextComponent ss = new StringTextComponent(Reference.MOD_NAME);
				ss.getStyle().setColor(TextFormatting.BLUE);
				
				StringTextComponent version = new StringTextComponent(latestVersion);
				version.getStyle().setColor(TextFormatting.BLUE);
				
				updateInfo = new TranslationTextComponent(ServerStopEventHandler.getTranslations("sp.update.display1"), new Object[] {ss, version});
				updateInfo.getStyle().setColor(TextFormatting.YELLOW);
				
				updateInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				updateInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));
				
			}
			
		}
	}

}
