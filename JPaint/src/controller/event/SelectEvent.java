package controller.event;

import controller.interfaces.IMouseEvent;
import controller.interfaces.IShapeCommand;
import controller.singletons.CollisionDetect;
import controller.singletons.ListOutput;
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
		IShapeCommand collisionCommand = new CollisionDetect(eventShape, shapeManager);
		ListOutput.execute(shapeManager.getShapes(), collisionCommand);
		shapeManager.cleanShapeList(shapeManager.getSelect());
		shapeManager.print();
	}

}
