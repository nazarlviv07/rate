package st;

public class Parser {

	public Parser() {

	}

	public boolean compareNameOfCommands(Koef kontora1, Koef kontora2) {
		if (kontora1.name_of_command1
				.equalsIgnoreCase(kontora2.name_of_command1)) {
			if (kontora1.name_of_command2
					.equalsIgnoreCase(kontora2.name_of_command2)) {
				return true;
			}
		}
		return false;
	}
}