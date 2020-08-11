package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import model.IShapeManager;
import model.Point;
import model.ShapeHandler;
import model.interfaces.IShape;

public class PasteCommand implements IMouseEvent {
	
	private IShapeManager shapeManager;
	private Point pastePoint;
	
	public PasteCommand(IShapeManager shapeManager) {
		this.shapeManager = shapeManager;
		pastePoint = new Point (0, 0);
	}

	@Override
	public void execute() {
		List<IShape> clipList = shapeManager.getClip();
		IShape tempShape;
		int clipLen = clipList.size();
		for (int i = 0; i < clipLen; i++) {
			tempShape = clipList.get(i);
			tempShape = ShapeHandler.getShape(tempShape.getType(), tempShape.getColor(), tempShape.getSecondColor(), tempShape.getShade(), pastePoint, new int[] {tempShape.getWidth(), tempShape.getHeight()}, shapeManager.getCanvas());
			shapeManager.add(tempShape);
			pastePoint = new Point((pastePoint.getX() + tempShape.getWidth()) + 20, pastePoint.getY());
		}
		shapeManager.print();
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
