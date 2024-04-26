package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.DrawCardListener;
import controller.SelectCardListener;
import controller.ShowCardInfoListener;
import model.Player;
import model.RotateIcon;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class CardLocationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player currentPlayer;
	private Player opponentPlayer;
	private List<JButton> handPlayer1 = new ArrayList<JButton>();
	private List<JButton> handPlayer2 = new ArrayList<JButton>();
	private JLayeredPane handPanelPlayer1;
	private JLayeredPane handPanelPlayer2;
	private DrawCardListener drawCardListener;
	private ShowCardInfoListener showCardInfoListener;
	private GUI gui;
	private SelectCardListener selectCardListener;
	private JButton selectedButton;
	private JButton drawCardButton_1;
	private JButton drawCardButton_2;
	private JButton fieldButton_1;
	private JButton fieldButton_2;

	public CardLocationPanel(GUI gui) {
		this.gui = gui;
		this.currentPlayer = gui.getNewGame().getCurrentPlayer();
		this.opponentPlayer = gui.getNewGame().getOpponentPlayer();
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(750, 840);
		setLayout(null);

		drawCardListener = new DrawCardListener(this);
		showCardInfoListener = new ShowCardInfoListener(gui, this);
		selectCardListener = new SelectCardListener(this);

		handPanelPlayer1 = new JLayeredPane();
		handPanelPlayer1.setBounds(0, 665, 750, 175);
		this.add(handPanelPlayer1);

		handPanelPlayer2 = new JLayeredPane();
		handPanelPlayer2.setBounds(0, 0, 750, 175);
		this.add(handPanelPlayer2);

		for (int i = 0; i < 10; i++) {
			JButton handBtn1 = new JButton("");
			handBtn1.setBounds(i * 70, 0, 120, 175);
			handBtn1.setFocusPainted(false);
			handBtn1.setVisible(false);
			handBtn1.addMouseListener(selectCardListener);
			handBtn1.addMouseListener(showCardInfoListener);
			handPanelPlayer1.add(handBtn1, Integer.valueOf(i));
			handPlayer1.add(handBtn1);
			JButton handBtn2 = new JButton("");
			handBtn2.setBounds(i * 70, 0, 120, 175);
			handBtn2.setFocusPainted(false);
			handBtn2.setVisible(false);
			handBtn2.addMouseListener(selectCardListener);
			handBtn2.addMouseListener(showCardInfoListener);
			handPanelPlayer2.add(handBtn2, Integer.valueOf(i));
			handPlayer2.add(handBtn2);
		}

		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setVisible(true);
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setVisible(true);
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
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

		drawCardButton_1 = new JButton("");
		drawCardButton_1.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		drawCardButton_1.setBounds(655, 555, 70, 100);
		drawCardButton_1.setFocusable(false);
		drawCardButton_1.addActionListener(drawCardListener);
		add(drawCardButton_1);

		drawCardButton_2 = new JButton("");
		drawCardButton_2.setBounds(25, 185, 70, 100);
		drawCardButton_2.setIcon(new ImageIcon(CardLocationPanel.class.getResource("/image/Card Background S.jpg")));
		drawCardButton_2.setFocusable(false);
		drawCardButton_2.addActionListener(drawCardListener);
		add(drawCardButton_2);

		fieldButton_1 = new JButton("");
		fieldButton_1.setBounds(25, 445, 70, 100);
		fieldButton_1.setFocusable(false);
		fieldButton_1.setVisible(false);
		add(fieldButton_1);

		fieldButton_2 = new JButton("");
		fieldButton_2.setBounds(655, 295, 70, 100);
		fieldButton_2.setFocusable(false);
		fieldButton_2.setVisible(false);
		add(fieldButton_2);

	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
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

	public void drawCard(Player player, JButton b) {
		if (player.getField().getPhase() == "DRAW" && player.getHand().getCardsInHand().size() < 11
				&& !player.isDrawed()) {
			if (player == gui.getNewGame().getPlayer1() && b.getX() == drawCardButton_1.getX()) {
				player.drawCard();
				int t = player.getHand().getCardsInHand().size() - 1;
				handPlayer1.get(t).setVisible(true);
				handPlayer1.get(t).setIcon(player.getHand().getCardsInHand().get(t).getImageMedium());
				player.setDrawed(true);
			}
			if (player == gui.getNewGame().getPlayer2() && b.getX() == drawCardButton_2.getX()) {
				player.drawCard();
				int t = player.getHand().getCardsInHand().size() - 1;
				handPlayer2.get(t).setVisible(true);
				handPlayer2.get(t).setIcon(player.getHand().getCardsInHand().get(t).getImageMedium());
				player.setDrawed(true);
			}
		}
	}

	public void selectCard(Component t) {
		if (selectedButton != null) {
			selectedButton.setBorder(new LineBorder(Color.YELLOW, 0));
		}
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer1.get(i).getX() == t.getX() && handPanelPlayer1.getY() == t.getParent().getY()) {
					selectedButton = handPlayer1.get(i);
					currentPlayer.setSelectedCard(currentPlayer.getHand().getCardsInHand().get(i));
					handPanelPlayer1.setComponentZOrder(selectedButton, handPlayer1.size() - 1 - i);
					selectedButton.setBorder(new LineBorder(Color.YELLOW, 5));
					break;
				}
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer2.get(i).getX() == t.getX() && handPanelPlayer2.getY() == t.getParent().getY()) {
					selectedButton = handPlayer2.get(i);
					currentPlayer.setSelectedCard(currentPlayer.getHand().getCardsInHand().get(i));
					handPanelPlayer2.setComponentZOrder(selectedButton, handPlayer2.size() - 1 - i);
					selectedButton.setBorder(new LineBorder(Color.YELLOW, 5));
					break;
				}
			}
		}
	}

	public void highlightCard(Component t, Boolean b) {
		if (currentPlayer == gui.getNewGame().getPlayer1()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer1.get(i).getX() == t.getX() && handPanelPlayer1.getY() == t.getParent().getY()) {
					if (b && handPlayer1.get(i) != selectedButton) {
						handPlayer1.get(i).setBorder(new LineBorder(Color.GREEN, 5));
						handPanelPlayer1.setComponentZOrder(handPlayer1.get(i), handPlayer1.get(i).getComponentCount());
					}
					if (!b && handPlayer1.get(i) != selectedButton) {
						handPlayer1.get(i).setBorder(new LineBorder(Color.GREEN, 0));
						handPanelPlayer1.setComponentZOrder(handPlayer1.get(i), handPlayer1.size() - 1 - i);
					}
					break;
				}
			}
		}
		if (currentPlayer == gui.getNewGame().getPlayer2()) {
			for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
				if (handPlayer2.get(i).getX() == t.getX() && handPanelPlayer2.getY() == t.getParent().getY()) {
					if (b && handPlayer2.get(i) != selectedButton) {
						handPlayer2.get(i).setBorder(new LineBorder(Color.GREEN, 5));
						handPanelPlayer2.setComponentZOrder(handPlayer2.get(i), handPlayer2.get(i).getComponentCount());
					}
					if (!b && handPlayer2.get(i) != selectedButton) {
						handPlayer2.get(i).setBorder(new LineBorder(Color.GREEN, 0));
						handPanelPlayer2.setComponentZOrder(handPlayer2.get(i), handPlayer2.size() - 1 - i);
					}
					break;
				}
			}
		}
	}

	public void swapUI() {
		Player t = currentPlayer;
		currentPlayer = opponentPlayer;
		opponentPlayer = t;
		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
			}
		}
		for (int i = 0; i < opponentPlayer.getHand().getCardsInHand().size(); i++) {
			if (opponentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(opponentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
			}
			if (opponentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(opponentPlayer.getHand().getCardsInHand().get(i).faceDownImage("M"));
			}
		}
	}
	
	public void removeCardInHandUI() {
		for (int i = 0; i < currentPlayer.getHand().getCardsInHand().size(); i++) {
			if (currentPlayer == gui.getNewGame().getPlayer1()) {
				handPlayer1.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer1.get(currentPlayer.getHand().getCardsInHand().size()).setVisible(false);
			}
			if (currentPlayer == gui.getNewGame().getPlayer2()) {
				handPlayer2.get(i).setIcon(currentPlayer.getHand().getCardsInHand().get(i).getImageMedium());
				handPlayer2.get(currentPlayer.getHand().getCardsInHand().size()).setVisible(false);
			}
		}
		selectedButton.setBorder(new LineBorder(Color.YELLOW, 0));
		gui.getNewGame().getCurrentPlayer().setSelectedCard(null);
	}
}
