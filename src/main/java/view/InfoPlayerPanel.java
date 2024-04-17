package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public InfoPlayerPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(360, 150);
		setLayout(null);

		JLabel avartarLabel = new JLabel("");
		avartarLabel.setBackground(new Color(255, 0, 0));
		avartarLabel.setOpaque(true);
		avartarLabel.setBounds(230, 10, 130, 130);
		add(avartarLabel);

		JLabel playerNameLabel = new JLabel("Player 2");
		playerNameLabel.setBackground(new Color(0, 255, 255));
		playerNameLabel.setOpaque(true);
		playerNameLabel.setBounds(10, 80, 220, 60);
		add(playerNameLabel);

		JLabel lifePointLabel = new JLabel("LP: 8000");
		lifePointLabel.setBackground(new Color(0, 255, 64));
		lifePointLabel.setOpaque(true);
		lifePointLabel.setBounds(10, 10, 220, 70);
		add(lifePointLabel);
	}

}
