package controller.event;

import controller.Printer.OutputFactory;
import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
import model.Point;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class MoveEvent implements IMouseEvent{
	private Point startPoint;
	private Point endPoint;
	private PaintCanvasBase canvas;
	
	public MoveEvent(Point newStartPoint, Point newEndPoint, PaintCanvasBase newEventCanvas) {
		startPoint = newStartPoint;
		endPoint = newEndPoint;
		canvas = newEventCanvas;
	}

	public void Execute() {
		canvas.clear();
		IShapeCommand mCommand = new MoveCommand(canvas, startPoint, endPoint);
		OutputFactory.execute(canvas.getSelect(), mCommand);
		OutputFactory.execute(canvas.getShapes(), ((IShape shape) -> {shape.print();}));
		OutputFactory.execute(canvas.getSelect(), ((IShape shape) -> {shape.print();}));
	}

}
