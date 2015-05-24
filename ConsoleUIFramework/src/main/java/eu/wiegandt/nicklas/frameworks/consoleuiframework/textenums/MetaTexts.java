package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

public enum MetaTexts {
	RETURN("Zurück");
	

	private String displayText;

	private MetaTexts(String aDisplayText)
	{
		displayText = aDisplayText;
	}

	public String getDisplayText() {
		return displayText;
	}
}
