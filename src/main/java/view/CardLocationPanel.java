package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.DrawCardListener;
import controller.SelectCardListener;
import controller.SelectFieldListener;
import controller.SelectOpponentFieldListener;
import controller.ShowCardInfoListener;
import controller.ShowOpponentCardInfoListener;
import model.Card;
import model.Player;
import model.RotateIcon;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

public class CardLocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player currentPlayer;
	private Player opponentPlayer;
	private List<JButton> handPlayer1;
	private List<JButton> handPlayer2;
	private List<JButton> monsterFieldButton1;
	private List<JButton> monsterFieldButton2;
	private List<JButton> spellTrapFieldButton1;
	private List<JButton> spellTrapFieldButton2;
	private JLayeredPane handPanelPlayer1;
	private JLayeredPane handPanelPlayer2;
	private GUI gui;
	private JButton selectedButton;
	private JButton selectedFieldButton;
	private JButton selectedOpponentButton;
	private JButton tributeMonsterButton1;
	private JButton tributeMonsterButton2;
	private JButton drawCardButton_1;
	private JButton drawCardButton_2;
	private JButton fieldButton_1;
	private JButton fieldButton_2;
	private JButton graveyardButton_1;
	private JButton graveyardButton_2;
	private ActionListener drawCardListener;
	private MouseListener showCardInfoListener;
	private MouseListener selectCardListener;
	private MouseListener selectFieldListener;
	private MouseListener selectOpponentFieldListener;
	private MouseListener showOpponentCardInfoListener;
	private Boolean enabled = true;

	public CardLocationPanel(GUI gui) {
		this.gui = gui;
		this.currentPlayer = gui.getNewGame().getCurrentPlayer();
		this.opponentPlayer = gui.getNewGame().getOpponentPlayer();
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(750, 850);
		setLayout(null);

		drawCardListener = new DrawCardListener(this);
		showCardInfoListener = new ShowCardInfoListener(gui);
		selectCardListener = new SelectCardListener(this);
		selectFieldListener = new SelectFieldListener(this, gui);
		selectOpponentFieldListener = new SelectOpponentFieldListener(this, gui);
		showOpponentCardInfoListener = new ShowOpponentCardInfoListener(gui);

		handPanelPlayer1 = new JLayeredPane();
		handPanelPlayer1.setBounds(0, 675, 750, 175);
		this.add(handPanelPlayer1);

		handPanelPlayer2 = new JLayeredPane();
		handPanelPlayer2.setBounds(0, 0, 750, 175);
		this.add(handPanelPlayer2);

		handPlayer1 = new ArrayList<JButton>(10);
		handPlayer2 = new ArrayList<JButton>(10);

		for (int i = 0; i < 10; i++) {
			JButton handBtn1 = new JButton("");
			handBtn1.setBounds(i * 70, 0, 120, 175);
			handBtn1.setFocusPainted(false);
			handBtn1.setVisible(false);
			handPanelPlayer1.add(handBtn1, Integer.valueOf(i));
			handPlayer1.add(handBtn1);
			JButton handBtn2 = new JButton("");
			handBtn2.setBounds(i * 70, 0, 120, 175);
			handBtn2.setFocusPainted(false);
			handBtn2.setVisible(false);
			handPanelPlayer2.add(handBtn2, Integer.valueOf(i));
			handPlayer2.add(handBtn2);
		}

		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setVisible(true);
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer1.get(i).addMouseListener(selectCardListener);
				handPlayer1.get(i).addMouseListener(showCardInfoListener);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setVisible(true);
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer2.get(i).addMouseListener(selectCardListener);
				handPlayer2.get(i).addMouseListener(showCardInfoListener);
			}
		}
		for (int i = 0; i < opponentPlayer.getHand().getCardsInHand().size(); i++) {
			if (opponentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setVisible(true);
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
			}
			if (opponentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setVisible(true);
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
			}
		}

		drawCardButton_1 = new JButton("35");
		drawCardButton_1.setBounds(655, 560, 70, 100);
		drawCardButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		drawCardButton_1.setForeground(new Color(255, 255, 0));
		drawCardButton_1.setFocusable(false);
		drawCardButton_1.setOpaque(false);
		drawCardButton_1.setContentAreaFilled(false);
		drawCardButton_1.addActionListener(drawCardListener);
		drawCardButton_1.addMouseListener(selectCardListener);
		add(drawCardButton_1);

		JLabel numberCardLabel_1 = new JLabel("");
		numberCardLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		numberCardLabel_1.setFocusable(false);
		numberCardLabel_1.setBounds(655, 560, 70, 100);
		numberCardLabel_1.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		numberCardLabel_1.setBorder(new LineBorder(Color.WHITE, 3));
		add(numberCardLabel_1);

		drawCardButton_2 = new JButton("35");
		drawCardButton_2.setBounds(25, 190, 70, 100);
		drawCardButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		drawCardButton_2.setForeground(new Color(255, 255, 0));
		drawCardButton_2.setFocusable(false);
		drawCardButton_2.setOpaque(false);
		drawCardButton_2.setContentAreaFilled(false);
		drawCardButton_2.addActionListener(drawCardListener);
		drawCardButton_2.addMouseListener(selectCardListener);
		add(drawCardButton_2);

		JLabel numberCardLabel_2 = new JLabel("");
		numberCardLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		numberCardLabel_2.setFocusable(false);
		numberCardLabel_2.setBounds(25, 190, 70, 100);
		numberCardLabel_2.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		numberCardLabel_2.setBorder(new LineBorder(Color.WHITE, 3));
		add(numberCardLabel_2);

		fieldButton_1 = new JButton("");
		fieldButton_1.setBounds(25, 450, 70, 100);
		fieldButton_1.setFocusable(false);
		fieldButton_1.setVisible(false);
		fieldButton_1.addMouseListener(selectCardListener);
		fieldButton_1.addMouseListener(showCardInfoListener);

		fieldButton_2 = new JButton("");
		fieldButton_2.setBounds(655, 300, 70, 100);
		fieldButton_2.setFocusable(false);
		fieldButton_2.setVisible(false);
		fieldButton_2.addMouseListener(selectCardListener);
		fieldButton_2.addMouseListener(showCardInfoListener);

		graveyardButton_1 = new JButton("");
		graveyardButton_1.setBounds(655, 450, 70, 100);
		graveyardButton_1.setFocusable(false);
		graveyardButton_1.setVisible(false);
		graveyardButton_1.addMouseListener(selectCardListener);
		graveyardButton_1.addMouseListener(showCardInfoListener);

		graveyardButton_2 = new JButton("");
		graveyardButton_2.setBounds(25, 300, 70, 100);
		graveyardButton_2.setFocusable(false);
		graveyardButton_2.setVisible(false);
		graveyardButton_2.addMouseListener(selectCardListener);
		graveyardButton_2.addMouseListener(showCardInfoListener);

		add(fieldButton_1);
		add(fieldButton_2);
		add(graveyardButton_1);
		add(graveyardButton_2);

		JLabel numberExtraDeckLbl_1 = new JLabel("0");
		numberExtraDeckLbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		numberExtraDeckLbl_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numberExtraDeckLbl_1.setBounds(25, 560, 70, 100);
		numberExtraDeckLbl_1.setForeground(Color.RED);
		add(numberExtraDeckLbl_1);

		JLabel extraDeckLabel_1 = new JLabel("");
		extraDeckLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		extraDeckLabel_1.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		extraDeckLabel_1.setBounds(25, 560, 70, 100);
		extraDeckLabel_1.setBorder(new LineBorder(Color.WHITE, 3));
		add(extraDeckLabel_1);

		JLabel numberExtraDeckLbl_2 = new JLabel("0");
		numberExtraDeckLbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		numberExtraDeckLbl_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numberExtraDeckLbl_2.setBounds(655, 190, 70, 100);
		numberExtraDeckLbl_2.setForeground(Color.RED);
		add(numberExtraDeckLbl_2);

		JLabel extraDeckLabel_2 = new JLabel("");
		extraDeckLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		extraDeckLabel_2.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		extraDeckLabel_2.setBounds(655, 190, 70, 100);
		extraDeckLabel_2.setBorder(new LineBorder(Color.WHITE, 3));
		add(extraDeckLabel_2);

		monsterFieldButton1 = new ArrayList<JButton>(5);
		monsterFieldButton2 = new ArrayList<JButton>(5);

		for (int i = 0; i < 5; i++) {
			JButton button1 = new JButton("");
			button1.setBounds(120 + i * 110, 450, 70, 100);
			button1.setFocusable(false);
			button1.setContentAreaFilled(false);
			JButton button2 = new JButton("");
			button2.setBounds(120 + i * 110, 300, 70, 100);
			button2.setFocusable(false);
			button2.setContentAreaFilled(false);
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				button1.addMouseListener(selectFieldListener);
				button2.addMouseListener(selectOpponentFieldListener);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				button2.addMouseListener(selectFieldListener);
				button1.addMouseListener(selectOpponentFieldListener);
			}
			this.add(button1);
			button1.addMouseListener(showCardInfoListener);
			monsterFieldButton1.add(button1);
			this.add(button2);
			button2.addMouseListener(showCardInfoListener);
			monsterFieldButton2.add(button2);
		}

		spellTrapFieldButton1 = new ArrayList<JButton>(5);
		spellTrapFieldButton2 = new ArrayList<JButton>(5);

		for (int i = 0; i < 5; i++) {
			JButton button1 = new JButton("");
			button1.setBounds(120 + i * 110, 560, 70, 100);
			button1.setFocusable(false);
			button1.setContentAreaFilled(false);
			JButton button2 = new JButton("");
			button2.setBounds(120 + i * 110, 190, 70, 100);
			button2.setFocusable(false);
			button2.setContentAreaFilled(false);
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				button1.addMouseListener(selectFieldListener);
				button2.addMouseListener(selectOpponentFieldListener);
				button1.addMouseListener(showCardInfoListener);
				button2.addMouseListener(showOpponentCardInfoListener);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				button1.addMouseListener(selectOpponentFieldListener);
				button2.addMouseListener(selectFieldListener);
				button1.addMouseListener(showOpponentCardInfoListener);
				button2.addMouseListener(showCardInfoListener);
			}
			spellTrapFieldButton1.add(button1);
			button1.addMouseListener(showCardInfoListener);
			this.add(button1);
			button2.addMouseListener(showCardInfoListener);
			spellTrapFieldButton2.add(button2);
			this.add(button2);
		}

	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}

	public List<JButton> getMonsterFieldButton1() {
		return monsterFieldButton1;
	}

	public List<JButton> getMonsterFieldButton2() {
		return monsterFieldButton2;
	}

	public List<JButton> getSpellTrapFieldButton1() {
		return spellTrapFieldButton1;
	}

	public List<JButton> getSpellTrapFieldButton2() {
		return spellTrapFieldButton2;
	}

	public void setFieldButton_1(ImageIcon imageIcon) {
		fieldButton_1.setIcon(imageIcon);
		fieldButton_1.setVisible(true);
	}

	public void setFieldButton_2(ImageIcon imageIcon) {
		RotateIcon ri = new RotateIcon(imageIcon, RotateIcon.Rotate.UPSIDE_DOWN);
		fieldButton_2.setIcon(ri);
		fieldButton_2.setVisible(true);
	}

	public void setGraveyardButton_1(ImageIcon imageIcon) {
		graveyardButton_1.setIcon(imageIcon);
		graveyardButton_1.setVisible(true);
	}

	public void setGraveyardButton_2(ImageIcon imageIcon) {
		RotateIcon ri = new RotateIcon(imageIcon, RotateIcon.Rotate.UPSIDE_DOWN);
		graveyardButton_2.setIcon(ri);
		graveyardButton_2.setVisible(true);
	}

	public JButton getSelectedFieldButton() {
		return selectedFieldButton;
	}

	public void setSelectedFieldButton(JButton selectedFieldButton) {
		this.selectedFieldButton = selectedFieldButton;
	}

	public JButton getTributeMonsterButton1() {
		return tributeMonsterButton1;
	}

	public void setTributeMonsterButton1(JButton tributeMonsterButton1) {
		this.tributeMonsterButton1 = tributeMonsterButton1;
	}

	public JButton getTributeMonsterButton2() {
		return tributeMonsterButton2;
	}

	public void setTributeMonsterButton2(JButton tributeMonsterButton2) {
		this.tributeMonsterButton2 = tributeMonsterButton2;
	}

	public JButton getSelectedButton() {
		return selectedButton;
	}

	public void setSelectedButton(JButton selectedButton) {
		this.selectedButton = selectedButton;
	}

	public JButton getSelectedOpponentButton() {
		return selectedOpponentButton;
	}

	public void setSelectedOpponentButton(JButton selectedOpponentButton) {
		this.selectedOpponentButton = selectedOpponentButton;
	}

	public JButton getFieldButton_1() {
		return fieldButton_1;
	}

	public void setFieldButton_1(JButton fieldButton_1) {
		this.fieldButton_1 = fieldButton_1;
	}

	public JButton getFieldButton_2() {
		return fieldButton_2;
	}

	public void setFieldButton_2(JButton fieldButton_2) {
		this.fieldButton_2 = fieldButton_2;
	}

	public void setSpellTrapFieldButton1(List<JButton> spellTrapFieldButton1) {
		this.spellTrapFieldButton1 = spellTrapFieldButton1;
	}

	public void setSpellTrapFieldButton2(List<JButton> spellTrapFieldButton2) {
		this.spellTrapFieldButton2 = spellTrapFieldButton2;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled1(Boolean enabled) {
		this.enabled = enabled;
	}

	// Rút bài (Giao diện)
	public void drawCard(Player player, JButton b) {
		if (player.getField().getPhase() == "DRAW" && !player.isDrawed()) {
			if (player == gui.getNewGame().getPlayer1() && b.getX() == drawCardButton_1.getX()) {
				player.drawCard();
				SoundEffects.drawCardSound();
				int t = player.getHand().getCardsInHand().size() - 1;
				handPlayer1.get(t).setVisible(true);
				handPlayer1.get(t).setIcon(player.getHand().getCardsInHand().get(t).getImageMedium());
				handPlayer1.get(t).addMouseListener(selectCardListener);
				handPlayer1.get(t).addMouseListener(showCardInfoListener);
				drawCardButton_1.setText(String.valueOf(gui.getNewGame().getPlayer1().getDeck().getDeck().size()));
				drawCardButton_1.setBorder(new LineBorder(Color.RED, 5));
				handPanelPlayer1.setVisible(true);
				player.setDrawed(true);
				player.endPhase("MAIN 2");
				gui.endPhase();
			}
			if (player == gui.getNewGame().getPlayer2() && b.getX() == drawCardButton_2.getX()) {
				player.drawCard();
				SoundEffects.drawCardSound();
				int t = player.getHand().getCardsInHand().size() - 1;
				handPlayer2.get(t).setVisible(true);
				handPlayer2.get(t).setIcon(player.getHand().getCardsInHand().get(t).getImageMedium());
				handPlayer2.get(t).addMouseListener(selectCardListener);
				handPlayer2.get(t).addMouseListener(showCardInfoListener);
				drawCardButton_2.setText(String.valueOf(gui.getNewGame().getPlayer2().getDeck().getDeck().size()));
				drawCardButton_2.setBorder(new LineBorder(Color.RED, 5));
				handPanelPlayer2.setVisible(true);
				player.setDrawed(true);
				player.endPhase("MAIN 2");
				gui.endPhase();
			}
		}
	}

	// Chọn card trên tay người chơi (Giao diện)
	public void selectCardInHand_UI(Component t) {
		if (selectedButton != null) {
			selectedButton.setBorder(new LineBorder(Color.YELLOW, 0));
		}
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer1.get(i).getX() == t.getX() && handPanelPlayer1.getY() == t.getParent().getY()) {
					selectedButton = handPlayer1.get(i);
					currentPlayer.setSelectedCard(currentPlayer.getHand().getCardsInHand().get(i));
					SoundEffects.selectCardSound();
					handPanelPlayer1.setComponentZOrder(selectedButton, handPlayer1.size() - 1 - i);
					selectedButton.setBorder(new LineBorder(Color.YELLOW, 5));
					return;
				}
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer2.get(i).getX() == t.getX() && handPanelPlayer2.getY() == t.getParent().getY()) {
					selectedButton = handPlayer2.get(i);
					currentPlayer.setSelectedCard(currentPlayer.getHand().getCardsInHand().get(i));
					SoundEffects.selectCardSound();
					handPanelPlayer2.setComponentZOrder(selectedButton, handPlayer2.size() - 1 - i);
					selectedButton.setBorder(new LineBorder(Color.YELLOW, 5));
					return;
				}
			}
		}
	}

	// Lựa chọn card trên sân (Giao diện) (bộ bài, bài môi trường, mộ)
	public void selectCardInField_UI(Component t) {
		if (selectedButton != null && currentPlayer.getSelectedCard() != null) {
			if (currentPlayer.getSelectedCard().getLocation() == "On Field") {
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 0));
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			if (t.getX() == drawCardButton_1.getX() && t.getY() == drawCardButton_1.getY()) {
				return;
			}
			if (t.getX() == fieldButton_1.getX() && t.getY() == fieldButton_1.getY()) {
				selectedButton = fieldButton_1;
				currentPlayer.setSelectedCard(currentPlayer.getField().getField());
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == graveyardButton_1.getX() && t.getY() == graveyardButton_1.getY()) {
				selectedButton = graveyardButton_1;
				currentPlayer.setSelectedCard(currentPlayer.getField().getGraveyard()
						.get(currentPlayer.getField().getGraveyard().size() - 1));
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == fieldButton_2.getX() && t.getY() == fieldButton_2.getY()) {
				selectedButton = fieldButton_2;
				currentPlayer.setSelectedCard(opponentPlayer.getField().getField());
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == graveyardButton_2.getX() && t.getY() == graveyardButton_2.getY()) {
				selectedButton = graveyardButton_2;
				currentPlayer.setSelectedCard(opponentPlayer.getField().getGraveyard()
						.get(opponentPlayer.getField().getGraveyard().size() - 1));
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			if (t.getX() == drawCardButton_2.getX() && t.getY() == drawCardButton_2.getY()) {
				return;
			}
			if (t.getX() == fieldButton_2.getX() && t.getY() == fieldButton_2.getY()) {
				selectedButton = fieldButton_2;
				currentPlayer.setSelectedCard(currentPlayer.getField().getField());
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == graveyardButton_2.getX() && t.getY() == graveyardButton_2.getY()) {
				selectedButton = graveyardButton_2;
				currentPlayer.setSelectedCard(currentPlayer.getField().getGraveyard()
						.get(currentPlayer.getField().getGraveyard().size() - 1));
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == fieldButton_1.getX() && t.getY() == fieldButton_1.getY()) {
				selectedButton = fieldButton_1;
				currentPlayer.setSelectedCard(opponentPlayer.getField().getField());
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
			if (t.getX() == graveyardButton_1.getX() && t.getY() == graveyardButton_1.getY()) {
				selectedButton = graveyardButton_1;
				currentPlayer.setSelectedCard(opponentPlayer.getField().getGraveyard()
						.get(opponentPlayer.getField().getGraveyard().size() - 1));
				SoundEffects.selectField();
				selectedButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				return;
			}
		}
	}

	// Đặt viền cho bài trên tay khi trỏ chuột qua
	public void highlightCardInHand_UI(Component t, Boolean b) {
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer1.get(i).getX() == t.getX() && handPanelPlayer1.getY() == t.getParent().getY()) {
					if (b && handPlayer1.get(i) != selectedButton) {
						handPlayer1.get(i).setBorder(new LineBorder(Color.GREEN, 5));
						handPanelPlayer1.setComponentZOrder(handPlayer1.get(i), handPlayer1.get(i).getComponentCount());
						SoundEffects.hoverCardSound();
					}
					if (!b && handPlayer1.get(i) != selectedButton) {
						handPlayer1.get(i).setBorder(new LineBorder(Color.GREEN, 0));
						handPanelPlayer1.setComponentZOrder(handPlayer1.get(i), handPlayer1.size() - 1 - i);
					}
					return;
				}
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer2.get(i).getX() == t.getX() && handPanelPlayer2.getY() == t.getParent().getY()) {
					if (b && handPlayer2.get(i) != selectedButton) {
						handPlayer2.get(i).setBorder(new LineBorder(Color.GREEN, 5));
						handPanelPlayer2.setComponentZOrder(handPlayer2.get(i), handPlayer2.get(i).getComponentCount());
						SoundEffects.hoverCardSound();
					}
					if (!b && handPlayer2.get(i) != selectedButton) {
						handPlayer2.get(i).setBorder(new LineBorder(Color.GREEN, 0));
						handPanelPlayer2.setComponentZOrder(handPlayer2.get(i), handPlayer2.size() - 1 - i);
					}
					return;
				}
			}
		}
	}

	// Đặt viền cho bài trên sân khi trỏ chuột qua (bộ bài, bài môi trường, mộ)
	public void highlightCardInField_UI(Component t, Boolean b) {
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			if (t.getX() == drawCardButton_1.getX() && t.getY() == drawCardButton_1.getY()) {
				if (b) {
					if (currentPlayer.isDrawed()
							|| gui.getNewGame().getCurrentPlayer().getHand().getCardsInHand().size() == 10) {
						drawCardButton_1.setBorder(new LineBorder(Color.RED, 5));
						return;
					}
					drawCardButton_1.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b) {
					drawCardButton_1.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == fieldButton_1.getX() && t.getY() == fieldButton_1.getY()) {
				if (b && fieldButton_1 != selectedButton) {
					fieldButton_1.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b && fieldButton_1 != selectedButton) {
					fieldButton_1.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == graveyardButton_1.getX() && t.getY() == graveyardButton_1.getY()) {
				if (b && graveyardButton_1 != selectedButton) {
					graveyardButton_1.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b && graveyardButton_1 != selectedButton) {
					graveyardButton_1.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == fieldButton_2.getX() && t.getY() == fieldButton_2.getY()) {
				if (b && fieldButton_2 != selectedButton) {
					fieldButton_2.setBorder(new LineBorder(Color.RED, 5));
					return;
				}
				if (!b && fieldButton_2 != selectedButton) {
					fieldButton_2.setBorder(new LineBorder(Color.RED, 0));
					return;
				}
			}

			if (t.getX() == graveyardButton_2.getX() && t.getY() == graveyardButton_2.getY()) {
				if (b && graveyardButton_2 != selectedButton) {
					graveyardButton_2.setBorder(new LineBorder(Color.RED, 5));
					return;
				}
				if (!b && graveyardButton_2 != selectedButton) {
					graveyardButton_2.setBorder(new LineBorder(Color.RED, 0));
					return;
				}
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			if (t.getX() == drawCardButton_2.getX() && t.getY() == drawCardButton_2.getY()) {
				if (b) {
					if (currentPlayer.isDrawed()
							|| gui.getNewGame().getCurrentPlayer().getHand().getCardsInHand().size() >= 10) {
						drawCardButton_2.setBorder(new LineBorder(Color.RED, 5));
						return;
					}
					drawCardButton_2.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b) {
					drawCardButton_2.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == fieldButton_2.getX() && t.getY() == fieldButton_2.getY()) {
				if (b && fieldButton_2 != selectedButton) {
					fieldButton_2.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b && fieldButton_2 != selectedButton) {
					fieldButton_2.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == graveyardButton_2.getX() && t.getY() == graveyardButton_2.getY()) {
				if (b && graveyardButton_2 != selectedButton) {
					graveyardButton_2.setBorder(new LineBorder(Color.GREEN, 5));
					return;
				}
				if (!b && graveyardButton_2 != selectedButton) {
					graveyardButton_2.setBorder(new LineBorder(Color.GREEN, 0));
					return;
				}
			}

			if (t.getX() == fieldButton_1.getX() && t.getY() == fieldButton_1.getY()) {
				if (b && fieldButton_1 != selectedButton) {
					fieldButton_1.setBorder(new LineBorder(Color.RED, 5));
					return;
				}
				if (!b && fieldButton_1 != selectedButton) {
					fieldButton_1.setBorder(new LineBorder(Color.RED, 0));
					return;
				}
			}

			if (t.getX() == graveyardButton_1.getX() && t.getY() == graveyardButton_1.getY()) {
				if (b && graveyardButton_1 != selectedButton) {
					graveyardButton_1.setBorder(new LineBorder(Color.RED, 5));
					return;
				}
				if (!b && graveyardButton_1 != selectedButton) {
					graveyardButton_1.setBorder(new LineBorder(Color.RED, 0));
					return;
				}
			}
		}
	}

	// Thay đổi giao diện người chơi 1 và 2
	public void swapUI() {
		Player t = currentPlayer;
		currentPlayer = opponentPlayer;
		opponentPlayer = t;
		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer1.get(i).addMouseListener(selectCardListener);
				handPlayer1.get(i).addMouseListener(showCardInfoListener);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer2.get(i).addMouseListener(selectCardListener);
				handPlayer2.get(i).addMouseListener(showCardInfoListener);
			}
		}
		for (int i = 0; i < opponentPlayer.getHand().getCardsInHand().size(); i++) {
			if (opponentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(opponentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
				handPlayer1.get(i).removeMouseListener(selectCardListener);
				handPlayer1.get(i).removeMouseListener(showCardInfoListener);
			}
			if (opponentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(opponentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
				handPlayer2.get(i).removeMouseListener(selectCardListener);
				handPlayer2.get(i).removeMouseListener(showCardInfoListener);
			}
		}
		if (selectedButton != null) {
			selectedButton.setBorder(null);
		}
		gui.getNewGame().getCurrentPlayer().setSelectedCard(null);

		for (int i = 0; i < 5; i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				monsterFieldButton1.get(i).removeMouseListener(selectOpponentFieldListener);
				monsterFieldButton1.get(i).addMouseListener(selectFieldListener);
				monsterFieldButton2.get(i).removeMouseListener(selectFieldListener);
				monsterFieldButton2.get(i).addMouseListener(selectOpponentFieldListener);
				spellTrapFieldButton1.get(i).removeMouseListener(selectOpponentFieldListener);
				spellTrapFieldButton1.get(i).addMouseListener(selectFieldListener);
				spellTrapFieldButton2.get(i).removeMouseListener(selectFieldListener);
				spellTrapFieldButton2.get(i).addMouseListener(selectOpponentFieldListener);
				
				monsterFieldButton1.get(i).removeMouseListener(showOpponentCardInfoListener);
				monsterFieldButton1.get(i).addMouseListener(showCardInfoListener);
				monsterFieldButton2.get(i).removeMouseListener(showCardInfoListener);
				monsterFieldButton2.get(i).addMouseListener(showOpponentCardInfoListener);
				spellTrapFieldButton1.get(i).removeMouseListener(showOpponentCardInfoListener);
				spellTrapFieldButton1.get(i).addMouseListener(showCardInfoListener);
				spellTrapFieldButton2.get(i).removeMouseListener(showCardInfoListener);
				spellTrapFieldButton2.get(i).addMouseListener(showOpponentCardInfoListener);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				monsterFieldButton1.get(i).removeMouseListener(selectFieldListener);
				monsterFieldButton1.get(i).addMouseListener(selectOpponentFieldListener);
				monsterFieldButton2.get(i).removeMouseListener(selectOpponentFieldListener);
				monsterFieldButton2.get(i).addMouseListener(selectFieldListener);
				spellTrapFieldButton1.get(i).removeMouseListener(selectFieldListener);
				spellTrapFieldButton1.get(i).addMouseListener(selectOpponentFieldListener);
				spellTrapFieldButton2.get(i).removeMouseListener(selectOpponentFieldListener);
				spellTrapFieldButton2.get(i).addMouseListener(selectFieldListener);
				
				monsterFieldButton1.get(i).removeMouseListener(showCardInfoListener);
				monsterFieldButton1.get(i).addMouseListener(showOpponentCardInfoListener);
				monsterFieldButton2.get(i).removeMouseListener(showOpponentCardInfoListener);
				monsterFieldButton2.get(i).addMouseListener(showCardInfoListener);
				spellTrapFieldButton1.get(i).removeMouseListener(showCardInfoListener);
				spellTrapFieldButton1.get(i).addMouseListener(showOpponentCardInfoListener);
				spellTrapFieldButton2.get(i).removeMouseListener(showOpponentCardInfoListener);
				spellTrapFieldButton2.get(i).addMouseListener(showCardInfoListener);
			}
		}
		
		
	}

	// Xóa bài trên tay (Giao diện)
	public void removeCardInHandUI() {
		if (currentPlayer.getHand().getCardsInHand().size() == 0) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPanelPlayer1.setVisible(false);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPanelPlayer2.setVisible(false);
			}
		}
		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer1.get(currentPlayer.getHand().getCardsInHand().size()).setVisible(false);
				handPlayer1.get(i).setBorder(new LineBorder(Color.YELLOW, 0));
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer2.get(currentPlayer.getHand().getCardsInHand().size()).setVisible(false);
				handPlayer2.get(i).setBorder(new LineBorder(Color.YELLOW, 0));
			}
		}
		gui.setWinner_UI(gui.getNewGame().getCurrentWinner());
		selectedFieldButton = null;
		selectedButton = null;
		gui.closeShowInfo();
		gui.closeShowControl();
	}

	// Thêm bài vào mộ (Giao diện)
	public void addToGraveyard_UI(Player player, Card card) {
		if (player == gui.getNewGame().getPlayer1()) {
			setGraveyardButton_1(card.getImageSmall());
		}
		if (player == gui.getNewGame().getPlayer2()) {
			setGraveyardButton_2(card.getImageSmall());
		}
	}

	// Lựa chọn bài trên sân (Monster, Spell, Trap)
	public void selectField_UI(Player player, List<JButton> arrBtn, JButton b) {
		if (tributeMonsterButton1 != null && tributeMonsterButton1 != null) {
			return;
		}
		JButton t = selectedFieldButton;
		for (int i = 0; i < 5; i++) {
			if (arrBtn.get(i).getX() == b.getX() && arrBtn.get(i).getY() == b.getY()) {

				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					if (b.getY() == 450 || b.getY() == 465) {
						currentPlayer.setSelectedCard(currentPlayer.getField().getMonster().get(i));
						SoundEffects.selectField();
					}
					if (b.getY() == 560) {
						currentPlayer.setSelectedCard(currentPlayer.getField().getSpellTrap().get(i));
						SoundEffects.selectField();
					}
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					if (b.getY() == 300 || b.getY() == 315) {
						currentPlayer.setSelectedCard(currentPlayer.getField().getMonster().get(i));
						SoundEffects.selectField();
					}
					if (b.getY() == 190) {
						currentPlayer.setSelectedCard(currentPlayer.getField().getSpellTrap().get(i));
						SoundEffects.selectField();
					}
				}

				if (selectedButton != null) {
					selectedButton.setBorder(new LineBorder(Color.YELLOW, 0));
					selectedButton = null;
				}

				if (t != null && t != tributeMonsterButton1 && t != tributeMonsterButton2) {
					t.setBorder(new LineBorder(Color.YELLOW, 0));
					gui.closeShowInfo();
					gui.closeShowControl();
				}
				selectedFieldButton = arrBtn.get(i);
				selectedFieldButton.setBorder(new LineBorder(Color.YELLOW, 5));
				if (t == selectedFieldButton && t != tributeMonsterButton1 && t != tributeMonsterButton2) {
					t.setBorder(new LineBorder(Color.GREEN, 5));
					selectedFieldButton = null;
					currentPlayer.setSelectedCard(null);
				}
			}
			if (player == gui.getNewGame().getPlayer1()) {
				if (gui.getNewGame().getCurrentPlayer().getTributeMonster1() != null
						&& gui.getNewGame().getCurrentPlayer().getField().getMonster().get(i) == gui.getNewGame()
								.getCurrentPlayer().getTributeMonster1()) {
					monsterFieldButton1.get(i).setBorder(new LineBorder(Color.RED, 5));
					tributeMonsterButton1 = monsterFieldButton1.get(i);
				}
				if (gui.getNewGame().getCurrentPlayer().getTributeMonster2() != null
						&& gui.getNewGame().getCurrentPlayer().getField().getMonster().get(i) == gui.getNewGame()
								.getCurrentPlayer().getTributeMonster2()) {
					monsterFieldButton1.get(i).setBorder(new LineBorder(Color.RED, 5));
					tributeMonsterButton2 = monsterFieldButton1.get(i);
				}
			}
			if (player == gui.getNewGame().getPlayer2()) {
				if (gui.getNewGame().getCurrentPlayer().getTributeMonster1() != null
						&& gui.getNewGame().getCurrentPlayer().getField().getMonster().get(i) == gui.getNewGame()
								.getCurrentPlayer().getTributeMonster1()) {
					monsterFieldButton2.get(i).setBorder(new LineBorder(Color.RED, 5));
					tributeMonsterButton1 = monsterFieldButton2.get(i);
				}
				if (gui.getNewGame().getCurrentPlayer().getTributeMonster2() != null
						&& gui.getNewGame().getCurrentPlayer().getField().getMonster().get(i) == gui.getNewGame()
								.getCurrentPlayer().getTributeMonster2()) {
					monsterFieldButton2.get(i).setBorder(new LineBorder(Color.RED, 5));
					tributeMonsterButton2 = monsterFieldButton2.get(i);
				}
			}
		}
	}

	// Đặt viền cho bài trên sân khi trỏ chuột qua (Monster, Spell, Trap)
	public void hoverField_UI(Player player, ArrayList<JButton> arrBtn, JButton b, Boolean inOut) {
		if (tributeMonsterButton1 != null && tributeMonsterButton1 != null) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (arrBtn.get(i).getX() == b.getX() && arrBtn.get(i).getY() == b.getY() && b != selectedFieldButton
					&& b != tributeMonsterButton1 && b != tributeMonsterButton2) {
				if (inOut) {
					arrBtn.get(i).setBorder(new LineBorder(Color.GREEN, 5));
				}
				if (!inOut) {
					arrBtn.get(i).setBorder(new LineBorder(Color.GREEN, 0));
				}
				break;
			}
		}
	}

	// Triệu hồi quái thú (Giao diện)
	public void summon_UI(int index, Boolean isAttack) {
		if (selectedFieldButton != null) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				if (isAttack) {
					selectedFieldButton.setBounds(120 + index * 110, 450, 70, 100);
					selectedFieldButton.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				}
				if (!isAttack) {
					selectedFieldButton.setBounds(105 + index * 110, 465, 100, 70);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				if (isAttack) {
					selectedFieldButton.setBounds(120 + index * 110, 300, 70, 100);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
				if (!isAttack) {
					selectedFieldButton.setBounds(105 + index * 110, 315, 100, 70);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UP);
					selectedFieldButton.setIcon(ri);
				}
			}
		}
		if (selectedFieldButton == null) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				selectedFieldButton = monsterFieldButton1.get(index);
				selectedFieldButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				if (isAttack) {
					selectedFieldButton.setBounds(120 + index * 110, 450, 70, 100);
					selectedFieldButton.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				}
				if (!isAttack) {
					selectedFieldButton.setBounds(105 + index * 110, 465, 100, 70);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				selectedFieldButton = monsterFieldButton2.get(index);
				selectedFieldButton.setBorder(new LineBorder(Color.MAGENTA, 5));
				if (isAttack) {
					selectedFieldButton.setBounds(120 + index * 110, 300, 70, 100);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
				if (!isAttack) {
					selectedFieldButton.setBounds(105 + index * 110, 315, 100, 70);
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UP);
					selectedFieldButton.setIcon(ri);
				}
			}
		}
	}

	// Lấy giá trị field được chọn
	public int getIndex(JButton jButton, List<JButton> list, String indexOf) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == jButton) {
				return i;
			}
		}
		if (jButton == null && indexOf == "SummonMonster") {
			for (int i = 0; i < list.size(); i++) {
				if (gui.getNewGame().getCurrentPlayer().getField().getMonster().get(i) == null) {
					return i;
				}
			}
		}
		if (jButton == null && indexOf == "ActivateSpellTrap") {
			for (int i = 0; i < list.size(); i++) {
				if (gui.getNewGame().getCurrentPlayer().getField().getSpellTrap().get(i) == null) {
					return i;
				}
			}
		}
		return -1;
	}

	// Chọn quái vật hiến tế
	public void selectTributeMonster_UI(int index) {
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer1()) {
			monsterFieldButton1.get(index).setBorder(new LineBorder(Color.RED, 5));
		}
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer2()) {
			monsterFieldButton2.get(index).setBorder(new LineBorder(Color.RED, 5));
		}
	}

	// Xóa quái vật hiến tế
	public void removeTributeMonster_UI(int index) {
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer1()) {
			monsterFieldButton1.get(index).setBorder(new LineBorder(Color.RED, 0));
		}
		if (gui.getNewGame().getCurrentPlayer() == gui.getNewGame().getPlayer2()) {
			monsterFieldButton2.get(index).setBorder(new LineBorder(Color.RED, 0));
		}
	}

	// Hiển thị bài spell và trap
	public void setSpellTrap_UI(int index, Boolean isFaceDown) {
		if (!isFaceDown) {
			if (selectedFieldButton != null) {
				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					selectedFieldButton.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
			if (selectedFieldButton == null) {
				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					selectedFieldButton = spellTrapFieldButton1.get(index);
					selectedFieldButton.setBorder(new LineBorder(Color.MAGENTA, 5));
					selectedFieldButton.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					selectedFieldButton = spellTrapFieldButton2.get(index);
					selectedFieldButton.setBorder(new LineBorder(Color.MAGENTA, 5));
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
		}
		if (isFaceDown) {
			if (selectedFieldButton != null) {
				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					selectedFieldButton
							.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().faceDownImage("S"));
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().faceDownImage("S"),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
			if (selectedFieldButton == null) {
				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					selectedFieldButton = spellTrapFieldButton1.get(index);
					selectedFieldButton.setBorder(new LineBorder(Color.YELLOW, 5));
					selectedFieldButton
							.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().faceDownImage("S"));
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					selectedFieldButton = spellTrapFieldButton2.get(index);
					selectedFieldButton.setBorder(new LineBorder(Color.YELLOW, 5));
					RotateIcon ri = new RotateIcon(
							gui.getNewGame().getCurrentPlayer().getSelectedCard().faceDownImage("S"),
							RotateIcon.Rotate.UPSIDE_DOWN);
					selectedFieldButton.setIcon(ri);
				}
			}
		}
	}

	// Thay đổi chế độ chiến đấu của quái thú
	public void switchMonsterMode_UI(int index, String mode) {
		if (mode == "ATTACK") {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				selectedFieldButton.setBounds(120 + index * 110, 450, 70, 100);
				selectedFieldButton.setIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				selectedFieldButton.setBounds(120 + index * 110, 300, 70, 100);
				RotateIcon ri = new RotateIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
						RotateIcon.Rotate.UPSIDE_DOWN);
				selectedFieldButton.setIcon(ri);
			}
		}
		if (mode == "DEFENSE") {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				selectedFieldButton.setBounds(105 + index * 110, 465, 100, 70);
				RotateIcon ri = new RotateIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
						RotateIcon.Rotate.DOWN);
				selectedFieldButton.setIcon(ri);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				selectedFieldButton.setBounds(105 + index * 110, 315, 100, 70);
				RotateIcon ri = new RotateIcon(gui.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall(),
						RotateIcon.Rotate.UP);
				selectedFieldButton.setIcon(ri);
			}
		}
	}

	// Chọn bài trên sân đối thủ
	public void selectOpponentField_UI(Player player, List<JButton> arrBtn, JButton b) {
		JButton t = selectedOpponentButton;
		for (int i = 0; i < 5; i++) {
			if (arrBtn.get(i).getX() == b.getX() && arrBtn.get(i).getY() == b.getY()) {
				if (currentPlayer == gui.getNewGame().getPlayer1()) {
					if (b.getY() == 300 || b.getY() == 315) {
						currentPlayer.setSelectedOpponentCard(gui.getNewGame().getPlayer2().getField().getMonster().get(i));
						SoundEffects.selectField();
					}
					if (b.getY() == 190) {
						currentPlayer.setSelectedOpponentCard(gui.getNewGame().getPlayer2().getField().getSpellTrap().get(i));
						SoundEffects.selectField();
					}
				}
				if (currentPlayer == gui.getNewGame().getPlayer2()) {
					if (b.getY() == 450 || b.getY() == 465) {
						currentPlayer.setSelectedOpponentCard(gui.getNewGame().getPlayer1().getField().getMonster().get(i));
						SoundEffects.selectField();
					}
					if (b.getY() == 560) {
						currentPlayer.setSelectedOpponentCard(gui.getNewGame().getPlayer1().getField().getSpellTrap().get(i));
						SoundEffects.selectField();
					}
				}
				if (selectedButton != null) {
					selectedButton.setBorder(null);
					selectedButton = null;
				}
				if (selectedFieldButton != null) {
					selectedFieldButton.setBorder(null);
					selectedFieldButton = null;
				}
				if (t != null) {
					t.setBorder(null);
					gui.closeShowInfo();
					gui.closeShowControl();
				}
				selectedOpponentButton = arrBtn.get(i);
				if (player.getField().getPhase() == "BATTLE") {
					arrBtn.get(i).setBorder(new LineBorder(Color.YELLOW, 5));
				} else {
					arrBtn.get(i).setBorder(new LineBorder(Color.MAGENTA, 5));
				}
				if (t == selectedOpponentButton) {
					if (player.getField().getPhase() == "BATTLE") {
						arrBtn.get(i).setBorder(new LineBorder(Color.GREEN, 5));
					} else {
						arrBtn.get(i).setBorder(new LineBorder(Color.RED, 5));
					}
					selectedOpponentButton = null;
					currentPlayer.setSelectedOpponentCard(null);
				}
			}
		}
	}

	// Trỏ chuột vào bài trên sân đối thủ
	public void hoverOpponentField_UI(Player player, ArrayList<JButton> arrBtn, JButton b, Boolean inOut) {
		for (int i = 0; i < 5; i++) {
			if (arrBtn.get(i).getX() == b.getX() && arrBtn.get(i).getY() == b.getY() && b != selectedOpponentButton) {
				if (inOut) {
					if (player.getField().getPhase() == "BATTLE") {
						arrBtn.get(i).setBorder(new LineBorder(Color.GREEN, 5));
					} else {
						arrBtn.get(i).setBorder(new LineBorder(Color.RED, 5));
					}
				}
				if (!inOut) {
					arrBtn.get(i).setBorder(null);
				}
				break;
			}
		}
	}

	// Xóa quái vật (Giao diện)
	public void removeMonster_UI(Player opponent) {
		for (int i = 0; i < 5; i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				if (currentPlayer.getField().getMonster().get(i) == null) {
					monsterFieldButton1.get(i).setIcon(null);
					monsterFieldButton1.get(i).setBorder(null);
				}
				if (opponentPlayer.getField().getMonster().get(i) == null) {
					monsterFieldButton2.get(i).setIcon(null);
					monsterFieldButton2.get(i).setBorder(null);
				}
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				if (currentPlayer.getField().getMonster().get(i) == null) {
					monsterFieldButton2.get(i).setIcon(null);
					monsterFieldButton2.get(i).setBorder(null);
				}
				if (opponentPlayer.getField().getMonster().get(i) == null) {
					monsterFieldButton1.get(i).setIcon(null);
					monsterFieldButton1.get(i).setBorder(null);
				}
			}
		}
	}
	
	// Thêm listener select
	public void addSelectCard_UI() {
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				handPlayer1.get(i).addMouseListener(selectCardListener);
				handPlayer1.get(i).addMouseListener(showCardInfoListener);
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				handPlayer2.get(i).addMouseListener(selectCardListener);
				handPlayer2.get(i).addMouseListener(showCardInfoListener);
			}
		}
	}
	
	// Xóa listener select
	public void removeSelectCard_UI() {
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				handPlayer1.get(i).removeMouseListener(selectCardListener);
				handPlayer1.get(i).removeMouseListener(showCardInfoListener);
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				handPlayer2.get(i).removeMouseListener(selectCardListener);
				handPlayer2.get(i).removeMouseListener(showCardInfoListener);
			}
		}
	}
}
