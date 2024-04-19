package view;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BattlePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;

	public BattlePanel() {
		this.init();
	}

	private void init() {
		setLayout(null);
		this.setSize(720, 490);

		JLabel deckLabel_1 = new JLabel("");
		deckLabel_1.setOpaque(true);
		deckLabel_1.setBackground(new Color(0, 0, 0, 100));
		deckLabel_1.setBounds(640, 380, 70, 100);
		add(deckLabel_1);

		JLabel deckLabel_2 = new JLabel("");
		deckLabel_2.setBackground(new Color(0, 0, 0, 100));
		deckLabel_2.setOpaque(true);
		deckLabel_2.setBounds(10, 10, 70, 100);
		add(deckLabel_2);

		JLabel greaveyardLabel_1 = new JLabel("");
		greaveyardLabel_1.setOpaque(true);
		greaveyardLabel_1.setBackground(new Color(0, 0, 0, 100));
		greaveyardLabel_1.setBounds(640, 270, 70, 100);
		add(greaveyardLabel_1);

		JLabel greaveyardLabel_2 = new JLabel("");
		greaveyardLabel_2.setOpaque(true);
		greaveyardLabel_2.setBackground(new Color(0, 0, 0, 100));
		greaveyardLabel_2.setBounds(10, 120, 70, 100);
		add(greaveyardLabel_2);

		JLabel fieldLabel_1 = new JLabel("");
		fieldLabel_1.setOpaque(true);
		fieldLabel_1.setBackground(new Color(0, 0, 0, 100));
		fieldLabel_1.setBounds(10, 270, 70, 100);
		add(fieldLabel_1);

		JLabel fieldLabel_2 = new JLabel("");
		fieldLabel_2.setOpaque(true);
		fieldLabel_2.setBackground(new Color(0, 0, 0, 100));
		fieldLabel_2.setBounds(640, 120, 70, 100);
		add(fieldLabel_2);
		
		JLabel extraDeckLabel_1 = new JLabel("");
		extraDeckLabel_1.setOpaque(true);
		extraDeckLabel_1.setBackground(new Color(0, 0, 0, 100));
		extraDeckLabel_1.setBounds(10, 380, 70, 100);
		add(extraDeckLabel_1);

		JLabel extraDeckLabel_2 = new JLabel("");
		extraDeckLabel_2.setOpaque(true);
		extraDeckLabel_2.setBackground(new Color(0, 0, 0, 100));
		extraDeckLabel_2.setBounds(640, 10, 70, 100);
		add(extraDeckLabel_2);

		JLabel monsterAtkLabel_1_1 = new JLabel("");
		monsterAtkLabel_1_1.setOpaque(true);
		monsterAtkLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_1.setBounds(105, 270, 70, 100);
		add(monsterAtkLabel_1_1);

		JLabel monsterAtkLabel_1_2 = new JLabel("");
		monsterAtkLabel_1_2.setOpaque(true);
		monsterAtkLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_2.setBounds(215, 270, 70, 100);
		add(monsterAtkLabel_1_2);

		JLabel monsterAtkLabel_1_3 = new JLabel("");
		monsterAtkLabel_1_3.setOpaque(true);
		monsterAtkLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_3.setBounds(325, 270, 70, 100);
		add(monsterAtkLabel_1_3);

		JLabel monsterAtkLabel_1_4 = new JLabel("");
		monsterAtkLabel_1_4.setOpaque(true);
		monsterAtkLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_4.setBounds(435, 270, 70, 100);
		add(monsterAtkLabel_1_4);

		JLabel monsterAtkLabel_1_5 = new JLabel("");
		monsterAtkLabel_1_5.setOpaque(true);
		monsterAtkLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_1_5.setBounds(545, 270, 70, 100);
		add(monsterAtkLabel_1_5);

		JLabel monsterAtkLabel_2_1 = new JLabel("");
		monsterAtkLabel_2_1.setOpaque(true);
		monsterAtkLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_1.setBounds(545, 120, 70, 100);
		add(monsterAtkLabel_2_1);

		JLabel monsterAtkLabel_2_2 = new JLabel("");
		monsterAtkLabel_2_2.setOpaque(true);
		monsterAtkLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_2.setBounds(435, 120, 70, 100);
		add(monsterAtkLabel_2_2);

		JLabel monsterAtkLabel_2_3 = new JLabel("");
		monsterAtkLabel_2_3.setOpaque(true);
		monsterAtkLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_3.setBounds(325, 120, 70, 100);
		add(monsterAtkLabel_2_3);

		JLabel monsterAtkLabel_2_4 = new JLabel("");
		monsterAtkLabel_2_4.setOpaque(true);
		monsterAtkLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_4.setBounds(215, 120, 70, 100);
		add(monsterAtkLabel_2_4);

		JLabel monsterAtkLabel_2_5 = new JLabel("");
		monsterAtkLabel_2_5.setOpaque(true);
		monsterAtkLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		monsterAtkLabel_2_5.setBounds(105, 120, 70, 100);
		add(monsterAtkLabel_2_5);

		JLabel monsterDefLabel_1_1 = new JLabel("");
		monsterDefLabel_1_1.setOpaque(true);
		monsterDefLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_1.setBounds(90, 285, 100, 70);
		add(monsterDefLabel_1_1);

		JLabel monsterDefLabel_1_2 = new JLabel("");
		monsterDefLabel_1_2.setOpaque(true);
		monsterDefLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_2.setBounds(200, 285, 100, 70);
		add(monsterDefLabel_1_2);

		JLabel monsterDefLabel_1_3 = new JLabel("");
		monsterDefLabel_1_3.setOpaque(true);
		monsterDefLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_3.setBounds(310, 285, 100, 70);
		add(monsterDefLabel_1_3);

		JLabel monsterDefLabel_1_4 = new JLabel("");
		monsterDefLabel_1_4.setOpaque(true);
		monsterDefLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_4.setBounds(420, 285, 100, 70);
		add(monsterDefLabel_1_4);

		JLabel monsterDefLabel_1_5 = new JLabel("");
		monsterDefLabel_1_5.setOpaque(true);
		monsterDefLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_1_5.setBounds(530, 285, 100, 70);
		add(monsterDefLabel_1_5);

		JLabel monsterDefLabel_2_1 = new JLabel("");
		monsterDefLabel_2_1.setOpaque(true);
		monsterDefLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_1.setBounds(530, 135, 100, 70);
		add(monsterDefLabel_2_1);

		JLabel monsterDefLabel_2_2 = new JLabel("");
		monsterDefLabel_2_2.setOpaque(true);
		monsterDefLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_2.setBounds(420, 135, 100, 70);
		add(monsterDefLabel_2_2);

		JLabel monsterDefLabel_2_3 = new JLabel("");
		monsterDefLabel_2_3.setOpaque(true);
		monsterDefLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_3.setBounds(310, 135, 100, 70);
		add(monsterDefLabel_2_3);

		JLabel monsterDefLabel_2_4 = new JLabel("");
		monsterDefLabel_2_4.setOpaque(true);
		monsterDefLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_4.setBounds(200, 135, 100, 70);
		add(monsterDefLabel_2_4);

		JLabel monsterDefLabel_2_5 = new JLabel("");
		monsterDefLabel_2_5.setOpaque(true);
		monsterDefLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		monsterDefLabel_2_5.setBounds(90, 135, 100, 70);
		add(monsterDefLabel_2_5);

		JLabel spellTrapLabel_1_1 = new JLabel("");
		spellTrapLabel_1_1.setOpaque(true);
		spellTrapLabel_1_1.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_1.setBounds(105, 380, 70, 100);
		add(spellTrapLabel_1_1);

		JLabel spellTrapLabel_1_2 = new JLabel("");
		spellTrapLabel_1_2.setOpaque(true);
		spellTrapLabel_1_2.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_2.setBounds(215, 380, 70, 100);
		add(spellTrapLabel_1_2);

		JLabel spellTrapLabel_1_3 = new JLabel("");
		spellTrapLabel_1_3.setOpaque(true);
		spellTrapLabel_1_3.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_3.setBounds(325, 380, 70, 100);
		add(spellTrapLabel_1_3);

		JLabel spellTrapLabel_1_4 = new JLabel("");
		spellTrapLabel_1_4.setOpaque(true);
		spellTrapLabel_1_4.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_4.setBounds(435, 380, 70, 100);
		add(spellTrapLabel_1_4);

		JLabel spellTrapLabel_1_5 = new JLabel("");
		spellTrapLabel_1_5.setOpaque(true);
		spellTrapLabel_1_5.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_1_5.setBounds(545, 380, 70, 100);
		add(spellTrapLabel_1_5);

		JLabel spellTrapLabel_2_1 = new JLabel("");
		spellTrapLabel_2_1.setOpaque(true);
		spellTrapLabel_2_1.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_1.setBounds(545, 10, 70, 100);
		add(spellTrapLabel_2_1);

		JLabel spellTrapLabel_2_2 = new JLabel("");
		spellTrapLabel_2_2.setOpaque(true);
		spellTrapLabel_2_2.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_2.setBounds(435, 10, 70, 100);
		add(spellTrapLabel_2_2);

		JLabel spellTrapLabel_2_3 = new JLabel("");
		spellTrapLabel_2_3.setOpaque(true);
		spellTrapLabel_2_3.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_3.setBounds(325, 10, 70, 100);
		add(spellTrapLabel_2_3);

		JLabel spellTrapLabel_2_4 = new JLabel("");
		spellTrapLabel_2_4.setOpaque(true);
		spellTrapLabel_2_4.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_4.setBounds(215, 10, 70, 100);
		add(spellTrapLabel_2_4);

		JLabel spellTrapLabel_2_5 = new JLabel("");
		spellTrapLabel_2_5.setOpaque(true);
		spellTrapLabel_2_5.setBackground(new Color(0, 0, 0, 100));
		spellTrapLabel_2_5.setBounds(105, 10, 70, 100);
		add(spellTrapLabel_2_5);
		
		JLabel separatingLineLabel = new JLabel("");
		separatingLineLabel.setBackground(new Color(255, 0, 0));
		separatingLineLabel.setOpaque(true);
		separatingLineLabel.setBounds(10, 240, 700, 10);
		add(separatingLineLabel);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(BattlePanel.class.getResource("/view/resources/Battle Background.jpg")));
		backgroundLabel.setBounds(10, 10, 700, 460);
		this.add(backgroundLabel);

	}

	public void setBattleBackground(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

}
