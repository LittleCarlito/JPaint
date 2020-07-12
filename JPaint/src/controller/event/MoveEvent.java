package controller.event;

import java.util.List;

import controller.Printer.PrintFactory;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class MoveEvent implements IMouseEvent{
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase eventCanvas;
	private List<IShape> selectShapeList;
	
	public MoveEvent(Point newStartPoint, Point newEndPoint, PaintCanvasBase newEventCanvas) {
		startPoint = newStartPoint;
		endPoint = newEndPoint;
		eventCanvas = newEventCanvas;
		selectShapeList = eventCanvas.getSelect();
	}

	public void Execute() {
		for(int i = 0; i < selectShapeList.size(); i++) {
			IShape shape = selectShapeList.get(i);
			Point newOrigin = new Point(shape.getOrigin().getX() - (startPoint.getX() - endPoint.getX()), shape.getOrigin().getY() - (startPoint.getY() - endPoint.getY()));
			IShape newShape = shape.getClone(newOrigin);
			selectShapeList.set(i, newShape);
			PrintFactory eventPrinter = new PrintFactory(eventCanvas);
			eventPrinter.print();
		}
	}

}
