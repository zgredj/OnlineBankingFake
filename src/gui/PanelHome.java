package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datenbank.DatenbankCode;
import datenbank.Konto;
import datenbank.Rechnung;

public class PanelHome extends JPanel {

	JLabel labelOffeneRechnungenHome = new JLabel("Offene Rechnungen");

	JPanel panelRechnungenListeHome = new JPanel();
	JPanel westBoxHome = new JPanel();
	JPanel rechnungenBezahlenHome = new JPanel(new BorderLayout());
	JPanel panelRechnungenListeRandHome = new JPanel(new BorderLayout());

	JButton buttonRechnungenBezahlenHome = new JButton("Bezahlen");

	public PanelHome(int kartennummer) {

		JLabel labelKartennummerHome = new JLabel("Kartenummer:      " + kartennummer);
		JLabel labelKontostandHome = new JLabel(
				"Kontostand:         " + DatenbankCode.getKontostandVonDatenbank(kartennummer) + " CHF");

		labelKartennummerHome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelKontostandHome.setFont(new Font("Arial", Font.PLAIN, 20));

		setLayout(new BorderLayout());
		labelOffeneRechnungenHome.setFont(new Font("Arial", Font.BOLD, 20));

		rechnungenBezahlenHome.add(labelOffeneRechnungenHome, BorderLayout.NORTH);
		rechnungenBezahlenHome.add(panelRechnungenListeRandHome, BorderLayout.CENTER);
		rechnungenBezahlenHome.add(buttonRechnungenBezahlenHome, BorderLayout.SOUTH);

		panelRechnungenListeRandHome.add(panelRechnungenListeHome);

		westBoxHome.setLayout(new BoxLayout(westBoxHome, BoxLayout.PAGE_AXIS));
		panelRechnungenListeHome.setLayout(new BoxLayout(panelRechnungenListeHome, BoxLayout.Y_AXIS));

		add(rechnungenBezahlenHome, BorderLayout.EAST);
		add(westBoxHome, BorderLayout.WEST);

		westBoxHome.add(labelKartennummerHome);
		westBoxHome.add(labelKontostandHome);

		panelRechnungenListeRandHome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		panelRechnungenListeHome.setBorder(BorderFactory.createEtchedBorder(5, Color.BLACK, Color.BLACK));
		rechnungenBezahlenHome.setBorder(BorderFactory.createEmptyBorder(30, 150, 200, 100));
		setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0));
	}

	public ArrayList<JCheckBox> createRechnungCheckBoxes(int kartennummer) {
		int kontoNr = DatenbankCode.getKontoIdByKartennummerOrNull(kartennummer);
		ArrayList<JCheckBox> arrayCheckBoxes = new ArrayList<JCheckBox>();
		ArrayList<Rechnung> arrayRechnungen = DatenbankCode.getRechnungVonDatenbank(kontoNr);
		for (Rechnung rechnung : arrayRechnungen) {
			Konto konto = new Konto();
			konto = DatenbankCode.getVorUndNachnameVonDatenbankByKartennummer(rechnung.getKartennummer());
			JCheckBox chbox = new JCheckBox(konto.getVorname() + " " + konto.getName() + " " + rechnung.getBetrag());
			arrayCheckBoxes.add(chbox);
		}
		return arrayCheckBoxes;
	}
}
