package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import controller.CloseGameListener;
import controller.ControlCardListener1;
import model.FieldCard;
import model.Game;
import model.Player;

import javax.swing.border.CompoundBorder;
import javax.swing.JButton;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private BattlePanel battlePanel;
	private PhaseControlPanel phaseControlPanel;
	private CardLocationPanel cardLocationPanel;
	private JLabel timeLabel;
	private JButton closeGameButton;
	private InfoPlayerPanel infoPlayer1Panel;
	private InfoPlayerPanel infoPlayer2Panel;
	private Game newGame;
	private CardInfoPanel cardInfoPanel;
	private JButton controlButton_1;
	private JButton controlButton_2;

	public GUI() {
		newGame = new Game();
		newGame.startNewGame();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Yugioh");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		ActionListener closeGame = new CloseGameListener(this);
		ControlCardListener1 controlCardListener1 = new ControlCardListener1(this);

		cardLocationPanel = new CardLocationPanel(this);
		cardLocationPanel.setLocation(393, 12);
		getContentPane().add(cardLocationPanel);

		closeGameButton = new JButton("");
		closeGameButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Close Game.jpg")));
		closeGameButton.addActionListener(closeGame);
		closeGameButton.setBounds(0, 0, 20, 20);
		closeGameButton.setFocusPainted(false);
		getContentPane().add(closeGameButton);

		timeLabel = new JLabel("");
		timeLabel.setBounds(20, 0, 90, 30);
		getContentPane().add(timeLabel);

		JButton musicButton = new JButton("");
		musicButton.setBounds(0, 824, 40, 40);
		getContentPane().add(musicButton);

		battlePanel = new BattlePanel();
		battlePanel.setBorder(new LineBorder(new Color(255, 0, 0), 5));
		battlePanel.setLocation(403, 182);
		getContentPane().add(battlePanel);

		cardInfoPanel = new CardInfoPanel();
		cardInfoPanel.setLocation(18, 67);
		cardInfoPanel.setVisible(false);
		getContentPane().add(cardInfoPanel);

		controlButton_1 = new JButton("");
		controlButton_1.setBounds(73, 662, 260, 60);
		controlButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		controlButton_1.addMouseListener(controlCardListener1);
		controlButton_1.setVisible(false);
		getContentPane().add(controlButton_1);

		controlButton_2 = new JButton("");
		controlButton_2.setBounds(73, 732, 260, 60);
		controlButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		controlButton_2.setVisible(false);
		getContentPane().add(controlButton_2);

		phaseControlPanel = new PhaseControlPanel(this);
		phaseControlPanel.setLocation(1202, 222);
		getContentPane().add(phaseControlPanel);

		infoPlayer1Panel = new InfoPlayerPanel();
		infoPlayer1Panel.setLocation(1176, 714);
		getContentPane().add(infoPlayer1Panel);

		infoPlayer2Panel = new InfoPlayerPanel();
		infoPlayer2Panel.setLocation(1176, 0);
		getContentPane().add(infoPlayer2Panel);

		JLabel backgroundLabel = new JLabel("");

		backgroundLabel.setIcon(new ImageIcon(GUI.class.getResource("/image/Background.jpg")));

		backgroundLabel.setBounds(0, 0, 1536, 864);
		getContentPane().add(backgroundLabel);
	}

	public Game getNewGame() {
		return newGame;
	}

	public void setNewGame(Game newGame) {
		this.newGame = newGame;
	}

	public void showCardInfo() {
		cardInfoPanel.setIcon(newGame.getCurrentPlayer().getSelectedCard().getImageLarge());
		cardInfoPanel.setInfo(newGame.getCurrentPlayer().getSelectedCard());
		cardInfoPanel.setVisible(true);
		controlButton_1.setVisible(true);
	}

	public void endPhase() {
		newGame.getCurrentPlayer().endPhase(newGame.getCurrentPlayer().getField().getPhase());
		phaseControlPanel.nextPhase(newGame.getCurrentPlayer().getField().getPhase());
	}

	public void endTurn() {
		newGame.endTurn();
		cardLocationPanel.swapUI();
		phaseControlPanel.nextTurn();
		cardInfoPanel.setVisible(false);
		controlButton_1.setVisible(false);
		controlButton_2.setVisible(false);
	}

	public void cardControl() {
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand"
				&& getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
			controlButton_1.setText("SUMMON");
			controlButton_2.setVisible(true);
			controlButton_2.setText("Summon Face Down");
		}
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand"
				&& getNewGame().getCurrentPlayer().getSelectedCard().getType() == "SpellCard") {
			controlButton_1.setText("USE");
			controlButton_2.setVisible(true);
			controlButton_2.setText("FACE DOWN");
		}
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand"
				&& getNewGame().getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
			controlButton_1.setText("USE");
			controlButton_2.setVisible(true);
			controlButton_2.setText("FACE DOWN");
		}
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "In Hand"
				&& getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard") {
			controlButton_1.setText("USE");
			controlButton_2.setVisible(false);
		}
	}

	public void summon() {
		// TODO Auto-generated method stub

	}

	public void useField() {
		FieldCard fieldCard = (FieldCard) this.getNewGame().getCurrentPlayer().getSelectedCard();
		this.getNewGame().getCurrentPlayer().setField(fieldCard);
		if (this.getNewGame().getCurrentPlayer() == this.getNewGame().getPlayer1()) {
			if (this.getNewGame().getCurrentPlayer().getField().getPhase() == "STANDBY"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 1"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 2") {
				cardLocationPanel
						.setFieldButton_1(this.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				battlePanel.setBgPlayerLabel_1(newGame.getCurrentPlayer().getSelectedCard());
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setVisible(false);
				controlButton_1.setVisible(false);
				controlButton_2.setVisible(false);
				this.revalidate();
				this.repaint();
			}
		}
		if (this.getNewGame().getCurrentPlayer() == this.getNewGame().getPlayer2()) {
			if (this.getNewGame().getCurrentPlayer().getField().getPhase() == "STANDBY"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 1"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 2") {
				cardLocationPanel
						.setFieldButton_2(this.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				battlePanel.setBgPlayerLabel_2(newGame.getCurrentPlayer().getSelectedCard());
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setVisible(false);
				controlButton_1.setVisible(false);
				controlButton_2.setVisible(false);
				this.revalidate();
				this.repaint();
			}
		}
	}
}
