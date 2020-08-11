package controller.event;

import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.Point;

public class MoveEvent implements IMouseEvent{
	private Point _startPoint;
	private Point _endPoint;
	private IShapeManager _shapeManager;
	
	public MoveEvent(Point startPoint, Point endPoint, IShapeManager shapeManager) {
		_startPoint = startPoint;
		_endPoint = endPoint;
		_shapeManager = shapeManager;
	}

	public void execute() {
		move(_startPoint, _endPoint);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		move(_endPoint, _startPoint);
	}

	@Override
	public void redo() {
		execute();
	}

	private void move(Point startPoint, Point endPoint) {
		IShapeCommand mCommand = new MoveCommand(_shapeManager.getSelect(), startPoint, endPoint);
		ListOutput.execute(_shapeManager.getSelect(), mCommand);
		_shapeManager.print();
	}
}
