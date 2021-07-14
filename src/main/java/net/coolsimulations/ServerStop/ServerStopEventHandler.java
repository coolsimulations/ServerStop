package net.coolsimulations.ServerStop;

import java.util.Calendar;
import java.util.List;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

		PlayerList player = ServerLifecycleHooks.getCurrentServer().getPlayerList();

		if(ServerStopConfig.stopWhenPlayersOnline.get()) {
			serverstop(event, player);
		} else {
			if(player.getPlayers().size() == 0) {
				serverstop(event, player);
			}
		}
	}

	@SubscribeEvent
	public void checkForUpdates(WorldEvent.Load event) {
		if(!event.getWorld().isRemote()) {
			ServerStopUpdateHandler.init();
		}
	}

	@SubscribeEvent
	public void onplayerLogin(PlayerLoggedInEvent event)
	{
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();

		if(ServerStopUpdateHandler.isOld == true && ServerStopConfig.disableUpdateCheck.get() == false && player.hasPermissionLevel(player.getServer().getOpPermissionLevel())) {
			player.sendMessage(ServerStopUpdateHandler.updateInfo);
			player.sendMessage(ServerStopUpdateHandler.updateVersionInfo);
		}
	}

	public static void serverstop(TickEvent.ServerTickEvent event, PlayerList player) {

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && ServerStopConfig.enableMonday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.mondayHour.get(), ServerStopConfig.mondayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY && ServerStopConfig.enableTuesday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.tuesdayHour.get(), ServerStopConfig.tuesdayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && ServerStopConfig.enableWednesday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.wednesdayHour.get(), ServerStopConfig.wednesdayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && ServerStopConfig.enableThursday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.thursdayHour.get(), ServerStopConfig.thursdayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && ServerStopConfig.enableFriday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.fridayHour.get(), ServerStopConfig.fridayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && ServerStopConfig.enableSaturday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.saturdayHour.get(), ServerStopConfig.saturdayMinute.get());
		}

		if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && ServerStopConfig.enableSunday.get() == true && cancel == false) {

			checkSendAndShutdown(player, ServerStopConfig.sundayHour.get(), ServerStopConfig.sundayMinute.get());
		}
	}

	public static void checkSendAndShutdown(PlayerList player, List<Integer> hour, List<Integer> minute) {

		int setPairs = Math.min(hour.size(), minute.size());

		for(int i = 0; i < setPairs; i++) {

			int innerHour = hour.get(i);
			int innerMinute = minute.get(i);

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

				hasPosted5Min = sendMessage(player, "serverstop.five_minutes", TextFormatting.AQUA, false);
			}

			if(!hasPosted1Min && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				hasPosted1Min = sendMessage(player, "serverstop.one_minute", TextFormatting.DARK_AQUA, false);
			}

			if(!hasPosted30Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 30) {

				hasPosted30Sec = sendMessage(player, "serverstop.thirty_seconds", TextFormatting.GOLD, false);
			}

			if(!hasPosted10Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 50) {

				hasPosted10Sec = sendMessage(player, "serverstop.ten_seconds", TextFormatting.YELLOW, false);
			}

			if(!hasPosted5Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 55) {

				hasPosted5Sec = sendMessage(player, "serverstop.five_seconds", TextFormatting.RED, true);
			}

			if(!hasPosted4Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 56) {

				hasPosted4Sec = sendMessage(player, "serverstop.four_seconds", TextFormatting.DARK_RED, true);
			}

			if(!hasPosted3Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 57) {

				hasPosted3Sec = sendMessage(player, "serverstop.three_seconds", TextFormatting.DARK_RED, true);
			}

			if(!hasPosted2Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 58) {

				hasPosted2Sec = sendMessage(player, "serverstop.two_seconds", TextFormatting.DARK_RED, true);
			}

			if(!hasPosted1Sec && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute - 1 && Calendar.getInstance().get(Calendar.SECOND) == 59) {

				hasPosted1Sec = sendMessage(player, "serverstop.one_second", TextFormatting.DARK_RED, true);
			}

			if(!hasStop && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) == innerHour && Calendar.getInstance().get(Calendar.MINUTE) == innerMinute && Calendar.getInstance().get(Calendar.SECOND) == 0) {

				ServerLifecycleHooks.getCurrentServer().initiateShutdown(false);
				hasStop = true;
			}
		}
	}

	public static boolean sendMessage(PlayerList player, String translation, TextFormatting colour, boolean bold) {

		StringTextComponent text = new StringTextComponent(getTranslations(translation));
		text.getStyle().setColor(colour);
		text.getStyle().setBold(bold);
		player.sendMessage(text);
		return true;
	}

	public static String getTranslations(String text) {

		String lang;

		if(ServerStopConfig.serverLang.get() != null)
			lang = ServerStopConfig.serverLang.get().toLowerCase();
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
