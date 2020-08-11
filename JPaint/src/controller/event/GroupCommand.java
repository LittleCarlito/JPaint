package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IShape;

public class GroupCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	
	public GroupCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		List<IShape> selectList = shapeManager.getSelect();
		int selectSize = selectList.size();
		IShape leadShape;
		if(selectSize > 1) {
			leadShape = selectList.get(0);
			selectList.remove(0);
			ListOutput.execute(selectList, (IShape shape) -> {leadShape.group(shape);});
			selectList.clear();
			selectList.add(leadShape);
		}

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
