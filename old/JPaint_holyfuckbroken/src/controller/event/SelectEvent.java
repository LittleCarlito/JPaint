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
		//Clear the currently selected shapes
		eventCanvas.deSelect();
		//Detect if the area selected by the mouse intersects any shapes and put those that are in selected list
		IShapeCommand collisionCommand = new CollisionDetect(eventShape, eventCanvas);
		ListOutput.execute(eventCanvas.getShapes(), collisionCommand);
		//Take selected shapes out of the shape list
		eventCanvas.cleanShapeList(eventCanvas.getSelect());
		//Clear currently printed shapes
		System.out.println("Select list has this many objects: " + eventCanvas.getSelect().size());
		ListOutput.execute(eventCanvas.getSelect(), (IShape shape) -> {shape.getID();});

		eventCanvas.clear();
		//Print shape and selected lists to canvas
		ListOutput.execute(eventCanvas.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(eventCanvas.getSelect(), ((IShape shape) -> {shape.print();}));
//		ListOutput.execute(eventCanvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
