package controller.event;

import controller.interfaces.IEventFactory;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.Shape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory implements IEventFactory{
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase eventCanvas;
	private ShapeType eventShapeType;
	private ShapeColor eventShapeColor;
	private ShapeShadingType eventShadeType;
	private StartAndEndPointMode eventMode;
	
	public EventFactory(Point baseStartPoint, Point baseEndPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		startPoint = baseStartPoint;
		endPoint = baseEndPoint;
		eventCanvas = baseCanvas;
		eventShapeType = baseState.getActiveShapeType();
		eventShapeColor = baseState.getActivePrimaryColor();
		eventShadeType = baseState.getActiveShapeShadingType();
		eventMode = baseState.getActiveStartAndEndPointMode();
	}
	
	@Override
	public IMouseEvent getEvent(){
		if (eventMode.equals(StartAndEndPointMode.DRAW)) {
			int minX = Math.min(startPoint.getX(), endPoint.getX());
			int maxX = Math.max(startPoint.getX(), endPoint.getX());
			int minY = Math.min(startPoint.getY(), endPoint.getY());
			int maxY = Math.max(startPoint.getY(), endPoint.getY());
			Point origin = new Point(minX, minY);
			int width = maxX - minX;
			int height = maxY - minY;
			IShape newShape = new Shape(eventShapeType, eventShapeColor, eventShadeType, origin, width, height);
			return new DrawEvent(newShape, eventCanvas);
		}
		else {
			//Add more cases here as they are required
			return null;
		}
	}

}
