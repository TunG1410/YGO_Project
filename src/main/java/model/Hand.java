package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cardsInHand;
	private String playersHand;

	
	public Hand() {
	}

	public Hand(Player player) {
		cardsInHand = new ArrayList<Card>();
		playersHand = player.getPlayerName();
	}

	public ArrayList<Card> getCardsInHand() {
		return (ArrayList<Card>) cardsInHand;
	}

	public String getPlayersHand() {
		return playersHand;
	}

	public void addCardToHand(Card card) {
		cardsInHand.add(card);
	}

	public void removeCardFromHand(Card card) {
		for (int i = 0; i < cardsInHand.size(); i++) {
			if (cardsInHand.get(i) == card) {
				cardsInHand.remove(card);
				return;
			}
		}
	}
}