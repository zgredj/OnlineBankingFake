package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {

	public Login() {

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

		add(panelSeite);

	}
}