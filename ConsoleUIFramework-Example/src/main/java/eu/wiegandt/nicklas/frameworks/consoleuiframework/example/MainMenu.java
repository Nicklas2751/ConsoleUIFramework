package eu.wiegandt.nicklas.frameworks.consoleuiframework.example;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.AbstractMenu;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.ExitMenuEntry;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs.FileInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs.IntegerInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.menuentries.dialogs.TextInputDialog;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums.DisplayTexts;

/**
 * This class is an example for a main menu.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public class MainMenu extends AbstractMenu {

	public MainMenu() {
		super(DisplayTexts.MAINMENU.getDisplayText());
	}

	@Override
	protected final void fillMenuEntries() {
		addMenuEntries(new FileInputDialog());
		addMenuEntries(new IntegerInputDialog());
		addMenuEntries(new TextInputDialog());
		addMenuEntries(new ExitMenuEntry());
	}

}
