package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CardInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public CardInfoPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setLayout(null);
		this.setSize(370, 730);

		JLabel infoCardLabel = new JLabel("");
		infoCardLabel.setBackground(new Color(128, 255, 255));
		infoCardLabel.setBounds(10, 15, 350, 510);
		infoCardLabel.setOpaque(true);
		add(infoCardLabel);

		JLabel ATK_CardLabel = new JLabel("ATK / 1000");
		ATK_CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ATK_CardLabel.setBackground(new Color(255, 0, 0));
		ATK_CardLabel.setBounds(10, 530, 170, 40);
		ATK_CardLabel.setOpaque(true);
		add(ATK_CardLabel);

		JLabel DEF_CardLabel = new JLabel("DEF / 1000");
		DEF_CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DEF_CardLabel.setBackground(new Color(255, 255, 0));
		DEF_CardLabel.setBounds(190, 530, 170, 40);
		DEF_CardLabel.setOpaque(true);
		add(DEF_CardLabel);

		JButton attackButton = new JButton("ATTACK");
		attackButton.setBounds(105, 595, 160, 60);
		attackButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(attackButton);
		
		JButton useButton = new JButton("USE");
		useButton.setBounds(105, 595, 160, 60);
		useButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(useButton);

		JButton switchModeButton = new JButton("SWITCH MODE");
		switchModeButton.setBounds(55, 665, 260, 60);
		switchModeButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(switchModeButton);

		JLabel backgroundInfoCardLabel = new JLabel("");
		backgroundInfoCardLabel.setBackground(new Color(0, 255, 64));
		backgroundInfoCardLabel.setOpaque(true);
		backgroundInfoCardLabel.setBounds(0, 0, 370, 585);
		add(backgroundInfoCardLabel);
	}
}
