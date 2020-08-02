package controller.event;

import java.util.List;

import controller.interfaces.IMouseEvent;
import controller.singletons.ListOutput;
import model.Point;
import model.ShapeHandler;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class PasteCommand implements IMouseEvent {
	
	private PaintCanvasBase paintCanvas;
	private Point pastePoint;
	
	public PasteCommand(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
		pastePoint = new Point (0, 0);
	}

	@Override
	public void execute() {
		List<IShape> clipList = paintCanvas.getClip();
		IShape tempShape;
		int clipLen = clipList.size();
		for (int i = 0; i < clipLen; i++) {
			tempShape = clipList.get(i);
			tempShape = ShapeHandler.getShape(tempShape.getType(), tempShape.getColor(), tempShape.getSecondColor(), tempShape.getShade(), pastePoint, new int[] {tempShape.getWidth(), tempShape.getHeight()}, paintCanvas);
			paintCanvas.add(tempShape);
			pastePoint = new Point((pastePoint.getX() + tempShape.getWidth()) + 20, pastePoint.getY());
		}
		paintCanvas.clear();
		ListOutput.execute(paintCanvas.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
