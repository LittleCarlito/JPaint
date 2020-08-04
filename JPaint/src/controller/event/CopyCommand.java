package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IShape;

public class CopyCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	
	public CopyCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		shapeManager.clearClip();
		List<IShape> selectList = shapeManager.getSelect();
		List<IShape> clipList = shapeManager.getClip();
		ListOutput.execute(selectList, (IShape shape) -> {clipList.add(shape);});
	}

}
