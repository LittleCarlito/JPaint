package model;

import controller.Printer.PrinterFactory;
import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapeHandler {
	
	public ShapeHandler() {
	}
	
	public static IShape getShape(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions) {
		IShape newShape = null;
		if(newType.equals(ShapeType.RECTANGLE)) {
			newShape = ShapeFactory.getRectangle(newType, newColor, newSecondColor, newShade, origin, dimensions);
		}
		else if(newType.equals(ShapeType.ELLIPSE)) {
			newShape = ShapeFactory.getEllipse(newType, newColor, newSecondColor, newShade, origin, dimensions);
		}
		else if(newType.equals(ShapeType.TRIANGLE)) {
			newShape = ShapeFactory.getTriangle(newType, newColor, newSecondColor, newShade, origin, dimensions);
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
	
	public static IPrinter getOutliner(ShapeType sType, PaintCanvasBase canvas) {
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
	
	public static IShape getCopy(IShape shape) {
		return ShapeHandler.getShape(shape.getType(), shape.getColor(), shape.getSecondColor(), shape.getShade(), shape.getOrigin(), new int[] {shape.getWidth(), shape.getHeight()});
	}
}
