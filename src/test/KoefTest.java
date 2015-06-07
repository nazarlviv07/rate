package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import st.FavbetKoef;
import st.BetcityKoef;
import st.FonbetKoef;
import st.Koef;

public class KoefTest {

	@Test
	public void testKoefFavbet() {
		Koef koef_favbet = new FavbetKoef();
		koef_favbet.file = "Test/koef/favBet/favbet1.html";
		try {
			koef_favbet.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		koef_favbet.getKoef();
		Assert.assertEquals(koef_favbet.name_of_command1, "Queensland Lions");
		Assert.assertEquals(koef_favbet.name_of_command2, "Logan Lightning");
		
		Assert.assertEquals(koef_favbet.name_1, 2.7f);
		Assert.assertEquals(koef_favbet.name_X, 3.4f);
		Assert.assertEquals(koef_favbet.name_2, 2.25f);
		Assert.assertEquals(koef_favbet.name_1X, 1.52f);
		Assert.assertEquals(koef_favbet.name_12, 1.25f);
		Assert.assertEquals(koef_favbet.name_X2, 1.37f);
		Assert.assertEquals(koef_favbet.name_TOTAL[0], 1.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[0], 1.09f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[0], 6.15f);
		Assert.assertEquals(koef_favbet.name_TOTAL[1], 2f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[1], 1.14f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[1], 5f);
		Assert.assertEquals(koef_favbet.name_TOTAL[2], 2.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[2], 2.4f);
		Assert.assertEquals(koef_favbet.name_TOTAL[3], 3f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[3], 1.9f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[3], 1.8f);
		Assert.assertEquals(koef_favbet.name_TOTAL[4], 3.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[4], 2.55f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[4], 1.45f);
		Assert.assertEquals(koef_favbet.name_TOTAL[5], 4f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[5], 4f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[5], 1.2f);
		Assert.assertEquals(koef_favbet.name_TOTAL[6], 4.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[6], 4.75f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[6], 1.15f);
		Assert.assertEquals(koef_favbet.name_TOTAL[7], 5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[7], 8.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[7], 1.04f);
		Assert.assertEquals(koef_favbet.name_TOTAL[8], 5.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[8], 9f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[8], 1.03f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[0], 1.22f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[0], 3.85f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[1], 1f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[1], 1.39f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[1], 2.77f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[2], 2.05f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[2], 1.7f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[3], 2.0f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[3], 3.2f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[3], 1.3f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[4], 2.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[4], 4f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[4], 1.2f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[5], 3.0f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[5], 7.7f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[5], 1.05f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[6], 3.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[6], 9f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[6], 1.03f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2[0], 1.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2[0], 2.1f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2[0], 1.65f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2[1], 2f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2[1], 4.75f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2[1], 1.15f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2[2], 2.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2[2], 6.15f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2[2], 1.09f);

		// Fora
		Assert.assertEquals(koef_favbet.name_FORA1[0], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[0], 2.7f);
		Assert.assertEquals(koef_favbet.name_FORA2[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[0], 1.37f);
		Assert.assertEquals(koef_favbet.name_FORA1[1], -1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[1], 4.75f);
		Assert.assertEquals(koef_favbet.name_FORA2[1], 1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[1], 1.15f);
		Assert.assertEquals(koef_favbet.name_FORA1[2], -1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[2], 5.5f);
		Assert.assertEquals(koef_favbet.name_FORA2[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[2], 1.11f);
		Assert.assertEquals(koef_favbet.name_FORA1[3], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[3], 2.05f);
		Assert.assertEquals(koef_favbet.name_FORA2[3], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[3], 1.7f);
		Assert.assertEquals(koef_favbet.name_FORA1[4], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[4], 1.52f);
		Assert.assertEquals(koef_favbet.name_FORA2[4], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[4], 2.25f);
		Assert.assertEquals(koef_favbet.name_FORA1[5], 1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[5], 1.18f);
		Assert.assertEquals(koef_favbet.name_FORA2[5], -1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[5], 4.3f);
		Assert.assertEquals(koef_favbet.name_FORA1[6], 1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[6], 1.11f);
		Assert.assertEquals(koef_favbet.name_FORA2[6], -1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[6], 5.5f);
		
		Assert.assertEquals(koef_favbet.name_total_parnuy_ni, 1.83f);
		Assert.assertEquals(koef_favbet.name_total_parnuy_tak, 1.87f);
		
		Assert.assertEquals(koef_favbet.name_dvi_komandu_zabjytj_ni, 3.85f);
		Assert.assertEquals(koef_favbet.name_dvi_komandu_zabjytj_tak, 1.22f);
		
		
		// Perwuy time

		koef_favbet.file = "Test/koef/favBet/favbet2.html";
		try {
			koef_favbet.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		koef_favbet.getKoef();

		Assert.assertEquals(koef_favbet.name_of_command1, "Sydney Olympic");
		Assert.assertEquals(koef_favbet.name_of_command2, "Parramatta Eagles");
		
		Assert.assertEquals(koef_favbet.name_1_perwuy, 2.15f);
		Assert.assertEquals(koef_favbet.name_X_perwuy, 1.9f);
		Assert.assertEquals(koef_favbet.name_2_perwuy, 7.5f);
		Assert.assertEquals(koef_favbet.name_1X_perwuy, 1.01f);
		Assert.assertEquals(koef_favbet.name_12_perwuy, 1.69f);
		Assert.assertEquals(koef_favbet.name_X2_perwuy, 1.53f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[0], 1.55f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[0], 2.3f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[1], 1f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[1], 2.45f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[1], 1.49f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[2], 3.65f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[2], 1.24f);
		
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1_perwuy[0],
				1.87f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1_perwuy[0],
				1.83f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2_perwuy[0],
				3.9f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2_perwuy[0],
				1.21f);

		// Fora
		Assert.assertEquals(koef_favbet.name_FORA1_perwuy[0], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1_perwuy[0], 2.15f);
		Assert.assertEquals(koef_favbet.name_FORA2_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2_perwuy[0], 1.53f);
		Assert.assertEquals(koef_favbet.name_FORA1_perwuy[1], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1_perwuy[1], 1.19f);
		Assert.assertEquals(koef_favbet.name_FORA2_perwuy[1], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2_perwuy[1], 4.15f);
	}

	@Test
	public void testKoefFonbet() {
		Koef koef_fonbet = new FonbetKoef();
		koef_fonbet.file = "Test/koef/fonbet/fonbet1.html";
		((FonbetKoef) koef_fonbet).num_of_event = 4327333;
		try {
			koef_fonbet.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		koef_fonbet.getKoef();
		
		Assert.assertEquals(koef_fonbet.name_of_command1, "Gerena");
		Assert.assertEquals(koef_fonbet.name_of_command2, "San Juan");
		
		Assert.assertEquals(koef_fonbet.name_1, 2f);
		Assert.assertEquals(koef_fonbet.name_X, 3.05f);
		Assert.assertEquals(koef_fonbet.name_2, 3.95f);
		Assert.assertEquals(koef_fonbet.name_1X, 1.20f);
		Assert.assertEquals(koef_fonbet.name_12, 1.33f);
		Assert.assertEquals(koef_fonbet.name_X2, 1.72f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[0], 1.6f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[0], 2.2f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[1], 0.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[1], 1.11f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[1], 5.6f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[2], 2.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[2], 2.80f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[2], 1.38f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[3], 3.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[3], 5.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[3], 1.11f);
		
		// Ind Total
		Assert.assertEquals(koef_fonbet.name_IndTotalOfCommand1[0], 2.5f);
		Assert.assertEquals(koef_fonbet.name_IndTotalBilweOfCommand1[0], 6.10f);
		Assert.assertEquals(koef_fonbet.name_IndTotalMenweOfCommand1[0], 1.09f);
		Assert.assertEquals(koef_fonbet.name_IndTotalOfCommand1[1], 1.5f);
		Assert.assertEquals(koef_fonbet.name_IndTotalBilweOfCommand1[1], 2.70f);
		Assert.assertEquals(koef_fonbet.name_IndTotalMenweOfCommand1[1], 1.40f);
		Assert.assertEquals(koef_fonbet.name_IndTotalOfCommand2[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_IndTotalBilweOfCommand2[0], 4.6f);
		Assert.assertEquals(koef_fonbet.name_IndTotalMenweOfCommand2[0], 1.16f);

		// Fora
		Assert.assertEquals(koef_fonbet.name_FORA1[0], -1.5f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA1[0], 5.20f);
		Assert.assertEquals(koef_fonbet.name_FORA2[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA2[0], 1.12f);
		Assert.assertEquals(koef_fonbet.name_FORA1[1], 0f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA1[1], 1.40f);
		Assert.assertEquals(koef_fonbet.name_FORA2[1], 0f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA2[1], 2.75f);

		Assert.assertEquals(koef_fonbet.name_perwa_komanda_zabje_tak, 1.52f);
		Assert.assertEquals(koef_fonbet.name_perwa_komanda_zabje_ni, 2.35f);
		Assert.assertEquals(koef_fonbet.name_dryga_komanda_zabje_tak, 2.15f);
		Assert.assertEquals(koef_fonbet.name_dryga_komanda_zabje_ni, 1.63f);
		Assert.assertEquals(koef_fonbet.name_dvi_komandu_zabjytj_tak, 3.20f);
		Assert.assertEquals(koef_fonbet.name_dvi_komandu_zabjytj_ni, 1.30f);
		Assert.assertEquals(koef_fonbet.name_total_parnuy_tak, 1.75f);
		Assert.assertEquals(koef_fonbet.name_total_parnuy_ni, 1.95f);
		Assert.assertEquals(koef_fonbet.name_nastypnuy_gol_perwa_komanda, 1.85f);
		Assert.assertEquals(koef_fonbet.name_nastypnuy_gol_dryga_komanda, 3.20f);
		Assert.assertEquals(koef_fonbet.name_nastypnuy_gol_nixto, 3.85f);
		Assert.assertEquals(koef_fonbet.name_time_match_P1_P1, 9.00f);
		Assert.assertEquals(koef_fonbet.name_time_match_P1_N, 25.00f);
		Assert.assertEquals(koef_fonbet.name_time_match_N_P1, 2.80f);
		Assert.assertEquals(koef_fonbet.name_time_match_N_N, 2.60f);
		Assert.assertEquals(koef_fonbet.name_time_match_N_P2, 6.00f);
		Assert.assertEquals(koef_fonbet.name_time_match_P2_N, 25.00f);
		Assert.assertEquals(koef_fonbet.name_time_match_P2_P2 , 19.00f);
		
		// Perwuy time

		Assert.assertEquals(koef_fonbet.name_1_perwuy, 6.60f);
		Assert.assertEquals(koef_fonbet.name_X_perwuy, 1.17f);
		Assert.assertEquals(koef_fonbet.name_2_perwuy, 11.50f);
		Assert.assertEquals(koef_fonbet.name_1X_perwuy, 1.01f);
		Assert.assertEquals(koef_fonbet.name_12_perwuy, 4.40f);
		Assert.assertEquals(koef_fonbet.name_X2_perwuy, 1.08f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_perwuy[0], 0.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe_perwuy[0], 4.15f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe_perwuy[0], 1.19f);

		// Fora
		Assert.assertEquals(koef_fonbet.name_FORA1_perwuy[0], 0f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA1_perwuy[0], 1.50f);
		Assert.assertEquals(koef_fonbet.name_FORA2_perwuy[0], 0f);
		Assert.assertEquals(koef_fonbet.name_koef_for_FORA2_perwuy[0], 2.45f);
		
		Assert.assertEquals(koef_fonbet.name_perwa_komanda_zabje_tak_perwuy, 5.90f);
		Assert.assertEquals(koef_fonbet.name_perwa_komanda_zabje_ni_perwuy, 1.10f);
		Assert.assertEquals(koef_fonbet.name_dryga_komanda_zabje_tak_perwuy, 8.50f);
		Assert.assertEquals(koef_fonbet.name_dryga_komanda_zabje_ni_perwuy, 1.05f);

	}

	@Test
	public void testKoefBetcity() throws IOException {
		Koef koef_betcity = new BetcityKoef();
		koef_betcity.file = "Test/koef/betcity/betcity1.html";
		koef_betcity.readFromFile();
		koef_betcity.getKoef();

		Assert.assertEquals(koef_betcity.name_1, 1.1f);
		Assert.assertEquals(koef_betcity.name_X, 7.94f);
		Assert.assertEquals(koef_betcity.name_2, 15.6f);
		Assert.assertEquals(koef_betcity.name_1X, 0f);
		Assert.assertEquals(koef_betcity.name_12, 1.05f);
		Assert.assertEquals(koef_betcity.name_X2, 5.7f);
		// Total
		Assert.assertEquals(koef_betcity.name_TOTAL[0], 2.5f);
		Assert.assertEquals(koef_betcity.name_TOTAL_bilwe[0], 1.8f);
		Assert.assertEquals(koef_betcity.name_TOTAL_menwe[0], 1.9f);
		Assert.assertEquals(koef_betcity.name_TOTAL[1], 3.5f);
		Assert.assertEquals(koef_betcity.name_TOTAL_bilwe[1], 3.46f);
		Assert.assertEquals(koef_betcity.name_TOTAL_menwe[1], 1.26f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand1[0], 1.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand1[0], 1.29f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand1[0], 3.25f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand1[1], 2.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand1[1], 2.43f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand1[1], 1.49f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand1[2], 3.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand1[2], 5.63f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand1[2], 1.11f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand2[0], 0.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand2[0], 2.63f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand2[0], 1.43f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand2[1], 1.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand2[1], 10.3f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand2[1], 1.02f);

		// Fora

		Assert.assertEquals(koef_betcity.name_FORA1[2], -2.5f);
		Assert.assertEquals(koef_betcity.name_koef_for_FORA1[2], 2.92f);
		Assert.assertEquals(koef_betcity.name_FORA2[2], 2.5f);
		Assert.assertEquals(koef_betcity.name_koef_for_FORA2[2], 1.35f);
		Assert.assertEquals(koef_betcity.name_FORA1[3], -1.5f);
		Assert.assertEquals(koef_betcity.name_koef_for_FORA1[3], 1.52f);
		Assert.assertEquals(koef_betcity.name_FORA2[3], 1.5f);
		Assert.assertEquals(koef_betcity.name_koef_for_FORA2[3], 2.35f);

		// dotatkovuy test induvidyalnogo totaly
		koef_betcity.file = "Test/koef/betcity/betcity2.html";
		koef_betcity.readFromFile();
		koef_betcity.getKoef();

		// Ind Total

		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand1[0], 3.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand1[0], 2.95f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand1[0], 1.02f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand1[1], 0f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand1[1], 0f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand1[1], 0f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand2[0], 0.5f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand2[0], 4.33f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand2[0], 3.67f);
		Assert.assertEquals(koef_betcity.name_IndTotalOfCommand2[1], 0f);
		Assert.assertEquals(koef_betcity.name_IndTotalBilweOfCommand2[1], 0f);
		Assert.assertEquals(koef_betcity.name_IndTotalMenweOfCommand2[1], 0f);
	}

}
