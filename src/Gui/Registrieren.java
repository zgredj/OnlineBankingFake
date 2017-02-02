package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrieren extends BasisLayout {

	public Registrieren() {
		//JTextField textFieldKartennummer2 = new JTextField("Kartennummer"); 
		//add(textFieldKartennummer2);
		JLabel labelTitel = new JLabel("Neues Benutzerkonto");
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(100, 230, 0, 0));
		panelKopfzeile.add(labelTitel, BorderLayout.NORTH);

		add(panelKopfzeile, BorderLayout.NORTH);

		JPanel panelInhalt = new JPanel(); // new GridLayout(8, 1)
		panelInhalt.setBackground(Color.blue);

		JLabel labelTitel2 = new JLabel("Neues Benutzerkonto");
		// labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		panelInhalt.add(labelTitel2);

		add(panelInhalt, BorderLayout.SOUTH);
	}
}
