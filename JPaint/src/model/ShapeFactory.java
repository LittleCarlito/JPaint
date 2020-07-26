package model;

import controller.Printer.PrinterFactory;
import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory {
	private static IPrinter sPrinter;
	private static int sid = 0;

	private ShapeFactory() {		
	}
	
	public static IShape getRectangle(ApplicationState state, PaintCanvasBase canvas, Point origin, int[] dimensions) {
		sPrinter = PrinterFactory.getRectanglePrinter(canvas);
		ApplicationState newState = state;
		newState.setActiveShadingType(ShapeShadingType.SELECTED);
		return getShape(state, origin, dimensions);
	}
	
	public static IShape getEllipse(ApplicationState state, PaintCanvasBase canvas, Point origin, int[] dimensions) {
		sPrinter = PrinterFactory.getEllipsePrinter(canvas);
		return getShape(state, origin, dimensions);
	}
	
	public static IShape getTriangle(ApplicationState state, PaintCanvasBase canvas, Point origin, int[] dimensions) {
		sPrinter = PrinterFactory.getTrianglePrinter(canvas);
		return getShape(state, origin, dimensions);
	}
	
	private static IShape getShape(ApplicationState state, Point origin, int[] dimensions) {
		IShape newShape = new Shape(sid, sPrinter, state.getActiveShapeType(), state.getActivePrimaryColor(), state.getActiveSecondaryColor(), state.getActiveShapeShadingType(), origin, dimensions[0], dimensions[1]);
		sid++;
		return newShape;
	}
}
