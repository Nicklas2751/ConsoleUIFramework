package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleReader {
	private static final Logger LOG = LogManager.getLogger(ConsoleReader.class);

	private static ConsoleReader instance;

	private BufferedReader bufferedReader;

	private ConsoleReader() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		bufferedReader = new BufferedReader(inputStreamReader);
	}

	public static ConsoleReader getInstance() {
		if (instance == null) {
			instance = new ConsoleReader();
		}
		return instance;
	}

	public static Integer readNumber() {
		Integer number;
		do {
			String inputText = getInstance().readLine();
			try {
				number = Integer.parseInt(inputText);
			} catch (NumberFormatException numberFormatException) {
				number = null;
				LOG.info("Ihre Eingabe war keine valide Nummer! Bitte versuchen Sie es erneut:");
			}
		} while (number == null);
		return number;
	}

	public String readLine() {
		String line;
		try {
			line = bufferedReader.readLine();
		} catch (IOException ioException) {
			LOG.fatal("Beim Lesen der Eingabe ist ein Fehler aufgetreten!",
					ioException);
			line = "";
		}
		return line;
	}

	public void close() {
		try {
			bufferedReader.close();
		} catch (IOException ioException2) {
			LOG.debug(
					"Beim schlieÃen des BufferedReaders ist ein weiterer Fehler aufgetreten!",
					ioException2);
		}
	}

}
