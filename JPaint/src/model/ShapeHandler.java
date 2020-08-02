package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.printer.PrinterFactory;
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
	
	public static IShape getOutliner(IShape shape, IPrinter printer) {
		PaintCanvasBase canvas = printer.getCanvas();
		ShapeType sType = shape.getType();
		Point outlineOrigin = new Point(shape.getOrigin().getX() - 5, shape.getOrigin().getY() - 5);
		int outlineWidth = shape.getWidth() + 10;
		int outlineHeight = shape.getHeight() + 10;
		IShape sOutline = getShape(sType, ShapeColor.BLACK, shape.getSecondColor(), shape.getShade(), outlineOrigin, new int[] {outlineWidth, outlineHeight});
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
		sOutline.setPrinter(newPrinter);
		return sOutline;		
	}
	
	public static IShape getCopy(IShape shape) {
		return ShapeHandler.getShape(shape.getType(), shape.getColor(), shape.getSecondColor(), shape.getShade(), shape.getOrigin(), new int[] {shape.getWidth(), shape.getHeight()});
	}
}
