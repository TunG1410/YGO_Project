package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.CardLocationPanel;
import view.GUI;

public class ShowCardInfoListener implements MouseListener {
	private GUI gui;
	private CardLocationPanel cardLocationPanel;

	public ShowCardInfoListener(GUI gui, CardLocationPanel cardLocationPanel) {
		this.gui = gui;
		this.cardLocationPanel = cardLocationPanel;
	}

	public void mouseClicked(MouseEvent e) {
		gui.showCardInfo();
		gui.cardControl();
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
