package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IDrawable;

public class DeleteCommand implements IMouseEvent {
	private List<IDrawable> deleteList;
	
	public DeleteCommand() {
		deleteList = new ArrayList<IDrawable>();
		for(IDrawable drawObject : IShapeManager.getSelect()) {
			deleteList.add(drawObject);
		}
	}

	@Override
	public void execute() {
		IShapeManager.deleteCommand();
		IShapeManager.print();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
//		System.out.println("Delete list has " + deleteList.size() + " items");
		ListOutput.execute(deleteList, (IDrawable drawObject) -> {IShapeManager.addSelect(drawObject);});
		IShapeManager.print();
	}

	@Override
	public void redo() {
		IShapeManager.cleanShapeList(deleteList);
		IShapeManager.print();
	}

}