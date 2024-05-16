package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data_access_object.CardDAO;
import view.SoundEffects;

public class CloseGameListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CardDAO.getInstance().deleteAll();
		SoundEffects.closeGameSound();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}

}
