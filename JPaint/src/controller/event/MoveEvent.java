package controller.event;

import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
import controller.singletons.CanvasClear;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.Point;
import model.interfaces.IShape;

public class MoveEvent implements IMouseEvent{
	private Point startPoint;
	private Point endPoint;
	private IShapeManager shapeManager;
	
	public MoveEvent(Point startPoint, Point endPoint, IShapeManager shapeManager) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeManager = shapeManager;
	}

	public void execute() {
		IShapeCommand mCommand = new MoveCommand(shapeManager.getSelect(), startPoint, endPoint);
		ListOutput.execute(shapeManager.getSelect(), mCommand);
		CanvasClear.clear();
		ListOutput.execute(shapeManager.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(shapeManager.getSelect(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(shapeManager.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
