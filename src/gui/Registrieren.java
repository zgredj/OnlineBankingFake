package gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registrieren extends JPanel {

	public Registrieren() {

		JTextField textFieldKartennummer = new JTextField();
		JPasswordField textFieldPassword = new JPasswordField();
		JPasswordField textFieldPasswordWiederholen = new JPasswordField();
		JTextField textFieldVorname = new JTextField();
		JTextField textFieldNachname = new JTextField();
		JTextField textFieldGeburtsdatum = new JTextField();
		JTextField textFieldWohnort = new JTextField();
		JTextField textFieldPlz = new JTextField();
		JTextField textFieldStrasse = new JTextField();
		JTextField textFieldHausNr = new JTextField();
		
		JLabel labelTitel = new JLabel("Neues Benutzerkonto");
		
		JLabel stringKartennummer = new JLabel("Kartennummer");
		JLabel stringPassword = new JLabel("Passwort");
		JLabel stringPasswordWiederholen = new JLabel("Passwort wiederholen");
		JLabel stringVorname = new JLabel("Vorname");
		JLabel stringNachname = new JLabel("Nachname");
		JLabel stringGeburtsdatum = new JLabel("Geburtsdatum");
		JLabel stringWohnort = new JLabel("Wohnort");
		JLabel stringPlz = new JLabel("PLZ");
		JLabel stringStrasse = new JLabel("Strasse");
		JLabel stringHausNr = new JLabel("Haus Nr.");
		JLabel stringLeer = new JLabel(" ");
		
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		
		JPanel panelInhalt = new JPanel(new GridLayout(11, 2, 30, 15));
		JPanel panelInhaltOrt = new JPanel(new BorderLayout());
		JPanel panelInhaltStrasse = new JPanel(new BorderLayout());
		JPanel panelOsten = new JPanel(new BorderLayout());
		
		JButton buttonRegistrieren = new JButton("registrieren");

		panelInhalt.add(stringKartennummer);
		panelInhalt.add(textFieldKartennummer);
		
		panelInhalt.add(stringPassword);
		panelInhalt.add(textFieldPassword);
		
		panelInhalt.add(stringPasswordWiederholen);
		panelInhalt.add(textFieldPasswordWiederholen);
		
		panelInhalt.add(stringVorname);
		panelInhalt.add(textFieldVorname);
		
		panelInhalt.add(stringNachname);
		panelInhalt.add(textFieldNachname);
		
		panelInhalt.add(stringGeburtsdatum);
		panelInhalt.add(textFieldGeburtsdatum);
		
		panelInhalt.add(stringWohnort);
		panelInhalt.add(textFieldWohnort);
		
		panelInhalt.add(stringPlz);
		panelInhalt.add(textFieldPlz);
		
		panelInhalt.add(stringStrasse);
		panelInhalt.add(textFieldStrasse);
		
		panelInhalt.add(stringHausNr);
		panelInhalt.add(textFieldHausNr);
		
		panelInhalt.add(stringLeer);
		panelInhalt.add(buttonRegistrieren);

		
		
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		
		add(panelInhalt, BorderLayout.CENTER);
		add(panelKopfzeile, BorderLayout.NORTH);
		
		
		
		panelKopfzeile.add(labelTitel, BorderLayout.NORTH);
		panelKopfzeile.add(panelInhalt, BorderLayout.WEST);
		panelKopfzeile.add(panelOsten, BorderLayout.EAST);
		panelInhalt.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 0));
		
	}
}
