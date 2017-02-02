package Gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrieren extends BasisLayout {

	public Registrieren() {
		JTextField textFieldKartennummer = new JTextField("Kartennummer");
		JTextField textFieldPassword = new JTextField("Passwort");
		JTextField textFieldPasswordWiederholen = new JTextField("Passwort wiederholen");
		JTextField textFieldVorname = new JTextField("Vorname");
		JTextField textFieldNachname = new JTextField("Nachname");
		JTextField textFieldGeburtsdatum = new JTextField("Geburtsdatum");
		JTextField textFieldWohnort = new JTextField("Wohnort");
		JTextField textFieldPlz = new JTextField("PLZ");
		JTextField textFieldStrasse = new JTextField("Strasse");
		JTextField textFieldHausNr = new JTextField("HausNr.");
		
		
		
		
		
		JPanel panelInhalt = new JPanel(new GridLayout(8, 1));
		add(panelInhalt, BorderLayout.CENTER);
		panelInhalt.add(textFieldKartennummer);
		JLabel labelTitel = new JLabel("Neues Benutzerkonto");
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(100, 230, 0, 0));
		panelKopfzeile.add(labelTitel, BorderLayout.NORTH);

		add(panelKopfzeile, BorderLayout.NORTH);


		add(panelInhalt, BorderLayout.SOUTH);
		setSize(1200, 800); 
		setResizable(false);
	}
}
