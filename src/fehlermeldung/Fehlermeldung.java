package fehlermeldung;
import javax.swing.JOptionPane;

import gui.MainFrame;

public class Fehlermeldung {

	private MainFrame mainFrame; 
	
	public Fehlermeldung(MainFrame mainFrame)
	{
		this.mainFrame = mainFrame;
	}

	public void openFehlermeldungDialog(String fehlermeldung) {
		JOptionPane fehlerFenster = new JOptionPane();
		fehlerFenster.showMessageDialog(mainFrame, fehlermeldung, "Fehler!", JOptionPane.ERROR_MESSAGE);
	}

	public void openInfoDialog(String message, String title) {
		JOptionPane.showMessageDialog(mainFrame, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
}
