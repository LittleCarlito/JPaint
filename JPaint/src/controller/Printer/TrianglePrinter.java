package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.interfaces.IPrinter;
import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class TrianglePrinter implements IPrinter{
	private PaintCanvasBase canvas;

	public TrianglePrinter(PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
	}

	public void print(IShape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		ColorConverter.getInstance();
		graphics2d.setColor(ColorConverter.getColor(shape.getColor()));
		ShapeShadingType shadeType = shape.getShade();
		PointConverter.getInstance();
		int[][] dimensions = PointConverter.getTriangle(shape.getOrigin(), shape.getWidth(), shape.getHeight());
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillPolygon(dimensions[0], dimensions[1], 3);
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawPolygon(dimensions[0], dimensions[1], 3);
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			int[][] dimensions2 = PointConverter.getTriangle(new Point(shape.getOrigin().getX() - 1, shape.getOrigin().getY() - 1), shape.getWidth() - 2, shape.getHeight() - 2);
			graphics2d.fillPolygon(dimensions2[0], dimensions2[1], 3);
			graphics2d.setColor(ColorConverter.getColor(shape.getSecondColor()));
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.drawPolygon(dimensions2[0], dimensions2[1], 3);
		}
	}
}