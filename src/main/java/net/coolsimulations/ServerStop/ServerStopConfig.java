package net.coolsimulations.ServerStop;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;


public class ServerStopConfig {
	
	public static ConfigValue<String> serverLang;
	
	public static BooleanValue enableMonday;
	public static IntValue mondayHour;
	public static IntValue mondayMinute;
	
	public static BooleanValue enableTuesday;
	public static IntValue tuesdayHour;
	public static IntValue tuesdayMinute;
	
	public static BooleanValue enableWednesday;
	public static IntValue wednesdayHour;
	public static IntValue wednesdayMinute;
	
	public static BooleanValue enableThursday;
	public static IntValue thursdayHour;
	public static IntValue thursdayMinute;
	
	public static BooleanValue enableFriday;
	public static IntValue fridayHour;
	public static IntValue fridayMinute;
	
	public static BooleanValue enableSaturday;
	public static IntValue saturdayHour;
	public static IntValue saturdayMinute;
	
	public static BooleanValue enableSunday;
	public static IntValue sundayHour;
	public static IntValue sundayMinute;
	
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
			
			builder.pop();
			
			builder.comment("Monday Settings")
			.push("monday");
			
			enableMonday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableMonday", true);
			
			mondayHour = builder
					.comment("On Monday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("mondayHour", 12, 0, 23);
			
			mondayMinute = builder
					.comment("On Monday this is the minute the server will auto-shutdown.")
					.defineInRange("mondayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Tuesday Settings")
			.push("tuesday");
			
			enableTuesday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableTuesday", true);
			
			tuesdayHour = builder
					.comment("On Tuesday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("tuesdayHour", 12, 0, 23);
			
			tuesdayMinute = builder
					.comment("On Tuesday this is the minute the server will auto-shutdown.")
					.defineInRange("tuesdayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Wednesday Settings")
			.push("wednesday");
			
			enableWednesday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableWednesday", true);
			
			wednesdayHour = builder
					.comment("On Wednesday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("wednesdayHour", 12, 0, 23);
			
			wednesdayMinute = builder
					.comment("On Wednesday this is the minute the server will auto-shutdown.")
					.defineInRange("wednesdayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Thursday Settings")
			.push("thursday");
			
			enableThursday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableThursday", true);
			
			thursdayHour = builder
					.comment("On Thursday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("thursdayHour", 12, 0, 23);
			
			thursdayMinute = builder
					.comment("On Thursday this is the minute the server will auto-shutdown.")
					.defineInRange("thursdayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Friday Settings")
			.push("friday");
			
			enableFriday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableFriday", true);
			
			fridayHour = builder
					.comment("On Friday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("fridayHour", 12, 0, 23);
			
			fridayMinute = builder
					.comment("On Friday this is the minute the server will auto-shutdown.")
					.defineInRange("fridayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Saturday Settings")
			.push("saturday");
			
			enableSaturday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableSaturday", true);
			
			saturdayHour = builder
					.comment("On Saturday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("saturdayHour", 12, 0, 23);
			
			saturdayMinute = builder
					.comment("On Saturday this is the minute the server will auto-shutdown.")
					.defineInRange("saturdayMinute", 0, 0, 59);
			
			builder.pop();
			
			builder.comment("Sunday Settings")
			.push("sunday");
			
			enableSunday = builder
					.comment("If this is enabled, at a time specified below the server will auto-shutdown.")
					.define("enableSunday", true);
			
			sundayHour = builder
					.comment("On Sunday this is the hour the server will auto-shutdown. It uses 24-hour time.")
					.defineInRange("sundayHour", 12, 0, 23);
			
			sundayMinute = builder
					.comment("On Sunday this is the minute the server will auto-shutdown.")
					.defineInRange("sundayMinute", 0, 0, 59);
			
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
