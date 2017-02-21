package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import datenbank.DatenbankCode;
import datenbank.Konto;
import datenbank.Rechnung;
import fehlermeldung.Fehlermeldung;

public class PanelHome extends JPanel {

	JLabel labelOffeneRechnungenHome = new JLabel("Offene Rechnungen");

	JPanel panelRechnungenListeHome = new JPanel();
	JPanel westBoxHome = new JPanel();
	JPanel panelRechnungenBezahlenHome = new JPanel(new BorderLayout());
	JPanel panelRechnungenListeRandHome = new JPanel(new BorderLayout());

	JButton buttonRechnungenBezahlenHome = new JButton("Bezahlen");

	long summeRechnungen = 0;
	
	public PanelHome(int kartennummer, MainFrame mainFrame) {
		ArrayList<JCheckBox> allCheckBoxHome = this.createRechnungCheckBoxes(kartennummer); 
		
		JLabel labelKartennummerHome = new JLabel("Kartenummer:      " + kartennummer);
		JLabel labelKontostandHome = new JLabel("Kontostand:         " + DatenbankCode.getKontostandVonDatenbank(kartennummer) + " CHF");

		labelKartennummerHome.setFont(new Font("Arial", Font.PLAIN, 20));
		labelKontostandHome.setFont(new Font("Arial", Font.PLAIN, 20));

		setLayout(new BorderLayout());
		labelOffeneRechnungenHome.setFont(new Font("Arial", Font.BOLD, 20));

		buttonRechnungenBezahlenHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					DatenbankCode.setKontostandByKartennummer(kartennummer, summeRechnungen, "auszahlen", mainFrame);
					for (JCheckBox checkBox : allCheckBoxHome) {
						if (checkBox.isSelected()){
							int checkBoxId = (int) checkBox.getClientProperty("id");
							double checkBoxBetrag = (double) checkBox.getClientProperty("betrag");
							DatenbankCode.deleteRechnungById(checkBoxId);
						DatenbankCode.ueberweiseBezahlteRechnungByKartennummer(kartennummer, checkBoxBetrag);
						}
					}
					JOptionPane.showMessageDialog(mainFrame, "Die Rechnung(en) wurden erfolgreich bezahlt!", "Rechnungen wurden bezahlt!", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc) {
					Fehlermeldung.openFehlermeldungDialog("Die Rechnung(en) konnten nicht bezahlt werden, da Sie zu wenig Geld auf dem Konto haben!", mainFrame);
				}
			}
		});
		
		panelRechnungenBezahlenHome.add(labelOffeneRechnungenHome, BorderLayout.NORTH);
		panelRechnungenBezahlenHome.add(buttonRechnungenBezahlenHome, BorderLayout.SOUTH);

		panelRechnungenListeRandHome.add(panelRechnungenListeHome);

		westBoxHome.setLayout(new BoxLayout(westBoxHome, BoxLayout.PAGE_AXIS));
		panelRechnungenListeHome.setLayout(new BoxLayout(panelRechnungenListeHome, BoxLayout.Y_AXIS));

		add(panelRechnungenBezahlenHome, BorderLayout.EAST);
		add(westBoxHome, BorderLayout.WEST);

		westBoxHome.add(labelKartennummerHome);
		westBoxHome.add(labelKontostandHome);

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
			JCheckBox chbox = new JCheckBox(rechnung.getBetrag() + " CHF " + konto.getVorname() + " " + konto.getName());
			chbox.putClientProperty("id", rechnung.getId());
			chbox.putClientProperty("betrag", rechnung.getBetrag());
			chbox.addItemListener(new ItemListener(){
				
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
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
