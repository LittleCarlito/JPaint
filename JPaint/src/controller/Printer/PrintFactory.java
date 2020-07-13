package controller.Printer;


import java.awt.Graphics2D;
import java.util.List;

import controller.interfaces.IPrinter;
import model.ShapeType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class PrintFactory implements IPrinter{
	private PaintCanvasBase paintCanvas;
	
	public PrintFactory(PaintCanvasBase baseCanvas) {
		paintCanvas = baseCanvas;
	}

	public void print() {
		System.out.println("Within PrintFactory\nCount of shapeList: " + paintCanvas.getShapes().size() + "\nCount of selectList: " + paintCanvas.getSelect().size() + "\n");
		screenOutput(paintCanvas.getShapes());
		screenOutput(paintCanvas.getSelect());
	}
	
	private void screenOutput(List<IShape> shapeList) {
		for (IShape shape : shapeList) {
			Graphics2D graphics2d = paintCanvas.getGraphics2D();
			ShapeType sType = shape.getType();
			if (sType.equals(ShapeType.ELLIPSE)) {
				IPrinter ellipsePrinter = new EllipsePrinter(shape, graphics2d);
				ellipsePrinter.print();
			}
			else if(sType.equals(ShapeType.RECTANGLE)) {
				IPrinter rectanglePrinter = new RectanglePrinter(shape, graphics2d);
				rectanglePrinter.print();
			}
			else if(sType.equals(ShapeType.TRIANGLE)) {
				IPrinter trianglePrinter = new TrianglePrinter(shape, graphics2d);
				trianglePrinter.print();
			}
		}
	}
}
