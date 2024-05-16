package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import controller.EndPhaseListener;

public class PhaseControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GUI gui;
	private JLabel drawPhaseLabel;
	private JLabel standbyPhaseLabel;
	private JLabel mainPhase1Label;
	private JLabel battlePhaseLabel;
	private JLabel mainPhase2Label;
	private JLabel turnLabel;
	private JButton endPhaseButton;

	public PhaseControlPanel(GUI gui) {
		this.gui = gui;
		this.init();
	}

	private void init() {
		this.setBackground(new Color(0, 0, 0, 0));
		this.setSize(260, 420);
		setLayout(null);

		EndPhaseListener endPhaseListener = new EndPhaseListener(gui);

		drawPhaseLabel = new JLabel("DRAW");
		drawPhaseLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		drawPhaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drawPhaseLabel.setOpaque(true);
		drawPhaseLabel.setBackground(new Color(200, 200, 0));
		drawPhaseLabel.setBounds(5, 65, 190, 50);
		drawPhaseLabel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		add(drawPhaseLabel);

		standbyPhaseLabel = new JLabel("STANDBY");
		standbyPhaseLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		standbyPhaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		standbyPhaseLabel.setOpaque(true);
		standbyPhaseLabel.setBackground(new Color(200, 200, 0));
		standbyPhaseLabel.setBounds(5, 125, 190, 50);
		standbyPhaseLabel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		add(standbyPhaseLabel);

		mainPhase1Label = new JLabel("MAIN 1");
		mainPhase1Label.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		mainPhase1Label.setHorizontalAlignment(SwingConstants.CENTER);
		mainPhase1Label.setOpaque(true);
		mainPhase1Label.setBackground(new Color(200, 200, 0));
		mainPhase1Label.setBounds(5, 185, 190, 50);
		mainPhase1Label.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		add(mainPhase1Label);

		battlePhaseLabel = new JLabel("BATTLE");
		battlePhaseLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		battlePhaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		battlePhaseLabel.setOpaque(true);
		battlePhaseLabel.setBackground(new Color(200, 200, 0));
		battlePhaseLabel.setBounds(5, 245, 190, 50);
		battlePhaseLabel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		add(battlePhaseLabel);

		mainPhase2Label = new JLabel("MAIN 2");
		mainPhase2Label.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		mainPhase2Label.setHorizontalAlignment(SwingConstants.CENTER);
		mainPhase2Label.setOpaque(true);
		mainPhase2Label.setBackground(new Color(255, 255, 0));
		mainPhase2Label.setBounds(5, 305, 190, 50);
		mainPhase2Label.setBorder(new CompoundBorder(new LineBorder(new Color(0, 206, 209), 2),
				new LineBorder(new Color(0, 255, 255), 3)));
		add(mainPhase2Label);

		turnLabel = new JLabel("TURN : 1");
		turnLabel.setForeground(new Color(224, 255, 255));
		turnLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		turnLabel.setBackground(new Color(0, 0, 0, 200));
		turnLabel.setOpaque(true);
		turnLabel.setBounds(5, 5, 250, 50);
		turnLabel.setBorder(
				new CompoundBorder(new LineBorder(new Color(165, 42, 42), 2), new LineBorder(new Color(255, 0, 0), 3)));
		add(turnLabel);

		JLabel phaseLabel = new JLabel("");
		phaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phaseLabel.setIcon(new ImageIcon(GUI.class.getResource("/image/PhaseBg.jpg")));
		phaseLabel.setOpaque(true);
		phaseLabel.setBounds(205, 65, 50, 290);
		phaseLabel.setBorder(new CompoundBorder(new LineBorder(new Color(165, 42, 42), 2), new LineBorder(new Color(255, 0, 0), 3)));
		add(phaseLabel);

		endPhaseButton = new JButton("END TURN");
		endPhaseButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		endPhaseButton.setBackground(Color.LIGHT_GRAY);
		endPhaseButton.setOpaque(true);
		endPhaseButton.setBounds(5, 365, 250, 50);
		endPhaseButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(165, 42, 42), 2), new LineBorder(new Color(255, 0, 0), 3)));
		endPhaseButton.setFocusPainted(false);
		endPhaseButton.addMouseListener(endPhaseListener);
		add(endPhaseButton);
	}

	public void nextPhase(String phase) {
		if (phase == "DRAW") {
			endPhaseButton.setText("END PHASE");
			mainPhase2Label.setBackground(new Color(200, 200, 0));
			drawPhaseLabel.setBackground(new Color(255, 255, 0));
		} else if (phase == "STANDBY") {
			drawPhaseLabel.setBackground(new Color(200, 200, 0));
			standbyPhaseLabel.setBackground(new Color(255, 255, 0));
		} else if (phase == "MAIN 1") {
			standbyPhaseLabel.setBackground(new Color(200, 200, 0));
			mainPhase1Label.setBackground(new Color(255, 255, 0));
		} else if (phase == "BATTLE") {
			mainPhase1Label.setBackground(new Color(200, 200, 0));
			battlePhaseLabel.setBackground(new Color(255, 255, 0));
		} else if (phase == "MAIN 2") {
			battlePhaseLabel.setBackground(new Color(200, 200, 0));
			mainPhase2Label.setBackground(new Color(255, 255, 0));
			endPhaseButton.setText("END TURN");
		}
	}

	public void nextTurn() {
		turnLabel.setText("TURN : " + gui.getNewGame().getTurn());
	}

}
