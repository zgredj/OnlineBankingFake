package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LayoutEingeloggt extends JPanel {

	private String titel = "Willkommen";
	private String vorname = "Vorname";
	private String nachname = "Nachname";

	public LayoutEingeloggt(final MainFrame mainFrame) {
		JPanel panelAlles = new JPanel(new BorderLayout());
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		JPanel panelKopfzeileEAST = new JPanel();

		JLabel labelTitel = new JLabel();
		JLabel labelName = new JLabel();
		JLabel labelAngemeldet = new JLabel();

		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel panelHome = new JPanel(new BorderLayout());
		JPanel panelZahlungen = new JPanel(new BorderLayout());
		JPanel panelRechnungen = new JPanel(new BorderLayout());

		panelAlles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		labelTitel.setText(titel);
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		labelName.setText(vorname + "  " + nachname);
		labelName.setFont(new Font("Arial", Font.PLAIN, 16));
		labelAngemeldet.setText("Angemeldet");
		labelAngemeldet.setFont(new Font("Arial", Font.PLAIN, 14));

		panelKopfzeileEAST.setLayout(new BoxLayout(panelKopfzeileEAST, BoxLayout.Y_AXIS));
		panelKopfzeileEAST.add(labelName);
		panelKopfzeileEAST.add(labelAngemeldet);
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(15, 40, 10, 10));
		panelKopfzeile.add(labelTitel, BorderLayout.WEST);
		panelKopfzeile.add(panelKopfzeileEAST, BorderLayout.EAST);

		panelAlles.add(panelKopfzeile, BorderLayout.NORTH);

		tabbedPaneMenu.addTab("Home", panelHome);
		tabbedPaneMenu.addTab("Zahlungen", panelZahlungen);
		tabbedPaneMenu.addTab("Rechnugnen", panelRechnungen);

		// TabbedPane Home
		JLabel labelKartennummerHome = new JLabel("Kartenummer");
		JLabel labelKontostandHome = new JLabel("Kontostand");

		JScrollPane scrollPaneOffeneRechnungenHome = new JScrollPane();
		JPanel westBoxHome = new JPanel();

		westBoxHome.setLayout(new BoxLayout(westBoxHome, BoxLayout.PAGE_AXIS));

		panelHome.add(westBoxHome, BorderLayout.WEST);
		panelHome.add(scrollPaneOffeneRechnungenHome, BorderLayout.EAST);

		westBoxHome.add(labelKartennummerHome);
		westBoxHome.add(labelKontostandHome);

		panelHome.setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0));

		// TabbedPane Zahlungen
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

		panelXAchseWesten.setLayout(new BoxLayout(panelXAchseWesten, BoxLayout.PAGE_AXIS));
		panelXAchseOsten.setLayout(new BoxLayout(panelXAchseOsten, BoxLayout.PAGE_AXIS));
		panelButtonEinzahlen.setLayout(new BoxLayout(panelButtonEinzahlen, BoxLayout.PAGE_AXIS));
		panelButtonAuszahlen.setLayout(new BoxLayout(panelButtonAuszahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragEinzahlen.setLayout(new BoxLayout(panelTextFieldBetragEinzahlen, BoxLayout.PAGE_AXIS));
		panelTextFieldBetragAuszahlen.setLayout(new BoxLayout(panelTextFieldBetragAuszahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldEinzahlen.setLayout(new BoxLayout(panelPasswortFieldEinzahlen, BoxLayout.PAGE_AXIS));
		panelPasswortFieldAuszahlen.setLayout(new BoxLayout(panelPasswortFieldAuszahlen, BoxLayout.PAGE_AXIS));

		panelZahlungen.setBorder(BorderFactory.createEmptyBorder(40, 100, 320, 200));
		panelButtonEinzahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		panelButtonAuszahlen.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		labelAuszahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelEinzahlung.setFont(new Font("Arial", Font.PLAIN, 30));
		labelBetragEinzahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelBetragAuszahlen.setFont(new Font("Arial", Font.PLAIN, 14));
		labelPasswortEinzahlen.setFont(new Font("Arial", Font.PLAIN, 15));
		labelPasswortAuszahlen.setFont(new Font("Arial", Font.PLAIN, 15));

		panelZahlungen.add(panelXAchseOsten, BorderLayout.EAST);
		panelZahlungen.add(panelXAchseWesten, BorderLayout.WEST);

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

		// TabbedPane Rechnungen
		JLabel labelRechnungenerstellen = new JLabel("Rechnungen erstellen");
		JLabel labelKartennummerDesEmpfängers = new JLabel("Kartennummer des Empfaengers");
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

		labelRechnungenerstellen.setFont(new Font("Arial", Font.PLAIN, 30));

		panelKartennummerRechnungen.setLayout(new BoxLayout(panelKartennummerRechnungen, BoxLayout.PAGE_AXIS));
		panelBetragRechnungen.setLayout(new BoxLayout(panelBetragRechnungen, BoxLayout.PAGE_AXIS));
		panelPasswordRechnungen.setLayout(new BoxLayout(panelPasswordRechnungen, BoxLayout.PAGE_AXIS));
		panelBoxRechnungen.setLayout(new BoxLayout(panelBoxRechnungen, BoxLayout.PAGE_AXIS));

		panelRechnungenErstellen.add(labelRechnungenerstellen);

		panelRechnungen.add(panelBoxRechnungen);

		panelBoxRechnungen.add(panelRechnungenErstellen);
		panelBoxRechnungen.add(panelCenterMenuRechnungen);

		panelCenterMenuRechnungen.add(panelKartennummerRechnungen, BorderLayout.NORTH);
		panelCenterMenuRechnungen.add(panelNorthMenuRechnungen, BorderLayout.CENTER);
		panelCenterMenuRechnungen.add(buttonAbsendenRechnungen, BorderLayout.SOUTH);

		panelNorthMenuRechnungen.add(panelBetragRechnungen, BorderLayout.EAST);
		panelNorthMenuRechnungen.add(panelPasswordRechnungen, BorderLayout.WEST);

		panelKartennummerRechnungen.add(labelKartennummerDesEmpfängers);
		panelKartennummerRechnungen.add(textFieldKartennummerRechnungen);

		panelBetragRechnungen.add(labelBetragRechnungen);
		panelBetragRechnungen.add(textFieldBetragRechnungen);

		panelPasswordRechnungen.add(labelPasswordRechnungen);
		panelPasswordRechnungen.add(textFieldPasswordRechnungen);

		panelRechnungen.setBorder(BorderFactory.createEmptyBorder(40, 100, 300, 200));
		panelCenterMenuRechnungen.setBorder(BorderFactory.createEmptyBorder(15, 0, 40, 250));
		panelBetragRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));
		panelPasswordRechnungen.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));

		// Footer
		JPanel panelAusloggen = new JPanel(new FlowLayout());
		JButton buttonAusloggen = new JButton("Ausloggen");
		buttonAusloggen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(new Login(mainFrame));
				mainFrame.getContentPane().revalidate();
			}
		});
		panelAusloggen.add(buttonAusloggen);
		panelAusloggen.setBorder(BorderFactory.createEmptyBorder(10, 670, 0, 0));
		panelAlles.add(panelAusloggen, BorderLayout.SOUTH);

		panelAlles.add(tabbedPaneMenu, BorderLayout.CENTER);
		add(panelAlles);

	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

}
