package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import view.CardLocationPanel;
import view.GUI;

public class SelectOpponentFieldListener implements MouseListener {
	private CardLocationPanel cardLocationPanel;
	private GUI gui;
		
	public SelectOpponentFieldListener(CardLocationPanel cardLocationPanel, GUI gui) {
		this.cardLocationPanel = cardLocationPanel;
		this.gui = gui;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!cardLocationPanel.getEnabled()) {
			return;
		}
		
		JButton b = (JButton) e.getComponent();
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer1()) {
			cardLocationPanel.selectOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton2(), b);
			cardLocationPanel.selectOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton2(), b);
		}
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer2()) {
			cardLocationPanel.selectOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton1(), b);
			cardLocationPanel.selectOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton1(), b);
		}
		cardLocationPanel.revalidate();
		cardLocationPanel.repaint();
		gui.revalidate();
		gui.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		cardLocationPanel.revalidate();
		cardLocationPanel.repaint();
		gui.revalidate();
		gui.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		cardLocationPanel.revalidate();
		cardLocationPanel.repaint();
		gui.revalidate();
		gui.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (!cardLocationPanel.getEnabled()) {
			gui.revalidate();
			gui.repaint();
			return;
		}
		
		JButton b = (JButton) e.getComponent();
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer1()) {
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton2(), b, true);
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton2(), b, true);
		}
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer2()) {
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton1(), b, true);
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton1(), b, true);
		}
		cardLocationPanel.revalidate();
		cardLocationPanel.repaint();
		gui.revalidate();
		gui.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (!cardLocationPanel.getEnabled()) {
			gui.revalidate();
			gui.repaint();
			return;
		}
		
		JButton b = (JButton) e.getComponent();
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer1()) {
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton2(), b, false);
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer1(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton2(), b, false);
		}
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer2()) {
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getMonsterFieldButton1(), b, false);
			cardLocationPanel.hoverOpponentField_UI(gui.getNewGame().getPlayer2(), (ArrayList<JButton>) cardLocationPanel.getSpellTrapFieldButton1(), b, false);
		}
		cardLocationPanel.revalidate();
		cardLocationPanel.repaint();
		gui.revalidate();
		gui.repaint();
	}

}
