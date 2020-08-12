package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.Point;
import workSpace.IDrawable;

public class PasteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	private Point pastePoint;
	private List<IDrawable> clipList;
	private List<IDrawable> newList;
	
	public PasteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		clipList = shapeManager.getClip();
		newList = new ArrayList<IDrawable>();
	}

	@Override
	public void execute() {
		run();
		CommandHistory.add(this);
	}
	
	private void run() {
		pastePoint = new Point (0, 0);
		IDrawable newObject;
		for(IDrawable drawObject : clipList) {
			newObject = drawObject.getClone();
			pastePoint = newObject.pasteOrigin(pastePoint);
			shapeManager.addGroup(newObject);
			newList.add(newObject);
		}
		shapeManager.print();
	}

	@Override
	public void undo() {
		shapeManager.cleanShapeList(newList);
		shapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}

}
