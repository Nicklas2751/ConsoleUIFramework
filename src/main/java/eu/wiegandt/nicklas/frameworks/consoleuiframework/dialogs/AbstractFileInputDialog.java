package eu.wiegandt.nicklas.frameworks.consoleuiframework.dialogs;

import java.io.File;
import java.io.FileFilter;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleReader;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Errors;

/**
 * This dialog reads file paths and return them as File objects.
 *
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractFileInputDialog.png"
 * alt="AbstractFileInputDialog">
 *
 * @see File
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public abstract class AbstractFileInputDialog extends AbstractInputDialog<File> {

	private static final String	ZERO	= "0";
	private Boolean				cancelOnZero;
	private FileFilter			fileFilter;

	/**
	 * The constructor without file filter and without cancel on zero.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the files will be read.
	 */
	public AbstractFileInputDialog(final String aDisplayText,
			final String... aDialogTexts) {
		super(aDisplayText, aDialogTexts);
		fileFilter = null;
	}

	/**
	 * The constructor without file filter.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the files will be read.
	 * @param aCancelOnZero
	 *            If this is true, the dialog will be canceled if the user
	 *            writes "0" as file path.
	 */
	public AbstractFileInputDialog(final String aDisplayText,
			final String[] aDialogTexts, final Boolean aCancelOnZero) {
		this(aDisplayText, aDialogTexts);
		cancelOnZero = aCancelOnZero;
	}

	/**
	 * The constructor without cancel on zero.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the files will be read.
	 * @param aFileFilter
	 *            The dialog will only accept files which are accepted by the
	 *            filter.
	 */
	public AbstractFileInputDialog(final String aDisplayText,
			final String[] aDialogTexts, final FileFilter aFileFilter) {
		this(aDisplayText, aDialogTexts, aFileFilter, false);
	}

	/**
	 * The constructor.
	 *
	 * @param aDisplayText
	 *            The display text for the dialog.
	 * @param aDialogTexts
	 *            The dialog texts for which the files will be read.
	 * @param aFileFilter
	 *            The dialog will only accept files which are accepted by the
	 *            filter.
	 * @param aCancelOnZero
	 *            If this is true, the dialog will be canceled if the user
	 *            writes "0" as file path.
	 */
	public AbstractFileInputDialog(final String aDisplayText,
			final String[] aDialogTexts, final FileFilter aFileFilter,
			final Boolean aCancelOnZero) {
		this(aDisplayText, aDialogTexts, aCancelOnZero);
		setFileFilter(aFileFilter);
	}

	/**
	 * This method checks if the file exists and if the file will be accepted by
	 * the file filter. If the file aren't existing or accepted by the filter an
	 * error will be printed.
	 *
	 * @param file
	 *            The file which will be checked.
	 * @return true if the file is accepted or no file filter is set.
	 */
	protected final boolean checkFile(final File file) {
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

	/**
	 * @see AbstractInputDialog#readInput(String)
	 * @return null if the dialog should be canceled.
	 */
	@Override
	protected final File readInput(final String aDialogText) {
		File file;
		boolean invalid = false;

		do {
			if (invalid) {
				ConsoleTools.printLine();
				printDialogText(aDialogText);
			}

			final String filePath = ConsoleReader.getInstance().readLine();
			if (cancelOnZero && filePath.equals(ZERO)) {
				file = null;
			} else {
				file = new File(filePath);

				invalid = checkFile(file);
			}
		} while (invalid);
		return file;
	}

	private boolean checkFileFilter(final File aFile) {
		return fileFilter == null || fileFilter.accept(aFile);
	}

	private void setFileFilter(final FileFilter aFileFilter) {
		fileFilter = aFileFilter;
	}

}
