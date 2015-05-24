package eu.wiegandt.nicklas.frameworks.consoleuiframework;

import java.util.SortedMap;
import java.util.TreeMap;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Dialogs;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.Errors;
import eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums.MetaTexts;

public abstract class AbstractMenu extends AbstractMenuEntry {
	private static final String MENU_ENTRY_PRINT_PATTERN = "%d."
			+ ConsoleTools.TAB + "%s";
	private static final int RETURN_ENTRY_NUMBER = 0;
	private final SortedMap<Integer, AbstractMenuEntry> menuEntries;
	private boolean hasParent;

	public AbstractMenu(String aDisplayText) {
		this(aDisplayText, false);
	}

	public AbstractMenu(String aDisplayText, boolean aHasParent) {
		super(aDisplayText);
		menuEntries = new TreeMap<Integer, AbstractMenuEntry>();
		hasParent = aHasParent;
		fillMenuEntries();
	}

	protected abstract void fillMenuEntries();

	protected final void addMenuEntries(AbstractMenuEntry... aMenuEntries) {
		for (AbstractMenuEntry menuEntry : aMenuEntries) {
			int nextNumber = getNextNumberForEntry();
			menuEntries.put(nextNumber, menuEntry);
		}
	}

	private final int getNextNumberForEntry() {
		int nextNumber;
		if (hasParent && menuEntries.isEmpty()) {
			nextNumber = 1;
		} else {
			nextNumber = menuEntries.size();
		}
		return nextNumber;
	}

	@Override
	public final void start() {
		printMenuEntries();
		chooseEntry();
	}

	private final void chooseEntry() {
		boolean numberIsInvalid;
		int entryNumber;
		do {
			Dialogs.CHOOSE_ENTRY.print();
			entryNumber = ConsoleReader.readNumber();

			numberIsInvalid = entryNumber != RETURN_ENTRY_NUMBER
					&& menuEntries.containsKey(entryNumber);

			if (numberIsInvalid) {
				Errors.ENTRY_NOT_EXISTS.print();
			}
		} while (numberIsInvalid);
		startChoosenEntry(entryNumber);
	}

	private final void startChoosenEntry(int entryNumber) {
		if (entryNumber != RETURN_ENTRY_NUMBER) {
			menuEntries.get(entryNumber).start();
		}
	}

	private final void printMenuEntries() {
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

	private final void printReturnEntry() {
		ConsoleTools.getLogger().info(
				String.format(MENU_ENTRY_PRINT_PATTERN, RETURN_ENTRY_NUMBER,
						menuEntries.get(MetaTexts.RETURN.getDisplayText())
								.getDisplayText()));
	}

}
