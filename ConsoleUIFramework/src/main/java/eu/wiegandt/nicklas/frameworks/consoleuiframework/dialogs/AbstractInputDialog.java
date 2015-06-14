package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.AbstractMenuEntry;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

/**
 * This generic class contains basic methods to create an input dialog.
 *
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractInputDialog.png" alt="AbstractInputDialog">
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 * @param <T>
 *            The type of the objects which will be read, example: String /
 *            Integer / File etc.
 */
public abstract class AbstractInputDialog<T> extends AbstractMenuEntry {
	/**
	 * The logger.
	 */
	protected static final Logger	LOG	= ConsoleTools.getLogger();

	private final String[]			dialogTexts;

	/**
	 * The constructor.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the objects which will be read.
	 */
	public AbstractInputDialog(final String aDisplayText,
			final String... aDialogTexts) {
		super(aDisplayText);
		dialogTexts = aDialogTexts;
	}

	@Override
	public final void start() {
		final Map<String, T> inputs = new HashMap<String, T>();
		for (final String dialogText : dialogTexts) {
			printDialogText(dialogText);
			final T input = readInput(dialogText);
			if (input != null) {
				inputs.put(dialogText, input);
			}
		}
		processInputs(inputs);
	}

	/**
	 * This method logs the display text as a info in the console.
	 *
	 * @param aDialogText
	 *            The dialog text which will be logged.
	 */
	protected final void printDialogText(final String aDialogText) {
		ConsoleTools.printLine();
		LOG.info(aDialogText);
	}

	/**
	 * This method processes the inputs.
	 *
	 * @param inputs
	 *            The inputs which will be processed. The dialog texts are the
	 *            keys.
	 */
	protected abstract void processInputs(Map<String, T> inputs);

	/**
	 * This method reads the input for the given dialog text.
	 *
	 * @param aDialogText
	 *            The dialog text for this input.
	 * @return The read object.
	 */
	protected abstract T readInput(String aDialogText);

}
