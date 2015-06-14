package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.AbstractMenuEntry;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.Example;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DisplayTexts;

/**
 * This is a example menu entry which exits the program.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class ExitMenuEntry extends AbstractMenuEntry {

	public ExitMenuEntry() {
		super(DisplayTexts.EXIT.getDisplayText());
	}

	@Override
	public final void start() {
		ConsoleTools.printLine();
		Example.getInstance().setRun(false);
	}

}
