package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleTools {
	private static final Logger LOG = LogManager.getRootLogger();

	public static final String TAB = "    ";
	public static final String MENUE_PUNKT_PRINT_PATTERN = "%d."
			+ ConsoleTools.TAB + "%s";
	private static final String LINE = "##############################";

	public static void printTitle(String aTitle) {
		printLine();
		LOG.info(TAB + aTitle);
	}

	public static void printLine() {
		LOG.info(LINE);
	}

	public static Logger getLogger() {
		return LOG;
	}

	public static void close() {
		ConsoleReader.getInstance().close();
	}

}
