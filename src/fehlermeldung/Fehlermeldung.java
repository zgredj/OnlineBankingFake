package fehlermeldung;
import javax.swing.JOptionPane;

import gui.MainFrame;

public class Fehlermeldung {

	public void openFehlermeldungDialog(String fehlermeldung, MainFrame mainFrame) {
		JOptionPane fehlerFenster = new JOptionPane();
		fehlerFenster.showMessageDialog(mainFrame, fehlermeldung, "Fehler!", JOptionPane.ERROR_MESSAGE);
	}
}
