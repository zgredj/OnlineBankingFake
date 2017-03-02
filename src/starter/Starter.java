package starter;

import fehlermeldung.Fehlermeldung;
import gui.EnumGui;
import gui.MainFrame;
import gui.Navigator;

public class Starter {

	private Navigator navigator;
	private MainFrame mainFrame;
	private Fehlermeldung fehlermeldung;

	private Starter() {
		mainFrame = new MainFrame();
		fehlermeldung = new Fehlermeldung(mainFrame);
		navigator = new Navigator(mainFrame.getContentPane(), fehlermeldung);

		navigator.navigate(EnumGui.LOGIN);
	}
	public static void main(String[] args) {
		new Starter();
	}
}