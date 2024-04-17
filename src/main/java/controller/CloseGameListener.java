package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI;

public class CloseGameListener implements ActionListener {
	private GUI gui;

	public CloseGameListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
