package view.gui;

import view.interfaces.PaintCanvasBase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import controller.Printer.OutputFactory;
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
	
	public void cleanShapeList(List<IShape> removeList) {
		OutputFactory.execute(removeList, (IShape shape) -> {if(shapeList.contains(shape)) {shapeList.remove(shape);}});
	}

	public void deSelect() {
		OutputFactory.execute(selectList, (IShape shape) -> {shapeList.add(shape);});
		selectList.clear();
	}
	
	public void clear() {
		Graphics2D graphics2d = this.getGraphics2D();      
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
