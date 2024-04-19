package model;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FinalValues {
	private static Color noColor = new Color(0, 0, 0, 0);
	private static Border noBorder = new LineBorder(new Color(0, 0, 0, 0), 5);
	private static Border highLightBorder = new LineBorder(new Color(0, 0, 0, 0), 5);

	public static Color getNoColor() {
		return noColor;
	}

	public static Border getNoBorder() {
		return noBorder;
	}

	public static Border getHighLightBorder() {
		return highLightBorder;
	}

}
