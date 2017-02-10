package testerKlassen;

import javax.swing.JOptionPane;

import gui.MainFrame;

public class TesterFehlermeldungGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame h3 = new MainFrame();
		JOptionPane.showMessageDialog(h3, "Passwörter stimmen nicht überrein", "Error", JOptionPane.ERROR_MESSAGE);

	}

}
