package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.singletons.CanvasClear;
import controller.singletons.ListOutput;
import model.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class IShapeManager {
	private List<IShape> shapeList;
	private List<IShape> selectList;
	private List<IShape> clipList;
	private Stack<IShape> deleteList;
	private PaintCanvasBase canvas;
	
	public IShapeManager(PaintCanvasBase canvas) {
		this.canvas = canvas;
		shapeList = new ArrayList<IShape>();
		selectList = new ArrayList<IShape>();
		clipList = new ArrayList<IShape>();
		deleteList = new Stack<IShape>();
	}
	
	public void remove(IShape shape) {
		boolean shapeListCheck = shapeList.contains(shape);
		boolean selectListCheck = selectList.contains(shape);
//		int shapeIndex = shapeList.indexOf(shape);
//		int selectIndex = selectList.indexOf(shape);
//		System.out.println("\nShape to undo was in shapeList: " + shapeListCheck + "\nIts index is: " + shapeIndex);
//		System.out.println("Shape to undo was in shapeList: " + selectListCheck + "\nIts index is: " + selectIndex);
		if(shapeListCheck) {
			shapeList.remove(shapeList.indexOf(shape));
		}
		else if(selectListCheck) {
			selectList.remove(selectList.indexOf(shape));
		}
	}
	
	public PaintCanvasBase getCanvas() {
		return canvas;
	}
	
	public void add(IShape newShape) {
		shapeList.add(newShape);
	}
	
	public void select(IShape newShape) {
		newShape.setSelect();
		ListOutput.execute(newShape.getGroup(), (IShape shape) -> {shape.setSelect();});
//		newShape.setSelect();
		selectList.add(newShape);
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
	
	public void cleanShapeList(List<IShape> removeList) {
		ListOutput.execute(removeList, (IShape shape) -> {if(shapeList.contains(shape)) {shapeList.remove(shape);}});
	}

	public void deSelect() {
		ListOutput.execute(selectList, (IShape shape) -> {shape.setNoSelect();});
		ListOutput.execute(selectList, (IShape shape) -> {shapeList.add(shape);});
		selectList.clear();
	}
	
	public void clearClip() {
		clipList.clear();
	}
	
	public void deleteCommand() {
		ListOutput.execute(selectList, (IShape shape) -> {deleteList.push(shape);});
		selectList.clear();
	}
	
	public void print() {
		CanvasClear.clear();
		ListOutput.execute(shapeList, ((IShape shape) -> {shape.groupPrint();}));
		ListOutput.execute(selectList, ((IShape shape) -> {shape.groupPrint();}));
//		ListOutput.execute(shapeList, ((IShape shape) -> {System.out.println("ShapeList ID: " + shape.getID());}));
//		ListOutput.execute(selectList, ((IShape shape) -> {System.out.println("SelectList ID: " + shape.getID());}));

	}
}
