package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.interfaces.IDrawable;

public class GroupCommand implements IMouseEvent {
	
	private List<IDrawable> listToGroup = new ArrayList<IDrawable>();
	private IDrawable leadGroup;
	
	public GroupCommand() {
		for(IDrawable drawObject : IShapeManager.getSelect()) {
			listToGroup.add(drawObject);
		}
		
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		int groupSize = listToGroup.size();
		if(groupSize > 0) {
			leadGroup = listToGroup.get(0);
			listToGroup.remove(0);
			for(IDrawable drawObject : listToGroup) {
				leadGroup.add(drawObject);
			}
			IShapeManager.clearSelect();
			IShapeManager.addSelect(leadGroup);
		}
		IShapeManager.soundOff();
	}

	@Override
	public void undo() {
		leadGroup.ungroup();
		IShapeManager.print();
		IShapeManager.soundOff();
	}

	@Override
	public void redo() {
		listToGroup.add(leadGroup);
		run();		
	}

}
