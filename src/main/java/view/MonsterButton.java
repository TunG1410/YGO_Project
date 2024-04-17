package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.MonsterCard;

public class MonsterButton extends JButton {

	private MonsterCard monsterCard;

	public MonsterButton() {
	}

	public MonsterButton(ImageIcon imageIcon, MonsterCard addedMonsterCard) {
		this.setIcon(imageIcon);
		this.monsterCard = addedMonsterCard;
	}

}
