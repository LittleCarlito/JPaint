package model;

import controller.Printer.EllipsePrinter;
import controller.Printer.RectanglePrinter;
import controller.Printer.TrianglePrinter;
import controller.interfaces.IPrinter;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory {
	private static int sid = 0;

	private ShapeFactory() {		
	}
	
	public static IShape getShape(ApplicationState state, PaintCanvasBase canvas, Point origin, int[] dimensions) {
		IPrinter sPrinter = null;
		if(state.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
			sPrinter = new RectanglePrinter(canvas);
		}
		else if(state.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
			sPrinter = new EllipsePrinter(canvas);
		}
		else if(state.getActiveShapeType().equals(ShapeType.TRIANGLE)) {
			sPrinter = new TrianglePrinter(canvas);
		}
		IShape newShape = new Shape(sid, sPrinter, state.getActiveShapeType(), state.getActivePrimaryColor(), state.getActiveSecondaryColor(), state.getActiveShapeShadingType(), origin, dimensions[0], dimensions[1]);
		sid++;
		return newShape;
	}
}
