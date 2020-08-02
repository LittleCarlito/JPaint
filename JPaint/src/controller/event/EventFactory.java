package controller.event;

import controller.interfaces.IMouseEvent;
import controller.singletons.PointConverter;
import model.Point;
import model.ShapeHandler;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory{
	private static IShape eventShape;
	
	private EventFactory() {
	}
	
	public static IMouseEvent getDraw(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		getEventShape(startPoint, endPoint, baseCanvas, baseState);
		return new DrawEvent(eventShape, baseCanvas);
	}
	
	public static IMouseEvent getSelect(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		getEventShape(startPoint, endPoint, baseCanvas, baseState);
		return new SelectEvent(eventShape, baseCanvas);
	}
	
	public static IMouseEvent getMove(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		return new MoveEvent(startPoint, endPoint, baseCanvas);
	}
	
	private static void getEventShape(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		// Get shape details
		PointConverter.getInstance();
		Point origin = PointConverter.getOrigin(startPoint, endPoint);
		int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
		// Create shape
		IShape newShape = ShapeHandler.getShape(baseState.getActiveShapeType(), baseState.getActivePrimaryColor(), baseState.getActiveSecondaryColor(), baseState.getActiveShapeShadingType(), origin, dimensions, baseCanvas);
		eventShape = newShape;
	}
}
