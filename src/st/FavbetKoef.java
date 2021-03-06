package st;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class FavbetKoef extends Koef {

	public FavbetKoef() {
		file = "favbet.html";
		link_to_download_file = "https://www.favbet.com/live/markets/event/";
		name_of_kontora = "favbet";
	}

	public String getKoef() {

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
			return "Немає коефіцієнтів";
		String nameOfTeams = jsonObject.getString("event_name");
		int lastIndex = nameOfTeams.lastIndexOf(" - ");
		name_of_command1 = nameOfTeams.substring(0, lastIndex);
		name_of_command2 = nameOfTeams.substring(lastIndex + 3);

		String eventResultTotal = jsonObject.getString("event_result_total");
		if (eventResultTotal.contains("(")){
			lastIndex = eventResultTotal.lastIndexOf("(");
			event_result = eventResultTotal.substring(0, lastIndex - 1);
		}else{
			event_result = eventResultTotal;
		}
		
		
		JsonArray jsArrOutComes;

		JsonObject jsObjHeadMarket = jsonObject.getJsonObject("head_market");
		if (!jsObjHeadMarket.isEmpty()) {

			jsArrOutComes = jsObjHeadMarket.getJsonArray("outcomes");

			for (int i = 0; i < jsArrOutComes.size(); i++) {
				if (jsArrOutComes.getJsonObject(i).getString("outcome_visible")
						.equals("yes")) {

					if (jsArrOutComes.getJsonObject(i)
							.getString("outcome_name").equals(name_of_command1)) {

						name_1 = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonNumber("outcome_coef")
								.toString());
					} else if (jsArrOutComes.getJsonObject(i)
							.getString("outcome_name").equals("Ничья")
							|| jsArrOutComes.getJsonObject(i)
									.getString("outcome_name").equals("Draw")) {

						name_X = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonNumber("outcome_coef")
								.toString());

					} else if (jsArrOutComes.getJsonObject(i)
							.getString("outcome_name").equals(name_of_command2)) {

						name_2 = Float.parseFloat(jsArrOutComes
								.getJsonObject(i).getJsonNumber("outcome_coef")
								.toString());
					}
				}
			}
		}
		JsonArray jsArrResultTypes = jsonObject.getJsonArray("result_types");
		if (!jsArrResultTypes.isEmpty()) {
			jsArrResultTypes.getJsonObject(0).getString("result_type_name");

			for (int i = 0; i < jsArrResultTypes.size(); i++) {
				if (jsArrResultTypes.getJsonObject(i)
						.getString("result_type_name").equals("Основное время")
						|| jsArrResultTypes.getJsonObject(i)
								.getString("result_type_name")
								.equals("Full Time")) {
					JsonArray jsArrMarketGroups = jsArrResultTypes
							.getJsonObject(i).getJsonArray("market_groups");

					for (int j = 0; j < jsArrMarketGroups.size(); j++) {

						if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name")
								.equals("Двойной исход")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Double chance")) {
							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");
							if (!jsArrMarkets.isEmpty()) {
								jsArrOutComes = jsArrMarkets.getJsonObject(0)
										.getJsonArray("outcomes");
								for (int z = 0; z < jsArrOutComes.size(); z++) {

									if (jsArrOutComes.getJsonObject(z)
											.getString("outcome_visible")
											.equals("yes")) {

										if (jsArrOutComes.getJsonObject(z)
												.getString("outcome_name")
												.equals("1X")) {

											name_1X = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals("12")) {

											name_12 = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals("X2")) {

											name_X2 = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										}
									}
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Фора")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Handicap")) {
							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									name_FORA1[z] = cutInsideBrackets(temp_string);

									name_koef_for_FORA1[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(0)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {
									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();
									name_FORA2[z] = cutInsideBrackets(temp_string);
									name_koef_for_FORA2[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(1)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Тотал")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Over/Under")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									name_TOTAL[z] = cutInsideBrackets(temp_string);

									name_TOTAL_bilwe[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(0)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {
									name_TOTAL_menwe[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(1)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}
							}

						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name")
								.equals("Обе команды забьют")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Both Teams to Score")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Да")
											|| temp_string.equals("Yes")) {
										name_dvi_komandu_zabjytj_tak = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Нет")
											|| temp_string.equals("No")) {
										name_dvi_komandu_zabjytj_ni = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Нечет / Чёт")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Odd / Even")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Нечет")
											|| temp_string.equals("Odd")) {
										name_total_parnuy_ni = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Чет")
											|| temp_string.equals("Even")) {
										name_total_parnuy_tak = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name")
								.equals("Индивидуальный тотал")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Team total")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							int num_com1 = 0;
							int num_com2 = 0;

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.endsWith(name_of_command1)) {
										name_IndTotalOfCommand1[num_com1] = cutInsideBrackets(temp_string);

										name_IndTotalBilweOfCommand1[num_com1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());
										num_com1 += 1;

									} else if (temp_string
											.endsWith(name_of_command2)) {
										name_IndTotalOfCommand2[num_com2] = cutInsideBrackets(temp_string);

										name_IndTotalBilweOfCommand2[num_com2] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());

										num_com2 += 1;
									}

								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.endsWith(name_of_command1)) {
										name_IndTotalOfCommand1[num_com1 - 1] = cutInsideBrackets(temp_string);

										name_IndTotalMenweOfCommand1[num_com1 - 1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());

									} else if (temp_string
											.endsWith(name_of_command2)) {
										name_IndTotalOfCommand2[num_com2 - 1] = cutInsideBrackets(temp_string);

										name_IndTotalMenweOfCommand2[num_com2 - 1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}
							}
						}
					}
				} else if (jsArrResultTypes.getJsonObject(i)
						.getString("result_type_name").equals("1 Тайм")
						|| jsArrResultTypes.getJsonObject(i)
								.getString("result_type_name")
								.equals("1st Half")) {

					JsonArray jsArrMarketGroups = jsArrResultTypes
							.getJsonObject(i).getJsonArray("market_groups");

					for (int j = 0; j < jsArrMarketGroups.size(); j++) {

						if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Победа")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Money Line")) {
							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");
							if (!jsArrMarkets.isEmpty()) {
								jsArrOutComes = jsArrMarkets.getJsonObject(0)
										.getJsonArray("outcomes");
								for (int z = 0; z < jsArrOutComes.size(); z++) {

									if (jsArrOutComes.getJsonObject(z)
											.getString("outcome_visible")
											.equals("yes")) {

										if (jsArrOutComes.getJsonObject(z)
												.getString("outcome_name")
												.equals(name_of_command1)) {

											name_1_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals("Ничья")
												|| jsArrOutComes
														.getJsonObject(z)
														.getString(
																"outcome_name")
														.equals("Draw")) {

											name_X_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals(name_of_command2)) {

											name_2_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										}
									}
								}
							}

						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name")
								.equals("Двойной исход")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Double chance")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");
							if (!jsArrMarkets.isEmpty()) {
								jsArrOutComes = jsArrMarkets.getJsonObject(0)
										.getJsonArray("outcomes");
								for (int z = 0; z < jsArrOutComes.size(); z++) {

									if (jsArrOutComes.getJsonObject(z)
											.getString("outcome_visible")
											.equals("yes")) {

										if (jsArrOutComes.getJsonObject(z)
												.getString("outcome_name")
												.equals("1X")) {

											name_1X_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals("12")) {

											name_12_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										} else if (jsArrOutComes
												.getJsonObject(z)
												.getString("outcome_name")
												.equals("X2")) {

											name_X2_perwuy = Float
													.parseFloat(jsArrOutComes
															.getJsonObject(z)
															.getJsonNumber(
																	"outcome_coef")
															.toString());
										}
									}
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Фора")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Handicap")) {
							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									name_FORA1_perwuy[z] = cutInsideBrackets(temp_string);

									name_koef_for_FORA1_perwuy[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(0)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {
									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();
									name_FORA2_perwuy[z] = cutInsideBrackets(temp_string);
									name_koef_for_FORA2_perwuy[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(1)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Тотал")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Over/Under")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									name_TOTAL_perwuy[z] = cutInsideBrackets(temp_string);

									name_TOTAL_bilwe_perwuy[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(0)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {
									name_TOTAL_menwe_perwuy[z] = Float
											.parseFloat(jsArrOutComes
													.getJsonObject(1)
													.getJsonNumber(
															"outcome_coef")
													.toString());
								}
							}

						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name").equals("Нечет / Чёт")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Odd / Even")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Нечет")
											|| temp_string.equals("Odd")) {
										name_total_parnuy_ni_perwuy = Float // ///////
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.equals("Чет")
											|| temp_string.equals("Even")) {
										name_total_parnuy_tak_perwuy = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}
							}
						} else if (jsArrMarketGroups.getJsonObject(j)
								.getString("market_name")
								.equals("Индивидуальный тотал")
								|| jsArrMarketGroups.getJsonObject(j)
										.getString("market_name")
										.equals("Team total")) {

							JsonArray jsArrMarkets = jsArrMarketGroups
									.getJsonObject(j).getJsonArray("markets");

							int num_com1 = 0;
							int num_com2 = 0;

							for (int z = 0; z < jsArrMarkets.size(); z++) {

								jsArrOutComes = jsArrMarkets.getJsonObject(z)
										.getJsonArray("outcomes");

								if (jsArrOutComes.getJsonObject(0)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(0)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.endsWith(name_of_command1)) {
										name_IndTotalOfCommand1_perwuy[num_com1] = cutInsideBrackets(temp_string);

										name_IndTotalBilweOfCommand1_perwuy[num_com1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());
										num_com1 += 1;

									} else if (temp_string
											.endsWith(name_of_command2)) {
										name_IndTotalOfCommand2_perwuy[num_com2] = cutInsideBrackets(temp_string);

										name_IndTotalBilweOfCommand2_perwuy[num_com2] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(0)
														.getJsonNumber(
																"outcome_coef")
														.toString());

										num_com2 += 1;
									}

								}

								if (jsArrOutComes.getJsonObject(1)
										.getString("outcome_visible")
										.equals("yes")) {

									String temp_string = jsArrOutComes
											.getJsonObject(1)
											.getJsonString("outcome_name")
											.getString();

									if (temp_string.endsWith(name_of_command1)) {
										name_IndTotalOfCommand1_perwuy[num_com1 - 1] = cutInsideBrackets(temp_string);

										name_IndTotalMenweOfCommand1_perwuy[num_com1 - 1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());

									} else if (temp_string
											.endsWith(name_of_command2)) {
										name_IndTotalOfCommand2_perwuy[num_com2 - 1] = cutInsideBrackets(temp_string);

										name_IndTotalMenweOfCommand2_perwuy[num_com2 - 1] = Float
												.parseFloat(jsArrOutComes
														.getJsonObject(1)
														.getJsonNumber(
																"outcome_coef")
														.toString());
									}
								}
							}
						}
					}

				}
			}
		}

		return "";
	}

	public Float cutInsideBrackets(String str) {
		int pos_start, pos_end;
		pos_start = str.indexOf("(");
		pos_end = str.indexOf(")");
		String strNew = str.substring(pos_start + 1, pos_end);
		Float tempNum = null;
		try {
			tempNum = Float.parseFloat(strNew);
		} catch (NumberFormatException e) {
			str = str.substring(pos_end + 1);
			pos_start = str.indexOf("(");
			pos_end = str.indexOf(")");
			str = str.substring(pos_start + 1, pos_end);
			tempNum = Float.parseFloat(str);
		}
		return tempNum;
	}

	// Результат без ничьи - Draw no bet
	// Кто выиграет остаток матча? - Who will win the rest of the match?

}
