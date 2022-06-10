package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class ServerStopUpdateHandler {

	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static MutableComponent updateInfo = null;
	public static MutableComponent updateVersionInfo = null;

	public static void init() {

		try {
			URL url = new URL("https://coolsimulations.net/mcmods/serverstop/versionchecker119.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersion = s.next();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			URL url = new URL("https://coolsimulations.net/mcmods/serverstop/updateinfo119.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersionInfo = s.nextLine();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if(latestVersion != null) {

			if(latestVersion.equals("ended")) {

				isOld = true;

				MutableComponent ss = Component.literal(Reference.MOD_NAME);
				ss.withStyle(ChatFormatting.BLUE);

				MutableComponent MCVersion = Component.literal(MCPVersion.getMCVersion());
				MCVersion.withStyle(ChatFormatting.BLUE);

				updateInfo = Component.translatable(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.withStyle(ChatFormatting.YELLOW);

				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, Component.literal(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));

			}

			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {

				isOld = true;

				MutableComponent ss = Component.literal(Reference.MOD_NAME);
				ss.withStyle(ChatFormatting.BLUE);

				MutableComponent version = Component.literal(latestVersion);
				version.withStyle(ChatFormatting.BLUE);

				updateInfo = Component.translatable(ServerStopEventHandler.getTranslations("serverstop.update.display1"), new Object[] {ss, version});
				updateInfo.withStyle(ChatFormatting.YELLOW);

				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, Component.literal(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));
				
				if(latestVersionInfo != null) {

					updateVersionInfo = Component.literal(latestVersionInfo);
					updateVersionInfo.withStyle(ChatFormatting.DARK_AQUA);
					updateVersionInfo.withStyle(ChatFormatting.BOLD);

					//updateVersionInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
					//updateVersionInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));

				}

			}

		}
	}

}
