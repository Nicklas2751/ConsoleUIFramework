package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

/**
 * This enum contains the dialog texts.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/Dialogs.png" alt="Dialogs">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum Dialogs {
	CHOOSE_ENTRY("Bitte wählen Sie einen Eintrag aus:");

	private String displayText;

	private Dialogs(String aDisplayText) {
		displayText = aDisplayText;
	}

	/**
	 * This method logs the display text as info in the console.
	 */
	public void print() {
		ConsoleTools.getLogger().info(displayText);
	}
}
