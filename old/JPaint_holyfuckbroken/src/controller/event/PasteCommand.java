package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
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
		List<IShape> pasteList = new ArrayList<IShape>();
		IShape tempShape;
		int clipLen = clipList.size();
		for (int i = 0; i < clipLen; i++) {
			tempShape = clipList.get(i);
			tempShape = tempShape.getClone(tempShape.getColor(), tempShape.getShade(), pastePoint, tempShape.getWidth(), tempShape.getHeight());
			tempShape = ShapeHandler.getCopy(tempShape);
			tempShape.setPrinter(ShapeHandler.getPrinter(tempShape.getType(), paintCanvas));
			paintCanvas.add(tempShape);
			pasteList.add(tempShape);
			pastePoint = new Point((pastePoint.getX() + tempShape.getWidth()) + 20, pastePoint.getY());
		}
		paintCanvas.clear();
		ListOutput.execute(paintCanvas.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.print();}));
//		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
