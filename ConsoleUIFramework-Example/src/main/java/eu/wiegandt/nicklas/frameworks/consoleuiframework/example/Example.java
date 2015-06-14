package eu.wiegandt.nicklas.frameworks.consoleuiframework.example;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

/**
 * This is the main class for the console ui framework example.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public final class Example {
	private static Example		instance;
	private static final String	TITLE	= "Console UI Framework - Example";

	private boolean				run;

	public static Example getInstance() {
		if (instance == null) {
			instance = new Example();
		}
		return instance;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            The program arguments.
	 */
	public static void main(final String[] args) {
		Example.getInstance().start();
	}

	private Example() {
	}

	public void setRun(final boolean aRun) {
		run = aRun;
	}

	private void start() {
		run = true;
		ConsoleTools.printTitle(TITLE);
		final MainMenu mainmenu = new MainMenu();
		while (run) {
			mainmenu.start();
		}
		ConsoleTools.close();
	}

}
