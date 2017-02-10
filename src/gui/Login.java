package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class Login extends JPanel {

	public Login(MainFrame mainFrame) {

		JPanel panelSeite = new JPanel();
		JPanel panelLogin = new JPanel(new BorderLayout());
		JPanel panelTitel = new JPanel(new BorderLayout());
		JPanel panelKartennummer = new JPanel();
		JPanel panelPasswort = new JPanel(new FlowLayout());
		JPanel panelButtonLogin = new JPanel(new BorderLayout());
		JPanel panelText = new JPanel(new BorderLayout());
		JPanel panelButtonRegistrieren = new JPanel(new BorderLayout());
		JPanel panelTitelLogin = new JPanel(new BorderLayout());
		JPanel panelPlatzhalter = new JPanel();
		JPanel panelKartennummerPasswortLogin = new JPanel();
		JPanel panelTextRegistrieren = new JPanel();

		JLabel labelLogin = new JLabel("Login");
		JLabel labelBbcBank = new JLabel("BBC BANK");
		JLabel labelKartennummer = new JLabel("Kartennummer:");
		JLabel labelPasswort = new JLabel("Passwort:");
		JLabel labelText = new JLabel("Noch kein Benutzerkonto?");

		JButton buttonLogin = new JButton("Login");
		JButton buttonRegistrieren = new JButton("Registrieren");

		JTextField textFieldKartennummer = new JTextField(17);
		JPasswordField textFieldPasswort = new JPasswordField(20);

		labelBbcBank.setFont(new Font("Arial", Font.PLAIN, 80));

		panelTitel.add(labelBbcBank, BorderLayout.CENTER);

		panelSeite.setLayout(new BorderLayout());

		labelLogin.setFont(new Font("Arial", Font.PLAIN, 50));
		panelLogin.add(labelLogin, BorderLayout.CENTER);
		labelKartennummer.setFont(new Font("Arial", Font.PLAIN, 16));
		labelPasswort.setFont(new Font("Arial", Font.PLAIN, 16));

		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Connection con = ConnectionFactory.getInstance().getConnection();
	
				int kartennummer = mainFrame.checkDigitReturnIntOrNegativError(textFieldKartennummer.getText()); 
				if (kartennummer < 0) {
					System.err.println("Kartennummer ist keine Zahl!");
				}

				String passwort = new String(textFieldPasswort.getPassword());
				//String passwortVonDatenbank = mainFrame.getPasswortVonDatenbank();
				if (passwort.equals(passwortVonDatenbank)) {
					mainFrame.getContentPane().removeAll();
					mainFrame.getContentPane().add(new LayoutEingeloggt(mainFrame));
					mainFrame.getContentPane().revalidate();
				} else {
					// *************
					// Fehlermeldung
					System.err.println("Falsche Kartennummer oder Passwort!");
					// *************
				}
			}
		});

		panelButtonLogin.setBorder(BorderFactory.createEmptyBorder(5, 90, 0, 0));
		panelButtonLogin.add(buttonLogin);

		buttonRegistrieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(new Registrieren(mainFrame));
				mainFrame.getContentPane().revalidate();
			}
		});

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

		add(panelSeite);

	}
}