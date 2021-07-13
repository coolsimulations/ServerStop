package net.coolsimulations.ServerStop;

import java.util.Calendar;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.TextComponent;
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

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && ServerStopConfig.enableMonday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && ServerStopConfig.enableTuesday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && ServerStopConfig.enableWednesday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && ServerStopConfig.enableThursday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && ServerStopConfig.enableFriday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && ServerStopConfig.enableSaturday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}

			if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && ServerStopConfig.enableSunday == true && cancel == false) {

				if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent fiveMins = new TextComponent(getTranslations("serverstop.five_minutes"));
					fiveMins.withStyle(ChatFormatting.AQUA);
					player.broadcastMessage(fiveMins, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Min = true;
				}

				if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					TextComponent oneMin = new TextComponent(getTranslations("serverstop.one_minute"));
					oneMin.withStyle(ChatFormatting.DARK_AQUA);
					player.broadcastMessage(oneMin, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Min = true;
				}

				if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

					TextComponent thirtySecs = new TextComponent(getTranslations("serverstop.thirty_seconds"));
					thirtySecs.withStyle(ChatFormatting.GOLD);
					player.broadcastMessage(thirtySecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted30Sec = true;
				}

				if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

					TextComponent tenSecs = new TextComponent(getTranslations("serverstop.ten_seconds"));
					tenSecs.withStyle(ChatFormatting.YELLOW);
					player.broadcastMessage(tenSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted10Sec = true;
				}

				if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

					TextComponent fiveSecs = new TextComponent(getTranslations("serverstop.five_seconds"));
					fiveSecs.withStyle(ChatFormatting.RED);
					fiveSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fiveSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted5Sec = true;
				}

				if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

					TextComponent fourSecs = new TextComponent(getTranslations("serverstop.four_seconds"));
					fourSecs.withStyle(ChatFormatting.DARK_RED);
					fourSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(fourSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted4Sec = true;
				}

				if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

					TextComponent threeSecs = new TextComponent(getTranslations("serverstop.three_seconds"));
					threeSecs.withStyle(ChatFormatting.DARK_RED);
					threeSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(threeSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted3Sec = true;
				}

				if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

					TextComponent twoSecs = new TextComponent(getTranslations("serverstop.two_seconds"));
					twoSecs.withStyle(ChatFormatting.DARK_RED);
					twoSecs.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(twoSecs, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted2Sec = true;
				}

				if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

					TextComponent oneSec = new TextComponent(getTranslations("serverstop.one_second"));
					oneSec.withStyle(ChatFormatting.DARK_RED);
					oneSec.withStyle(ChatFormatting.BOLD);
					player.broadcastMessage(oneSec, ChatType.SYSTEM, Util.NIL_UUID);
					hasPosted1Sec = true;
				}

				if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

					server.halt(false);
					hasStop = true;
				}
			}
		});
	}

	public static void onplayerLogin(ServerPlayer player)
	{
		if(ServerStopUpdateHandler.isOld == true && ServerStopConfig.disableUpdateCheck == false) {
			player.sendMessage(ServerStopUpdateHandler.updateInfo, ChatType.SYSTEM, Util.NIL_UUID);
    		player.sendMessage(ServerStopUpdateHandler.updateInfo.withStyle((style) -> {return style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent(ServerStopEventHandler.getTranslations("serverstop.update.display2")))).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://curseforge.com/minecraft/mc-mods/serverstop-fabric"));}), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}

	public static String getTranslations(String text) {

		if(ServerStopConfig.serverLang.equals("af_za") || ServerStopConfig.serverLang.equals("af_ZA")) {

			return ServerStopLang.afrikaansLang(text);
		}

		if(ServerStopConfig.serverLang.equals("ar_sa") || ServerStopConfig.serverLang.equals("ar_SA")) {

			return ServerStopLang.arabicLang(text);
		}

		if(ServerStopConfig.serverLang.equals("be_by") || ServerStopConfig.serverLang.equals("be_BY")) {

			return ServerStopLang.belarusianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("bg_bg") || ServerStopConfig.serverLang.equals("bg_BG")) {

			return ServerStopLang.bulgarianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("bs_ba") || ServerStopConfig.serverLang.equals("bs_BA")) {

			return ServerStopLang.bosnianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("ca_es") || ServerStopConfig.serverLang.equals("ca_ES")) {

			return ServerStopLang.catalanLang(text);
		}

		if(ServerStopConfig.serverLang.equals("cs_cz") || ServerStopConfig.serverLang.equals("cs_CZ")) {

			return ServerStopLang.czechLang(text);
		}

		if(ServerStopConfig.serverLang.equals("cy_gb") || ServerStopConfig.serverLang.equals("cy_GB")) {

			return ServerStopLang.welshLang(text);
		}

		if(ServerStopConfig.serverLang.equals("da_dk") || ServerStopConfig.serverLang.equals("da_DK")) {

			return ServerStopLang.danishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("de_at") || ServerStopConfig.serverLang.equals("de_AT") || ServerStopConfig.serverLang.equals("de_alg") || ServerStopConfig.serverLang.equals("de_ALG") || ServerStopConfig.serverLang.equals("de_ch") || ServerStopConfig.serverLang.equals("de_CH") || ServerStopConfig.serverLang.equals("de_de") || ServerStopConfig.serverLang.equals("de_DE")) {

			return ServerStopLang.germanLang(text);
		}

		if(ServerStopConfig.serverLang.equals("el_gr") || ServerStopConfig.serverLang.equals("el_GR")) {

			return ServerStopLang.greekLang(text);
		}

		if(ServerStopConfig.serverLang.equals("en_us") || ServerStopConfig.serverLang.equals("en_US") || ServerStopConfig.serverLang.equals("en_au") || ServerStopConfig.serverLang.equals("en_AU") || ServerStopConfig.serverLang.equals("en_ca") || ServerStopConfig.serverLang.equals("en_CA") || ServerStopConfig.serverLang.equals("en_gb") || ServerStopConfig.serverLang.equals("en_GB") || ServerStopConfig.serverLang.equals("en_nz") || ServerStopConfig.serverLang.equals("en_NZ") || ServerStopConfig.serverLang.equals(null)) {

			return ServerStopLang.englishUSLang(text);
		}

		if(ServerStopConfig.serverLang.equals("en_7s") || ServerStopConfig.serverLang.equals("en_7S") || ServerStopConfig.serverLang.equals("en_pt") || ServerStopConfig.serverLang.equals("en_PT")) {

			return ServerStopLang.englishPTLang(text);
		}

		if(ServerStopConfig.serverLang.equals("en_ud") || ServerStopConfig.serverLang.equals("en_UD")) {

			return ServerStopLang.englishUDLang(text);
		}

		if(ServerStopConfig.serverLang.equals("en_ws") || ServerStopConfig.serverLang.equals("en_WS")) {

			return ServerStopLang.englishWSLang(text);
		}

		if(ServerStopConfig.serverLang.equals("eo") || ServerStopConfig.serverLang.equals("EO") || ServerStopConfig.serverLang.equals("eo_uy") || ServerStopConfig.serverLang.equals("eo_UY")) {

			return ServerStopLang.esperantoLang(text);
		}

		if(ServerStopConfig.serverLang.equals("es_ar") || ServerStopConfig.serverLang.equals("es_AR") || ServerStopConfig.serverLang.equals("es_cl") || ServerStopConfig.serverLang.equals("es_CL") || ServerStopConfig.serverLang.equals("es_es") || ServerStopConfig.serverLang.equals("es_ES") || ServerStopConfig.serverLang.equals("es_mx") || ServerStopConfig.serverLang.equals("es_MX") || ServerStopConfig.serverLang.equals("es_uy") || ServerStopConfig.serverLang.equals("es_UY") || ServerStopConfig.serverLang.equals("es_ve") || ServerStopConfig.serverLang.equals("es_VE")) {

			return ServerStopLang.spanishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("fi_fi") || ServerStopConfig.serverLang.equals("fi_FI")) {

			return ServerStopLang.finnishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("fr_fr") || ServerStopConfig.serverLang.equals("fr_FR")) {

			return ServerStopLang.frenchLang(text);
		}

		if(ServerStopConfig.serverLang.equals("hr_hr") || ServerStopConfig.serverLang.equals("hr_HR")) {

			return ServerStopLang.croatianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("hu_hu") || ServerStopConfig.serverLang.equals("hu_HU")) {

			return ServerStopLang.hungarianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("it_it") || ServerStopConfig.serverLang.equals("it_IT")) {

			return ServerStopLang.italianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("ja_jp") || ServerStopConfig.serverLang.equals("ja_JP")) {

			return ServerStopLang.japaneseLang(text);
		}

		if(ServerStopConfig.serverLang.equals("ko_kr") || ServerStopConfig.serverLang.equals("ko_KR")) {

			return ServerStopLang.koreanLang(text);
		}

		if(ServerStopConfig.serverLang.equals("nl_nl") || ServerStopConfig.serverLang.equals("nl_NL")) {

			return ServerStopLang.dutchLang(text);
		}

		if(ServerStopConfig.serverLang.equals("pl_pl") || ServerStopConfig.serverLang.equals("pl_PL")) {

			return ServerStopLang.polishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("pt_br") || ServerStopConfig.serverLang.equals("pt_BR") || ServerStopConfig.serverLang.equals("pt_pt") || ServerStopConfig.serverLang.equals("pt_PT")) {

			return ServerStopLang.portugueseLang(text);
		}

		if(ServerStopConfig.serverLang.equals("ru_ru") || ServerStopConfig.serverLang.equals("ru_RU")) {

			return ServerStopLang.russianLang(text);
		}

		if(ServerStopConfig.serverLang.equals("sv_se") || ServerStopConfig.serverLang.equals("sv_SE")) {

			return ServerStopLang.swedishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("th_th") || ServerStopConfig.serverLang.equals("th_TH")) {

			return ServerStopLang.thaiLang(text);
		}

		if(ServerStopConfig.serverLang.equals("tr_tr") || ServerStopConfig.serverLang.equals("tr_TR")) {

			return ServerStopLang.turkishLang(text);
		}

		if(ServerStopConfig.serverLang.equals("zh_cn") || ServerStopConfig.serverLang.equals("zh_CN")) {

			return ServerStopLang.chineseSimpLang(text);
		}

		if(ServerStopConfig.serverLang.equals("zh_tw") || ServerStopConfig.serverLang.equals("zh_TW")) {

			return ServerStopLang.chineseTradLang(text);
		}

		return ServerStopLang.englishUSLang(text);
	}
}
