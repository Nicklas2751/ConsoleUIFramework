package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

/**
 * This enum contains the texts which are neither dialogs or errors.
 *
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/MetaTexts.png" alt="MetaTexts">
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum MetaTexts {
	/**
	 * The return text.
	 */
	RETURN("Zurück");

	private String	displayText;

	private MetaTexts(final String aDisplayText) {
		displayText = aDisplayText;
	}

	/**
	 * @return The display text.
	 */
	public String getDisplayText() {
		return displayText;
	}
}
