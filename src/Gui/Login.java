package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends BasisLayout {

	public Login() {
		JPanel alles = new JPanel(new BorderLayout());
		alles.setBorder(BorderFactory.createEmptyBorder(40, 110, 0, 0));

		JPanel panelTitel = new JPanel(new BorderLayout());
		JLabel labelTitelBig = new JLabel("BBC BANK");
		JLabel labelTitelSmall = new JLabel("Login");
		labelTitelBig.setFont(new Font("Arial", Font.PLAIN, 70));
		labelTitelSmall.setFont(new Font("Arial", Font.PLAIN, 50));
		panelTitel.add(labelTitelBig, BorderLayout.NORTH);
		panelTitel.add(labelTitelSmall, BorderLayout.SOUTH);

		alles.add(panelTitel, BorderLayout.NORTH);

		JPanel panelInhalt = new JPanel(new BorderLayout());
		JTextField textFieldKartennummer = new JTextField();
		JPanel panelPassLog = new JPanel(new FlowLayout());
		JTextField textFieldPasswort = new JTextField();
		JButton buttonLogin = new JButton("Login");
		panelPassLog.add(textFieldPasswort);
		panelPassLog.add(buttonLogin);
		panelInhalt.add(textFieldKartennummer, BorderLayout.NORTH);
		panelInhalt.add(panelPassLog, BorderLayout.SOUTH);
		
		alles.add(panelInhalt, BorderLayout.CENTER);
		
		add(alles, BorderLayout.CENTER);
}