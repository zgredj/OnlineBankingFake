package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelZahlungen extends JPanel {
	JLabel labelEinzahlung = new JLabel("Einzahlung");
	JLabel labelAuszahlung = new JLabel("Auszahlung");
	JLabel labelBetragEinzahlen = new JLabel("Betrag");
	JLabel labelBetragAuszahlen = new JLabel("Betrag");
	JLabel labelPasswortEinzahlen = new JLabel("Passwort");
	JLabel labelPasswortAuszahlen = new JLabel("Passwort");

	JTextField textFieldBetragEinzahlen = new JTextField();
	JTextField textFieldBetragAuszahlen = new JTextField();

	JPasswordField textFieldPasswortAuszahlen = new JPasswordField();
	JPasswordField textFieldPasswortEinzahlen = new JPasswordField();

	JPanel panelXAchseWesten = new JPanel();
	JPanel panelXAchseOsten = new JPanel();
	JPanel panelButtonEinzahlen = new JPanel();
	JPanel panelButtonAuszahlen = new JPanel();
	JPanel panelTextFieldBetragEinzahlen = new JPanel();
	JPanel panelTextFieldBetragAuszahlen = new JPanel();
	JPanel panelPasswortFieldEinzahlen = new JPanel();
	JPanel panelPasswortFieldAuszahlen = new JPanel();

	JButton buttonEinzahlen = new JButton("einzahlen");
	JButton buttonAuszahlen = new JButton("auszahlen");

	public PanelZahlungen() {
		panelXAchseWesten.setLayout(new BoxLayout(panelXAchseWesten, BoxLayout.PAGE_AXIS));
		panelXAchseOsten.setLayout(new BoxLayout(panelXAchseOsten, BoxLayout.PAGE_AXIS));
		panelButtonEinzahlen.setLayout(new BoxLayout(panelButtonEinzahlen, BoxLayout.PAGE_AXIS));
		panelButtonAuszahlen.setLayout(new BoxLayout(panelButtonAuszahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragEinzahlen.setLayout(new BoxLayout(panelTextFieldBetragEinzahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragAuszahlen.setLayout(new BoxLayout(panelTextFieldBetragAuszahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldEinzahlen.setLayout(new BoxLayout(panelPasswortFieldEinzahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldAuszahlen.setLayout(new BoxLayout(panelPasswortFieldAuszahlen, BoxLayout.PAGE_AXIS));
		
		panelXAchseWesten.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
		
		setBorder(BorderFactory.createEmptyBorder(40, 100, 320, 200));
		panelButtonEinzahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelButtonAuszahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		labelAuszahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelEinzahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelBetragEinzahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelBetragAuszahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelPasswortEinzahlen.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPasswortAuszahlen.setFont(new Font("Arial", Font.PLAIN, 15));

		add(panelXAchseOsten, BorderLayout.EAST);
		add(panelXAchseWesten, BorderLayout.WEST);

		panelTextFieldBetragEinzahlen.add(textFieldBetragEinzahlen);
		panelTextFieldBetragAuszahlen.add(textFieldBetragAuszahlen);
		panelPasswortFieldEinzahlen.add(textFieldPasswortEinzahlen);
		panelPasswortFieldAuszahlen.add(textFieldPasswortAuszahlen);

		panelButtonEinzahlen.add(buttonEinzahlen);
		panelButtonAuszahlen.add(buttonAuszahlen);

		panelXAchseWesten.add(labelEinzahlung);
		panelXAchseWesten.add(labelBetragEinzahlen);
		panelXAchseWesten.add(panelTextFieldBetragEinzahlen);
		panelXAchseWesten.add(labelPasswortEinzahlen);
		panelXAchseWesten.add(panelPasswortFieldEinzahlen);
		panelXAchseWesten.add(panelButtonEinzahlen);

		panelXAchseOsten.add(labelAuszahlung);
		panelXAchseOsten.add(labelBetragAuszahlen);
		panelXAchseOsten.add(panelTextFieldBetragAuszahlen);
		panelXAchseOsten.add(labelPasswortAuszahlen);
		panelXAchseOsten.add(panelPasswortFieldAuszahlen);
		panelXAchseOsten.add(panelButtonAuszahlen);

		panelTextFieldBetragEinzahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelTextFieldBetragAuszahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelPasswortFieldEinzahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		panelPasswortFieldAuszahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	}
}