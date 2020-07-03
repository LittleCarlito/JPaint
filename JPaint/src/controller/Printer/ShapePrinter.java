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
	private Color color2;
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
		ShapeColor sColor2 = shape.getSecondColor();
		shade = shape.getShade();
		ColorConverter.getInstance();
		color = ColorConverter.getColor(sColor);
		color2 = ColorConverter.getColor(sColor2);
	}
	
	protected void setPrimaryColor() {
		graphics2d.setColor(color);
	}
	
	protected void setSecondaryColor() {
		graphics2d.setColor(color2);
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
