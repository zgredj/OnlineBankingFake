package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

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

public class Registrieren extends JPanel {

	public Registrieren(final MainFrame mainFrame) {

		Fehlermeldung fehlermeldung = new Fehlermeldung();
		DatenbankCode dbcode = new DatenbankCode();

		final JTextField textFieldKartennummer = new JTextField();
		final JPasswordField textFieldPassword = new JPasswordField();
		final JPasswordField textFieldPasswordWiederholen = new JPasswordField();
		final JTextField textFieldVorname = new JTextField();
		final JTextField textFieldNachname = new JTextField();
		final JTextField textFieldGeburtsdatum = new JTextField();
		final JTextField textFieldWohnort = new JTextField();
		final JTextField textFieldPlz = new JTextField();
		final JTextField textFieldStrasse = new JTextField();
		final JTextField textFieldHausNr = new JTextField();

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
		JPanel panelOsten = new JPanel(new BorderLayout());

		JButton buttonRegistrieren = new JButton("registrieren");

		buttonRegistrieren.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Connection connection = ConnectionFactory.getInstance().getConnection();
				KontoJDBCDao kontoJDBCDao = new KontoJDBCDao(connection);
				Konto konto = new Konto();

				int kartennummer = mainFrame.checkDigitReturnIntOrNegativError(textFieldKartennummer.getText());
				if (kartennummer < 0) {
					fehlermeldung.openFehlermeldungDialog("Die Kartennummer muss eine Zahl sein!", mainFrame);
					textFieldKartennummer.setText("");
					return;
				} else {
					ArrayList<Integer> listeKartennummernVonDatenbank = dbcode.getAlleKartennummernVonDatenbank();
					boolean istNichtVorhanden = true;
					for (Integer kartennummerVonDatenbank : listeKartennummernVonDatenbank) {
						if (kartennummer == kartennummerVonDatenbank) {
							istNichtVorhanden = false;
						}
					}
					if (istNichtVorhanden) {
						konto.setKartennummer(kartennummer);
					} else {
						fehlermeldung.openFehlermeldungDialog("Die Kartennummer ist schon Vorhanden!", mainFrame);
						textFieldKartennummer.setText("");
						return;
					}
				}

				String passwort1 = "";
				String passwort = new String(textFieldPassword.getPassword());
				if (!passwort.equals("")) {
					passwort1 = passwort;
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Passwort eingegeben werden!", mainFrame);
					textFieldPasswordWiederholen.setText("");
					return;
				}
				String passwort2 = new String(textFieldPasswordWiederholen.getPassword());
				if (passwort1.equals(passwort2)) {
					konto.setPasswort(passwort1);
				} else {
					fehlermeldung.openFehlermeldungDialog("Die eingegebenen Passwörter stimmen nicht überein!",
							mainFrame);
					textFieldPassword.setText("");
					textFieldPasswordWiederholen.setText("");
					return;
				}

				String vorname = textFieldVorname.getText();
				if (!vorname.equals("")) {
					konto.setVorname(vorname);
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Vorname eingegeben werden!", mainFrame);
					return;
				}

				String nachname = textFieldNachname.getText();
				if (!nachname.equals("")) {
					konto.setName(nachname);
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Nachname eingegeben werden!", mainFrame);
					return;
				}

				String geburtsdatum = textFieldGeburtsdatum.getText();
				if (!geburtsdatum.equals("")) {
					konto.setGeburtsdatum(geburtsdatum);
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Geburtsdatum eingegeben werden!", mainFrame);
					return;
				}

				AdresseJDBCDao adresseJDBCDao = new AdresseJDBCDao(connection);
				Adresse adresse = new Adresse();

				String wohnort = textFieldWohnort.getText();
				if (!wohnort.equals("")) {
					adresse.setWohnort(wohnort);
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss ein Wohnort eingegeben werden!", mainFrame);
					return;
				}

				int plz = mainFrame.checkDigitReturnIntOrNegativError(textFieldPlz.getText());
				if (plz < 0) {
					fehlermeldung.openFehlermeldungDialog("Die PLZ muss eine Zahl sein!", mainFrame);
					textFieldPlz.setText("");
					return;
				} else {
					adresse.setPlz(plz);
				}

				String strasse = textFieldStrasse.getText();
				if (!strasse.equals("")) {
					adresse.setStrasse(strasse);
				} else {
					fehlermeldung.openFehlermeldungDialog("Es muss eine Strasse eingegeben werden!", mainFrame);
					return;
				}

				int hausnummer = mainFrame.checkDigitReturnIntOrNegativError(textFieldHausNr.getText());
				if (hausnummer < 0) {
					fehlermeldung.openFehlermeldungDialog("Die Hausnummer muss eine Zahl sein!", mainFrame);
					textFieldHausNr.setText("");
					return;
				} else {
					adresse.setHausnummer(hausnummer);
				}

				kontoJDBCDao.insertKonto(konto);
				adresseJDBCDao.insertAdresse(adresse);

				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(new LayoutEingeloggt(mainFrame));
				mainFrame.getContentPane().revalidate();
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
