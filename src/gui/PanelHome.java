package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHome extends JPanel {

	JLabel labelKartennummerHome = new JLabel("Kartenummer");
	JLabel labelKontostandHome = new JLabel("Kontostand");
	JLabel labelOffeneRechnungenHome = new JLabel("Offene Rechnungen");

	JLabel labelTest1 = new JLabel("Test 1");
	JLabel labelTest2 = new JLabel("Test 2");
	JLabel labelTest3 = new JLabel("Test 3");
	JLabel labelTest4 = new JLabel("Test 4");
	JLabel labelTest5 = new JLabel("Test 5");
	JLabel labelTest6 = new JLabel("Test 6");

	JPanel panelRechnungenListeHome = new JPanel();
	JPanel westBoxHome = new JPanel();
	JPanel rechnungenBezahlenHome = new JPanel(new BorderLayout());
	JPanel panelRechnungenListeRandHome = new JPanel(new BorderLayout());

	JButton buttonRechnungenBezahlenHome = new JButton("bezahlen");

	public PanelHome() {
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

		panelRechnungenListeHome.add(labelTest1);
		panelRechnungenListeHome.add(labelTest2);
		panelRechnungenListeHome.add(labelTest3);
		panelRechnungenListeHome.add(labelTest4);
		panelRechnungenListeHome.add(labelTest5);
		panelRechnungenListeHome.add(labelTest6);

		panelRechnungenListeRandHome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		panelRechnungenListeHome.setBorder(BorderFactory.createEtchedBorder(5, Color.BLACK, Color.BLACK));
		rechnungenBezahlenHome.setBorder(BorderFactory.createEmptyBorder(30, 150, 200, 100));
		setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0));
	}
}
