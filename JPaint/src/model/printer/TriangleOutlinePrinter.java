package model.printer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

import controller.interfaces.IPrinter;
import controller.singletons.PointConverter;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class TriangleOutlinePrinter implements IPrinter {
	private PaintCanvasBase canvas;

	public TriangleOutlinePrinter(PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
	}

	@Override
	public void print(IShape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		PointConverter.getInstance();
		int[][] dimensions = PointConverter.getTriangle(shape.getOrigin(), shape.getWidth(), shape.getHeight());
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.drawPolygon(dimensions[0], dimensions[1], 3);
	}

	@Override
	public PaintCanvasBase getCanvas() {
		return canvas;
	}
}
