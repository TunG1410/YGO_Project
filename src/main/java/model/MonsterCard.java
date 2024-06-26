package model;

public class MonsterCard extends Card {
	private int attack;
	private int defence;
	private int level;
	private String mode;
	private Boolean attacked;
	private Boolean switchedMode;

	public MonsterCard() {
	}

	public MonsterCard(String nm, int lvl, int atk, int def) {
		super();
		setName(nm);
		setType("MonsterCard");
		level = lvl;
		attack = atk;
		defence = def;
		switchedMode = true;
		mode = "ATTACK";
		attacked = false;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(Boolean haveAttacked) {
		this.attacked = haveAttacked;
	}

	public Boolean getSwitchedMode() {
		return switchedMode;
	}

	public void setSwitchedMode(Boolean switchedMode) {
		this.switchedMode = switchedMode;
	}
}