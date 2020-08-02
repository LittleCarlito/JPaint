package controller.event;

import controller.Printer.ListOutput;
import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class DeleteCommand implements IMouseEvent {
	
	private PaintCanvasBase paintCanvas;
	
	public DeleteCommand(PaintCanvasBase paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void execute() {
		paintCanvas.deleteCommand();
		paintCanvas.clear();
		ListOutput.execute(paintCanvas.getShapes(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.print();}));
		ListOutput.execute(paintCanvas.getSelect(), ((IShape shape) -> {shape.outline();}));
	}

}