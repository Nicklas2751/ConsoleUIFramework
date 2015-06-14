package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums;

/**
 * This enumeration contains the display texts. The display texts are shown in
 * the menu.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum DisplayTexts {
	/**
	 * Exit.
	 */
	EXIT("Beenden"),
	/**
	 * A file input dialog.
	 */
	FILEINPUTDIALOG("Ordner auswahl Dialog"),
	/**
	 * A integer input dialog.
	 */
	INTEGERINPUTDIALOG("Ganzzahl eingabe Dialog"),
	/**
	 * The main menu.
	 */
	MAINMENU("Hauptmenü"),
	/**
	 * A person information input dialog.
	 */
	PERSONINPUTDIALOG("Eingabe von Informationen einer Person"),
	/**
	 * A text input dialog.
	 */
	TEXTINPUTDIALOG("Text eingabe Dialog");

	private String	displayText;

	private DisplayTexts(final String aDiplayText) {
		displayText = aDiplayText;
	}

	public String getDisplayText() {
		return displayText;
	}
}
