package st.type;

public enum Sport {
	FOOTBALL("Football");

	private String string;

	Sport(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
