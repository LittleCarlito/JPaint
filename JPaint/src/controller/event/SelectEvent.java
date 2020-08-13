package controller.event;

import controller.interfaces.IMouseEvent;
import model.handlers.IShapeManager;
import model.interfaces.IShape;

public class SelectEvent implements IMouseEvent{
	private IShape eventShape;
	
	public SelectEvent (IShape eventShape) {
		this.eventShape = eventShape;
	}
	
	@Override
	public void execute() {
		IShapeManager.deSelect();
		IShapeManager.selectWithin(eventShape);
		IShapeManager.cleanShapeList(IShapeManager.getSelect());
		IShapeManager.print();
		IShapeManager.soundOff();
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
