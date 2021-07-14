package net.coolsimulations.ServerStop;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;


public class ServerStopConfig {
	
	static Configuration config;
	
	public static String serverLang;
	
	public static Boolean enableMonday;
	public static int[] mondayHour;
	public static int[] mondayMinute;
	
	public static Boolean enableTuesday;
	public static int[] tuesdayHour;
	public static int[] tuesdayMinute;
	
	public static Boolean enableWednesday;
	public static int[] wednesdayHour;
	public static int[] wednesdayMinute;
	
	public static Boolean enableThursday;
	public static int[] thursdayHour;
	public static int[] thursdayMinute;
	
	public static Boolean enableFriday;
	public static int[] fridayHour;
	public static int[] fridayMinute;
	
	public static Boolean enableSaturday;
	public static int[] saturdayHour;
	public static int[] saturdayMinute;
	
	public static Boolean enableSunday;
	public static int[] sundayHour;
	public static int[] sundayMinute;
	
	public static boolean stopWhenPlayersOnline;
	
    public static boolean disableUpdateCheck;
	
	public static void init(File file)
    {
        config = new Configuration(file);
        syncConfig(true);
    }
	
    public static void forceSave()
    {
    	config.save();
    }
	
	 public static void syncConfig(boolean load)
	    {
	        List<String> propOrder = new ArrayList<String>();

	        try
	        {
	            Property prop;

	            if (!config.isChild)
	            {
	                if (load)
	                {
	                    config.load();
	                }
	            }
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_LANG, "Default Server language", "en_us");
	            prop.setComment("Server language codes are based off the Minecraft .lang files. See https://minecraft.gamepedia.com/Language for list.");
	            serverLang = prop.getString();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_UTIL, "Disable ServerStop Update Checker Message", false);
	            disableUpdateCheck = prop.getBoolean(false);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_UTIL, "Shutdown the Server Even if Players are Online", true);
	            stopWhenPlayersOnline = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_MONDAY, "Enable Monday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableMonday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_MONDAY, "Monday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Monday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            mondayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_MONDAY, "Monday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Monday this is the minute the server will auto-shutdown.");
	            mondayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_TUESDAY, "Enable Tuesday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableTuesday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_TUESDAY, "Tuesday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Tuesday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            tuesdayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_TUESDAY, "Tuesday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Tuesday this is the minute the server will auto-shutdown.");
	            tuesdayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_WEDNESDAY, "Enable Wednesday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableWednesday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_WEDNESDAY, "Wednesday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Wednesday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            wednesdayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_WEDNESDAY, "Wednesday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Wednesday this is the minute the server will auto-shutdown.");
	            wednesdayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_THURSDAY, "Enable Thursday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableThursday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_THURSDAY, "Thursday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Thursday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            thursdayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_THURSDAY, "Thursday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Thursday this is the minute the server will auto-shutdown.");
	            thursdayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_FRIDAY, "Enable Friday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableFriday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_FRIDAY, "Friday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Friday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            fridayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_FRIDAY, "Friday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Friday this is the minute the server will auto-shutdown.");
	            fridayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SATURDAY, "Enable Saturday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableSaturday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SATURDAY, "Saturday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Saturday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            saturdayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SATURDAY, "Saturday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Saturday this is the minute the server will auto-shutdown.");
	            saturdayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SUNDAY, "Enable Sunday Server Stop", true);
	            prop.setComment("If this is enabled, at a time specified below the server will auto-shutdown.");
	            enableSunday = prop.getBoolean(true);
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SUNDAY, "Sunday Server Shutdown Hour", new int[]{12});
	            prop.setComment("On Sunday this is the hour the server will auto-shutdown. It uses 24-hour time.");
	            sundayHour = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            prop = config.get(Reference.CONFIG_CATEGORY_SUNDAY, "Sunday Server Shutdown Minute", new int[]{0});
	            prop.setComment("On Sunday this is the minute the server will auto-shutdown.");
	            sundayMinute = prop.getIntList();
	            propOrder.add(prop.getName());
	            
	            propOrder.add(prop.getName());
	            
	            if (config.hasChanged())
	            {
	                config.save();
	            }
	            
	        }
	        catch (final Exception e)
	        {
	        	FMLRelaunchLog.log(Reference.MOD_NAME, Level.ERROR, ("Problem loading SurvivalPlus config (\"SurvivalPlus.conf\")"));
	            e.printStackTrace();
	        }
	    }
	 
	 public static List<IConfigElement> getConfigElements()
	    {
	        List<IConfigElement> list = new ArrayList<IConfigElement>();
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_LANG)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_MONDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_TUESDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_WEDNESDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_THURSDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_FRIDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_SATURDAY)).getChildElements());
	        list.addAll(new ConfigElement(config.getCategory(Reference.CONFIG_CATEGORY_SUNDAY)).getChildElements());
	        return list;
	    }

}
