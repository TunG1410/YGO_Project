package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GUI;

public class ControlCardListener1 implements MouseListener {
	private GUI gui;

	public ControlCardListener1(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard"
				&& gui.getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand") {
			gui.summon();
		}
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
			gui.summon();
		}
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
			gui.summon();
		}
		if (gui.getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard"
				&& gui.getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand") {
			gui.useField();
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
