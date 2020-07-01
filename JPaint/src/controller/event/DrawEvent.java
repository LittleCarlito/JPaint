package controller.event;

import controller.ShapePrinter;
import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class DrawEvent implements IMouseEvent{
	private PaintCanvasBase eventCanvas;
	private ShapePrinter eventPrinter;
	private IShape eventShape;
	
	public DrawEvent(IShape nShape, PaintCanvasBase baseCanvas) {
		eventCanvas = baseCanvas;
		eventShape = nShape;
	}

	public void Execute() {
		eventCanvas.add(eventShape);
		eventPrinter = new ShapePrinter(eventCanvas);
		eventPrinter.print();
	}
}
