package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import model.Card;
import model.Deck;
import model.MonsterCard;
import model.SpellCard;
import view.GUI;

public class Test {
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GUI();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
//		MonsterCard c1 = new MonsterCard("tttt", 4, 1000, 2000);
//		MonsterCard c2 = new MonsterCard("tttt", 4, 3000, 4000);
//		SpellCard s1 = new SpellCard("spell 1", "buff");
//
//		Deck d = new Deck();
//		d.addCardToDeck(c1);
//		d.addCardToDeck(c2);
//		d.addCardToDeck(s1);
//
//		Card t = d.drawOneCard();
//		MonsterCard t1 = null;
//		SpellCard t2 = null;
//		if (t.getType() == "MonsterCard") {
//			t1 = (MonsterCard) t;
//			System.out.println(t1.getAttack() + " " + t1.getDefence());
//		}
//		if (t.getType() == "SpellCard") {
//			t2 = (SpellCard) t;
//			System.out.println("" + t2.getEffect());
//		}

	}

}
