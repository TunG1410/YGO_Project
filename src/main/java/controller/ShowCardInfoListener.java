package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GUI;

public class ShowCardInfoListener implements MouseListener {
	private GUI gui;

	public ShowCardInfoListener(GUI gui) {
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard() != null) {
			if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard") {
				gui.showCardInfo();
				gui.showCardControl();
			}
			else {
				if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getOwner() == gui.getNewGame().getCurrentPlayer().getPlayerName()) {
					if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Graveyard") {
						gui.showCardInfo();
						gui.closeShowControl();
					}
					else {
						gui.showCardInfo();
						gui.showCardControl();
					}
				}
				if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getOwner() != gui.getNewGame().getCurrentPlayer().getPlayerName()) {
					gui.showCardInfo();
					gui.closeShowControl();
				}
			}
		}
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard() == null) {
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
