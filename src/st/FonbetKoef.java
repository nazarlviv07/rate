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

import org.json.JSONException;
import org.json.JSONObject;
public class FonbetKoef extends Koef {

	public FonbetKoef() {
		file = "fonbet.html";
		//link_to_download_file = "https://www.favbet.com/live/markets/event/";
		link_to_download_file = "http://live.fonbet.com/live/currentLine/ru/?"
				+ Math.random();
		name_of_kontora = "fonbet";
	}

	public int id = 0;
	public int id_perwuy_time = 0;
	public int num_of_event;

	public String getKoef(){

		setKoefToZero();
		InputStream fis = null;

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

		/**
		 * We can create JsonReader from Factory also JsonReaderFactory factory
		 * = Json.createReaderFactory(null); jsonReader =
		 * factory.createReader(fis);
		 */
//===============================================
	/*	JSONObject json = null;
		try {
			//json = readJsonFromUrl("https://graph.facebook.com/19292868552");
			json = readJsonFromUrl("http://live.fonbet.com/live/currentLine/ru/?0.67535345345345345345345353068247");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    System.out.println(json.toString());
	    System.out.println(json.get("id"));*/
		
		
		//=====================================================
		
		
		
		
		
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
			return "Призупинені коефіцієнти";

		JsonArray jsArrOutComes = jsonObject.getJsonArray("events");

		if (!jsArrOutComes.isEmpty()) {
			for (int i = 0; i < jsArrOutComes.size(); i++) {
				if (jsArrOutComes.getJsonObject(i).getInt("num") == num_of_event) {
					name_of_command1 = jsArrOutComes.getJsonObject(i)
							.getString("team1");
					name_of_command2 = jsArrOutComes.getJsonObject(i)
							.getString("team2");
					id = jsArrOutComes.getJsonObject(i).getInt("id");
				}
			}

			for (int i = 0; i < jsArrOutComes.size(); i++) {
				if (jsArrOutComes.getJsonObject(i).containsKey("parentId")) {
					if (jsArrOutComes.getJsonObject(i).getInt("parentId") == id) {
						if (jsArrOutComes.getJsonObject(i).getString("name")
								.equals("1-й тайм"))

							id_perwuy_time = jsArrOutComes.getJsonObject(i)
									.getInt("id");
					}
				}
			}

			if (id != 0) {
				jsArrOutComes = jsonObject.getJsonArray("eventBlocks");

				for (int i = 0; i < jsArrOutComes.size(); i++) {

					if (jsArrOutComes.getJsonObject(i).getInt("eventId") == id) {

						if (jsArrOutComes.getJsonObject(i).getString("state")
								.equals("blocked")) {
							return "Призупинені коефіцієнти";
						}
					}
				}

				jsArrOutComes = jsonObject.getJsonArray("customFactors");

				for (int i = 0; i < jsArrOutComes.size(); i++) {

					if (jsArrOutComes.getJsonObject(i).getInt("e") == id) {

						int temp = jsArrOutComes.getJsonObject(i).getInt("f");

						switch (temp) {
						case 921:
							name_1 = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 922:
							name_X = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 923:
							name_2 = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 924:
							name_1X = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 1571:
							name_12 = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 925:
							name_X2 = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonNumber("v")
									.toString());
							break;
						case 927:
							name_FORA1[0] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA1[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 928:
							name_FORA2[0] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA2[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 910:
							name_FORA1[1] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA1[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 912:
							name_FORA2[1] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA2[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 989:
							name_FORA1[2] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA1[2] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 991:
							name_FORA2[2] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA2[2] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1569:
							name_FORA1[3] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA1[3] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1572:
							name_FORA2[3] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_koef_for_FORA2[3] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 930:
							name_TOTAL[0] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_TOTAL_bilwe[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 931:
							name_TOTAL_menwe[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1696:
							name_TOTAL[1] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_TOTAL_bilwe[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1697:
							name_TOTAL_menwe[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1727:
							name_TOTAL[2] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_TOTAL_bilwe[2] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1728:
							name_TOTAL_menwe[2] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1730:
							name_TOTAL[3] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_TOTAL_bilwe[4] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1731:
							name_TOTAL_menwe[3] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1733:
							name_TOTAL[4] = Float.parseFloat(jsArrOutComes
									.getJsonObject(i).getJsonString("pt")
									.toString());
							name_TOTAL_bilwe[4] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1734:
							name_TOTAL_menwe[4] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1810:
							name_IndTotalOfCommand1[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalMenweOfCommand1[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1809:
							name_IndTotalOfCommand1[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalBilweOfCommand1[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1813:
							name_IndTotalOfCommand1[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalMenweOfCommand1[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1812:
							name_IndTotalOfCommand1[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalBilweOfCommand1[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1871:
							name_IndTotalOfCommand2[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalMenweOfCommand2[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1854:
							name_IndTotalOfCommand2[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalBilweOfCommand2[0] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1874:
							name_IndTotalOfCommand2[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalMenweOfCommand2[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 1873:
							name_IndTotalOfCommand2[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonString("pt").toString());
							name_IndTotalBilweOfCommand2[1] = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 703:
							name_perwa_komanda_zabje_ni = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 702:
							name_perwa_komanda_zabje_tak = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 699:
							name_total_parnuy_ni = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 698:
							name_total_parnuy_tak = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 706:
							name_dryga_komanda_zabje_ni = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 705:
							name_dryga_komanda_zabje_tak = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 696:
							name_dvi_komandu_zabjytj_ni = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 695:
							name_dvi_komandu_zabjytj_tak = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 2212:
							name_nastypnuy_gol_perwa_komanda = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 2213:
							name_nastypnuy_gol_dryga_komanda = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
						case 2214:
							name_nastypnuy_gol_nixto = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1007:
							name_time_match_P1_P1 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1008:
							name_time_match_P1_N = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1009:
							name_time_match_P1_P2 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1010:
							name_time_match_N_P1 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1011:
							name_time_match_N_N = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1012:
							name_time_match_N_P2 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1013:
							name_time_match_P2_P1 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1014:
							name_time_match_P2_N = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						case 1015:
							name_time_match_P2_P2 = Float
									.parseFloat(jsArrOutComes.getJsonObject(i)
											.getJsonNumber("v").toString());
							break;
							
						default:

						
							  System.out.println("f == " + temp + " v= " +
							  jsArrOutComes.getJsonObject(i)
							  .getJsonNumber("v").toString());
							 
						}
					}

				}

				jsArrOutComes = jsonObject.getJsonArray("eventBlocks");

				for (int i = 0; i < jsArrOutComes.size(); i++) {

					if (jsArrOutComes.getJsonObject(i).getInt("eventId") == id) {

						if (jsArrOutComes.getJsonObject(i).getString("state")
								.equals("partial")) {

							JsonArray jsArrFactors = jsArrOutComes
									.getJsonObject(i).getJsonArray("factors");

							for (int j = 0; j < jsArrFactors.size(); j++) {
								setPartialKoefToZero(jsArrFactors.getInt(j));
							}
						}

					}
				}
			}

			// Perwuy time

			jsArrOutComes = jsonObject.getJsonArray("eventBlocks");

			for (int i = 0; i < jsArrOutComes.size(); i++) {

				if (jsArrOutComes.getJsonObject(i).getInt("eventId") == id_perwuy_time) {

					if (jsArrOutComes.getJsonObject(i).getString("state")
							.equals("blocked")) {
						return "Призупинені коефіцієнти";
					}
				}
			}

			jsArrOutComes = jsonObject.getJsonArray("customFactors");

			for (int i = 0; i < jsArrOutComes.size(); i++) {

				if (jsArrOutComes.getJsonObject(i).getInt("e") == id_perwuy_time) {

					int temp = jsArrOutComes.getJsonObject(i).getInt("f");

					switch (temp) {
					case 921:
						name_1_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 922:
						name_X_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 923:
						name_2_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 924:
						name_1X_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1571:
						name_12_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 925:
						name_X2_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 927:
						name_FORA1_perwuy[0] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA1_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 928:
						name_FORA2_perwuy[0] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA2_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 910:
						name_FORA1_perwuy[1] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA1_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 912:
						name_FORA2_perwuy[1] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA2_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 989:
						name_FORA1_perwuy[2] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA1_perwuy[2] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 991:
						name_FORA2_perwuy[2] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA2_perwuy[2] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1569:
						name_FORA1_perwuy[3] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA1_perwuy[3] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1572:
						name_FORA2_perwuy[3] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_koef_for_FORA2_perwuy[3] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 930:
						name_TOTAL_perwuy[0] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_TOTAL_bilwe_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 931:
						name_TOTAL_menwe_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1696:
						name_TOTAL_perwuy[1] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_TOTAL_bilwe_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1697:
						name_TOTAL_menwe_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1727:
						name_TOTAL_perwuy[2] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_TOTAL_bilwe_perwuy[2] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1728:
						name_TOTAL_menwe_perwuy[2] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1730:
						name_TOTAL_perwuy[3] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_TOTAL_bilwe_perwuy[4] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1731:
						name_TOTAL_menwe_perwuy[3] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1733:
						name_TOTAL_perwuy[4] = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonString("pt")
								.toString());
						name_TOTAL_bilwe_perwuy[4] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1734:
						name_TOTAL_menwe_perwuy[4] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1810:
						name_IndTotalOfCommand1_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalMenweOfCommand1_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1809:
						name_IndTotalOfCommand1_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalBilweOfCommand1_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1813:
						name_IndTotalOfCommand1_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalMenweOfCommand1_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1812:
						name_IndTotalOfCommand1_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalBilweOfCommand1_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1871:
						name_IndTotalOfCommand2_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalMenweOfCommand2[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1854:
						name_IndTotalOfCommand2_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalBilweOfCommand2_perwuy[0] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1874:
						name_IndTotalOfCommand2_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalMenweOfCommand2_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 1873:
						name_IndTotalOfCommand2_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonString("pt").toString());
						name_IndTotalBilweOfCommand2_perwuy[1] = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 703:
						name_perwa_komanda_zabje_ni_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 702:
						name_perwa_komanda_zabje_tak_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 699:
						name_total_parnuy_ni_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 698:
						name_total_parnuy_tak_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 706:
						name_dryga_komanda_zabje_ni_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 705:
						name_dryga_komanda_zabje_tak_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 696:
						name_dvi_komandu_zabjytj_ni_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 695:
						name_dvi_komandu_zabjytj_tak_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 2212:
						name_nastypnuy_gol_perwa_komanda_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 2213:
						name_nastypnuy_gol_dryga_komanda_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					case 2214:
						name_nastypnuy_gol_nixto_perwuy = Float
								.parseFloat(jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
						break;
					default:

						System.out.println("perwuy f == "
								+ temp
								+ " v= "
								+ jsArrOutComes.getJsonObject(i)
										.getJsonNumber("v").toString());
					}
				}

			}

			jsArrOutComes = jsonObject.getJsonArray("eventBlocks");

			for (int i = 0; i < jsArrOutComes.size(); i++) {

				if (jsArrOutComes.getJsonObject(i).getInt("eventId") == id) {

					if (jsArrOutComes.getJsonObject(i).getString("state")
							.equals("partial")) {

						JsonArray jsArrFactors = jsArrOutComes.getJsonObject(i)
								.getJsonArray("factors");

						for (int j = 0; j < jsArrFactors.size(); j++) {
							setPartialKoefToZero(jsArrFactors.getInt(j));
						}
					}

				}
			}

		}

		return "";
	}

	public void setPartialKoefToZero(int numOfEvent) {
		switch (numOfEvent) {
		case 921:
			name_1 = 0;
			break;
		case 922:
			name_X = 0;
			break;
		case 923:
			name_2 = 0;
			break;
		case 924:
			name_1X = 0;
			break;
		case 1571:
			name_12 = 0;
			break;
		case 925:
			name_X2 = 0;
			break;
		case 927:
			name_FORA1[0] = 0;
			name_koef_for_FORA1[0] = 0;
			break;
		case 928:
			name_FORA2[0] = 0;
			name_koef_for_FORA2[0] = 0;
			break;
		case 910:
			name_FORA1[1] = 0;
			name_koef_for_FORA1[1] = 0;
			break;
		case 912:
			name_FORA2[1] = 0;
			break;
		case 989:
			name_FORA1[2] = 0;
			name_koef_for_FORA1[2] = 0;
			break;
		case 991:
			name_FORA2[2] = 0;
			name_koef_for_FORA2[2] = 0;
			break;
		case 1569:
			name_FORA1[3] = 0;
			name_koef_for_FORA1[3] = 0;
			break;
		case 1572:
			name_FORA2[3] = 0;
			name_koef_for_FORA2[3] = 0;
			break;
		case 930:
			name_TOTAL[0] = 0;
			name_TOTAL_bilwe[0] = 0;
			break;
		case 931:
			name_TOTAL_menwe[0] = 0;
			break;
		case 1696:
			name_TOTAL[1] = 0;
			name_TOTAL_bilwe[1] = 0;
			break;
		case 1697:
			name_TOTAL_menwe[1] = 0;
			break;
		case 1727:
			name_TOTAL[2] = 0;
			name_TOTAL_bilwe[2] = 0;
			break;
		case 1728:
			name_TOTAL_menwe[2] = 0;
			break;
		case 1730:
			name_TOTAL[3] = 0;
			name_TOTAL_bilwe[4] = 0;
			break;
		case 1731:
			name_TOTAL_menwe[3] = 0;
			break;
		case 1733:
			name_TOTAL[4] = 0;
			name_TOTAL_bilwe[4] = 0;
			break;
		case 1734:
			name_TOTAL_menwe[4] = 0;
			break;
		case 1810:
			name_IndTotalOfCommand1[0] = 0;
			name_IndTotalMenweOfCommand1[0] = 0;
			break;
		case 1809:
			name_IndTotalOfCommand1[0] = 0;
			name_IndTotalBilweOfCommand1[0] = 0;
			break;
		case 1813:
			name_IndTotalOfCommand1[1] = 0;
			name_IndTotalMenweOfCommand1[1] = 0;
			break;
		case 1812:
			name_IndTotalOfCommand1[1] = 0;
			name_IndTotalBilweOfCommand1[1] = 0;
			break;
		case 1871:
			name_IndTotalOfCommand2[0] = 0;
			name_IndTotalMenweOfCommand2[0] = 0;
			break;
		case 1854:
			name_IndTotalOfCommand2[0] = 0;
			name_IndTotalBilweOfCommand2[0] = 0;
			break;
		case 1874:
			name_IndTotalOfCommand2[1] = 0;
			name_IndTotalMenweOfCommand2[1] = 0;
			break;
		case 1873:
			name_IndTotalOfCommand2[1] = 0;
			name_IndTotalBilweOfCommand2[1] = 0;
			break;
		case 703:
			name_perwa_komanda_zabje_ni = 0;
			break;
		case 702:
			name_perwa_komanda_zabje_tak = 0;
			break;
		case 699:
			name_total_parnuy_ni = 0;
			break;
		case 698:
			name_total_parnuy_tak = 0;
			break;
		case 706:
			name_dryga_komanda_zabje_ni = 0;
			break;
		case 705:
			name_dryga_komanda_zabje_tak = 0;
			break;
		case 696:
			name_dvi_komandu_zabjytj_ni = 0;
			break;
		case 695:
			name_dvi_komandu_zabjytj_tak = 0;
			break;
		case 2212:
			name_nastypnuy_gol_perwa_komanda = 0;
			break;
		case 2213:
			name_nastypnuy_gol_dryga_komanda = 0;
			break;
		case 2214:
			name_nastypnuy_gol_nixto = 0;
			break;
		default:

			;
		}
	}

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      //BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("WINDOWS-1251")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
}
