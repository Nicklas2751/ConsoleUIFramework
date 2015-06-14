package eu.wiegandt.nicklas.frameworks.consoleuiframework;

/**
 * This class is the parent class of all elements in the menu.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractMenuEntry.png" alt="AbstractMenuEntry">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *         <b>Skype:</b> Nicklas2751<br>
 *
 */
public abstract class AbstractMenuEntry {

	private final String	displayText;

	/**
	 * The constructor.
	 * 
	 * @param aDisplayText
	 *            This text will be displayed in the menu.
	 */
	public AbstractMenuEntry(final String aDisplayText) {
		displayText = aDisplayText;
	}

	/**
	 * @return The display text.
	 */
	public final String getDisplayText() {
		return displayText;
	}

	/**
	 * Starts the operation for this menu entry.
	 */
	public abstract void start();
}
