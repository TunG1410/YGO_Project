package model;

public class TrapCard extends Card {
	private String effect;

	public TrapCard() {
	}

	public TrapCard(String name, String effect) {
		setName(name);
		setType("TrapCard");
		this.effect = effect;
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