package controller.event;

import java.awt.Rectangle;
import java.util.List;

import controller.Printer.PrintFactory;
import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class SelectEvent implements IMouseEvent{
	private PaintCanvasBase eventCanvas;
	private IShape eventShape;
	
	public SelectEvent (IShape nShape, PaintCanvasBase baseCanvas) {
		eventCanvas = baseCanvas;
		eventShape = nShape;
	}
	
	@Override
	public void Execute() {
		//eventCanvas.deSelect();
		eventCanvas.deSelect();
		List<IShape> shapeList = eventCanvas.getShapes();
		Rectangle r1 = new Rectangle(eventShape.getOrigin().getX(), eventShape.getOrigin().getY(), eventShape.getWidth(), eventShape.getHeight());
		for(IShape shape : shapeList) {
			Rectangle r2 = new Rectangle(shape.getOrigin().getX(), shape.getOrigin().getY(), shape.getWidth(), shape.getHeight());
			if (r1.intersects(r2)) { 
				System.out.println("Collision Detected!");
				eventCanvas.select(shape);
				}
		}
		eventCanvas.cleanShapeList(eventCanvas.getSelect());
		PrintFactory.getInstance();
		PrintFactory.print(eventCanvas);
	}

}
