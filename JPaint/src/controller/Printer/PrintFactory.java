package controller.Printer;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import controller.interfaces.IPrinter;
import model.ShapeType;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class PrintFactory{
	private PaintCanvasBase paintCanvas;
	
	public PrintFactory(PaintCanvasBase baseCanvas) {
		paintCanvas = baseCanvas;
	}

	public void print() {
		System.out.println("Within PrintFactory\nCount of shapeList: " + paintCanvas.getShapes().size() + "\nCount of selectList: " + paintCanvas.getSelect().size() + "\n");
		Graphics2D graphics2d = paintCanvas.getGraphics2D();      
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
		screenOutput(paintCanvas.getShapes());
		screenOutput(paintCanvas.getSelect());
	}
	
	private void screenOutput(List<IShape> shapeList) {
		for (IShape shape : shapeList) {
			shape.print();
		}
	}
}
