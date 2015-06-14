package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import java.util.SortedMap;
import java.util.TreeMap;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Dialogs;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Errors;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.MetaTexts;

/**
 * This class contains all methods which are needed for a working menu. <br>
 * <hr>
 * <br>
 * <img src="doc-files/AbstractMenu.png" alt="AbstractMenu">
 * 
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public abstract class AbstractMenu extends AbstractMenuEntry {
	private static final String							MENU_ENTRY_PRINT_PATTERN	= "%d."
																							+ ConsoleTools.TAB
																							+ "%s";
	private static final int							RETURN_ENTRY_NUMBER			= 0;
	private boolean										hasParent;
	private final SortedMap<Integer, AbstractMenuEntry>	menuEntries;

	/**
	 * The constructor for a main menu. The hasParent filed will be set to
	 * false.
	 * 
	 * @param aDisplayText
	 *            The display text.
	 */
	public AbstractMenu(final String aDisplayText) {
		this(aDisplayText, false);
	}

	/**
	 * The constructor.
	 * 
	 * @param aDisplayText
	 *            The display text.
	 * @param aHasParent
	 *            If true the menu print a return menu entry.
	 */
	public AbstractMenu(final String aDisplayText, final boolean aHasParent) {
		super(aDisplayText);
		menuEntries = new TreeMap<Integer, AbstractMenuEntry>();
		hasParent = aHasParent;
	}

	@Override
	public final void start() {
		fillMenuEntriesIfNecessary();
		printMenuEntries();
		chooseEntry();
	}

	/**
	 * This method adds menu entries to the method.
	 * 
	 * @param aMenuEntries
	 *            The menu entries wich will be set.
	 */
	protected final void addMenuEntries(final AbstractMenuEntry... aMenuEntries) {
		for (AbstractMenuEntry menuEntry : aMenuEntries) {
			int nextNumber = getNextNumberForEntry();
			menuEntries.put(nextNumber, menuEntry);
		}
	}

	/**
	 * This method fills the menu with entries.
	 */
	protected abstract void fillMenuEntries();

	private void chooseEntry() {
		boolean numberIsInvalid;
		int entryNumber;
		do {
			Dialogs.CHOOSE_ENTRY.print();
			entryNumber = ConsoleReader.readNumber();

			numberIsInvalid = entryNumber != RETURN_ENTRY_NUMBER
					&& !menuEntries.containsKey(entryNumber);

			if (numberIsInvalid) {
				Errors.ENTRY_NOT_EXISTS.print();
			}
		} while (numberIsInvalid);
		startChoosenEntry(entryNumber);
	}

	private void fillMenuEntriesIfNecessary() {
		if (menuEntries.isEmpty()) {
			fillMenuEntries();
		}
	}

	private int getNextNumberForEntry() {
		return menuEntries.size() + 1;
	}

	private void printMenuEntries() {
		ConsoleTools.printLine();
		for (Integer menuEntryNumber : menuEntries.keySet()) {
			ConsoleTools.getLogger().info(
					String.format(MENU_ENTRY_PRINT_PATTERN, menuEntryNumber,
							menuEntries.get(menuEntryNumber).getDisplayText()));
		}
		if (hasParent) {
			printReturnEntry();
		}
	}

	private void printReturnEntry() {
		ConsoleTools.getLogger().info(
				String.format(MENU_ENTRY_PRINT_PATTERN, RETURN_ENTRY_NUMBER,
						MetaTexts.RETURN.getDisplayText()));
	}

	private void startChoosenEntry(final int aEntryNumber) {
		if (aEntryNumber != RETURN_ENTRY_NUMBER) {
			menuEntries.get(aEntryNumber).start();
		}
	}

}
