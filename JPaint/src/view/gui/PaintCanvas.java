package view.gui;

import view.interfaces.PaintCanvasBase;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.JComponent;
import model.interfaces.IShape;

public class PaintCanvas extends PaintCanvasBase {
	private static final long serialVersionUID = 1509453058678547085L;
	private List<IShape> shapeList;
	private List<IShape> selectList;
	
	public PaintCanvas(ArrayList<IShape> baseList, List<IShape> baseSelectList) {
		shapeList = baseList;
		selectList = baseSelectList;
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public void select(IShape newShape) {
		selectList.add(newShape);
	}
	
	public List<IShape> getShapes() {
		return shapeList;
	}
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

	public List<IShape> getSelect() {
		return selectList;
	}
}
