package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.event.handlers.CommandHistory;
import controller.interfaces.IMouseEvent;
import model.Point;
import model.handlers.IShapeManager;
import model.interfaces.IDrawable;

public class MoveEvent implements IMouseEvent{
	private Point _startPoint;
	private Point _endPoint;
	private List<IDrawable> moveList;
	
	public MoveEvent(Point startPoint, Point endPoint) {
		_startPoint = startPoint;
		_endPoint = endPoint;
		moveList = new ArrayList<IDrawable>();
	}

	@Override
	public void execute() {
		for(IDrawable drawObject : IShapeManager.getSelect()) {
			moveList.add(drawObject);
		}
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
		for(IDrawable drawObject : moveList) {
			moveDimension = new Point((startPoint.getX() - endPoint.getX()), (startPoint.getY() - endPoint.getY()));
			drawObject.move(moveDimension);
		}
	}
}
