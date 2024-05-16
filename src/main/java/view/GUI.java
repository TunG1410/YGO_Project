package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import controller.ActivateFieldListener;
import controller.ActivateSpellTrapListener;
import controller.CardFaceDownListener;
import controller.CloseGameListener;
import controller.MonsterAttackListener;
import controller.PauseGameListener;
import controller.SoundControllerListener;
import controller.SummonMonsterListener;
import controller.SwitchMonsterModeListener;
import data_access_object.GameDAO;
import model.FieldCard;
import model.Game;
import model.MonsterCard;
import model.Player;
import model.SpellCard;
import model.TrapCard;
import thread.CountingTimeThread;
import thread.PlayBackgroundMusicThread;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private int j, k;
	private Game newGame;
	private Boolean isPause = false;
	private JLabel timeLabel;
	private JButton closeGameButton;
	private JButton controlButton_1;
	private JButton controlButton_2;
	private JButton musicButton;
	private JButton pauseButton;
	private BattlePanel battlePanel;
	private PhaseControlPanel phaseControlPanel;
	private CardLocationPanel cardLocationPanel;
	private InfoPlayerPanel infoPlayer1Panel;
	private InfoPlayerPanel infoPlayer2Panel;
	private CardInfoPanel cardInfoPanel;
	private WinnerPanel winnerPanel;
	private PauseGamePanel pauseGamePanel;
	private PlayBackgroundMusicThread playBackgroundMusicThread;
	private CountingTimeThread countingTimeThread;

	public GUI() {
		newGame = new Game();
		newGame.startNewGame();
		this.init();
		this.setVisible(true);
		countingTimeThread = new CountingTimeThread(this);
		playBackgroundMusicThread = new PlayBackgroundMusicThread("src/main/resources/sound/YuGiOhOSTm.wav");
		countingTimeThread.start();
		playBackgroundMusicThread.start();
		SoundEffects.lifePointSound();
	}

	private void init() {
		this.setTitle("Yugioh");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		CloseGameListener closeGame = new CloseGameListener();
		SoundControllerListener soundControllerListener = new SoundControllerListener(this);
		ActivateFieldListener activateFieldListener = new ActivateFieldListener(this);
		SummonMonsterListener summonMonsterListener = new SummonMonsterListener(this);
		ActivateSpellTrapListener activateSpellTrapListener = new ActivateSpellTrapListener(this);
		CardFaceDownListener cardFaceDownListener = new CardFaceDownListener(this);
		SwitchMonsterModeListener switchMonsterModeListener = new SwitchMonsterModeListener(this);
		MonsterAttackListener monsterAttackListener = new MonsterAttackListener(this);
		PauseGameListener pauseGameListener = new PauseGameListener(this);
		
		pauseButton = new JButton();
		pauseButton.setBackground(Color.LIGHT_GRAY);
		pauseButton.setBounds(20, 0, 30, 30);
		pauseButton.setFocusPainted(false);
		pauseButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pauseButton.setOpaque(true);
		pauseButton.setBorderPainted(true);
		pauseButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Resume.jpg")));
		pauseButton.addActionListener(pauseGameListener);
		getContentPane().add(pauseButton);

		pauseGamePanel = new PauseGamePanel();
		pauseGamePanel.setLocation(643, 382);
		pauseGamePanel.setBackground(SystemColor.textHighlightText);
		pauseGamePanel.setOpaque(true);
		pauseGamePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5), new LineBorder(new Color(0, 255, 255), 5)));
		getContentPane().add(pauseGamePanel);
		pauseGamePanel.setVisible(false);
		
		winnerPanel = new WinnerPanel();
		winnerPanel.setLocation(518, 265);
		winnerPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5),
				new LineBorder(new Color(0, 255, 255), 5)));
		getContentPane().add(winnerPanel);
		winnerPanel.setVisible(false);

		cardLocationPanel = new CardLocationPanel(this);
		cardLocationPanel.setLocation(393, 7);
		getContentPane().add(cardLocationPanel);

		closeGameButton = new JButton("");
		closeGameButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Close Game.jpg")));
		closeGameButton.addActionListener(closeGame);

		closeGameButton.setBounds(0, 0, 20, 20);
		closeGameButton.setFocusPainted(false);
		getContentPane().add(closeGameButton);

		timeLabel = new JLabel("00:00:00");
		timeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setOpaque(true);
		timeLabel.setBounds(72, 830, 90, 30);
		timeLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(timeLabel);

		musicButton = new JButton("");
		musicButton.setVerticalAlignment(SwingConstants.TOP);
		musicButton.setHorizontalAlignment(SwingConstants.RIGHT);
		musicButton.setBounds(20, 814, 50, 49);
		musicButton.addActionListener(soundControllerListener);
		musicButton.setFocusPainted(false);
		musicButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		musicButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Sound On.jpg")));
		getContentPane().add(musicButton);

		battlePanel = new BattlePanel();
		battlePanel.setLocation(403, 182);
		getContentPane().add(battlePanel);

		cardInfoPanel = new CardInfoPanel();
		cardInfoPanel.setLocation(18, 67);
		cardInfoPanel.setVisible(false);
		getContentPane().add(cardInfoPanel);

		controlButton_1 = new JButton("");
		controlButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		controlButton_1.setBackground(Color.LIGHT_GRAY);
		controlButton_1.setOpaque(true);
		controlButton_1.setBounds(73, 662, 260, 60);
		controlButton_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		controlButton_1.addMouseListener(activateSpellTrapListener);
		controlButton_1.addMouseListener(activateFieldListener);
		controlButton_1.addMouseListener(summonMonsterListener);
		controlButton_1.addMouseListener(monsterAttackListener);
		controlButton_1.setVisible(false);
		getContentPane().add(controlButton_1);

		controlButton_2 = new JButton("");
		controlButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		controlButton_2.setBackground(Color.LIGHT_GRAY);
		controlButton_2.setOpaque(true);
		controlButton_2.setBounds(73, 662, 260, 60);
		controlButton_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		controlButton_2.setBounds(73, 732, 260, 60);
		controlButton_2.addMouseListener(cardFaceDownListener);
		controlButton_2.addMouseListener(summonMonsterListener);
		controlButton_2.addMouseListener(switchMonsterModeListener);
		controlButton_2.setVisible(false);
		getContentPane().add(controlButton_2);

		phaseControlPanel = new PhaseControlPanel(this);
		phaseControlPanel.setLocation(1202, 222);
		getContentPane().add(phaseControlPanel);

		infoPlayer1Panel = new InfoPlayerPanel();
		infoPlayer1Panel.setLocation(1186, 724);
		infoPlayer1Panel.getAvartarLabel().setIcon(new ImageIcon(GUI.class.getResource("/image/AvatarYugi.png")));
		infoPlayer1Panel.getPlayerNameLabel().setText(newGame.getPlayer1().getPlayerName());
		getContentPane().add(infoPlayer1Panel);

		infoPlayer2Panel = new InfoPlayerPanel();
		infoPlayer2Panel.setLocation(1186, 0);
		infoPlayer2Panel.getAvartarLabel().setIcon(new ImageIcon(GUI.class.getResource("/image/AvatarKaiba.png")));
		infoPlayer2Panel.getPlayerNameLabel().setText(newGame.getPlayer2().getPlayerName());
		getContentPane().add(infoPlayer2Panel);

		JLabel backgroundLabel = new JLabel("");

		backgroundLabel.setIcon(new ImageIcon(GUI.class.getResource("/image/Background.jpg")));

		backgroundLabel.setBounds(0, 0, 1536, 864);
		getContentPane().add(backgroundLabel);

		if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
			infoPlayer1Panel.setBackground(Color.GREEN);
		}
		if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
			infoPlayer2Panel.setBackground(Color.GREEN);
		}
	}

	public Game getNewGame() {
		return newGame;
	}

	public void setNewGame(Game newGame) {
		this.newGame = newGame;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public CardLocationPanel getCardLocationPanel() {
		return cardLocationPanel;
	}

	// Hiểm thị thông tin thẻ bài khi chọn
	public void showCardInfo() {
		cardInfoPanel.setIcon(newGame.getCurrentPlayer().getSelectedCard().getImageLarge());
		cardInfoPanel.setInfo(newGame.getCurrentPlayer().getSelectedCard());
		cardInfoPanel.setVisible(true);
		controlButton_1.setVisible(true);
		MonsterCard monsterCard = null;
		if (newGame.getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
			monsterCard = (MonsterCard) newGame.getCurrentPlayer().getSelectedCard();
		}
		if (monsterCard != null) {
			if (monsterCard.getLocation() == "On Hand") {
				cardInfoPanel.setSelect();
			}
			if (monsterCard.getLocation() == "On Field") {
				if (monsterCard.getMode() == "ATTACK") {
					cardInfoPanel.setATK();
				}
				if (monsterCard.getMode() == "DEFENSE") {
					cardInfoPanel.setDEF();
				}
			}
		}
	}

	// Hiển thị thông tin thẻ bài đối thủ
	public void opponentCardInfoShow() {
		if (newGame.getCurrentPlayer().getSelectedOpponentCard().getFaceDown()) {
			cardInfoPanel.setIcon(newGame.getCurrentPlayer().getSelectedOpponentCard().faceDownImage("L"));
			cardInfoPanel.closeInfo_UI();
		}
		if (!newGame.getCurrentPlayer().getSelectedOpponentCard().getFaceDown()) {
			cardInfoPanel.setIcon(newGame.getCurrentPlayer().getSelectedOpponentCard().getImageLarge());
			cardInfoPanel.setInfo(newGame.getCurrentPlayer().getSelectedOpponentCard());
		}
		cardInfoPanel.setVisible(true);
		controlButton_1.setVisible(false);
		controlButton_2.setVisible(false);
		MonsterCard monsterCard = null;
		if (newGame.getCurrentPlayer().getSelectedOpponentCard().getType() == "MonsterCard") {
			monsterCard = (MonsterCard) newGame.getCurrentPlayer().getSelectedOpponentCard();
		}
		if (monsterCard != null) {
			if (monsterCard.getLocation() == "On Field") {
				if (monsterCard.getMode() == "ATTACK") {
					cardInfoPanel.setATK();
				}
				if (monsterCard.getMode() == "DEFENSE") {
					cardInfoPanel.setDEF();
				}
			}
		}
	}

	// Đóng hiển thị thông tin thẻ
	public void closeShowInfo() {
		cardInfoPanel.setVisible(false);
	}

	// Đóng hiển thị điều khiển thẻ
	public void closeShowControl() {
		controlButton_1.setVisible(false);
		controlButton_2.setVisible(false);
	}

	// Kết thúc giai đoạn
	public void endPhase() {
		newGame.getCurrentPlayer().endPhase(newGame.getCurrentPlayer().getField().getPhase());
		phaseControlPanel.nextPhase(newGame.getCurrentPlayer().getField().getPhase());
		if (cardLocationPanel.getSelectedButton() != null) {
			cardLocationPanel.getSelectedButton().setBorder(new LineBorder(Color.YELLOW, 0));
		}
		for (int i = 0; i < 5; i++) {
			cardLocationPanel.getMonsterFieldButton1().get(i).setBorder(null);
			cardLocationPanel.getMonsterFieldButton2().get(i).setBorder(null);
			cardLocationPanel.getSpellTrapFieldButton1().get(i).setBorder(null);
			cardLocationPanel.getSpellTrapFieldButton2().get(i).setBorder(null);
		}
		if (newGame.getCurrentPlayer().getField().getPhase() == "BATTLE") {
			cardLocationPanel.removeSelectCard_UI();
		}
		if (newGame.getCurrentPlayer().getField().getPhase() == "MAIN 2") {
			cardLocationPanel.addSelectCard_UI();
		}
		infoPlayer1Panel.getLifePointLabel().setForeground(Color.YELLOW);
		infoPlayer2Panel.getLifePointLabel().setForeground(Color.YELLOW);
		cardLocationPanel.setSelectedButton(null);
		cardLocationPanel.setSelectedFieldButton(null);
		cardLocationPanel.setSelectedOpponentButton(null);
		cardLocationPanel.setTributeMonsterButton1(null);
		cardLocationPanel.setTributeMonsterButton2(null);
		closeShowInfo();
		closeShowControl();
		this.revalidate();
		this.repaint();
	}

	// Kết thúc lượt
	public void endTurn() {
		newGame.endTurn();
		SoundEffects.nextPhaseSound();
		cardLocationPanel.swapUI();
		phaseControlPanel.nextTurn();
		closeShowInfo();
		closeShowControl();

		if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
			infoPlayer2Panel.setBackground(new Color(0, 0, 0, 0));
			infoPlayer1Panel.setBackground(Color.GREEN);
		}
		if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
			infoPlayer1Panel.setBackground(new Color(0, 0, 0, 0));
			infoPlayer2Panel.setBackground(Color.GREEN);
		}
	}

	// Hien thi cac nut dieu khien the
	public void showCardControl() {
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "On Hand") {
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
				MonsterCard monsterCard = (MonsterCard) getNewGame().getCurrentPlayer().getSelectedCard();
				if (monsterCard.getLevel() <= 4) {
					controlButton_1.setVisible(true);
					controlButton_1.setText("SUMMON ATTACK");
					controlButton_2.setVisible(true);
					controlButton_2.setText("SUMMON DEFENSE");
					return;
				}
				if (monsterCard.getLevel() > 4) {
					if (newGame.getCurrentPlayer().getTributeMonster1() == null) {
						controlButton_1.setVisible(true);
						controlButton_1.setText("TRIBUTE MONSTER 1");
						controlButton_2.setVisible(false);
					}
					if (newGame.getCurrentPlayer().getTributeMonster1() != null) {
						controlButton_2.setVisible(true);
						controlButton_2.setText("TRIBUTE MONSTER 2");
						controlButton_1.setVisible(false);
					}
					if (newGame.getCurrentPlayer().getTributeMonster1() != null
							&& newGame.getCurrentPlayer().getTributeMonster2() != null) {
						controlButton_1.setVisible(true);
						controlButton_1.setText("SUMMON ATTACK");
						controlButton_2.setVisible(true);
						controlButton_2.setText("SUMMON DEFENSE");
					}
				}
			}
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "SpellCard"
					|| getNewGame().getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				controlButton_1.setVisible(true);
				controlButton_1.setText("ACTIVATE");
				controlButton_2.setVisible(true);
				controlButton_2.setText("FACE DOWN");
				return;
			}
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard") {
				controlButton_1.setVisible(true);
				controlButton_1.setText("ACTIVATE");
				controlButton_2.setVisible(false);
				return;
			}

		}
		if (getNewGame().getCurrentPlayer().getSelectedCard().getLocation() == "On Field") {
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
				controlButton_1.setVisible(true);
				controlButton_1.setText("ATTACK");
				controlButton_2.setVisible(true);
				controlButton_2.setText("SWITCH MODE");
				return;
			}
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "SpellCard"
					|| getNewGame().getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				if (newGame.getCurrentPlayer().getSelectedCard().getFaceDown()) {
					controlButton_1.setVisible(true);
					controlButton_1.setText("ACTIVATE");
				} else {
					controlButton_1.setVisible(false);
				}
				controlButton_2.setVisible(false);
				return;
			}
			if (getNewGame().getCurrentPlayer().getSelectedCard().getType() == "FieldCard") {
				controlButton_1.setVisible(false);
				controlButton_2.setVisible(false);
				return;
			}

		}
	}

	// Triệu hồi (Giao diện)
	public void summonMonster_UI(JButton b) {
		MonsterCard monster = null;
		if (newGame.getCurrentPlayer().getSelectedCard() != null
				&& newGame.getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
			monster = (MonsterCard) newGame.getCurrentPlayer().getSelectedCard();
		} else
			return;

		// Exception summon
		if (b.getText() == "SUMMON ATTACK" || b.getText() == "SUMMON DEFENSE" || b.getText() == "TRIBUTE MONSTER 1"
				|| b.getText() == "TRIBUTE MONSTER 2") {
			if (newGame.getCurrentPlayer().getField().getPhase() != "MAIN 1"
					&& newGame.getCurrentPlayer().getField().getPhase() != "MAIN 2") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Only summon monsters in MAIN 1 or MAIN 2!");
				return;
			}
			if (cardLocationPanel.getSelectedFieldButton() != null) {
				if (cardLocationPanel.getSelectedFieldButton().getY() == cardLocationPanel.getSpellTrapFieldButton1()
							.get(0).getY() || cardLocationPanel.getSelectedFieldButton().getY() == cardLocationPanel.getSpellTrapFieldButton2()
							.get(0).getY()) {
					SoundEffects.exceptionSound();
					JOptionPane.showMessageDialog(null, "Cannot be summoned in spell trap field!");
					return;
				}
			}
		}

	if(newGame.getCurrentPlayer().getField().getPhase()=="MAIN 1"||newGame.getCurrentPlayer().getField().getPhase()=="MAIN 2")

	{
		JButton t = cardLocationPanel.getSelectedFieldButton();
		int index = 0;
		if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
			index = cardLocationPanel.getIndex(t, cardLocationPanel.getMonsterFieldButton1(), "SummonMonster");
			if (index == -1)
				return;
		}
		if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
			index = cardLocationPanel.getIndex(t, cardLocationPanel.getMonsterFieldButton2(), "SummonMonster");
			if (index == -1)
				return;
		}

		if (b.getText() == "TRIBUTE MONSTER 1" || b.getText() == "TRIBUTE MONSTER 2") {
			if (newGame.getCurrentPlayer().monsterCardCount(newGame.getCurrentPlayer().getField().getMonster()) <= 1) {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot be tribute when have less than 2 monsters!");
				return;
			}
			if (newGame.getCurrentPlayer().getField().getMonster().get(index) == null
					&& cardLocationPanel.getSelectedFieldButton() == null) {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Select field have monster to tribute!");
				return;
			}
		}

		if (b.getText() == "TRIBUTE MONSTER 1" && newGame.getCurrentPlayer()
				.monsterCardCount(newGame.getCurrentPlayer().getField().getMonster()) > 1) {
			if (newGame.getCurrentPlayer().getField().getMonster().get(index) != null
					&& newGame.getCurrentPlayer().getTributeMonster1() == null) {
				j = index;
				if (newGame.getCurrentPlayer().getTributeMonster2() != null) {
					int temp = j;
					j = k;
					k = temp;
				}
				newGame.getCurrentPlayer()
						.setTributeMonster1(newGame.getCurrentPlayer().getField().getMonster().get(index));
				cardLocationPanel.selectTributeMonster_UI(index);
				SoundEffects.clickSound();
			}
			if (newGame.getCurrentPlayer().getTributeMonster1() != null
					&& newGame.getCurrentPlayer().getTributeMonster2() != null) {
				showCardControl();
			}
			return;
		}
		if (b.getText() == "TRIBUTE MONSTER 2" && newGame.getCurrentPlayer()
				.monsterCardCount(newGame.getCurrentPlayer().getField().getMonster()) > 1) {
			if (newGame.getCurrentPlayer().getField().getMonster().get(index) != null
					&& newGame.getCurrentPlayer().getTributeMonster2() == null) {
				k = index;
				newGame.getCurrentPlayer()
						.setTributeMonster2(newGame.getCurrentPlayer().getField().getMonster().get(index));
				cardLocationPanel.selectTributeMonster_UI(index);
				SoundEffects.clickSound();
			}
			if (newGame.getCurrentPlayer().getTributeMonster1() != null
					&& newGame.getCurrentPlayer().getTributeMonster2() != null) {
				showCardControl();
			}
			return;
		}

		// Summon attack
		if (b.getText() == "SUMMON ATTACK") {
			// Normal summon
			if (!newGame.getCurrentPlayer().isNormalSummoned()
					&& newGame.getCurrentPlayer().getField().getMonster().get(index) == null
					&& monster.getLevel() <= 4) {
				newGame.getCurrentPlayer().summonMonster(monster, index, "ATTACK");
				SoundEffects.summonMonsterSound();
				cardLocationPanel.summon_UI(index, true);
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setATK();
				this.revalidate();
				this.repaint();
			}
			// Tribute summon
			if (monster.getLevel() > 4) {
				cardLocationPanel.addToGraveyard_UI(newGame.getCurrentPlayer(),
						newGame.getCurrentPlayer().getTributeMonster2());
				cardLocationPanel.setTributeMonsterButton1(null);
				cardLocationPanel.setTributeMonsterButton2(null);
				cardLocationPanel.removeTributeMonster_UI(j);
				cardLocationPanel.removeTributeMonster_UI(k);
				if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
					cardLocationPanel.getMonsterFieldButton1().get(j).setBounds(120 + j * 110, 450, 70, 100);
					cardLocationPanel.getMonsterFieldButton1().get(j).setIcon(null);
					cardLocationPanel.getMonsterFieldButton1().get(j).setBorder(new LineBorder(Color.RED, 0));
					cardLocationPanel.getMonsterFieldButton1().get(k).setBounds(120 + k * 110, 450, 70, 100);
					cardLocationPanel.getMonsterFieldButton1().get(k).setIcon(null);
					cardLocationPanel.getMonsterFieldButton1().get(k).setBorder(new LineBorder(Color.RED, 0));
				}
				if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
					cardLocationPanel.getMonsterFieldButton2().get(j).setBounds(120 + j * 110, 300, 70, 100);
					cardLocationPanel.getMonsterFieldButton2().get(j).setIcon(null);
					cardLocationPanel.getMonsterFieldButton2().get(j).setBorder(new LineBorder(Color.RED, 0));
					cardLocationPanel.getMonsterFieldButton2().get(k).setBounds(120 + k * 110, 300, 70, 100);
					cardLocationPanel.getMonsterFieldButton2().get(k).setIcon(null);
					cardLocationPanel.getMonsterFieldButton2().get(k).setBorder(new LineBorder(Color.RED, 0));
				}
				newGame.getCurrentPlayer().tributeSummon(monster, k, j, k, "ATTACK");
				SoundEffects.summonMonsterSound();
				cardLocationPanel.setSelectedFieldButton(null);
				cardLocationPanel.summon_UI(k, true);
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setATK();
				this.revalidate();
				this.repaint();
			}
			return;
		}

		// Summon defense
		if (b.getText() == "SUMMON DEFENSE") {
			// Normal summon
			if (!newGame.getCurrentPlayer().isNormalSummoned()
					&& newGame.getCurrentPlayer().getField().getMonster().get(index) == null
					&& monster.getLevel() <= 4) {
				newGame.getCurrentPlayer().summonMonster(monster, index, "DEFENSE");
				SoundEffects.summonMonsterSound();
				cardLocationPanel.summon_UI(index, false);
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setDEF();
				this.revalidate();
				this.repaint();
			}
			// Tribute summon
			if (monster.getLevel() > 4 && newGame.getCurrentPlayer()
					.monsterCardCount(newGame.getCurrentPlayer().getField().getMonster()) > 1) {
				cardLocationPanel.addToGraveyard_UI(newGame.getCurrentPlayer(),
						newGame.getCurrentPlayer().getTributeMonster2());
				cardLocationPanel.setTributeMonsterButton1(null);
				cardLocationPanel.setTributeMonsterButton2(null);
				cardLocationPanel.removeTributeMonster_UI(j);
				cardLocationPanel.removeTributeMonster_UI(k);
				if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
					cardLocationPanel.getMonsterFieldButton1().get(j).setBounds(120 + j * 110, 450, 70, 100);
					cardLocationPanel.getMonsterFieldButton1().get(j).setIcon(null);
					cardLocationPanel.getMonsterFieldButton1().get(j).setBorder(new LineBorder(Color.RED, 0));
					cardLocationPanel.getMonsterFieldButton1().get(k).setBounds(105 + k * 110, 465, 100, 70);
					cardLocationPanel.getMonsterFieldButton1().get(k).setIcon(null);
					cardLocationPanel.getMonsterFieldButton1().get(k).setBorder(new LineBorder(Color.RED, 0));
				}
				if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
					cardLocationPanel.getMonsterFieldButton2().get(j).setBounds(120 + j * 110, 300, 70, 100);
					cardLocationPanel.getMonsterFieldButton2().get(j).setIcon(null);
					cardLocationPanel.getMonsterFieldButton2().get(j).setBorder(new LineBorder(Color.RED, 0));
					cardLocationPanel.getMonsterFieldButton2().get(k).setBounds(105 + k * 110, 315, 100, 70);
					cardLocationPanel.getMonsterFieldButton2().get(k).setIcon(null);
					cardLocationPanel.getMonsterFieldButton2().get(k).setBorder(new LineBorder(Color.RED, 0));
				}
				newGame.getCurrentPlayer().tributeSummon(monster, k, j, k, "DEFENSE");
				SoundEffects.summonMonsterSound();
				cardLocationPanel.summon_UI(k, false);
				cardLocationPanel.removeCardInHandUI();
				cardInfoPanel.setDEF();
				this.revalidate();
				this.repaint();
			}
			return;
		}
	}
	}

	// Sử dụng thẻ bài môi truòng
	public void useField_UI() {
		FieldCard fieldCard = (FieldCard) this.getNewGame().getCurrentPlayer().getSelectedCard();
		if (getNewGame().getCurrentPlayer().getField().getField() != null) {
			cardLocationPanel.addToGraveyard_UI(getNewGame().getCurrentPlayer(),
					getNewGame().getCurrentPlayer().getField().getField());
		}
		this.getNewGame().getCurrentPlayer().setField(fieldCard);
		if (this.getNewGame().getCurrentPlayer() == this.getNewGame().getPlayer1()) {
			if (this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 1"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 2") {
				SoundEffects.activeEffectCardSound();
				cardLocationPanel
						.setFieldButton_1(this.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				battlePanel.setBgPlayerLabel_1(newGame.getCurrentPlayer().getSelectedCard());
				cardLocationPanel.removeCardInHandUI();
				this.revalidate();
				this.repaint();
			}
		}
		if (this.getNewGame().getCurrentPlayer() == this.getNewGame().getPlayer2()) {
			if (this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 1"
					|| this.getNewGame().getCurrentPlayer().getField().getPhase() == "MAIN 2") {
				SoundEffects.activeEffectCardSound();
				cardLocationPanel
						.setFieldButton_2(this.getNewGame().getCurrentPlayer().getSelectedCard().getImageSmall());
				battlePanel.setBgPlayerLabel_2(newGame.getCurrentPlayer().getSelectedCard());
				cardLocationPanel.removeCardInHandUI();
				this.revalidate();
				this.repaint();
			}
		}
	}

	// Activate spell or trap UI
	public void activateSpellTrap_UI(JButton b) {
		if (newGame.getCurrentPlayer().getSelectedCard() != null
				&& newGame.getCurrentPlayer().getSelectedCard().getType() == "FieldCard") {
			return;
		}

		// Exception activatee spell trap
		if (newGame.getCurrentPlayer().getField().getPhase() == "STANDBY"
				&& newGame.getCurrentPlayer().getSelectedCard().getLocation() == "On Hand") {
			if (newGame.getCurrentPlayer().getSelectedCard().getType() == "SpellCard"
					|| newGame.getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot activate spell or trap in STANDBY!");
				return;
			}
		}
		if (newGame.getCurrentPlayer().getField().getPhase() == "DRAW") {
			if (newGame.getCurrentPlayer().getSelectedCard().getType() == "SpellCard"
					|| newGame.getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot activate spell or trap in DRAW!");
				return;
			}
		}
		if (b.getText() == "ACTIVATE") {
			if (cardLocationPanel.getSelectedFieldButton() != null
					&& cardLocationPanel.getSelectedFieldButton().getY() != cardLocationPanel.getSpellTrapFieldButton1()
							.get(0).getY()
					&& cardLocationPanel.getSelectedFieldButton().getY() != cardLocationPanel.getSpellTrapFieldButton2()
							.get(0).getY()) {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot be activate in monster field!");
				return;
			}
		}

		if (newGame.getCurrentPlayer().getField().getPhase() == "STANDBY"
				|| newGame.getCurrentPlayer().getField().getPhase() == "MAIN 1"
				|| newGame.getCurrentPlayer().getField().getPhase() == "MAIN 2"
				|| newGame.getCurrentPlayer().getField().getPhase() == "BATTLE") {
			SpellCard spellCard = null;
			TrapCard trapCard = null;
			if (newGame.getCurrentPlayer().getSelectedCard() != null
					&& newGame.getCurrentPlayer().getSelectedCard().getType() == "SpellCard") {
				spellCard = (SpellCard) newGame.getCurrentPlayer().getSelectedCard();
			}
			if (newGame.getCurrentPlayer().getSelectedCard() != null
					&& newGame.getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				trapCard = (TrapCard) newGame.getCurrentPlayer().getSelectedCard();
			}
			JButton t = cardLocationPanel.getSelectedFieldButton();
			int index = 0;
			if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getSpellTrapFieldButton1(),
						"ActivateSpellTrap");
				if (index == -1)
					return;
			}
			if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getSpellTrapFieldButton2(),
						"ActivateSpellTrap");
				if (index == -1)
					return;
			}
			if (b.getText() == "ACTIVATE") {
				if (newGame.getCurrentPlayer().getField().getSpellTrap().get(index) == null
						&& newGame.getCurrentPlayer().getSelectedCard().getLocation() == "On Hand") {
					if (spellCard != null && trapCard == null) {
						newGame.getCurrentPlayer().activateSpell(spellCard, index, null, null);
					}
					if (spellCard == null && trapCard != null) {
						newGame.getCurrentPlayer().activateTrap(trapCard, index, null, null);
					}
					SoundEffects.activeEffectCardSound();
					cardLocationPanel.setSpellTrap_UI(index,
							newGame.getCurrentPlayer().getField().getSpellTrap().get(index).getFaceDown());
					cardLocationPanel.removeCardInHandUI();
					this.revalidate();
					this.repaint();
				}
				if (newGame.getCurrentPlayer().getField().getSpellTrap().get(index) != null
						&& newGame.getCurrentPlayer().getSelectedCard().getLocation() == "On Field") {
					if (spellCard != null && trapCard == null) {
						newGame.getCurrentPlayer().activateSpell(spellCard, index, null, null);
					}
					if (spellCard == null && trapCard != null) {
						newGame.getCurrentPlayer().activateTrap(trapCard, index, null, null);
					}
					SoundEffects.activeEffectCardSound();
					cardLocationPanel.setSpellTrap_UI(index,
							newGame.getCurrentPlayer().getField().getSpellTrap().get(index).getFaceDown());
					cardLocationPanel.removeCardInHandUI();
					newGame.getCurrentPlayer().getField().getSpellTrap().get(index).setFaceDown(false);
					this.revalidate();
					this.repaint();
				}
			}
			return;
		}

	}

	// Up bai
	public void faceDownSpellTrap_UI(JButton b) {

		// Face down exception
		if (b.getText() == "FACE DOWN") {
			if (cardLocationPanel.getSelectedFieldButton() != null
					&& cardLocationPanel.getSelectedFieldButton().getY() != cardLocationPanel.getSpellTrapFieldButton1()
							.get(0).getY()
					&& cardLocationPanel.getSelectedFieldButton().getY() != cardLocationPanel.getSpellTrapFieldButton2()
							.get(0).getY()) {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Cannot be face down in monster field!");
				return;
			}
			if (newGame.getCurrentPlayer().getField().getPhase() != "MAIN 1"
					&& newGame.getCurrentPlayer().getField().getPhase() != "MAIN 2") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Only face down in MAIN 1 or MAIN 2!");
				return;
			}
		}

		if (newGame.getCurrentPlayer().getField().getPhase() == "MAIN 1"
				|| newGame.getCurrentPlayer().getField().getPhase() == "MAIN 2") {
			SpellCard spellCard = null;
			TrapCard trapCard = null;
			if (newGame.getCurrentPlayer().getSelectedCard() != null
					&& newGame.getCurrentPlayer().getSelectedCard().getType() == "SpellCard") {
				spellCard = (SpellCard) newGame.getCurrentPlayer().getSelectedCard();
			}
			if (newGame.getCurrentPlayer().getSelectedCard() != null
					&& newGame.getCurrentPlayer().getSelectedCard().getType() == "TrapCard") {
				trapCard = (TrapCard) newGame.getCurrentPlayer().getSelectedCard();
			}
			JButton t = cardLocationPanel.getSelectedFieldButton();
			int index = 0;
			if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getSpellTrapFieldButton1(),
						"ActivateSpellTrap");
				if (index == -1)
					return;
			}
			if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getSpellTrapFieldButton2(),
						"ActivateSpellTrap");
				if (index == -1)
					return;
			}
			if (b.getText() == "FACE DOWN") {
				if (newGame.getCurrentPlayer().getField().getSpellTrap().get(index) == null) {
					if (spellCard != null && trapCard == null) {
						newGame.getCurrentPlayer().setSpellFaceDown(spellCard, index);
					}
					if (spellCard == null && trapCard != null) {
						newGame.getCurrentPlayer().setTrapFaceDown(trapCard, index);
					}
					SoundEffects.activeEffectCardSound();
					cardLocationPanel.setSpellTrap_UI(index,
							newGame.getCurrentPlayer().getField().getSpellTrap().get(index).getFaceDown());
					cardLocationPanel.removeCardInHandUI();
					this.revalidate();
					this.repaint();
				}
				return;
			}
		}
	}

	// Chuyển chế độ tấn công / phong thủ
	public void switchMonsterMode_UI(JButton b) {

		// Face down exception
		if (b.getText() == "SWITCH MODE") {
			if (newGame.getCurrentPlayer().getField().getPhase() != "MAIN 1"
					&& newGame.getCurrentPlayer().getField().getPhase() != "MAIN 2"
					&& newGame.getCurrentPlayer().getField().getPhase() != "BATTLE") {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Only switch mode in MAIN 1 or MAIN 2!");
				return;
			}
		}

		if (newGame.getCurrentPlayer().getField().getPhase() == "MAIN 1"
				|| newGame.getCurrentPlayer().getField().getPhase() == "MAIN 2"
				|| newGame.getCurrentPlayer().getField().getPhase() == "BATTLE") {
			MonsterCard monster;
			if (newGame.getCurrentPlayer().getSelectedCard() != null
					&& newGame.getCurrentPlayer().getSelectedCard().getType() == "MonsterCard") {
				monster = (MonsterCard) newGame.getCurrentPlayer().getSelectedCard();
			} else
				return;
			JButton t = cardLocationPanel.getSelectedFieldButton();
			int index = 0;
			if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getMonsterFieldButton1(), "SummonMonster");
				if (index == -1)
					return;
			}
			if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
				index = cardLocationPanel.getIndex(t, cardLocationPanel.getMonsterFieldButton2(), "SummonMonster");
				if (index == -1)
					return;
			}
			if (b.getText() == "SWITCH MODE") {
				if (monster.getSwitchedMode()) {
					SoundEffects.exceptionSound();
					JOptionPane.showMessageDialog(null, "Monster cannot switch mode twice in a turn");
					return;
				}
				if (monster.isAttacked()) {
					SoundEffects.exceptionSound();
					JOptionPane.showMessageDialog(null, "Monster cannot switch mode after attacked");
					return;
				}
				if (!monster.getSwitchedMode() && !monster.isAttacked()) {
					newGame.getCurrentPlayer().switchMonsterMode(monster);
					SoundEffects.summonMonsterSound();
					cardLocationPanel.switchMonsterMode_UI(index,
							newGame.getCurrentPlayer().getField().getMonster().get(index).getMode());
					if (newGame.getCurrentPlayer().getField().getMonster().get(index).getMode() == "ATTACK") {
						cardInfoPanel.setATK();
					}
					if (newGame.getCurrentPlayer().getField().getMonster().get(index).getMode() == "DEFENSE") {
						cardInfoPanel.setDEF();
					}
					this.revalidate();
					this.repaint();
				}
				return;
			}
		}
	}

	// Điều khiển tấn công
	public void monsterAttack_UI(JButton b) {
		int index = 0;
		if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
			index = cardLocationPanel.getIndex(cardLocationPanel.getSelectedFieldButton(),
					cardLocationPanel.getMonsterFieldButton1(), "MonsterAttack");
			if (index == -1)
				return;
		}
		if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
			index = cardLocationPanel.getIndex(cardLocationPanel.getSelectedFieldButton(),
					cardLocationPanel.getMonsterFieldButton2(), "MonsterAttack");
			if (index == -1)
				return;
		}
		int opponentIndex = 0;
		if (newGame.getCurrentPlayer() == newGame.getPlayer1()) {
			opponentIndex = cardLocationPanel.getIndex(cardLocationPanel.getSelectedOpponentButton(),
					cardLocationPanel.getMonsterFieldButton2(), "MonsterAttack");
		}
		if (newGame.getCurrentPlayer() == newGame.getPlayer2()) {
			opponentIndex = cardLocationPanel.getIndex(cardLocationPanel.getSelectedOpponentButton(),
					cardLocationPanel.getMonsterFieldButton1(), "MonsterAttack");
		}
		if (b.getText() == "ATTACK") {

			if (newGame.getCurrentPlayer().getField().getMonster().get(index).isAttacked()) {
				SoundEffects.exceptionSound();
				JOptionPane.showMessageDialog(null, "Monster cannot attack twice in a turn");
				return;
			}

			if (!newGame.getCurrentPlayer().getField().getMonster().get(index).isAttacked()) {
				int player1LP = newGame.getPlayer1().getLifepoints();
				int player2LP = newGame.getPlayer2().getLifepoints();
				newGame.getCurrentPlayer().attack(index, opponentIndex, newGame.getOpponentPlayer());
				if (player1LP != newGame.getPlayer1().getLifepoints()) {
					infoPlayer1Panel.getLifePointLabel().setText("LP: " + newGame.getPlayer1().getLifepoints());
					infoPlayer1Panel.getLifePointLabel().setForeground(Color.RED);
				}
				if (player2LP != newGame.getPlayer2().getLifepoints()) {
					infoPlayer2Panel.getLifePointLabel().setText("LP: " + newGame.getPlayer2().getLifepoints());
					infoPlayer2Panel.getLifePointLabel().setForeground(Color.RED);
				}
				if (newGame.getCurrentPlayer().getField().getMonster().get(index) == null) {
					cardLocationPanel.addToGraveyard_UI(newGame.getCurrentPlayer(),
							newGame.getCurrentPlayer().getSelectedCard());
				}
				if (opponentIndex >= 0 && newGame.getOpponentPlayer().getField().getMonster().get(opponentIndex) == null
						&& newGame.getCurrentPlayer().getSelectedOpponentCard() != null) {
					cardLocationPanel.addToGraveyard_UI(newGame.getOpponentPlayer(),
							newGame.getCurrentPlayer().getSelectedOpponentCard());
				}
				cardLocationPanel.removeMonster_UI(newGame.getOpponentPlayer());
				setWinner_UI(newGame.getCurrentWinner());
				newGame.getCurrentPlayer().setSelectedCard(null);
				newGame.getCurrentPlayer().setSelectedOpponentCard(null);
				cardLocationPanel.getSelectedFieldButton().setBorder(null);
				cardLocationPanel.setSelectedFieldButton(null);
				cardLocationPanel.setSelectedOpponentButton(null);
				closeShowInfo();
				closeShowControl();
				this.revalidate();
				this.repaint();
			}
			return;
		}
	}

	public void setWinner_UI(Player winner) {
		if (winner != null) {

			long hours = ((newGame.getStartTime()) / (1000 * 60 * 60)) % 24;
			long minutes = ((newGame.getStartTime()) / (1000 * 60)) % 60;
			long seconds = ((newGame.getStartTime()) / 1000) % 60;
			GameDAO.getInstance().insert(hours + ":" + minutes + ":" + seconds, countingTimeThread.getTime(),
					newGame.getPlayer1().getPlayerName(), newGame.getPlayer2().getPlayerName(), newGame.getTurn(),
					newGame.getCurrentWinner().getPlayerName());

			cardLocationPanel.setEnabled1(false);

			this.repaint();
			this.revalidate();

			if (winner == newGame.getPlayer1()) {
				winnerPanel.getAvatarLabel().setIcon(new ImageIcon(GUI.class.getResource("/image/AvatarYugi.png")));
			}
			if (winner == newGame.getPlayer2()) {
				winnerPanel.getAvatarLabel().setIcon(new ImageIcon(GUI.class.getResource("/image/AvatarKaiba.png")));
			}
			winnerPanel.getNameLabel().setText(winner.getPlayerName());
			winnerPanel.setVisible(true);

			playBackgroundMusicThread.stopMusic();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SoundEffects.winnerSound();
		}
	}

	public void soundControl() {
		if (SoundEffects.getIsON()) {
			playBackgroundMusicThread.stopMusic();
			SoundEffects.setIsON(false);
			musicButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Sound Off.jpg")));
			return;
		}
		if (!SoundEffects.getIsON()) {
			playBackgroundMusicThread.continueMusic();
			SoundEffects.setIsON(true);
			musicButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Sound On.jpg")));
			return;
		}
	}

	public void pauseGame() {
		if (isPause) {
			isPause = !isPause;
			cardLocationPanel.setEnabled1(true);
			pauseButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Resume.jpg")));
			pauseGamePanel.setVisible(false);
			SoundEffects.nextPhaseSound();
			countingTimeThread.resume1();
			
			return;
		}
		if (!isPause) {
			isPause = !isPause;
			cardLocationPanel.setEnabled1(false);
			pauseButton.setIcon(new ImageIcon(GUI.class.getResource("/image/Pause.jpg")));
			pauseGamePanel.setVisible(true);
			SoundEffects.nextPhaseSound();
			countingTimeThread.pause1();
			return;
		}
	}

}
