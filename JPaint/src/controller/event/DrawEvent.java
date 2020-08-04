package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IShape;

public class DrawEvent implements IMouseEvent{
	private IShapeManager shapeManager;
	private IShape eventShape;
	
	public DrawEvent(IShape nShape, IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		eventShape = nShape;
	}

	public void execute() {
		shapeManager.add(eventShape);
		List<IShape> shapeList = new ArrayList<IShape>();
		shapeList.add(eventShape);
		ListOutput.execute(shapeList, ((IShape shape) -> {shape.print();}));
	}
}
