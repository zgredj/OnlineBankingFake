package Gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BasisLayoutEingelogt extends BasisLayout {

	private String titel = "Titel";
	private String vorname = "Vorname";
	private String nachname = "Nachname";

	public BasisLayoutEingelogt() {
		JPanel panelAlles = new JPanel(new BorderLayout());
		panelAlles.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		JLabel labelTitel = new JLabel();
		JLabel labelName = new JLabel();
		JLabel labelAngemeldet = new JLabel();
		labelTitel.setText(titel);
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		labelName.setText(vorname + "  " + nachname);
		labelName.setFont(new Font("Arial", Font.PLAIN, 16));
		labelAngemeldet.setText("Angemeldet");
		labelAngemeldet.setFont(new Font("Arial", Font.PLAIN, 14));

		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		JPanel panelKopfzeileEAST = new JPanel();
		panelKopfzeileEAST.setLayout(new BoxLayout(panelKopfzeileEAST, BoxLayout.Y_AXIS));
		//panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));
		panelKopfzeileEAST.add(labelName);
		panelKopfzeileEAST.add(labelAngemeldet);
		panelKopfzeile.add(labelTitel, BorderLayout.WEST);
		panelKopfzeile.add(panelKopfzeileEAST, BorderLayout.EAST);

		panelAlles.add(panelKopfzeile, BorderLayout.NORTH);

		JTabbedPane tabbedPaneMenu = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel panelHome = new JPanel();
		JPanel panelZahlungen = new JPanel();
		JPanel panelRechnungen = new JPanel();

		tabbedPaneMenu.addTab("Home", panelHome);
		tabbedPaneMenu.addTab("Zahlungen", panelZahlungen);
		tabbedPaneMenu.addTab("Rechnugnen", panelRechnungen);

		JPanel panelAusloggen = new JPanel(new BorderLayout());
		JButton buttonAusloggen = new JButton("Ausloggen");
		//panelAusloggen.setBorder(BorderFactory.createEmptyBorder(10, 500, 0, 0));
		panelAusloggen.add(buttonAusloggen);
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
