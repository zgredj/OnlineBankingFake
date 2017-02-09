package gui;

import java.awt.*;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public JPanel alles = new JPanel();
	
	public MainFrame() {
		setTitle("BBC BANK - Online Banking");
		
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//"alles" setzt einen Abstand von Aussen zu allem Inhalt.
		
		
		add(new LayoutEingeloggt());
		//add(new Registrieren());
		//add(new Login());
		
		setVisible(true);
	}
}