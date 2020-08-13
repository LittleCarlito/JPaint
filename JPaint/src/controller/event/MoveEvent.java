package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.Point;
import model.interfaces.IDrawable;

public class MoveEvent implements IMouseEvent{
	private Point _startPoint;
	private Point _endPoint;
	
	public MoveEvent(Point startPoint, Point endPoint) {
		_startPoint = startPoint;
		_endPoint = endPoint;
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		moveShapes(_startPoint, _endPoint);
		IShapeManager.print();
	}

	@Override
	public void undo() {
		moveShapes(_endPoint, _startPoint);
		IShapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}
	
	private void moveShapes(Point startPoint, Point endPoint) {
		Point moveDimension;
		for(IDrawable drawObject : IShapeManager.getSelect()) {
			moveDimension = new Point((startPoint.getX() - endPoint.getX()), (startPoint.getY() - endPoint.getY()));
			drawObject.move(moveDimension);
		}
	}
}
