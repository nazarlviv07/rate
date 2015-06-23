package st;

import st.type.Result;

public class Calc {

	/*
	 * public class Result { boolean fork; String nameOfKoefKontora1; float
	 * KoefKontora1; String nameOfKoefKontora2; float KoefKontora2; }
	 */

	public Calc() {
		result_value = new Result();
		result_value.fork = false;
		result_value.nameOfKoefKontora1 = "";
		result_value.nameOfKoefKontora2 = "";
		result_value.KoefKontora1 = 0;
		result_value.KoefKontora2 = 0;
	}

	Result result_value = new Result();

	Result check(float dat1, float dat2, String name_data1, String name_data2) {
		Result result_check = new Result();

		result_check.fork = false;
		if (dat1 == 0)
			return result_check;
		if (dat1 / (dat1 - 1) < dat2) {
			result_check.fork = true;
			result_check.nameOfKoefKontora1 = name_data1;
			result_check.nameOfKoefKontora2 = name_data2;
			result_check.KoefKontora1 = dat1;
			result_check.KoefKontora2 = dat2;
			return result_check;
		}

		return result_check;
	}

	public Result checkFork(Koef data1, Koef data2) {
		Result result_value = new Result();

		// 1 - X2
		result_value = check(data1.name_1, data2.name_X2, "1", "X2");
		if (result_value.fork == true)
			return result_value;

		// X2 - 1
		result_value = check(data1.name_X2, data2.name_1, "X2", "1");
		if (result_value.fork == true)
			return result_value;

		// X - 12
		result_value = check(data1.name_X, data2.name_12, "X", "12");
		if (result_value.fork == true)
			return result_value;

		// 12 - X
		result_value = check(data1.name_12, data2.name_X, "12", "X");
		if (result_value.fork == true)
			return result_value;

		// 2 - 1X
		result_value = check(data1.name_2, data2.name_1X, "2", "1X");
		if (result_value.fork == true)
			return result_value;

		// 1X - 2
		result_value = check(data1.name_1X, data2.name_2, "1X", "2");
		if (result_value.fork == true)
			return result_value;

		// kontora 1 FORA 1 kontora 2 Fora 2

		for (int i = 0; i < data1.maxNumOfFora; i++) {

			for (int j = 0; j < data2.maxNumOfFora; j++) {
				if (data1.name_FORA1[i] == -data2.name_FORA2[j]) {
					String s1 = new String();
					if (data1.name_FORA1[i] < 0) {
						s1 = "-" + String.valueOf(data2.name_FORA2[j]);
						;
					} else {
						s1 = String.valueOf(data1.name_FORA1[i]);
					}

					String s2 = new String();
					if (data2.name_FORA2[j] < 0) {
						s2 = "-" + String.valueOf(data1.name_FORA1[i]);
					} else {
						s2 = String.valueOf(data2.name_FORA2[j]);
					}

					String Fora1 = new String("FORA1 = ");
					String Fora2 = new String("FORA2 = ");

					result_value = check(data1.name_koef_for_FORA1[i],
							data2.name_koef_for_FORA2[j], Fora1 + s1, Fora2
									+ s2);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}
		// kontora 1 FORA 2 kontora 2 Fora 1

		for (int i = 0; i < data1.maxNumOfFora; i++) {
			if (data1.name_FORA2[i] == (int) (data1.name_FORA2[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfFora; j++) {
				if (data1.name_FORA2[i] == -data2.name_FORA1[j]) {
					String s1 = new String();
					if (data1.name_FORA2[i] < 0) {
						s1 = "-" + String.valueOf(data2.name_FORA1[j]);
					} else {
						s1 = String.valueOf(data1.name_FORA2[i]);
					}

					String s2 = new String();
					if (data2.name_FORA1[j] < 0) {
						s2 = "-" + String.valueOf(data1.name_FORA2[i]);
					} else {
						s2 = String.valueOf(data2.name_FORA1[j]);
					}

					String Fora1 = new String("FORA1 = ");
					String Fora2 = new String("FORA2 = ");

					result_value = check(data1.name_koef_for_FORA2[i],
							data2.name_koef_for_FORA1[j], Fora2 + s1, Fora1
									+ s2);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}
		// Zagaljnuy Total

		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			// if (data1.name_TOTAL[i] == (int) (data1.name_TOTAL[i]))
			// continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_TOTAL[i] == data2.name_TOTAL[j]) {
					String Total = new String("Total = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_TOTAL[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_TOTAL_menwe[i],
							data2.name_TOTAL_bilwe[j], Total + s + Menwe, Total
									+ s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_TOTAL_bilwe[i],
							data2.name_TOTAL_menwe[j], Total + s + Bilwe, Total
									+ s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		// Induvidyaljnuy Total Command1
		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			if (data1.name_IndTotalOfCommand1[i] == (int) (data1.name_IndTotalOfCommand1[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_IndTotalOfCommand1[i] == data2.name_IndTotalOfCommand1[j]) {
					String Total = new String("Ind Total Com1 = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_IndTotalOfCommand1[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_IndTotalMenweOfCommand1[i],
							data2.name_IndTotalBilweOfCommand1[j], Total + s
									+ Menwe, Total + s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_IndTotalBilweOfCommand1[i],
							data2.name_IndTotalMenweOfCommand1[j], Total + s
									+ Bilwe, Total + s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		// Induvidyaljnuy Total Command2
		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			if (data1.name_IndTotalOfCommand2[i] == (int) (data1.name_IndTotalOfCommand2[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_IndTotalOfCommand2[i] == data2.name_IndTotalOfCommand2[j]) {
					String Total = new String("Ind Total Com2 = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_IndTotalOfCommand2[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_IndTotalMenweOfCommand2[i],
							data2.name_IndTotalBilweOfCommand2[j], Total + s
									+ Menwe, Total + s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_IndTotalBilweOfCommand2[i],
							data2.name_IndTotalMenweOfCommand2[j], Total + s
									+ Bilwe, Total + s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		// Perwuy taym

		// 1_perwuy - X2_perwuy
		result_value = check(data1.name_1_perwuy, data2.name_X2_perwuy,
				"1_perwuy", "X2_perwuy");
		if (result_value.fork == true)
			return result_value;

		// X2_perwuy - 1_perwuy
		result_value = check(data1.name_X2_perwuy, data2.name_1_perwuy, "X2_perwuy", "1_perwuy");
		if (result_value.fork == true)
			return result_value;

		// X_perwuy - 12_perwuy
		result_value = check(data1.name_X_perwuy, data2.name_12_perwuy, "X_perwuy", "12_perwuy");
		if (result_value.fork == true)
			return result_value;

		// 12_perwuy - X_perwuy
		result_value = check(data1.name_12_perwuy, data2.name_X_perwuy, "12_perwuy", "X_perwuy");
		if (result_value.fork == true)
			return result_value;

		// 2_perwuy - 1X_perwuy
		result_value = check(data1.name_2_perwuy, data2.name_1X_perwuy, "2_perwuy", "1X_perwuy");
		if (result_value.fork == true)
			return result_value;

		// 1X_perwuy - 2_perwuy
		result_value = check(data1.name_1X_perwuy, data2.name_2_perwuy, "1X_perwuy", "2_perwuy");
		if (result_value.fork == true)
			return result_value;

		// kontora 1 FORA 1_perwuy    kontora 2 Fora 2_perwuy

		for (int i = 0; i < data1.maxNumOfFora; i++) {

			for (int j = 0; j < data2.maxNumOfFora; j++) {
				if (data1.name_FORA1_perwuy[i] == -data2.name_FORA2_perwuy[j]) {
					String s1 = new String();
					if (data1.name_FORA1_perwuy[i] < 0) {
						s1 = "-" + String.valueOf(data2.name_FORA2_perwuy[j]);
						;
					} else {
						s1 = String.valueOf(data1.name_FORA1_perwuy[i]);
					}

					String s2 = new String();
					if (data2.name_FORA2_perwuy[j] < 0) {
						s2 = "-" + String.valueOf(data1.name_FORA1_perwuy[i]);
					} else {
						s2 = String.valueOf(data2.name_FORA2_perwuy[j]);
					}

					String Fora1 = new String("FORA1_perwuy = ");
					String Fora2 = new String("FORA2_perwuy = ");

					result_value = check(data1.name_koef_for_FORA1_perwuy[i],
							data2.name_koef_for_FORA2_perwuy[j], Fora1 + s1, Fora2
									+ s2);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}
		// kontora 1 FORA 2_perwuy    kontora 2 Fora 1_perwuy

		for (int i = 0; i < data1.maxNumOfFora; i++) {
			if (data1.name_FORA2_perwuy[i] == (int) (data1.name_FORA2_perwuy[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfFora; j++) {
				if (data1.name_FORA2_perwuy[i] == -data2.name_FORA1_perwuy[j]) {
					String s1 = new String();
					if (data1.name_FORA2_perwuy[i] < 0) {
						s1 = "-" + String.valueOf(data2.name_FORA1_perwuy[j]);
					} else {
						s1 = String.valueOf(data1.name_FORA2_perwuy[i]);
					}

					String s2 = new String();
					if (data2.name_FORA1_perwuy[j] < 0) {
						s2 = "-" + String.valueOf(data1.name_FORA2_perwuy[i]);
					} else {
						s2 = String.valueOf(data2.name_FORA1_perwuy[j]);
					}

					String Fora1 = new String("FORA1_perwuy = ");
					String Fora2 = new String("FORA2_perwuy = ");

					result_value = check(data1.name_koef_for_FORA2_perwuy[i],
							data2.name_koef_for_FORA1_perwuy[j], Fora2 + s1, Fora1
									+ s2);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}
		// Zagaljnuy Total

		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			// if (data1.name_TOTAL[i] == (int) (data1.name_TOTAL[i]))
			// continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_TOTAL_perwuy[i] == data2.name_TOTAL_perwuy[j]) {
					String Total = new String("Total_perwuy = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_TOTAL_perwuy[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_TOTAL_menwe_perwuy[i],
							data2.name_TOTAL_bilwe_perwuy[j], Total + s + Menwe, Total
									+ s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_TOTAL_bilwe_perwuy[i],
							data2.name_TOTAL_menwe_perwuy[j], Total + s + Bilwe, Total
									+ s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		// Induvidyaljnuy Total Command1
		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			if (data1.name_IndTotalOfCommand1_perwuy[i] == (int) (data1.name_IndTotalOfCommand1_perwuy[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_IndTotalOfCommand1_perwuy[i] == data2.name_IndTotalOfCommand1_perwuy[j]) {
					String Total = new String("Ind Total Com1_perwuy = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_IndTotalOfCommand1_perwuy[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_IndTotalMenweOfCommand1_perwuy[i],
							data2.name_IndTotalBilweOfCommand1_perwuy[j], Total + s
									+ Menwe, Total + s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_IndTotalBilweOfCommand1_perwuy[i],
							data2.name_IndTotalMenweOfCommand1_perwuy[j], Total + s
									+ Bilwe, Total + s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		// Induvidyaljnuy Total Command2
		for (int i = 0; i < data1.maxNumOfTotal; i++) {
			if (data1.name_IndTotalOfCommand2_perwuy[i] == (int) (data1.name_IndTotalOfCommand2_perwuy[i]))
				continue;

			for (int j = 0; j < data2.maxNumOfTotal; j++) {
				if (data1.name_IndTotalOfCommand2_perwuy[i] == data2.name_IndTotalOfCommand2_perwuy[j]) {
					String Total = new String("Ind Total Com2_perwuy = ");
					String Bilwe = new String(" Bilwe");
					String Menwe = new String(" Menwe");

					String s = new String();
					s = String.valueOf(data1.name_IndTotalOfCommand2_perwuy[i]);
					// kontora 1 Total menwe kontora 2 Total biljwe

					result_value = check(data1.name_IndTotalMenweOfCommand2_perwuy[i],
							data2.name_IndTotalBilweOfCommand2_perwuy[j], Total + s
									+ Menwe, Total + s + Bilwe);
					if (result_value.fork == true)
						return result_value;

					// kontora 1 Total biljwe kontora 2 Total menwe

					result_value = check(data1.name_IndTotalBilweOfCommand2_perwuy[i],
							data2.name_IndTotalMenweOfCommand2_perwuy[j], Total + s
									+ Bilwe, Total + s + Menwe);
					if (result_value.fork == true)
						return result_value;
				}
			}
		}

		result_value.fork = false;
		return result_value;
	}
}