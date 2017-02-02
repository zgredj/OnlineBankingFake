package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrieren extends BasisLayout {

	public Registrieren() {

		JLabel labelTitel = new JLabel();
		JPanel panel = new JPanel(new BorderLayout());
		labelTitel.setText("Neues Benutzerkonto");
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		
		add(panel, BorderLayout.NORTH);
		panel.setBorder(BorderFactory.createEmptyBorder(100, 230, 0, 0));
		panel.add(labelTitel, BorderLayout.WEST);
		
		JTextField kartennummer = new JTextField("Kartennummer", 15);
		.add(kartennummer, BorderLayout.NORTH);
		
	}
}
