package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.Point;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class TrianglePrinter extends ShapePrinter{

	public TrianglePrinter(IShape newShape, PaintCanvasBase baseCanvas) {
		super(newShape, baseCanvas);
	}

	public void print() {
		Graphics2D graphics2d = this.getCanvas().getGraphics2D();
		graphics2d.setColor(this.getPrimaryColor());
		ShapeShadingType shadeType = getShade();
		PointConverter.getInstance();
		int[][] dimensions = PointConverter.getTriangle(getOrigin(), getWidth(), getHeight());
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillPolygon(dimensions[0], dimensions[1], 3);
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawPolygon(dimensions[0], dimensions[1], 3);
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			int[][] dimensions2 = PointConverter.getTriangle(new Point(getOrigin().getX() - 1, getOrigin().getY() - 1), getWidth() - 2, getHeight() - 2);
			graphics2d.fillPolygon(dimensions2[0], dimensions2[1], 3);
			graphics2d.setColor(this.getSecondaryColor());
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.drawPolygon(dimensions2[0], dimensions2[1], 3);
		}
	}
}