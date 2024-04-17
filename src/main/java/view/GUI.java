package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import controller.CloseGameListener;

import javax.swing.border.CompoundBorder;
import javax.swing.JButton;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private BattlePanel battlePanel;
	private CardInfoPanel cardInfoPanel;
	private PhaseControlPanel phaseControlPanel;
	private CardLocationPanel cardLocationPanel;
	private JLabel timeLabel;
	private JButton closeGameButton;
	private InfoPlayerPanel infoPlayer1Panel;
	private InfoPlayerPanel infoPlayer2Panel;

	public GUI() {
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
		
		cardLocationPanel = new CardLocationPanel();
		cardLocationPanel.setLocation(28, 7);
		getContentPane().add(cardLocationPanel);
		
		closeGameButton = new JButton("");
		closeGameButton.setIcon(new ImageIcon(GUI.class.getResource("/view/resources/Close Game.jpg")));
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
		battlePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5),
				new LineBorder(new Color(0, 255, 255), 5)));
		battlePanel.setLocation(408, 197);
		getContentPane().add(battlePanel);
		
		cardInfoPanel = new CardInfoPanel();
		cardInfoPanel.setLocation(18, 67);
		cardInfoPanel.setVisible(true);
		getContentPane().add(cardInfoPanel);
		
		phaseControlPanel = new PhaseControlPanel();
		phaseControlPanel.setLocation(1202, 222);
		getContentPane().add(phaseControlPanel);
		
		infoPlayer1Panel = new InfoPlayerPanel();
		infoPlayer1Panel.setLocation(1176, 714);
		getContentPane().add(infoPlayer1Panel);
		
		infoPlayer2Panel = new InfoPlayerPanel();
		infoPlayer2Panel.setLocation(1176, 0);
		getContentPane().add(infoPlayer2Panel);

		JLabel backgroundLabel = new JLabel("");

		backgroundLabel.setIcon(new ImageIcon(GUI.class.getResource("/view/resources/Background.jpg")));

		backgroundLabel.setBounds(0, 0, 1536, 864);
		getContentPane().add(backgroundLabel);
	}
}
