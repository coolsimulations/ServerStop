package net.coolsimulations.ServerStop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ServerStopConfig {
	
	public static String serverLang;
	
	public static boolean enableMonday;
	public static int mondayHour;
	public static int mondayMinute;
	
	public static boolean enableTuesday;
	public static int tuesdayHour;
	public static int tuesdayMinute;
	
	public static boolean enableWednesday;
	public static int wednesdayHour;
	public static int wednesdayMinute;
	
	public static boolean enableThursday;
	public static int thursdayHour;
	public static int thursdayMinute;
	
	public static boolean enableFriday;
	public static int fridayHour;
	public static int fridayMinute;
	
	public static boolean enableSaturday;
	public static int saturdayHour;
	public static int saturdayMinute;
	
	public static boolean enableSunday;
	public static int sundayHour;
	public static int sundayMinute;
	
    public static boolean disableUpdateCheck;
    
    static File file;
	static JsonObject object;
	
	public static void init(File fileSrc) {

		serverLang = "en_us";
		
		disableUpdateCheck = false;
		
		enableMonday = true;
		mondayHour = 12;
		mondayMinute = 0;
		
		enableTuesday = true;
		tuesdayHour = 12;
		tuesdayMinute = 0;
		
		enableWednesday = true;
		wednesdayHour = 12;
		wednesdayMinute = 0;
		
		enableThursday = true;
		thursdayHour = 12;
		thursdayMinute = 0;
		
		enableFriday = true;
		fridayHour = 12;
		fridayMinute = 0;
		
		enableSaturday = true;
		saturdayHour = 12;
		saturdayMinute = 0;
		
		enableSunday = true;
		sundayHour = 12;
		sundayMinute = 0;

		JsonObject jsonObject = setJsonObject(new JsonObject());

		if(!fileSrc.exists() || fileSrc.length() <= 2) {
			save(fileSrc, jsonObject);
		} else {
			load(fileSrc);
		}
		
		file = fileSrc;
		object = jsonObject;

	}
	
	public static void save(File fileSrc, JsonObject object) {
		try {
			FileWriter file = new FileWriter(fileSrc);
			setJsonObject(object);
			file.write(new GsonBuilder().setPrettyPrinting().create().toJson(object));
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load(File fileSrc) {
		JsonParser parser = new JsonParser();
		try {
			Object obj = parser.parse(new FileReader(fileSrc));
			JsonObject jsonObjectRead = (JsonObject) obj;
			
			serverLang = jsonObjectRead.get("serverLang").getAsString();
			
			disableUpdateCheck = jsonObjectRead.get("disableUpdateCheck").getAsBoolean();
			
			enableMonday = jsonObjectRead.get("enableMonday").getAsBoolean();
			mondayHour = jsonObjectRead.get("mondayHour").getAsInt();
			mondayMinute = jsonObjectRead.get("mondayMinute").getAsInt();
			
			enableTuesday = jsonObjectRead.get("enableTuesday").getAsBoolean();
			tuesdayHour = jsonObjectRead.get("tuesdayHour").getAsInt();
			tuesdayMinute = jsonObjectRead.get("tuesdayMinute").getAsInt();
			
			enableWednesday = jsonObjectRead.get("enableWednesday").getAsBoolean();
			wednesdayHour = jsonObjectRead.get("wednesdayHour").getAsInt();
			wednesdayMinute = jsonObjectRead.get("wednesdayMinute").getAsInt();
			
			enableThursday = jsonObjectRead.get("enableThursday").getAsBoolean();
			thursdayHour = jsonObjectRead.get("thursdayHour").getAsInt();
			thursdayMinute = jsonObjectRead.get("thursdayMinute").getAsInt();
			
			enableFriday = jsonObjectRead.get("enableFriday").getAsBoolean();
			fridayHour = jsonObjectRead.get("fridayHour").getAsInt();
			fridayMinute = jsonObjectRead.get("fridayMinute").getAsInt();
			
			enableSaturday = jsonObjectRead.get("enableSaturday").getAsBoolean();
			saturdayHour = jsonObjectRead.get("saturdayHour").getAsInt();
			saturdayMinute = jsonObjectRead.get("saturdayMinute").getAsInt();
			
			enableSunday = jsonObjectRead.get("enableSunday").getAsBoolean();
			sundayHour = jsonObjectRead.get("sundayHour").getAsInt();
			sundayMinute = jsonObjectRead.get("sundayMinute").getAsInt();
			
			if(mondayHour < 0) {
				mondayHour = 0;
			} else if(mondayHour > 23) {
				mondayHour = 23;
			}
			
			if(mondayMinute < 0) {
				mondayMinute = 0;
			} else if(mondayMinute > 59) {
				mondayMinute = 59;
			}
			
			if(tuesdayHour < 0) {
				tuesdayHour = 0;
			} else if(tuesdayHour > 23) {
				tuesdayHour = 23;
			}
			
			if(tuesdayMinute < 0) {
				tuesdayMinute = 0;
			} else if(tuesdayMinute > 59) {
				tuesdayMinute = 59;
			}
			
			if(wednesdayHour < 0) {
				wednesdayHour = 0;
			} else if(wednesdayHour > 23) {
				wednesdayHour = 23;
			}
			
			if(wednesdayMinute < 0) {
				wednesdayMinute = 0;
			} else if(wednesdayMinute > 59) {
				wednesdayMinute = 59;
			}
			
			if(thursdayHour < 0) {
				thursdayHour = 0;
			} else if(thursdayHour > 23) {
				thursdayHour = 23;
			}
			
			if(thursdayMinute < 0) {
				thursdayMinute = 0;
			} else if(thursdayMinute > 59) {
				thursdayMinute = 59;
			}
			
			if(fridayHour < 0) {
				fridayHour = 0;
			} else if(fridayHour > 23) {
				fridayHour = 23;
			}
			
			if(fridayMinute < 0) {
				fridayMinute = 0;
			} else if(fridayMinute > 59) {
				fridayMinute = 59;
			}
			
			if(saturdayHour < 0) {
				saturdayHour = 0;
			} else if(saturdayHour > 23) {
				saturdayHour = 23;
			}
			
			if(saturdayMinute < 0) {
				saturdayMinute = 0;
			} else if(saturdayMinute > 59) {
				saturdayMinute = 59;
			}
			
			if(sundayHour < 0) {
				sundayHour = 0;
			} else if(sundayHour > 23) {
				sundayHour = 23;
			}
			
			if(sundayMinute < 0) {
				sundayMinute = 0;
			} else if(sundayMinute > 59) {
				sundayMinute = 59;
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static JsonObject setJsonObject(JsonObject jsonObject) {
		
		jsonObject.addProperty("serverLang", serverLang);
		
		jsonObject.addProperty("disableUpdateCheck", disableUpdateCheck);
		
		jsonObject.addProperty("enableMonday", enableMonday);
		jsonObject.addProperty("mondayHour", mondayHour);
		jsonObject.addProperty("mondayMinute", mondayMinute);
		
		jsonObject.addProperty("enableTuesday", enableTuesday);
		jsonObject.addProperty("tuesdayHour", tuesdayHour);
		jsonObject.addProperty("tuesdayMinute", tuesdayMinute);
		
		jsonObject.addProperty("enableWednesday", enableWednesday);
		jsonObject.addProperty("wednesdayHour", wednesdayHour);
		jsonObject.addProperty("wednesdayMinute", wednesdayMinute);
		
		jsonObject.addProperty("enableThursday", enableThursday);
		jsonObject.addProperty("thursdayHour", thursdayHour);
		jsonObject.addProperty("thursdayMinute", thursdayMinute);
		
		jsonObject.addProperty("enableFriday", enableFriday);
		jsonObject.addProperty("fridayHour", fridayHour);
		jsonObject.addProperty("fridayMinute", fridayMinute);
		
		jsonObject.addProperty("enableSaturday", enableSaturday);
		jsonObject.addProperty("saturdayHour", saturdayHour);
		jsonObject.addProperty("saturdayMinute", saturdayMinute);
		
		jsonObject.addProperty("enableSunday", enableSunday);
		jsonObject.addProperty("sundayHour", sundayHour);
		jsonObject.addProperty("sundayMinute", sundayMinute);
		
		return jsonObject;
	}
	
	public static File getFile() {
		return file;
	}
	
	public static JsonObject getObject() {
		return object;
	}

}
