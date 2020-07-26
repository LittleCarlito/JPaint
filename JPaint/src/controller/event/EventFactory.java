package controller.event;

import controller.Printer.PointConverter;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.ShapeHandler;
import model.StartAndEndPointMode;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory{
	private static IShape eventShape;
	
	private EventFactory() {
	}
	
	public static IMouseEvent getEvent(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState){
		// Get shape details
		PointConverter.getInstance();
		Point origin = PointConverter.getOrigin(startPoint, endPoint);
		int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
		// Create shape
		IShape newShape = ShapeHandler.getShape(baseState, baseCanvas, origin, dimensions);
		// Determine event type
		StartAndEndPointMode eventMode = baseState.getActiveStartAndEndPointMode();
		if (eventMode.equals(StartAndEndPointMode.DRAW)) {
			return new DrawEvent(newShape, baseCanvas);
		}
		else if (eventMode.equals(StartAndEndPointMode.SELECT)) {
			return new SelectEvent(newShape, baseCanvas);
		}
		else if (eventMode.equals(StartAndEndPointMode.MOVE)) {
			return new MoveEvent(startPoint, endPoint, baseCanvas);
		}
		else {
			//Add more cases here as they are required
			return null;
		}
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
		eventShape = ShapeHandler.getShape(baseState, baseCanvas, origin, dimensions);
	}
}
