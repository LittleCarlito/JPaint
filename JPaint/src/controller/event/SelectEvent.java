package controller.event;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.interfaces.IShape;

public class SelectEvent implements IMouseEvent{
	private IShapeManager shapeManager;
	private IShape eventShape;
	
	public SelectEvent (IShape eventShape, IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		this.eventShape = eventShape;
	}
	
	@Override
	public void execute() {
		shapeManager.deSelect();
		shapeManager.selectWithin(eventShape);
		shapeManager.cleanShapeList(shapeManager.getSelect());
		shapeManager.print();
		shapeManager.soundOff();
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
