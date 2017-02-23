package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datenbank.Adresse;
import datenbank.AdresseJDBCDao;
import datenbank.ConnectionFactory;
import datenbank.DatenbankCode;
import datenbank.Konto;
import datenbank.KontoJDBCDao;
import fehlermeldung.Fehlermeldung;
import util.Helper;

public class Registrieren extends JPanel {

	private JButton buttonRegistrieren = new JButton("registrieren");

	private JTextField textFieldKartennummer = new JTextField();
	private JPasswordField textFieldPassword = new JPasswordField();
	private JPasswordField textFieldPasswordWiederholen = new JPasswordField();
	private JTextField textFieldVorname = new JTextField();
	private JTextField textFieldNachname = new JTextField();
	private JTextField textFieldGeburtsdatum = new JTextField();
	private JTextField textFieldWohnort = new JTextField();
	private JTextField textFieldPlz = new JTextField();
	private JTextField textFieldStrasse = new JTextField();
	private JTextField textFieldHausNr = new JTextField();

	private JLabel labelTitel = new JLabel("Neues Benutzerkonto");
	private JLabel labelKartennummer = new JLabel("Kartennummer");
	private JLabel labelPassword = new JLabel("Passwort");
	private JLabel labelPasswordWiederholen = new JLabel("Passwort wiederholen");
	private JLabel labelVorname = new JLabel("Vorname");
	private JLabel labelNachname = new JLabel("Nachname");
	private JLabel labelGeburtsdatum = new JLabel("Geburtsdatum");
	private JLabel labelWohnort = new JLabel("Wohnort");
	private JLabel labelPlz = new JLabel("PLZ");
	private JLabel labelStrasse = new JLabel("Strasse");
	private JLabel labelHausNr = new JLabel("Haus Nr.");
	private JLabel labelLeer = new JLabel(" ");

	private JPanel panelGanzeGUI = new JPanel(new BorderLayout());
	private JPanel panelInhalt = new JPanel(new GridLayout(11, 2, 30, 15));
	private JPanel panelOsten = new JPanel(new BorderLayout());

	public Registrieren(final Navigator navigator, Fehlermeldung fehlermeldung) {

		buttonRegistrieren.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				KontoJDBCDao kontoJDBCDao = new KontoJDBCDao(connection);
				Konto konto = new Konto();

				int kartennummer = Helper.checkDigitReturnIntOrNegativError(textFieldKartennummer.getText());
				if (kartennummer < 0) {
					fehlermeldung.openFehlermeldungDialog("Die Kartennummer muss eine Zahl sein!");
					textFieldKartennummer.setText("");
					return;
				} else {
					if (!DatenbankCode.istKartennummerVorhanden(kartennummer)) {
						konto.setKartennummer(kartennummer);
					} else {
						fehlermeldung.openFehlermeldungDialog("Die Kartennummer ist schon Vorhanden!");
						textFieldKartennummer.setText("");
						return;
					}
				}

				String passwort1 = "";
				String passwort = new String(textFieldPassword.getPassword());
				if (!passwort.equals("")) {
					if (passwort.length() <= 45) {
						passwort1 = passwort;
					} else {
						fehlermeldung.openFehlermeldungDialog("Das Passwort darf maximal 45 Zeichen lang sein!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Passwort eingegeben werden!");
					textFieldPasswordWiederholen.setText("");
					return;
				}
				String passwort2 = new String(textFieldPasswordWiederholen.getPassword());
				if (passwort1.equals(passwort2)) {
					konto.setPasswort(passwort1);
				} else {
					fehlermeldung.openFehlermeldungDialog("Die eingegebenen Passwoerter stimmen nicht ueberein!");
					textFieldPassword.setText("");
					textFieldPasswordWiederholen.setText("");
					return;
				}

				String vorname = textFieldVorname.getText();
				if (!vorname.equals("")) {
					if (vorname.length() <= 45) {
						konto.setVorname(vorname);
					} else {
						fehlermeldung.openFehlermeldungDialog("Der Vorname darf maximal 45 Zeichen lang sein!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Vorname eingegeben werden!");
					return;
				}

				String nachname = textFieldNachname.getText();
				if (!nachname.equals("")) {
					if (nachname.length() <= 45) {
						konto.setName(nachname);
					} else {
						fehlermeldung.openFehlermeldungDialog("Der Nachname darf maximal 45 Zeichen lang sein!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Nachname eingegeben werden!");
					return;
				}

				String geburtsdatum = textFieldGeburtsdatum.getText();
				if (!geburtsdatum.equals("")) {
					if (geburtsdatum.length() <= 10) {
						konto.setGeburtsdatum(geburtsdatum);
					} else {
						fehlermeldung.openFehlermeldungDialog("Das Datum ist zu lang!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Das Geburtsdatum darf maximal 10 Zeichen lang sein!!");
					return;
				}

				AdresseJDBCDao adresseJDBCDao = new AdresseJDBCDao(connection);
				Adresse adresse = new Adresse();

				String wohnort = textFieldWohnort.getText();
				if (!wohnort.equals("")) {
					if (wohnort.length() <= 45) {
						adresse.setWohnort(wohnort);
					} else {
						fehlermeldung.openFehlermeldungDialog("Der Wohnort darf maximal 45 Zeichen lang sein!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Wohnort eingegeben werden!");
					return;
				}

				int plz = Helper.checkDigitReturnIntOrNegativError(textFieldPlz.getText());
				if (plz < 0) {
					fehlermeldung.openFehlermeldungDialog("Die PLZ muss eine Zahl sein!");
					textFieldPlz.setText("");
					return;
				} else {
					adresse.setPlz(plz);
				}

				String strasse = textFieldStrasse.getText();
				if (!strasse.equals("")) {
					if (strasse.length() <= 45) {
						adresse.setStrasse(strasse);
					} else {
						fehlermeldung.openFehlermeldungDialog("Die Strasse darf maximal 45 Zeichen lang sein!");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss eine Strasse eingegeben werden!");
					return;
				}

				int hausnummer = Helper.checkDigitReturnIntOrNegativError(textFieldHausNr.getText());
				if (hausnummer < 0) {
					fehlermeldung.openFehlermeldungDialog("Die Hausnummer muss eine Zahl sein!");
					textFieldHausNr.setText("");
					return;
				} else {
					adresse.setHausnummer(hausnummer);
				}

				kontoJDBCDao.insertKontoIntoDatabase(konto);
				adresseJDBCDao.insertAdresseIntoDatabase(adresse);

				navigator.navigate(EnumGui.LayoutEingeloggt);
				DatenbankCode.setAllUserInformationsByKartennummer(kartennummer, navigator);
				try {
					connection.close();
				} catch (SQLException e1) {
					throw new RuntimeException();
				}
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
		panelInhalt.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 0));
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		
		panelGanzeGUI.add(labelTitel, BorderLayout.NORTH);
		panelGanzeGUI.add(panelInhalt, BorderLayout.WEST);
		panelGanzeGUI.add(panelOsten, BorderLayout.EAST);

		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));

		add(panelGanzeGUI, BorderLayout.NORTH);
		add(panelInhalt, BorderLayout.CENTER);
	}
}