package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;

/**
 * This dialog reads an string for every given dialog text.
 *
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractTextInputDialog.png"
 * alt="AbstractTextInputDialog">
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public abstract class AbstractTextInputDialog extends
		AbstractInputDialog<String> {

	/**
	 * The constructor.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the strings will be read.
	 */
	public AbstractTextInputDialog(final String aDisplayText,
			final String... aDialogTexts) {
		super(aDisplayText, aDialogTexts);
	}

	@Override
	protected final String readInput(final String aDialogText) {
		return ConsoleReader.getInstance().readLine();
	}

}
