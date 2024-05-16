package view;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import model.Card;
import model.FieldCard;
import model.RotateIcon;

import java.awt.Color;

import javax.swing.JLabel;

public class BattlePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel bgPlayerLabel_1;
	private JLabel bgPlayerLabel_2;

	public BattlePanel() {
		this.init();
	}

	private void init() {
		setLayout(null);
		this.setSize(730, 500);
		this.setBackground(new Color(0, 0, 0, 0));

		JLabel deckLabel_1 = new JLabel("");
		deckLabel_1.setOpaque(true);
		deckLabel_1.setBackground(new Color(0, 0, 0, 100));
		deckLabel_1.setBounds(645, 385, 70, 100);
		add(deckLabel_1);

		JLabel deckLabel_2 = new JLabel("");
		deckLabel_2.setBackground(new Color(0, 0, 0, 100));
		deckLabel_2.setOpaque(true);
		deckLabel_2.setBounds(15, 15, 70, 100);
		add(deckLabel_2);

		JLabel greaveyardLabel_1 = new JLabel("");
		greaveyardLabel_1.setOpaque(true);
		greaveyardLabel_1.setBackground(new Color(0, 0, 0, 100));
		greaveyardLabel_1.setBounds(645, 275, 70, 100);
		add(greaveyardLabel_1);

		JLabel greaveyardLabel_2 = new JLabel("");
		greaveyardLabel_2.setOpaque(true);
		greaveyardLabel_2.setBackground(new Color(0, 0, 0, 100));
		greaveyardLabel_2.setBounds(15, 125, 70, 100);
		add(greaveyardLabel_2);

		JLabel fieldLabel_1 = new JLabel("");
		fieldLabel_1.setOpaque(true);
		fieldLabel_1.setBackground(new Color(0, 0, 0, 100));
		fieldLabel_1.setBounds(15, 275, 70, 100);
		add(fieldLabel_1);

		JLabel fieldLabel_2 = new JLabel("");
		fieldLabel_2.setOpaque(true);
		fieldLabel_2.setBackground(new Color(0, 0, 0, 100));
		fieldLabel_2.setBounds(645, 125, 70, 100);
		add(fieldLabel_2);
		
		JLabel extraDeckLabel_1 = new JLabel("");
		extraDeckLabel_1.setOpaque(true);
		extraDeckLabel_1.setBackground(new Color(0, 0, 0, 100));
		extraDeckLabel_1.setBounds(15, 385, 70, 100);
		add(extraDeckLabel_1);

		JLabel extraDeckLabel_2 = new JLabel("");
		extraDeckLabel_2.setOpaque(true);
		extraDeckLabel_2.setBackground(new Color(0, 0, 0, 100));
		extraDeckLabel_2.setBounds(645, 15, 70, 100);
		add(extraDeckLabel_2);

		JLabel monsterAtkLabel_1_1 = new JLabel("");
		monsterAtkLabel_1_1.setOpaque(true);
		monsterAtkLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_1.setBounds(110, 275, 70, 100);
		add(monsterAtkLabel_1_1);

		JLabel monsterAtkLabel_1_2 = new JLabel("");
		monsterAtkLabel_1_2.setOpaque(true);
		monsterAtkLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_2.setBounds(220, 275, 70, 100);
		add(monsterAtkLabel_1_2);

		JLabel monsterAtkLabel_1_3 = new JLabel("");
		monsterAtkLabel_1_3.setOpaque(true);
		monsterAtkLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_3.setBounds(330, 275, 70, 100);
		add(monsterAtkLabel_1_3);

		JLabel monsterAtkLabel_1_4 = new JLabel("");
		monsterAtkLabel_1_4.setOpaque(true);
		monsterAtkLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_4.setBounds(440, 275, 70, 100);
		add(monsterAtkLabel_1_4);

		JLabel monsterAtkLabel_1_5 = new JLabel("");
		monsterAtkLabel_1_5.setOpaque(true);
		monsterAtkLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_5.setBounds(550, 275, 70, 100);
		add(monsterAtkLabel_1_5);

		JLabel monsterAtkLabel_2_1 = new JLabel("");
		monsterAtkLabel_2_1.setOpaque(true);
		monsterAtkLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_1.setBounds(550, 125, 70, 100);
		add(monsterAtkLabel_2_1);

		JLabel monsterAtkLabel_2_2 = new JLabel("");
		monsterAtkLabel_2_2.setOpaque(true);
		monsterAtkLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_2.setBounds(440, 125, 70, 100);
		add(monsterAtkLabel_2_2);

		JLabel monsterAtkLabel_2_3 = new JLabel("");
		monsterAtkLabel_2_3.setOpaque(true);
		monsterAtkLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_3.setBounds(330, 125, 70, 100);
		add(monsterAtkLabel_2_3);

		JLabel monsterAtkLabel_2_4 = new JLabel("");
		monsterAtkLabel_2_4.setOpaque(true);
		monsterAtkLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_4.setBounds(220, 125, 70, 100);
		add(monsterAtkLabel_2_4);

		JLabel monsterAtkLabel_2_5 = new JLabel("");
		monsterAtkLabel_2_5.setOpaque(true);
		monsterAtkLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_5.setBounds(110, 125, 70, 100);
		add(monsterAtkLabel_2_5);

		JLabel monsterDefLabel_1_1 = new JLabel("");
		monsterDefLabel_1_1.setOpaque(true);
		monsterDefLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_1.setBounds(95, 290, 100, 70);
		add(monsterDefLabel_1_1);

		JLabel monsterDefLabel_1_2 = new JLabel("");
		monsterDefLabel_1_2.setOpaque(true);
		monsterDefLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_2.setBounds(205, 290, 100, 70);
		add(monsterDefLabel_1_2);

		JLabel monsterDefLabel_1_3 = new JLabel("");
		monsterDefLabel_1_3.setOpaque(true);
		monsterDefLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_3.setBounds(315, 290, 100, 70);
		add(monsterDefLabel_1_3);

		JLabel monsterDefLabel_1_4 = new JLabel("");
		monsterDefLabel_1_4.setOpaque(true);
		monsterDefLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_4.setBounds(425, 290, 100, 70);
		add(monsterDefLabel_1_4);

		JLabel monsterDefLabel_1_5 = new JLabel("");
		monsterDefLabel_1_5.setOpaque(true);
		monsterDefLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_5.setBounds(535, 290, 100, 70);
		add(monsterDefLabel_1_5);

		JLabel monsterDefLabel_2_1 = new JLabel("");
		monsterDefLabel_2_1.setOpaque(true);
		monsterDefLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_1.setBounds(535, 140, 100, 70);
		add(monsterDefLabel_2_1);

		JLabel monsterDefLabel_2_2 = new JLabel("");
		monsterDefLabel_2_2.setOpaque(true);
		monsterDefLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_2.setBounds(425, 140, 100, 70);
		add(monsterDefLabel_2_2);

		JLabel monsterDefLabel_2_3 = new JLabel("");
		monsterDefLabel_2_3.setOpaque(true);
		monsterDefLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_3.setBounds(315, 140, 100, 70);
		add(monsterDefLabel_2_3);

		JLabel monsterDefLabel_2_4 = new JLabel("");
		monsterDefLabel_2_4.setOpaque(true);
		monsterDefLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_4.setBounds(205, 140, 100, 70);
		add(monsterDefLabel_2_4);

		JLabel monsterDefLabel_2_5 = new JLabel("");
		monsterDefLabel_2_5.setOpaque(true);
		monsterDefLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_5.setBounds(95, 140, 100, 70);
		add(monsterDefLabel_2_5);

		JLabel spellTrapLabel_1_1 = new JLabel("");
		spellTrapLabel_1_1.setOpaque(true);
		spellTrapLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_1.setBounds(110, 385, 70, 100);
		add(spellTrapLabel_1_1);

		JLabel spellTrapLabel_1_2 = new JLabel("");
		spellTrapLabel_1_2.setOpaque(true);
		spellTrapLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_2.setBounds(220, 385, 70, 100);
		add(spellTrapLabel_1_2);

		JLabel spellTrapLabel_1_3 = new JLabel("");
		spellTrapLabel_1_3.setOpaque(true);
		spellTrapLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_3.setBounds(330, 385, 70, 100);
		add(spellTrapLabel_1_3);

		JLabel spellTrapLabel_1_4 = new JLabel("");
		spellTrapLabel_1_4.setOpaque(true);
		spellTrapLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_4.setBounds(440, 385, 70, 100);
		add(spellTrapLabel_1_4);

		JLabel spellTrapLabel_1_5 = new JLabel("");
		spellTrapLabel_1_5.setOpaque(true);
		spellTrapLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_5.setBounds(550, 385, 70, 100);
		add(spellTrapLabel_1_5);

		JLabel spellTrapLabel_2_1 = new JLabel("");
		spellTrapLabel_2_1.setOpaque(true);
		spellTrapLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_1.setBounds(550, 15, 70, 100);
		add(spellTrapLabel_2_1);

		JLabel spellTrapLabel_2_2 = new JLabel("");
		spellTrapLabel_2_2.setOpaque(true);
		spellTrapLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_2.setBounds(440, 15, 70, 100);
		add(spellTrapLabel_2_2);

		JLabel spellTrapLabel_2_3 = new JLabel("");
		spellTrapLabel_2_3.setOpaque(true);
		spellTrapLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_3.setBounds(330, 15, 70, 100);
		add(spellTrapLabel_2_3);

		JLabel spellTrapLabel_2_4 = new JLabel("");
		spellTrapLabel_2_4.setOpaque(true);
		spellTrapLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_4.setBounds(220, 15, 70, 100);
		add(spellTrapLabel_2_4);

		JLabel spellTrapLabel_2_5 = new JLabel("");
		spellTrapLabel_2_5.setOpaque(true);
		spellTrapLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_5.setBounds(110, 15, 70, 100);
		add(spellTrapLabel_2_5);
		
		bgPlayerLabel_1 = new JLabel("");
		bgPlayerLabel_1.setBounds(5, 265, 720, 230);
		bgPlayerLabel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5),
				new LineBorder(new Color(0, 255, 255), 5)));
		bgPlayerLabel_1.setBackground(new Color(0, 0, 0, 0));
		bgPlayerLabel_1.setOpaque(true);
		add(bgPlayerLabel_1);
		
		bgPlayerLabel_2 = new JLabel("");
		bgPlayerLabel_2.setBounds(5, 5, 720, 230);
		bgPlayerLabel_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5),
				new LineBorder(new Color(0, 255, 255), 5)));
		bgPlayerLabel_1.setBackground(new Color(0, 0, 0, 0));
		bgPlayerLabel_1.setOpaque(true);
		add(bgPlayerLabel_2);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(10, 10, 700, 470);
		this.add(backgroundLabel);

	}

	public void setBgPlayerLabel_1(Card card) {
		FieldCard fieldCard = (FieldCard) card;
		bgPlayerLabel_1.setIcon(fieldCard.getFieldImage());
	}

	public void setBgPlayerLabel_2(Card card) {
		FieldCard fieldCard = (FieldCard) card;
		RotateIcon ri = new RotateIcon(fieldCard.getFieldImage(), RotateIcon.Rotate.UPSIDE_DOWN);
		bgPlayerLabel_2.setIcon(ri);
	}
	
	
}
