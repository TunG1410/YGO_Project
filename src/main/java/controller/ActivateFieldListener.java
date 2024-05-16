package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.GUI;
import view.SoundEffects;

public class ActivateFieldListener implements MouseListener {
	private GUI gui;

	public ActivateFieldListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard() != null
				&& gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard"
				&& gui.getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "On Hand") {
			
			// Exception activate field
			if (gui.getNewGame().getCurrentPlayer().getField().getPhase() != "MAIN 1"
					&& gui.getNewGame().getCurrentPlayer().getField().getPhase() != "MAIN 2") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Only activate field in MAIN 1 or MAIN 2!");
				return;
			}
			
			gui.useField_UI();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
