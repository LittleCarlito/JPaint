package event;

import model.Point;
import model.ShapeFactory;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory{
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase eventCanvas;
	private ApplicationState appState;
	
	public EventFactory(Point baseStartPoint, Point baseEndPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		startPoint = baseStartPoint;
		endPoint = baseEndPoint;
		eventCanvas = baseCanvas;
		appState = baseState;
	}
	public IMouseEvent getEvent() {
		//Gonna set up to just do DrawEvents for now
		if(!appState.getActiveStartAndEndPointMode().equals(null)) {
			int minX = Math.min(startPoint.getX(), endPoint.getX());
			int maxX = Math.max(startPoint.getX(), endPoint.getX());
			int minY = Math.min(startPoint.getY(), endPoint.getY());
			int maxY = Math.max(startPoint.getY(), endPoint.getY());
			Point origin = new Point(minX, minY);
			int width = maxX - minX;
			int height = maxY - minY;
			IShape newShape = new ShapeFactory(appState.getActivePrimaryColor(), appState.getActiveShapeType(), origin, width, height).getShape();
			return new DrawEvent(newShape, eventCanvas);
		}
		return null;
	}

}
