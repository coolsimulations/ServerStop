package net.coolsimulations.ServerStop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ServerStopConfig {

	public static String serverLang;

	public static boolean enableMonday;
	public static int[] mondayHour;
	public static int[] mondayMinute;

	public static boolean enableTuesday;
	public static int[] tuesdayHour;
	public static int[] tuesdayMinute;

	public static boolean enableWednesday;
	public static int[] wednesdayHour;
	public static int[] wednesdayMinute;

	public static boolean enableThursday;
	public static int[] thursdayHour;
	public static int[] thursdayMinute;

	public static boolean enableFriday;
	public static int[] fridayHour;
	public static int[] fridayMinute;

	public static boolean enableSaturday;
	public static int[] saturdayHour;
	public static int[] saturdayMinute;

	public static boolean enableSunday;
	public static int[] sundayHour;
	public static int[] sundayMinute;

	public static boolean stopWhenPlayersOnline;

	public static boolean disableUpdateCheck;

	static File file;
	static JsonObject object;

	public static void init(File fileSrc) {

		JsonArray arrayHour = new JsonArray();
		JsonArray arrayMinute = new JsonArray();

		arrayHour.add(12);
		arrayMinute.add(0);

		serverLang = "en_us";

		stopWhenPlayersOnline = true;

		disableUpdateCheck = false;

		enableMonday = true;
		mondayHour = convertArrayToInteger(arrayHour);
		mondayMinute = convertArrayToInteger(arrayMinute);

		enableTuesday = true;
		tuesdayHour = convertArrayToInteger(arrayHour);
		tuesdayMinute = convertArrayToInteger(arrayMinute);

		enableWednesday = true;
		wednesdayHour = convertArrayToInteger(arrayHour);
		wednesdayMinute = convertArrayToInteger(arrayMinute);

		enableThursday = true;
		thursdayHour = convertArrayToInteger(arrayHour);
		thursdayMinute = convertArrayToInteger(arrayMinute);

		enableFriday = true;
		fridayHour = convertArrayToInteger(arrayHour);
		fridayMinute = convertArrayToInteger(arrayMinute);

		enableSaturday = true;
		saturdayHour = convertArrayToInteger(arrayHour);
		saturdayMinute = convertArrayToInteger(arrayMinute);

		enableSunday = true;
		sundayHour = convertArrayToInteger(arrayHour);
		sundayMinute = convertArrayToInteger(arrayMinute);

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

			stopWhenPlayersOnline = jsonObjectRead.get("stopWhenPlayersOnline").getAsBoolean();

			disableUpdateCheck = jsonObjectRead.get("disableUpdateCheck").getAsBoolean();

			enableMonday = jsonObjectRead.get("enableMonday").getAsBoolean();
			mondayHour = convertArrayToInteger(jsonObjectRead.get("mondayHour").getAsJsonArray());
			mondayMinute = convertArrayToInteger(jsonObjectRead.get("mondayMinute").getAsJsonArray());

			enableTuesday = jsonObjectRead.get("enableTuesday").getAsBoolean();
			tuesdayHour = convertArrayToInteger(jsonObjectRead.get("tuesdayHour").getAsJsonArray());
			tuesdayMinute = convertArrayToInteger(jsonObjectRead.get("tuesdayMinute").getAsJsonArray());

			enableWednesday = jsonObjectRead.get("enableWednesday").getAsBoolean();
			wednesdayHour = convertArrayToInteger(jsonObjectRead.get("wednesdayHour").getAsJsonArray());
			wednesdayMinute = convertArrayToInteger(jsonObjectRead.get("wednesdayMinute").getAsJsonArray());

			enableThursday = jsonObjectRead.get("enableThursday").getAsBoolean();
			thursdayHour = convertArrayToInteger(jsonObjectRead.get("thursdayHour").getAsJsonArray());
			thursdayMinute = convertArrayToInteger(jsonObjectRead.get("thursdayMinute").getAsJsonArray());

			enableFriday = jsonObjectRead.get("enableFriday").getAsBoolean();
			fridayHour = convertArrayToInteger(jsonObjectRead.get("fridayHour").getAsJsonArray());
			fridayMinute = convertArrayToInteger(jsonObjectRead.get("fridayMinute").getAsJsonArray());

			enableSaturday = jsonObjectRead.get("enableSaturday").getAsBoolean();
			saturdayHour = convertArrayToInteger(jsonObjectRead.get("saturdayHour").getAsJsonArray());
			saturdayMinute = convertArrayToInteger(jsonObjectRead.get("saturdayMinute").getAsJsonArray());

			enableSunday = jsonObjectRead.get("enableSunday").getAsBoolean();
			sundayHour = convertArrayToInteger(jsonObjectRead.get("sundayHour").getAsJsonArray());
			sundayMinute = convertArrayToInteger(jsonObjectRead.get("sundayMinute").getAsJsonArray());

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static JsonObject setJsonObject(JsonObject jsonObject) {

		jsonObject.addProperty("serverLang", serverLang);
		
		jsonObject.addProperty("stopWhenPlayersOnline", stopWhenPlayersOnline);

		jsonObject.addProperty("disableUpdateCheck", disableUpdateCheck);

		jsonObject.addProperty("enableMonday", enableMonday);
		jsonObject.add("mondayHour", convertIntegerToArray(mondayHour));
		jsonObject.add("mondayMinute", convertIntegerToArray(mondayMinute));

		jsonObject.addProperty("enableTuesday", enableTuesday);
		jsonObject.add("tuesdayHour", convertIntegerToArray(tuesdayHour));
		jsonObject.add("tuesdayMinute", convertIntegerToArray(tuesdayMinute));

		jsonObject.addProperty("enableWednesday", enableWednesday);
		jsonObject.add("wednesdayHour", convertIntegerToArray(wednesdayHour));
		jsonObject.add("wednesdayMinute", convertIntegerToArray(wednesdayMinute));

		jsonObject.addProperty("enableThursday", enableThursday);
		jsonObject.add("thursdayHour", convertIntegerToArray(thursdayHour));
		jsonObject.add("thursdayMinute", convertIntegerToArray(thursdayMinute));

		jsonObject.addProperty("enableFriday", enableFriday);
		jsonObject.add("fridayHour", convertIntegerToArray(fridayHour));
		jsonObject.add("fridayMinute", convertIntegerToArray(fridayMinute));

		jsonObject.addProperty("enableSaturday", enableSaturday);
		jsonObject.add("saturdayHour", convertIntegerToArray(saturdayHour));
		jsonObject.add("saturdayMinute", convertIntegerToArray(saturdayMinute));

		jsonObject.addProperty("enableSunday", enableSunday);
		jsonObject.add("sundayHour", convertIntegerToArray(sundayHour));
		jsonObject.add("sundayMinute", convertIntegerToArray(sundayMinute));

		return jsonObject;
	}

	private static int[] convertArrayToInteger(JsonArray array) {

		int[] integer = new int[array.size()];

		for(int i = 0; i < array.size(); i ++) {
			integer[i] = array.get(i).getAsInt();
		}

		return integer;
	}
	
	private static JsonArray convertIntegerToArray(int[] integer) {

		JsonArray array = new JsonArray();

		for(int i = 0; i < integer.length; i ++) {
			array.add(integer[i]);
		}

		return array;
	}

	public static File getFile() {
		return file;
	}

	public static JsonObject getObject() {
		return object;
	}

}
