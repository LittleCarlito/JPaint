package controller.event;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
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
	public void execute() {
		eventCanvas.deSelect();
		IShapeCommand collisionCommand = new CollisionDetect(eventShape, eventCanvas);
		ListOutput.execute(eventCanvas.getShapes(), collisionCommand);
		eventCanvas.cleanShapeList(eventCanvas.getSelect());
	}

}
