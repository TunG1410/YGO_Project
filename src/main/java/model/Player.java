package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.SoundEffects;

public class Player {

	private String playerName;
	private int lifepoints;
	private Hand hand;
	private Deck deck;
	private Field field;
	private boolean normalSummoned = false;
	private boolean isDrawed = true;
	private Card selectedCard;
	private Card selectedOpponentCard;
	private MonsterCard tributeMonster1;
	private MonsterCard tributeMonster2;

	public Player() {

	}

	public Player(String name, int lp) {
		playerName = name;
		lifepoints = lp;
		hand = new Hand(this);
		deck = new Deck();
		field = new Field(this);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getLifepoints() {
		return lifepoints;
	}

	public void setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
	}

	public Hand getHand() {
		return hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public Field getField() {
		return field;
	}

	public boolean isNormalSummoned() {
		return normalSummoned;
	}

	public void setNormalSummoned(boolean normalSummoned) {
		this.normalSummoned = normalSummoned;
	}

	public boolean isDrawed() {
		return isDrawed;
	}

	public void setDrawed(boolean isDrawed) {
		this.isDrawed = isDrawed;
	}

	public Card getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(Card selectedCard) {
		this.selectedCard = selectedCard;
	}

	public Card getSelectedOpponentCard() {
		return selectedOpponentCard;
	}

	public void setSelectedOpponentCard(Card selectedOpponentCard) {
		this.selectedOpponentCard = selectedOpponentCard;
	}

	public MonsterCard getTributeMonster1() {
		return tributeMonster1;
	}

	public void setTributeMonster1(MonsterCard tributeMonster1) {
		this.tributeMonster1 = tributeMonster1;
	}

	public MonsterCard getTributeMonster2() {
		return tributeMonster2;
	}

	public void setTributeMonster2(MonsterCard tributeMonster2) {
		this.tributeMonster2 = tributeMonster2;
	}

	// Triệu hồi thông thường
	public void summonMonster(MonsterCard monsterCard, int i, String mode) {
		if (monsterCard.getType() == "MonsterCard") {
			field.getMonster().set(i, monsterCard);
			field.getMonster().get(i).setMode(mode);
			field.getMonster().get(i).setLocation("On Field");
			field.getMonster().get(i).setSwitchedMode(true);
			hand.removeCardFromHand(monsterCard);
			this.normalSummoned = true;
		}
	}

	// Triệu hồi hiến tế (lv > 4)
	public void tributeSummon(MonsterCard monsterCard, int i, int j, int k, String mode) {
		if (monsterCard.getType() == "MonsterCard") {
			field.addToGraveyard(field.getMonster().get(j));
			field.getMonster().set(j, null);
			field.addToGraveyard(field.getMonster().get(k));
			field.getMonster().set(k, null);
			tributeMonster1 = null;
			tributeMonster2 = null;
			field.getMonster().set(i, monsterCard);
			field.getMonster().get(i).setMode(mode);
			field.getMonster().get(i).setLocation("On Field");
			field.getMonster().get(i).setSwitchedMode(true);
			hand.removeCardFromHand(monsterCard);
		}
	}

	// Điều khiển tấn công
	public void attack(int index, int opponentIndex, Player opponent) {
		MonsterCard monsterCard = null;
		MonsterCard opponentMonsterCard = null;
		if (field.getMonster().get(index) != null) {
			monsterCard = field.getMonster().get(index);
		}
		if (field.getMonster().get(index) == null) {
			return;
		}
		if (opponentIndex == -1) {
			for (int i = 0; i < 5; i++) {
				if (opponent.getField().getMonster().get(i) != null) {
					SoundEffects.exceptionSound();
					JOptionPane.showMessageDialog(null, "Select opponent monster to attack!");
					return;
				}
			}
			if (monsterCard.getMode() == "ATTACK" && !monsterCard.isAttacked()) {
				monsterCard.setAttacked(true);
				SoundEffects.lifePointSound();
				opponent.lifepoints = opponent.lifepoints - monsterCard.getAttack();
			}
			return;
		}
		if (opponent.getField().getMonster().get(opponentIndex) != null) {
			opponentMonsterCard = opponent.getField().getMonster().get(opponentIndex);
		}
		if (opponent.getField().getMonster().get(opponentIndex) == null) {
			for (int i = 0; i < 5; i++) {
				if (opponent.getField().getMonster().get(i) != null) {
					SoundEffects.exceptionSound();
					JOptionPane.showMessageDialog(null, "Select opponent monster to attack!");
					return;
				}
			}
			if (monsterCard.getMode() == "ATTACK" && !monsterCard.isAttacked()) {
				monsterCard.setAttacked(true);
				SoundEffects.lifePointSound();
				opponent.lifepoints = opponent.lifepoints - monsterCard.getAttack();
			}
			return;
		}
		if (monsterCard.getMode() == "ATTACK" && opponentMonsterCard.getMode() == "ATTACK") {
			monsterCard.setAttacked(true);
			if (monsterCard.getAttack() > opponentMonsterCard.getAttack()) {
				opponent.field.getMonster().set(opponentIndex, null);
				opponent.field.addToGraveyard(opponentMonsterCard);
				opponent.lifepoints = opponent.lifepoints - (monsterCard.getAttack() - opponentMonsterCard.getAttack());
				SoundEffects.cardDestroySound();
			}
			if (monsterCard.getAttack() < opponentMonsterCard.getAttack()) {
				this.field.getMonster().set(index, null);
				this.field.addToGraveyard(monsterCard);
				this.lifepoints = this.lifepoints - (opponentMonsterCard.getAttack() - monsterCard.getAttack());
				SoundEffects.cardDestroySound();
			}
			if (monsterCard.getAttack() == opponentMonsterCard.getAttack()) {
				opponent.field.getMonster().set(opponentIndex, null);
				opponent.field.addToGraveyard(opponentMonsterCard);
				this.field.getMonster().set(index, null);
				this.field.addToGraveyard(monsterCard);
				SoundEffects.cardDestroySound();
			}
		}
		if (monsterCard.getMode() == "ATTACK" && opponentMonsterCard.getMode() == "DEFENSE") {
			monsterCard.setAttacked(true);
			if (monsterCard.getAttack() > opponentMonsterCard.getDefence()) {
				opponent.field.getMonster().set(opponentIndex, null);
				opponent.field.addToGraveyard(opponentMonsterCard);
				SoundEffects.cardDestroySound();
			}
			if (monsterCard.getAttack() < opponentMonsterCard.getDefence()) {
				this.lifepoints = this.lifepoints - (opponentMonsterCard.getDefence() - monsterCard.getAttack());
				SoundEffects.swordHitSound();
			}
			if (monsterCard.getAttack() == opponentMonsterCard.getDefence()) {
				SoundEffects.swordHitSound();
			}
		}

	}

	// Đổi dạng tấn công / phòng thủ
	public void switchMonsterMode(MonsterCard monsterCard) {
		if (monsterCard.getMode() == "ATTACK" && !monsterCard.getSwitchedMode() && !monsterCard.isAttacked()) {
			monsterCard.setMode("DEFENSE");
			monsterCard.setSwitchedMode(true);
		}
		if (monsterCard.getMode() == "DEFENSE" && !monsterCard.getSwitchedMode() && !monsterCard.isAttacked()) {
			monsterCard.setMode("ATTACK");
			monsterCard.setSwitchedMode(true);
		}
	}

	// Úp bài phép
	public void setSpellFaceDown(SpellCard spellCard, int index) {
		field.getSpellTrap().set(index, spellCard);
		field.getSpellTrap().get(index).setLocation("On Field");
		field.getSpellTrap().get(index).setFaceDown(true);
		hand.removeCardFromHand(spellCard);
	}

	// Sử dụng bài phép
	public void activateSpell(SpellCard spellCard, int index, Card targetCard, Player targetPlayer) {
		spellCard.getEffect();
		field.getSpellTrap().set(index, spellCard);
		field.getSpellTrap().get(index).setLocation("On Field");
		field.getSpellTrap().get(index).setFaceDown(false);
		hand.removeCardFromHand(spellCard);
	}

	// Úp bài bẫy
	public void setTrapFaceDown(TrapCard trapCard, int index) {
		field.getSpellTrap().set(index, trapCard);
		field.getSpellTrap().get(index).setLocation("On Field");
		field.getSpellTrap().get(index).setFaceDown(true);
		hand.removeCardFromHand(trapCard);
	}

	// Sử dụng bài bẫy
	public void activateTrap(TrapCard trapCard, int index, Card targetCard, Player targetPlayer) {
		trapCard.getEffect();
		field.getSpellTrap().set(index, trapCard);
		field.getSpellTrap().get(index).setLocation("On Field");
		field.getSpellTrap().get(index).setFaceDown(false);
		hand.removeCardFromHand(trapCard);
	}

	// Sử dụng bài môi trường
	public void setField(FieldCard fieldCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			if (field.getField() != null) {
				field.addToGraveyard(field.getField());
			}
			fieldCard.setLocation("On Field");
			field.setField(fieldCard);
			hand.removeCardFromHand(fieldCard);
		}
	}

