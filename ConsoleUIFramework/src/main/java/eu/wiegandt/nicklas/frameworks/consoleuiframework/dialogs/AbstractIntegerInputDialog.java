package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;

/**
 * This dialog reads an integer for every given dialog text.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractIntegerInputDialog.png"
 * alt="AbstractIntegerInputDialog">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public abstract class AbstractIntegerInputDialog extends
		AbstractInputDialog<Integer> {

	/**
	 * The constructor.
	 * 
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogText
	 *            The dialog text for which the integers will be read.
	 */
	public AbstractIntegerInputDialog(String aDisplayText, String aDialogText) {
		super(aDisplayText, aDialogText);
	}

	@Override
	protected final Integer readInput(String aDialogText) {
		return ConsoleReader.readNumber();
	}

}
