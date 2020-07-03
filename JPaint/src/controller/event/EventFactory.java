package controller.event;

import controller.Printer.PointConverter;
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
	private ShapeColor eventSecondShapeColor;
	private ShapeShadingType eventShadeType;
	private StartAndEndPointMode eventMode;
	
	public EventFactory(Point baseStartPoint, Point baseEndPoint, PaintCanvasBase baseCanvas, ApplicationState baseState) {
		startPoint = baseStartPoint;
		endPoint = baseEndPoint;
		eventCanvas = baseCanvas;
		eventShapeType = baseState.getActiveShapeType();
		eventShapeColor = baseState.getActivePrimaryColor();
		eventSecondShapeColor = baseState.getActiveSecondaryColor();
		eventShadeType = baseState.getActiveShapeShadingType();
		eventMode = baseState.getActiveStartAndEndPointMode();
	}
	
	@Override
	public IMouseEvent getEvent(){
		if (eventMode.equals(StartAndEndPointMode.DRAW)) {
			PointConverter.getInstance();
			Point origin = PointConverter.getOrigin(startPoint, endPoint);
			int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
			IShape newShape = new Shape(eventShapeType, eventShapeColor, eventSecondShapeColor, eventShadeType, origin, dimensions[0], dimensions[1]);
			return new DrawEvent(newShape, eventCanvas);
		}
		else {
			//Add more cases here as they are required
			return null;
		}
	}

}
