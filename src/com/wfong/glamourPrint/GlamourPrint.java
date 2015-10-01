/**
 * 
 */
package com.wfong.glamourPrint;

/**
 * @author William
 * This class handles colored output to Terminal
 */
public class GlamourPrint {
	
	public static String colorString(String color, String baseString) {
		return findColor(color) + baseString + findColor("reset");
	}
	
	//Define Helper Methods
	public static String goodString(String baseString) {
		return colorString("green", baseString);
	}
	
	public static String badString(String baseString) {
		return colorString("red", baseString);
	}
	
	private static String findColor(String color) {
		//Setup temporary variable that is lowercase for easy comparing
		String comparingStr = color.toLowerCase();
		switch (comparingStr) {
		case "reset":
			return Color.ANSI_RESET.getColor();
		case "black":
			return Color.ANSI_BLACK.getColor();
		case "red":
			return Color.ANSI_RED.getColor();
		case "green":
			return Color.ANSI_GREEN.getColor();
		case "yellow":
			return Color.ANSI_YELLOW.getColor();
		case "blue":
			return Color.ANSI_BLUE.getColor();
		case "purple":
			return Color.ANSI_PURPLE.getColor();
		case "cyan":
			return Color.ANSI_CYAN.getColor();
		case "white":
			return Color.ANSI_WHITE.getColor();
		default:
			return "";
		}
	}
}
