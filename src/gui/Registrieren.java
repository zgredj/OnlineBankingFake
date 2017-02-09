package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datenbank.Adresse;
import datenbank.Konto;

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

		JLabel labelKartennummer = new JLabel("Kartennummer");
		JLabel labelPassword = new JLabel("Passwort");
		JLabel labelPasswordWiederholen = new JLabel("Passwort wiederholen");
		JLabel labelVorname = new JLabel("Vorname");
		JLabel labelNachname = new JLabel("Nachname");
		JLabel labelGeburtsdatum = new JLabel("Geburtsdatum");
		JLabel labelWohnort = new JLabel("Wohnort");
		JLabel labelPlz = new JLabel("PLZ");
		JLabel labelStrasse = new JLabel("Strasse");
		JLabel labelHausNr = new JLabel("Haus Nr.");
		JLabel labelLeer = new JLabel(" ");

		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		JPanel panelInhalt = new JPanel(new GridLayout(11, 2, 30, 15));
		JPanel panelInhaltOrt = new JPanel(new BorderLayout());
		JPanel panelInhaltStrasse = new JPanel(new BorderLayout());
		JPanel panelOsten = new JPanel(new BorderLayout());

		JButton buttonRegistrieren = new JButton("registrieren");
		
		buttonRegistrieren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Konto konto = new Konto();
				konto.setKartennummer(Integer.parseInt(textFieldKartennummer.getText()));
				konto.setPasswort(new String(textFieldPassword.getPassword()));
				konto.setVorname(textFieldVorname.getText());
				konto.setName(textFieldNachname.getText());
				konto.setGeburtsdatum(textFieldGeburtsdatum.getText());
				Adresse adresse = new Adresse();
				adresse.setWohnort(textFieldWohnort.getText());
				adresse.setPlz(Integer.parseInt(textFieldPlz.getText()));
				adresse.setStrasse(textFieldStrasse.getText());
				adresse.setHausnummer(Integer.parseInt(textFieldHausNr.getText()));
			}
		});

		panelInhalt.add(labelKartennummer);
		panelInhalt.add(textFieldKartennummer);

		panelInhalt.add(labelPassword);
		panelInhalt.add(textFieldPassword);

		panelInhalt.add(labelPasswordWiederholen);
		panelInhalt.add(textFieldPasswordWiederholen);

		panelInhalt.add(labelVorname);
		panelInhalt.add(textFieldVorname);

		panelInhalt.add(labelNachname);
		panelInhalt.add(textFieldNachname);

		panelInhalt.add(labelGeburtsdatum);
		panelInhalt.add(textFieldGeburtsdatum);

		panelInhalt.add(labelWohnort);
		panelInhalt.add(textFieldWohnort);

		panelInhalt.add(labelPlz);
		panelInhalt.add(textFieldPlz);

		panelInhalt.add(labelStrasse);
		panelInhalt.add(textFieldStrasse);

		panelInhalt.add(labelHausNr);
		panelInhalt.add(textFieldHausNr);

		panelInhalt.add(labelLeer);
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
