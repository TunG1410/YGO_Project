package model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private String fieldSide;
	private List<Card> deckZone;
	private List<MonsterCard> monsterZone;
	private List<SpellCard> spellZone;
	private List<TrapCard> trapZone;
	private FieldCard fieldZone;
	private ArrayList<Card> graveyard;
	private String phase;

	public Field() {
	}

	public Field(Player player) {
		fieldSide = player.getPlayerName();
		deckZone = new ArrayList<Card>();
		monsterZone = new ArrayList<MonsterCard>();
		spellZone = new ArrayList<SpellCard>();
		trapZone = new ArrayList<TrapCard>();
		graveyard = new ArrayList<Card>();
	}

	public String getFieldSide() {
		return fieldSide;
	}

	public void setFieldSide(String fieldSide) {
		this.fieldSide = fieldSide;
	}

	public ArrayList<Card> getDeck() {
		return (ArrayList<Card>) deckZone;
	}

	public void addToDeck(Card card) {
		deckZone.add(card);
	}

	public void removeFromDeck(Card card) {
		deckZone.remove(card);
	}

	public ArrayList<MonsterCard> getMonster() {
		return (ArrayList<MonsterCard>) monsterZone;
	}

	public void setMonster(MonsterCard monsterCard) {
		if (monsterZone.size() < 6) {
			monsterZone.add(monsterCard);
		}
	}

	public void removeMonster(MonsterCard monsterCard) {
		monsterZone.remove(monsterCard);
	}

	public ArrayList<SpellCard> getSpell() {
		return (ArrayList<SpellCard>) spellZone;
	}

	public void setEffect(SpellCard spellCard) {
		if (spellZone.size() < 6) {
			spellZone.add(spellCard);
		}
	}

	public void removeEffect(SpellCard spellCard) {
		spellZone.remove(spellCard);
	}
	
	public ArrayList<TrapCard> getTrap() {
		return (ArrayList<TrapCard>) trapZone;
	}

	public void setEffect(TrapCard trapCard) {
		if (trapZone.size() < 6) {
			trapZone.add(trapCard);
		}
	}

	public void removeEffect(TrapCard trapCard) {
		trapZone.remove(trapCard);
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