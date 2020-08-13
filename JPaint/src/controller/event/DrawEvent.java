package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.interfaces.IDrawable;

public class DrawEvent implements IMouseEvent{
	private IDrawable eventShape;
	
	public DrawEvent(IDrawable nShape) {
		eventShape = nShape;
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		IShapeManager.addGroup(eventShape);
		IShapeManager.print();
	}

	@Override
	public void undo() {
		IShapeManager.removeGroup(eventShape);
		IShapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}
}
