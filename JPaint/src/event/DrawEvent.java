package event;

import controller.ShapePrinter;
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

	@Override
	public void Execute() {
		eventPrinter = new ShapePrinter(eventCanvas);
		eventPrinter.print(eventShape);
	}
}
