package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.filefilter;

import java.io.File;
import java.io.FileFilter;

/**
 * This is a simple file filter to check if a given file is a folder.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class FolderFileFilter implements FileFilter {

	/**
	 * Checks if a given file is a folder.
	 *
	 * @see FileFilter#accept(File)
	 * @param aFile
	 *            A file which should be checked.
	 * @return True if the file isn't null, exists and is a directory.
	 */
	@Override
	public final boolean accept(final File aFile) {
		return aFile != null && aFile.exists() && aFile.isDirectory();
	}

}
