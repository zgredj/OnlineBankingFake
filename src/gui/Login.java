package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datenbank.ConnectionFactory;
import datenbank.DatenbankCode;
import datenbank.User;
import fehlermeldung.Fehlermeldung;
import util.Helper;

public class Login extends JPanel {

	private JLabel labelLogin = new JLabel("Login");
	private JLabel labelBbcBank = new JLabel("BBC BANK");
	private JLabel labelKartennummer = new JLabel("Kartennummer:");
	private JLabel labelPasswort = new JLabel("Passwort:");
	private JLabel labelText = new JLabel("Noch kein Benutzerkonto?");

	private JPanel panelSeite = new JPanel();
	private JPanel panelLogin = new JPanel(new BorderLayout());
	private JPanel panelTitel = new JPanel(new BorderLayout());
	private JPanel panelButtonLogin = new JPanel(new BorderLayout());
	private JPanel panelText = new JPanel(new BorderLayout());
	private JPanel panelButtonRegistrieren = new JPanel(new BorderLayout());
	private JPanel panelTitelLogin = new JPanel(new BorderLayout());
	private JPanel panelPlatzhalter = new JPanel();
	private JPanel panelKartennummerPasswortLogin = new JPanel();
	private JPanel panelTextRegistrieren = new JPanel();

	private JButton buttonLogin = new JButton("Login");
	private JButton buttonRegistrieren = new JButton("Registrieren");

	private JTextField textFieldKartennummer = new JTextField(17);
	private JPasswordField textFieldPasswort = new JPasswordField(20);

	public Login(final Navigator navigator, Fehlermeldung fehlermeldung) {

		labelBbcBank.setFont(new Font("Arial", Font.PLAIN, 80));
		labelLogin.setFont(new Font("Arial", Font.PLAIN, 50));
		labelKartennummer.setFont(new Font("Arial", Font.PLAIN, 16));
		labelPasswort.setFont(new Font("Arial", Font.PLAIN, 16));

		panelTitel.add(labelBbcBank, BorderLayout.CENTER);
		panelSeite.setLayout(new BorderLayout());
		panelLogin.add(labelLogin, BorderLayout.CENTER);
		panelButtonLogin.setBorder(BorderFactory.createEmptyBorder(5, 90, 0, 0));
		panelButtonLogin.add(buttonLogin);
		panelText.add(labelText);
		panelButtonRegistrieren.add(buttonRegistrieren);
		panelTitelLogin.add(panelTitel, BorderLayout.NORTH);
		panelTitelLogin.add(panelLogin, BorderLayout.SOUTH);
		panelKartennummerPasswortLogin.setLayout(new GridLayout(4, 2));
		panelKartennummerPasswortLogin.add(labelKartennummer);
		panelKartennummerPasswortLogin.add(textFieldKartennummer);
		panelKartennummerPasswortLogin.add(labelPasswort);
		panelKartennummerPasswortLogin.add(textFieldPasswort);
		panelKartennummerPasswortLogin.add(panelPlatzhalter);
		panelKartennummerPasswortLogin.add(panelButtonLogin);
		panelKartennummerPasswortLogin.setBorder(BorderFactory.createEmptyBorder(40, 0, 370, 200));
		panelTextRegistrieren.add(panelText, BorderLayout.NORTH);
		panelTextRegistrieren.add(panelButtonRegistrieren, BorderLayout.SOUTH);
		panelSeite.add(panelTitelLogin, BorderLayout.NORTH);
		panelSeite.add(panelKartennummerPasswortLogin, BorderLayout.CENTER);
		panelSeite.add(panelTextRegistrieren, BorderLayout.SOUTH);

		buttonLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int kartennummer = Helper.checkDigitReturnIntOrNegativError(textFieldKartennummer.getText());
				if (kartennummer < 0) {
					fehlermeldung.openFehlermeldungDialog("Die Kartennummer muss eine Zahl sein!");
					textFieldKartennummer.setText("");
					return;
				}

				String passwort = new String(textFieldPasswort.getPassword());
				String passwortVonDatenbank = DatenbankCode.getPasswortVonDatenbank(kartennummer);

				if (passwort.equals(passwortVonDatenbank)) {
					DatenbankCode.setAllUserInformationsByKartennummer(kartennummer);
					navigator.navigate(EnumGui.LayoutEingeloggt);
				} else {
					fehlermeldung.openFehlermeldungDialog("Die Kartennummer oder das Passwort ist falsch!");
					textFieldPasswort.setText("");
				}
			}
		});

		buttonRegistrieren.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				navigator.navigate(EnumGui.Registrieren);
			}
		});

		add(panelSeite);
	}
}