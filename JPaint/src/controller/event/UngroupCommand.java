package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.event.handlers.CommandHistory;
import controller.interfaces.IMouseEvent;
import model.handlers.IShapeManager;
import model.interfaces.IDrawable;

public class UngroupCommand implements IMouseEvent {
	private List<IDrawable> groupList = new ArrayList<IDrawable>();
	private List<IDrawable> copyList = new ArrayList<IDrawable>();
	
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
		for(IDrawable drawObject : groupList) {
			copyList.add(drawObject);
		}
		IShapeManager.deSelect();
		for(IDrawable drawObject : groupList) {
			drawObject.ungroup();
		}
		IShapeManager.print();
		IShapeManager.soundOff();
	}

	@Override
	public void undo() {
		IShapeManager.cleanShapeList(groupList);
		for(IDrawable drawObject : copyList) {
			IShapeManager.addGroup(drawObject);
		}
		IShapeManager.print();
		IShapeManager.soundOff();
	}

	@Override
	public void redo() {
		groupList.clear();
		for(IDrawable drawObject : copyList) {
			groupList.add(drawObject);
		}
		run();
	}

}
