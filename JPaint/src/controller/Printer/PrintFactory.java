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
		List<IShape> shapeList = paintCanvas.getShapes();
		List<IShape> selectList = paintCanvas.getSelect();
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		for (IShape shape : shapeList) {
			//Print the object based on its ShapeType
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
		for (IShape shape : selectList) {
			//Print the object based on its ShapeType
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
