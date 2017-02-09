package eventlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Login;
import gui.MainFrame;

public class ListenerButtonAusloggen implements ActionListener {

	MainFrame mainFrame = null;
	
	public ListenerButtonAusloggen(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void actionPerformed(ActionEvent e) {
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(new Login(mainFrame));
		mainFrame.getContentPane().revalidate();
	}
}