import javax.swing.JOptionPane;

import gui.MainFrame;

public class Fehlermeldung {

	public void fehlermeldung(String fehlermeldung, MainFrame mainFrame) {
		JOptionPane fehlerFenster = new JOptionPane();
		fehlerFenster.showMessageDialog(mainFrame, fehlermeldung, JOptionPane.ERROR_MESSAGE);
	}
}
