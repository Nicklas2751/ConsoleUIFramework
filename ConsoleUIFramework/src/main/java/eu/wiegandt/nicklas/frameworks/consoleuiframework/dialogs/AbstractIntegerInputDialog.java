package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;

public abstract class AbstractIntegerInputDialog extends AbstractInputDialog<Integer> {

	public AbstractIntegerInputDialog(String aDisplayText, String aDialogText) {
		super(aDisplayText, aDialogText);
	}


	@Override
	protected final Integer readInput() {
		return ConsoleReader.readNumber();
	}

}
