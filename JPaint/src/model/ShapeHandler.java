package model;

import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.printer.PrinterHandler;
import view.interfaces.PaintCanvasBase;

public class ShapeHandler {
	
	public ShapeHandler() {
	}
	
	public static IShape getShape(ShapeType newType, ShapeColor newColor, ShapeColor newSecondColor, ShapeShadingType newShade, Point origin, int[] dimensions, PaintCanvasBase canvas) {
		IShape newShape = ShapeFactory.getShapeWithId(newType, newColor, newSecondColor, newShade, origin, dimensions);
		IPrinter newPrinter = PrinterHandler.getPrinter(newShape, canvas);
		newShape.setPrinter(newPrinter);
		Point outlineOrigin = new Point(origin.getX() - 5, origin.getY() - 5);
		int outlineWidth = dimensions[0] + 10;
		int outlineHeight = dimensions[1] + 10;
		IShape outline = ShapeFactory.getShape(newType, ShapeColor.BLACK, newSecondColor, newShade, outlineOrigin, new int[] {outlineWidth, outlineHeight});
		outline.setPrinter(PrinterHandler.getOutliner(outline, canvas));
		newShape.setOutline(outline);
		return newShape;
	}
	
	public static IShape completeShape(IShape shape, IPrinter printer) {
		shape.setPrinter(printer);
		Point outlineOrigin = new Point(shape.getOrigin().getX() - 5, shape.getOrigin().getY() - 5);
		int outlineWidth = shape.getWidth() + 10;
		int outlineHeight = shape.getHeight() + 10;
		IShape outline = ShapeFactory.getShape(shape.getType(), ShapeColor.BLACK, shape.getSecondColor(), shape.getShade(), outlineOrigin, new int[] {outlineWidth, outlineHeight});
		outline.setPrinter(PrinterHandler.getOutliner(outline, printer.getCanvas()));
		shape.setOutline(outline);
		return shape;
	}
}
