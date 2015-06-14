package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs;

import java.util.Map;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs.AbstractTextInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DialogTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DisplayTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.OutputTextPatterns;

/**
 * This is a example for a simple text input dialog.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class TextInputDialog extends AbstractTextInputDialog {

	public TextInputDialog() {
		super(DisplayTexts.TEXTINPUTDIALOG.getDisplayText(),
				DialogTexts.TEXT_INPUT.getText());
	}

	@Override
	protected final void processInputs(final Map<String, String> aTextMap) {
		final String text = aTextMap.get(DialogTexts.TEXT_INPUT.getText());
		ConsoleTools.printLine();
		LOG.info(String.format(
				OutputTextPatterns.TEXT_OUTPUT_TEXT_PATTERN.getTextpattern(),
				text));
	}

}
