package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
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

	private String vorname;
	private String nachname;

	public LayoutEingeloggt(final MainFrame mainFrame, String vorname, String nachname, int kartennummer) {
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

		labelTitel.setText("Willkommen");
		labelTitel.setFont(new Font("Arial", Font.PLAIN, 55));
		labelName.setText(vorname + "  " + nachname);
		labelName.setFont(new Font("Arial", Font.PLAIN, 16));
		labelAngemeldet.setText("Angemeldet");
		labelAngemeldet.setFont(new Font("Arial", Font.PLAIN, 14));

		panelKopfzeileEAST.setLayout(new BoxLayout(panelKopfzeileEAST, BoxLayout.Y_AXIS));
		panelKopfzeileEAST.add(labelName);
		panelKopfzeileEAST.add(labelAngemeldet);
		panelKopfzeile.setBorder(BorderFactory.createEmptyBorder(15, 40, 10, 30));
		panelKopfzeile.add(labelTitel, BorderLayout.WEST);
		panelKopfzeile.add(panelKopfzeileEAST, BorderLayout.EAST);

		panelAlles.add(panelKopfzeile, BorderLayout.NORTH);

		tabbedPaneMenu.addTab("Home", panelHome);
		tabbedPaneMenu.addTab("Zahlungen", panelZahlungen);
		tabbedPaneMenu.addTab("Rechnugen", panelRechnungen);

		// TabbedPane Home
		PanelHome panelHomeInstance = new PanelHome(kartennummer, mainFrame);
		panelHome.add(panelHomeInstance);

		// TabbedPane Zahlungen
		PanelZahlungen panelZahlungenInstance = new PanelZahlungen(mainFrame, kartennummer);
		panelZahlungen.add(panelZahlungenInstance);

		// TabbedPane Rechnungen
		PanelRechnungen panelRechnungenInstance = new PanelRechnungen(mainFrame, kartennummer);
		panelRechnungen.add(panelRechnungenInstance);

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
