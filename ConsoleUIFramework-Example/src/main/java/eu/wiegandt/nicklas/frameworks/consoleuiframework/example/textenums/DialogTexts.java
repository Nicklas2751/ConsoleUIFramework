package eu.wiegandt.nicklas.frameworks.consoleuiframework.example.textenums;

/**
 * This enumeration contains the dialog texts. The dialog texts are shown in the
 * dialogs when the user should input something.
 *
 * @author Nicklas Wiegandt (Nicklas2751)<br>
 *         <b>Mail:</b> nicklas@wiegandt.eu<br>
 *         <b>Jabber:</b> nicklas2751@elaon.de<br>
 *
 */
public enum DialogTexts {
	/**
	 * The dialog is canceled.
	 */
	CANCELED_DIALOG("Der Dialog wurde abgebrochen."),
	/**
	 * Folder input whit cancel on 0.
	 */
	FOLDER_INPUT(
			"Bitte wählen Sie einen Ordner aus (bei Eingabe von \"0\" wird dieser Dialog abgebrochen):"),
			/**
			 * Integer input.
			 */
			INTEGER_INPUT("Bitte geben Sie eine Ganzzahl ein:"),
			/**
			 * Text input.
			 */
			TEXT_INPUT("Bitte geben Sie einen Text ein:");

	private String	text;

	private DialogTexts(final String aText) {
		text = aText;
	}

	public String getText() {
		return text;
	}
}
