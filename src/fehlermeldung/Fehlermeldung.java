package fehlermeldung;
import javax.swing.JOptionPane;

import gui.MainFrame;

public class Fehlermeldung {

	public void openFehlermeldungDialog(String fehlermeldung, MainFrame mainFrame) {
		JOptionPane.showMessageDialog(mainFrame, fehlermeldung, "Fehler!", JOptionPane.ERROR_MESSAGE);
	}
}