	// Rút bài
	public void drawCard() {
		if (hand.getCardsInHand().size() < 10) {
			Card card = deck.drawOneCard();
			card.setLocation("On Hand");
			card.setFaceDown(false);
			hand.addCardToHand(card);
		}
	}

	// Kết thúc giai đoạn
	public void endPhase(String phase) {
		if (phase == "DRAW") {
			if (isDrawed) {
				this.getField().setPhase("STANDBY");
			} else {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot end phase when not drawing cards!");
			}
		} else if (phase == "STANDBY") {
			this.getField().setPhase("MAIN 1");
			SoundEffects.nextPhaseSound();
		} else if (phase == "MAIN 1") {
			this.getField().setPhase("BATTLE");
			SoundEffects.nextPhaseSound();
		} else if (phase == "BATTLE") {
			this.getField().setPhase("MAIN 2");
			SoundEffects.nextPhaseSound();
		} else if (phase == "MAIN 2") {
			this.getField().setPhase("DRAW");
		}
		selectedCard = null;
		selectedOpponentCard = null;
		tributeMonster1 = null;
		tributeMonster2 = null;
		for (int i = 0; i < 5; i++) {
			if (field.getMonster().get(i) != null) {
				field.getMonster().get(i).setSwitchedMode(false);
			}
		}
	}

	// Đếm số thẻ trong một array list
	public int monsterCardCount(ArrayList<MonsterCard> monsterCards) {
		int number = 0;
		for (MonsterCard c : monsterCards) {
			if (c != null)
				number++;
		}
		return number;
	}
}
