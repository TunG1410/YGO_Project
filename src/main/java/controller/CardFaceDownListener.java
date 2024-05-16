package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import view.GUI;

public class CardFaceDownListener implements MouseListener {
	private GUI gui;

	public CardFaceDownListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		JButton b = (JButton) e.getComponent();
		gui.faceDownSpellTrap_UI(b);
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
