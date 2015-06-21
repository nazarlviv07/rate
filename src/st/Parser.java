package st;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public Parser() {

	}

	public boolean isNameOfCommandSame(Koef kontora1, Koef kontora2) {
		if (kontora1.name_of_command1
				.equalsIgnoreCase(kontora2.name_of_command1)) {
			if (kontora1.name_of_command2
					.equalsIgnoreCase(kontora2.name_of_command2)) {
				return true;
			}
		}
		if (kontora1.name_of_command1.contains("corners") || kontora2.name_of_command1.contains("corners"))
			return false;
		
		if (kontora1.name_of_command1.length() >= 5
				&& kontora1.name_of_command2.length() >= 5
				&& kontora2.name_of_command1.length() >= 5
				&& kontora2.name_of_command2.length() >= 5) {
			if (kontora1.name_of_command1.substring(0, 5).equalsIgnoreCase(
					kontora2.name_of_command1.substring(0, 5))) {
				if (kontora1.name_of_command2.substring(0, 5).equalsIgnoreCase(
						kontora2.name_of_command2.substring(0, 5))) {
					return true;
				}
			}
		}
		return false;
	}

	public List<List<Koef>> compareNameOfCommands(List<List<Koef>> allEventsList) {

		List<List<Koef>> onlySameEventsList = new ArrayList<List<Koef>>();
		List<Koef> fonbetKoefList = allEventsList.get(0);
		List<Koef> favbetKoefList = allEventsList.get(1);
		List<Koef> fonbetKoefSameEventsList = new ArrayList<Koef>();
		List<Koef> favbetKoefSameEventsList = new ArrayList<Koef>();

		System.out.println("  Favbet");
		for (int i = 0; i < favbetKoefList.size(); i++) {
			System.out.println("command1 "
					+ favbetKoefList.get(i).name_of_command1 + " command2 "
					+ favbetKoefList.get(i).name_of_command2 + " id "
					+ favbetKoefList.get(i).id);
		}

		System.out.println("  Fonbet");

		for (int i = 0; i < fonbetKoefList.size(); i++) {
			System.out.println("command1 "
					+ fonbetKoefList.get(i).name_of_command1 + " command2 "
					+ fonbetKoefList.get(i).name_of_command2);
			;
		}

		for (int i = 0; i < fonbetKoefList.size(); i++) {
			for (int j = 0; j < favbetKoefList.size(); j++) {
				if (isNameOfCommandSame(fonbetKoefList.get(i),
						favbetKoefList.get(j))) {
					fonbetKoefSameEventsList.add(fonbetKoefList.get(i));
					favbetKoefSameEventsList.add(favbetKoefList.get(j));
				}
			}
		}

		onlySameEventsList.add(fonbetKoefSameEventsList);
		onlySameEventsList.add(favbetKoefSameEventsList);

		System.out.println(" The same same of commands");
		for (int i = 0; i < fonbetKoefSameEventsList.size(); i++) {
			System.out.println("command1 "
					+ fonbetKoefSameEventsList.get(i).name_of_command1
					+ " command2 "
					+ fonbetKoefSameEventsList.get(i).name_of_command2);
		}

		System.out.println("  Fonbet  ");

		for (int i = 0; i < favbetKoefSameEventsList.size(); i++) {
			System.out.println("command1 "
					+ favbetKoefSameEventsList.get(i).name_of_command1
					+ " command2 "
					+ favbetKoefSameEventsList.get(i).name_of_command2);
			;
		}

		return onlySameEventsList;
	}
}