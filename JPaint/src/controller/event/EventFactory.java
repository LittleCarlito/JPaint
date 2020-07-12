package controller.event;

import controller.Printer.PointConverter;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.Shape;
import model.StartAndEndPointMode;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class EventFactory{
	
	public EventFactory() {
	}
	
	public static IMouseEvent getEvent(Point startPoint, Point endPoint, PaintCanvasBase baseCanvas, ApplicationState baseState){
		PointConverter.getInstance();
		Point origin = PointConverter.getOrigin(startPoint, endPoint);
		int[] dimensions = PointConverter.getDimension(startPoint, endPoint);
		IShape newShape = new Shape(baseState.getActiveShapeType(), baseState.getActivePrimaryColor(), baseState.getActiveSecondaryColor(), baseState.getActiveShapeShadingType(), origin, dimensions[0], dimensions[1]);
		if (baseState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
			return new DrawEvent(newShape, baseCanvas);
		}
		else if (baseState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			return new SelectEvent(newShape, baseCanvas);
		}
		else if (baseState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			return new MoveEvent(startPoint, endPoint, baseCanvas);
		}
		else {
			//Add more cases here as they are required
			return null;
		}
	}

}
