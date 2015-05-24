package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;

public abstract class AbstractTextInputDialog extends
		AbstractInputDialog<String> {

	public AbstractTextInputDialog(String aDisplayText, String aDialogText) {
		super(aDisplayText, aDialogText);
	}


	@Override
	protected final String readInput() {
		return ConsoleReader.getInstance().readLine();
	}

}
