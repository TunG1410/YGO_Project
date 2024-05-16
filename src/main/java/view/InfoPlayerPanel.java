package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class InfoPlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lifePointLabel;
	private JLabel playerNameLabel;
	private JLabel avartarLabel;

	public InfoPlayerPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(350, 140);
		setLayout(null);

		avartarLabel = new JLabel("");
		avartarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avartarLabel.setBackground(new Color(255, 0, 0));
		avartarLabel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		avartarLabel.setOpaque(true);
		avartarLabel.setBounds(225, 5, 130, 130);
		add(avartarLabel);

		playerNameLabel = new JLabel("");
		playerNameLabel.setForeground(new Color(0, 255, 255));
		playerNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerNameLabel.setBackground(new Color(0, 0, 0, 150));
		playerNameLabel.setBorder(new MatteBorder(0, 3, 3, 0, (Color) Color.MAGENTA));
		playerNameLabel.setOpaque(true);
		playerNameLabel.setBounds(55, 75, 170, 50);
		add(playerNameLabel);

		lifePointLabel = new JLabel("LP: 8000");
		lifePointLabel.setForeground(Color.YELLOW);
		lifePointLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lifePointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lifePointLabel.setBackground(Color.DARK_GRAY);
		lifePointLabel.setBorder(new LineBorder(Color.YELLOW, 5, true));
		lifePointLabel.setOpaque(true);
		lifePointLabel.setBounds(5, 5, 220, 70);
		add(lifePointLabel);
	}

	public JLabel getPlayerNameLabel() {
		return playerNameLabel;
	}

	public JLabel getAvartarLabel() {
		return avartarLabel;
	}

	public JLabel getLifePointLabel() {
		return lifePointLabel;
	}

}
