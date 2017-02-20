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
import fehlermeldung.Fehlermeldung;

public class PanelRechnungen extends JPanel {

	DatenbankCode datenbankCode = new DatenbankCode();
	Fehlermeldung fehlermeldung = new Fehlermeldung();
	
	JLabel labelRechnungenerstellen = new JLabel("Rechnungen erstellen");
	JLabel labelKartennummerDesEmpfaengers = new JLabel("Kartennummer des Empfaengers");
	JLabel labelBetragRechnungen = new JLabel("Betrag ");
	JLabel labelPasswordRechnungen = new JLabel("Passwort ");

	JTextField textFieldKartennummerRechnungen = new JTextField(10);
	JTextField textFieldBetragRechnungen = new JTextField(10);
	JPasswordField textFieldPasswordRechnungen = new JPasswordField(10);

	JButton buttonAbsendenRechnungen = new JButton("absenden");

	JPanel panelCenterMenuRechnungen = new JPanel(new BorderLayout());
	JPanel panelNorthMenuRechnungen = new JPanel(new BorderLayout());
	JPanel panelKartennummerRechnungen = new JPanel();
	JPanel panelBetragRechnungen = new JPanel();
	JPanel panelPasswordRechnungen = new JPanel();
	JPanel panelRechnungenErstellen = new JPanel(new BorderLayout());
	JPanel panelBoxRechnungen = new JPanel();

	public PanelRechnungen(final MainFrame mainFrame, final int kartennummer) {
		labelRechnungenerstellen.setFont(new Font("Arial", Font.PLAIN, 30));

		panelKartennummerRechnungen.setLayout(new BoxLayout(panelKartennummerRechnungen, BoxLayout.PAGE_AXIS));
		panelBetragRechnungen.setLayout(new BoxLayout(panelBetragRechnungen, BoxLayout.PAGE_AXIS));
		panelPasswordRechnungen.setLayout(new BoxLayout(panelPasswordRechnungen, BoxLayout.PAGE_AXIS));
		panelBoxRechnungen.setLayout(new BoxLayout(panelBoxRechnungen, BoxLayout.PAGE_AXIS));

		panelRechnungenErstellen.add(labelRechnungenerstellen);

		add(panelBoxRechnungen);

		panelBoxRechnungen.add(panelRechnungenErstellen);
		panelBoxRechnungen.add(panelCenterMenuRechnungen);

		buttonAbsendenRechnungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kartennummerEmpfaenger = -1;
				int kartennummerEmpfaengerUnchecked = mainFrame.checkDigitReturnIntOrNegativError(textFieldKartennummerRechnungen.getText());
				if (kartennummerEmpfaengerUnchecked > 0) {
					kartennummerEmpfaenger = kartennummerEmpfaengerUnchecked;
				} else {
					fehlermeldung.openFehlermeldungDialog("Die eingegebene Kartennummer ist keine Zahl!", mainFrame);
					textFieldKartennummerRechnungen.setText("");
					return;
				}

				String passwortUnchecked = new String(textFieldPasswordRechnungen.getPassword());
				String passwortVonDatenbank = datenbankCode.getPasswortVonDatenbank(kartennummer);
				if (!passwortUnchecked.equals(passwortVonDatenbank)) {
					fehlermeldung.openFehlermeldungDialog("Falsches Passwort eingegeben!", mainFrame);
					textFieldPasswordRechnungen.setText("");
					return;
				}
				
				int betrag = -1;
				int betragUnchecked = mainFrame.checkDigitReturnIntOrNegativError(textFieldBetragRechnungen.getText());
				if (betragUnchecked > 0) {
					betrag = betragUnchecked;
				} else {
					fehlermeldung.openFehlermeldungDialog("Der eingegebene Betrag ist keine Zahl!", mainFrame);
					textFieldBetragRechnungen.setText("");
					return;
				}
				
				try {
					datenbankCode.setRechnungVonDatenbank(kartennummerEmpfaenger, kartennummer, betrag, mainFrame);
				} catch (Exception exc) {
					fehlermeldung.openFehlermeldungDialog(exc.getMessage(), mainFrame);
				}
				
				textFieldBetragRechnungen.setText("");
				textFieldKartennummerRechnungen.setText("");
				textFieldPasswordRechnungen.setText("");
			}
		});

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

		setBorder(BorderFactory.createEmptyBorder(40, 100, 300, 200));
		panelCenterMenuRechnungen.setBorder(BorderFactory.createEmptyBorder(15, 0, 40, 250));
		panelBetragRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));
		panelPasswordRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));
	}
}
