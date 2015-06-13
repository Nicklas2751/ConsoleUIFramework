package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class contains some console tools.
 * 
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/ConsoleTools.png" alt="ConsoleTools">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class ConsoleTools {
	/**
	 * A print pattern for menu entries.
	 */
	public static final String MENUE_ENTRY_PRINT_PATTERN = "%d."
			+ ConsoleTools.TAB + "%s";
	/**
	 * Represents a Tab.
	 */
	public static final String TAB = "    ";

	private static final String LINE = "##############################";
	private static final Logger LOG = LogManager.getRootLogger();

	/**
	 * This method closes the resources.
	 */
	public static void close() {
		ConsoleReader.getInstance().close();
	}

	/**
	 * @return The Logger.
	 */
	public static Logger getLogger() {
		return LOG;
	}

	/**
	 * Prints a hashtag Line.
	 */
	public static void printLine() {
		LOG.info(LINE);
	}

	/**
	 * Logs the given title as info.
	 * 
	 * @param aTitle
	 *            The title.
	 */
	public static void printTitle(String aTitle) {
		printLine();
		LOG.info(TAB + aTitle);
	}

}
