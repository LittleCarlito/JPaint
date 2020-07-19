package controller.event;

import controller.Printer.PrintFactory;
import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class DrawEvent implements IMouseEvent{
	private PaintCanvasBase eventCanvas;
	private IShape eventShape;
	
	public DrawEvent(IShape nShape, PaintCanvasBase baseCanvas) {
		eventCanvas = baseCanvas;
		eventShape = nShape;
	}

	public void Execute() {
		eventCanvas.add(eventShape);
		PrintFactory.print(eventCanvas);
	}
}
