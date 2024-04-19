package view;

import javax.swing.JPanel;

import model.FinalValues;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JButton;

public class CardInHandPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CardInHandPanel() {
		this.setBackground(FinalValues.getNoColor());
		this.setSize(660, 175);
		setLayout(null);

		JButton cardInHandBtn_10 = new JButton("");
		cardInHandBtn_10.setBounds(540, 0, 120, 175);
		cardInHandBtn_10.setVisible(false);
		add(cardInHandBtn_10);

		JButton cardInHandBtn_9 = new JButton("");
		cardInHandBtn_9.setBounds(480, 0, 120, 175);
		cardInHandBtn_9.setVisible(false);
		add(cardInHandBtn_9);

		JButton cardInHandBtn_8 = new JButton("");
		cardInHandBtn_8.setBounds(420, 0, 120, 175);
		cardInHandBtn_8.setVisible(false);
		add(cardInHandBtn_8);

		JButton cardInHandBtn_7 = new JButton("");
		cardInHandBtn_7.setBounds(360, 0, 120, 175);
		cardInHandBtn_7.setVisible(false);
		add(cardInHandBtn_7);

		JButton cardInHandBtn_6 = new JButton("");
		cardInHandBtn_6.setBounds(300, 0, 120, 175);
		cardInHandBtn_6.setVisible(false);
		add(cardInHandBtn_6);

		JButton cardInHandBtn_5 = new JButton("");
		cardInHandBtn_5.setBounds(240, 0, 120, 175);
		cardInHandBtn_5.setVisible(false);
		add(cardInHandBtn_5);

		JButton cardInHandBtn_4 = new JButton("");
		cardInHandBtn_4.setBounds(180, 0, 120, 175);
		cardInHandBtn_4.setVisible(false);
		add(cardInHandBtn_4);
		
		JButton cardInHandBtn_3 = new JButton("");
		cardInHandBtn_3.setBounds(120, 0, 120, 175);
		cardInHandBtn_3.setVisible(false);
		add(cardInHandBtn_3);

		JButton cardInHandBtn_2 = new JButton("");
		cardInHandBtn_2.setBounds(60, 0, 120, 175);
		cardInHandBtn_2.setVisible(false);
		add(cardInHandBtn_2);

		JButton cardInHandBtn_1 = new JButton("");
		cardInHandBtn_1.setBounds(0, 0, 120, 175);
		cardInHandBtn_1.setVisible(false);
		add(cardInHandBtn_1);
	}
}