package controller.event;

import java.util.ArrayList;
import java.util.List;

import controller.Printer.OutputFactory;
import controller.interfaces.IMouseEvent;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class DrawEvent implements IMouseEvent{
	private PaintCanvasBase canvas;
	private IShape eventShape;
	
	public DrawEvent(IShape nShape, PaintCanvasBase baseCanvas) {
		canvas = baseCanvas;
		eventShape = nShape;
	}

	public void Execute() {
		canvas.add(eventShape);
		List<IShape> shapeList = new ArrayList<IShape>();
		shapeList.add(eventShape);
		OutputFactory.execute(shapeList, ((IShape shape) -> {shape.print();}));
	}
}
