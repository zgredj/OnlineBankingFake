package gui;

import java.awt.Container;

import javax.swing.JPanel;

import datenbank.User;
import fehlermeldung.Fehlermeldung;

public class Navigator {

	private Container container;
	private Fehlermeldung fehlermeldung;
	private User user;

	public Navigator(Container container, Fehlermeldung fehlermeldung) {
		this.container = container;
		this.fehlermeldung = fehlermeldung;
	}

	public void navigate(EnumGui gui) {
		switch (gui) {
		case LOGIN:
			changeGuiPanel(new PanelLogin(this, fehlermeldung));
			break;
		case LAYOUTEINGELOGGT:
			changeGuiPanel(new PanelEingeloggt(this, fehlermeldung, user));
			break;
		case REGISTRIEREN:
			changeGuiPanel(new PanelRegistrieren(this, fehlermeldung));
			break;
		}
	}

	private void changeGuiPanel(JPanel panel) {
		container.removeAll();
		container.add(panel);
		container.revalidate();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
