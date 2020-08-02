package controller.event;

import java.util.List;

import controller.interfaces.IShapeCommand;
import model.Point;
import model.interfaces.IShape;

public class MoveCommand implements IShapeCommand {
	private List<IShape> _shapeList;
	private Point _startPoint;
	private Point _endPoint;
	
	public MoveCommand(List<IShape> shapeList, Point startPoint, Point endPoint) {
		_shapeList = shapeList;
		_startPoint = startPoint;
		_endPoint = endPoint;
	}
	
	@Override
	public void execute(IShape shape) {
		Point newOrigin = new Point(shape.getOrigin().getX() - (_startPoint.getX() - _endPoint.getX()), shape.getOrigin().getY() - (_startPoint.getY() - _endPoint.getY()));
		IShape newShape = shape.getClone(shape.getColor(), shape.getShade(), newOrigin, shape.getWidth(), shape.getHeight());
		_shapeList.set(_shapeList.indexOf(shape), newShape);
	}

}
