package st;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import st.type.Kontora;

import java.util.ArrayList;
import java.util.List;

import st.type.Sport;

public class Events extends Koef {

	public Events() {

	}

	public List<Koef> getAllEvents(Kontora kontora, Sport kindOfSport) {
		Files files = new Files();
		
		try {
			files.downloadFile(
					kontora.getName() + "AllEvents",
					kontora.getLinkAllEvents());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream fis = null;
		List<Koef> fonbetEventsList = new ArrayList<Koef>();
		try {
			fis = new FileInputStream(kontora.getName() + "AllEvents.html");
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
						.getString().equalsIgnoreCase(kindOfSport.getString())) {
					segmentId = jsArrOutComes.getJsonObject(i).getInt("id");
				}
			}

			if (segmentId != null) {
				for (int i = 0; i < jsArrOutComes.size(); i++) {
					if (jsArrOutComes.getJsonObject(i).getJsonString("kind")
							.getString().equalsIgnoreCase("segment")) {
						if (jsArrOutComes.getJsonObject(i).getInt("parentId") == segmentId) {
							listOfSportId.add(jsArrOutComes.getJsonObject(i)
									.getInt("id"));
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
						}
					}
				}
			}
		}
		return fonbetEventsList;
	}

	public List<Koef> getAllEventsFavbet(Kontora kontora,Sport kindOfSport) {
		Files files = new Files();
		
		try {
			files.downloadFile(kontora.getName() + "AllEvents",
					kontora.getLinkAllEvents());
		} catch (IOException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream fis = null;
		List<Koef> favbetEventsList = new ArrayList<Koef>();
		try {
			fis = new FileInputStream(kontora.getName() + "AllEvents.html");
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
