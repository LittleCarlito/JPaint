package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.Point;
import workSpace.IDrawable;

public class MoveEvent implements IMouseEvent{
	private Point _startPoint;
	private Point _endPoint;
	private IShapeManager _shapeManager;
	
	public MoveEvent(Point startPoint, Point endPoint, IShapeManager shapeManager) {
		_startPoint = startPoint;
		_endPoint = endPoint;
		_shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		moveShapes(_startPoint, _endPoint);
		_shapeManager.print();
//		IMouseEvent mCommand = new MoveCommand(shapeManager.getSelect(), startPoint, endPoint);
//		mCommand.execute();
//		shapeManager.print();
	}

	@Override
	public void undo() {
		moveShapes(_endPoint, _startPoint);
		_shapeManager.print();
//		IMouseEvent mCommand = new MoveCommand(shapeManager.getSelect(), endPoint, startPoint);
//		mCommand.execute();
//		shapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}
	
	private void moveShapes(Point startPoint, Point endPoint) {
		Point moveDimension;
		for(IDrawable drawObject : _shapeManager.getSelect()) {
			moveDimension = new Point((startPoint.getX() - endPoint.getX()), (startPoint.getY() - endPoint.getY()));
			drawObject.move(moveDimension);
		}
//		Point newOrigin = new Point(shape.getOrigin().getX() - (startPoint.getX() - endPoint.getX()),shape.getOrigin().getY() - (startPoint.getY() - endPoint.getY()));
//		IShape newShape = shape.getCloneAt(newOrigin);
//		newShape.setSelect();
//		shapeList.set(shapeList.indexOf(shape), newShape);
	}
}
