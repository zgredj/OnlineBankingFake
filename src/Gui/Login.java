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
		panelKartennummer.add(labelKartennummer);
		panelKartennummer.add(textFieldKartennummer);

		// Passwort
		JPanel panelPasswort = new JPanel(new FlowLayout());
		JTextField textFieldPasswort = new JTextField(20);
		JLabel labelPasswort = new JLabel("Passwort:");
		panelPasswort.add(labelPasswort);
		panelPasswort.add(textFieldPasswort);

		// Login
		JPanel panelButtonLogin = new JPanel();
		JButton buttonLogin = new JButton("Login");
		panelButtonLogin.add(buttonLogin);

		// Text
		JPanel panelText = new JPanel(new BorderLayout());
		JLabel labelText = new JLabel("Noch kein Benutzerkonto?");
		panelText.add(labelText);

		// Registrieren
		JPanel panelButtonRegistrieren = new JPanel(new BorderLayout());
		JButton buttonRegistrieren = new JButton("Registrieren");
		panelButtonRegistrieren.add(buttonRegistrieren);
		
		alles.add(panelSeite);

		Container contentPane = getContentPane();
		contentPane.add(alles);

		setSize(1200, 800);
		setResizable(false);
	}
}