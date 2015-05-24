package eu.wiegandt.nicklas.frameworks.consoleuiframework.textenums;

import eu.wiegandt.nicklas.frameworks.consoleuiframework.ConsoleTools;

public enum Errors {
	ENTRY_NOT_EXISTS(
			"Der gewählte Eintrag konnte nicht gefunden werden. Bitte versuchen Sie es erneut."), FILE_DONT_MATCH_FILTER(
			"Die angegebene Datei entspricht nicht dem erwarteten Format! Bitte versuchen Sie es erneut."), FILE_DONT_EXISTS(
			"Die angegebene Datei konnte nicht gefunden werden! Bitte versuchen Sie es erneut!");

	private String displayText;

	private Errors(String aDisplayText) {
		displayText = aDisplayText;
	}

	public void print() {
		ConsoleTools.getLogger().error(displayText);
	}

}
