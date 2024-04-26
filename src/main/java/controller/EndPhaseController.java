package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GUI;
import view.PhaseControlPanel;

public class EndPhaseController implements MouseListener {
	private GUI gui;
	private PhaseControlPanel phaseControlPanel;

	public EndPhaseController(GUI gui, PhaseControlPanel phaseControlPanel) {
		this.gui = gui;
		this.phaseControlPanel = phaseControlPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.gui.endPhase();
		if (gui.getNewGame().getCurrentPlayer().getField().getPhase() == "DRAW" && gui.getNewGame().getCurrentPlayer().isDrawed()) {
			gui.endTurn();
			gui.getNewGame().getCurrentPlayer().setDrawed(false);
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
