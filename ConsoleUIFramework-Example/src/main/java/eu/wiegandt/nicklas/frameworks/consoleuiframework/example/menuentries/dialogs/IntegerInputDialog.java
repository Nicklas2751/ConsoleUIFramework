package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs;

import java.util.Map;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs.AbstractIntegerInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DialogTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DisplayTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.OutputTextPatterns;

/**
 * This is a example for a integer input dialog.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class IntegerInputDialog extends AbstractIntegerInputDialog {

	public IntegerInputDialog() {
		super(DisplayTexts.INTEGERINPUTDIALOG.getDisplayText(),
				DialogTexts.INTEGER_INPUT.getText());
	}

	@Override
	protected final void processInputs(final Map<String, Integer> aIntegerMap) {
		final Integer integer = aIntegerMap.get(DialogTexts.INTEGER_INPUT
				.getText());
		ConsoleTools.getLogger();
		LOG.info(String.format(
				OutputTextPatterns.INTEGER_OUTOUT_TEXT_PATTERN.getTextpattern(),
				integer.toString()));
	}

}
