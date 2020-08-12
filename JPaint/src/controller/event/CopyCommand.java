package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.IShapeManager;
import workSpace.IDrawable;

public class CopyCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	
	public CopyCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
	}

	@Override
	public void execute() {
		shapeManager.clearClip();
		List<IDrawable> selectList = shapeManager.getSelect();
		List<IDrawable> clipList = shapeManager.getClip();
		ListOutput.execute(selectList, (IDrawable shape) -> {clipList.add(shape);});
		shapeManager.soundOff();
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
