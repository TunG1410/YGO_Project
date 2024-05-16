package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.CardLocationPanel;

public class DrawCardListener implements ActionListener {
	private CardLocationPanel cardLocationPanel;
	
	public DrawCardListener(CardLocationPanel cardLocationPanel) {
		this.cardLocationPanel = cardLocationPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (!cardLocationPanel.getEnabled()) {
			return;
		}
		
		JButton btn = (JButton) e.getSource();
		cardLocationPanel.drawCard(cardLocationPanel.getCurrentPlayer(), btn);
	}

}
