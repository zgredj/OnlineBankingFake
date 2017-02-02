package Gui;

import java.awt.*;

import javax.swing.*;

public class BasisLayout extends JFrame {
	
	JPanel alles = new JPanel(new BorderLayout());
	
	public BasisLayout() {
		setTitle("BBC BANK - Online Banking");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		alles.setBorder(BorderFactory.createEmptyBorder(40, 120, 10, 100));
	}
}