package Gui;

import java.awt.*;

import javax.swing.*;

public class BasisLayout extends JFrame {
	public BasisLayout() {
		setTitle("BBC BANK - Online Banking");
		setVisible(true);
		setSize(1200, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel alles = new JPanel();
		alles.setLayout(new BorderLayout());
		
		add(alles);
	}
}