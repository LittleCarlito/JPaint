package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;

public class DeleteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	
	public DeleteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		shapeManager.deleteCommand();
		shapeManager.print();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}