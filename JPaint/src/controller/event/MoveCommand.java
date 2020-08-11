package controller.event;

import java.util.List;

import controller.interfaces.IShapeCommand;
import model.Point;
import model.interfaces.IShape;

public class MoveCommand implements IShapeCommand {
	private List<IShape> shapeList;
	private Point startPoint;
	private Point endPoint;
	
	public MoveCommand(List<IShape> shapeList, Point startPoint, Point endPoint) {
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public void execute(IShape shape) {
		Point newOrigin = new Point(shape.getOrigin().getX() - (startPoint.getX() - endPoint.getX()), shape.getOrigin().getY() - (startPoint.getY() - endPoint.getY()));
		IShape newShape = shape.getCloneAt(newOrigin);
		newShape.setSelect();
		shapeList.set(shapeList.indexOf(shape), newShape);
	}

}
