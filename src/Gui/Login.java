package Gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;

public class Login extends BasisLayout {

	public Login() {
		JLabel titel = new JLabel("BBC BANK");
		titel.setFont(new Font("Arial", Font.PLAIN, 70));

		add(titel, BorderLayout.NORTH);

	}
}