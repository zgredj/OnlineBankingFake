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
import util.Helper;

public class PanelRechnungen extends JPanel {

	private JLabel labelRechnungenerstellen = new JLabel("Rechnungen erstellen");
	private JLabel labelKartennummerDesEmpfaengers = new JLabel("Kartennummer des Empfaengers");
	private JLabel labelBetragRechnungen = new JLabel("Betrag ");
	private JLabel labelPasswordRechnungen = new JLabel("Passwort ");

	private JTextField textFieldKartennummerRechnungen = new JTextField(10);
	private JTextField textFieldBetragRechnungen = new JTextField(10);
	private JPasswordField textFieldPasswordRechnungen = new JPasswordField(10);

	private JButton buttonAbsendenRechnungen = new JButton("absenden");

	private JPanel panelCenterMenuRechnungen = new JPanel(new BorderLayout());
	private JPanel panelNorthMenuRechnungen = new JPanel(new BorderLayout());
	private JPanel panelKartennummerRechnungen = new JPanel();
	private JPanel panelBetragRechnungen = new JPanel();
	private JPanel panelPasswordRechnungen = new JPanel();
	private JPanel panelRechnungenErstellen = new JPanel(new BorderLayout());
	private JPanel panelBoxRechnungen = new JPanel();

	public PanelRechnungen(final Fehlermeldung fehlermeldung, User user) {

		setBorder(BorderFactory.createEmptyBorder(40, 100, 300, 200));
		labelRechnungenerstellen.setFont(new Font("Arial", Font.PLAIN, 30));

		buttonAbsendenRechnungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kartennummerEmpfaenger = -1;
				int kartennummerEmpfaengerUnchecked = Helper
						.checkDigitReturnIntOrNegativError(textFieldKartennummerRechnungen.getText());
				if (kartennummerEmpfaengerUnchecked > 0) {
					kartennummerEmpfaenger = kartennummerEmpfaengerUnchecked;
				} else {
					fehlermeldung.openFehlermeldungDialog("Die eingegebene Kartennummer ist keine Zahl!");
					textFieldKartennummerRechnungen.setText("");
					return;
				}

				if (kartennummerEmpfaenger == user.getKartennummer()) {
					fehlermeldung.openFehlermeldungDialog("Sie koennen sich nicht selbst eine Rechnung stellen!");
					return;
				}

				String passwortUnchecked = new String(textFieldPasswordRechnungen.getPassword());
				String passwortVonDatenbank = DatenbankCode.getPasswortVonDatenbank(user.getKartennummer());
				if (!passwortUnchecked.equals(passwortVonDatenbank)) {
					fehlermeldung.openFehlermeldungDialog("Falsches Passwort eingegeben!");
					textFieldPasswordRechnungen.setText("");
					return;
				}

				double betrag;
				try {
					betrag = Double.parseDouble(textFieldBetragRechnungen.getText());
				} catch (NumberFormatException nfexc) {
					fehlermeldung.openFehlermeldungDialog("Der eingegebene Betrag muss eine Zahl sein!");
					textFieldBetragRechnungen.setText("");
					return;
				}

				try {
					DatenbankCode.setRechnungVonDatenbank(kartennummerEmpfaenger, user.getKartennummer(), betrag);
				} catch (Exception exc) {
					fehlermeldung.openFehlermeldungDialog("Die eingegebene Kartennummer ist nicht vorhanden!");
					textFieldKartennummerRechnungen.setText("");
					return;
				}

				textFieldBetragRechnungen.setText("");
				textFieldKartennummerRechnungen.setText("");
				textFieldPasswordRechnungen.setText("");
				fehlermeldung.openInfoDialog("Die Rechnung wurde erfolgreich erstellt!", "Rechnung erstellt!");
			}
		});

		panelKartennummerRechnungen.setLayout(new BoxLayout(panelKartennummerRechnungen, BoxLayout.PAGE_AXIS));
		panelBetragRechnungen.setLayout(new BoxLayout(panelBetragRechnungen, BoxLayout.PAGE_AXIS));
		panelPasswordRechnungen.setLayout(new BoxLayout(panelPasswordRechnungen, BoxLayout.PAGE_AXIS));
		panelBoxRechnungen.setLayout(new BoxLayout(panelBoxRechnungen, BoxLayout.PAGE_AXIS));

		panelRechnungenErstellen.add(labelRechnungenerstellen);

		panelBoxRechnungen.add(panelRechnungenErstellen);
		panelBoxRechnungen.add(panelCenterMenuRechnungen);

		panelCenterMenuRechnungen.add(panelKartennummerRechnungen, BorderLayout.NORTH);
		panelCenterMenuRechnungen.add(panelNorthMenuRechnungen, BorderLayout.CENTER);
		panelCenterMenuRechnungen.add(buttonAbsendenRechnungen, BorderLayout.SOUTH);

		panelNorthMenuRechnungen.add(panelBetragRechnungen, BorderLayout.EAST);
		panelNorthMenuRechnungen.add(panelPasswordRechnungen, BorderLayout.WEST);

		panelKartennummerRechnungen.add(labelKartennummerDesEmpfaengers);
		panelKartennummerRechnungen.add(textFieldKartennummerRechnungen);

		panelBetragRechnungen.add(labelBetragRechnungen);
		panelBetragRechnungen.add(textFieldBetragRechnungen);

		panelPasswordRechnungen.add(labelPasswordRechnungen);
		panelPasswordRechnungen.add(textFieldPasswordRechnungen);

		panelCenterMenuRechnungen.setBorder(BorderFactory.createEmptyBorder(15, 0, 40, 250));
		panelBetragRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));
		panelPasswordRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));

		add(panelBoxRechnungen);
	}
}
