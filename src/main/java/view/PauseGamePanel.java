package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PauseGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public PauseGamePanel() {
		this.init();
	}

	private void init() {
		this.setSize(250, 100);
		this.setLayout(null);
		
		JLabel pauseLabel = new JLabel("PAUSED");
		pauseLabel.setForeground(new Color(255, 0, 0));
		pauseLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pauseLabel.setBounds(0, 0, 250, 60);
		add(pauseLabel);
		
		JLabel mesResumeLabel = new JLabel("Press again to resume!");
		mesResumeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		mesResumeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mesResumeLabel.setBounds(0, 60, 250, 40);
		add(mesResumeLabel);
	}
}
