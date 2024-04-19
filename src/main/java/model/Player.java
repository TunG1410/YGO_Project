package model;

import javax.swing.JOptionPane;

public class Player {

	private String playerName;
	private int lifepoints;
	private Hand hand;
	private Deck deck;
	private Field field;
	private boolean normalSummoned = false;
	private boolean isDrawed = false;

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

	// Triệu hồi thông thường
	public void summonMonster(MonsterCard monsterCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			if (monsterCard.getLevel() > 4  && field.getMonster().size() < 5 && !this.normalSummoned) {
				field.setMonster(monsterCard);
				hand.removeCardFromHand(monsterCard);
				this.normalSummoned = true;
			}
			
		}
	}

	// Triệu hồi hiến tế (lv > 4)
	public void tributeSummon(MonsterCard monsterCard, MonsterCard tribute1, MonsterCard tribute2, String mode) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			if (monsterCard.getLevel() > 4 && field.getMonster().size() > 1) {
				field.removeMonster(tribute1);
				field.addToGraveyard(tribute1);
				field.removeMonster(tribute2);
				field.addToGraveyard(tribute2);
				field.setMonster(monsterCard);
				monsterCard.setMode(mode);
			}
		}
	}

	// Lật bài
	public void flipMonster(MonsterCard monsterCard) {
		if (monsterCard.getFaceDown()) {
			monsterCard.setFaceDown(false);
		} else {
			monsterCard.setFaceDown(true);
		}
	}

	// Điều khiển tấn công
	public void attack(MonsterCard monsterCard, MonsterCard opponentMonsterCard, Player opponent) {
		if (monsterCard.getHaveAttacked()) {
			JOptionPane.showMessageDialog(null, "Monster cannot attack twice in a turn");
//			throw new AlreadyAttackedException("Monster cannot attack twice in a turn");
		}
		if (field.getPhase() == "BATTLE" && monsterCard.getMode() == "DEFENSE") {
			JOptionPane.showMessageDialog(null, "Monster cannot attack if in defense position");
//			throw new DefenseModeException("Monster cannot attack if in defense position");
		}
		if (field.getPhase() != "BATTLE") {
			JOptionPane.showMessageDialog(null, "Monster cannot attack if not in battle phase");
//			throw new WrongPhaseException("Monster cannot attack if not in battle phase");
		}
		if (field.getPhase() == "BATTLE" && monsterCard.getMode() == "ATTACK"
				&& opponentMonsterCard.getMode() == "ATTACK" && !monsterCard.getHaveAttacked()) {
			monsterCard.setHaveAttacked(true);
			if (monsterCard.getAttack() >= opponentMonsterCard.getAttack()) {
				opponent.field.removeMonster(opponentMonsterCard);
				opponent.field.addToGraveyard(opponentMonsterCard);
				opponent.lifepoints = opponent.lifepoints - (monsterCard.getAttack() - opponentMonsterCard.getAttack());
			}
			if (monsterCard.getAttack() < opponentMonsterCard.getAttack()) {
				field.removeMonster(monsterCard);
				field.addToGraveyard(monsterCard);
				this.lifepoints = this.lifepoints - (opponentMonsterCard.getAttack() - monsterCard.getAttack());
			}
		}
		if (field.getPhase() == "BATTLE" && monsterCard.getMode() == "ATTACK"
				&& opponentMonsterCard.getMode() == "DEFENSE" && !monsterCard.getHaveAttacked()) {
			monsterCard.setHaveAttacked(true);
			if (monsterCard.getAttack() >= opponentMonsterCard.getDefence()) {
				opponent.field.removeMonster(opponentMonsterCard);
				opponent.field.addToGraveyard(opponentMonsterCard);
			}
			if (monsterCard.getAttack() >= opponentMonsterCard.getDefence()) {
				this.lifepoints = this.lifepoints - (opponentMonsterCard.getDefence() - monsterCard.getAttack());
			}
		}
		if (field.getPhase() == "BATTLE PHASE" && monsterCard.getMode() == "ATTACK"
				&& opponent.field.getMonster().size() <= 0 && !monsterCard.getHaveAttacked()) {
			monsterCard.setHaveAttacked(true);
			opponent.lifepoints = opponent.lifepoints - monsterCard.getAttack();
		}

	}

	// Đổi dạng tấn công / phòng thủ
	public boolean switchMonsterMode(MonsterCard monsterCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			if (monsterCard.getMode() == "ATTACK" && !monsterCard.getSwitchedMode()) {
				monsterCard.setMode("DEFENSE");
				monsterCard.setSwitchedMode(true);
			}
			if (monsterCard.getMode() == "DEFENSE" && !monsterCard.getSwitchedMode()) {
				monsterCard.setMode("ATTACK");
				monsterCard.setSwitchedMode(true);
			}
			return true;
		}
		return false;
	}

	public void setSpell(SpellCard spellCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2"
				|| field.getPhase() == "BATTLE PHASE") {
			field.setEffect(spellCard);
			hand.removeCardFromHand(spellCard);
		}
	}

	public void activateSpell(SpellCard spellCard, Card targetCard, Player targetPlayer) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2"
				|| field.getPhase() == "BATTLE PHASE") {
			if (!spellCard.getFaceDown()) {
				spellCard.getEffect();
				field.addToGraveyard(spellCard);
			}
		}
	}

	public void setTrap(TrapCard trapCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			field.setEffect(trapCard);
			hand.removeCardFromHand(trapCard);
		}
	}

	public void activateTrap(TrapCard trapCard, Card targetCard, Player targetPlayer) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2"
				|| field.getPhase() == "BATTLE PHASE") {
			if (!trapCard.getFaceDown()) {
				trapCard.getEffect();
				field.addToGraveyard(trapCard);
			}
		}
	}

	public void setField(FieldCard fieldCard) {
		if (field.getPhase() == "MAIN 1" || field.getPhase() == "MAIN 2") {
			if (field.getField() != null) {
				field.addToGraveyard(fieldCard);
			}
			field.setField(fieldCard);
			hand.removeCardFromHand(fieldCard);
		}
	}

	public Card drawCard() {
		Card card = deck.drawOneCard();
		hand.addCardToHand(card);
		return card;
	}

	public void endPhase(String phase) {
		if (phase == "DRAW") {
			this.getField().setPhase("STANDBY");
		} else if (phase == "STANDBY") {
			this.getField().setPhase("MAIN 1");
		} else if (phase == "MAIN 1") {
			this.getField().setPhase("BATTLE");
		} else if (phase == "BATTLE") {
			this.getField().setPhase("MAIN 2");
		}
	}

	public void endTurn() {
		this.normalSummoned = false;
		this.isDrawed = false;
		this.getField().setPhase("DRAW PHASE");
		for (int i = 0; i < this.field.getMonster().size(); i++) {
			this.field.getMonster().get(i).setHaveAttacked(false);
			this.field.getMonster().get(i).setSwitchedMode(false);
		}
	}
}
