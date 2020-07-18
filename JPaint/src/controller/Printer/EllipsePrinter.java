package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.interfaces.IPrinter;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class EllipsePrinter implements IPrinter{
	private PaintCanvasBase canvas;
	
	public EllipsePrinter(PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
	}

	@Override
	public void print(IShape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		// Set primary color
		ColorConverter.getInstance();
		graphics2d.setColor(ColorConverter.getColor(shape.getColor()));
		ShapeShadingType shadeType = shape.getShade();
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillOval(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawOval(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			graphics2d.fillOval(shape.getOrigin().getX() - 1, shape.getOrigin().getY() - 1, shape.getWidth() - 2, shape.getHeight() - 2);
			graphics2d.setColor(ColorConverter.getColor(shape.getSecondColor()));
			graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawOval(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
	}

}