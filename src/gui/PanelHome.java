package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import datenbank.DatenbankCode;
import datenbank.Konto;
import datenbank.Rechnung;
import datenbank.User;
import fehlermeldung.Fehlermeldung;
import fehlermeldung.OnlineBankingException;

public class PanelHome extends JPanel {

	private JLabel labelOffeneRechnungenHome = new JLabel("Offene Rechnungen");

	private JPanel panelRechnungenListeHome = new JPanel();
	private JPanel panelWestBoxHome = new JPanel();
	private JPanel panelRechnungenBezahlenHome = new JPanel(new BorderLayout());
	private JPanel panelRechnungenListeRandHome = new JPanel(new BorderLayout());

	private JButton buttonRechnungenBezahlenHome = new JButton("Bezahlen");

	private long summeRechnungen = 0;

	public PanelHome(Fehlermeldung fehlermeldung, Navigator navigator, User user) {

		setLayout(new BorderLayout());

		ArrayList<JCheckBox> allCheckBoxHome = this.createRechnungCheckBoxes(user.getKartennummer());

		JLabel labelKartennummerHome = new JLabel("Kartenummer:      " + user.getKartennummer());
		JLabel labelKontostandHome = new JLabel(
				"Kontostand:         " + DatenbankCode.getKontostandVonDatenbank(user.getKartennummer()) + " CHF");

		labelKartennummerHome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelKontostandHome.setFont(new Font("Arial", Font.PLAIN, 20));

		labelOffeneRechnungenHome.setFont(new Font("Arial", Font.BOLD, 20));

		buttonRechnungenBezahlenHome.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					for (JCheckBox checkBox : allCheckBoxHome) {
						if (checkBox.isSelected()) {
							int checkBoxId = (int) checkBox.getClientProperty("id");
							double checkBoxBetrag = (double) checkBox.getClientProperty("betrag");
							int checkBoxVersender = (int) checkBox.getClientProperty("versender");
							DatenbankCode.deleteRechnungById(checkBoxId);
							DatenbankCode.setKontostandByKartennummer(user.getKartennummer(), summeRechnungen,
									"auszahlen");
							DatenbankCode.ueberweiseBezahlteRechnungByKartennummer(checkBoxVersender, checkBoxBetrag);
						}
					}

					fehlermeldung.openInfoDialog("Die Rechnung(en) wurden erfolgreich bezahlt!",
							"Rechnungen wurden bezahlt!");

					navigator.navigate(EnumGui.LayoutEingeloggt);
				} catch (OnlineBankingException exc) {
					fehlermeldung.openFehlermeldungDialog(
							"Die Rechnung(en) konnten nicht bezahlt werden, da Sie zu wenig Geld auf dem Konto haben!");
				}
			}
		});

		panelRechnungenBezahlenHome.add(labelOffeneRechnungenHome, BorderLayout.NORTH);
		panelRechnungenBezahlenHome.add(buttonRechnungenBezahlenHome, BorderLayout.SOUTH);

		panelRechnungenListeRandHome.add(panelRechnungenListeHome);

		panelRechnungenListeHome.setLayout(new BoxLayout(panelRechnungenListeHome, BoxLayout.Y_AXIS));

		panelWestBoxHome.add(labelKartennummerHome);
		panelWestBoxHome.add(labelKontostandHome);
		panelWestBoxHome.setLayout(new BoxLayout(panelWestBoxHome, BoxLayout.PAGE_AXIS));

		add(panelRechnungenBezahlenHome, BorderLayout.EAST);
		add(panelWestBoxHome, BorderLayout.WEST);

		panelRechnungenBezahlenHome.setBorder(BorderFactory.createEmptyBorder(30, 150, 200, 100));
		panelRechnungenListeHome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0));

		for (JCheckBox checkboxHome : allCheckBoxHome) {
			panelRechnungenListeHome.add(checkboxHome);
		}

		JScrollPane scrollPane = new JScrollPane(panelRechnungenListeHome);
		scrollPane.setPreferredSize(new Dimension(100, 300));
		panelRechnungenBezahlenHome.add(scrollPane, BorderLayout.CENTER);
	}

	private ArrayList<JCheckBox> createRechnungCheckBoxes(int kartennummer) {
		int kontoNr = DatenbankCode.getKontoIdByKartennummerOrNull(kartennummer);
		ArrayList<JCheckBox> arrayCheckBoxes = new ArrayList<JCheckBox>();
		ArrayList<Rechnung> arrayRechnungen = DatenbankCode.getRechnungVonDatenbank(kontoNr);
		for (Rechnung rechnung : arrayRechnungen) {
			Konto konto = new Konto();
			konto = DatenbankCode.getVorUndNachnameVonDatenbankByKartennummer(rechnung.getKartennummer());
			JCheckBox chbox = new JCheckBox(
					rechnung.getBetrag() + " CHF " + konto.getVorname() + " " + konto.getName());
			chbox.putClientProperty("id", rechnung.getId());
			chbox.putClientProperty("versender", rechnung.getKartennummer());
			chbox.putClientProperty("betrag", rechnung.getBetrag());
			chbox.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						summeRechnungen += rechnung.getBetrag();
					} else {
						summeRechnungen -= rechnung.getBetrag();
					}
				}

			});
			arrayCheckBoxes.add(chbox);
		}
		return arrayCheckBoxes;
	}
}
