package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();
	}

	public ArrayList<Card> getDeck() {
		return (ArrayList<Card>) deck;
	}

	// Trộn bài bằng phương thức shuffle trong class Collections có sẵn
	public void shuffleDeck() {
		Collections.shuffle(getDeck());
	}

	public void addCardToDeck(Card card) {
		deck.add(card);
	}

	// Lấy ra card đầu tiên rồi xóa(Rút bài)
	public Card drawOneCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}
	
}