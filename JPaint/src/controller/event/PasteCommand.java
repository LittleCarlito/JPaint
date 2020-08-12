//package controller.event;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import controller.interfaces.IMouseEvent;
//import model.IShapeManager;
//import model.Point;
//import model.ShapeHandler;
//import model.interfaces.IShape;
//
//public class PasteCommand implements IMouseEvent {
//	
//	private IShapeManager shapeManager;
//	private Point pastePoint;
//	private List<IShape> clipList;
//	private List<IShape> newList;
//	
//	public PasteCommand(IShapeManager shapeManager) {
//		this.shapeManager = shapeManager;
//		clipList = shapeManager.getClip();
//		pastePoint = new Point (0, 0);
//		newList = new ArrayList<IShape>();
//	}
//
//	@Override
//	public void execute() {
//		run();
//		CommandHistory.add(this);
//	}
//	
//	private void run() {
//		IShape tempShape;
//		int clipLen = clipList.size();
//		for (int i = 0; i < clipLen; i++) {
//			tempShape = clipList.get(i);
//			tempShape = ShapeHandler.getShape(tempShape.getType(), tempShape.getColor(), tempShape.getSecondColor(), tempShape.getShade(), pastePoint, new int[] {tempShape.getWidth(), tempShape.getHeight()}, shapeManager.getCanvas());
//			shapeManager.add(tempShape);
//			newList.add(tempShape);
//			pastePoint = new Point((pastePoint.getX() + tempShape.getWidth()) + 20, pastePoint.getY());
//		}
//		shapeManager.print();
//	}
//
//	@Override
//	public void undo() {
//		shapeManager.cleanShapeList(newList);
//		shapeManager.print();
//	}
//
//	@Override
//	public void redo() {
//		run();
//	}
//
//}
