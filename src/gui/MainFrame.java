package gui;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {

	public MainFrame() {
		setTitle("BBC BANK - Online Banking");

		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//add(new LayoutEingeloggt());
		add(new Registrieren());
		// add(new Login());

		setVisible(true);
	}
}