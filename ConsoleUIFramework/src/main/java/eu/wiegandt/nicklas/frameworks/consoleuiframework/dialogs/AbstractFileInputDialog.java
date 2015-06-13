package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import java.io.File;
import java.io.FileFilter;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Errors;

public abstract class AbstractFileInputDialog extends AbstractInputDialog<File> {

	private static final String ZERO = "0";
	private FileFilter fileFilter;
	private Boolean cancelOnZero;

	public AbstractFileInputDialog(String aDisplayText, String... aDialogTexts) {
		super(aDisplayText, aDialogTexts);
		fileFilter = null;
	}

	public AbstractFileInputDialog(String aDisplayText, String[] aDialogTexts,
			Boolean aCancelOnZero) {
		this(aDisplayText, aDialogTexts);
		cancelOnZero = aCancelOnZero;
	}

	public AbstractFileInputDialog(String aDisplayText, String[] aDialogTexts,
			FileFilter aFileFilter, Boolean aCancelOnZero) {
		this(aDisplayText, aDialogTexts, aCancelOnZero);
		setFileFilter(aFileFilter);
	}

	public AbstractFileInputDialog(String aDisplayText, String[] aDialogTexts,
			FileFilter aFileFilter) {
		this(aDisplayText, aDialogTexts, aFileFilter, false);
	}

	private final void setFileFilter(FileFilter aFileFilter) {
		fileFilter = aFileFilter;
	}

	/**
	 * @return null if saving should be canceled.
	 */
	@Override
	protected final File readInput(String aDialogText) {
		File file;
		boolean invalid = false;

		do {
			if (invalid) {
				ConsoleTools.printLine();
				printDialogText(aDialogText);
			}

			String filePath = ConsoleReader.getInstance().readLine();
			if (cancelOnZero && filePath.equals(ZERO)) {
				file = null;
			} else {
				file = new File(filePath);

				invalid = checkFile(file);
			}
		} while (invalid);
		return file;
	}

	protected boolean checkFile(File file) {
		boolean invalid;
		if (file.exists()) {
			if (checkFileFilter(file)) {
				invalid = false;
			} else {
				Errors.FILE_DONT_MATCH_FILTER.print();
				invalid = true;
			}
		} else {
			Errors.FILE_DONT_EXISTS.print();
			invalid = true;
		}
		return invalid;
	}

	private final boolean checkFileFilter(File aFile) {
		return fileFilter == null || fileFilter.accept(aFile);
	}

}
