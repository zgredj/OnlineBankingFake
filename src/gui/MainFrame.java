package gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame() {
		setTitle("BBC BANK - Online Banking");
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// add(new LayoutEingeloggt(this));
		// add(new Registrieren());
		add(new Login(this));

		setVisible(true);
	}

	public int checkDigitReturnIntOrNegativError(String uncheckedString) {
		int checkedInteger = -1;
		try {
			checkedInteger = Integer.parseInt(uncheckedString);
		} catch (NumberFormatException nfe) {
			//Error
			return -1;
			//Error
		}
		return checkedInteger;
	}
}