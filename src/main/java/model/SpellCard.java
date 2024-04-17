package model;

public class SpellCard extends Card {
	private String effect;

	public SpellCard() {
	}

	public SpellCard(String name, String effect) {
		setName(name);
		setType("SpellCard");
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