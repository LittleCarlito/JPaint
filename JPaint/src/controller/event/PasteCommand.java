package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
import model.ShapeHandler;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class PasteCommand implements IMouseEvent {
	
	private PaintCanvasBase paintCanvas;
	
	public PasteCommand(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void execute() {
		List<IShape> clipList = paintCanvas.getClip();
		List<IShape> pasteList = new ArrayList<IShape>();
		IShape tempShape;
		for(IShape shape : clipList) {
			tempShape = ShapeHandler.getCopy(shape);
			pasteList.add(tempShape);
		}

		//get clones of all clip board shapes
		//use move event to iterate through the list and move the origin so they don't all paste on each other
//		ListOutput.execute(canvas.getShapes(), ((IShape shape) -> {shape.print();}));
//		ListOutput.execute(canvas.getSelect(), ((IShape shape) -> {shape.print();}));
//		ListOutput.execute(canvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}
