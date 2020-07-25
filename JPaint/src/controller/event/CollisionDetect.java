package controller.event;

import java.awt.Rectangle;

import controller.interfaces.IShapeCommand;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class CollisionDetect implements IShapeCommand {
	private Rectangle r1;
	private PaintCanvasBase canvas;
	
	public CollisionDetect(IShape newShape, PaintCanvasBase newCanvas) {
		r1 = new Rectangle(newShape.getOrigin().getX(), newShape.getOrigin().getY(), newShape.getWidth(), newShape.getHeight());
		canvas = newCanvas;
	}

	@Override
	public void execute(IShape shape) {
		Rectangle r2 = new Rectangle(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
		if (r1.intersects(r2)) { 
			canvas.select(shape);
			}
	}

}
