package st;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class Koef {

	public String name_of_kontora = new String();
	public String link_to_download_file = new String();
	public String strTotal = new String();
	public String file = new String();
	public int maxNumOfFora = 20;
	public int maxNumOfTotal = 20;
	public int maxNumOfIndTotal = 20;
	public int hour;
	public int minute;
	public String name_of_command1 = new String();
	public String name_of_command2 = new String();
	public float name_1;
	public float name_X;
	public float name_2;
	public float name_1X;
	public float name_12;
	public float name_X2;
	public float name_total_parnuy_ni;
	public float name_total_parnuy_tak;
	public float name_perwa_komanda_zabje_ni;
	public float name_perwa_komanda_zabje_tak;
	public float name_dryga_komanda_zabje_ni;
	public float name_dryga_komanda_zabje_tak;
	public float name_dvi_komandu_zabjytj_ni;
	public float name_dvi_komandu_zabjytj_tak;
	public float name_nastypnuy_gol_perwa_komanda;
	public float name_nastypnuy_gol_dryga_komanda;
	public float name_nastypnuy_gol_nixto;
	public float[] name_FORA1 = new float[maxNumOfFora];
	public float[] name_FORA2 = new float[maxNumOfFora];
	public float[] name_koef_for_FORA1 = new float[maxNumOfFora];
	public float[] name_koef_for_FORA2 = new float[maxNumOfFora];
	public float[] name_TOTAL = new float[maxNumOfTotal];
	public float[] name_TOTAL_menwe = new float[maxNumOfTotal];
	public float[] name_TOTAL_bilwe = new float[maxNumOfTotal];
	public float[] name_IndTotalOfCommand1 = new float[maxNumOfIndTotal];
	public float[] name_IndTotalMenweOfCommand1 = new float[maxNumOfIndTotal];
	public float[] name_IndTotalBilweOfCommand1 = new float[maxNumOfIndTotal];
	public float[] name_IndTotalOfCommand2 = new float[maxNumOfIndTotal];
	public float[] name_IndTotalMenweOfCommand2 = new float[maxNumOfIndTotal];
	public float[] name_IndTotalBilweOfCommand2 = new float[maxNumOfIndTotal];
	public float name_time_match_P1_P1;
	public float name_time_match_P1_P2;
	public float name_time_match_P2_P1;
	public float name_time_match_P1_N;
	public float name_time_match_N_P1;
	public float name_time_match_N_N;
	public float name_time_match_N_P2;
	public float name_time_match_P2_N;
	public float name_time_match_P2_P2;

	// Перший тайм

	public float name_1_perwuy;
	public float name_X_perwuy;
	public float name_2_perwuy;
	public float name_1X_perwuy;
	public float name_12_perwuy;
	public float name_X2_perwuy;

	public float[] name_FORA1_perwuy = new float[maxNumOfFora];
	public float[] name_FORA2_perwuy = new float[maxNumOfFora];
	public float[] name_koef_for_FORA1_perwuy = new float[maxNumOfFora];
	public float[] name_koef_for_FORA2_perwuy = new float[maxNumOfFora];
	public float[] name_TOTAL_perwuy = new float[maxNumOfTotal];
	public float[] name_TOTAL_menwe_perwuy = new float[maxNumOfTotal];
	public float[] name_TOTAL_bilwe_perwuy = new float[maxNumOfTotal];
	public float[] name_IndTotalOfCommand1_perwuy = new float[maxNumOfIndTotal];
	public float[] name_IndTotalMenweOfCommand1_perwuy = new float[maxNumOfIndTotal];
	public float[] name_IndTotalBilweOfCommand1_perwuy = new float[maxNumOfIndTotal];
	public float[] name_IndTotalOfCommand2_perwuy = new float[maxNumOfIndTotal];
	public float[] name_IndTotalMenweOfCommand2_perwuy = new float[maxNumOfIndTotal];
	public float[] name_IndTotalBilweOfCommand2_perwuy = new float[maxNumOfIndTotal];

	public float name_total_parnuy_ni_perwuy;
	public float name_total_parnuy_tak_perwuy;
	public float name_perwa_komanda_zabje_ni_perwuy;
	public float name_perwa_komanda_zabje_tak_perwuy;
	public float name_dryga_komanda_zabje_ni_perwuy;
	public float name_dryga_komanda_zabje_tak_perwuy;
	public float name_dvi_komandu_zabjytj_ni_perwuy;
	public float name_dvi_komandu_zabjytj_tak_perwuy;
	public float name_nastypnuy_gol_perwa_komanda_perwuy;
	public float name_nastypnuy_gol_dryga_komanda_perwuy;
	public float name_nastypnuy_gol_nixto_perwuy;

	public boolean koef() {
		return true;
	}

	public void readFromFile() throws IOException {

		File file1 = new File(file);
		FileReader fr = new FileReader(file1.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);

		strTotal = FileUtils.readFileToString(file1, Charsets.UTF_8);

		br.close();

	}

	public String getKoef() {
		return "Update class";
	}

	public Koef() {
		setKoefToZero();
	}

	public void setKoefToZero() {
		// ======== Коефіцієнти загальні ==============
		hour = 0;
		minute = 0;
		name_of_command1 = "";
		name_of_command2 = "";
		name_1 = 0;
		name_X = 0;
		name_2 = 0;
		name_1X = 0;
		name_12 = 0;
		name_X2 = 0;
		name_perwa_komanda_zabje_ni = 0;
		name_perwa_komanda_zabje_tak = 0;
		name_dryga_komanda_zabje_ni = 0;
		name_dryga_komanda_zabje_tak = 0;
		name_dvi_komandu_zabjytj_ni = 0;
		name_dvi_komandu_zabjytj_tak = 0;
		name_nastypnuy_gol_perwa_komanda = 0;
		name_nastypnuy_gol_dryga_komanda = 0;
		name_nastypnuy_gol_nixto = 0;
		name_total_parnuy_ni = 0;
		name_total_parnuy_tak = 0;

		for (int i = 0; i < maxNumOfFora; i++) {
			name_FORA1[i] = 0;
			name_koef_for_FORA1[i] = 0;
			name_FORA2[i] = 0;
			name_koef_for_FORA2[i] = 0;
		}

		for (int i = 0; i < maxNumOfTotal; i++) {
			name_TOTAL[i] = 0;
			name_TOTAL_menwe[i] = 0;
			name_TOTAL_bilwe[i] = 0;
		}

		for (int i = 0; i < maxNumOfIndTotal; i++) {
			name_IndTotalOfCommand1[i] = 0;
			name_IndTotalMenweOfCommand1[i] = 0;
			name_IndTotalBilweOfCommand1[i] = 0;
			name_IndTotalOfCommand2[i] = 0;
			name_IndTotalMenweOfCommand2[i] = 0;
			name_IndTotalBilweOfCommand2[i] = 0;
		}

		name_time_match_P1_P1 = 0;
		name_time_match_P1_P2 = 0;
		name_time_match_P2_P1 = 0;
		name_time_match_P1_N = 0;
		name_time_match_N_P1 = 0;
		name_time_match_N_N = 0;
		name_time_match_N_P2 = 0;
		name_time_match_P2_N = 0;
		name_time_match_P2_P2 = 0;

		// Перший тайм

		name_1_perwuy = 0;
		name_X_perwuy = 0;
		name_2_perwuy = 0;
		name_1X_perwuy = 0;
		name_12_perwuy = 0;
		name_X2_perwuy = 0;

		for (int i = 0; i < maxNumOfFora; i++) {
			name_FORA1_perwuy[i] = 0;
			name_koef_for_FORA1_perwuy[i] = 0;
			name_FORA2_perwuy[i] = 0;
			name_koef_for_FORA2_perwuy[i] = 0;
		}

		for (int i = 0; i < maxNumOfTotal; i++) {
			name_TOTAL_perwuy[i] = 0;
			name_TOTAL_menwe_perwuy[i] = 0;
			name_TOTAL_bilwe_perwuy[i] = 0;
		}

		for (int i = 0; i < maxNumOfIndTotal; i++) {
			name_IndTotalOfCommand1_perwuy[i] = 0;
			name_IndTotalMenweOfCommand1_perwuy[i] = 0;
			name_IndTotalBilweOfCommand1_perwuy[i] = 0;
			name_IndTotalOfCommand2_perwuy[i] = 0;
			name_IndTotalMenweOfCommand2_perwuy[i] = 0;
			name_IndTotalBilweOfCommand2_perwuy[i] = 0;
		}

	}

	public void print() {
		System.out.println("hour  == " + hour);
		System.out.println("minute  == " + minute);
		System.out.println("name_of_command1  == " + name_of_command1);
		System.out.println("name_of_command2  == " + name_of_command2);
		System.out.println("name_1  == " + name_1);
		System.out.println("name_X  == " + name_X);
		System.out.println("name_2  == " + name_2);
		System.out.println("name_1X  == " + name_1X);

	}

}
