package model;

public class TrapCard extends Card {
	private String effect;

	public TrapCard() {
	}

	public TrapCard(String name) {
		setName(name);
		setType("TrapCard");
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public void activateEffect() {
	}

}