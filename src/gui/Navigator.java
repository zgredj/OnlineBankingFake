package gui;

import java.awt.Container;

import javax.swing.JPanel;

import datenbank.User;
import fehlermeldung.Fehlermeldung;

public class Navigator {

	private Container container;
	private Fehlermeldung fehlermeldung;
	private User user;

	public Navigator(Container container, Fehlermeldung fehlermeldung, User user) {
		this.container = container;
		this.fehlermeldung = fehlermeldung;
		this.user = user;
	}

	public void navigate(EnumGui gui) {
		switch (gui) {
		case LayoutEingeloggt:
			changeGuiPanel(new LayoutEingeloggt(this, fehlermeldung, user));
			break;
		case Registrieren:
			changeGuiPanel(new Registrieren(this, fehlermeldung));
			break;
		case Login:
			changeGuiPanel(new Login(this, fehlermeldung));
			break;
		}
	}

	private void changeGuiPanel(JPanel panel) {
		container.removeAll();
		container.add(panel);
		container.revalidate();
	}
}
