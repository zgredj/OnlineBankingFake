package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datenbank.DatenbankCode;
import datenbank.User;
import fehlermeldung.Fehlermeldung;

public class PanelZahlungen extends JPanel {

	private JLabel labelEinzahlung = new JLabel("Einzahlung");
	private JLabel labelAuszahlung = new JLabel("Auszahlung");
	private JLabel labelBetragEinzahlen = new JLabel("Betrag");
	private JLabel labelBetragAuszahlen = new JLabel("Betrag");
	private JLabel labelPasswortEinzahlen = new JLabel("Passwort");
	private JLabel labelPasswortAuszahlen = new JLabel("Passwort");

	private JTextField textFieldBetragEinzahlen = new JTextField();
	private JTextField textFieldBetragAuszahlen = new JTextField();
	private JPasswordField textFieldPasswortAuszahlen = new JPasswordField();
	private JPasswordField textFieldPasswortEinzahlen = new JPasswordField();

	private JPanel panelXAchseWesten = new JPanel();
	private JPanel panelXAchseOsten = new JPanel();
	private JPanel panelButtonEinzahlen = new JPanel();
	private JPanel panelButtonAuszahlen = new JPanel();
	private JPanel panelTextFieldBetragEinzahlen = new JPanel();
	private JPanel panelTextFieldBetragAuszahlen = new JPanel();
	private JPanel panelPasswortFieldEinzahlen = new JPanel();
	private JPanel panelPasswortFieldAuszahlen = new JPanel();

	private JButton buttonEinzahlen = new JButton("einzahlen");
	private JButton buttonAuszahlen = new JButton("auszahlen");

	public PanelZahlungen(Fehlermeldung fehlermeldung, Navigator navigator, User user) {

		setBorder(BorderFactory.createEmptyBorder(40, 100, 320, 200));

		labelAuszahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelEinzahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelBetragEinzahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelBetragAuszahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelPasswortEinzahlen.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPasswortAuszahlen.setFont(new Font("Arial", Font.PLAIN, 15));

		panelXAchseWesten.setLayout(new BoxLayout(panelXAchseWesten, BoxLayout.PAGE_AXIS));
		panelXAchseOsten.setLayout(new BoxLayout(panelXAchseOsten, BoxLayout.PAGE_AXIS));
		panelButtonEinzahlen.setLayout(new BoxLayout(panelButtonEinzahlen, BoxLayout.PAGE_AXIS));
		panelButtonAuszahlen.setLayout(new BoxLayout(panelButtonAuszahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragEinzahlen.setLayout(new BoxLayout(panelTextFieldBetragEinzahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragAuszahlen.setLayout(new BoxLayout(panelTextFieldBetragAuszahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldEinzahlen.setLayout(new BoxLayout(panelPasswortFieldEinzahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldAuszahlen.setLayout(new BoxLayout(panelPasswortFieldAuszahlen, BoxLayout.PAGE_AXIS));
		panelButtonEinzahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelButtonAuszahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
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
		panelXAchseWesten.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
		panelTextFieldBetragEinzahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelTextFieldBetragAuszahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelPasswortFieldEinzahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		panelPasswortFieldAuszahlen.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		add(panelXAchseOsten, BorderLayout.EAST);
		add(panelXAchseWesten, BorderLayout.WEST);

		buttonAuszahlen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double betrag;
				try {
					betrag = Double.parseDouble(textFieldBetragAuszahlen.getText());
					if (betrag <= 0) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException nfexc) {
					fehlermeldung.openFehlermeldungDialog("Der eingegebene Betrag muss eine positive Zahl sein!");
					textFieldBetragAuszahlen.setText("");
					return;
				}

				String passwortUnchecked = new String(textFieldPasswortAuszahlen.getPassword());
				String passwortVonDatenbank = DatenbankCode.getPasswortVonDatenbank(user.getKartennummer());
				if (passwortUnchecked.equals(passwortVonDatenbank)) {
					try {
						DatenbankCode.setKontostandByKartennummer(user.getKartennummer(), betrag, "auszahlen");
					} catch (Exception exc) {
						fehlermeldung.openFehlermeldungDialog(exc.getMessage());
						textFieldBetragAuszahlen.setText("");
						return;
					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Die Passwoerter stimmen nicht �berein!");
					textFieldPasswortAuszahlen.setText("");
					return;
				}

				textFieldBetragAuszahlen.setText("");
				textFieldPasswortAuszahlen.setText("");

				fehlermeldung.openInfoDialog("Der Betrag wurde erfolgreich ausgezahlt!", "Betrag ausgezahlt!");

				navigator.navigate(EnumGui.LayoutEingeloggt);
			}
		});

		buttonEinzahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double betrag;
				try {
					betrag = Double.parseDouble(textFieldBetragEinzahlen.getText());
					if (betrag <= 0) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException nfexc) {
					fehlermeldung.openFehlermeldungDialog("Der eingegebene Betrag muss eine positive Zahl sein!");
					textFieldBetragEinzahlen.setText("");
					return;
				}

				String passwortUnchecked = new String(textFieldPasswortEinzahlen.getPassword());
				String passwortVonDatenbank = DatenbankCode.getPasswortVonDatenbank(user.getKartennummer());
				if (passwortUnchecked.equals(passwortVonDatenbank)) {
					try {
						DatenbankCode.setKontostandByKartennummer(user.getKartennummer(), betrag, "einzahlen");
					} catch (Exception exc) {

					}
				} else {
					fehlermeldung.openFehlermeldungDialog("Falsches Passwort eingegeben!");
					textFieldPasswortEinzahlen.setText("");
					return;
				}

				textFieldBetragEinzahlen.setText("");
				textFieldPasswortEinzahlen.setText("");

				fehlermeldung.openInfoDialog("Der Betrag wurde erfolgreich eingezahlt!", "Betrag eingezahlt!");

				navigator.navigate(EnumGui.LayoutEingeloggt);
			}
		});
	}
}
