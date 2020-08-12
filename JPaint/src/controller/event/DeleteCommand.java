package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import workSpace.IDrawable;

public class DeleteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	private List<IDrawable> deleteList;
	
	public DeleteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		deleteList = new ArrayList<IDrawable>();
		for(IDrawable drawObject : shapeManager.getSelect()) {
			deleteList.add(drawObject);
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
		ListOutput.execute(deleteList, (IDrawable drawObject) -> {shapeManager.addSelect(drawObject);});
		shapeManager.print();
	}

	@Override
	public void redo() {
		shapeManager.cleanShapeList(deleteList);
		shapeManager.print();
	}

}