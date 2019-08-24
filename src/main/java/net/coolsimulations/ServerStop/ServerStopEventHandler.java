package net.coolsimulations.ServerStop;

import java.util.Calendar;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

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
	
	@SubscribeEvent
    public void onServerTickEvent(TickEvent.ServerTickEvent event) {
		
		MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
		PlayerList player = server.getPlayerList();

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && ServerStopConfig.enableMonday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.mondayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.mondayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && ServerStopConfig.enableTuesday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.tuesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.tuesdayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && ServerStopConfig.enableWednesday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.wednesdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.wednesdayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && ServerStopConfig.enableThursday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.thursdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.thursdayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && ServerStopConfig.enableFriday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.fridayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.fridayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && ServerStopConfig.enableSaturday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.saturdayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.saturdayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
		
		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && ServerStopConfig.enableSunday.get() == true && cancel == false) {
			
			if(!hasPosted5Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 5 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString fiveMins = new TextComponentString(getTranslations("serverstop.five_minutes"));
				fiveMins.getStyle().setColor(TextFormatting.AQUA);
				player.sendMessage(fiveMins);
				hasPosted5Min = true;
			}
			
			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				TextComponentString oneMin = new TextComponentString(getTranslations("serverstop.one_minute"));
				oneMin.getStyle().setColor(TextFormatting.DARK_AQUA);
				player.sendMessage(oneMin);
				hasPosted1Min = true;
			}
			
			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {
				
				TextComponentString thirtySecs = new TextComponentString(getTranslations("serverstop.thirty_seconds"));
				thirtySecs.getStyle().setColor(TextFormatting.GOLD);
				player.sendMessage(thirtySecs);
				hasPosted30Sec = true;
			}
			
			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {
				
				TextComponentString tenSecs = new TextComponentString(getTranslations("serverstop.ten_seconds"));
				tenSecs.getStyle().setColor(TextFormatting.YELLOW);
				player.sendMessage(tenSecs);
				hasPosted10Sec = true;
			}
			
			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {
				
				TextComponentString fiveSecs = new TextComponentString(getTranslations("serverstop.five_seconds"));
				fiveSecs.getStyle().setColor(TextFormatting.RED);
				fiveSecs.getStyle().setBold(true);
				player.sendMessage(fiveSecs);
				hasPosted5Sec = true;
			}
			
			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {
				
				TextComponentString fourSecs = new TextComponentString(getTranslations("serverstop.four_seconds"));
				fourSecs.getStyle().setColor(TextFormatting.DARK_RED);
				fourSecs.getStyle().setBold(true);
				player.sendMessage(fourSecs);
				hasPosted4Sec = true;
			}
			
			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {
				
				TextComponentString threeSecs = new TextComponentString(getTranslations("serverstop.three_seconds"));
				threeSecs.getStyle().setColor(TextFormatting.DARK_RED);
				threeSecs.getStyle().setBold(true);
				player.sendMessage(threeSecs);
				hasPosted3Sec = true;
			}
			
			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {
				
				TextComponentString twoSecs = new TextComponentString(getTranslations("serverstop.two_seconds"));
				twoSecs.getStyle().setColor(TextFormatting.DARK_RED);
				twoSecs.getStyle().setBold(true);
				player.sendMessage(twoSecs);
				hasPosted2Sec = true;
			}
			
			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {
				
				TextComponentString oneSec = new TextComponentString(getTranslations("serverstop.one_second"));
				oneSec.getStyle().setColor(TextFormatting.DARK_RED);
				oneSec.getStyle().setBold(true);
				player.sendMessage(oneSec);
				hasPosted1Sec = true;
			}
			
			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == ServerStopConfig.sundayHour.get() && Calendar.getInstance().get(Calendar.MINUTE) == ServerStopConfig.sundayMinute.get() && Calendar.getInstance().get(Calendar.SECOND) == 0) {
				
				server.initiateShutdown();
				hasStop = true;
			}
		}
    }
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event)
    {
        if (event.getModID().equals(Reference.MOD_ID))
        {
            //ServerStopConfig.syncConfig(false);
        }
    }
	
	@SubscribeEvent
	public void onplayerLogin(PlayerLoggedInEvent event)
    {
		EntityPlayerMP player = (EntityPlayerMP) event.getPlayer();
		
		if(ServerStopUpdateHandler.isOld == true && ServerStopConfig.disableUpdateCheck.get() == false) {
        		player.sendMessage(ServerStopUpdateHandler.updateInfo);
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
