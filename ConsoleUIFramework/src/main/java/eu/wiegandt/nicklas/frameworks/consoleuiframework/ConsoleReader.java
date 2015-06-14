package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.DebugMessages;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Errors;

/**
 * This is a console line reader which can read strings and integers from the
 * console.
 *
 * <br>
 * <hr>
 * <br>
 * <img src="doc-files/ConsoleReader.png" alt="ConsoleReader">
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public final class ConsoleReader {

	private static ConsoleReader	instance;

	private final BufferedReader	bufferedReader;

	/**
	 * @return A instance of the class.
	 */
	public static ConsoleReader getInstance() {
		if (instance == null) {
			instance = new ConsoleReader();
		}
		return instance;
	}

	/**
	 * Reads an integer from the console. If the console input wasn't an
	 * integer, a error will be printed and the input will be read again.
	 *
	 * @return The read number.
	 */
	public static Integer readNumber() {
		Integer number;
		do {
			final String inputText = getInstance().readLine();
			try {
				number = Integer.parseInt(inputText);
			} catch (final NumberFormatException numberFormatException) {
				number = null;
				Errors.NUMBER_INPUT_INVALID.print();
			}
		} while (number == null);
		return number;
	}

	private ConsoleReader() {
		final InputStreamReader inputStreamReader = new InputStreamReader(
				System.in);
		bufferedReader = new BufferedReader(inputStreamReader);
	}

	/**
	 * This method closes the resources.
	 */
	public void close() {
		try {
			bufferedReader.close();
		} catch (final IOException ioException2) {
			DebugMessages.BUFFERED_READER_CANT_CLOSED.print(ioException2);
		}
	}

	/**
	 * This methods read a line from the console as a string.
	 *
	 * @return The read line as a string.
	 */
	public String readLine() {
		String line;
		try {
			line = bufferedReader.readLine();
		} catch (final IOException ioException) {
			Errors.INPUT_READ_ERROR.printFatal(ioException);
			line = "";
		}
		return line;
	}

}
