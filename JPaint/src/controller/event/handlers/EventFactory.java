package controller.event.handlers;

import controller.event.DrawEvent;
import controller.event.MoveEvent;
import controller.event.SelectEvent;
import controller.interfaces.IMouseEvent;
import controller.singletons.PointConverter;
import model.Point;
import model.handlers.ShapeFactory;
import model.handlers.ShapeHandler;
import model.interfaces.IDrawable;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory{
	private static IDrawable eventShape;
	private static IShape selectShape;
	
	private EventFactory() {
	}
	
	public static IMouseEvent getDraw(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		getEventShape(startPoint, endPoint, baseCanvas, baseState);
//		return new DrawEvent(eventShape, baseCanvas.getShapeManager());
		return new DrawEvent(eventShape);

	}
	
	public static IMouseEvent getSelect(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		getSelectShape(startPoint, endPoint, baseCanvas, baseState);
//		return new SelectEvent(selectShape, baseCanvas.getShapeManager());
		return new SelectEvent(selectShape);

	}
	
	public static IMouseEvent getMove(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
//		return new MoveEvent(startPoint, endPoint, baseCanvas.getShapeManager());
		return new MoveEvent(startPoint, endPoint);

	}
	
	private static void getEventShape(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		// Get shape details
		PointConverter.getInstance();
		Point origin = PointConverter.getOrigin(startPoint, endPoint);
		int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
		// Create shape
		eventShape = ShapeHandler.getGroup(baseState.getActiveShapeType(), baseState.getActivePrimaryColor(), baseState.getActiveSecondaryColor(), baseState.getActiveShapeShadingType(), origin, dimensions, baseCanvas);
	}
	
	private static void getSelectShape(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		// Get shape details
		PointConverter.getInstance();
		Point origin = PointConverter.getOrigin(startPoint, endPoint);
		int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
		// Create shape
		selectShape = ShapeFactory.getShape(999999, baseState.getActiveShapeType(), baseState.getActivePrimaryColor(), baseState.getActiveSecondaryColor(), baseState.getActiveShapeShadingType(), origin, dimensions);
	}
}
