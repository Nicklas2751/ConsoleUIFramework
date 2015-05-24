package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import org.apache.logging.log4j.Logger;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.AbstractMenuEntry;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

public abstract class AbstractInputDialog<T> extends AbstractMenuEntry {
	protected static final Logger LOG = ConsoleTools.getLogger();

	private final String dialogText;

	public AbstractInputDialog(String aDisplayText,String aDialogText) {
		super(aDisplayText);
		dialogText = aDialogText;
	}

	@Override
	public final void start() {
		printDialogText();
		T input = readInput();
		processInput(input);
	}

	protected final void printDialogText() {
		ConsoleTools.printLine();
		LOG.info(dialogText);
	}

	protected abstract void processInput(T aInput);

	protected abstract T readInput();
	

}
