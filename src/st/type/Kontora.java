package st.type;

public enum Kontora {
	FAVBET("favbet",null),
	BETCITY("betcity",null),
	FONBET("fonbet",null);

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
