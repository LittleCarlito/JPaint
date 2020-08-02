package view.gui;

import view.interfaces.PaintCanvasBase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import controller.Printer.ListOutput;
import model.ShapeHandler;
//import javax.swing.JComponent;
import model.interfaces.IShape;

public class PaintCanvas extends PaintCanvasBase {
	private static final long serialVersionUID = 1509453058678547085L;
	private List<IShape> shapeList;
	private List<IShape> selectList;
	private List<IShape> clipList;
	private List<IShape> deleteList;
	
	public PaintCanvas() {
		shapeList = new ArrayList<IShape>();
		selectList = new ArrayList<IShape>();
		clipList = new ArrayList<IShape>();
		deleteList = new ArrayList<IShape>();
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public void select(IShape newShape) {
		if(!hasSelected(newShape))
		selectList.add(ShapeHandler.outlineWrap(newShape));
	}
	
	public List<IShape> getShapes() {
		return shapeList;
	}
	
	public List<IShape> getSelect() {
		return selectList;
	}
	
	public List<IShape> getClip(){
		return clipList;
	}
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
	
	public void cleanShapeList(List<IShape> removeList) {
		ListOutput.execute(removeList, (IShape shape) -> {if(hasSelected(shape)) {shapeList.remove(shape);}});
	}

	public void deSelect() {
		ListOutput.execute(selectList, (IShape shape) -> {shapeList.add(ShapeHandler.unwrap(shape));});
		selectList.clear();
	}
	
	public void clearClip() {
		clipList.clear();
	}
	
	public void clear() {
		Graphics2D graphics2d = this.getGraphics2D();      
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void deleteCommand() {
		ListOutput.execute(selectList,  (IShape shape) -> {deleteList.add(shape);});
		selectList.clear();
	}

	@Override
	public boolean hasSelected(IShape checkShape) {
		for(IShape shape : selectList) {
			if(shape.getID() == checkShape.getID())
				return true;
		}
		return false;
	}
	
}
