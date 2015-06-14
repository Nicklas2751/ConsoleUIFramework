package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs.AbstractFileInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.filefilter.FolderFileFilter;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DialogTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DisplayTexts;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.OutputTextPatterns;

/**
 * This is a example file input dialog which allows to choose a folder or cancel
 * with 0.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class FileInputDialog extends AbstractFileInputDialog {
	private static final Logger	LOG	= ConsoleTools.getLogger();

	public FileInputDialog() {
		super(DisplayTexts.FILEINPUTDIALOG.getDisplayText(),
				new String[] { DialogTexts.FOLDER_INPUT.getText() },
				new FolderFileFilter(), true);
	}

	@Override
	protected final void processInputs(final Map<String, File> aFiles) {
		if (aFiles.isEmpty()) {
			// If the user writes "0" as file path the map is empty so we can
			// cancel the dialog.
			ConsoleTools.printLine();
			LOG.info(DialogTexts.CANCELED_DIALOG.getText());
		} else {
			final File folder = aFiles.get(DialogTexts.FOLDER_INPUT.getText());
			ConsoleTools.printLine();
			LOG.info(String.format(
					OutputTextPatterns.FOLDER_OUTPUT_TEXT_PATTERN
							.getTextpattern(), folder.getAbsolutePath()
							.toString()));
		}
	}

}
