package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.Point;
import model.interfaces.IDrawable;

public class PasteCommand implements IMouseEvent {

	private Point pastePoint;
	private List<IDrawable> clipList;
	private List<IDrawable> newList;
	
	public PasteCommand() {
		clipList = IShapeManager.getClip();
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
//			newObject.soundOff();
			IShapeManager.addGroup(newObject);
			newList.add(newObject);
		}
		IShapeManager.print();
	}

	@Override
	public void undo() {
		IShapeManager.cleanShapeList(newList);
		IShapeManager.print();
	}

	@Override
	public void redo() {
		run();
	}

}
