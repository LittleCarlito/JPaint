package controller.event;

import java.util.List;

import controller.interfaces.IShapeCommand;
import model.Point;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements IShapeCommand {
	private List<IShape> _shapeList;
	private Point _startPoint;
	private Point _endPoint;
	
	public MoveCommand(PaintCanvasBase canvas, Point startPoint, Point endPoint) {
		_shapeList = canvas.getSelect();
		_startPoint = startPoint;
		_endPoint = endPoint;
	}
	
	@Override
	public void execute(IShape shape) {
		Point newOrigin = new Point(shape.getOrigin().getX() - (_startPoint.getX() - _endPoint.getX()), shape.getOrigin().getY() - (_startPoint.getY() - _endPoint.getY()));
		IShape newShape = shape.getClone(newOrigin);
		_shapeList.set(_shapeList.indexOf(shape), newShape);
	}

}
