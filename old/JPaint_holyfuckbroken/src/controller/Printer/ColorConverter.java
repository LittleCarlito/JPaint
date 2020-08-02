package controller.Printer;

import java.awt.Color;
import java.lang.reflect.Field;

import model.ShapeColor;

public class ColorConverter {
	private static ColorConverter obj = null;
	
	private ColorConverter() {}
	
	public static ColorConverter getInstance() {
		if(obj == null) {
			obj = new ColorConverter();
		}
		return obj;
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
