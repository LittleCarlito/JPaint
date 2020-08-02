package controller.Printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

import controller.interfaces.IPrinter;
import model.ShapeShadingType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class RectanglePrinter implements IPrinter{
	private PaintCanvasBase canvas;
	
	public RectanglePrinter(PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
	}

	@Override
	public void print(IShape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		ColorConverter.getInstance();
		graphics2d.setColor(ColorConverter.getColor(shape.getColor()));
		ShapeShadingType shadeType = shape.getShade();
		if(shadeType.equals(ShapeShadingType.FILLED_IN)) {
			graphics2d.fillRect(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE)) {
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawRect(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			graphics2d.fillRect(shape.getOrigin().getX() - 1, shape.getOrigin().getY() - 1, shape.getWidth() - 2, shape.getHeight() - 2);
			graphics2d.setColor(ColorConverter.getColor(shape.getSecondColor()));
			graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.drawRect(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
		else if(shadeType.equals(ShapeShadingType.SELECTED)) {
	        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
	        graphics2d.setStroke(stroke);
	        graphics2d.drawRect(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		}
	}

}
