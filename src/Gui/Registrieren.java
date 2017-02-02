package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrieren extends BasisLayout {

	public Registrieren() {

		JTextField textFieldKartennummer = new JTextField("Kartennummer", 10);
		JTextField textFieldPassword = new JTextField("Passwort");
		JTextField textFieldPasswordWiederholen = new JTextField("Passwort wiederholen");
		JTextField textFieldVorname = new JTextField("Vorname");
		JTextField textFieldNachname = new JTextField("Nachname");
		JTextField textFieldGeburtsdatum = new JTextField("Geburtsdatum");
		JTextField textFieldWohnort = new JTextField("Wohnort");
		JTextField textFieldPlz = new JTextField("PLZ");
		JTextField textFieldStrasse = new JTextField("Strasse");
		JTextField textFieldHausNr = new JTextField("HausNr.");

		JPanel panelInhalt = new JPanel(new GridLayout(10, 1));
		panelInhalt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 1000));
		JPanel panelInhaltOrt = new JPanel(new BorderLayout());
		JPanel panelInhaltStrasse = new JPanel(new BorderLayout());
		add(panelInhalt, BorderLayout.WEST);

		panelInhalt.add(textFieldKartennummer);
		panelInhalt.add(textFieldPassword);
		panelInhalt.add(textFieldPasswordWiederholen);
		panelInhalt.add(textFieldVorname);
		panelInhalt.add(textFieldNachname);
		panelInhalt.add(textFieldGeburtsdatum);
		panelInhalt.add(textFieldWohnort);
		panelInhalt.add(textFieldPlz);
		panelInhalt.add(panelInhaltOrt);
		panelInhalt.add(panelInhaltStrasse);

		panelInhaltOrt.add(textFieldWohnort, BorderLayout.WEST);
		panelInhaltOrt.add(textFieldPlz, BorderLayout.CENTER);

		panelInhaltStrasse.add(textFieldStrasse, BorderLayout.WEST);
		panelInhaltStrasse.add(textFieldHausNr, BorderLayout.CENTER);

		JLabel labelTitel = new JLabel("Neues Benutzerkonto");
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		panelKopfzeile.add(labelTitel, BorderLayout.NORTH);

		add(panelKopfzeile, BorderLayout.NORTH);

		add(panelInhalt, BorderLayout.SOUTH);
		setSize(1200, 800);
		setResizable(true);
	}
}
