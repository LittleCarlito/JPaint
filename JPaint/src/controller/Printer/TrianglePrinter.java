package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.interfaces.IShape;

public class TrianglePrinter extends ShapePrinter{
	private int[] xDimensions = new int[3];
	private int[] yDimensions = new int[3];

	public TrianglePrinter(IShape newShape, Graphics2D baseGraphics) {
		super(newShape, baseGraphics);
	}

	public void print() {
		setDimensions();
		ShapeShadingType sType = getShade();
		if(sType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillPolygon(xDimensions, yDimensions, 3);
		}
		else if(sType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawPolygon(xDimensions, yDimensions, 3);
		}
	}

	private void setDimensions() {
		int x = getOrigin().getX();
		int y = getOrigin().getY();
		int sWidth = getWidth();
		int sHeight = getHeight();
		xDimensions[0] = x;
		xDimensions[1] = x + (sWidth / 2);
		xDimensions[2] = x + sWidth;
		yDimensions[0] = y + sHeight;
		yDimensions[1] = y;
		yDimensions[2] = y + sHeight;
	}
}