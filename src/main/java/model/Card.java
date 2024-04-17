package model;

import javax.swing.ImageIcon;

abstract public class Card {
	private String owner;
	private String name;
	private String type;
	private String location;
	private Boolean faceDown;

	public Card() {
		faceDown = true;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getFaceDown() {
		return faceDown;
	}

	public void setFaceDown(Boolean faceDown) {
		this.faceDown = faceDown;
	}

	public ImageIcon getImageSmall() {
		return new ImageIcon(this.getClass().getResource("/view/resources/" + name + " Small.jpg"));
	}

	public ImageIcon getImageMedium() {
		return new ImageIcon(this.getClass().getResource("/view/resources/" + name + " Medium.jpg"));
	}

	public ImageIcon getImageLarge() {
		return new ImageIcon(this.getClass().getResource("/view/resources/" + name + " Large.jpg"));
	}
}