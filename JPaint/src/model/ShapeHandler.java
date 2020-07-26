package model;

import controller.Printer.PrinterFactory;
import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeHandler {
	
	public ShapeHandler() {
	}
	
	public static IShape getShape(ApplicationState state, PaintCanvasBase canvas, Point origin, int[] dimensions) {
		IShape newShape = null;
		if(state.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
			newShape = ShapeFactory.getRectangle(state, canvas, origin, dimensions);
		}
		else if(state.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
			newShape = ShapeFactory.getEllipse(state, canvas, origin, dimensions);
		}
		else if(state.getActiveShapeType().equals(ShapeType.TRIANGLE)) {
			newShape = ShapeFactory.getTriangle(state, canvas, origin, dimensions);
		}
		return newShape;
	}
	
	public static IPrinter getPrinter(ShapeType sType, PaintCanvasBase canvas) {
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
}
