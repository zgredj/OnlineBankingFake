package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TestGui {

	JButton myButton = new JButton();

	public TestGui() {

		myButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}

		});

		myButton.addActionListener(new MyActionListener());
	}

}

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
