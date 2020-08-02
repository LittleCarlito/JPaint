package controller.interfaces;

import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public interface IPrinter {
	public void print(IShape shape);
	
	public PaintCanvasBase getCanvas();
}
