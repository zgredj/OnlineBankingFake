package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

	public void start() {

		JPanel panelAlles = new JPanel(new BorderLayout());
		
		JLabel labelTitel = new JLabel();
		JLabel labelName = new JLabel();
		JLabel labelAngemeldet = new JLabel();
		JPanel panelKopfzeileEAST = new JPanel();
		JPanel panelKopfzeile = new JPanel(new BorderLayout());
		labelTitel.setText(titel);
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		labelName.setText(vorname + "  " + nachname);
		labelName.setFont(new Font("Arial", Font.PLAIN, 16));
		labelAngemeldet.setText("Angemeldet");
		labelAngemeldet.setFont(new Font("Arial", Font.PLAIN, 14));
		panelKopfzeileEAST.setLayout(new BoxLayout(panelKopfzeileEAST, BoxLayout.Y_AXIS));
		panelKopfzeileEAST.add(labelName);
		panelKopfzeileEAST.add(labelAngemeldet);
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
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
		tabbedPaneMenu.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

		panelAlles.add(tabbedPaneMenu, BorderLayout.CENTER);

		JButton buttonAusloggen = new JButton("Ausloggen");
		JPanel panelFusszeile = new JPanel(new BorderLayout());
		buttonAusloggen.setPreferredSize(new Dimension(130, 30));
		panelFusszeile.add(buttonAusloggen, BorderLayout.EAST);

		panelAlles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelAlles.add(panelFusszeile, BorderLayout.SOUTH);
		
		add(panelAlles, BorderLayout.CENTER);

		setVisible(true);
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
