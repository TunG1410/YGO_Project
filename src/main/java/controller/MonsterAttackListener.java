package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.GUI;
import view.SoundEffects;

public class MonsterAttackListener implements MouseListener {
	private GUI gui;

	public MonsterAttackListener(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!gui.getCardLocationPanel().getEnabled()) {
			return;
		}
		
		JButton b = (JButton) e.getComponent();
		if (b.getText() == "ATTACK" && gui.getNewGame().getCurrentPlayer().getField().getPhase() != "BATTLE") {
			SoundEffects.exceptionSound();
			JOptionPane.showMessageDialog(null, "Only attatck in BATTLE phase!");
		}
		if (gui.getNewGame().getCurrentPlayer().getField().getPhase() == "BATTLE") {
			gui.monsterAttack_UI(b);
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
