package controller.event;

import controller.interfaces.IMouseEvent;
import controller.singletons.CanvasClear;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IShape;

public class DeleteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	
	public DeleteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		shapeManager.deleteCommand();
		CanvasClear.clear();
		ListOutput.execute(shapeManager.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(shapeManager.getSelect(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(shapeManager.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}