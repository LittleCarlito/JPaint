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
			//Get each shapes attributes
			ShapeType sType = shape.getType();
			ShapeColor sColor = shape.getColor();
			Point sOrigin = shape.getOrigin();
			int sWidth = shape.getWidth();
			int sHeight = shape.getHeight();
			//Transfer from enum to Color class
			Color currC;
			try {
				Field field = Class.forName("java.awt.Color").getField(sColor.toString());
				currC = (Color) field.get(null);
			} catch (Exception e2) {
				currC = null; // Not defined
			}
			//Print the object based on its ShapeType
			Graphics2D graphics2d = paintCanvas.getGraphics2D();
			graphics2d.setColor(currC);
			if (sType.equals(ShapeType.ELLIPSE)) {
				graphics2d.fillOval(sOrigin.getX(), sOrigin.getY(), sWidth, sHeight);
			}
			else if(sType.equals(ShapeType.RECTANGLE)) {
				graphics2d.fillRect(sOrigin.getX(), sOrigin.getY(), sWidth, sHeight);
			}
			else if(sType.equals(ShapeType.TRIANGLE)) {
				int[] xDimensions = new int[3];
				int[] yDimensions = new int[3];
				//Get x dimensions for triangle
				xDimensions[0] = sOrigin.getX();
				xDimensions[1] = sOrigin.getX() + (sWidth / 2);
				xDimensions[2] = sOrigin.getX() + sWidth;
				//Get y dimensions for triangle
				yDimensions[0] = sOrigin.getY() + sHeight;
				yDimensions[1] = sOrigin.getY();
				yDimensions[2] = sOrigin.getY() + sHeight;
				graphics2d.fillPolygon(xDimensions, yDimensions, 3);
			}
		}
	}
}
