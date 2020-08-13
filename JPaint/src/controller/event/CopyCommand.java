package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import model.interfaces.IDrawable;

public class CopyCommand implements IMouseEvent {
	
	public CopyCommand() {
	}

	@Override
	public void execute() {
		IShapeManager.clearClip();
		List<IDrawable> selectList = IShapeManager.getSelect();
		List<IDrawable> clipList = IShapeManager.getClip();
		ListOutput.execute(selectList, (IDrawable shape) -> {clipList.add(shape);});
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
