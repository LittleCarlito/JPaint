package controller.event;

import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.Point;

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
		shapeManager.print();
	}

}
