package model.handlers;

import model.ShapeType;
import model.interfaces.IPrinter;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class PrinterHandler {
	
	public static IPrinter getPrinter(IShape shape, PaintCanvasBase canvas) {
		ShapeType sType = shape.getType();
		IPrinter newPrinter = null;
		if(sType.equals(ShapeType.RECTANGLE)) {
			newPrinter = PrinterFactory.getRectanglePrinter(canvas);
		}
		else if(sType.equals(ShapeType.ELLIPSE)) {
			newPrinter = PrinterFactory.getEllipsePrinter(canvas);
		}
		else if(sType.equals(ShapeType.TRIANGLE)) {
			newPrinter = PrinterFactory.getTrianglePrinter(canvas);
		}
		return newPrinter;
	}
	
	public static IPrinter getOutliner(IShape shape, PaintCanvasBase canvas) {
		ShapeType sType = shape.getType();
		IPrinter newPrinter = null;
		if(sType.equals(ShapeType.RECTANGLE)) {
			newPrinter = PrinterFactory.getRectangleOutlinePrinter(canvas);
		}
		else if(sType.equals(ShapeType.ELLIPSE)) {
			newPrinter = PrinterFactory.getEllipseOutlinePrinter(canvas);
		}
		else if(sType.equals(ShapeType.TRIANGLE)) {
			newPrinter = PrinterFactory.getTriangleOutlinePrinter(canvas);
		}
		return newPrinter;
	}
}
