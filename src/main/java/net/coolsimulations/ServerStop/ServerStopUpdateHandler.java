package net.coolsimulations.ServerStop;

import java.net.URL;
import java.util.Scanner;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;

public class ServerStopUpdateHandler {

	private static String latestVersion;
	private static String latestVersionInfo;
	public static boolean isOld = false;
	public static ChatMessageComponent updateInfo = null;
	public static ChatMessageComponent updateVersionInfo = null;

	public static void init() {

		try {
			URL url = new URL("http://coolsimulations.net/mcmods/serverstop/versionchecker16.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersion = s.next();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			URL url = new URL("http://coolsimulations.net/mcmods/serverstop/updateinfo16.txt");
			Scanner s = new Scanner(url.openStream());
			latestVersionInfo = s.nextLine();
			s.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if(latestVersion != null) {

			if(latestVersion.equals("ended")) {

				isOld = true;

				ChatMessageComponent ss = ChatMessageComponent.createFromText("§9" + Reference.MOD_NAME + "§e");
				ss.setColor(EnumChatFormatting.BLUE);

				ChatMessageComponent MCVersion = ChatMessageComponent.createFromText("§9" + FMLCommonHandler.instance().getMinecraftServerInstance().getMinecraftVersion() + "§e");
				MCVersion.setColor(EnumChatFormatting.BLUE);

				updateInfo = ChatMessageComponent.createFromTranslationWithSubstitutions(ServerStopEventHandler.getTranslations("serverstop.update.display3"), new Object[] {ss, MCVersion});
				updateInfo.setColor(EnumChatFormatting.YELLOW);

			}

			if(!latestVersion.equals(Reference.VERSION) && !latestVersion.equals("ended")) {

				isOld = true;

				ChatMessageComponent ss = ChatMessageComponent.createFromText("§9" + Reference.MOD_NAME + "§e");
				ss.setColor(EnumChatFormatting.BLUE);

				ChatMessageComponent version = ChatMessageComponent.createFromText("§9" + latestVersion + "§e");
				version.setColor(EnumChatFormatting.BLUE);

				updateInfo = ChatMessageComponent.createFromTranslationWithSubstitutions(ServerStopEventHandler.getTranslations("serverstop.update.display1"), new Object[] {ss, version});
				updateInfo.setColor(EnumChatFormatting.YELLOW);

				if(latestVersionInfo != null) {

					updateVersionInfo = ChatMessageComponent.createFromText(latestVersionInfo);
					updateVersionInfo.setColor(EnumChatFormatting.DARK_AQUA);
					updateVersionInfo.setBold(true);

				}

			}

		}
	}

}
