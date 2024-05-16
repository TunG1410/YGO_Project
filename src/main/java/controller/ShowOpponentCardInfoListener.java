package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GUI;

public class ShowOpponentCardInfoListener implements MouseListener {
	private GUI gui;

	public ShowOpponentCardInfoListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		if (gui.getNewGame().getCurrentPlayer().getSelectedOpponentCard() != null && gui.getNewGame().getCurrentPlayer()
				.getSelectedOpponentCard().getOwner() == gui.getNewGame().getOpponentPlayer().getPlayerName()) {
			gui.opponentCardInfoShow();
		}
		if (gui.getNewGame().getCurrentPlayer().getSelectedOpponentCard() == null) {
			gui.closeShowInfo();
			gui.closeShowControl();
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
