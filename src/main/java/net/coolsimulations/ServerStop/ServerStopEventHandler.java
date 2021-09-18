package net.coolsimulations.ServerStop;

import java.util.Calendar;
import java.util.EnumSet;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ServerStopEventHandler implements ITickHandler {

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

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

		if(type.contains(TickType.SERVER)) {
			ServerConfigurationManager player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager();

			if(ServerStopConfig.stopWhenPlayersOnline) {
				serverstop(player);
			} else {
				if(player.playerEntityList.size() == 0) {
					serverstop(player);
				}
			}
		}
	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}
	
	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.SERVER);
	}
	
	@Override
	public String getLabel() {
		return null;
	}

	@ForgeSubscribe
	public void onplayerLogin(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.entity;

			boolean op = player.mcServer.getConfigurationManager().isPlayerOpped(player.username);

			if(ServerStopUpdateHandler.isOld == true && ServerStopConfig.disableUpdateCheck == false && op) {
				player.sendChatToPlayer(ServerStopUpdateHandler.updateInfo);
				player.sendChatToPlayer(ServerStopUpdateHandler.updateVersionInfo);
			}
		}
	}

	public static void serverstop(ServerConfigurationManager player) {

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && ServerStopConfig.enableMonday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.mondayHour, ServerStopConfig.mondayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && ServerStopConfig.enableTuesday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.tuesdayHour, ServerStopConfig.tuesdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && ServerStopConfig.enableWednesday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.wednesdayHour, ServerStopConfig.wednesdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && ServerStopConfig.enableThursday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.thursdayHour, ServerStopConfig.thursdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && ServerStopConfig.enableFriday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.fridayHour, ServerStopConfig.fridayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && ServerStopConfig.enableSaturday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.saturdayHour, ServerStopConfig.saturdayMinute);
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && ServerStopConfig.enableSunday == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.sundayHour, ServerStopConfig.sundayMinute);
		}
	}

	public static void checkSendAndShutdown(ServerConfigurationManager player, int[] hour, int[] minute) {

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

				hasPosted5Min = sendMessage(player, "serverstop.five_minutes", EnumChatFormatting.AQUA, false);
			}

			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				hasPosted1Min = sendMessage(player, "serverstop.one_minute", EnumChatFormatting.DARK_AQUA, false);
			}

			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

				hasPosted30Sec = sendMessage(player, "serverstop.thirty_seconds", EnumChatFormatting.GOLD, false);
			}

			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

				hasPosted10Sec = sendMessage(player, "serverstop.ten_seconds", EnumChatFormatting.YELLOW, false);
			}

			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

				hasPosted5Sec = sendMessage(player, "serverstop.five_seconds", EnumChatFormatting.RED, true);
			}

			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

				hasPosted4Sec = sendMessage(player, "serverstop.four_seconds", EnumChatFormatting.DARK_RED, true);
			}

			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

				hasPosted3Sec = sendMessage(player, "serverstop.three_seconds", EnumChatFormatting.DARK_RED, true);
			}

			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

				hasPosted2Sec = sendMessage(player, "serverstop.two_seconds", EnumChatFormatting.DARK_RED, true);
			}

			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

				hasPosted1Sec = sendMessage(player, "serverstop.one_second", EnumChatFormatting.DARK_RED, true);
			}

			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				FMLCommonHandler.instance().getMinecraftServerInstance().initiateShutdown();
				hasStop = true;
			}
		}
	}

	public static boolean sendMessage(ServerConfigurationManager player, String translation, EnumChatFormatting colour, boolean bold) {

		ChatMessageComponent text = ChatMessageComponent.createFromText(getTranslations(translation));
		text.setColor(colour);
		text.setBold(bold);
		player.sendChatMsg(text);
		return true;
	}

	public static String getTranslations(String text) {

		String lang;

		if(ServerStopConfig.serverLang != null)
			lang = ServerStopConfig.serverLang.toLowerCase();
		else
			lang = "en_us";

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
