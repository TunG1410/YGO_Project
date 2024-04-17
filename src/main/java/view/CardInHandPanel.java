package view;

import javax.swing.JPanel;

import model.FinalValues;
import javax.swing.JToggleButton;
import java.awt.Color;

public class CardInHandPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CardInHandPanel() {
		this.setBackground(FinalValues.getNoColor());
		this.setSize(130, 185);
		setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBackground(new Color(0, 0, 0, 0));
		tglbtnNewToggleButton.setBorderPainted(true);
		tglbtnNewToggleButton.setOpaque(true);
		add(tglbtnNewToggleButton);
	}

}