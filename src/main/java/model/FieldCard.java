package model;

public class FieldCard extends Card {
	private String effect;

	public FieldCard() {
	}

	public FieldCard(String name, String effect) {
		super();
		setName(name);
		setType("FieldCard");
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
