package st.type;

public enum Kontora {
	FAVBET("favbet","https://www.favbet.com/live/markets/"),
	BETCITY("betcity",null),
	/*FONBET("fonbet","http://live.fonbet.com/live/currentLine/en/");
	  FONBET("fonbet","http://live.fonbet.com/live/currentLine/ru/");
	 */
	FONBET("fonbet","http://live.fonbet.com/live/currentLine/en/");

	private String name;
	private String linkAllEvents;

	Kontora(String name, String linkAllEvents) {
		this.name = name;
		this.linkAllEvents = linkAllEvents;
	}

	public String getName() {
		return name;
	}
	public String getLinkAllEvents() {
		return linkAllEvents;
	}
}
