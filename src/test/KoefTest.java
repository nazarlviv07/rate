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

		Assert.assertEquals(koef_favbet.name_1, 2.95f);
		Assert.assertEquals(koef_favbet.name_X, 1.53f);
		Assert.assertEquals(koef_favbet.name_2, 9.0f);
		Assert.assertEquals(koef_favbet.name_1X, 1.01f);
		Assert.assertEquals(koef_favbet.name_12, 2.25f);
		Assert.assertEquals(koef_favbet.name_X2, 1.32f);
		Assert.assertEquals(koef_favbet.name_TOTAL[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[0], 1.95f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[0], 1.77f);
		Assert.assertEquals(koef_favbet.name_TOTAL[1], 1f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[1], 3.75f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[1], 1.23f);
		Assert.assertEquals(koef_favbet.name_TOTAL[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[2], 5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[2], 1.14f);
		Assert.assertEquals(koef_favbet.name_TOTAL[3], 2f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe[3], 10f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe[3], 1.02f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[0], 2.37f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[0], 1.52f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[1], 1f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[1], 5.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[1], 1.11f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1[2], 7f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1[2], 1.07f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2[0], 4.45f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2[0], 1.17f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2[1], 0f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2[1], 0f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2[1], 0f);

		// Fora
		Assert.assertEquals(koef_favbet.name_FORA1[0], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[0], 2.95f);
		Assert.assertEquals(koef_favbet.name_FORA2[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[0], 1.32f);
		Assert.assertEquals(koef_favbet.name_FORA1[1], -1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[1], 6.15f);
		Assert.assertEquals(koef_favbet.name_FORA2[1], 1f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[1], 1.09f);
		Assert.assertEquals(koef_favbet.name_FORA1[2], -1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[2], 7.3f);
		Assert.assertEquals(koef_favbet.name_FORA2[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[2], 1.06f);
		Assert.assertEquals(koef_favbet.name_FORA1[3], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1[3], 1.23f);
		Assert.assertEquals(koef_favbet.name_FORA2[3], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2[3], 3.75f);
		
		Assert.assertEquals(koef_favbet.name_total_parnuy_ni, 2.45f);
		Assert.assertEquals(koef_favbet.name_total_parnuy_tak, 1.49f);
		
		Assert.assertEquals(koef_favbet.name_dvi_komandu_zabjytj_ni, 1.05f);
		Assert.assertEquals(koef_favbet.name_dvi_komandu_zabjytj_tak, 7.7f);
		
		
		// Perwuy time

		koef_favbet.file = "Test/koef/favBet/favbet2.html";
		try {
			koef_favbet.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		koef_favbet.getKoef();

		Assert.assertEquals(koef_favbet.name_1_perwuy, 4.8f);
		Assert.assertEquals(koef_favbet.name_X_perwuy, 1.31f);
		Assert.assertEquals(koef_favbet.name_2_perwuy, 6.75f);
		Assert.assertEquals(koef_favbet.name_1X_perwuy, 1.03f);
		Assert.assertEquals(koef_favbet.name_12_perwuy, 2.8f);
		Assert.assertEquals(koef_favbet.name_X2_perwuy, 1.09f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[0], 3.1f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[0], 1.32f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[1], 1f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[1], 10f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[1], 1.02f);
		Assert.assertEquals(koef_favbet.name_TOTAL_perwuy[2], 1.5f);
		Assert.assertEquals(koef_favbet.name_TOTAL_bilwe_perwuy[2], 11f);
		Assert.assertEquals(koef_favbet.name_TOTAL_menwe_perwuy[2], 1.01f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand1_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand1_perwuy[0],
				4.6f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand1_perwuy[0],
				1.16f);
		Assert.assertEquals(koef_favbet.name_IndTotalOfCommand2_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_IndTotalBilweOfCommand2_perwuy[0],
				5.85f);
		Assert.assertEquals(koef_favbet.name_IndTotalMenweOfCommand2_perwuy[0],
				1.1f);

		// Fora
		Assert.assertEquals(koef_favbet.name_FORA1_perwuy[0], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1_perwuy[0], 4.8f);
		Assert.assertEquals(koef_favbet.name_FORA2_perwuy[0], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2_perwuy[0], 1.09f);
		Assert.assertEquals(koef_favbet.name_FORA1_perwuy[1], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1_perwuy[1], 1.58f);
		Assert.assertEquals(koef_favbet.name_FORA2_perwuy[1], 0f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2_perwuy[1], 2.25f);
		Assert.assertEquals(koef_favbet.name_FORA1_perwuy[2], 0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA1_perwuy[2], 1.03f);
		Assert.assertEquals(koef_favbet.name_FORA2_perwuy[2], -0.5f);
		Assert.assertEquals(koef_favbet.name_koef_for_FORA2_perwuy[2], 6.75f);
		
		Assert.assertEquals(koef_favbet.name_total_parnuy_ni_perwuy, 3.55f);
		Assert.assertEquals(koef_favbet.name_total_parnuy_tak_perwuy, 1.25f);
	}

	@Test
	public void testKoefFonbet() {
		Koef koef_fonbet = new FonbetKoef();
		koef_fonbet.file = "Test/koef/fonbet/fonbet1.html";
		((FonbetKoef) koef_fonbet).num_of_event = 533;
		try {
			koef_fonbet.readFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		koef_fonbet.getKoef();

		Assert.assertEquals(koef_fonbet.name_1, 2.15f);
		Assert.assertEquals(koef_fonbet.name_X, 2.50f);
		Assert.assertEquals(koef_fonbet.name_2, 4.50f);
		Assert.assertEquals(koef_fonbet.name_1X, 1.16f);
		Assert.assertEquals(koef_fonbet.name_12, 1.47f);
		Assert.assertEquals(koef_fonbet.name_X2, 1.62f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[0], 2.08f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[0], 1.67f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[1], 0.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[1], 1.22f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[1], 3.85f);
		Assert.assertEquals(koef_fonbet.name_TOTAL[2], 2.5f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_bilwe[2], 4.40f);
		Assert.assertEquals(koef_fonbet.name_TOTAL_menwe[2], 1.17f);
		Assert.assertEquals(koef_fonbet.name_IndTotalOfCommand1[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_IndTotalBilweOfCommand1[0], 3.70f);
		Assert.assertEquals(koef_fonbet.name_IndTotalMenweOfCommand1[0], 1.23f);
		Assert.assertEquals(koef_fonbet.name_IndTotalOfCommand2[0], 1.5f);
		Assert.assertEquals(koef_fonbet.name_IndTotalBilweOfCommand2[0], 6.6f);
		Assert.assertEquals(koef_fonbet.name_IndTotalMenweOfCommand2[0], 1.08f);

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
