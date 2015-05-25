package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.AbstractMenuEntry;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

public abstract class AbstractInputDialog<T> extends AbstractMenuEntry {
	protected static final Logger LOG = ConsoleTools.getLogger();

	private final String[] dialogTexts;

	public AbstractInputDialog(String aDisplayText, String... aDialogTexts) {
		super(aDisplayText);
		dialogTexts = aDialogTexts;
	}

	@Override
	public final void start() {
		Map<String,T> inputs = new HashMap<String,T>();
		for (String dialogText : dialogTexts) {
			printDialogText(dialogText);
			inputs.put(dialogText,readInput(dialogText));
		}
		processInputs(inputs);
	}

	protected final void printDialogText(String aDialogText) {
		ConsoleTools.printLine();
		LOG.info(aDialogText);
	}

	protected abstract void processInputs(Map<String, T> inputs);

	protected abstract T readInput(String aDialogText);

}
