package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IShape;

public class DeleteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	private List<IShape> deleteList;
	
	public DeleteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		deleteList = new ArrayList<IShape>();
		for(IShape shape : shapeManager.getSelect()) {
			deleteList.add(shape);
		}
	}

	@Override
	public void execute() {
		shapeManager.deleteCommand();
		shapeManager.print();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
//		System.out.println("Delete list has " + deleteList.size() + " items");
		ListOutput.execute(deleteList, (IShape shape) -> {shapeManager.add(shape);});
		shapeManager.print();
	}

	@Override
	public void redo() {
		shapeManager.cleanShapeList(deleteList);
		shapeManager.print();
	}

}