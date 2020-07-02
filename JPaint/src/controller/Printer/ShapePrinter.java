package controller.Printer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IShape;

public abstract class ShapePrinter implements IPrinter {
	protected Graphics2D graphics2d;
	private Color color;
	private ShapeShadingType shade;
	private Point origin;
	private int width;
	private int height;
	
	public ShapePrinter(IShape shape, Graphics2D baseGraphics) {
		graphics2d = baseGraphics;
		origin = shape.getOrigin();
		width = shape.getWidth();
		height = shape.getHeight();
		ShapeColor sColor = shape.getColor();
		shade = shape.getShade();
		Color currC;
		try {
			Field field = Class.forName("java.awt.Color").getField(sColor.toString());
			currC = (Color) field.get(null);
		} catch (Exception e2) {
			currC = null; // Not defined
		}
		color = currC;
	}
	
	protected void setColor() {
		graphics2d.setColor(color);
	}
	
	protected ShapeShadingType getShade() {
		return shade;
	}
	
	protected Point getOrigin() {
		return origin;
	}


	protected int getWidth() {
		return width;
	}


	protected int getHeight() {
		return height;
	}

}
