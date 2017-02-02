package Gui;

import java.awt.*;

import javax.swing.*;

public class Login extends BasisLayout {

	public Login() {

		JPanel panelSeite = new JPanel();
		panelSeite.setLayout(new BoxLayout(panelSeite, BoxLayout.PAGE_AXIS));

		// Titel
		JPanel panelTitel = new JPanel(new BorderLayout());
		JLabel labelBbcBank = new JLabel("BBC BANK");
		labelBbcBank.setFont(new Font("Arial", Font.PLAIN, 70));
		panelTitel.add(labelBbcBank, BorderLayout.CENTER);

		// Login
		JPanel panelLogin = new JPanel(new BorderLayout());
		JLabel labelLogin = new JLabel("Login2");
		labelLogin.setFont(new Font("Arial", Font.PLAIN, 50));
		panelLogin.add(labelLogin, BorderLayout.CENTER);

		// Kartennummer
		JPanel panelKartennummer = new JPanel(new FlowLayout());
		JTextField textFieldKartennummer = new JTextField(20);
		JLabel labelKartennummer = new JLabel("Kartennummer:");
		panelKartennummer.add(labelKartennummer);
		panelKartennummer.add(textFieldKartennummer);

		// Passwort
		JPanel panelPasswortUndLogin = new JPanel(new FlowLayout());
		JTextField textFieldPasswort = new JTextField(20);
		JLabel labelPasswort = new JLabel("Passwort:");
		panelPasswortUndLogin.add(labelPasswort);
		panelPasswortUndLogin.add(textFieldPasswort);

		// Login
		JButton buttonLogin = new JButton("Login");
		panelPasswortUndLogin.add(buttonLogin);

		// Text
		JPanel panelText = new JPanel(new BorderLayout());
		JLabel labelText = new JLabel("Noch kein Benutzerkonto?");
		panelText.add(labelText);

		// Button
		JPanel panelRegistrieren = new JPanel(new BorderLayout());
		JButton buttonRegistrieren = new JButton("Registrieren");
		panelRegistrieren.add(buttonRegistrieren);

		panelSeite.add(panelTitel);
		panelSeite.add(panelLogin);
		panelSeite.add(panelKartennummer);
		panelSeite.add(panelPasswortUndLogin);
		panelSeite.add(panelText);
		panelSeite.add(panelRegistrieren);

		alles.add(panelSeite);

		Container contentPane = getContentPane();
		contentPane.add(alles);

		setSize(1200, 800);
		setResizable(false);
	}
}