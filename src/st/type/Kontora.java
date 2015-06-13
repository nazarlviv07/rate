package st.type;

public enum Kontora {
	FAVBET("favbet"),
	BETCITY("betcity"),
	FONBET("fonbet");

	private String name;

	Kontora(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
