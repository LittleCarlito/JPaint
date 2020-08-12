package controller.singletons;

import java.awt.Rectangle;

import model.interfaces.IShape;

public class CollisionDetect{
	
	public CollisionDetect() {}
	
	public static boolean collides(IShape newShape, IShape checkShape) {
		Rectangle r1;
		if(newShape.getWidth() == 0 && newShape.getHeight() == 0) {
			r1 = new Rectangle(newShape.getOrigin().getX(), newShape.getOrigin().getY(), 2, 2);
		}
		else {
			r1 = new Rectangle(newShape.getOrigin().getX(), newShape.getOrigin().getY(), newShape.getWidth(), newShape.getHeight());
		}
		Rectangle r2 = new Rectangle(checkShape.getOrigin().getX(), checkShape.getOrigin().getY(), checkShape.getWidth(), checkShape.getHeight());
		if (r1.intersects(r2)) {
			return true;
		}
		return false;
	}
}
