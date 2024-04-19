package view;

import java.awt.Color;

import javax.swing.JPanel;

import controller.DrawCardListener;
import model.Player;

import javax.swing.JButton;

public class CardLocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player1 = new Player();
	private Player player2 = new Player();

	public CardLocationPanel(Player player1, Player player2) {
		this.init();
		this.player1 = player1;
		this.player2 = player2;
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(1115, 850);
		setLayout(null);

		DrawCardListener drawCardListener = new DrawCardListener(this);

		JButton drawCardButton = new JButton("40");
		drawCardButton.setBounds(1030, 560, 70, 100);
		drawCardButton.addActionListener(drawCardListener);
		add(drawCardButton);

		JButton CardInHandBtn_1_10 = new JButton("110");
		CardInHandBtn_1_10.setBounds(960, 670, 120, 175);
		CardInHandBtn_1_10.setVisible(false);
		add(CardInHandBtn_1_10);

		JButton CardInHandBtn_1_9 = new JButton("19");
		CardInHandBtn_1_9.setBounds(900, 670, 120, 175);
		CardInHandBtn_1_9.setVisible(false);
		add(CardInHandBtn_1_9);

		JButton CardInHandBtn_1_8 = new JButton("18");
		CardInHandBtn_1_8.setBounds(840, 670, 120, 175);
		CardInHandBtn_1_8.setVisible(false);
		add(CardInHandBtn_1_8);

		JButton CardInHandBtn_1_7 = new JButton("17");
		CardInHandBtn_1_7.setBounds(780, 670, 120, 175);
		CardInHandBtn_1_7.setVisible(false);
		add(CardInHandBtn_1_7);

		JButton CardInHandBtn_1_6 = new JButton("16");
		CardInHandBtn_1_6.setBounds(720, 670, 120, 175);
		CardInHandBtn_1_6.setVisible(false);
		add(CardInHandBtn_1_6);

		JButton CardInHandBtn_1_5 = new JButton("15");
		CardInHandBtn_1_5.setBounds(660, 670, 120, 175);
		CardInHandBtn_1_5.setVisible(false);
		add(CardInHandBtn_1_5);

		JButton CardInHandBtn_1_4 = new JButton("14");
		CardInHandBtn_1_4.setBounds(600, 670, 120, 175);
		CardInHandBtn_1_4.setVisible(false);
		add(CardInHandBtn_1_4);

		JButton CardInHandBtn_1_3 = new JButton("13");
		CardInHandBtn_1_3.setBounds(540, 670, 120, 175);
		CardInHandBtn_1_3.setVisible(false);
		add(CardInHandBtn_1_3);

		JButton CardInHandBtn_1_2 = new JButton("12");
		CardInHandBtn_1_2.setBounds(480, 670, 120, 175);
		CardInHandBtn_1_2.setVisible(false);
		add(CardInHandBtn_1_2);

		JButton CardInHandBtn_1_1 = new JButton("11");
		CardInHandBtn_1_1.setBounds(420, 670, 120, 175);
		CardInHandBtn_1_1.setVisible(false);
		add(CardInHandBtn_1_1);
	}

	public void drawCard() {
		if (player1.getField().getPhase() == "DRAW" && player1.getHand().getCardsInHand().size() < 11 && !player1.isDrawed()) {
			player1.drawCard();
			player1.setDrawed(true);
		}
	}
}
