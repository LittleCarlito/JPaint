package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

import model.Point;
import model.ShapeColor;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapePrinter implements IPrinter{
	private PaintCanvasBase paintCanvas;
	
	public ShapePrinter(PaintCanvasBase baseCanvas) {
		paintCanvas = baseCanvas;
	}

	@Override
	public void draw(IShape Shape) {
		ShapeColor sColor = Shape.getColor();
		Point sOrigin = Shape.getOrigin();
		int sWidth = Shape.getWidth();
		int sHeight = Shape.getHeight();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		Color currC;
		try {
		    Field field = Class.forName("java.awt.Color").getField(sColor.toString());
		    currC = (Color)field.get(null);
		} catch (Exception e2) {
		    currC = null; // Not defined
		}
		graphics2d.setColor(currC);
        graphics2d.fillRect(sOrigin.getX(), sOrigin.getY(), sWidth, sHeight);
	}
	
}
