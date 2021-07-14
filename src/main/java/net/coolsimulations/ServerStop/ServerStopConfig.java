package net.coolsimulations.ServerStop;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;


public class ServerStopConfig {
	
	public static ConfigValue<String> serverLang;
	
	public static BooleanValue enableMonday;
	public static ConfigValue<List<Integer>> mondayHour;
	public static ConfigValue<List<Integer>> mondayMinute;
	
	public static BooleanValue enableTuesday;
	public static ConfigValue<List<Integer>> tuesdayHour;
	public static ConfigValue<List<Integer>> tuesdayMinute;
	
	public static BooleanValue enableWednesday;
	public static ConfigValue<List<Integer>> wednesdayHour;
	public static ConfigValue<List<Integer>> wednesdayMinute;
	
	public static BooleanValue enableThursday;
	public static ConfigValue<List<Integer>> thursdayHour;
	public static ConfigValue<List<Integer>> thursdayMinute;
	
	public static BooleanValue enableFriday;
	public static ConfigValue<List<Integer>> fridayHour;
	public static ConfigValue<List<Integer>> fridayMinute;
	
	public static BooleanValue enableSaturday;
	public static ConfigValue<List<Integer>> saturdayHour;
	public static ConfigValue<List<Integer>> saturdayMinute;
	
	public static BooleanValue enableSunday;
	public static ConfigValue<List<Integer>> sundayHour;
	public static ConfigValue<List<Integer>> sundayMinute;
	
	public static BooleanValue stopWhenPlayersOnline;
	
    public static BooleanValue disableUpdateCheck;
    
    public static class Common {

		Common(final ForgeConfigSpec.Builder builder) {
			builder.comment("Lang Settings")
					.push("lang");
			
			serverLang = builder
					.comment("Server language codes are based off the Minecraft .lang files. See https://minecraft.gamepedia.com/Language for list.")
					.define("serverLang", "en_us");
			
			builder.pop();
			
			builder.comment("Util Settings")
			.push("util");
			
			disableUpdateCheck = builder
					.comment("Disable ServerStop Update Checker Message")
					.define("disableUpdateCheck", false);
			
			stopWhenPlayersOnline = builder
					.comment("Shutdown the Server Even if Players are Online")
					.define("stopWhenPlayersOnline", true);
			
			builder.pop();
			
			builder.comment("Monday Settings")
			.push("monday");
			
			enableMonday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableMonday", true);
			
			mondayHour = builder
					.comment("On Monday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("mondayHour", new ArrayList<Integer>());
			
			mondayMinute = builder
					.comment("On Monday this is the minute the server will auto-shutdown.")
					.define("mondayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Tuesday Settings")
			.push("tuesday");
			
			enableTuesday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableTuesday", true);
			
			tuesdayHour = builder
					.comment("On Tuesday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("tuesdayHour", new ArrayList<Integer>());
			
			tuesdayMinute = builder
					.comment("On Tuesday this is the minute the server will auto-shutdown.")
					.define("tuesdayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Wednesday Settings")
			.push("wednesday");
			
			enableWednesday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableWednesday", true);
			
			wednesdayHour = builder
					.comment("On Wednesday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("wednesdayHour", new ArrayList<Integer>());
			
			wednesdayMinute = builder
					.comment("On Wednesday this is the minute the server will auto-shutdown.")
					.define("wednesdayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Thursday Settings")
			.push("thursday");
			
			enableThursday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableThursday", true);
			
			thursdayHour = builder
					.comment("On Thursday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("thursdayHour", new ArrayList<Integer>());
			
			thursdayMinute = builder
					.comment("On Thursday this is the minute the server will auto-shutdown.")
					.define("thursdayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Friday Settings")
			.push("friday");
			
			enableFriday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableFriday", true);
			
			fridayHour = builder
					.comment("On Friday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("fridayHour", new ArrayList<Integer>());
			
			fridayMinute = builder
					.comment("On Friday this is the minute the server will auto-shutdown.")
					.define("fridayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Saturday Settings")
			.push("saturday");
			
			enableSaturday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableSaturday", true);
			
			saturdayHour = builder
					.comment("On Saturday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("saturdayHour", new ArrayList<Integer>());
			
			saturdayMinute = builder
					.comment("On Saturday this is the minute the server will auto-shutdown.")
					.define("saturdayMinute", new ArrayList<Integer>());
			
			builder.pop();
			
			builder.comment("Sunday Settings")
			.push("sunday");
			
			enableSunday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableSunday", true);
			
			sundayHour = builder
					.comment("On Sunday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.define("sundayHour", new ArrayList<Integer>());
			
			sundayMinute = builder
					.comment("On Sunday this is the minute the server will auto-shutdown.")
					.define("sundayMinute", new ArrayList<Integer>());
			
			builder.pop();
		}
    }
    
	private static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;
	
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static void register(final ModLoadingContext context) {
		context.registerConfig(ModConfig.Type.COMMON, commonSpec);
	}

}
