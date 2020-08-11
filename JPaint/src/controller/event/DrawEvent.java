package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.interfaces.IShape;

public class DrawEvent implements IMouseEvent{
	private IShapeManager shapeManager;
	private IShape eventShape;
	
	public DrawEvent(IShape nShape, IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		eventShape = nShape;
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		shapeManager.add(eventShape);
		shapeManager.print();
	}

	@Override
	public void undo() {
		shapeManager.remove(eventShape);
		shapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}
}
