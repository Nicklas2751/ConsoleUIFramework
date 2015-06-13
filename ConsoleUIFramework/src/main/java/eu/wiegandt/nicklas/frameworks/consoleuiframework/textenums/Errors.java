package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

/**
 * This enum contains the error texts.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/Errors.png" alt="Errors">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum Errors {
	/**
	 * Entry not exists.
	 */
	ENTRY_NOT_EXISTS(
			"Der gewählte Eintrag konnte nicht gefunden werden. Bitte versuchen Sie es erneut."),
	/**
	 * File don't exists.
	 */
	FILE_DONT_EXISTS(
			"Die angegebene Datei konnte nicht gefunden werden! Bitte versuchen Sie es erneut!"),
	/**
	 * File don't match.
	 */
	FILE_DONT_MATCH_FILTER(
			"Die angegebene Datei entspricht nicht dem erwarteten Format! Bitte versuchen Sie es erneut."),
	/**
	 * Input read error.
	 */
	INPUT_READ_ERROR("Beim Lesen der Eingabe ist ein Fehler aufgetreten!"),
	/**
	 * Number input is invalid.
	 */
	NUMBER_INPUT_INVALID(
			"Ihre Eingabe war keine valide Nummer! Bitte versuchen Sie es erneut:");

	private String displayText;

	private Errors(String aDisplayText) {
		displayText = aDisplayText;
	}

	/**
	 * This method logs the display text as error in the console.
	 */
	public void print() {
		ConsoleTools.getLogger().error(displayText);
	}

	/**
	 * This method logs the display text as error in the console. The given
	 * Throwable will be printed too.
	 * 
	 * @param aCause
	 *            This Throwable will be printed too.
	 */
	public void print(Throwable aCause) {
		ConsoleTools.getLogger().error(displayText, aCause);
	}

	/**
	 * This method logs the display text as fatal in the console.
	 */
	public void printFatal() {
		ConsoleTools.getLogger().fatal(displayText);
	}

	/**
	 * This method logs the display text as fatal in the console.The given
	 * Throwable will be printed too.
	 * 
	 * @param aCause
	 *            This Throwable will be printed too.
	 */
	public void printFatal(Throwable aCause) {
		ConsoleTools.getLogger().fatal(displayText, aCause);
	}

}
