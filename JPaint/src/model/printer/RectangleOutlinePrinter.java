package model.printer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IPrinter;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class RectangleOutlinePrinter implements IPrinter {
	private PaintCanvasBase canvas;
	
	public RectangleOutlinePrinter(PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
	}

	@Override
	public void print(IShape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.drawRect(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
	}

	@Override
	public PaintCanvasBase getCanvas() {
		return canvas;
	}

}
