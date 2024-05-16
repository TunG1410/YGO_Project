package model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private List<MonsterCard> monsterZone;
	private List<Card> spellTrapZone;
	private FieldCard fieldZone;
	private ArrayList<Card> graveyard;
	private String phase;

	public Field() {
	}

	public Field(Player player) {
		monsterZone = new ArrayList<MonsterCard>(5);
		spellTrapZone = new ArrayList<Card>(5);
		graveyard = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			monsterZone.add(null);
			spellTrapZone.add(null);
		}
	}

	public ArrayList<MonsterCard> getMonster() {
		return (ArrayList<MonsterCard>) monsterZone;
	}

	public ArrayList<Card> getSpellTrap() {
		return (ArrayList<Card>) spellTrapZone;
	}

	public FieldCard getField() {
		return fieldZone;
	}

	public void setField(FieldCard fieldCard) {
		fieldZone = fieldCard;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public void addToGraveyard(Card card) {
		card.setLocation("In Graveyard");
		graveyard.add(card);
	}

	public void removeFromGraveyard(Card card) {
		graveyard.remove(card);
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

}