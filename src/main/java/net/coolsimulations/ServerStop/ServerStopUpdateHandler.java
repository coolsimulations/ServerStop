package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.versions.mcp.MCPVersion;

public class ServerStopUpdateHandler {

	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static TranslationTextComponent updateInfo = null;
	public static StringTextComponent updateVersionInfo = null;

	public static void init() {

		try {
			URL url = new URL("https://coolsimulations.net/mcmods/serverstop/versionchecker116.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersion = s.next();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			URL url = new URL("https://coolsimulations.net/mcmods/serverstop/updateinfo116.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersionInfo = s.nextLine();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if(latestVersion != null) {

			if(latestVersion.equals("ended")) {

				isOld = true;

				StringTextComponent ss = new StringTextComponent(Reference.MOD_NAME);
				ss.withStyle(TextFormatting.BLUE);

				StringTextComponent MCVersion = new StringTextComponent(MCPVersion.getMCVersion());
				MCVersion.withStyle(TextFormatting.BLUE);

				updateInfo = new TranslationTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.withStyle(TextFormatting.YELLOW);

				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));

			}

			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {

				isOld = true;

				StringTextComponent ss = new StringTextComponent(Reference.MOD_NAME);
				ss.withStyle(TextFormatting.BLUE);

				StringTextComponent version = new StringTextComponent(latestVersion);
				version.withStyle(TextFormatting.BLUE);

				updateInfo = new TranslationTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display1"), new Object[] {ss, version});
				updateInfo.withStyle(TextFormatting.YELLOW);

				//updateInfo.getStyle().func_240716_a_(new HoverEvent(HoverEvent.Action.field_230550_a_, new StringTextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2"))));
				//updateInfo.getStyle().func_240715_a_(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));
				
				if(latestVersionInfo != null) {

					updateVersionInfo = new StringTextComponent(latestVersionInfo);
					updateVersionInfo.withStyle(TextFormatting.DARK_AQUA);
					updateVersionInfo.withStyle(TextFormatting.BOLD);

					//updateVersionInfo.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent("serverstop.update.display2")));
					//updateVersionInfo.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop"));

				}

			}

		}
	}

}
