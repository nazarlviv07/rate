package st;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

//==============================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Events extends Koef {

	public Events() {

		file = "fonbet.html";
		// link_to_download_file = "https://www.favbet.com/live/markets/event/";
		// link_to_download_file =
		// "http://live.fonbet.com/live/currentLine/ru/?"
		link_to_download_file = "http://live.fonbet.com/live/currentLine/en/?"
				+ Math.random();
		name_of_kontora = "fonbet";
	}

	public List<Koef> getAllEvents(String kindOfSport) {
		Files files = new Files();
		try {
			files.downloadFile(
					"fonbet",
					"http://live.fonbet.com/live/currentLine/en/?"
							+ Math.random());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream fis = null;
		List<Koef> fonbetEventsList = new ArrayList<Koef>();
		try {
			fis = new FileInputStream(file);
			// fis = new FileInputStream(JSON_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			// return 1;
		}

		// create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);

		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();

		// we can close IO resource and JsonReader now
		jsonReader.close();
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Retrieve data from JsonObject

		if (jsonObject.isEmpty())
			return null;

		JsonArray jsArrOutComes = jsonObject.getJsonArray("sports");
		Integer segmentId = null;
		Integer evendId = null;

		List<Integer> listOfSportId = new ArrayList<Integer>();

		if (!jsArrOutComes.isEmpty()) {
			for (int i = 0; i < jsArrOutComes.size(); i++) {
				if (jsArrOutComes.getJsonObject(i).getJsonString("name")
						.getString().equalsIgnoreCase(kindOfSport)) {
					segmentId = jsArrOutComes.getJsonObject(i).getInt("id");
					/*
					 * System.out.println(jsArrOutComes.getJsonObject(i).getInt(
					 * "id"));
					 */

				}
			}
			/* System.out.print("=================="); */
			if (segmentId != null) {
				for (int i = 0; i < jsArrOutComes.size(); i++) {
					if (jsArrOutComes.getJsonObject(i).getJsonString("kind")
							.getString().equalsIgnoreCase("segment")) {
						if (jsArrOutComes.getJsonObject(i).getInt("parentId") == segmentId) {
							listOfSportId.add(jsArrOutComes.getJsonObject(i)
									.getInt("id"));
							/*
							 * System.out.println(jsArrOutComes.getJsonObject(i)
							 * .getInt("id"));
							 */
						}
					}
				}
			}

		}

		jsArrOutComes = jsonObject.getJsonArray("events");

		if (!jsArrOutComes.isEmpty()) {
			for (int i = 0; i < jsArrOutComes.size(); i++) {

				for (int k = 0; k < listOfSportId.size(); k++) {

					if (jsArrOutComes.getJsonObject(i).getInt("sportId") == listOfSportId
							.get(k)) {
						if (jsArrOutComes.getJsonObject(i).getInt("level") == 1) {
							FonbetKoef fonbet = new FonbetKoef();
							fonbet.id = jsArrOutComes
									.getJsonObject(i).getInt("id");
							fonbet.name_of_command1 = jsArrOutComes
									.getJsonObject(i).getString("team1");
							fonbet.name_of_command2 = jsArrOutComes
									.getJsonObject(i).getString("team2");
							fonbetEventsList.add(fonbet);
							/*
							 * System.out.println(jsArrOutComes.getJsonObject(i)
							 * .getString("team1"));
							 * System.out.println(jsArrOutComes.getJsonObject(i)
							 * .getString("team2"));
							 */
						}
					}
				}
			}
		}
		return fonbetEventsList;
	}

	public List<Koef> getAllEventsFavbet(String kindOfSport) {
		Files files = new Files();

		try {
			files.downloadFile("favbetAllEvents",
					"https://www.favbet.com/live/markets/?0." + Math.random());
		} catch (IOException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream fis = null;
		List<Koef> favbetEventsList = new ArrayList<Koef>();
		try {
			fis = new FileInputStream("favbetAllEvents.html");
			// fis = new FileInputStream(JSON_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			// return 1;
		}

		// create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);

		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();

		// we can close IO resource and JsonReader now
		jsonReader.close();
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Retrieve data from JsonObject

		if (jsonObject.isEmpty())
			return null;

		/* System.exit(1); */

		JsonArray jsArrOutComes = jsonObject.getJsonArray("markets");
		Integer segmentId = null;
		Integer evendId = null;

		for (int i = 0; i < jsArrOutComes.size(); i++) {

			if (jsArrOutComes.getJsonObject(i).getString("sport_name")
					.equals("Soccer")) {

				JsonArray jsArrMarkets = jsArrOutComes.getJsonObject(i)
						.getJsonArray("tournaments");
				if (!jsArrMarkets.isEmpty()) {

					for (int j = 0; j < jsArrMarkets.size(); j++) {

						JsonArray jsArrMarkets2 = jsArrMarkets.getJsonObject(j)
								.getJsonArray("events");

						for (int k = 0; k < jsArrMarkets2.size(); k++) {

							FavbetKoef favbet = new FavbetKoef();

							favbet.id = jsArrMarkets2.getJsonObject(k).getJsonNumber("event_id").intValue();
							String nameOfTeams = jsArrMarkets2.getJsonObject(k)
									.getJsonString("event_name").getString();

							int lastIndex = nameOfTeams.lastIndexOf(" - ");
							favbet.name_of_command1 = nameOfTeams.substring(0,
									lastIndex);
							favbet.name_of_command2 = nameOfTeams
									.substring(lastIndex + 3);

							favbetEventsList.add(favbet);
						}
					}
				}
			}
		}

		return favbetEventsList;
	}

}
