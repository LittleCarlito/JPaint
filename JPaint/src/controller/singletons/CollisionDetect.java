package controller.singletons;

import java.awt.Rectangle;
import java.util.List;

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

	// Add a shape group size check for each shape in the for shape : groupList loop
		// if the size is 0 in the shapes group list than run collision
		// otherwise feed the shape into execute(IShape inShape) so its list gets collision detected
	@Override
	public void execute(IShape inShape) {
		Rectangle r2 = new Rectangle(inShape.getOrigin().getX(), inShape.getOrigin().getY(), inShape.getWidth(), inShape.getHeight());
		if (r1.intersects(r2)) {
			shapeManager.select(inShape);
			return;
		}
		List<IShape> groupList = inShape.getGroup();
		for (IShape shape : groupList) {
			Rectangle r3 = new Rectangle(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
			if (r1.intersects(r3)) {
				shapeManager.select(inShape);
				return;
			}
		}
	}
}
