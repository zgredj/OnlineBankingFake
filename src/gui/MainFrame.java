package gui;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public JPanel alles = new JPanel();
	
	public MainFrame() {
		setTitle("BBC BANK - Online Banking");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//"alles" setzt einen Abstand von Aussen zu allem Inhalt.
		alles.setBorder(BorderFactory.createEmptyBorder(40, 120, 10, 100));
		
		alles.add(new Login());
		
	}
}