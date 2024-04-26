package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.Card;
import model.FieldCard;
import model.MonsterCard;
import model.SpellCard;
import model.TrapCard;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;

public class CardInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel infoCardLabel;
	private JLabel ATK_CardLabel;
	private JLabel DEF_CardLabel;
	private JTextArea effectCardTextArea;

	public CardInfoPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(Color.MAGENTA);
		this.setLayout(null);
		this.setSize(370, 585);

		infoCardLabel = new JLabel("");
		infoCardLabel.setBackground(new Color(128, 255, 255));
		infoCardLabel.setBounds(10, 15, 350, 510);
		infoCardLabel.setOpaque(true);
		add(infoCardLabel);

		ATK_CardLabel = new JLabel("ATK / 1000");
		ATK_CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ATK_CardLabel.setBackground(new Color(255, 0, 0));
		ATK_CardLabel.setBounds(10, 530, 170, 40);
		ATK_CardLabel.setOpaque(true);
		add(ATK_CardLabel);

		DEF_CardLabel = new JLabel("DEF / 1000");
		DEF_CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DEF_CardLabel.setBackground(new Color(255, 255, 0));
		DEF_CardLabel.setBounds(190, 530, 170, 40);
		DEF_CardLabel.setOpaque(true);
		add(DEF_CardLabel);

		effectCardTextArea = new JTextArea();
		effectCardTextArea.setFont(new Font("Courier New", Font.PLAIN, 20));
		effectCardTextArea.setEditable(false);
		effectCardTextArea.setEnabled(false);
		effectCardTextArea.setLineWrap(true);
		effectCardTextArea.setWrapStyleWord(true);
		effectCardTextArea.setBounds(10, 530, 350, 40);
		effectCardTextArea.setBackground(new Color(255, 255, 255));
		effectCardTextArea.setOpaque(true);
		effectCardTextArea.setDisabledTextColor(Color.RED);
		add(effectCardTextArea);
	}

	public void setIcon(ImageIcon imageIcon) {
		infoCardLabel.setIcon(imageIcon);
	}

	public void setInfo(Card card) {
		if (card.getType() == "MonsterCard") {
			MonsterCard monsterCard = (MonsterCard) card;
			ATK_CardLabel.setVisible(true);
			ATK_CardLabel.setText("ATK / " + monsterCard.getAttack());
			DEF_CardLabel.setVisible(true);
			DEF_CardLabel.setText("DEF / " + monsterCard.getDefence());
			effectCardTextArea.setVisible(false);
		}
		if (card.getType() == "SpellCard") {
			SpellCard spellCard = (SpellCard) card;
			ATK_CardLabel.setVisible(false);
			DEF_CardLabel.setVisible(false);
			effectCardTextArea.setVisible(true);
			effectCardTextArea.setText(spellCard.getEffect());
		}
		if (card.getType() == "TrapCard") {
			TrapCard trapCard = (TrapCard) card;
			ATK_CardLabel.setVisible(false);
			DEF_CardLabel.setVisible(false);
			effectCardTextArea.setVisible(true);
			effectCardTextArea.setText(trapCard.getEffect());
		}
		if (card.getType() == "FieldCard") {
			FieldCard fieldCard = (FieldCard) card;
			ATK_CardLabel.setVisible(false);
			DEF_CardLabel.setVisible(false);
			effectCardTextArea.setVisible(true);
			effectCardTextArea.setText(fieldCard.getEffect());
		}
	}
}
