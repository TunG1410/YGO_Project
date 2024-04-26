package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.CardLocationPanel;

public class SelectCardListener implements MouseListener {
	private CardLocationPanel cardLocationPanel;

	public SelectCardListener(CardLocationPanel cardLocationPanel) {
		this.cardLocationPanel = cardLocationPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Component t = e.getComponent();
		cardLocationPanel.selectCard(t);
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
		Component t = e.getComponent();
		cardLocationPanel.highlightCard(t, true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Component t = e.getComponent();
		cardLocationPanel.highlightCard(t, false);
	}

}
