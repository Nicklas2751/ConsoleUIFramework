package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;


public enum Dialogs {
	CHOOSE_ENTRY("Bitte wählen Sie einen Eintrag aus:");
	
	private String displayText;

	private Dialogs(String aDisplayText)
	{
		displayText = aDisplayText;
	}
	
	public void print()
	{
		ConsoleTools.getLogger().info(displayText);
	}
}
