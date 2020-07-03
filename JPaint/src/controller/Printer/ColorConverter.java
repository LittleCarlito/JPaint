package controller.Printer;

import java.awt.Color;
import java.lang.reflect.Field;

import model.ShapeColor;

public class ColorConverter {
	private static final ColorConverter INSTANCE = new ColorConverter();
	
	private ColorConverter() {}
	
	public static ColorConverter getInstance() {
		return INSTANCE;
	}
	
	public static Color getColor(ShapeColor sColor) {
		Color currC;
		try {
			Field field = Class.forName("java.awt.Color").getField(sColor.toString());
			currC = (Color) field.get(null);
		} catch (Exception e2) {
			currC = null; // Not defined
		}
		return currC;
	}
}
