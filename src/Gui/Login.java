package Gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Login extends BasisLayout {

	public Login() {
		JPanel alles = new JPanel(new BorderLayout());
		alles.setBorder(BorderFactory.createEmptyBorder(40, 110, 0, 0));

		JPanel panelTitel = new JPanel();
		JLabel labelTitelBig = new JLabel("BBC BANK");
		JLabel labelTitelSmall = new JLabel("Login");
		labelTitelBig.setFont(new Font("Arial", Font.PLAIN, 80));
		labelTitelSmall.setFont(new Font("Arial", Font.PLAIN, 60));
		panelTitel.add(labelTitelBig, BorderLayout.NORTH);
		panelTitel.add(labelTitelSmall, BorderLayout.SOUTH);

		alles.add(panelTitel, BorderLayout.NORTH);

		add(alles, BorderLayout.CENTER);

	}
}