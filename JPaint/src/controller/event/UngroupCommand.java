package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import workSpace.IDrawable;

public class UngroupCommand implements IMouseEvent {
	private List<IDrawable> groupList = new ArrayList<IDrawable>();
	
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
		IShapeManager.deSelect();
		for(IDrawable drawObject : groupList) {
			drawObject.ungroup();
		}
		IShapeManager.print();
		IShapeManager.soundOff();
	}

	@Override
	public void undo() {
//		for(IDrawable drawObject : groupList) {
//			IShapeManager.select
//		}
	}

	@Override
	public void redo() {
		run();
	}

}
