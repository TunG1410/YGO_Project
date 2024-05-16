package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Color;

public class WinnerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel avatarLabel;
	private JLabel nameLabel;

	public WinnerPanel() {
		this.init();
	}

	private void init() {
		this.setSize(500, 334);
		this.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 5),
				new LineBorder(new Color(0, 255, 255), 5)));
		this.setLayout(null);

		JLabel winnerLabel = new JLabel("WINNER");
		winnerLabel.setForeground(new Color(255, 255, 0));
		winnerLabel.setBackground(new Color(0, 0, 0, 0));
		winnerLabel.setOpaque(true);
		winnerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setBounds(70, 20, 360, 80);
		add(winnerLabel);

		avatarLabel = new JLabel("");
		avatarLabel.setBackground(new Color(0, 0, 0, 0));
		avatarLabel.setOpaque(true);
		avatarLabel.setBounds(185, 120, 130, 130);
		add(avatarLabel);

		nameLabel = new JLabel("");
		nameLabel.setForeground(new Color(0, 255, 255));
		nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		nameLabel.setBackground(new Color(0, 0, 0, 0));
		nameLabel.setOpaque(true);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(165, 260, 170, 50);
		add(nameLabel);

		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 500, 334);
		bgLabel.setIcon(new ImageIcon(GUI.class.getResource("/image/Winner Background.gif")));
		add(bgLabel);
	}

	public JLabel getAvatarLabel() {
		return avatarLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

}
