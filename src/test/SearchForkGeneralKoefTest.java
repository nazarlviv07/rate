package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import st.Calc;
import st.Koef;
import st.type.Result;

public class SearchForkGeneralKoefTest {
	Koef koef1 = new Koef();
	Koef koef2 = new Koef();
	Calc calculation = new Calc();
	Result fork = new Result();
	@BeforeMethod()
	public void beforeTest() {
	
	  fork.fork = false;
	  fork.nameOfKoefKontora1 = "";
	  fork.nameOfKoefKontora2 = "";
	  fork.KoefKontora1 = 0;
	  fork.KoefKontora2 = 0;
	  koef1.setKoefToZero();
	  koef2.setKoefToZero();
	}
	@Test()
	public void test1_X2() {

		koef1.name_1 = 1.5f;
		koef2.name_X2 = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "1");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "X2");
	}
	
	@Test()
	public void testX2_1() {

		koef1.name_X2 = 1.5f;
		koef2.name_1 = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		
		Assert.assertEquals(fork.nameOfKoefKontora1 , "X2");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "1");
	}
	
	@Test()
	public void testX_12() {

		koef1.name_X = 1.5f;
		koef2.name_12 = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "X");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "12");
	}
	
	@Test()
	public void test12_X() {

		koef1.name_12 = 1.5f;
		koef2.name_X = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "12");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "X");
	}
	
	@Test()
	public void test2_1X() {

		koef1.name_2 = 1.5f;
		koef2.name_1X = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "2");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "1X");
	}
	
	@Test()
	public void test1X_2() {

		koef1.name_1X = 1.5f;
		koef2.name_2 = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "1X");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "2");
	}
	
	@Test()
	public void testFora1_0_Fora2_0() {

		koef1.name_FORA1[0] = 0.5f;
		koef2.name_FORA2[0] = -0.5f;
		koef1.name_koef_for_FORA1[0] = 1.5f;
		koef2.name_koef_for_FORA2[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "FORA1 = 0.5");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "FORA2 = -0.5");
	}
	
	@Test()
	public void testFora1_1_Fora2_2() {

		koef1.name_FORA1[1] = 0.5f;
		koef2.name_FORA2[2] = -0.5f;
		koef1.name_koef_for_FORA1[1] = 1.5f;
		koef2.name_koef_for_FORA2[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "FORA1 = 0.5");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "FORA2 = -0.5");
	}

	@Test()
	public void testFora2_0_Fora1_0() {

		koef1.name_FORA2[0] = 0.5f;
		koef2.name_FORA1[0] = -0.5f;
		koef1.name_koef_for_FORA2[0] = 1.5f;
		koef2.name_koef_for_FORA1[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "FORA2 = 0.5");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "FORA1 = -0.5");
	}
	
	@Test()
	public void testFora2_2_Fora1_3() {

		koef1.name_FORA2[2] = 0.5f;
		koef2.name_FORA1[3] = -0.5f;
		koef1.name_koef_for_FORA2[2] = 1.5f;
		koef2.name_koef_for_FORA1[3] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "FORA2 = 0.5");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "FORA1 = -0.5");
	}
	
	@Test()
	public void testTotal_Bilwe_0_and_Total_Menwe_0() {

		koef1.name_TOTAL[0] = 0.5f;
		koef1.name_TOTAL_bilwe[0] = 1.5f;
		
		koef2.name_TOTAL[0] = 0.5f;
		koef2.name_TOTAL_menwe[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Total = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Total = 0.5 Menwe");
	}
	
	@Test()
	public void testTotal_Bilwe_1_and_Total_Menwe_2() {

		koef1.name_TOTAL[1] = 0.5f;
		koef1.name_TOTAL_bilwe[1] = 1.5f;
		
		koef2.name_TOTAL[2] = 0.5f;
		koef2.name_TOTAL_menwe[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Total = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Total = 0.5 Menwe");
	}
	
	@Test()
	public void testTotal_Menwe_0_and_Total_Bilwe_0() {

		koef1.name_TOTAL[0] = 0.5f;
		koef1.name_TOTAL_menwe[0] = 1.5f;
		
		koef2.name_TOTAL[0] = 0.5f;
		koef2.name_TOTAL_bilwe[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Total = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Total = 0.5 Bilwe");
	}
	
	@Test()
	public void testTotal_Menwe_1_and_Total_Bilwe_2() {

		koef1.name_TOTAL[1] = 0.5f;
		koef1.name_TOTAL_menwe[1] = 1.5f;
		
		koef2.name_TOTAL[2] = 0.5f;
		koef2.name_TOTAL_bilwe[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Total = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Total = 0.5 Bilwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_1_Menwe_0_and_Ind_Total_Command_1_Bilwe_0() {

		koef1.name_IndTotalOfCommand1[0] = 0.5f;
		koef1.name_IndTotalMenweOfCommand1[0] = 1.5f;
		
		koef2.name_IndTotalOfCommand1[0] = 0.5f;
		koef2.name_IndTotalBilweOfCommand1[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com1 = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com1 = 0.5 Bilwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_1_Menwe_1_and_Ind_Total_Command_1_Bilwe_2() {

		koef1.name_IndTotalOfCommand1[1] = 0.5f;
		koef1.name_IndTotalMenweOfCommand1[1] = 1.5f;
		
		koef2.name_IndTotalOfCommand1[2] = 0.5f;
		koef2.name_IndTotalBilweOfCommand1[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com1 = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com1 = 0.5 Bilwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_2_Menwe_0_and_Ind_Total_Command_2_Bilwe_0() {

		koef1.name_IndTotalOfCommand2[0] = 0.5f;
		koef1.name_IndTotalMenweOfCommand2[0] = 1.5f;
		
		koef2.name_IndTotalOfCommand2[0] = 0.5f;
		koef2.name_IndTotalBilweOfCommand2[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com2 = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com2 = 0.5 Bilwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_2_Menwe_1_and_Ind_Total_Command_2_Bilwe_2() {

		koef1.name_IndTotalOfCommand2[1] = 0.5f;
		koef1.name_IndTotalMenweOfCommand2[1] = 1.5f;
		
		koef2.name_IndTotalOfCommand2[2] = 0.5f;
		koef2.name_IndTotalBilweOfCommand2[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com2 = 0.5 Menwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com2 = 0.5 Bilwe");
	}

	@Test()
	public void test_Ind_Total_Command_1_Bilwe_0_and_Ind_Total_Command_1_Menwe_0() {

		koef1.name_IndTotalOfCommand1[0] = 0.5f;
		koef1.name_IndTotalBilweOfCommand1[0] = 1.5f;
		
		koef2.name_IndTotalOfCommand1[0] = 0.5f;
		koef2.name_IndTotalMenweOfCommand1[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com1 = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com1 = 0.5 Menwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_1_Bilwe_1_and_Ind_Total_Command_1_Menwe_2() {

		koef1.name_IndTotalOfCommand1[1] = 0.5f;
		koef1.name_IndTotalBilweOfCommand1[1] = 1.5f;
		
		koef2.name_IndTotalOfCommand1[2] = 0.5f;
		koef2.name_IndTotalMenweOfCommand1[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com1 = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com1 = 0.5 Menwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_2_Bilwe_0_and_Ind_Total_Command_2_Menwe_0() {

		koef1.name_IndTotalOfCommand2[0] = 0.5f;
		koef1.name_IndTotalBilweOfCommand2[0] = 1.5f;
		
		koef2.name_IndTotalOfCommand2[0] = 0.5f;
		koef2.name_IndTotalMenweOfCommand2[0] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com2 = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com2 = 0.5 Menwe");
	}
	
	@Test()
	public void test_Ind_Total_Command_2_Bilwe_1_and_Ind_Total_Command_2_Menwe_2() {

		koef1.name_IndTotalOfCommand2[1] = 0.5f;
		koef1.name_IndTotalBilweOfCommand2[1] = 1.5f;
		
		koef2.name_IndTotalOfCommand2[2] = 0.5f;
		koef2.name_IndTotalMenweOfCommand2[2] = 3.5f;

		fork = calculation.checkFork(koef1, koef2);
		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1 , "Ind Total Com2 = 0.5 Bilwe");
		Assert.assertEquals(fork.nameOfKoefKontora2 , "Ind Total Com2 = 0.5 Menwe");
	}
}
