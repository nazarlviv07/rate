package test;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import st.Calc;
import st.FavbetKoef;
import st.BetcityKoef;
import st.FonbetKoef;
import st.Koef;
import st.type.Result;

public class SearchForkInRealFilesTest {

	Koef koef_betcity = new BetcityKoef();
	Koef koef_favbet = new FavbetKoef();
	Result fork = new Result();
	Calc calculation = new Calc();

	@Test
	public void testInRealFiles1() throws IOException {

		koef_favbet.file = "Test/1/favBet.html";
		koef_betcity.file = "Test/1/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "1");
		Assert.assertEquals(fork.KoefKontora1, 1.91f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "X2");
		Assert.assertEquals(fork.KoefKontora2, 3.1f);
	}

	@Test
	public void testInRealFiles2() throws IOException {

		koef_favbet.file = "Test/2/favBet.html";
		koef_betcity.file = "Test/2/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "X2");
		Assert.assertEquals(fork.KoefKontora1, 1.92f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "1");
		Assert.assertEquals(fork.KoefKontora2, 3.2f);
	}
	
	@Test
	public void testInRealFiles3() throws IOException {

		koef_favbet.file = "Test/3/favBet.html";
		koef_betcity.file = "Test/3/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "X");
		Assert.assertEquals(fork.KoefKontora1, 1.93f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "12");
		Assert.assertEquals(fork.KoefKontora2, 3.3f);
	}
	
	@Test
	public void testInRealFiles4() throws IOException {

		koef_favbet.file = "Test/4/favBet.html";
		koef_betcity.file = "Test/4/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "12");
		Assert.assertEquals(fork.KoefKontora1, 1.94f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "X");
		Assert.assertEquals(fork.KoefKontora2, 3.8f);
	}
	
	@Test
	public void testInRealFiles5() throws IOException {

		koef_favbet.file = "Test/5/favBet.html";
		koef_betcity.file = "Test/5/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "2");
		Assert.assertEquals(fork.KoefKontora1, 1.9f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "1X");
		Assert.assertEquals(fork.KoefKontora2, 3.0f);
	}
	
	@Test
	public void testInRealFiles6() throws IOException {

		koef_favbet.file = "Test/6/favBet.html";
		koef_betcity.file = "Test/6/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "1X");
		Assert.assertEquals(fork.KoefKontora1, 30.1f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "2");
		Assert.assertEquals(fork.KoefKontora2, 1.33f);
	}
	
	@Test
	public void testInRealFiles7() throws IOException {

		koef_favbet.file = "Test/7/favBet.html";
		koef_betcity.file = "Test/7/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "FORA1 = -2.5");
		Assert.assertEquals(fork.KoefKontora1, 2.71f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "FORA2 = 2.5");
		Assert.assertEquals(fork.KoefKontora2, 2.35f);
	}
	
	@Test
	public void testInRealFiles8() throws IOException {

		koef_favbet.file = "Test/8/favBet.html";
		koef_betcity.file = "Test/8/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "FORA1 = 2.0");
		Assert.assertEquals(fork.KoefKontora1, 2.2f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "FORA2 = -2.0");
		Assert.assertEquals(fork.KoefKontora2, 3.2f);
	}
	
	@Test
	public void testInRealFiles9() throws IOException {

		koef_favbet.file = "Test/9/favBet.html";
		koef_betcity.file = "Test/9/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "Total = 4.5 Menwe");
		Assert.assertEquals(fork.KoefKontora1, 4.41f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "Total = 4.5 Bilwe");
		Assert.assertEquals(fork.KoefKontora2, 3.3f);
	}
	
	@Test
	public void testInRealFiles10() throws IOException {

		koef_favbet.file = "Test/10/favBet.html";
		koef_betcity.file = "Test/10/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "Total = 5.0 Bilwe");
		Assert.assertEquals(fork.KoefKontora1, 2.4f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "Total = 5.0 Menwe");
		Assert.assertEquals(fork.KoefKontora2, 3.42f);
	}
	
	@Test
	public void testInRealFiles11() throws IOException {

		koef_favbet.file = "Test/11/favBet.html";
		koef_betcity.file = "Test/11/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "Ind Total Com1 = 3.5 Menwe");
		Assert.assertEquals(fork.KoefKontora1, 4.43f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "Ind Total Com1 = 3.5 Bilwe");
		Assert.assertEquals(fork.KoefKontora2, 2.07f);
	}
	
	@Test
	public void testInRealFiles12() throws IOException {

		koef_favbet.file = "Test/12/favBet.html";
		koef_betcity.file = "Test/12/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "Ind Total Com1 = 3.5 Bilwe");
		Assert.assertEquals(fork.KoefKontora1, 2.07f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "Ind Total Com1 = 3.5 Menwe");
		Assert.assertEquals(fork.KoefKontora2, 4.67f);
	}
	
	@Test
	public void testInRealFiles13() throws IOException {

		koef_favbet.file = "Test/13/favBet.html";
		koef_betcity.file = "Test/13/betcity.html";

		koef_favbet.readFromFile();
		koef_favbet.getKoef();

		koef_betcity.getKoef();

		fork = calculation.checkFork(koef_betcity, koef_favbet);

		Assert.assertEquals(fork.fork, true);
		Assert.assertEquals(fork.nameOfKoefKontora1, "Ind Total Com2 = 0.5 Menwe");
		Assert.assertEquals(fork.KoefKontora1, 3.67f);
		Assert.assertEquals(fork.nameOfKoefKontora2, "Ind Total Com2 = 0.5 Bilwe");
		Assert.assertEquals(fork.KoefKontora2, 4.45f);
	}
}
