package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import workSpace.IDrawable;

public class UngroupCommand implements IMouseEvent {
	private List<IDrawable> groupList;
	
	public UngroupCommand() {
		for(IDrawable drawObject : IShapeManager.getSelect()) {
			groupList.add(drawObject);
		}
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
//		IShapeManager.unGroup(groupList);
		for(IDrawable drawObject : groupList) {
			// Make ungroup a thing on IShapes and ShapeGroups
				// boolean method
				// returns false for shapes and true for ShapeGroups once they are down to one shape
				// or consider making ShapeGroups have a base IShape then you can just have every group dump its contents in ShapeList effectively seperating all of them
			drawObject.unGroup();
		}
		IShapeManager.print();
		IShapeManager.soundOff();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		run();
	}

}
