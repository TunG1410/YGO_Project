package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PhaseControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public PhaseControlPanel() {
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(260, 420);
		setLayout(null);
		
		JLabel drawPhaseLabel_1 = new JLabel("");
		drawPhaseLabel_1.setOpaque(true);
		drawPhaseLabel_1.setBackground(new Color(0, 255, 255));
		drawPhaseLabel_1.setBounds(5, 65, 190, 50);
		add(drawPhaseLabel_1);
		
		JLabel standbyPhaseLabel_1 = new JLabel("");
		standbyPhaseLabel_1.setOpaque(true);
		standbyPhaseLabel_1.setBackground(new Color(0, 255, 255));
		standbyPhaseLabel_1.setBounds(5, 125, 190, 50);
		add(standbyPhaseLabel_1);
		
		JLabel mainPhase1Label_1 = new JLabel("");
		mainPhase1Label_1.setOpaque(true);
		mainPhase1Label_1.setBackground(new Color(0, 255, 255));
		mainPhase1Label_1.setBounds(5, 185, 190, 50);
		add(mainPhase1Label_1);
		
		JLabel battlePhaseLabel_1 = new JLabel("");
		battlePhaseLabel_1.setOpaque(true);
		battlePhaseLabel_1.setBackground(new Color(0, 255, 255));
		battlePhaseLabel_1.setBounds(5, 245, 190, 50);
		add(battlePhaseLabel_1);
		
		JLabel mainPhase2Label_1 = new JLabel("New label");
		mainPhase2Label_1.setOpaque(true);
		mainPhase2Label_1.setBackground(Color.CYAN);
		mainPhase2Label_1.setBounds(5, 305, 190, 50);
		add(mainPhase2Label_1);
		
		JLabel turnLabel = new JLabel("New label");
		turnLabel.setBackground(new Color(255, 0, 0));
		turnLabel.setOpaque(true);
		turnLabel.setBounds(5, 5, 250, 50);
		add(turnLabel);
		
		JLabel drawPhaseLabel = new JLabel("");
		drawPhaseLabel.setBackground(new Color(255, 0, 0));
		drawPhaseLabel.setOpaque(true);
		drawPhaseLabel.setBounds(0, 60, 200, 60);
		add(drawPhaseLabel);
		
		JLabel standbyPhaseLabel = new JLabel("");
		standbyPhaseLabel.setBackground(new Color(255, 0, 0));
		standbyPhaseLabel.setOpaque(true);
		standbyPhaseLabel.setBounds(0, 120, 200, 60);
		add(standbyPhaseLabel);
		
		JLabel mainPhase1Label = new JLabel("");
		mainPhase1Label.setBackground(new Color(255, 0, 0));
		mainPhase1Label.setOpaque(true);
		mainPhase1Label.setBounds(0, 180, 200, 60);
		add(mainPhase1Label);
		
		JLabel battlePhaseLabel = new JLabel("");
		battlePhaseLabel.setBackground(new Color(255, 0, 0));
		battlePhaseLabel.setOpaque(true);
		battlePhaseLabel.setBounds(0, 240, 200, 60);
		add(battlePhaseLabel);
		
		JLabel mainPhase2Label = new JLabel("");
		mainPhase2Label.setBackground(new Color(255, 0, 0));
		mainPhase2Label.setOpaque(true);
		mainPhase2Label.setBounds(0, 300, 200, 60);
		add(mainPhase2Label);
		
		JLabel phaseLabel = new JLabel("New label");
		phaseLabel.setBackground(new Color(0, 255, 64));
		phaseLabel.setOpaque(true);
		phaseLabel.setBounds(205, 65, 50, 290);
		add(phaseLabel);
		
		JButton nextPhaseButton = new JButton("New button");
		nextPhaseButton.setBounds(5, 365, 250, 50);
		add(nextPhaseButton);
		
	}
}
