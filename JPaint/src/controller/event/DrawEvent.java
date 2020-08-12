package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import workSpace.IDrawable;

public class DrawEvent implements IMouseEvent{
	private IShapeManager shapeManager;
	private IDrawable eventShape;
	
	public DrawEvent(IDrawable nShape, IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		eventShape = nShape;
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		shapeManager.addGroup(eventShape);
		shapeManager.print();
	}

	@Override
	public void undo() {
		shapeManager.removeGroup(eventShape);
		shapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}
}
