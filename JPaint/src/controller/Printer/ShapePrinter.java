package controller.Printer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public abstract class ShapePrinter implements IPrinter {
	private PaintCanvasBase canvas;
	private Color color;
	private Color color2;
	private ShapeShadingType shade;
	private Point origin;
	private int width;
	private int height;
	
	public ShapePrinter(IShape shape, PaintCanvasBase newCanvas) {
		canvas = newCanvas;
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
	
	protected PaintCanvasBase getCanvas() {
		return canvas;
	}

	protected Color getPrimaryColor() {
		return color;
	}
	
	protected Color getSecondaryColor() {
		return color2;
	}
}
