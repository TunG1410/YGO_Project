package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GUI;

public class PauseGameListener implements ActionListener {
	private GUI gui;

	public PauseGameListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.pauseGame();
	}

}
