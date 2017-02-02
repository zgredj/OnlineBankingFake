package Gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		JTextField textFieldKartennummer = new JTextField(10);
		JPanel panelPassLog = new JPanel(new BorderLayout());
		JTextField textFieldPasswort = new JTextField(10);
		JButton buttonLogin = new JButton("Login");
		JPanel panelLabelRegbutton = new JPanel(new BorderLayout());
		JLabel labelText = new JLabel("Noch kein Benutzerkonto?");
		JButton buttonRegistrieren = new JButton("Registrieren");

		panelInhalt.add(textFieldKartennummer, BorderLayout.NORTH);

		panelPassLog.add(textFieldPasswort, BorderLayout.WEST);
		panelPassLog.add(buttonLogin, BorderLayout.EAST);

		panelLabelRegbutton.add(labelText, BorderLayout.NORTH);
		panelLabelRegbutton.add(buttonRegistrieren, BorderLayout.SOUTH);

		panelInhalt.add(panelPassLog, BorderLayout.CENTER);
		panelInhalt.add(panelLabelRegbutton, BorderLayout.SOUTH);

		alles.add(panelInhalt, BorderLayout.SOUTH);
		
		add(alles, BorderLayout.CENTER);
		setSize(1200, 800);
		setResizable(false);
	}
}