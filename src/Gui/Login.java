package Gui;

import java.awt.*;

import javax.swing.*;

public class Login extends BasisLayout {

	public Login() {

		JPanel panelSeite = new JPanel();
		panelSeite.setLayout(new BorderLayout());
		//panelSeite.setLayout(new GridLayout(7, 1));
		
		// Titel
		JPanel panelTitel = new JPanel(new BorderLayout());
		JLabel labelBbcBank = new JLabel("BBC BANK");
		labelBbcBank.setFont(new Font("Arial", Font.PLAIN, 80));
		panelTitel.add(labelBbcBank, BorderLayout.CENTER);

		// Login
		JPanel panelLogin = new JPanel(new BorderLayout());
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(new Font("Arial", Font.PLAIN, 50));
		panelLogin.add(labelLogin, BorderLayout.CENTER);

		// Kartennummer
		JPanel panelKartennummer = new JPanel();
		JTextField textFieldKartennummer = new JTextField(17);
		JLabel labelKartennummer = new JLabel("Kartennummer:");
		labelKartennummer.setFont(new Font("Arial", Font.PLAIN, 16));

		// Passwort
		JPanel panelPasswort = new JPanel(new FlowLayout());
		JTextField textFieldPasswort = new JTextField(20);
		JLabel labelPasswort = new JLabel("Passwort:");
		labelPasswort.setFont(new Font("Arial", Font.PLAIN, 16));

		// Login
		JPanel panelButtonLogin = new JPanel(new BorderLayout());
		JButton buttonLogin = new JButton("Login");
		panelButtonLogin.setBorder(BorderFactory.createEmptyBorder(0,0,5,90));
		panelButtonLogin.add(buttonLogin);

		// Text
		JPanel panelText = new JPanel(new BorderLayout());
		JLabel labelText = new JLabel("Noch kein Benutzerkonto?");
		panelText.add(labelText);

		// Registrieren
		JPanel panelButtonRegistrieren = new JPanel(new BorderLayout());
		JButton buttonRegistrieren = new JButton("Registrieren");
		panelButtonRegistrieren.add(buttonRegistrieren);

		JPanel panelTitelLogin = new JPanel(new BorderLayout());
		panelTitelLogin.add(panelTitel, BorderLayout.NORTH);
		panelTitelLogin.add(panelLogin, BorderLayout.SOUTH);
		JPanel panelKartennummerPasswortLogin = new JPanel();
		panelKartennummerPasswortLogin.setLayout(new GridLayout(4, 2));
		panelKartennummerPasswortLogin.add(labelKartennummer);
		panelKartennummerPasswortLogin.add(textFieldKartennummer);
		panelKartennummerPasswortLogin.add(labelPasswort);
		panelKartennummerPasswortLogin.add(textFieldPasswort);
		panelKartennummerPasswortLogin.add(panelButtonLogin);
		panelKartennummerPasswortLogin.setBorder(BorderFactory.createEmptyBorder(40,0,370,600));
		JPanel panelTextRegistrieren = new JPanel();
		panelTextRegistrieren.add(panelText, BorderLayout.NORTH);
		panelTextRegistrieren.add(panelButtonRegistrieren, BorderLayout.SOUTH);
		
		panelSeite.add(panelTitelLogin, BorderLayout.NORTH);
		panelSeite.add(panelKartennummerPasswortLogin, BorderLayout.CENTER);
		panelSeite.add(panelTextRegistrieren,BorderLayout.SOUTH);
		
		alles.add(panelSeite);

		Container contentPane = getContentPane();
		contentPane.add(alles);

		setSize(1200, 800);
		setResizable(false);
	}
}