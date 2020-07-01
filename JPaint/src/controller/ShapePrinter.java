package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapePrinter implements IPrinter{
	private PaintCanvasBase paintCanvas;
	
	public ShapePrinter(PaintCanvasBase baseCanvas) {
		paintCanvas = baseCanvas;
	}

	public void print() {
		ShapeList<IShape> shapeList = paintCanvas.getShapes();
		for (IShape shape : shapeList) {
			ShapeType sType = shape.getType();
			ShapeColor sColor = shape.getColor();
			Point sOrigin = shape.getOrigin();
			int sWidth = shape.getWidth();
			int sHeight = shape.getHeight();
			Color currC;
			try {
				Field field = Class.forName("java.awt.Color").getField(sColor.toString());
				currC = (Color) field.get(null);
			} catch (Exception e2) {
				currC = null; // Not defined
			}
			Graphics2D graphics2d = paintCanvas.getGraphics2D();
			graphics2d.setColor(currC);
			//Actual case example for when we have more shape types
//			if (sType.equals(ShapeType.RECTANGLE)) {
			if (sType.equals(ShapeType.ELLIPSE)) {
				graphics2d.fillOval(sOrigin.getX(), sOrigin.getY(), sWidth, sHeight);
			}
			else if(sType.equals(ShapeType.RECTANGLE)) {
				graphics2d.fillRect(sOrigin.getX(), sOrigin.getY(), sWidth, sHeight);
			}
		}
	}
}
