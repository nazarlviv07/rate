package st;

import java.io.IOException;

public class BetcityKoef extends Koef {
	public BetcityKoef() {
		file = "betcity.html";
		link_to_download_file = "http://www.betsbc.com/livebetssh.php?livebets[]=";
	}

	public String getKoef() {

		name_of_kontora = "Betcity";
		setKoefToZero();

		try {
			this.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ======== atribute ==============
		boolean atr_time = false;
		boolean atr_name_of_command1 = false;
		boolean atr_name_of_command2 = false;
		boolean atr_name_1 = false;
		boolean atr_name_X = false;
		boolean atr_name_2 = false;
		boolean atr_name_1X = false;
		boolean atr_name_12 = false;
		boolean atr_name_X2 = false;
		boolean atr_name_FORA1 = false;
		boolean atr_name_koef_for_FORA1 = false;
		boolean atr_name_FORA2 = false;
		boolean atr_name_koef_for_FORA2 = false;
		boolean atr_name_TOTAL = false;
		boolean atr_name_TOTAL_menwe = false;
		boolean atr_name_TOTAL_bilwe = false;

		int pos, pos_start, pos_end, pos_temp;

		String atr = new String();

		pos = strTotal.indexOf("<tr class=\"lbh\">"); // position of <tr
														// class="lbh">
		pos_end = strTotal.indexOf("</tr>", pos); // position of </tr>

		if (pos_end - pos < 10)
			return "pos=" + pos + " pos_end=" + pos_end
					+ "nemajemo informazijy v zagolovky tabluzi";

		// ===================== Vremja =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);

		atr = strTotal.substring(pos_start + 16, pos_start + 16 + 1); //

		if (atr.equals("<")) {
			atr_time = true;
			pos = pos_start + 16;
		} else
			return "Vremja";

		// ===================== Command1 =============
		pos_start = strTotal.indexOf("<td nowrap", pos);
		pos = pos_start;
		pos_start = strTotal.indexOf(">", pos);
		atr = strTotal.substring(pos_start + 8, pos_start + 15); //

		if (atr.equals("&nbsp;1")) {
			atr_name_of_command1 = true;
			pos = pos_start + 25;
		} else
			return "Command1";

		// ===================== Command2 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 18, pos_start + 25);

		if (atr.equals("&nbsp;2")) {
			atr_name_of_command2 = true;
			pos = pos_start + 25;
		} else
			return "Command2";

		// ===================== 1 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 14, pos_start + 15);
		if (atr.equals("1")) {
			atr_name_1 = true;
			pos = pos_start + 15;
		}

		// ===================== X =============
		pos_start = strTotal.indexOf("<td nowrap", pos);
		pos = pos_start;
		pos_start = strTotal.indexOf("<b>", pos);
		atr = strTotal.substring(pos_start + 3, pos_start + 4);
		if (atr.equals("X")) {
			atr_name_X = true;
			pos = pos_start + 4;
		}

		// ===================== 2 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 14, pos_start + 15);
		if (atr.equals("2")) {
			atr_name_2 = true;
			pos = pos_start + 15;
		}

		// ===================== 1X =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 11, pos_start + 13);
		if (atr.equals("1X")) {
			atr_name_1X = true;
			pos = pos_start + 13;
		}

		// ===================== 12 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 11, pos_start + 13);
		if (atr.equals("12")) {
			atr_name_12 = true;
			pos = pos_start + 13;
		}

		// ===================== X2 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 11, pos_start + 13);
		if (atr.equals("X2")) {
			atr_name_X2 = true;
			pos = pos_start + 13;
		}

		// ===================== FORA1 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 15, pos_start + 22);
		if (atr.equals("&nbsp;1")) {
			atr_name_FORA1 = true;
			pos = pos_start + 22;
		}

		// ===================== koef for FORA1 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 13, pos_start + 14);

		if (atr.equals("<")) {
			atr_name_koef_for_FORA1 = true;
			pos = pos_start + 13;
		}

		// ===================== FORA2 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 15, pos_start + 22);
		if (atr.equals("&nbsp;2")) {
			atr_name_FORA2 = true;
			pos = pos_start + 22;
		}

		// ===================== koef for FORA2 =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 13, pos_start + 14);

		if (atr.equals("<")) {
			atr_name_koef_for_FORA2 = true;
			pos = pos_start + 13;
		}

		// ===================== TOTAL =============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 16, pos_start + 17);
		if (atr.equals("<")) {
			atr_name_TOTAL = true;
			pos = pos_start + 16;
		}

		// ===================== TOTAL MENWE=============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 14, pos_start + 15);
		if (atr.equals("<")) {
			atr_name_TOTAL_menwe = true;
			pos = pos_start + 14;
		}

		// ===================== TOTAL BILWE=============
		pos_start = strTotal.indexOf("width=\"25\">", pos);
		atr = strTotal.substring(pos_start + 14, pos_start + 15);
		if (atr.equals("<")) {
			atr_name_TOTAL_bilwe = true;
			pos = pos_start + 14;
		}

		pos = strTotal.indexOf("<tr class=\"lbk\">"); // position of <tr
														// class="lbh">
		pos_end = strTotal.indexOf("</tr>", pos); // position of </tr>

		if (pos_end - pos > 10) // majemo informazijy pro koefizientu
		{
			// ===================== TIME =============

			if (atr_time == true) {
				pos_start = strTotal.indexOf("<td nowrap", pos);
				pos = pos_start + 10;
				pos_start = strTotal.indexOf(">", pos);
				atr = strTotal.substring(pos_start + 1, pos_start + 3); // hour
				hour = Integer.parseInt(atr);

				atr = strTotal.substring(pos_start + 4, pos_start + 6); // minute
				minute = Integer.parseInt(atr);
				pos = pos_start;
			}

			// ===================== Command1 =============
			if (atr_name_of_command1 == true) {
				pos_start = strTotal.indexOf("<b>", pos);
				pos_end = strTotal.indexOf("</b>", pos);
				name_of_command1 = strTotal.substring(pos_start + 3, pos_end);
				pos = pos_end;
			}

			// ===================== Command2 =============
			if (atr_name_of_command2 == true) {
				pos_start = strTotal.indexOf("<b>", pos);
				pos_end = strTotal.indexOf("</b>", pos_start);
				name_of_command2 = strTotal.substring(pos_start + 3, pos_end);
				pos = pos_end;
			}

			// ===================== 1 =============

			if (atr_name_1 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);

					name_1 = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== X =============

			if (atr_name_X == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_X = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== 2 =============
			if (atr_name_2 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_2 = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== 1X =============
			if (atr_name_1X == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_1X = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}
			// ===================== 12 =============

			if (atr_name_12 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_12 = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== X2 =============
			if (atr_name_X2 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);

				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_X2 = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== FORA1 =============
			if (atr_name_FORA1 == true) {
				pos_start = strTotal.indexOf("<td nowrap", pos);
				pos = pos_start;
				pos_start = strTotal.indexOf("<b>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;

				if (pos_end - pos_start > 7) {
					pos_start = strTotal.indexOf("<b>", pos);
					pos_end = strTotal.indexOf("</b>", pos_start);
					atr = strTotal.substring(pos_start + 3, pos_end);
					name_FORA1[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== koef for FORA1 =============
			if (atr_name_koef_for_FORA1 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_koef_for_FORA1[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

			// ===================== FORA2 =============
			if (atr_name_FORA2 == true) {
				pos_start = strTotal.indexOf("<td nowrap", pos);
				pos = pos_start;
				pos_start = strTotal.indexOf("<b>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;

				if (pos_end - pos_start > 7) {
					pos_start = strTotal.indexOf("<b>", pos);
					pos_end = strTotal.indexOf("</b>", pos_start);
					atr = strTotal.substring(pos_start + 3, pos_end);
					name_FORA2[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}
			// ===================== koef for FORA2 =============
			if (atr_name_koef_for_FORA2 == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_koef_for_FORA2[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}
			// ===================== TOTAL =============
			if (atr_name_TOTAL == true) {
				pos_start = strTotal.indexOf("<td", pos);
				pos = pos_start;
				pos_start = strTotal.indexOf("<b>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 7) {
					pos_start = strTotal.indexOf("<b>", pos);
					pos_end = strTotal.indexOf("</b>", pos_start);
					atr = strTotal.substring(pos_start + 3, pos_end);
					name_TOTAL[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}
			// ===================== TOTAL MENWE=============
			if (atr_name_TOTAL_menwe == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_TOTAL_menwe[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}
			// ===================== TOTAL BILWE=============

			if (atr_name_TOTAL_bilwe == true) {
				pos_start = strTotal.indexOf("<td>", pos);
				pos_end = strTotal.indexOf("</td>", pos_start);
				pos = pos_start;
				if (pos_end - pos_start > 5) {
					pos_start = strTotal.indexOf("underline;\">", pos);
					pos_end = strTotal.indexOf("</font>", pos_start);
					atr = strTotal.substring(pos_start + 12, pos_end);
					name_TOTAL_bilwe[0] = Float.parseFloat(atr);
				}
				pos = pos + 8;
			}

		}
		// Dodatkovi Foru

		int numFora = 1;
		while (strTotal.indexOf("Дополнительные форы:", pos) < strTotal
				.length()
				&& strTotal.indexOf("Дополнительные форы:", pos) != -1) {

			pos_start = strTotal.indexOf("Дополнительные форы:", pos);

			// name Fora1
			pos_start = strTotal.indexOf("</b>: (", pos_start) + 7;
			pos_end = strTotal.indexOf(") <", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_FORA1[numFora] = Float.parseFloat(atr);

			// koef for Fora1
			pos_start = strTotal.indexOf(">", pos) + 1;
			pos_end = strTotal.indexOf("<", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_koef_for_FORA1[numFora] = Float.parseFloat(atr);

			// name Fora2
			pos_start = strTotal.indexOf("</b>: (", pos_start) + 7;
			pos_end = strTotal.indexOf(") <", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_FORA2[numFora] = Float.parseFloat(atr);

			// koef for Fora2
			pos_start = strTotal.indexOf(">", pos) + 1;
			pos_end = strTotal.indexOf("<", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_koef_for_FORA2[numFora] = Float.parseFloat(atr);

			// takogo v prunzupi ne mogluvo bytu
			if (name_FORA1[numFora] != -name_FORA2[numFora]) {
				name_koef_for_FORA1[numFora] = 0;
				name_koef_for_FORA2[numFora] = 0;
				break;
			}

			numFora += 1;
		}

		// Dodatkovi Totalu
		int numTotal = 1;
		while (strTotal.indexOf("Дополнительные тоталы:", pos) < strTotal
				.length()
				&& strTotal.indexOf("Дополнительные тоталы:", pos) != -1) {
			pos = strTotal.indexOf("Дополнительные тоталы:", pos);

			// name Total
			pos_start = pos + 28;
			pos_end = strTotal.indexOf(")", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_TOTAL[numTotal] = Float.parseFloat(atr);

			// koef for Total menwe
			pos_start = strTotal.indexOf(">", pos) + 1;
			pos_end = strTotal.indexOf("<", pos_start);
			pos = pos_end + 5;
			atr = strTotal.substring(pos_start, pos_end);
			name_TOTAL_menwe[numTotal] = Float.parseFloat(atr);

			// koef for Total bilwe
			pos_start = strTotal.indexOf(">", pos) + 1;
			pos_end = strTotal.indexOf("<", pos_start);
			pos = pos_end;
			atr = strTotal.substring(pos_start, pos_end);
			name_TOTAL_bilwe[numTotal] = Float.parseFloat(atr);

			numTotal += 1;
			if (numTotal == maxNumOfTotal)
				break; // ne wykatu biljwe jak maxNumOfTotal Totalu
		}

		// Induvidyalni Totalu
		numTotal = 0;
		while (strTotal.indexOf("Индивидуальный тотал:", pos) < strTotal
				.length()
				&& strTotal.indexOf("Индивидуальный тотал:", pos) != -1) {
			pos = strTotal.indexOf("Индивидуальный тотал:", pos);

			// name Total
			pos += 29;

			pos_start = strTotal.indexOf(name_of_command1, pos);

			pos_temp = strTotal.indexOf(name_of_command2, pos);

			pos = strTotal.indexOf(":", pos);

			// individual total only for command2
			if (pos_temp < pos_start && pos_temp != -1) {

				// name Induvidyal Total
				pos_start = pos_temp;
				pos_start = strTotal.indexOf("(", pos);
				pos_end = strTotal.indexOf(")", pos);
				pos = pos_end;
				atr = strTotal.substring(pos_start + 1, pos_end);
				name_IndTotalOfCommand2[numTotal] = Float.parseFloat(atr);

				// koef for Total menwe
				pos_start = strTotal.indexOf(">", pos) + 1;
				pos_end = strTotal.indexOf("<", pos_start);
				pos = pos_end + 5;
				atr = strTotal.substring(pos_start, pos_end);
				name_IndTotalMenweOfCommand2[numTotal] = Float.parseFloat(atr);

				// koef for Total bilwe
				pos_start = strTotal.indexOf(">", pos) + 1;
				pos_end = strTotal.indexOf("<", pos_start);
				pos = pos_end;
				atr = strTotal.substring(pos_start, pos_end);
				name_IndTotalBilweOfCommand2[numTotal] = Float.parseFloat(atr);

			} else {

				// name Induvidyal Total
				pos_start = strTotal.indexOf("(", pos);
				pos_end = strTotal.indexOf(")", pos);
				pos = pos_end;
				atr = strTotal.substring(pos_start + 1, pos_end);
				name_IndTotalOfCommand1[numTotal] = Float.parseFloat(atr);

				// koef for Total menwe
				pos_start = strTotal.indexOf(">", pos) + 1;
				pos_end = strTotal.indexOf("<", pos_start);
				pos = pos_end + 5;
				atr = strTotal.substring(pos_start, pos_end);
				name_IndTotalMenweOfCommand1[numTotal] = Float.parseFloat(atr);

				// koef for Total bilwe
				pos_start = strTotal.indexOf(">", pos) + 1;
				pos_end = strTotal.indexOf("<", pos_start);
				pos = pos_end;
				atr = strTotal.substring(pos_start, pos_end);
				name_IndTotalBilweOfCommand1[numTotal] = Float.parseFloat(atr);

				if (pos_temp != -1 ) {
					
					if ( pos_temp < pos_end + 13){

						pos = strTotal.indexOf(":", pos_temp);
						pos_start = strTotal.indexOf("(", pos);
						pos_end = strTotal.indexOf(")", pos);
						pos = pos_end;
						atr = strTotal.substring(pos_start + 1, pos_end);
						name_IndTotalOfCommand2[numTotal] = Float
								.parseFloat(atr);

						// koef for Total menwe
						pos_start = strTotal.indexOf(">", pos) + 1;
						pos_end = strTotal.indexOf("<", pos_start);
						pos = pos_end + 5;
						atr = strTotal.substring(pos_start, pos_end);
						name_IndTotalMenweOfCommand2[numTotal] = Float
								.parseFloat(atr);

						// koef for Total bilwe
						pos_start = strTotal.indexOf(">", pos) + 1;
						pos_end = strTotal.indexOf("<", pos_start);
						pos = pos_end;
						atr = strTotal.substring(pos_start, pos_end);
						name_IndTotalBilweOfCommand2[numTotal] = Float
								.parseFloat(atr);
					}
				}
			}

			numTotal += 1;
			if (numTotal == maxNumOfTotal)
				break; // ne wykatu biljwe jak maxNumOfTotal Totalu
		}
		return "";
	}
}
