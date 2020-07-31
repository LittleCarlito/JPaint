package controller.event;

import controller.Printer.ListOutput;
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

	public void execute() {
		canvas.clear();
		IShapeCommand mCommand = new MoveCommand(canvas.getSelect(), startPoint, endPoint);
		ListOutput.execute(canvas.getSelect(), mCommand);
		ListOutput.execute(canvas.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(canvas.getSelect(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(canvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
