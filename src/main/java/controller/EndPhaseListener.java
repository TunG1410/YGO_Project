package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GUI;

public class EndPhaseListener implements MouseListener {
	private GUI gui;

	public EndPhaseListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		this.gui.endPhase();
		if (gui.getNewGame().getCurrentPlayer().getField().getPhase() == "DRAW" && gui.getNewGame().getCurrentPlayer().isDrawed()) {
			gui.endTurn();
			if (gui.getNewGame().getCurrentPlayer().getHand().getCardsInHand().size() < 10 && gui.getNewGame().getCurrentPlayer().getDeck().getDeck().size() > 0) {
				gui.getNewGame().getCurrentPlayer().setDrawed(false);
			}
			if (gui.getNewGame().getCurrentPlayer().getHand().getCardsInHand().size() >= 10 || gui.getNewGame().getCurrentPlayer().getDeck().getDeck().size() <= 0) {
				gui.getNewGame().getCurrentPlayer().endPhase("MAIN 2");
				gui.endPhase();
			}
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
