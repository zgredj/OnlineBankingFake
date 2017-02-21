package testerKlassen;

import gui.LayoutEingeloggt;
import gui.MainFrame;

public class MainFrameTester {

	public static void main(String[] args) {
		
		MainFrame br1 = new MainFrame();
		br1.getContentPane().removeAll();
		br1.getContentPane().add(new LayoutEingeloggt(br1, "Vorname", "nachname", 1));
		br1.getContentPane().revalidate();
	}

}
