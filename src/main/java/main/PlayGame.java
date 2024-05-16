package main;

import javax.swing.UIManager;

import view.GUI;

public class PlayGame {
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GUI();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
