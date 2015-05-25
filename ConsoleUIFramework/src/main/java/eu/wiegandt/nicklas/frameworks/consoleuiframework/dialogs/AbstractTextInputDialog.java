package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;

public abstract class AbstractTextInputDialog extends
		AbstractInputDialog<String> {

	public AbstractTextInputDialog(String aDisplayText, String... aDialogTexts) {
		super(aDisplayText, aDialogTexts);
	}


	@Override
	protected final String readInput(String aDialogText) {
		return ConsoleReader.getInstance().readLine();
	}

}
