package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.SpellCard;
import model.TrapCard;

public class SpellTrapButton extends JButton {

	private SpellCard spellCard;
	private TrapCard trapCard;

	public SpellTrapButton() {
	}

	public SpellTrapButton(ImageIcon imageIcon, SpellCard addedSpellCard) {
		this.setIcon(imageIcon);
		this.spellCard = addedSpellCard;
	}
	
	public SpellTrapButton(ImageIcon imageIcon, TrapCard addedTrapCard) {
		this.setIcon(imageIcon);
		this.trapCard = addedTrapCard;
	}
}
