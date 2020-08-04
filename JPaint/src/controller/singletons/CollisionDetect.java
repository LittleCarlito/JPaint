package controller.singletons;

import java.awt.Rectangle;

import controller.interfaces.IShapeCommand;
import model.IShapeManager;
import model.interfaces.IShape;

public class CollisionDetect implements IShapeCommand {
	private Rectangle r1;
	private IShapeManager shapeManager;
	
	public CollisionDetect(IShape newShape, IShapeManager shapeManager) {
		if(newShape.getWidth() == 0 && newShape.getHeight() == 0) {
			r1 = new Rectangle(newShape.getOrigin().getX(), newShape.getOrigin().getY(), 2, 2);
		}
		else {
			r1 = new Rectangle(newShape.getOrigin().getX(), newShape.getOrigin().getY(), newShape.getWidth(), newShape.getHeight());
		}
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute(IShape shape) {
		Rectangle r2 = new Rectangle(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		if (r1.intersects(r2)) { 
			shapeManager.select(shape);
			}
	}

}
