package starter; 

import datenbank.User;
import fehlermeldung.Fehlermeldung;
import gui.EnumGui;
import gui.MainFrame;
import gui.Navigator;

public class Starter {

	private Navigator navigator;
	private MainFrame mainFrame;
	private Fehlermeldung fehlermeldung;
	private User user = new User();

	private Starter() {
		mainFrame = new MainFrame();
		navigator = new Navigator(mainFrame.getContentPane(), fehlermeldung, user);
		fehlermeldung = new Fehlermeldung(mainFrame);

		navigator.navigate(EnumGui.Login);
	}

	public static void main(String[] args) {
		new Starter();
	}
}