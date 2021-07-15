package net.coolsimulations.ServerStop;

import java.util.Calendar;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;

public class ServerStopEventHandler {

	private static boolean hasPosted5Min = false;
	private static boolean hasPosted1Min = false;
	private static boolean hasPosted30Sec = false;
	private static boolean hasPosted10Sec = false;
	private static boolean hasPosted5Sec = false;
	private static boolean hasPosted4Sec = false;
	private static boolean hasPosted3Sec = false;
	private static boolean hasPosted2Sec = false;
	private static boolean hasPosted1Sec = false;
	private static boolean hasStop = false;
	public static boolean cancel = false;

	public static void onServerTickEvent() {

		ServerTickEvents.START_SERVER_TICK.register((server) -> {

			PlayerList player = server.getPlayerList();

			if(ServerStopConfig.stopWhenPlayersOnline) {
				serverstop(server, player);
			} else {
				if(player.getPlayers().size() == 0) {
					serverstop(server, player);
				}
			}
		});
	}

	public static void onplayerLogin(ServerPlayer player)
	{
		if(ServerStopUpdateHandler.isOld == true && ServerStopConfig.disableUpdateCheck == false && player.hasPermissions(player.getServer().getOperatorUserPermissionLevel())) {
			player.sendMessage(ServerStopUpdateHandler.updateInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2")))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop-fabric"));}), ChatType.SYSTEM, Util.NIL_UUID);
			player.sendMessage(ServerStopUpdateHandler.updateVersionInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2")))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop-fabric"));}), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}

	public static void serverstop(MinecraftServer server, PlayerList player) {

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && ServerStopConfig.enableMonday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.mondayHour, ServerStopConfig.mondayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && ServerStopConfig.enableTuesday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.tuesdayHour, ServerStopConfig.tuesdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && ServerStopConfig.enableWednesday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.wednesdayHour, ServerStopConfig.wednesdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && ServerStopConfig.enableThursday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.thursdayHour, ServerStopConfig.thursdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && ServerStopConfig.enableFriday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.fridayHour, ServerStopConfig.fridayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && ServerStopConfig.enableSaturday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.saturdayHour, ServerStopConfig.saturdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && ServerStopConfig.enableSunday == true && cancel == false) {

			checkSendAndShutdown(server, player, ServerStopConfig.sundayHour, ServerStopConfig.sundayMinute);
		}
	}

	public static void checkSendAndShutdown(MinecraftServer server, PlayerList player, int[] hour, int[] minute) {

		int setPairs = Math.min(hour.length, minute.length);

		for(int i = 0; i < setPairs; i++) {

			int innerHour = hour[i];
			int innerMinute = minute[i];

			if(innerHour < 0) {
				innerHour = 0;
			} else if (innerHour > 23) {
				innerHour = 23;
			}

			if(innerMinute < 0) {
				innerMinute = 0;
			} else if (innerMinute > 59) {
				innerMinute = 59;
			}

			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				hasPosted5Min = sendMessage(player, "serverstop.five_minutes", ChatFormatting.AQUA, false);
			}

			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				hasPosted1Min = sendMessage(player, "serverstop.one_minute", ChatFormatting.DARK_AQUA, false);
			}

			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

				hasPosted30Sec = sendMessage(player, "serverstop.thirty_seconds", ChatFormatting.GOLD, false);
			}

			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

				hasPosted10Sec = sendMessage(player, "serverstop.ten_seconds", ChatFormatting.YELLOW, false);
			}

			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

				hasPosted5Sec = sendMessage(player, "serverstop.five_seconds", ChatFormatting.RED, true);
			}

			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

				hasPosted4Sec = sendMessage(player, "serverstop.four_seconds", ChatFormatting.DARK_RED, true);
			}

			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

				hasPosted3Sec = sendMessage(player, "serverstop.three_seconds", ChatFormatting.DARK_RED, true);
			}

			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

				hasPosted2Sec = sendMessage(player, "serverstop.two_seconds", ChatFormatting.DARK_RED, true);
			}

			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

				hasPosted1Sec = sendMessage(player, "serverstop.one_second", ChatFormatting.DARK_RED, true);
			}

			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				server.halt(false);
				hasStop = true;
			}
		}
	}

	public static boolean sendMessage(PlayerList player, String translation, ChatFormatting colour, boolean bold) {

		TextComponent text = new TextComponent(getTranslations(translation));
		text.withStyle(colour);
		if(bold)
			text.withStyle(ChatFormatting.BOLD);
		player.broadcastMessage(text, ChatType.SYSTEM, Util.NIL_UUID);
		return true;
	}

	public static String getTranslations(String text) {

		String lang = ServerStopConfig.serverLang.toLowerCase();;

		if(lang.equals("af_za")) {

			return ServerStopLang.afrikaansLang(text);
		}

		if(lang.equals("ar_sa")) {

			return ServerStopLang.arabicLang(text);
		}

		if(lang.equals("be_by")) {

			return ServerStopLang.belarusianLang(text);
		}

		if(lang.equals("bg_bg")) {

			return ServerStopLang.bulgarianLang(text);
		}

		if(lang.equals("bs_ba")) {

			return ServerStopLang.bosnianLang(text);
		}

		if(lang.equals("ca_es")) {

			return ServerStopLang.catalanLang(text);
		}

		if(lang.equals("cs_cz")) {

			return ServerStopLang.czechLang(text);
		}

		if(lang.equals("cy_gb")) {

			return ServerStopLang.welshLang(text);
		}

		if(lang.equals("da_dk")) {

			return ServerStopLang.danishLang(text);
		}

		if(lang.equals("de_at") || lang.equals("de_alg") || lang.equals("de_ch") || lang.equals("de_de")) {

			return ServerStopLang.germanLang(text);
		}

		if(lang.equals("el_gr")) {

			return ServerStopLang.greekLang(text);
		}

		if(lang.equals("en_us") || lang.equals("en_au") || lang.equals("en_ca") || lang.equals("en_gb") || lang.equals("en_nz")) {

			return ServerStopLang.englishUSLang(text);
		}

		if(lang.equals("en_7s") || lang.equals("en_pt")) {

			return ServerStopLang.englishPTLang(text);
		}

		if(lang.equals("en_ud")) {

			return ServerStopLang.englishUDLang(text);
		}

		if(lang.equals("en_ws")) {

			return ServerStopLang.englishWSLang(text);
		}

		if(lang.equals("eo") || lang.equals("eo_uy")) {

			return ServerStopLang.esperantoLang(text);
		}

		if(lang.equals("es_ar") || lang.equals("es_cl") || lang.equals("es_es") || lang.equals("es_mx") || lang.equals("es_uy") || lang.equals("es_ve")) {

			return ServerStopLang.spanishLang(text);
		}

		if(lang.equals("fi_fi")) {

			return ServerStopLang.finnishLang(text);
		}

		if(lang.equals("fr_fr")) {

			return ServerStopLang.frenchLang(text);
		}

		if(lang.equals("hr_hr")) {

			return ServerStopLang.croatianLang(text);
		}

		if(lang.equals("hu_hu")) {

			return ServerStopLang.hungarianLang(text);
		}

		if(lang.equals("it_it")) {

			return ServerStopLang.italianLang(text);
		}

		if(lang.equals("ja_jp")) {

			return ServerStopLang.japaneseLang(text);
		}

		if(lang.equals("ko_kr")) {

			return ServerStopLang.koreanLang(text);
		}

		if(lang.equals("nl_nl")) {

			return ServerStopLang.dutchLang(text);
		}

		if(lang.equals("pl_pl")) {

			return ServerStopLang.polishLang(text);
		}

		if(lang.equals("pt_br") || lang.equals("pt_pt")) {

			return ServerStopLang.portugueseLang(text);
		}

		if(lang.equals("ru_ru")) {

			return ServerStopLang.russianLang(text);
		}

		if(lang.equals("sv_se")) {

			return ServerStopLang.swedishLang(text);
		}

		if(lang.equals("th_th")) {

			return ServerStopLang.thaiLang(text);
		}

		if(lang.equals("tr_tr")) {

			return ServerStopLang.turkishLang(text);
		}

		if(lang.equals("zh_cn")) {

			return ServerStopLang.chineseSimpLang(text);
		}

		if(lang.equals("zh_tw")) {

			return ServerStopLang.chineseTradLang(text);
		}

		return ServerStopLang.englishUSLang(text);
	}
}
