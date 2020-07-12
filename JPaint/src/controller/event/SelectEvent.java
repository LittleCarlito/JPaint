package controller.event;

import java.awt.Rectangle;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class SelectEvent implements IMouseEvent{
	private PaintCanvasBase eventCanvas;
	private IShape eventShape;
	private List<IShape> shapeList;
	
	public SelectEvent (IShape nShape, PaintCanvasBase baseCanvas) {
		eventCanvas = baseCanvas;
		shapeList = eventCanvas.getShapes();
		eventShape = nShape;
	}
	
	@Override
	public void Execute() {
		eventCanvas.deSelect();
		Rectangle r1 = new Rectangle(eventShape.getOrigin().getX(), eventShape.getOrigin().getY(), eventShape.getWidth(), eventShape.getHeight());
		for(IShape shape : shapeList) {
			Rectangle r2 = new Rectangle(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
			if (r1.intersects(r2)) { 
				System.out.println("Collision Detected!");
				eventCanvas.select(shape);
				}
		}
	}

}
