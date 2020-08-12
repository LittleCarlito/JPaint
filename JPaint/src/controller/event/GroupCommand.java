package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import workSpace.IDrawable;

public class GroupCommand implements IMouseEvent {
	
	private List<IDrawable> groupList = new ArrayList<IDrawable>();
	
	public GroupCommand() {
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
		int groupSize = groupList.size();
		if(groupSize > 0) {
			IDrawable leadGroup = groupList.get(0);
			groupList.remove(0);
			for(IDrawable drawObject : groupList) {
				leadGroup.add(drawObject);
			}
			IShapeManager.clearSelect();
			IShapeManager.addSelect(leadGroup);
		}
		IShapeManager.soundOff();
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
