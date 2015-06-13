package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

/**
 * This class contains debug messages.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/DebugMessages.png" alt="DebugMessages">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum DebugMessages {
	/**
	 * The BufferedReader can't be closed.
	 */
	BUFFERED_READER_CANT_CLOSED(
			"Beim schließen des BufferedReaders ist ein weiterer Fehler aufgetreten!");

	private String displayText;

	private DebugMessages(String aDisplayText) {
		displayText = aDisplayText;
	}

	/**
	 * This method logs the display text as debug message in the console.
	 */
	public void print() {
		ConsoleTools.getLogger().debug(displayText);
	}

	/**
	 * This method logs the display text as debug message in the console. The
	 * given Throwable will be printed too.
	 * 
	 * @param aCause
	 *            This Throwable will be printed too.
	 * 
	 */
	public void print(Throwable aCause) {
		ConsoleTools.getLogger().debug(displayText, aCause);
	}

}