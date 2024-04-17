package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import model.FinalValues;

public class CardLocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CardLocationPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(1115, 850);
		setLayout(null);
		
		JButton drawCardButton = new JButton("40");
		drawCardButton.setBounds(1020, 560, 70, 100);
		add(drawCardButton);
		
		JPanel handTglBtn_1 = new CardInHandPanel();
		handTglBtn_1.setLocation(385, 665);
		add(handTglBtn_1);
		
		JToggleButton handTglBtn_2 = new JToggleButton();
		handTglBtn_2.setBounds(385, 0, 130, 185);
		handTglBtn_2.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/view/resources/Battle Background.jpg")));
		handTglBtn_2.setBorder(new LineBorder(new Color(0, 0, 0, 0), 5));
		add(handTglBtn_2);
		
		
	}
}
