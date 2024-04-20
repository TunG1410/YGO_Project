package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.DrawCardListener;
import model.Player;

import javax.swing.JButton;

public class CardLocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player1 = new Player();
	private Player player2 = new Player();
	private ArrayList<JButton> cardInHandPlayer1 = new ArrayList<JButton>();
	private ArrayList<JButton> cardInHandPlayer2;

	public CardLocationPanel(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(1115, 850);
		setLayout(null);

		DrawCardListener drawCardListener = new DrawCardListener(this);

		for (int i = 0; i < player1.getHand().getCardsInHand().size(); ++i) {
			JButton cardInHandBtn = new JButton("");
			cardInHandBtn.setBounds(420 + i * 60, 670, 120, 175);
			cardInHandBtn.setIcon(player1.getHand().getCardsInHand().get(i).getImageMedium());
			cardInHandPlayer1.add(cardInHandBtn);
			this.add(cardInHandBtn);
		}
		
		JButton drawCardButton = new JButton("40");
		drawCardButton.setBounds(1030, 560, 70, 100);
		drawCardButton.addActionListener(drawCardListener);
		add(drawCardButton);
	}

	public void drawCard() {
		if (player1.getField().getPhase() == "DRAW" && player1.getHand().getCardsInHand().size() < 11
				&& !player1.isDrawed()) {
			player1.drawCard();
			player1.setDrawed(true);
		}
	}
}
