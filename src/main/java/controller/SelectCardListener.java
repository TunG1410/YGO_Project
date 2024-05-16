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
		
		if (!cardLocationPanel.getEnabled()) {
			return;
		}
		
		Component t = e.getComponent();
		cardLocationPanel.selectCardInHand_UI(t);
		cardLocationPanel.selectCardInField_UI(t);
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
		
		if (!cardLocationPanel.getEnabled()) {
			return;
		}
		
		Component t = e.getComponent();
		cardLocationPanel.highlightCardInField_UI(t, true);
		cardLocationPanel.highlightCardInHand_UI(t, true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (!cardLocationPanel.getEnabled()) {
			return;
		}
		
		Component t = e.getComponent();
		cardLocationPanel.highlightCardInField_UI(t, false);
		cardLocationPanel.highlightCardInHand_UI(t, false);
	}

}
