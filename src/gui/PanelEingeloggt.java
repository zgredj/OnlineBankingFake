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
import javax.swing.JTabbedPane;

import datenbank.DatenbankCode;
import datenbank.User;
import fehlermeldung.Fehlermeldung;

public class PanelEingeloggt extends JPanel {

	private JLabel labelTitel = new JLabel();
	private JLabel labelName = new JLabel();
	private JLabel labelAngemeldet = new JLabel();

	private JPanel panelAlles = new JPanel(new BorderLayout());
	private JPanel panelKopfzeile = new JPanel(new BorderLayout());
	private JPanel panelKopfzeileEAST = new JPanel();
	private JPanel panelHome = new JPanel(new BorderLayout());
	private JPanel panelZahlungen = new JPanel(new BorderLayout());
	private JPanel panelRechnungen = new JPanel(new BorderLayout());
	
	private JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

	public PanelEingeloggt(Navigator navigator, Fehlermeldung fehlermeldung, User user) {

		labelTitel.setText("BBC Bank");
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		labelName.setText(user.getVorname() + "  " + user.getNachname());
		labelName.setFont(new Font("Arial", Font.PLAIN, 16));
		labelAngemeldet.setText("Angemeldet");
		labelAngemeldet.setFont(new Font("Arial", Font.PLAIN, 14));

		panelKopfzeileEAST.setLayout(new BoxLayout(panelKopfzeileEAST, BoxLayout.Y_AXIS));
		panelKopfzeileEAST.add(labelName);
		panelKopfzeileEAST.add(labelAngemeldet);
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(15, 40, 10, 30));
		panelKopfzeile.add(labelTitel, BorderLayout.WEST);
		panelKopfzeile.add(panelKopfzeileEAST, BorderLayout.EAST);

		tabbedPaneMenu.addTab("Home", panelHome);
		tabbedPaneMenu.addTab("Zahlungen", panelZahlungen);
		tabbedPaneMenu.addTab("Rechnugen", panelRechnungen);

		PanelHome panelHomeInstance = new PanelHome(fehlermeldung, navigator, user);
		panelHome.add(panelHomeInstance);

		PanelZahlungen panelZahlungenInstance = new PanelZahlungen(fehlermeldung, navigator, user);
		panelZahlungen.add(panelZahlungenInstance);

		PanelRechnungen panelRechnungenInstance = new PanelRechnungen(fehlermeldung, user);
		panelRechnungen.add(panelRechnungenInstance);

		JPanel panelButtons = new JPanel(new FlowLayout());
		
		JButton buttonKontoloeschen = new JButton("Konto loeschen");
		buttonKontoloeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatenbankCode.deleteKartennummerUndKontoVonDatenbank(user.getKartennummer());
				navigator.navigate(EnumGui.LOGIN);
			}
		});
		
		JButton buttonAusloggen = new JButton("Ausloggen");
		buttonAusloggen.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				navigator.navigate(EnumGui.LOGIN);
			}
		});

		panelButtons.add(buttonKontoloeschen);
		panelButtons.add(buttonAusloggen);
		panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 500, 0, 10));

		panelAlles.add(panelButtons, BorderLayout.SOUTH);
		panelAlles.add(tabbedPaneMenu, BorderLayout.CENTER);
		panelAlles.add(panelKopfzeile, BorderLayout.NORTH);
		panelAlles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panelAlles);
	}
}
