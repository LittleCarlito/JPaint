package view.gui;

import view.interfaces.PaintCanvasBase;

import java.awt.Graphics2D;

//import javax.swing.JComponent;

import model.ShapeList;
import model.interfaces.IShape;

public class PaintCanvas extends PaintCanvasBase {
	private static final long serialVersionUID = 1509453058678547085L;
	private ShapeList<IShape> shapeList;
	
	public PaintCanvas(ShapeList<IShape> baseList) {
		shapeList = baseList;
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public ShapeList<IShape> getShapes() {
		return shapeList;
	}
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
