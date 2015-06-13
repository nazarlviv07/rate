package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import st.FavbetKoef;
import st.BetcityKoef;
import st.FonbetKoef;
import st.Koef;
import st.Parser;

public class ParserTest {

	@Test
	public void testNameOfCommands1() {
		Parser parser = new Parser();
		Koef koef_favbet = new FavbetKoef();
		Koef koef_fonbet = new FonbetKoef();
		
		koef_favbet.name_of_command1 = "Myanmar";
		koef_favbet.name_of_command2 = "Vietnam";
		
		koef_fonbet.name_of_command1 = "Myanmar U23";
		koef_fonbet.name_of_command2 = "Vietnam U23";
	
		Assert.assertTrue(parser.isNameOfCommandSame(koef_favbet, koef_fonbet));
	}
	
	@Test
	public void testNameOfCommands2() {
		Parser parser = new Parser();
		Koef koef_favbet = new FavbetKoef();
		Koef koef_fonbet = new FonbetKoef();
		
		koef_favbet.name_of_command1 = "Box Hill United";
		koef_favbet.name_of_command2 = "Moreland Zebras";
		
		koef_fonbet.name_of_command1 = "Box Hill";
		koef_fonbet.name_of_command2 = "Moreland Zebras";
	
		Assert.assertTrue(parser.isNameOfCommandSame(koef_favbet, koef_fonbet));
	}
	
	@Test
	public void testNameOfCommands3() {
		Parser parser = new Parser();
		Koef koef_favbet = new FavbetKoef();
		Koef koef_fonbet = new FonbetKoef();
		
		koef_favbet.name_of_command1 = "Subiaco AFC";
		koef_favbet.name_of_command2 = "Perth SC";
		
		koef_fonbet.name_of_command1 = "Subiaco";
		koef_fonbet.name_of_command2 = "Perth";
	
		Assert.assertTrue(parser.isNameOfCommandSame(koef_favbet, koef_fonbet));
	}
	
	@Test
	public void testNameOfCommandsFail1Test() {
		Parser parser = new Parser();
		Koef koef_favbet = new FavbetKoef();
		Koef koef_fonbet = new FonbetKoef();
		
		koef_favbet.name_of_command1 = "Box Hill United";
		koef_favbet.name_of_command2 = "Moreland Zebras";
		
		koef_fonbet.name_of_command1 = "Myanmar U23";
		koef_fonbet.name_of_command2 = "Vietnam U23";
	
		Assert.assertFalse(parser.isNameOfCommandSame(koef_favbet, koef_fonbet));
	}

	@Test
	public void testNameOfCommandsFail2Test() {
		Parser parser = new Parser();
		Koef koef_favbet = new FavbetKoef();
		Koef koef_fonbet = new FonbetKoef();
		
		koef_favbet.name_of_command1 = "Denmark";
		koef_favbet.name_of_command2 = "Serbia";
		
		koef_fonbet.name_of_command1 = "Denmark (corners)";
		koef_fonbet.name_of_command2 = "Serbia (corners)";
	
		Assert.assertFalse(parser.isNameOfCommandSame(koef_favbet, koef_fonbet));
	}
}
