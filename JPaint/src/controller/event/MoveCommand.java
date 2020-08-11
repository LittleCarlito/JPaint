package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import model.Point;
import model.interfaces.IShape;

public class MoveCommand implements IMouseEvent {
	private List<IShape> shapeList;
	private Point startPoint;
	private Point endPoint;
	
	public MoveCommand(List<IShape> shapeList, Point startPoint, Point endPoint) {
		this.shapeList = shapeList;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	@Override
	public void execute() {
		for (IShape shape : shapeList) {
			Point newOrigin = new Point(shape.getOrigin().getX() - (startPoint.getX() - endPoint.getX()),shape.getOrigin().getY() - (startPoint.getY() - endPoint.getY()));
			IShape newShape = shape.getCloneAt(newOrigin);
			newShape.setSelect();
			shapeList.set(shapeList.indexOf(shape), newShape);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
}
