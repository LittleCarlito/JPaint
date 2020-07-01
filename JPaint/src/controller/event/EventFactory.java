package controller.event;

import controller.interfaces.IEventFactory;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.ShapeColor;
import model.ShapeFactory;
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
	private StartAndEndPointMode eventMode;
	
	public EventFactory(Point baseStartPoint, Point baseEndPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		startPoint = baseStartPoint;
		endPoint = baseEndPoint;
		eventCanvas = baseCanvas;
		eventShapeType = baseState.getActiveShapeType();
		eventShapeColor = baseState.getActivePrimaryColor();
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
			IShape newShape = new ShapeFactory(eventShapeType, eventShapeColor, origin, width, height).getShape();
			return new DrawEvent(newShape, eventCanvas);
		}
		else {
			//Add more cases here as they are required
			return null;
		}
	}

}
