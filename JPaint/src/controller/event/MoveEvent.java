package controller.event;

import controller.interfaces.IMouseEvent;
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
		IMouseEvent mCommand = new MoveCommand(_shapeManager.getSelect(), _startPoint, _endPoint);
		mCommand.execute();
		_shapeManager.print();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		IMouseEvent mCommand = new MoveCommand(_shapeManager.getSelect(), _endPoint, _startPoint);
		mCommand.execute();
		_shapeManager.print();
	}

	@Override
	public void redo() {
		execute();
	}
}
