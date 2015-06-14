package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums;

/**
 * This enumeration contains the output text patterns.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum OutputTextPatterns {
	/**
	 * Folder path output text pattern.
	 */
	FOLDER_OUTPUT_TEXT_PATTERN(
			"Sie haben den folgenden Ordner ausgewählt: \"%s\""),
			/**
			 * Integer output text pattern.
			 */
			INTEGER_OUTOUT_TEXT_PATTERN(
					"Sie haben folgende Ganzzahl eingegeben: \"%s\""),
					/**
					 * Text output text pattern.
					 */
					TEXT_OUTPUT_TEXT_PATTERN("Sie haben folgenden Text eingegeben: \"%s\"");

	private String	textpattern;

	private OutputTextPatterns(final String aTextpattern) {
		textpattern = aTextpattern;
	}

	public String getTextpattern() {
		return textpattern;
	}
}
